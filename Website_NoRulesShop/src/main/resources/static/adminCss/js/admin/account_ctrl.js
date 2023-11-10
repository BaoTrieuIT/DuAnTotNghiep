app.controller("account_ctrl", function($scope, $http){
    $scope.initialize = function(){
        $http.get("/rest/manage_account").then(resp =>{
            $scope.items = resp.data;
        })
    }
    $scope.initialize ();
})