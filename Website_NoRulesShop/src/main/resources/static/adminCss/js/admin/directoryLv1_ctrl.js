app.controller("directoryLv1_ctrl", function ($scope, $http, DataSharingService) {
    var direcId = null
    // $scope.directoryId = DataSharingService.getDirectoryId()
    $scope.$watch(function () {
        return DataSharingService.getDirectoryId()
    }, function (newDirectoryId, oldDirectoryId) {
        if (newDirectoryId !== oldDirectoryId) {
            // Gọi lại API khi directoryId thay đổi
            direcId = newDirectoryId
        }
        // console.log(direcId)
    });
    $scope.initialize = function (direcId) {
        if (direcId === undefined) {
            $http.get("/rest/manage_directory/DirectoryLv1").then(resp => {
                $scope.ListdirectoryLv1 = resp.data;
            })
        } else {
            $http.get("/rest/manage_directory/Directory?directoryId=" + direcId).then(resp => {
                $scope.ListdirectoryLv1 = resp.data;
            })
        }

    }


// THÊM MỚI DIRECTORY LEVEL 1
//     $scope.creatDirLv1 = function (direcId) {
//         var dlv1 = angular.copy($scope.form)
//         $http.post('/rest/directoryLv1/' + direcId, dlv1).then(resp => {
//             $scope.ListdirectoryLv1.push(resp.data);
//             $scope.form = {};
//             $('#create_directory_lv1_' + direcId).modal('hide');
//             isSusccess(1,`Thêm danh mục ` +`${dlv1.directoryLv1Name} thành công`)
//             console.log(`Thêm danh mục ` +`${dlv1.directoryLv1Name} thành công`)
//         }).catch(error => {
//             isSusccess(2," Lỗi thêm mới danh mục")
//             console.log(Error,error + " Lỗi thêm mới danh mục")
//         });
//     }
    $scope.creatDirLv1 = function (direcId) {
        var dlv1 = angular.copy($scope.form)
        $http.post('/rest/directoryLv1/' + direcId, dlv1).then(resp => {
            $scope.ListdirectoryLv1.push(resp.data);
            $scope.form = {};
            $('#create_directory_lv1_' + direcId).modal('hide');
            var data = DataSharingService.getData();
            data.messerror = false;
            data.messwarning = false;
            data.messsuccess = true;
            data.message = "Tạo danh mục " +`${dlv1.directoryLv1Name} thành công`;
            DataSharingService.setData(data)
            console.log("data ngay tạo thành công: ",DataSharingService.getData())
        }).catch(error => {
            var data = DataSharingService.getData();
            data.messwarning = false;
            data.messsuccess = false;
            data.messerror = true;
            data.message = "Tạo danh mục thất bại";
            DataSharingService.setData(data)
            console.log(DataSharingService.getData().message)
        });
    }


// CẬP NHẬT DIRECTORY LEVEL 1
    $scope.selectedDirectoryLv1 = null

    $scope.selectDirectoryLv1 = function (directoryLv1) {
        $scope.selectedDirectoryLv1 = angular.copy(directoryLv1)
        console.log(directoryLv1.directoryLv1Id)
        console.log(directoryLv1.directoryLv1Name)
    }

    $scope.updateDirLV1 = function () {
        var item = angular.copy($scope.selectedDirectoryLv1);
        // Sử dụng biến selectedDirectoryLv1
        console.log(item)
        if (!item.directoryLv1Id) {
            alert("ID không hợp lệ.");
            return;
        }
        $http.put(`/rest/directoryLv1/update/${item.directoryLv1Id}`, item).then(resp => {
            var index = $scope.ListdirectoryLv1.findIndex(p => p.directoryLv1Id === item.directoryLv1Id);
            if (index === -1) {
                DataSharingService.isSuccess(3,"Không tìm thấy danh mục con này tương ứng trong danh mục")
                return;
            }
            $scope.ListdirectoryLv1[index] = item;
            $('#edit_name_directory_lv1_' + direcId + item.directoryLv1Id).modal('hide')
            DataSharingService.isSuccess(1,`Cập nhật danh mục ` +`${+dlv1.directoryLv1Name} thành công`)
            $scope.selectedDirectoryLv1 = {};
        }).catch(error => {
            DataSharingService.isSuccess(2,"Lỗi cập nhật sản phẩm!")
            console.log("Error", error);
        });
    };

// XÓA DANH MỤC CON ĐƯỢC CHỌN
    $scope.reloadDirectoryList = function() {
        $http.get("/rest/manage_directory/Directory?directoryId=" + direcId).then(resp => {
            $scope.ListdirectoryLv1 = resp.data;
        }).catch(function(error) {
            console.error("Error loading directory list", error);
        });
    };

    $scope.deleteSelectedItems = function () {
        var selectedIds = [];

        // Lặp qua danh sách các mục đã đánh dấu
        for (var i = 0; i < $scope.ListdirectoryLv1.length; i++) {
            if ($scope.ListdirectoryLv1[i].checked) {
                selectedIds.push($scope.ListdirectoryLv1[i].directoryLv1Id);
                console.log($scope.ListdirectoryLv1[i].directoryLv1Name);
            }
        }
        console.log(selectedIds)
        if (selectedIds.length === 0) {
            // alert("Vui lòng chọn ít nhất một mục để xóa.");
            DataSharingService.isSuccess(3,"Vui lòng chọn ít nhất một mục để xóa.")
            return;
        }

        // Gửi các ID đã chọn lên máy chủ để xóa
        $http({
            method: 'DELETE',
            url: '/rest/directoryLv1/delete',
            data: selectedIds, // Gửi mảng các ID cần xóa
            headers: {'Content-Type': 'application/json;charset=utf-8'}
        }).then(function (response) {
            for (var i = $scope.ListdirectoryLv1.length - 1; i >= 0; i--) {
                if (selectedIds.indexOf($scope.ListdirectoryLv1[i].directoryLv1Id) !== -1) {
                    // Xóa mục đã chọn khỏi danh sách
                    $scope.ListdirectoryLv1.splice(i, 1);
                }
            }
            $scope.reloadDirectoryList()
            console.log($scope.reloadDirectoryList())
            DataSharingService.isSuccess(1,"Xóa thành công danh mục được chọn")
            console.log("Xóa thành công danh mục được chọn")
        }).catch(function (error) {
            // alert("Lỗi xóa mục đã chọn.");
            DataSharingService.isSuccess(2,"Lỗi xóa mục đã chọn.")
            console.error("Error", error);
        });
    };


    $scope.initialize();
})