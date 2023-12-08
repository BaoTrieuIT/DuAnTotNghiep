const app = angular.module("app", []);

app.run(function ($http, $rootScope) {
    $http.get(`/rest/login/authentication`).then(resp => {
        if (resp.data) {
            console.log(resp.data);
            $auth = $rootScope.$auth = resp.data;
            $http.defaults.headers.common["Authorization"] = $auth.token;
        }
    });
})
app.filter('vndFormat', function () {
    return function (input) {
        return new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(input);
    };
});

