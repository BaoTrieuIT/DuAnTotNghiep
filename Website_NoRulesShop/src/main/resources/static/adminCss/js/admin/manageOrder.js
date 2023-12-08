app.service("order_service", function () {
    var orderId = null;
    return {
        getOrderDetail: function () {
            return orderId;
        }, setOrderDetail: function (order) {
            orderId = order;
        }
    };
})


app.controller("order_ctrl", function ($scope, $http, $location, order_service) {
    $scope.initialize = function () {
        $scope.doGetOrderAwaitingConfirm();
        $scope.doGetOrderInTransit();
        $scope.doGetOrderHasBeenShipped();
        $scope.doGetOrderDeliveryComplete();
        $scope.doGetOrderHasBeenCanceled();
    }

    $scope.orderAwatingConfirm = null;
    $scope.orderInTransit = null;
    $scope.orderHasBeenCanceled = null;
    $scope.orderHasBeenShipped = null;
    $scope.orderDeliveryComplete = null;


    $scope.doGetOrderAwaitingConfirm = function () {
        $.ajax({
            url: "/rest/order/awatingConfirm",
            method: "GET",
            success: function (data) {
                if (data.status = "Success") {
                    $scope.orderAwatingConfirm = data.data;
                } else {
                    $scope.orderAwatingConfirm = null;
                }
            }
        })
    };


    $scope.doGetOrderInTransit = function () {
        $.ajax({
            url: "/rest/order/inTransit",
            method: "GET",
            success: function (data) {
                if (data.status = "Success") {
                    $scope.orderInTransit = data.data;
                } else {
                    $scope.orderInTransit = null;
                }
            }
        })
    };


    $scope.doGetOrderHasBeenShipped = function () {
        $.ajax({
            url: "/rest/order/hasBeenShipped",
            method: "GET",
            success: function (data) {
                if (data.status = "Success") {
                    $scope.orderHasBeenShipped = data.data;
                } else {
                    $scope.orderHasBeenShipped = null;
                }
            }
        })
    };

    $scope.doGetOrderDeliveryComplete = function () {
        $.ajax({
            url: "/rest/order/deliveryComplete",
            method: "GET",
            success: function (data) {
                if (data.status = "Success") {
                    $scope.orderDeliveryComplete = data.data;
                } else {
                    $scope.orderDeliveryComplete = null;
                }
            }
        })
    };


    $scope.doGetOrderHasBeenCanceled = function () {
        $.ajax({
            url: "/rest/order/hasBeenCanceled",
            method: "GET",
            success: function (data) {
                if (data.status = "Success") {
                    $scope.orderHasBeenCanceled = data.data;
                } else {
                    $scope.orderHasBeenCanceled = null;
                }
            }
        })
    };


    $scope.showOrderDetail = function (orderId) {
        order_service.setOrderDetail(orderId);
        $location.path("/orderDetail");
    }

    $scope.updateStatus = function (orderId, statusId) {
        let status = "";
        if (statusId === 1) {
            status = "Đang chờ xác nhận";
        } else if (statusId === 2) {
            status = "Xuất kho";
        } else if (statusId === 3) {
            status = "Đang giao";
        } else if (statusId === 4) {
            status = "Đã giao";
        } else if (statusId === 5) {
            status = "Bị huỷ";
        }else{
            status = "undefine";
        }
        Swal.fire({
            title: status  + "?",
            text: 'Bạn Có Chắc Chắn Muốn Cập Nhật Trạng Thái Thành ' + status + ' Không !',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Xóa',
            cancelButtonText: 'Hủy'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: '/rest/order/updateOrderStatus?orderId=' + orderId + '&&statusId=' + statusId,
                    method : "GET",
                    success: function (data) {
                        Swal.fire(
                            'Cập Nhật Hoàn Tất!',
                            "Trạng Thái Đã Được Chuyển Thành " + status,
                            'success'
                        );
                    },
                    error: function (error) {
                        Swal.fire(
                            'Thất Bại!',
                            "Cập Nhật Trạng Thái Thất Bại",
                            'error'
                        );
                    }
                })
            }
        });
    }

    $scope.initialize();

})


app.controller("order_detail_ctrl", function ($scope, $http, $location, order_service) {
    $scope.initialize();
    $scope.orderDetails = [];


    $scope.initialize = function () {
        $scope.orderId =  order_service.getOrderDetail();
        if( $scope.orderId){
            getOrderDetails( $scope.orderId);
        }
    }

    // Hàm tính tổng totalPrice
    $scope.calculateTotalPrice = function() {
        var totalPriceSum = 0;
        angular.forEach($scope.orderDetails, function(orderDetail) {
            totalPriceSum += orderDetail.totalPrice;
        });
        return totalPriceSum;
    };

    function getOrderDetails(orderId) {
        $.ajax({
            url: `/rest/orderDetails/byOrder/${orderId}`,
            method: "GET",
            success: function (data) {
                if(data.status == "success"){
                    $scope.orderDetails = data.data;
                }else{
                    Swal.fire(
                        'Thất Bại!',
                        "Lỗi Khi Lấy Order Detail Từ Database",
                        'error'
                    );
                }
            },
            error: function (error) {
                console.log(error)
            }
        })
    }
})