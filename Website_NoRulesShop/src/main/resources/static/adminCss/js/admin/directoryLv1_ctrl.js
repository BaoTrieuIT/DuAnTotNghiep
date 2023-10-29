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
    });
    // $scope.initialize = function (direcId) {
    //     var iD = direcId;
    //     if (iD === undefined) {
    //         $http.get("/rest/manage_directory/DirectoryLv1").then(resp => {
    //             $scope.ListdirectoryLv1 = resp.data;
    //         })
    //     } else {
    //         $http.get("/rest/manage_directory/Directory?directoryId=" + iD).then(resp => {
    //             $scope.ListdirectoryLv1 = resp.data;
    //         })
    //     }
    //
    $scope.initialize = function (direcId) {
        $http.get("/rest/manage_directory/Directory?directoryId=" + direcId).then(resp => {
            $scope.ListdirectoryLv1 = resp.data;
        })
    }
    $scope.select = function (direcId) {
        console.log(direcId)
    }
    // Ban đầu ẩn form
    $scope.isCreateDirectoryLv1ModalOpen = false;

    $scope.select = function (direcId) {
        console.log(direcId);
        $scope.isCreateDirectoryLv1ModalOpen = true;
    }


    $scope.creatDirLv1 = function (direcId) {
        console.log($scope.ListdirectoryLv1)
        console.log(direcId)
        console.log($scope.directoryLv1Name)
        var dlv1 = angular.copy($scope.form)
        $http.post('/rest/directoryLv1/' + direcId, dlv1).then(resp => {
            $scope.ListdirectoryLv1.push(resp.data);
            $scope.form = {};
            alert("Thêm mới thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới!");
            console.log("Error", error);
        });
    }

    // CẬP NHẬT DIRECTORY LEVEL 1
    $scope.selectedDirectoryLv1 = null

    $scope.selectDirectoryLv1 = function (directoryLv1){
        $scope.selectedDirectoryLv1 = angular.copy(directoryLv1)
        console.log(directoryLv1.directoryLv1Id)
    }

    $scope.updateDirLV1 = function() {
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
                alert("Không tìm thấy item với ID tương ứng.");
                return;
            }
            $scope.ListdirectoryLv1[index] = item;
            // $scope.showForm = false
            alert("Cập nhật sản phẩm thành công!");
            $scope.selectedDirectoryLv1 = {};
        }).catch(error => {
            alert("Lỗi cập nhật sản phẩm!");
            console.log("Error", error);
        });
    };


    $scope.deleteSelectedItems = function() {
        var selectedItems = $scope.ListdirectoryLv1.filter(function(directoryLv1) {
            return directoryLv1.checked;
            console.log(directoryLv1.directoryLv1Name)
        });

        // Biến đổi danh sách các mục đã đánh dấu thành một mảng của các ID hoặc đối tượng Directory
        var selectedIds = selectedItems.map(function(directoryLv1) {
            return directoryLv1.directoryLv1Id;
            console.log(directoryLv1.directoryLv1Name)
        });

        $http.delete('/rest/directoryLv1/delete', { data: selectedIds }).then(function(response) {
            // Xử lý phản hồi từ máy chủ (nếu cần)
        });
    };
    // $scope.delete = function(item){
    //     if(confirm("Bạn muốn xóa sản phẩm này?")){
    //         $http.delete(`/rest/directoryLv1/${item.id}`).then(resp => {
    //             var index = $scope.ListdirectoryLv1.findIndex(p => p.id == item.id);
    //             $scope.ListdirectoryLv1.splice(index, 1);
    //             alert("Xóa sản phẩm thành công!");
    //         }).catch(error => {
    //             alert("Lỗi xóa sản phẩm!");
    //             console.log("Error", error);
    //         })
    //     }
    // }
    $scope.initialize();
})