app.controller("brand_ctrl", function ($scope, $http) {
    $scope.initialize = function () {
        $http.get("/rest/manage_brand").then(resp => {
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
    $scope.initialize();
})