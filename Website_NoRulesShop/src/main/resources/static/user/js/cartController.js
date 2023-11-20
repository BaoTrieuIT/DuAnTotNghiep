app.controller("cart_ctrl", function ($scope, $http) {
    var $cart = $scope.cart = {
        items: [],
        add(productId) { // thêm sản phẩm vào giỏ hàng
            this.qty = 1;
            var maxQty = 0;
            // var quantity = this.qty;
            var item = this.items.find(item => item.productId === productId);
            if (item) {
                $http.get(`/rest/getMaxQty/${productId}`).then(response => {
                    // Assuming the server returns the maxQty value
                    maxQty = response.data;
                    if (item.qty >= maxQty || this.qty >= maxQty) {
                        alert("Không đủ số lượng");
                        return false;
                    }
                    item.qty += this.qty;
                    this.saveToLocalStorage();
                }).catch(error => {
                    console.error('Error fetching maxQty:', error);
                });

            } else {
                $http.get(`/rest/products/${productId}`).then(resp => {
                    $http.get(`/rest/productImages/${productId}`).then(respImage => {
                        resp.data.qty = 1;
                        resp.data.productImageList = respImage.data;
                        this.items.push(resp.data);
                        this.saveToLocalStorage();
                    })
                });
            }
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

            return item.priceMin * item.qty;
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
    $scope.decrementQty = function (item) {
        if (item.qty > 0) {
            item.qty--;
        }
        $cart.saveToLocalStorage();
    };

    $scope.incrementQty = function (item) {
        item.qty++;
        $cart.saveToLocalStorage();
    };
    $cart.loadFromLocalStorage();
    // Đặt hàng
    $scope.order = {
        get account() {
            return {username: $auth.user.username}
        },
        createDate: new Date(),
        sdt: "",
        address: "",
        get orderDetails() {
            return $cart.items.map(item => {
                return {
                    product: {id: item.id},
                    price: item.price,
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
