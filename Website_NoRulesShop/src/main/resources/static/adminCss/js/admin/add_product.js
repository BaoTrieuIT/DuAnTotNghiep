app.controller("product_ctrl", function($scope, $http){
    $scope.initialize = function () {
        $scope.getBrands();
        $scope.getDirectory();
    }
    $scope.getDirectory = function (){
        $http.get("/rest/manage_directoryLv1/").then(resp => {
            $scope.directoryLv1s = resp.data
            console.log($scope.directoryLv1s)
        })
    };
    $scope.getBrands = function (){
        $http.get("/rest/manage_brand").then(resp => {
            $scope.brands = resp.data
        })
    }
    $scope.initialize();
});