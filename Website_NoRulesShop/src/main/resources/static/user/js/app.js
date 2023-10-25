const app = angular.module("app", []);

app.run(function ($http, $rootScope) {
    $http.get(`/rest/login/authentication`).then(resp => {
        if (resp.data) {
            $auth = $rootScope.$auth = resp.data;
            $http.defaults.headers.common["Authorization"] = $auth.token;
        }
    });
})
