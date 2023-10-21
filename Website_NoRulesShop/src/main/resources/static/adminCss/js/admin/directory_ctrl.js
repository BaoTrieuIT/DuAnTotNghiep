app.controller("directory_ctrl", function($scope, $http){
    $scope.initialize = function(){
        $http.get("../rest/manage_gender").then(resp => {
            $scope.genders = resp.data
        })
        $http.get("/rest/manage_directory").then(resp => {
            $scope.items = resp.data;
        })
    }
    $scope.initialize();
})