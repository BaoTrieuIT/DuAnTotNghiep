app.controller("brand_ctrl", function ($scope, $http,$timeout) {
    $scope.initialize = function () {
        $http.get("/rest/manage_directory").then(resp => {
            $scope.directoryLv1_all = resp.data;
        });
        $http.get("/rest/manage_brand").then(resp => {
            $scope.items = resp.data
        })
    }
    $scope.showAlert = false;
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.form.imagePath = item.logoUrl;
        $scope.disabled = true;
        $('a[href="#add-brand"]').tab('show');
    }
    $scope.create = function() {
        var item = angular.copy($scope.form);
        var inputFile = document.getElementById("inputFile");

        // Tạo đối tượng FormData và thêm tệp ảnh vào nó
        var formData = new FormData();
        if (inputFile.files.length > 0) {
            formData.append("fileName", inputFile.files[0]);
            $http.post('/rest/manage_brand/upload', formData, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }
            }).then(function(response) {
                var data = response.data;
                var successMessage = data.message;
                // Lấy đường dẫn hoặc tên tệp ảnh từ response
                var imagePath = data.imagePath;
                console.log(successMessage);
                console.log("Image path: " + imagePath);
                // Cập nhật thuộc tính logo_url của thương hiệu
                item.logoUrl = imagePath;

                // Tạo thương hiệu sau khi đã cập nhật logo_url
                $http.post('/rest/manage_brand', item).then(function(resp) {
                    $scope.items.push(resp.data);
                    $scope.succes = "Thêm thành công";
                    $scope.showAlert = true;
                    $('a[href="#manager-brand"]').tab('show');
                    $timeout(function() {
                        $scope.showAlert = false;
                        $scope.succes = "";
                    }, 5000);
                    $scope.form = {};

                }).catch(function(error) {
                    $scope.succes = "Lỗi thêm!";
                    console.log("Error", error);
                });
            }).catch(function(error) {
                $scope.succes = "Lỗi tải lên ảnh!";
                console.log("Error", error);
            });
        }else{
            $scope.succes = "Bắt buộc thêm ảnh";
            $timeout(function() {
                $scope.succes = "";
            }, 3000);
        }

        // Tải lên tệp ảnh (nếu có)

    }

    $scope.update = function(){
        var item = angular.copy($scope.form);
        var inputFile = document.getElementById("inputFile");
        var formData = new FormData();
        if (inputFile.files.length > 0) {
            formData.append("fileName", inputFile.files[0]);
            $http.post('/rest/manage_brand/upload', formData, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }
            }).then(function(response) {
                var data = response.data;
                var successMessage = data.message;
                // Lấy đường dẫn hoặc tên tệp ảnh từ response
                var imagePath = data.imagePath;
                console.log(successMessage);
                console.log("Image path: " + imagePath);
                // Cập nhật thuộc tính logo_url của thương hiệu
                item.logoUrl = imagePath;

                // Tạo thương hiệu sau khi đã cập nhật logo_url
                $http.put(`/rest/manage_brand/${item.brandId}`, item).then(resp => {
                    var index = $scope.items.findIndex(p => p.brandId === item.brandId);
                    $scope.items[index] = item;
                    $scope.succes = "Cập nhật sản phẩm thành công!";

                    $scope.showAlert = true;
                    $('a[href="#manager-brand"]').tab('show');
                    $timeout(function() {
                        $scope.showAlert = false;
                        $scope.succes = "";
                    }, 5000);
                    $scope.disabled= false;
                    $scope.form = {};

                })
                    .catch(error => {
                        $scope.succes = "Lỗi cập nhật sản phẩm!";
                        console.log("Error", error);
                    });
            }).catch(function(error) {
                $scope.succes = "Loi tai len anh!";
                console.log("Error", error);
            });
        }else {
            // Tạo thương hiệu sau khi đã cập nhật logo_url
            $http.put(`/rest/manage_brand/${item.brandId}`, item).then(resp => {
                var index = $scope.items.findIndex(p => p.brandId === item.brandId);
                $scope.items[index] = item;
                $scope.succes = "Cập nhật sản phẩm thành công!";
                $scope.disabled= false;
                $scope.showAlert = true;
                $('a[href="#manager-brand"]').tab('show');
                $timeout(function() {
                    $scope.showAlert = false;
                    $scope.succes = "";
                }, 5000);
                $scope.form = {};

            })
                .catch(error => {
                    $scope.succes = "Lỗi cập nhật sản phẩm!";
                    console.log("Error", error);
                });
        }

    }
    $scope.reset = function(){
        $scope.form = {}
        $scope.succes="";
        $scope.disabled= false;
    }
    $scope.delete = function(item){
        if(confirm("Bạn có muốn ngừng hoạt động sản phẩm này?")){
            $http.delete(`/rest/manage_brand/${item.brandId}`).then(resp => {

                alert("Ngừng hoạt động sản phẩm thành công!");

            }).catch(error => {
                alert("Lỗi!");
                console.log("Error", error);
            })
        }
    }
    $scope.initialize();
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            if (this.page < 0) {
                this.last();
            }
            if (this.page >= this.count) {
                this.first();
            }
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size)
        },
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
            this.page = 0;
        },
        last(){
            this.page = this.count - 1;
        },
        next(){
            this.page++;
        },
        prev(){
            this.page--;
        }
    }
})