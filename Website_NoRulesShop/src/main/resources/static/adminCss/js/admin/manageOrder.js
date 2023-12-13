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
        $http.get("/rest/order_manage/awaitingConfirm").then(resp => {
            $scope.orderAwatingConfirm = resp.data;
        })
    };


    $scope.doGetOrderInTransit = function () {
        $http.get("/rest/order_manage/inTransit").then(resp => {
            $scope.orderInTransit = resp.data;
        })
    };


    $scope.doGetOrderHasBeenShipped = function () {
        $http.get("/rest/order_manage/hasBeenShipped").then(resp => {
            $scope.orderHasBeenShipped = resp.data;
        })
    };

    $scope.doGetOrderDeliveryComplete = function () {
        $http.get("/rest/order_manage/deliveryComplete").then(resp => {
            $scope.orderDeliveryComplete = resp.data;
        })
    };


    $scope.doGetOrderHasBeenCanceled = function () {
        $http.get("/rest/order_manage/hasBeenCanceled").then(resp => {
            $scope.orderHasBeenCanceled = resp.data;
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
        } else {
            status = "undefine";
        }
        Swal.fire({
            title: status + "?",
            text: 'Bạn Có Chắc Chắn Muốn Cập Nhật Trạng Thái Thành ' + status + ' Không !',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Xác nhận',
            cancelButtonText: 'Hủy'
        }).then((result) => {
            if (result.isConfirmed) {
                $http.get('/rest/order_manage/updateOrderStatus', {
                    params: {
                        orderId: orderId,
                        statusId: statusId
                    }
                }).then(
                    (resp) => {
                        Swal.fire(
                            'Cập Nhật Hoàn Tất!',
                            "Trạng Thái Đã Được Chuyển Thành " + status,
                            'success',
                        );
                        location.reload();
                    },
                    (error) => {
                        Swal.fire(
                            'Thất Bại!',
                            "Cập Nhật Trạng Thái Thất Bại",
                            'error'
                        );
                    }
                )
            }
        });
    }

    $scope.initialize();

})


app.controller("order_detail_ctrl", function ($scope, $http, $location, order_service) {

    $scope.initialize = function () {

        $.ajax({
            url: `/rest/orderDetails/byOrder/${order_service.getOrderDetail()}`,
            method: "GET",
            success: function (data) {
                if (data.status == "success") {
                    let html = "";
                    data.data.forEach(orderDetail => {
                        html += `
                                <tr>
                                    <td class="Name">${orderDetail.product.productName}</td>
                                    <td class="Other">${orderDetail.price.toLocaleString('vi-VN', {
                            style: 'currency',
                            currency: 'VND'
                        })}</td>
                                    <td class="Other">${orderDetail.quantity}</td>
                                    <td class="Other">${orderDetail.totalPrice.toLocaleString('vi-VN', {
                            style: 'currency',
                            currency: 'VND'
                        })}</td>
                                </tr>
                            `;
                    })
                    document.getElementById("table-body").innerHTML = html;
                    let totalPriceSum = 0;
                    data.data.forEach(orderDetail => {
                        totalPriceSum += orderDetail.totalPrice;
                    });

                    const formattedTotalPrice = totalPriceSum.toLocaleString('vi-VN', {
                        style: 'currency',
                        currency: 'VND'
                    });
                    document.getElementById("totalPrice").innerHTML = formattedTotalPrice;

                } else {
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
        });
    }

    // Hàm tính tổng totalPrice
    $scope.calculateTotalPrice = function () {
        return totalPriceSum;
    };
    $scope.initialize();
})