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

    $scope.init();
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
        async add(productId, quantity, categoryLv1Id, categoryLv2Id) { // thêm sản phẩm vào giỏ hàng
            if (categoryLv1Id == null || categoryLv2Id == null) {
                Swal.fire({
                    icon: "error",
                    title: "Lỗi",
                    text: "Vui lòng chọn kích thước và màu sắc",
                });
                return false;
            }
            if (quantity === undefined || quantity < 1 || isNaN(quantity)) {
                Swal.fire({
                    icon: "error",
                    title: "Lỗi",
                    text: "Vui lòng nhập số lượng",
                });
                return false;
            }
            try {
                const maxQty = await this.getMaxQuantity(productId, categoryLv1Id, categoryLv2Id);
                if (quantity > maxQty) {
                    Swal.fire({
                        icon: "error",
                        title: "Lỗi",
                        text: "Không đủ số lượng",
                    });
                    return false;
                }
                const item = this.findCartItem(productId);
                if (item && item.qty <= 0) {
                    if (item && item.qty + quantity > maxQty) {
                        Swal.fire({
                            icon: "error",
                            title: "Lỗi",
                            text: "Không đủ số lượng",
                        });
                        return false;
                    }
                } else {
                    if (item && (item.qty + quantity) - item.qty > maxQty) {
                        Swal.fire({
                            icon: "error",
                            title: "Lỗi",
                            text: "Không đủ số lượng",
                        });
                        return false;
                    }
                }
                if (item) {
                    await this.updateCartItem(item, quantity, productId, categoryLv1Id, categoryLv2Id);
                } else {
                    await this.addNewItemToCart(productId, categoryLv1Id, categoryLv2Id, quantity);
                }
                this.redirect("/home/product-details/filter", productId, categoryLv1Id, categoryLv2Id);
                location.reload()
                return true;
            } catch (error) {
                Swal.fire({
                    icon: "error",
                    title: "Lỗi",
                    text: "Lỗi rồi",
                });
                console.error(error);
                return false;
            }
        },
        async getMaxQuantity(productId, categoryLv1Id, categoryLv2Id) {
            const response = await $http.get(`/rest/getMaxQty/${productId}/${categoryLv1Id}/${categoryLv2Id}`);
            return response.data;
        },
        findCartItem(productId) {
            return this.items.find(item => item.productId === productId);
        },

        async updateCartItem(item, quantity, productId, categoryLv1Id, categoryLv2Id) {
            item.qty += quantity;
            await $http.post(`/rest/categoryQuantitywhenAdd/${productId}/${categoryLv1Id}/${categoryLv2Id}/${quantity}`)
                .then(resp => {
                    location.reload();
                    this.saveToLocalStorage();
                })
                .catch(error => {
                        Swal.fire({
                            icon: "error",
                            title: "Lỗi",
                            text: "Lỗi rồi",
                        });
                        console.log(error);
                    }
                );
        },
        async addNewItemToCart(productId, categoryLv1Id, categoryLv2Id, quantity) {
            try {
                const productResponse = await $http.get(`/rest/products/${productId}`);
                const imageResponse = await $http.get(`/rest/productImages/${productId}`);
                const categoryResponse = await $http.get(`/rest/categoryQuantity/${productId}/${categoryLv1Id}/${categoryLv2Id}`);

                await $http.post(`/rest/categoryQuantitywhenAdd/${productId}/${categoryLv1Id}/${categoryLv2Id}/${quantity}`)
                    .then(respQuantity => {
                        productResponse.data.qty = quantity;
                        productResponse.data.categoryQuantity = categoryResponse.data;
                        productResponse.data.productImageList = imageResponse.data;
                        this.items.push(productResponse.data);
                        this.saveToLocalStorage();
                        location.reload();
                    })
                    .catch(error => {
                            Swal.fire({
                                icon: "error",
                                title: "Lỗi",
                                text: "Lỗi rồi",
                            });
                            console.log(error);
                        }
                    );
            } catch (error) {
                Swal.fire({
                    icon: "error",
                    title: "Lỗi",
                    text: "Lỗi rồi",
                });
                // Handle errors as needed
            }
        },
        redirect(baseURL, productId, categoryLv1Id, categoryLv2Id) {
            const url = `${baseURL}?productId=${productId}&categoryLv1Id=${categoryLv1Id}&categoryLv2Id=${categoryLv2Id}`;
        },

        remove(productId, quantity, categoryLv1Id, categoryLv2Id) { // xóa sản phẩm khỏi giỏ hàng
            var index = this.items.findIndex(item => item.productId === productId);
            this.items.splice(index, 1);
            $http.post(`/rest/categoryQuantitywhenRemove/${productId}/${categoryLv1Id}/${categoryLv2Id}/${quantity}`).then(respQuantity => {
                location.reload()
            }).catch(error => {
                Swal.fire({
                    icon: "error",
                    title: "Lỗi",
                    text: "Lỗi rồi",
                });
                console.log(error)
            })

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
