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
    function isSusccess(number,mess){
        if (number != 1) {
            if (number == 2) {
                $scope.Messsuccess = false;
                $scope.Messerror = true;
                $scope.Messwarning = false;
                $scope.message = mess
            } else (number == 3)
            {
                $scope.Messsuccess = false;
                $scope.Messerror = false;
                $scope.Messwarning = true;
                $scope.message = mess
            }
        } else {
            $scope.Messsuccess = true;
            $scope.Messerror = false;
            $scope.Messwarning = false;
            $scope.message = mess
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
    // $scope.createDir = function (genderID) {
    //     var item = angular.copy($scope.form);
    //     console.log(item)
    //     $http.post("/rest/manage_directory/" + genderID, item).then(resp => {
    //         $scope.items.push(resp.data);
    //         $scope.form = {};
    //         $('#create_directory_lv1_' + direcId).modal('hide');
    //         isSusccess(1,"Thêm danh mục thành công")
    //     }).catch(error => {
    //         console.log("Error", error);
    //         isSusccess(2,"Lỗi thêm danh mục")
    //         $('#create_directory').modal('hide')
    //     });
    // }
    $scope.createDir = function(genderID) {
        var item = angular.copy($scope.form);

        // Kiểm tra xem item.directoryName đã tồn tại trong danh sách items hay chưa
        var isDuplicate = $scope.items.some(function(existingItem) {
            return existingItem.directoryName === item.directoryName;
        });

        if (isDuplicate) {
            // Nếu tên danh mục đã tồn tại, hiển thị thông báo và không tạo mới
            isSusccess(3,"Danh mục đã tồn tại")
            console.log($scope.message)
            $('#create_directory').modal('hide');
        } else {
            // Nếu tên danh mục chưa tồn tại, tiến hành tạo mới
            $http.post("/rest/manage_directory/" + genderID, item).then(resp => {
                $scope.items.push(resp.data);
                $scope.form = {};
                isSusccess(1,"Thêm danh mục thành công")
                console.log($scope.message)
                $('#create_directory').modal('hide');
            }).catch(error => {
                console.log("Error", error);
                isSusccess(2,"Lỗi thêm mới danh mục")
                console.log($scope.message)
                $('#create_directory').modal('hide');
            });
        }
    }


    $scope.initialize();

})



