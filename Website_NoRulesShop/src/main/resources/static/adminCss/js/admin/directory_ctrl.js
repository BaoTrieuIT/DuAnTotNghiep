app.service('DataSharingService', function () {
    var directoryId = null;

    return {
        getDirectoryId: function () {
            return directoryId;
        },
        setDirectoryId: function (newDirectoryId) {
            directoryId = newDirectoryId;
        }
    };
});

app.controller("directory_ctrl", function ($scope, $http, DataSharingService) {
    $scope.initialize = function () {
        $http.get("/rest/manage_gender").then(resp => {
            $scope.genders = resp.data
        })
        $http.get("/rest/manage_directory").then(resp => {
            $scope.items = resp.data;
        })
    }

    $scope.genderSelected = null;

    $scope.onChangeGender = function () {
        var genderId = $scope.genderSelected.genderId;
        if (genderId === undefined) {
            $http.get("/rest/manage_directory").then(resp => {
                $scope.items = resp.data;
            })
        } else {

            $http.get("/rest/manage_directory/Gender?genderId=" + genderId).then(resp => {
                $scope.items = resp.data
            })
        }

    }

    $scope.ClickDirectory = function (directoryId) {
        if (directoryId === undefined) {
            console.log("error");
        } else {
            $scope.filterByDirectoryId = function (directoryLv1) {
                return directoryLv1.directory.directoryId === directoryId;
            };
            $http.get("/rest/manage_directory/Directory?directoryId=" + directoryId).then(resp => {
                $scope.ListdirectoryLv1 = resp.data
                DataSharingService.setDirectoryId(directoryId)
            })
        }

    }

    $scope.createDir = function (genderID) {
        // $scope.form.genderId = genderID
        var item = angular.copy($scope.form);
        console.log(item)
        $http.post("/rest/manage_directory/" + genderID, item).then(resp => {
            $scope.items.push(resp.data);
            $scope.form = {};
            alert("Thêm mới thành công!");
            $('#create_directory').modal('hide')
        }).catch(error => {
            alert("Lỗi thêm mới");
            console.log("Error", error);
        });
    }

    $scope.initialize();

})



