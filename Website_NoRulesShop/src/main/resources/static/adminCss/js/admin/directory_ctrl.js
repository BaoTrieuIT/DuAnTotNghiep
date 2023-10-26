app.service('DataSharingService', function() {
    var directoryId = null;

    return {
        getDirectoryId: function() {
            return directoryId;
        },
        setDirectoryId: function(newDirectoryId) {
            directoryId = newDirectoryId;
        }
    };
});

app.controller("directory_ctrl", function($scope, $http ,DataSharingService){
    $scope.initialize = function(){
        $http.get("/rest/manage_gender").then(resp => {
            $scope.genders = resp.data
        })
        $http.get("/rest/manage_directory").then(resp => {
            $scope.items = resp.data;
        })
    }

    $scope.genderSelected = null;

    $scope.onChangeGender = function (){
        $http.get("/rest/manage_directory/Gender?genderId="+ $scope.genderSelected.genderId).then(resp => {
            $scope.items = resp.data
            console.log($scope.items)
        })
    }

    $scope.ClickDirectory = function (directoryId){
        $http.get("/rest/manage_directory/Directory?directoryId="+ directoryId).then(resp => {
            $scope.ListdirectoryLv1 = resp.data
            DataSharingService.setDirectoryId(directoryId)
        })
    }

    $scope.createDir = function(genderID){
        // $scope.form.genderId = genderID
        var item = angular.copy($scope.form);
        console.log(item)
        $http.post("/rest/manage_directory/"+genderID ,item).then(resp => {
            $scope.items.push(resp.data);
            $scope.form= {};
            alert("Thêm mới thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới");
            console.log("Error", error);
        });
    }

    $scope.initialize();

})




// app.controller("directoryLv1_ctrl", function($scope, $http, DataSharingService){
//     var direcId = null
//     // $scope.directoryId = DataSharingService.getDirectoryId()
//     $scope.$watch(function (){
//         return DataSharingService.getDirectoryId()
//     }, function(newDirectoryId, oldDirectoryId){
//         if (newDirectoryId !== oldDirectoryId) {
//             console.log(newDirectoryId)
//             // Gọi lại API khi directoryId thay đổi
//             direcId = newDirectoryId
//         }
//     });
//
//
//     $scope.initialize = function(direcId){
//         $http.get("/rest/manage_directory/Directory?directoryId="+ direcId).then(resp => {
//             $scope.ListdirectoryLv1 = resp.data;
//         })
//     }
//
//     $scope.creatDirLv1 = function(direcId){
//         console.log($scope.ListdirectoryLv1)
//         console.log(direcId)
//         console.log($scope.directoryLv1Name)
//         var dlv1 = angular.copy($scope.form)
//         $http.post('/rest/directoryLv1/'+ direcId,dlv1).then(resp => {
//             $scope.ListdirectoryLv1.push(resp.data);
//             $scope.form= {};
//             alert("Thêm mới thành công!");
//         }).catch(error => {
//             alert("Lỗi thêm mới!");
//             console.log("Error", error);
//         });
//     }
//
//     // $scope.update = function(item){
//     //     var item = angular.copy($scope.form);
//     //     $http.put(`/rest/directoryLv1/${item.id}`, item).then(resp => {
//     //         var index = $scope.ListdirectoryLv1.findIndex(p => p.id == item.id);
//     //         $scope.ListdirectoryLv1[index] = item;
//     //         alert("Cập nhật sản phẩm thành công!");
//     //     })
//     //         .catch(error => {
//     //             alert("Lỗi cập nhật sản phẩm!");
//     //             console.log("Error", error);
//     //         });
//     // }
//
//     // $scope.delete = function(item){
//     //     if(confirm("Bạn muốn xóa sản phẩm này?")){
//     //         $http.delete(`/rest/directoryLv1/${item.id}`).then(resp => {
//     //             var index = $scope.ListdirectoryLv1.findIndex(p => p.id == item.id);
//     //             $scope.ListdirectoryLv1.splice(index, 1);
//     //             alert("Xóa sản phẩm thành công!");
//     //         }).catch(error => {
//     //             alert("Lỗi xóa sản phẩm!");
//     //             console.log("Error", error);
//     //         })
//     //     }
//     // }
//     // $scope.deleteSelectedItems = function() {
//     //     var selectedItems = $scope.ListdirectoryLv1.filter(function(item) {
//     //         return item.checked;
//     //     });
//     //
//     //     // Biến đổi danh sách các mục đã đánh dấu thành một mảng của các ID hoặc đối tượng Directory
//     //     var selectedIds = selectedItems.map(function(item) {
//     //         return item.directoryId;
//     //     });
//     //
//     //     $http.delete('/api/directories/delete', { data: selectedIds }).then(function(response) {
//     //         // Xử lý phản hồi từ máy chủ (nếu cần)
//     //     });
//     // };
//
//     $scope.initialize();
// })


