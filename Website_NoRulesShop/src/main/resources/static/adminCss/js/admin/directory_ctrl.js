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
    $scope.genderSelected = null;

    $scope.onChangeGender = function (){
        $http.get("../rest/manage_directory/Gender?genderId="+ $scope.genderSelected.genderId).then(resp => {
            $scope.directoryList = resp.data
            console.log($scope.directoryList)

        })
    }




    $scope.ClickDirectory = function (DirectoryId){
        $http.get("../rest/manage_directory/Directory?directoryId="+ DirectoryId).then(resp => {
            console.log(DirectoryId)
            $scope.ListdirectoryLv1 = resp.data
            console.log(resp.data)
        })
    }
})