app.controller("manage_product_ctrl", function ($scope, $http
                                                // , sharing_product_data, $location
) {
    $scope.initialize = function () {
        $scope.renderProductIsActive();
    }
    $scope.search_product_name = "";
    $scope.minValue = 0;
    $scope.maxValue = 10000000;
    $scope.backupItem = [];

    $scope.renderProductIsHidden = function () {
        $scope.items = [];
        $http.get("/rest/product_all/isHidden").then(resp => {
            $scope.items = resp.data
            $scope.backupItem = resp.data;
            $scope.itemType = "hidden";
        })
    }
    $scope.renderProductIsActive = function () {
        $scope.items = [];
        $http.get("/rest/product_all/isActive").then(resp => {
            $scope.items = resp.data
            $scope.backupItem = resp.data;
            $scope.itemType = "active";
        })
    }
    $scope.renderProductIsSoldOut = function () {
        $scope.items = [];
        $http.get("/rest/product_all/isSoldOut").then(resp => {
            $scope.backupItem = resp.data;
            $scope.items = resp.data
            $scope.itemType = "soldout";
        })
    }
    $scope.HiddenProDuct = function (productId) {
        $http.get("/rest/product_all/hiddenProduct?productId=" + productId).then(resp => {
            $scope.items = resp.data
        }).catch(error => {
        })
    }
    $scope.ActiveProduct = function (productId) {
        $http.get("/rest/product_all/activeProduct?productId=" + productId).then(resp => {
            $scope.items = resp.data
        }).catch(error => {
        })
    }
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            if (this.page < 0) {
                this.last();
            }
            if (this.page >= this.count) {
                this.first();
            }
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size)
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        last() {
            this.page = this.count - 1;
        },
        next() {
            this.page++;
        },
        prev() {
            this.page--;
        }
    }

    $scope.filterProduct = function () {
        $scope.items = [];
        $scope.backupItem.forEach(item => {
            if (item.productName.toLowerCase().includes($scope.search_product_name.toLowerCase()) && item.priceNew <= $scope.maxValue && item.priceNew >= $scope.minValue) {
                $scope.items.push(item);
            }
        })
    }
    $scope.initialize();

//    edit Product
//     $scope.editProduct = function (productId) {
//         sharing_product_data.setProductId(productId);
//         $location.path = "/editProduct";
//     }


});




