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
document.getElementById('comfirmPassword').addEventListener('input', function () {
    var newPassword = document.getElementById('password').value;
    var confirmPassword = document.getElementById('comfirmPassword').value;
    var errorDiv = document.getElementById('password-mismatch-error');

    if (newPassword.length < 6) {
        errorDiv.innerHTML = "Mật khẩu mới phải có ít nhất 6 ký tự.";
        errorDiv.style.display = 'block';
    } else {
        if (newPassword === confirmPassword) {
            errorDiv.style.display = 'none';
        } else {
            errorDiv.innerHTML = "Mật khẩu không khớp. Vui lòng kiểm tra lại.";
            errorDiv.style.display = 'block';
        }
    }
    console.log("newPassword: " + newPassword);
    console.log("confirmPassword: " + confirmPassword);
});

document.getElementById("phone_number").addEventListener("input", function () {
    var phoneNumber = this.value.replace(/\D/g, ''); // Loại bỏ các kí tự không phải số
    console.log(phoneNumber)
    if (phoneNumber !== null) {
        if (phoneNumber.length === 10) {
            // this.setCustomValidity("");
            document.getElementById("phoneErrorDiv").innerText = "";
        } else {
            console.log("Số điện thoại phải là 10 chữ số");
            document.getElementById("phoneErrorDiv").innerText = "Số điện thoại phải là 10 chữ số";
            // this.setCustomValidity("Số điện thoại phải là 10 chữ số");
        }
    } else {
        console.log("Số điện thoại không được để trống");
        document.getElementById("phoneErrorDiv").innerText = "Số điện thoại không được để trống";
    }

});
document.addEventListener("DOMContentLoaded", function () {
    var emailInput = document.getElementById("acc-email");
    var fullnameInput = document.getElementById("fullname");

    emailInput.addEventListener("input", function () {
        validateEmail(emailInput);
    });

    fullnameInput.addEventListener("input", function () {
        validateFullname(fullnameInput);
    });
    document.getElementById("birthday").addEventListener("input", function () {
        validateBirthday(this);
    });
});

function validateEmail(emailInput) {
    var email = emailInput.value;
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        emailInput.setCustomValidity("Địa chỉ email không hợp lệ");
    } else {
        emailInput.setCustomValidity("");
    }
}

function validateFullname(fullnameInput) {
    var fullname = fullnameInput.value;
    var fullnameRegex = /^[a-zA-Z ]*$/;

    if (!fullnameRegex.test(fullname)) {
        fullnameInput.setCustomValidity("Họ và tên không được chứa kí tự đặc biệt và số");
        document.getElementById("fullnameErrorDiv").innerText = "Họ và tên không được chứa kí tự đặc biệt và số";
    } else {
        fullnameInput.setCustomValidity("");
    }
    

    //Kiểm tra ngày sinh đủ 12 tuổi
    function validateBirthday(birthdayInput) {
        var birthday = new Date(birthdayInput.value);
        var today = new Date();
        var age = today.getFullYear() - birthday.getFullYear();

        if (today.getMonth() < birthday.getMonth() || (today.getMonth() === birthday.getMonth() && today.getDate() < birthday.getDate())) {
            age--;
        }

        if (age < 12 || age > 200) {
            document.getElementById("birthday-error").style.display = "none";
            document.getElementById("age-error").style.display = "block";
            birthdayInput.setCustomValidity("Ngày sinh không đủ 12 tuổi");
            document.getElementById("birthday-error").innerText = "Ngày sinh không đủ 12 tuổi";
        } else {
            document.getElementById("birthday-error").style.display = "none";
            document.getElementById("age-error").style.display = "none";
            birthdayInput.setCustomValidity("");
        }
    }


}