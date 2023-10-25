app.controller("product_ctrl", function($scope, $http){
    $scope.classificationList1 = null;
    $scope.classificationList2 = null;
    $scope.classificationText1 ="";
    $scope.classificationText2 ="";

    $scope.showclassification1 = false;
    $scope.showclassification2 = false;

    $scope.classificationGround1 = "";
    $scope.classificationGround2 = "";


    $scope.initialize = function () {
        $scope.getBrands();
        $scope.getDirectory();
    }
    $scope.getDirectory = function (){
        $http.get("/rest/manage_directoryLv1/").then(resp => {
            $scope.directoryLv1s = resp.data
        })
    };
    $scope.getBrands = function (){
        $http.get("/rest/manage_brand").then(resp => {
            $scope.brands = resp.data
        })
    }

    $scope.getDetailInformationType = function() {
        $scope.ListDetailInfo = [];
        $scope.InformationTypes.forEach(function(informationType) {
            $http.get("/rest/manage_DetailInfo/byInfo?InfoId=" + informationType.informationTypeId).then(resp => {
                // Lưu trữ thông tin từ resp.data vào biến tạm thời tempDetailInfoList
                let tempDetailInfoList = resp.data;

                // Thêm thông tin từ tempDetailInfoList vào $scope.ListDetailInfo
                tempDetailInfoList.forEach(function(item) {
                    $scope.ListDetailInfo.push(item)
                });

                // Gán danh sách $scope.ListDetailInfo vào thuộc tính informationType
                informationType.detailInfoList = $scope.ListDetailInfo
                $scope.ListDetailInfo = [];
            });
        });
    };
    $scope.getInformationType = function (){
        $http.get("/rest/manage_info?byDirectoryLv1Id="+ $scope.SelectedDirectoryLv1.directoryLv1Id).then(resp => {
                $scope.InformationTypes = resp.data;
                $scope.getDetailInformationType();
        })

    }
    $scope.ChangeSelectedDirectoryLv1 = function (){
        $scope.getInformationType();
    }


    $scope.initialize();

    $scope.addClassificationOfGoodsOne =function (){
        $scope.showclassification1 = true;
    }

    $scope.addClassificationOfGoodsTwo = function (){
        $scope.showclassification2 = true;
    }

    $scope.changedInClassfication = function (){
        $scope.classificationList1 = $scope.classificationText1.split(",");
        $scope.classificationList2 = $scope.classificationText2.split(",");
    }

});