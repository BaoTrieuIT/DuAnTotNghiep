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

        // var dlv1 = angular.copy($scope.form)
        // $http.post('/rest/directoryLv1/' + direcId, dlv1).then(resp => {
        //     $scope.ListdirectoryLv1.push(resp.data);
        //     $scope.form = {};
        //     alert("Thêm mới thành công!");
        // }).catch(error => {
        //     alert("Lỗi thêm mới!");
        //     console.log("Error", error);
        // });
    }

    $scope.creatDirLv1 = function (direcId) {
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

    // $scope.update = function(item){
    //     var item = angular.copy($scope.form);
    //     $http.put(`/rest/directoryLv1/${item.id}`, item).then(resp => {
    //         var index = $scope.ListdirectoryLv1.findIndex(p => p.id == item.id);
    //         $scope.ListdirectoryLv1[index] = item;
    //         alert("Cập nhật sản phẩm thành công!");
    //     })
    //         .catch(error => {
    //             alert("Lỗi cập nhật sản phẩm!");
    //             console.log("Error", error);
    //         });
    // }

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
    // $scope.deleteSelectedItems = function() {
    //     var selectedItems = $scope.ListdirectoryLv1.filter(function(item) {
    //         return item.checked;
    //     });
    //
    //     // Biến đổi danh sách các mục đã đánh dấu thành một mảng của các ID hoặc đối tượng Directory
    //     var selectedIds = selectedItems.map(function(item) {
    //         return item.directoryId;
    //     });
    //
    //     $http.delete('/api/directories/delete', { data: selectedIds }).then(function(response) {
    //         // Xử lý phản hồi từ máy chủ (nếu cần)
    //     });
    // };

    $scope.initialize();
})