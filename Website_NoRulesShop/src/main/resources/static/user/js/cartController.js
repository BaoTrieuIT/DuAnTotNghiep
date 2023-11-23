app.controller("cart_ctrl", function ($scope, $http) {
    var $cart = $scope.cart = {
        items: [],
        minus(item) {
            if (item.qty > 1) {
                item.qty--;
                this.saveToLocalStorage();
            }
        },
        plus(item) {
            var maxQty = 0;
            $http.get(`/rest/getMaxQty/${item.productId}/${item.categoryQuantity.categoryLevel1Detail.category_level_1_detail_id}/${item.categoryQuantity.categoryLevel2Detail.category_level_2_detail_id}`).then(response => {
                maxQty = response.data;
                if (item.qty < maxQty) {
                    item.qty++;
                    this.saveToLocalStorage();
                }
            });
        },
        add(productId, quantity, categoryLv1Id, categoryLv2Id) { // thêm sản phẩm vào giỏ hàng
            if (categoryLv1Id == null || categoryLv2Id == null) {
                alert("Vui lòng chọn kích thước và màu sắc");
                return false;
            }
            if (quantity === undefined || quantity < 1 || isNaN(quantity)) {
                alert("Vui lòng nhập số lượng");
                return false;
            }
            var maxQty = 0;
            // var quantity = this.qty;
            var item = this.items.find(item => item.productId === productId);
            $http.get(`/rest/getMaxQty/${productId}/${categoryLv1Id}/${categoryLv2Id}`).then(response => {
                // Assuming the server returns the maxQty value
                maxQty = response.data;
                if (quantity > maxQty) {
                    alert("Không đủ số lượng");
                    return false;
                }
                if (item) {
                    if (item.qty + quantity > maxQty) {
                        alert("Không đủ số lượng");
                        return false;
                    }
                    item.qty += quantity;
                    this.saveToLocalStorage();
                } else {
                    $http.get(`/rest/products/${productId}`).then(resp => {
                        $http.get(`/rest/productImages/${productId}`).then(respImage => {
                            $http.get(`/rest/categoryQuantity/${productId}/${categoryLv1Id}/${categoryLv2Id}`).then(respCategory => {
                                resp.data.qty = quantity;
                                resp.data.categoryQuantity = respCategory.data;
                                resp.data.productImageList = respImage.data;
                                console.log(resp.data);
                                this.items.push(resp.data);
                                this.saveToLocalStorage();
                            })
                        })
                    });
                }
            })

        },
        remove(productId) { // xóa sản phẩm khỏi giỏ hàng
            var index = this.items.findIndex(item => item.productId === productId);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        clear() { // Xóa sạch các mặt hàng trong giỏ
            this.items = []
            this.saveToLocalStorage();
        },
        amt_of(item) { // tính thành tiền của 1 sản phẩm

            return item.priceNew * item.qty;
        },
        get count() { // tính tổng số lượng các mặt hàng trong giỏ
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount() { // tổng thành tiền các mặt hàng trong giỏ
            return this.items
                .map(item => this.amt_of(item))
                .reduce((total, amt) => total += amt, 0);
        },
        saveToLocalStorage() { // lưu giỏ hàng vào local storage
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage() { // đọc giỏ hàng từ local storage
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }

    }
    $scope.countCartItems = function () {
        var totalCount = 0;

        angular.forEach($scope.cart.items, function (item) {
            totalCount += item.qty;
        });

        return totalCount;
    };
    $cart.loadFromLocalStorage();
    // Đặt hàng
    $scope.order = {
        get account() {
            return {username: $auth.user.username}
        },
        orderTime: new Date(),
        phoneNumber: "",
        recipientName: "",
        specifiedAddress: "",
        orderNote: "",
        get orderDetails() {
            return $cart.items.map(item => {
                return {
                    product: {productId: item.productId},
                    priceNew: item.priceNew,
                    quantity: item.qty
                }
            });
        },
        purchase() {
            var order = angular.copy(this);
            // Thực hiện đặt hàng
            $http.post("/rest/orders", order).then(resp => {
                alert("Đặt hàng thành công!");
                $cart.clear();
                location.href = "/home/order-detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng lỗi!")
                console.log(error)
            })
        }
    }
})

$(document).ready(function () {
});