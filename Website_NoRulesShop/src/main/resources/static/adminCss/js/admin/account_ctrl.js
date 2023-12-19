app.service('AccountService', function () {
    var editedAccount = null;
    var alert = {
        message: '',
        visible: false
    };
    return {
        getEditedAccount: function () {
            return editedAccount;
        },
        setEditedAccount: function (account) {
            editedAccount = account;
        },
        setAlert: function (message) {
            alert.message = message;
            alert.visible = true;
        },
        getAlertMessage: function () {
            return alert.message;
        },
        getAlertVisible: function () {
            return alert.visible;
        },
        clearAlert: function () {
            alert.message = '';
            alert.visible = false;
        }

    };
});
app.controller("account_ctrl", function ($scope, $http, $location, $timeout, AccountService, $rootScope) {
    $scope.initialize = function () {
        $http.get("/rest/manage_account").then(resp => {
            $scope.items = resp.data;
        })
        $http.get("/rest/manage_account/getAccountInfo").then(resp => {
            $scope.Account = resp.data;
        })

    }

    $scope.itemToHide = null;
    $scope.setItemToHide = function (item) {
        $scope.itemToHide = item;
    }
    var params = $location.search();
    if (params.success === 'true') {
        $scope.succesAccount = AccountService.getAlertVisible();
        $scope.alerSuccess = AccountService.getAlertMessage();
        $timeout(function () {
            $scope.succesAccount = false;
            $scope.alerSuccess = "";
        }, 1000);
    }
    $scope.hidden = function (item) {
        $http.put(`/rest/manage_account/hidden/${item.account_id}`, item).then(function (resp) {
            var index = $scope.items.findIndex(p => p.account_id === item.account_id);
            $scope.items[index] = resp.data;
        })
    }
    $scope.show = function (item) {
        $http.put(`/rest/manage_account/show/${item.account_id}`, item).then(function (resp) {
            var index = $scope.items.findIndex(p => p.account_id === item.account_id);
            $scope.items[index] = resp.data;
        })
    }
    $scope.report = function (item) {
        $http.put(`/rest/manage_account/report/${item.account_id}`, item).then(function (resp) {
            var index = $scope.items.findIndex(p => p.account_id === item.account_id);
            $scope.items[index] = resp.data;
        })
    }
    $scope.edit = function (item) {
        AccountService.setEditedAccount(item);
        $location.path('/account_add');
    };
    $scope.initialize();
    $scope.pagerActive = {
        page: 0,
        size: 4,
        get items() {
            if ($scope.items && Array.isArray($scope.items)) {
                const activeItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Active');
                if (this.page < 0) {
                    this.last();
                }
                if (this.page >= this.count) {
                    this.first();
                }
                var start = this.page * this.size;
                return activeItems.slice(start, start + this.size);
            } else {
                return [];
            }
        },
        get count() {
            if ($scope.items && Array.isArray($scope.items)) {
                const activeItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Active');
                return Math.ceil(1.0 * activeItems.length / this.size);
            }
            return 0;
        },
        first() {
            this.page = 0;
        },
        last() {
            const activeItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Active');
            const totalPages = Math.ceil(activeItems.length / this.size);
            this.page = totalPages ? totalPages - 1 : 0;
        },
        next() {
            const activeItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Active');
            if (this.page < Math.ceil(1.0 * activeItems.length / this.size) - 1) {
                this.page++;
            }
        },
        prev() {
            if (this.page > 0) {
                this.page--;
            }
        }
    };
    $scope.pagerInactive = {
        page: 0,
        size: 4,
        get items() {
            if ($scope.items && Array.isArray($scope.items)) {
                const inactiveItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Inactive');

                if (this.page < 0) {
                    this.last();
                }
                if (this.page >= this.count) {
                    this.first();
                }
                var start = this.page * this.size;
                return inactiveItems.slice(start, start + this.size);
            } else {
                return [];
            }
        },
        get count() {
            if ($scope.items && Array.isArray($scope.items)) {
                const inactiveItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Inactive');
                return Math.ceil(1.0 * inactiveItems.length / this.size);
            }
            return 0;
        },
        first() {
            this.page = 0;
        },
        last() {
            const inactiveItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Inactive');
            const totalPages = Math.ceil(inactiveItems.length / this.size);
            this.page = totalPages ? totalPages - 1 : 0;
        },

        next() {
            const activeItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Inactive');
            if (this.page < Math.ceil(1.0 * activeItems.length / this.size) - 1) {
                this.page++;
            }
        },
        prev() {
            if (this.page > 0) {
                this.page--;
            }
        }
    };
    $scope.pagerSuspended = {
        page: 0,
        size: 4,
        get items() {
            if ($scope.items && Array.isArray($scope.items)) {
                const suspendedItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Suspended');

                if (this.page < 0) {
                    this.last();
                }
                if (this.page >= this.count) {
                    this.first();
                }
                var start = this.page * this.size;
                return suspendedItems.slice(start, start + this.size);
            } else {
                return [];
            }
        },
        get count() {
            if ($scope.items && Array.isArray($scope.items)) {
                const suspendedItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Suspended');
                return Math.ceil(1.0 * suspendedItems.length / this.size);
            }
            return 0;
        },
        first() {
            this.page = 0;
        },
        last() {
            const suspendedItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Suspended');
            const totalPages = Math.ceil(suspendedItems.length / this.size);
            this.page = totalPages.length ? totalPages.length - 1 : 0;
        },
        next() {
            const suspendedItems = $scope.items.filter(item => item.accountStatus && item.accountStatus.accountStatusName === 'Suspended');
            if (this.page < Math.ceil(1.0 * suspendedItems.length / this.size) - 1) {
                this.page++;
            }
        },
        prev() {
            if (this.page > 0) {
                this.page--;
            }
        }
    };
    $scope.pager = {
        page: 0,
        size: 4,
        get items() {
            if ($scope.items && Array.isArray($scope.items)) {
                if (this.page < 0) {
                    this.last();
                }
                if (this.page >= this.count) {
                    this.first();
                }
                var start = this.page * this.size;
                return $scope.items.slice(start, start + this.size);
            } else {
            }
        },
        get count() {
            if ($scope.items && $scope.items.length) {
                return Math.ceil(1.0 * $scope.items.length / this.size);
            }
        },
        first() {
            this.page = 0;
        },
        last() {
            this.page = this.count - 1;
        },
        next() {
            this.page++;
        },
        prev() {
            this.page--;
        }
    }
})
app.controller('AddAccountController', ['$scope', '$http', '$location', '$timeout', 'AccountService', '$rootScope', '$window', function ($scope, $http, $location, $timeout, AccountService, $rootScope, $window) {
    $scope.initialize = function () {
        $http.get("/rest/manage_account").then(resp => {
            $scope.items = resp.data;
        })
        $http.get("/rest/manage_account/getAccountInfo").then(resp => {
            $scope.Account = resp.data;
            $scope.form = AccountService.getEditedAccount();
            if ($scope.form && $scope.form.birthday != null) {
                $scope.form.birthday = new Date($scope.form.birthday);
            } else {
                return 0;
            }

            if ($scope.form.account_id === $scope.Account.account_id) {
                $scope.disable = true;
            }
        })
    }
    $scope.initialize();
    $scope.disable = false;
    $scope.update = function () {
        var item = angular.copy($scope.form);
        var inputFile = document.getElementById("inputFile");
        var formData = new FormData();
        if (inputFile.files.length > 0) {
            formData.append("fileName", inputFile.files[0]);
            $http.post('/rest/manage_account/upload', formData, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            }).then(function (response) {
                var data = response.data;
                var successMessage = data.message;
                var imagePath = data.imagePath;
                item.avatar_url = imagePath;
                if ($scope.myForm.$valid) {
                    $http.put(`/rest/manage_account/${item.account_id}`, item).then(function (resp) {
                        var index = $scope.items.findIndex(p => p.account_id === item.account_id);
                        $scope.items[index] = item;
                        AccountService.setAlert('Thành công!');
                        $location.path('/manage_account').search('success', 'true');
                    }).catch(error => {
                        console.log("Error", error);
                    });
                } else {
                    console.log("Error", error);
                }
            }).catch(function (error) {
                $scope.succes = "Loi tai len anh!";
                console.log("Error", error);
            });
        } else {
            if ($scope.myForm.$valid) {
                $http.put(`/rest/manage_account/${item.account_id}`, item).then(function (resp) {
                    var index = $scope.items.findIndex(p => p.account_id === item.account_id);
                    $scope.items[index] = item;
                    AccountService.setAlert('Thành công!');
                    $location.path('/manage_account').search('success', 'true');
                }).catch(error => {
                    console.log("Error", error);
                });
            } else {
            }
        }
    }
    $scope.reset = function () {
        $scope.form = {};
        $scope.disable = false;
    }
}])