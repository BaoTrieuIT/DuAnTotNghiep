app.controller("product_ctrl", function($scope, $http){
    $scope.initialize = function () {
        $http.get("/rest/product_all").then(resp => {
            $scope.items = resp.data
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
        }
    }

    $scope.SearchByName = function (productName){
        $http.get("/rest/product_all/searchByName?productName="+productName ).then(resp => {
            $scope.items = resp.data
            console.log(items);
        })
    }
    $scope.initialize();
})