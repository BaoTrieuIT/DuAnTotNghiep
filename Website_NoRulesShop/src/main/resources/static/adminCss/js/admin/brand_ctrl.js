app.controller("brand_ctrl", function ($scope, $http,$timeout,$window) {
    $scope.initialize = function () {
        $http.get("/rest/manage_directory").then(resp => {
            $scope.directoryLv1_all = resp.data;
        });
        $http.get("/rest/manage_brand").then(resp => {
            $scope.items = resp.data
        })
        $scope.form = {
            brandName: undefined ,
            websiteUrl:undefined,
            anotherInformation:undefined,
        };
    }
    $scope.isHidden = false;
    $scope.showAlert = false;
    $scope.showAlert1 = false;
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $scope.form.imagePath = item.logoUrl;
        $scope.isHidden = true;
        $scope.disabled = true;
        console.log($scope.form.is_excepted);
        $('a[href="#add-brand"]').tab('show');
    }
    $scope.them = function (){
        $scope.isHidden = false;
        var inputFile = document.getElementById("inputFile");
        var previewImage = document.getElementById("previewImage");
        inputFile.value= "";
        previewImage.src = "";
        $scope.form = {
            brandName: undefined ,
            websiteUrl:undefined,
            anotherInformation:undefined,
        };
        $scope.disabled= false;
        $('a[href="#add-brand"]').tab('show');
    }
    $scope.create = function() {
        if($scope.form.brandName !== undefined && $scope.form.websiteUrl !== undefined && $scope.form.anotherInformation  !== undefined){
            var item = angular.copy($scope.form);
            var inputFile = document.getElementById("inputFile");
            var previewImage = document.getElementById("previewImage");

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
                        $timeout(function() {
                            $scope.showAlert = false;
                            $scope.succes = "";
                        }, 2000);
                        $scope.form = {
                            brandName: undefined ,
                            websiteUrl:undefined,
                            anotherInformation:undefined,
                        };
                        inputFile.value= "";
                        previewImage.src = "";
                        $('a[href="#manager-brand"]').tab('show');
                    }).catch(function(error) {
                        $scope.succes = "Lỗi thêm!";
                        console.log("Error", error);
                    });
                }).catch(function(error) {
                    $scope.succes = "Lỗi tải lên ảnh!";
                    console.log("Error", error);
                });
            }else{

                $scope.succes1 = "Vui lòng chọn ảnh";
                $scope.showAlert1 = true;
                $timeout(function() {
                    $scope.showAlert1 = false;
                    $scope.succes1 = "";
                }, 3000);
            }
        }else{
            $scope.succes1 = "Vui lòng nhập đủ thông tin";
            $scope.showAlert1 = true;
            $timeout(function() {
                $scope.showAlert1 = false;
                $scope.succes1 = "";
            }, 2000);
        }
    }
    $scope.update = function(){

        if($scope.form.brandName !== undefined && $scope.form.websiteUrl !== undefined && $scope.form.anotherInformation  !== undefined){
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
                    $timeout(function() {
                        $scope.showAlert = false;
                        $scope.succes = "";
                    }, 2000);
                    $scope.disabled= false;
                    $scope.form = {};

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
                $timeout(function() {
                    $scope.showAlert = false;
                    $scope.succes = "";
                }, 2000);
                $scope.form = {};

            })
                .catch(error => {
                    alert("Lỗi cập nhật sản phẩm!");
                    console.log("Error", error);
                });
        }
        }else{
            $scope.succes1 = "Vui lòng nhập đủ thông tin";
            $scope.showAlert1 = true;
            $timeout(function() {
                $scope.showAlert1 = false;
                $scope.succes1 = "";
            }, 2000);
        }

    }
    $scope.reset = function(){
        $scope.form = {};
        $scope.isHidden = false;
        $scope.succes="";
        $scope.disabled= false;
    }
    $scope.itemToHide = null;

    $scope.setItemToHide = function(item) {
        $scope.itemToHide = item;
    }
    $scope.hidden = function(item){
        item.isActive = false;
        $http.put(`/rest/manage_brand/${item.brandId}`, item).then(function(resp) {
            var index = $scope.items.findIndex(p => p.brandId === item.brandId);
            $scope.items[index] = item;
        })
    }
    $scope.show = function(item){
        item.isActive = true;
        $http.put(`/rest/manage_brand/${item.brandId}`, item).then(function(resp) {
            var index = $scope.items.findIndex(p => p.brandId === item.brandId);
            $scope.items[index] = item;
        })
    }
    $scope.initialize();
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            if ($scope.items) {
            var activeBrands = $scope.items.filter(function(brand) {
                return brand.isActive === true;
            });
            if (this.page < 0) {
                this.last();
            }
            if (this.page >= this.count) {
                this.first();
            }
            var start = this.page * this.size;
            return activeBrands.slice(start, start + this.size)
            } else {
                // Trả về một giá trị mặc định hoặc xử lý lỗi tại đây nếu $scope.items là undefined.
                return 0;
            }
        },
        get count(){
            if ($scope.items) {
            var activeBrands = $scope.items.filter(function(brand) {
                return brand.isActive === true;
            });
            return Math.ceil(1.0 * activeBrands.length / this.size);
            } else {
                // Trả về một giá trị mặc định hoặc xử lý lỗi tại đây nếu $scope.items là undefined.
                return 0;
            }
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
    $scope.pagerHidden = {
        page: 0,
        size: 10,
        get items() {
            if ($scope.items) {
            var activeBrands = $scope.items.filter(function(brand) {
                return brand.isActive === false;
            });
            if (this.page < 0) {
                this.last();
            }
            if (this.page >= this.count) {
                this.first();
            }
            var start = this.page * this.size;
            return activeBrands.slice(start, start + this.size)
            } else {
                // Trả về một giá trị mặc định hoặc xử lý lỗi tại đây nếu $scope.items là undefined.
                return 0;
            }
        },
        get count(){
            if ($scope.items) {
            var activeBrands = $scope.items.filter(function(brand) {
                return brand.isActive === false;
            });
            return Math.ceil(1.0 * activeBrands.length / this.size);
        } else {
            // Trả về một giá trị mặc định hoặc xử lý lỗi tại đây nếu $scope.items là undefined.
            return 0;
        }
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