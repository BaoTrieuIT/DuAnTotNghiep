app = angular.module("app", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when("/manage_account", {
            templateUrl: "/admin/manage_account.html",
            controller: "account_ctrl"
        })
        .when("/account_add", {
            templateUrl: "/admin/account_add.html",
            controller: "account_ctrl"
        })
        .when("/manage_brand", {
            templateUrl: "/admin/manage_brand.html",
            controller: "brand_ctrl"
        })
        .when("/manage_directory", {
            templateUrl: "/admin/manage_directory.html",
            controller: "directory_ctrl"
        })
        .when("/manage_shipping", {
            templateUrl: "/admin/manage_shipping.html",
            controller: "shipping_ctrl"
        })
        .when("/setting_shipping", {
            templateUrl: "/admin/setting_shipping.html",
            controller: "shipping_ctrl"
        })
        .when("/order_all", {
            templateUrl: "/admin/order_all.html",
            controller: "order_ctrl"
        })
        .when("/order_cancel", {
            templateUrl: "/admin/order_cancel.html",
            controller: "order_ctrl"
        })
        .when("/order_back", {
            templateUrl: "/admin/order_back.html",
            controller: "order_ctrl"
        })
        .when("/product_all", {
            templateUrl: "/admin/product_all.html",
            controller: "product_ctrl"
        })
        .when("/product_add", {
            templateUrl: "/admin/product_add.html",
            controller: "product_ctrl"
        })
        .when("/product_report", {
            templateUrl: "/admin/product_report.html",
            controller: "product_ctrl"
        })
        .when("/overview", {
            templateUrl: "/admin/overview.html",
            controller: "overview_ctrl"
        })
        .when("/manager_voucher", {
            templateUrl: "/admin/manager_voucher.html",
            controller: "manager_voucher_ctrl"
        })
})