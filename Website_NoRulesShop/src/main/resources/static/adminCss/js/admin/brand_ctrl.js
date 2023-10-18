app.controller("brand_ctrl", function ($scope, $http) {
    $scope.initialize = function () {
        $http.get("/rest/manage_directory").then(resp => {
            $scope.directoryLv1_all = resp.data;
        });
        $http.get("/rest/manage_brand").then(resp => {
            $scope.items = resp.data
        })
    }
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.form.imagePath = item.logo_url;
        $scope.disabled = true;
        console.log($scope.form.is_excepted);
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
                item.logo_url = imagePath;

                // Tạo thương hiệu sau khi đã cập nhật logo_url
                $http.post('/rest/manage_brand', item).then(function(resp) {
                    $scope.items.push(resp.data);
                    $scope.reset();
                    alert("Thêm mới thành công!");

                }).catch(function(error) {
                    alert("Lỗi thêm mới!");
                    console.log("Error", error);
                });
            }).catch(function(error) {
                alert("Lỗi tải lên ảnh!");
                console.log("Error", error);
            });
        }else{
            alert("Bắt buộc thêm ảnh")
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
                item.logo_url = imagePath;

                // Tạo thương hiệu sau khi đã cập nhật logo_url
                $http.put(`/rest/manage_brand/${item.brand_id}`, item).then(resp => {
                    var index = $scope.items.findIndex(p => p.brand_id === item.brand_id);
                    $scope.items[index] = item;
                    $scope.reset();
                    alert("Cập nhật sản phẩm thành công!");
                    $('a[href="#manager-brand"]').tab('show');
                })
                    .catch(error => {
                        alert("Lỗi cập nhật sản phẩm!");
                        console.log("Error", error);
                    });
            }).catch(function(error) {
                alert("Loi tai len anh!");
                console.log("Error", error);
            });
        }else {
            // Tạo thương hiệu sau khi đã cập nhật logo_url
            $http.put(`/rest/manage_brand/${item.brand_id}`, item).then(resp => {
                var index = $scope.items.findIndex(p => p.brand_id === item.brand_id);
                $scope.items[index] = item;
                $scope.reset();
                alert("Cập nhật sản phẩm thành công!");
                $('a[href="#manager-brand"]').tab('show');
            })
                .catch(error => {
                    alert("Lỗi cập nhật sản phẩm!");
                    console.log("Error", error);
                });
        }

    }
    $scope.reset = function(){
        $scope.form = {}
        $scope.disabled= false;
    }
    $scope.delete = function(item){
        if(confirm("Bạn có muốn ngừng hoạt động sản phẩm này?")){
            $http.delete(`/rest/manage_brand/${item.brand_id}`).then(resp => {
                item.is_excepted=false;
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