app = angular.module("app", ["ngRoute"]);

app.config(function ($routeProvider) {

    $routeProvider
        .when("/manage_account", {
            templateUrl: "/admin/manage_account.html",
            controller: "account_ctrl"
        })
        .when("/account_add", {
            templateUrl: "/admin/account_add.html",
            controller: "AddAccountController"
        })
        .when("/manage_brand", {
            templateUrl: "/admin/manage_brand.html",
            controller: "brand_ctrl"
        })
        .when("/manage_directory", {
            templateUrl: "/admin/manage_directory.html",
            controller: "directoryLv1_ctrl",
            controller: "directory_ctrl"
        })
        .when("/order_all", {
            templateUrl: "/admin/order_all.html",
            controller: "order_ctrl"
        })
        .when("/product_all", {
            templateUrl: "/admin/product_all.html",
            controller: "manage_product_ctrl"
        })
        .when("/product_add", {
            templateUrl: "/admin/product_add.html",
            controller: "product_ctrl"
        })
        .when("/product_report", {
            templateUrl: "/admin/product_report.html",
            controller: "product_ctrl"
        })
        .when("/discount", {
            templateUrl: "/admin/discount.html",
            controller: "discount_ctrl"
        })
        .when("/orderDetail", {
            templateUrl: "/admin/orderDetail.html",
            controller: "order_detail_ctrl"
        })
        .otherwise({
            templateUrl: "/admin/index.html",
            controller: "dashboard_ctrl"
        });
})