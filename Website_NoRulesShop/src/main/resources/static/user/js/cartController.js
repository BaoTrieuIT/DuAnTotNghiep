app.controller("cart_ctrl", function ($scope, $http) {
    $scope.init = function () {
        $http.get("/rest/paymenMethod").then(resp => {
            $scope.paymentMethods = resp.data;
        });
        $http.get("/rest/flag").then(resp => {
            let flag = resp.data;
            if (flag === true) {
                $scope.cart.clear();
            }
        });

    }
    $scope.updateStatus = function (orderId) {
        Swal.fire({
            title: "!",
            text: 'Bạn có chắc chắn muốn huỷ đơn hàng không ?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Xác nhận',
            cancelButtonText: 'Hủy'
        }).then((result) => {
            if (result.isConfirmed) {
                // $http.post('/home/order-update/' + orderId)
                Promise.all([post(orderId), reloadWithDelay(3000)])
                    .then(results => {
                        console.log("All jobs completed successfully");
                        console.log("Results:", results);
                    })
                    .catch(error => {
                        console.error("An error occurred:", error);
                    });
            }
        });
    }

    function post(orderId) {
        return new Promise((resolve, reject) => {
            $http.post('/home/order-update/' + orderId)
                .then(response => resolve(response.data))
                .catch(error => reject(error));
        });
    }

    function reloadWithDelay(delay) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                location.reload();
                resolve(); // Resolving immediately after location.reload()
            }, delay);
        });
    }

    $scope.number = 0; // Initialize index

    // ... other controller logic ...

    $scope.incrementIndex = function () {
        $scope.number++;
    };
    $scope.init();
    var $cart = $scope.cart = {
        items: [],
        minus(item, productId, quantity, categoryQuantityId) {
            const qty = 1;
            if (item.qty > 1) {
                $http.post(`/rest/categoryQuantitywhenRemove/${productId}/${categoryQuantityId}/${qty}`).then(respQuantity => {
                    item.qty--;
                    this.saveToLocalStorage();
                    location.reload()
                }).catch(error => {
                    this.showError("error", "Lỗi", "Lỗi rồi");
                    console.log(error)
                })
            } else {
                this.showError("error", "Lỗi", "Số lượng sản phẩm sai");
                return false;
            }
        },
        plus(item, productId, quantity, categoryQuantityId) {
            $http.get(`/rest/getMaxQty/${productId}/${categoryQuantityId}`).then(response => {
                const maxQty = response.data;
                const qty = 1;
                if (item && (item.qty + qty) - item.qty > maxQty) {
                    this.showError("error", "Lỗi", "Không đủ số lượng");
                    return false;
                }
                $http.post(`/rest/categoryQuantitywhenAdd/${productId}/${categoryQuantityId}/${qty}`).then(respQuantity => {
                    item.qty++;
                    console.log("AFTER", item.qty)
                    console.log("AFTER", quantity)
                    this.saveToLocalStorage();
                    location.reload()
                }).catch(error => {
                    this.showError("error", "Lỗi", "Lỗi rồi");
                    console.log(error)
                })
            });
        },
        async add(productId, quantity, categoryLv1Id, categoryLv2Id, categoryQuantityId) { // thêm sản phẩm vào giỏ hàng
            if (categoryLv1Id == null || categoryLv2Id == null) {
                this.showError("error", "Lỗi", "Vui lòng chọn kích thước và màu sắc");
                return false;
            }
            if (quantity === undefined || quantity < 1 || isNaN(quantity)) {
                this.showError("error", "Lỗi", "Vui lòng nhập số lượng");

                return false;
            }
            try {
                const maxQty = await this.getMaxQuantity(productId, categoryQuantityId);
                if (quantity > maxQty) {
                    this.showError("error", "Lỗi", "Không đủ số lượng");
                    return false;
                }
                const item = this.findCartItem(productId, categoryQuantityId);
                if (item && item.qty <= 0) {
                    if (item && item.qty + quantity > maxQty) {
                        this.showError("error", "Lỗi", "Không đủ số lượng");
                        return false;
                    }
                } else {
                    if (item && (item.qty + quantity) - item.qty > maxQty) {
                        this.showError("error", "Lỗi", "Không đủ số lượng");
                        return false;
                    }
                }
                if (item) {
                    await this.updateCartItem(item, quantity, productId, categoryQuantityId);
                } else {
                    await this.addNewItemToCart(productId, categoryLv1Id, categoryLv2Id, quantity, categoryQuantityId);
                }
                this.redirect("/home/product-details/filter", productId, categoryLv1Id, categoryLv2Id);
                location.reload()
                return true;
            } catch (error) {
                this.showError("error", "Lỗi", "Lỗi cập nhật giỏ hàng");
                console.error(error);
                return false;
            }
        },
        remove(productId, quantity, categoryQuantityId) { // xóa sản phẩm khỏi giỏ hàng
            $http.post(`/rest/categoryQuantitywhenRemove/${productId}/${categoryQuantityId}/${quantity}`).then(respQuantity => {
                const itemIndex = this.findCartItemIndex(productId, categoryQuantityId);
                this.items.splice(itemIndex, 1);
                this.saveToLocalStorage();
                location.reload()
            }).catch(error => {
                this.showError("error", "Lỗi", "Lỗi rồi");
                console.log(error)
            })
        },

        async getMaxQuantity(productId, categoryQuantityId) {
            const response = await $http.get(`/rest/getMaxQty/${productId}/${categoryQuantityId}`);
            return response.data;
        },
        findCartItemIndex(productId, categoryQuantityId) {
            return this.items.findIndex(item => item.productId === productId
                && item.categoryQuantity[0].category_quantity_id === categoryQuantityId
            );
        },
        findCartItem(productId, categoryQuantityId) {
            return this.items.find(item => item.productId === productId
                && item.categoryQuantity[0].category_quantity_id === categoryQuantityId
            );
        },

        async updateCartItem(item, quantity, productId, categoryQuantityId) {
            item.qty += quantity;
            await $http.post(`/rest/categoryQuantitywhenAdd/${productId}/${categoryQuantityId}/${quantity}`)
                .then(resp => {
                    location.reload();
                    this.saveToLocalStorage();
                })
                .catch(error => {
                        this.showError("error", "Lỗi", "Lỗi cập nhật giỏ hàng");
                        console.log(error);
                    }
                );
        },
        async addNewItemToCart(productId, categoryLv1Id, categoryLv2Id, quantity, categoryQuantityId) {
            try {
                const productResponse = await $http.get(`/rest/products/${productId}`);
                const imageResponse = await $http.get(`/rest/productImages/${productId}`);
                const categoryResponse = await $http.get(`/rest/categoryQuantity/${productId}/${categoryLv1Id}/${categoryLv2Id}`);

                await $http.post(`/rest/categoryQuantitywhenAdd/${productId}/${categoryQuantityId}/${quantity}`)
                    .then(respQuantity => {
                        productResponse.data.qty = quantity;
                        productResponse.data.categoryQuantity = categoryResponse.data;
                        productResponse.data.productImageList = imageResponse.data;
                        this.items.push(productResponse.data);
                        this.saveToLocalStorage();
                        location.reload();
                    })
                    .catch(error => {
                            this.showError("error", "Lỗi", "Lỗi thêm sản phẩm");
                            console.log(error);
                        }
                    );
            } catch (error) {
                this.showError("error", "Lỗi", "Lỗi get");
                // Handle errors as needed
            }
        },
        redirect(baseURL, productId, categoryLv1Id, categoryLv2Id) {
            const url = `${baseURL}?productId=${productId}&categoryLv1Id=${categoryLv1Id}&categoryLv2Id=${categoryLv2Id}`;
        },


        showError(icon, title, message) {
            Swal.fire({
                icon: icon,
                title: title,
                text: message,
            });
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
    $scope.flag = false;
    // $scope.cart.clear()
    $scope.order = {
        get account() {
            return {account_id: $auth.account_id}
        },
        orderTime: new Date(),
        phoneNumber: "",
        recipientName: "",
        specifiedAddress: "",
        orderNote: "",
        orderStatus: {orderStatusId: 1},
        paymentMethodId: "",
        paymentMethod: {paymentMethodId: ""},
        paymentStatus: {paymentStatusId: ""},
        totalPrice: "",
        get orderDetailList() {
            return $cart.items.map(item => {
                return {
                    product: {productId: item.productId},
                    price: item.priceNew,
                    quantity: item.qty,
                    totalPrice: $cart.amt_of(item),
                    categoryQuantity: {category_quantity_id: item.categoryQuantity[0].category_quantity_id}
                }
            });
        },
        purchase() {
            if (this.recipientName === "" && this.phoneNumber === "" && this.specifiedAddress === "") {
                Swal.fire({
                    icon: "error",
                    title: "Lỗi",
                    text: "Vui lòng điền các thông tin nhận hàng",
                });
            } else {
                this.totalPrice = $cart.amount;
                var order
                if (this.paymentMethodId === 1) {
                    this.paymentStatus = {paymentStatusId: 1};
                    this.paymentMethod = {paymentMethodId: 1};
                    order = angular.copy(this);
                    // Thực hiện đặt hàng
                    $http.post("/rest/order", order).then(resp => {
                        $cart.clear();
                        location.href = "/home/order-confirm/" + resp.data.orderId;
                    }).catch(error => {
                        Swal.fire({
                            icon: "error",
                            title: "Lỗi",
                            text: "Lỗi rồi",
                        });
                        console.log(error)
                    })
                } else if (this.paymentMethodId === 2) {
                    this.paymentStatus = {paymentStatusId: 2};
                    this.paymentMethod = {paymentMethodId: 2};
                    order = angular.copy(this);
                    // $scope.cart.clear()
                    $http.post(`/rest/payment/${this.totalPrice}`, order).then(resp => {
                        window.location.href = resp.data.paymentUrl;
                    }).catch(error => {
                        Swal.fire({
                            icon: "error",
                            title: "Lỗi",
                            text: "Lỗi rồi",
                        });
                        console.log(error)
                    })
                }
                $scope.flag.loading = true;
            }

        }
    }
})
