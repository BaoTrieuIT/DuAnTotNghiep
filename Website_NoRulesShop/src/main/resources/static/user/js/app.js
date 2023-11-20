const app = angular.module("app", []);

// app.run(function ($http, $rootScope) {
//     $http.get(`/rest/login/authentication`).then(resp => {
//         if (resp.data) {
//             $auth = $rootScope.$auth = resp.data;
//             $http.defaults.headers.common["Authorization"] = $auth.token;
//         }
//     });
// })
app.filter('vndFormat', function () {
    return function (input) {
        // Assuming 'input' is the price in the default format
        // You may need to handle different formats based on your application

        // Format the price to VND
        var formattedPrice = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(input);

        return formattedPrice;
    };
});