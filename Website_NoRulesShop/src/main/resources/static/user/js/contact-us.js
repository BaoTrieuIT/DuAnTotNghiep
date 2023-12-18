function sendContactInformation() {
    // lấy thông tin -> gửi thông đến email đươc chọn qua api/contact-us/sendMailContactUs
    getData().then((contactUsForm)=>{
        $.ajax({
            url: "/api/contact-us/sendMailContactUs",
            method: "POST", // Sử dụng phương thức POST
            data: JSON.stringify(contactUsForm), // Chuyển đổi dữ liệu sang JSON string
            contentType: "application/json", // Chỉ định kiểu dữ liệu
            success: function (data) {
                Swal.fire({
                    icon: 'success',
                    title: 'Gửi Thành Công!',
                    text: 'Thông tin đã được gửi thành công.',
                    confirmButtonText: 'OK'
                    // Các tùy chọn khác tại đây nếu cần
                });
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Gửi Thất Bại!',
                    text: 'Đã xảy ra lỗi khi gửi thông tin. Vui lòng thử lại sau.',
                    confirmButtonText: 'OK'
                    // Các tùy chọn khác tại đây nếu cần
                });
            }
        })
    })
}



function getData() {
    return new Promise((resolve, reject)=>{
        let firstName = document.getElementById("firstname").value;
        let lastName = document.getElementById("lastname").value;
        let email = document.getElementById("email").value;
        // let subject = document.getElementById("subject").value;
        let message = document.getElementById("message").value;


        let contactUsForm = {
            firstname: firstName,
            lastname: lastName,
            email: email,
            // subject: subject,
            message: message
        }
        resolve(contactUsForm);
    })
}