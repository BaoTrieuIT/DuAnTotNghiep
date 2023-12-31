// app.service('DataSharingService', function () {
//     var directoryId = null;
//
//     return {
//         getDirectoryId: function () {
//             return directoryId;
//         },
//         setDirectoryId: function (newDirectoryId) {
//             directoryId = newDirectoryId;
//         }
//     };
// });
app.service('DataSharingService', function ($timeout) {
    var directoryId = null;

    var data = {
        messsuccess: false,
        messerror: false,
        messwarning: false,
        message: ''
    };

    return {
        getDirectoryId: function () {
            return directoryId;
        }, setDirectoryId: function (newDirectoryId) {
            directoryId = newDirectoryId;
        },

        getData: function () {
            return data;
        }, setData: function (newData) {
            data.messsuccess = newData.messsuccess;
            data.messerror = newData.messerror;
            data.messwarning = newData.messwarning;
            data.message = newData.message;
        },
    };
});


app.controller("directory_ctrl", function ($scope, $http, DataSharingService, $timeout) {

    $scope.$watch(function () {
        return DataSharingService.getData()
    }, function (newDirectory, oldDirectory) {
        if (newDirectory !== oldDirectory) {
            $scope.Messsuccess = newDirectory.messsuccess;
            $scope.Messerror = newDirectory.messerror;
            $scope.Messwarning = newDirectory.messwarning;
            $scope.message = newDirectory.message;
        }
    });

    function setAutoCloseTime() {
        // Đóng thông báo tự động
        var closeTimeout = $timeout(function () {
            $scope.Messsuccess = false
            $scope.Messerror = false
            $scope.Messwarning = false
            $scope.message = ""
        }, 10000); // 10000 là 10s
    }

    $scope.initialize = function () {
        $http.get("/rest/manage_gender").then(resp => {
            $scope.genders = resp.data
        })
        $http.get("/rest/manage_directory").then(resp => {
            $scope.items = resp.data;
        })
        $scope.Messsuccess = false
        $scope.Messerror = false
        $scope.Messwarning = false
        $scope.message = ""
        // Thông điệp thành công hoặc không thành công của bạn
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
        var item = angular.copy($scope.form);

        // Kiểm tra xem item.directoryName đã tồn tại trong danh sách items hay chưa
        var isDuplicate = $scope.items.some(function (existingItem) {
            return existingItem.directoryName === item.directoryName;
        });

        if (isDuplicate) {
            // Nếu tên danh mục đã tồn tại, hiển thị thông báo và không tạo mới
            $scope.Messwarning = true;
            $scope.Messsuccess = false
            $scope.Messerror = false
            $scope.message = "Danh mục " + `${item.directoryName} đã tồn tại`
            $('#create_directory').modal('hide');
            setAutoCloseTime()
        } else {
            // Nếu tên danh mục chưa tồn tại, tiến hành tạo mới
            $http.post("/rest/manage_directory/" + genderID, item).then(resp => {
                $scope.items.push(resp.data);
                $scope.form = {};
                $scope.Messerror = false
                $scope.Messwarning = false;
                $scope.Messsuccess = true
                $scope.message = "Thêm danh mục thành công"
                $('#create_directory').modal('hide');
                setAutoCloseTime()
            }).catch(error => {
                $scope.form = {};
                console.log("Error", error);
                $scope.Messsuccess = false
                $scope.Messwarning = false
                $scope.Messerror = true
                $scope.message = "Lỗi thêm mới danh mục"
                $('#create_directory').modal('hide');
            });
        }
    }


    $scope.initialize();

})



