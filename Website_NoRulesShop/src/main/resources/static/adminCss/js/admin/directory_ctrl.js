app.controller("directory_ctrl", function($scope, $http){
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



    $scope.ClickDirectory = function (DirectoryId){
        $http.get("../rest/manage_directory/Directory?directoryId="+ DirectoryId).then(resp => {
            $scope.ListdirectoryLv1 = resp.data
        })
    }

    $scope.createDir = function(genderID){
        $scope.form.genderId = genderID
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


    // $scope.createDirLv1 = function(DirectoryId){
    //     var item = angular.copy($scope.form);
    //     $http.post('../rest/manage_directory/Directory?directoryId='+ DirectoryId + item).then(resp => {
    //         $scope.directoryList.push(resp.data);
    //         $scope.form= {};
    //         alert("Thêm mới thành công!");
    //     }).catch(error => {
    //         alert("Lỗi thêm mới!");
    //         console.log("Error", error);
    //     });
    // }
    //
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
    //
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

