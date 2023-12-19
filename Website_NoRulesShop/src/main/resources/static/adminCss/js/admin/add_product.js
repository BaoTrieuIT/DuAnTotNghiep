app.controller("product_ctrl", function ($scope, $http) {
    $scope.classificationList1 = null;
    $scope.classificationList2 = null;
    $scope.classificationText1 = "";
    $scope.classificationText2 = "";

    $scope.showclassification1 = false;
    $scope.showclassification2 = false;

    $scope.classificationGround1 = "Màu Sắc";
    $scope.classificationGround2 = "Size";

    $scope.CategoryPriceArr = [];
    $scope.CategoryQuantityArr = [];
    $scope.CategorDiscountArr = [];

    $scope.categoryLv1Details = [];
    $scope.categoryLv2Details = [];

    $scope.prices = [];
    $scope.quantities = [];
    $scope.discounts = [];


    $scope.initialize = function () {
        $scope.getBrands();
        $scope.getDirectory();
    }
    $scope.getDirectory = function () {
        $http.get("/rest/manage_directoryLv1/isActive").then(resp => {
            $scope.directoryLv1s = resp.data
        })
    };

    $scope.getBrands = function () {
        $http.get("/rest/manage_brand").then(resp => {
            $scope.brands = resp.data
        })
    }

    $scope.getDetailInformationType = function () {
        $scope.ListDetailInfo = [];
        $scope.InformationTypes.forEach(function (informationType) {
            $http.get("/rest/manage_DetailInfo/byInfo?InfoId=" + informationType.informationTypeId).then(resp => {
                // Lưu trữ thông tin từ resp.data vào biến tạm thời tempDetailInfoList
                let tempDetailInfoList = resp.data;

                // Thêm thông tin từ tempDetailInfoList vào $scope.ListDetailInfo
                tempDetailInfoList.forEach(function (item) {
                    $scope.ListDetailInfo.push(item)
                });

                // Gán danh sách $scope.ListDetailInfo vào thuộc tính informationType
                informationType.detailInfoList = $scope.ListDetailInfo
                $scope.ListDetailInfo = [];
            });
        });
    };

    $scope.getInformationType = function () {
        $http.get("/rest/manage_info?byDirectoryLv1Id=" + $scope.ProductDirectory.directoryLv1Id).then(resp => {
            $scope.InformationTypes = resp.data;
            $scope.getDetailInformationType();
        })

    }

    $scope.ChangeSelectedDirectoryLv1 = function () {
        $scope.getInformationType();
    }


    $scope.initialize();

    $scope.addClassificationOfGoodsOne = function () {
        $scope.showclassification1 = true;
    }

    $scope.addClassificationOfGoodsTwo = function () {
        $scope.showclassification2 = true;
    }

    $scope.changedInClassfication = function () {
        $scope.classificationList1 = $scope.classificationText1.split(",");
        $scope.classificationList2 = $scope.classificationText2.split(",");
    }


    $scope.productImagesChanged = function (element) {
        $scope.productImages = element.files;
    }

    $scope.submit = async function () {
        try {
            const isValidProductInfo = await $scope.validateProductInformation();

            if (isValidProductInfo) {
                await $scope.addProduct();
                if ($scope.showclassification1) {
                    await $scope.addProductImages();
                    await $scope.addCategoryLv1();
                    await $scope.addCategoryLv2();
                    await $scope.addCategoryLv1Detail();
                    await $scope.addCategoryLv2Detail();
                    await $scope.addCategoryQuantity();
                    await $scope.setTotalQuantity();
                }
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Thêm Thành Công Sản Phẩm",
                    showConfirmButton: false,
                    timer: 1500
                });
            } else {
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Thông Tin Sản Phẩm Không Hợp Lệ",
                    showConfirmButton: false,
                    timer: 1500
                });
            }
        } catch (error) {
            console.error("Đã xảy ra lỗi:", error);
        }
    };

    $scope.addProduct = function () {
        return $http.post("/api/product/addProduct"
            + "?productName=" + $scope.productName + "&&productBrandId=" + $scope.productBrand.brandId + "&&productDirectoryId=" + $scope.ProductDirectory.directoryLv1Id + "&&productDescription=" + $scope.productDescription + "&&productDiscount=" + $scope.productDiscount + "&&productPrice=" + $scope.productPrice + "&&productTotalQuantity=" + $scope.productQuantity
        ).then(function (response) {
                $scope.addingProduct = response.data;
            },
            function (error) {
                console.error('Lỗi khi thêm sản phẩm:', error);
            })
    }


    $scope.addProductImages = function () {
        let formData = new FormData();
        for (let i = 0; i < $scope.productImages.length; i++) {
            formData.append('files', $scope.productImages[i]);
        }

        return $http.post('/api/product/addProductImages', formData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .then(function (response) {

            })
            .catch(function (error) {
                console.error('Lưu tệp tin thất bại:', error);
                throw error; // Ném lỗi để catch ở hàm submit
            });
    };
    // $scope.ChangeEvent=  function (){

    // }

    $scope.addProductInformationType = function () {
        let promises = $scope.InformationTypes.map(function (informationType) {
            return $http.post("/api/product/addProductInfo?value=" + informationType.selectedValue.detailInformationTypeName + "&&infomationTypeId=" + informationType.informationTypeId)
                .then(function (response) {
                    console.log(response.data);
                    // Xử lý sau khi request thành công
                })
                .catch(function (error) {
                    console.error(error.data);
                    throw error; // Ném lỗi để catch ở hàm submit
                });
        });
        return Promise.all(promises);
    };

    $scope.addCategoryLv1 = function () {
        return $http.post("/api/product/addCategoryLv1?categoryName=" + $scope.classificationGround1)
            .then(function (response) {
                $scope.categorylv1 = response.data;
                // Xử lý sau khi request thành công
            })
            .catch(function (error) {
                console.error(error.data);
                throw error; // Ném lỗi để catch ở hàm submit
            });
    };
    $scope.addCategoryLv2 = function () {
        return $http.post("/api/product/addCategoryLv2?categoryName=" + $scope.classificationGround2)
            .then(function (response) {
                $scope.categorylv2 = response.data;
                // Xử lý sau khi request thành công
            })
            .catch(function (error) {
                console.error(error.data);
                throw error; // Ném lỗi để catch ở hàm submit
            });
    };


    $scope.addCategoryLv1Detail = function () {
        let categoryLv1Details = $scope.classificationList1.map(function (item) {
            return item;
        });
        return $http.post("/api/product/addCategoryLv1_Detail", {categoryLv1Details: categoryLv1Details})
            .then(
                function (response) {
                    $scope.categoryLv1Details = response.data;
                    // Xử lý sau khi request thành công
                }
            )
            .catch(function (error) {
                console.error(error.data);
                throw error; // Ném lỗi để catch ở hàm submit
            });
    };

    $scope.addCategoryLv2Detail = function () {
        let categoryLv2Details = $scope.classificationList2.map(function (item) {
            return item;
        });
        return $http.post("/api/product/addCategoryLv2_Detail", {categoryLv2Details: categoryLv2Details})
            .then(
                function (response) {
                    $scope.categoryLv2Details = response.data;
                    // Xử lý sau khi request thành công
                }
            )
            .catch(function (error) {
                console.error(error.data);
                throw error; // Ném lỗi để catch ở hàm submit
            });
    };


    $scope.addCategoryQuantity = function () {
        $scope.categoryLv1Details.forEach(categoryLv1Detail => {
            $scope.categoryLv2Details.forEach(categoryLv2Detail => {
                let index = $scope.categoryLv1Details.indexOf(categoryLv1Detail) * $scope.categoryLv2Details.length + $scope.categoryLv2Details.indexOf(categoryLv2Detail);

                // Tạo đối tượng CategoryQuantityDTO từ dữ liệu trong AngularJS
                let categoryQuantityDTO = {
                    categoryLevel1Detail: categoryLv1Detail,
                    categoryLevel2Detail: categoryLv2Detail,
                    quantity: $scope.quantities[index],
                };

                $http.post("/api/product/addCategoryQuantity", categoryQuantityDTO)
                    .then(function (response) {
                    })
                    .catch(function (error) {
                        // Xử lý lỗi nếu có
                        console.error(error);
                    });
            });
        });
    };

    $scope.setTotalQuantity = function () {
        $scope.totalQuantity = $scope.quantities.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
        let totalQuantity = $scope.totalQuantity;
        $http.post("/api/product/setTotalQuantity?totalQuantity=" + totalQuantity)
            .then(function (response) {
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Thêm Thành Công Sản Phẩm",
                    showConfirmButton: false,
                    timer: 1500
                });
            }).catch(function (error) {
            // Xử lý lỗi nếu có
            console.error(error);
        });
    }


    $scope.validateProductInformation = function () {
        return new Promise((resolve, reject) => {
            validateBasicInformation()
                .then(resultBasic => {
                    if (!resultBasic) {
                        resolve(false);
                    } else {
                        validatePurchaseInformation().then(resultPurchase => {
                            resolve(resultPurchase);
                        }).catch(e => {
                            console.error(e);
                            resolve(false);
                        });
                    }
                }).catch(e => {
                console.error(e);
                resolve(false);
            });
        });
    }


    function validateBasicInformation() {
        return new Promise((resolve, reject) => {
            try {
                let isProductImageValid = validateAndReturnResult(document.getElementById("product-image-input"));
                let isProductNameValid = validateAndReturnResult(document.getElementById("product-name"));
                let isProductPriceValid = validateAndReturnResult(document.getElementById("product-price"));
                let isProductDiscountValid = validateAndReturnResult(document.getElementById("product-discount"));
                let isProductBrandValid = validateAndReturnResult(document.getElementById("product-brand"));
                let isProductDirectoryLv1Valid = validateAndReturnResult(document.getElementById("product-directory-lv1"));
                let isProductDirectoryDescriptionValid = validateAndReturnResult(document.getElementById("product-description"));
                let isProductQuantity = validateAndReturnResult(document.getElementById("product-quantity"));
                let result = isProductImageValid && isProductNameValid && isProductPriceValid && isProductDiscountValid && isProductBrandValid && isProductDirectoryLv1Valid && isProductDirectoryDescriptionValid && isProductQuantity;
                resolve(result);
            } catch (e) {
                console.error(e);
                resolve(false);
            }
        });
    }

    function validatePurchaseInformation() {
        return new Promise((resolve, reject) => {
            validateCategoryQuantities().then(resultQuantities => {
                if (!resultQuantities) {
                    resolve(false);
                } else {
                    validateCategoryGroup().then(resultGroup => {
                        resolve(resultGroup);
                    }).catch(e => {
                        console.error(e);
                        resolve(false);
                    });
                }
            }).catch(e => {
                console.error(e);
                resolve(false);
            });
        });
    }

    function validateCategoryQuantities() {
        return new Promise((resolve, reject) => {
            try {
                let result = true;
                let categoryQuantitiesInputs = document.querySelectorAll(".category-quantity");
                categoryQuantitiesInputs.forEach(categoryQuantityInput => {
                    if (categoryQuantityInput.value == '') {
                        categoryQuantityInput.style.borderColor = "red";
                        result = false;
                    }
                })
                resolve(result);
            } catch (e) {
                reject(e);
            }
        })
    }

    function validateCategoryGroup() {
        return new Promise((resolve, reject) => {
            let group1 = document.getElementById("classificationGround1");
            let group2 = document.getElementById("classificationGround2");
            let list1 = document.getElementById("classificationText1");
            console.log(list1);
            let list2 = document.getElementById("classificationText2");
            console.log(list2)

            if ($scope.showclassification1) {
                if (group1.value == '') {
                    group1.style.borderColor = "red";
                    resolve(false);
                } else {
                    group1.style.borderColor = "green";
                }
                if (list1.value == '') {
                    list1.style.borderColor = "red";
                    resolve(false);
                } else {
                    list1.style.borderColor = "green";
                }
                if ($scope.showclassification2) {
                    if (group2.value == '') {
                        group2.style.borderColor = "red";
                        resolve(false);
                    } else {
                        group2.style.borderColor = "green";
                    }

                    if (list2.value == '') {
                        list2.style.borderColor = "red";
                        resolve(false);
                    } else {
                        list2.style.borderColor = "green";
                    }
                }
            }
            resolve(true);
        })
    }

    function validateAndReturnResult(input) {
        const validationResult = validateInput(input);
        return validationResult.valid;
    }

});




