app.service("sharing_product_data", function () {
    let product_id = null;
    return {
        getProductId: function () {
            return product_id;
        }, setProductId: function (productId) {
            product_id =  productId;
        }
    };
})


app.controller("manage_product_ctrl", function ($scope, $http, sharing_product_data, $location) {
    $scope.initialize =  function () {
        let productId = sharing_product_data.getProductId()
        console.log(productId);
    }
});
