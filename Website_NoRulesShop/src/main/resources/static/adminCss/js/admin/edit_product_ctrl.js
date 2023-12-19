app.service("sharing_product_data", function () {
    let product_id = null;
    return {
        getProductId: function () {
            return product_id;
        }, setProductId: function (productId) {
            product_id = productId;
        }
    };
})

app.controller("edit_product_ctrl", function ($scope, $http, sharing_product_data, $location) {
    $scope.initialize = function () {
        let productId = sharing_product_data.getProductId();
        if(!productId){
            // $location.path("/product_all");
        }else{

        }
        getDirectoryLv1();
        getBrands();
        getProductInformation(1); // Gọi hàm để lấy thông tin sản phẩm
    };

    function getBrands() {
        $http.get("/rest/manage_brand").then(resp => {
            $scope.brands = resp.data
        })
    }
    function getDirectoryLv1() {
        $http.get("/rest/manage_directoryLv1").then(resp => {
            $scope.directoryLv1s = resp.data
        })
    }

    function getProductInformation(productId) {
        $http.get(`/rest/products/${productId}`)
            .then(function (response) {
                $scope.product = response.data; // Lưu dữ liệu vào $scope.product để hiển thị trong DOM
                console.log($scope.product);
            })
            .catch(function (error) {
                // Xử lý lỗi ở đây
                Swal.fire({
                    icon: 'error',
                    title: 'Lỗi!',
                    text: 'Không thể lấy thông tin. Vui lòng thử lại sau.',
                });
                console.log(error);
            });
    }

    $scope.initialize(); // Gọi hàm initialize để bắt đầu quá trình edit

    $scope.submit = function () {
        // updateProduct();
        testingUpdateProduct();
    }
    function testingUpdateProduct() {
        $http({
            method: 'PUT',
            url: `/rest/product_all/updateProduct`,
            data: $scope.product, // Dữ liệu JSON
            headers: {
                'Content-Type': 'application/json' // Xác định loại dữ liệu là JSON
            }
        }).then(function successCallback(response) {
            // Xử lý kết quả thành công
            Swal.fire({
                icon: 'success',
                title: 'Thành Công',
                text: 'Đã Cập Nhật Sản Phẩm Thành Công',
                confirmButtonText: "OK"
            });
        }, function errorCallback(error) {
            // Xử lý lỗi
            Swal.fire({
                icon: 'error',
                title: 'Lỗi!',
                text: `error: ${error}`,
            });
            console.log(error);
        });
    }

});
