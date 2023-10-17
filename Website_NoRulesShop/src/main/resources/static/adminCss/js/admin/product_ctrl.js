app.controller("product_ctrl", function($scope, $http){
    $scope.initialize = function () {
        $scope.renderProductIsActive();
    }
    // $scope.pager = {
    //     page: 0,
    //     size: 10,
    //     get items() {
    //         if (this.page < 0) {
    //             this.last();
    //         }
    //         if (this.page >= this.count) {
    //             this.first();
    //         }
    //         var start = this.page * this.size;
    //         // return $scope.items.slice(start, start + this.size)
    //     }
    // }

    $scope.SearchByName = function (productName){
        switch ($scope.itemType){
            case "hidden":
                $http.get("/rest/product_all/searchByNameProductHidden?productName="+productName ).then(resp => {
                    $scope.items = resp.data
                })
                break;
            case "active":
                $http.get("/rest/product_all/searchByNameProductOnline?productName="+productName ).then(resp => {
                    $scope.items = resp.data
                })
                break;
            case "soldout":
                $http.get("/rest/product_all/searchByNameProductSoldout?productName="+productName ).then(resp => {
                    $scope.items = resp.data
                })
                break;
        }
    }
    //
    // $scope.changeTabContent =  function (TabPaneName){
    //     switch (TabPaneName) {
    //         case "hidden":
    //             break;
    //         case "activity":
    //             break;
    //         case "sold_out":
    //             break;
    //     }
    // }
    $scope.renderProductIsHidden = function (){
        $http.get("/rest/product_all/isHidden").then(resp => {
            $scope.items = resp.data
            $scope.itemType = "hidden";
        })
    }
    $scope.renderProductIsActive = function (){
        $http.get("/rest/product_all/isActive").then(resp => {
            $scope.items = resp.data
            $scope.itemType = "active";

        })
    }
    $scope.renderProductIsSoldOut = function (){
        $http.get("/rest/product_all/isSoldOut").then(resp => {
            $scope.items = resp.data
            $scope.itemType = "soldout";

        })
    }
    $scope.HiddenProDuct = function (productId){
        if(confirm("Do you want to hidden this product ?")){
            $http.get("/rest/product_all/hiddenProduct?productId="+productId).then(resp => {
                $scope.items = resp.data
                alert("Successfully !");
            }).catch(error => {

            })
        }
    }
    $scope.ActiveProduct = function (productId){
        if(confirm("Do you want to display this product ?")){
            $http.get("/rest/product_all/activeProduct?productId="+productId).then(resp => {
                $scope.items = resp.data
                alert("Successfully !");
            }).catch(error => {

            })
        }
    }


    $scope.initialize();
    $scope.pager = {
        page: 0,
        size: 3,
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
});
