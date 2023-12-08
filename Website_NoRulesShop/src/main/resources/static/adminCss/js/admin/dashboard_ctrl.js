app.controller("dashboard_ctrl", function ($scope, $http, $rootScope) {
    $scope.initialize = function () {
        var timeCustomer = "customer_today";
        var timeRevenue = "revenue_today";
        var timeSales = "sales_today";
        $scope.cardTitleRevenue = "Hôm nay";
        $scope.cardTitleSales = "Hôm nay";
        $scope.cardTitleCustomer = "Hôm nay"; // Default

        $http.get(`/rest/dashboard/customers/${timeCustomer}`).then(resp => {
            $scope.customers = resp.data;
        })

        $http.get(`/rest/dashboard/sales/${timeSales}`).then(resp => {
            $scope.sales = resp.data;
        })

        $http.get(`/rest/dashboard/revenue/${timeRevenue}`).then(resp => {
            $scope.revenue = resp.data;
        })
    }

    $scope.updateCardTitle = function () {
        var timeString = $scope.selectedFilter;
        switch ($scope.selectedFilter) {
            // Revenue
            case "revenue_today":
                $scope.cardTitleRevenue = "Hôm nay";
                $http.get(`/rest/dashboard/revenue/${timeString}`).then(resp => {
                    $scope.revenue = resp.data;
                })
                break;
            case "revenue_month":
                $scope.cardTitleRevenue = "Tháng này";
                $http.get(`/rest/dashboard/revenue/${timeString}`).then(resp => {
                    $scope.revenue = resp.data;
                })
                break;
            case "revenue_year":
                $scope.cardTitleRevenue = "Năm nay";
                $http.get(`/rest/dashboard/revenue/${timeString}`).then(resp => {
                    $scope.revenue = resp.data;
                })
                break;
            //     Sales
            case "sales_today":
                $scope.cardTitleSales = "Hôm nay";
                $http.get(`/rest/dashboard/sales/${timeString}`).then(resp => {
                    $scope.sales = resp.data;
                })
                break;
            case "sales_month":
                $scope.cardTitleSales = "Tháng này";
                $http.get(`/rest/dashboard/sales/${timeString}`).then(resp => {
                    $scope.sales = resp.data;
                })
                break;
            case "sales_year":
                $scope.cardTitleSales = "Năm nay";
                $http.get(`/rest/dashboard/sales/${timeString}`).then(resp => {
                    $scope.sales = resp.data;
                })
                break;
            //     Customerv
            case "customer_today":
                $scope.cardTitleCustomer = "Hôm nay";
                $http.get(`/rest/dashboard/customers/${timeString}`).then(resp => {
                    $scope.customers = resp.data;
                })
                break;
            case "customer_month":
                $scope.cardTitleCustomer = "Tháng này";
                $http.get(`/rest/dashboard/customers/${timeString}`).then(resp => {
                    $scope.customers = resp.data;
                })
                break;
            case "customer_year":
                $scope.cardTitleCustomer = "Năm nay";
                $http.get(`/rest/dashboard/customers/${timeString}`).then(resp => {
                    $scope.customers = resp.data;
                })
                break;
            default:
                $scope.cardTitleRevenue = "Hôm nay";
                $scope.cardTitleCustomer = "Hôm nay"; // Default
                $scope.cardTitleSales = "Hôm nay"; // Default
        }


    };

    $scope.selectFilter = function (filter) {
        $scope.selectedFilter = filter;
        $scope.updateCardTitle();
    };
    var chart = new ApexCharts(document.querySelector("#columnChart"), {
        series: [{
            name: 'Doanh thu',
            data: [123.423, 440.523, 523.451, 745.223, 234.523, 235.234, 534.433, 252.352, 235.232]
        }],
        chart: {
            type: 'bar',
            height: 350
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '55%',
                endingShape: 'rounded'
            },
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            colors: ['transparent']
        },
        xaxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
        yaxis: {
            title: {
                text: 'Vietnam đồng'
            }
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            y: {
                formatter: function (val) {
                    return "đ " + val
                }
            }
        }
    });

    // Render the chart
    chart.render();
    $scope.initialize();
})
app.filter('vndFormat', function () {
    return function (input) {
        // Check if input is defined and numeric
        if (typeof input === 'undefined' || isNaN(input)) {
            return 'Invalid Revenue';
        }

        // Format input as VND with commas
        var formattedRevenue = input.toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});

        // Replace the decimal comma with a dot
        formattedRevenue = formattedRevenue.replace(/,/g, '.');

        // Remove the trailing '₫'
        formattedRevenue = formattedRevenue.replace(/₫/g, '');

        return formattedRevenue + 'đ';
    };


});
