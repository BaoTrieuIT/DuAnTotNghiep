function sendContactInformation() {
    // Sử dụng Promise
    validateInformation()
        .then(() => {
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
        })
        .catch((errorMessages) => {
            let resultComponent = document.getElementById("result");
            resultComponent.innerHTML = ""; // Xóa thông báo lỗi cũ trước khi hiển thị mới

            errorMessages.forEach((errorMessage) => {
                resultComponent.innerHTML += `<p>${errorMessage}</p>`;
            });
        });
}



function getData() {
    return new Promise((resolve, reject)=>{
        let firstName = document.getElementById("firstname").value;
        let lastName = document.getElementById("lastname").value;
        let email = document.getElementById("email").value;
        // let subject = document.getElementById("subject").value;
        let message = document.getElementById("message").value;

        if (firstName === '' || lastName === '' || email === '' || message === '') {
            alert('Please fill in all fields.');
            return false;
        }

        // Email validation using a regular expression
        const emailRegex = /\S+@\S+\.\S+/;
        if (!emailRegex.test(email)) {
            alert('Please enter a valid email address.');
            return false;
        }

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


function validateInformation() {
    return new Promise((resolve, reject) => {
        let firstName = document.getElementById("firstname").value;
        let lastName = document.getElementById("lastname").value;
        let email = document.getElementById("email").value;
        // let subject = document.getElementById("subject").value;
        let message = document.getElementById("message").value;
        let resultComponent = document.getElementById("result");
        resultComponent.innerHTML = ""; // Xóa thông báo lỗi cũ

        let isValid = true;
        let errorMessages = [];

        if (firstName === '') {
            errorMessages.push("Vui lòng nhập tên của bạn.");
            isValid = false;
        }else if (lastName === '') {
            errorMessages.push("Vui lòng nhập họ của bạn.");
            isValid = false;
        } else if (email === '') {
            errorMessages.push("Vui lòng nhập địa chỉ email của bạn.");
            isValid = false;
        } else if (message === '') {
            errorMessages.push("Vui lòng nhập nội dung tin nhắn.");
            isValid = false;
        } else {
            const emailRegex = /\S+@\S+\.\S+/;
            if (!emailRegex.test(email)) {
                errorMessages.push("Vui lòng nhập địa chỉ email hợp lệ.");
                isValid = false;
            }
        }
        if (isValid) {
            resolve(true); // Form hợp lệ
        } else {
            reject(errorMessages); // Trả về danh sách thông báo lỗi
        }
    });
}
