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
        $http.get("/rest/product_all/searchByName?productName="+productName ).then(resp => {
            $scope.items = resp.data
        })
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
        })
    }
    $scope.renderProductIsActive = function (){
        $http.get("/rest/product_all/isActive").then(resp => {
            $scope.items = resp.data
        })
    }
    $scope.renderProductIsSoldOut = function (){
        $http.get("/rest/product_all/isSoldOut").then(resp => {
            $scope.items = resp.data
        })
    }
    $scope.HiddenProDuct = function (productId){
        $http.get("/rest/product_all/hiddenProduct?productId="+productId).then(resp => {
            $scope.items = resp.data
        })
    }
    $scope.ActiveProduct = function (productId){
        $http.get("/rest/product_all/activeProduct?productId="+productId).then(resp => {
            $scope.items = resp.data
        })
    }


    $scope.initialize();
})