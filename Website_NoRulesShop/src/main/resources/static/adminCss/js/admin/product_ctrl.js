// app.controller("product_ctrl", function($scope, $http){
//
//     $scope.minValue = 0;
//     $scope.maxValue = 10000000;
//
//     $scope.initialize = function () {
//         $scope.renderProductIsActive();
//     }
//     $scope.SearchByName = function (productName){
//         switch ($scope.itemType){
//             case "hidden":
//                 $http.get("/rest/product_all/searchByNameProductHidden?productName="+productName+"&min="+$scope.minValue +"&max="+$scope.maxValue).then(resp => {
//                     $scope.items = resp.data
//                 })
//                 break;
//             case "active":
//                 $http.get("/rest/product_all/searchByNameProductOnline?productName="+productName+"&min="+$scope.minValue +"&max="+$scope.maxValue ).then(resp => {
//                     $scope.items = resp.data
//                 })
//                 break;
//             case "soldout":
//                 $http.get("/rest/product_all/searchByNameProductSoldout?productName="+productName+"&min="+$scope.minValue +"&max="+$scope.maxValue ).then(resp => {
//                     $scope.items = resp.data
//                 })
//                 break;
//         }
//     }
//
//     const rangeInput = document.querySelectorAll(".range-input input"),
//         priceInput = document.querySelectorAll(".price-input input"),
//         range = document.querySelector(".slider .progress");
//     let priceGap = 1000;
//
//     priceInput.forEach(input =>{
//         input.addEventListener("input", e =>{
//             let minPrice = parseInt(priceInput[0].value),
//                 maxPrice = parseInt(priceInput[1].value);
//
//             if((maxPrice - minPrice >= priceGap) && maxPrice <= rangeInput[1].max){
//                 if(e.target.className === "input-min"){
//                     rangeInput[0].value = minPrice;
//                     range.style.left = ((minPrice / rangeInput[0].max) * 1000) + "%";
//                 }else{
//                     rangeInput[1].value = maxPrice;
//                     range.style.right = 1000 - (maxPrice / rangeInput[1].max) * 1000 + "%";
//                 }
//             }
//         });
//     });
//
//     rangeInput.forEach(input =>{
//         input.addEventListener("input", e =>{
//             let minVal = parseInt(rangeInput[0].value),
//                 maxVal = parseInt(rangeInput[1].value);
//
//             if((maxVal - minVal) < priceGap){
//                 if(e.target.className === "range-min"){
//                     rangeInput[0].value = maxVal - priceGap
//                 }else{
//                     rangeInput[1].value = minVal + priceGap;
//                 }
//             }else{
//                 priceInput[0].value = minVal;
//                 priceInput[1].value = maxVal;
//                 range.style.left = ((minVal / rangeInput[0].max) * 1000) + "%";
//                 range.style.right = 1000 - (maxVal / rangeInput[1].max) * 1000 + "%";
//             }
//         });
//     });
//     //
//     // $scope.changeTabContent =  function (TabPaneName){
//     //     switch (TabPaneName) {
//     //         case "hidden":
//     //             break;
//     //         case "activity":
//     //             break;
//     //         case "sold_out":
//     //             break;
//     //     }
//     // }
//     $scope.renderProductIsHidden = function (){
//         $http.get("/rest/product_all/isHidden").then(resp => {
//             $scope.items = resp.data
//             $scope.itemType = "hidden";
//         })
//     }
//     $scope.renderProductIsActive = function (){
//         $http.get("/rest/product_all/isActive").then(resp => {
//             $scope.items = resp.data
//             $scope.itemType = "active";
//         })
//     }
//     $scope.renderProductIsSoldOut = function (){
//         $http.get("/rest/product_all/isSoldOut").then(resp => {
//             $scope.items = resp.data
//             $scope.itemType = "soldout";
//
//         })
//     }
//     $scope.HiddenProDuct = function (productId){
//             $http.get("/rest/product_all/hiddenProduct?productId="+productId).then(resp => {
//                 $scope.items = resp.data
//             }).catch(error => {
//             })
//
//     }
//     $scope.ActiveProduct = function (productId){
//             $http.get("/rest/product_all/activeProduct?productId="+productId).then(resp => {
//                 $scope.items = resp.data
//             }).catch(error => {
//             })
//         }
//
//
//     $scope.initialize();
//     $scope.pager = {
//         page: 0,
//         size: 3,
//         get items() {
//             if (this.page < 0) {
//                 this.last();
//             }
//             if (this.page >= this.count) {
//                 this.first();
//             }
//             var start = this.page * this.size;
//             return $scope.items.slice(start, start + this.size)
//         },
//         get count() {
//             return Math.ceil(1.0 * $scope.items.length / this.size);
//         },
//         first() {
//             this.page = 0;
//         },
//         last() {
//             this.page = this.count - 1;
//         },
//         next() {
//             this.page++;
//         },
//         prev() {
//             this.page--;
//         }
//     }
//
//
// });
//
//
//
