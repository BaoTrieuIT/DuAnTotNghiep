// app.controller("order_ctrl", function ($scope, $http) {
//     $scope.initialize = function () {
//         $scope.doGetOrderAwaitingConfirm();
//         $scope.doGetOrderInTransit();
//         $scope.doGetOrderHasBeenShipped();
//         $scope.doGetOrderDeliveryComplete();
//         $scope.doGetOrderHasBeenCanceled();
//     }
//
//     $scope.orderAwatingConfirm = null;
//     $scope.orderInTransit = null;
//     $scope.orderHasBeenCanceled = null;
//     $scope.orderHasBeenShipped = null;
//     $scope.orderDeliveryComplete = null;
//
//
//     $scope.doGetOrderAwaitingConfirm = function () {
//         $.ajax({
//             url: "/rest/order/ awatingConfirm",
//             method: "GET",
//             success: function (data) {
//                 alert("here");
//                 if (data.status = "Success") {
//                     $scope.orderAwatingConfirm = data.data;
//                 } else {
//                     $scope.orderAwatingConfirm = null;
//                 }
//             }
//         })
//     };
//
//
//     $scope.doGetOrderInTransit = function () {
//         $.ajax({
//             url: "/rest/order/inTransit",
//             method: "GET",
//             success: function (data) {
//                 if (data.status = "Success") {
//                     $scope.orderInTransit = data.data;
//                 } else {
//                     $scope.orderInTransit = null;
//                 }
//             }
//         })
//     };
//
//
//     $scope.doGetOrderHasBeenShipped = function () {
//         $.ajax({
//             url: "/rest/order/hasBeenShipped",
//             method: "GET",
//             success: function (data) {
//                 if (data.status = "Success") {
//                     $scope.orderHasBeenCanceled = data.data;
//                 } else {
//                     $scope.orderHasBeenShipped = null;
//                 }
//             }
//         })
//     };
//
//     $scope.doGetOrderDeliveryComplete = function () {
//         $.ajax({
//             url: "/rest/order/deliveryComplete",
//             method: "GET",
//             success: function (data) {
//                 if (data.status = "Success") {
//                     $scope.orderDeliveryComplete = data.data;
//                 } else {
//                     $scope.orderDeliveryComplete = null;
//                 }
//             }
//         })
//     };
//
//
//     $scope.doGetOrderHasBeenCanceled = function () {
//         $.ajax({
//             url: "/rest/order/hasBeenCanceled",
//             method: "GET",
//             success: function (data) {
//                 if (data.status = "Success") {
//                     $scope.orderHasBeenCanceled = data.data;
//                 } else {
//                     $scope.orderHasBeenCanceled = null;
//                 }
//             }
//         })
//     };
//     $scope.initialize();
// })