function displayImage() {
    var fileInput = document.getElementById('fileInput');
    var selectedImage = document.getElementById('selectedImage');

    var file = fileInput.files[0];

    if (file) {
        var reader = new FileReader();

        reader.onload = function (e) {
            selectedImage.src = e.target.result;
            selectedImage.style.display = 'block';
        };

        reader.readAsDataURL(file);
    }
}
function updateAndReload() {
    var formData = new FormData(document.getElementById("myaccount-form"));
    var progressBar = document.getElementById("progress-bar");
    var progressText = document.getElementById("progress-text");
    var progressContainer = document.getElementById("upload-progress");

    // Hiển thị thanh tiến trình khi bắt đầu upload
    progressContainer.style.display = "block";

    fetch("/home/my-account/update", {
        method: "POST",
        body: formData,
        headers: {
            // Các header cần thiết, nhưng không cần thiết để hiển thị thanh tiến trình
        },
        signal: new AbortController().signal,
        onUploadProgress: function (progressEvent) {
            if (progressEvent.lengthComputable) {
                let percentComplete = (progressEvent.loaded / progressEvent.total) * 100;
                console.log(percentComplete);
                progressBar.style.width = percentComplete + "%";
                progressBar.setAttribute("aria-valuenow", percentComplete.toFixed(2)); // Cập nhật giá trị aria-valuenow
                progressText.innerText = percentComplete.toFixed(2) + "%";
            }
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error("Lỗi khi upload ảnh");
        }
        return response.json();
    }).then(data => {
        // Ẩn thanh tiến trình sau khi hoàn thành
        progressContainer.style.display = "none";
        // Hiển thị thông báo
        alert("Upload thành công! " + data); // Dữ liệu từ server

        // Nếu upload thành công, thì mới reload trang
        window.location.reload();
    }).catch(error => {
        console.error("Lỗi khi upload ảnh:", error);
        document.getElementById("imgErrorDiv").innerText = "Đã xảy ra lỗi khi upload ảnh";
        // Ẩn thanh tiến trình nếu có lỗi
        progressContainer.style.display = "none";
    });
}

function togglePasswordFields() {
    var checkbox = document.getElementById('change-password-checkbox');
    var hiddenField = document.getElementById('changePassword');
    var passwordFields = document.getElementById('account-change-password');

    if (checkbox.checked) {
        hiddenField.value = 'on';
        passwordFields.style.display = 'block';
    } else {
        hiddenField.value = '';
        passwordFields.style.display = 'none';
    }
}

var needsValidation = document.querySelectorAll('.needs-validation')

Array.prototype.slice.call(needsValidation)
    .forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
document.addEventListener("DOMContentLoaded", function () {
    var emailInput = document.getElementById("acc-email");
    var fullnameInput = document.getElementById("fullname");
    var birthdayInput = document.getElementById("birthday");
    var phonenumberInput = document.getElementById("phone_number");
    var oldPassword = document.getElementById('oldPassword');
    var newPassword = document.getElementById('newPassword');
    var confirmPassword = document.getElementById('comfirmPassword');

    emailInput.addEventListener("input", function () {
        validateEmail(emailInput);
    });
    fullnameInput.addEventListener("input", function () {
        validateFullname(fullnameInput);
    });
    birthdayInput.addEventListener("input", function () {
        validateBirthday(birthdayInput);
    });
    phonenumberInput.addEventListener("input", function () {
        validatePhoneNumber(phonenumberInput);
    });
    confirmPassword.addEventListener('input', function () {
        validateNewPassword(newPassword.value, confirmPassword.value);
    });
    oldPassword.addEventListener('input',function (){
        validateOldPassword(oldPassword.value);
    })
});

function validateOldPassword(oldPassword){
    var errorDiv = document.getElementById('oldpasswordErrorDiv');
    var oldpassword = oldPassword.value.trim();

    if (!oldpassword) {
        errorDiv.innerHTML = "Không để mật khẩu hiện tại trống";
        errorDiv.style.display = 'block';
     }
    // else {
    //     // Sử dụng Ajax để gửi yêu cầu đến server và kiểm tra mật khẩu cũ
    //     // Đây chỉ là một ví dụ, bạn cần thay thế bằng cách thực hiện thực tế của bạn.
    //     // Trong môi trường thực tế, bạn cần xác thực mật khẩu trên server và trả về kết quả.
    //     // Ở đây, tôi giả sử có một API endpoint '/api/check-password' trên server để kiểm tra mật khẩu.
    //     // Gửi yêu cầu Ajax đến server
    //     $.ajax({
    //         type: 'POST',
    //         url: '/api/check-password',
    //         data: {password: oldpassword},
    //         success: function (response) {
    //             if (response.valid) {
    //                 // Mật khẩu hợp lệ, ẩn thông báo lỗi
    //                 errorDiv.style.display = 'none';
    //             } else {
    //                 // Mật khẩu không hợp lệ, hiển thị thông báo lỗi
    //                 errorDiv.innerHTML = "Sai mật khẩu hiện tại";
    //                 errorDiv.style.display = 'block';
    //             }
    //         },
    //         error: function () {
    //             // Xử lý lỗi nếu có
    //             console.error("Error checking old password");
    //         }
    //     });
    // }
}

function validateNewPassword(newPassword, confirmPassword) {
    var errorDiv = document.getElementById('password-mismatch-error');
    if (newPassword.length < 6) {
        document.getElementById('comfirmPassword').setCustomValidity("Mật khẩu mới phải có ít nhất 6 ký tự")
        errorDiv.innerHTML = "Mật khẩu mới phải có ít nhất 6 ký tự";
        errorDiv.style.display = 'block';
    } else {
        if (newPassword === confirmPassword) {
            document.getElementById('comfirmPassword').setCustomValidity("")
            errorDiv.style.display = 'none';
        } else {
            document.getElementById('comfirmPassword').setCustomValidity("Mật khẩu không khớp. Vui lòng kiểm tra lại.")
            errorDiv.innerHTML = "Mật khẩu không khớp. Vui lòng kiểm tra lại.";
            errorDiv.style.display = 'block';
        }
    }
    console.log("newPassword: " + newPassword);
    console.log("confirmPassword: " + confirmPassword);
}

function validateEmail(emailInput) {
    var email = emailInput.value;
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        emailInput.setCustomValidity("Địa chỉ email không hợp lệ");
        document.getElementById("emailErrorDiv").innerText = "Địa chỉ email không hợp lệ";
    } else {
        emailInput.setCustomValidity("");
    }
}

function validateFullname(fullnameInput) {
    var fullname = fullnameInput.value;
    var fullnameRegex = /^[a-zA-Z ]*$/;

    if (!fullnameRegex.test(fullname) && fullname == null) {
        fullnameInput.setCustomValidity("Họ và tên không được chứa kí tự đặc biệt và số");
        document.getElementById("fullnameErrorDiv").innerText = "Họ và tên không được chứa kí tự đặc biệt và số";
    } else {
        fullnameInput.setCustomValidity("");
    }
}

//Kiểm tra ngày sinh đủ 12 tuổi
function validateBirthday(birthdayInput) {
    var birthday = new Date(birthdayInput.value);
    var today = new Date();
    var age = today.getFullYear() - birthday.getFullYear();

    if (today.getMonth() < birthday.getMonth() || (today.getMonth() === birthday.getMonth() && today.getDate() < birthday.getDate())) {
        age--;
    }
    console.log(age);
    if (age < 12 || age > 120) {
        birthdayInput.setCustomValidity("Ngày sinh không đủ 12 tuổi");
        document.getElementById("birthdayErrorDiv").innerText = "Ngày sinh không đủ 12 tuổi hoặc không hợp lệ";
    } else {
        birthdayInput.setCustomValidity("");
    }
}

function validatePhoneNumber(phoneInput) {
    var phoneNumber = phoneInput.value.replace(/\D/g, '');

    if (phoneNumber !== null) {
        if (phoneNumber.length === 10) {
            phoneInput.setCustomValidity("");
            document.getElementById("phoneErrorDiv").innerText = "";
        } else {
            console.error("Số điện thoại phải là 10 chữ số");
            document.getElementById("phoneErrorDiv").innerText = "Số điện thoại phải là 10 chữ số";
            phoneInput.setCustomValidity("Số điện thoại phải là 10 chữ số");
        }
    } else {
        console.error("Số điện thoại không được để trống");
        document.getElementById("phoneErrorDiv").innerText = "Số điện thoại không được để trống";
    }
}
