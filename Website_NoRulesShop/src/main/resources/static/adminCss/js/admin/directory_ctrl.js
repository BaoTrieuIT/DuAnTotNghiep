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

    /// PHẦN THÔNG BÁO
    $scope.Messsuccess = false;  // Đặt thành true khi hành động thành công
    $scope.Messerror = false;    // Đặt thành true khi hành động không thành công
    $scope.message = '';     // Thông điệp thành công hoặc không thành công của bạn

    $scope.closeAlert = function() {
        $scope.Messsuccess = false;
        $scope.Messerror = false;
        $scope.message = '';
    }
    var closeTimeout;

    function setAutoCloseTime() {
        // Đóng thông báo tự động
        closeTimeout = $timeout(function() {
            $scope.closeAlert();
        }, 15000); // 15000 là 15s
    }
    var isSusccess = function(number,mess){
        if(number == 1){
            $scope.Messsuccess = true;
            $scope.Messerror = false;
            $scope.message = mess
            setAutoCloseTime()
        }else{
            if (number== 2){
                $scope.Messsuccess = false;
                $scope.Messerror = true;
                $scope.message = mess
            }
        }
    }

    // Chọn gender
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
    /// TẠO MỚI DANH MỤC CHA NÈ
    $scope.createDir = function (genderID) {
        // $scope.form.genderId = genderID
        var item = angular.copy($scope.form);
        console.log(item)
        $http.post("/rest/manage_directory/" + genderID, item).then(resp => {
            $scope.items.push(resp.data);
            $scope.form = {};
            $('#create_directory_lv1_' + direcId).modal('hide');
            isSusccess(1,"Thêm danh mục thành công")
        }).catch(error => {
            console.log("Error", error);
            isSusccess(2,"Lỗi thêm danh mục")
            $('#create_directory').modal('hide')
        });
    }

    $scope.initialize();

})



