function displayImage() {
    var fileInput = document.getElementById('avt-image-file');
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


function validateInfomation() {
    return new Promise((resolve, reject) => {
        try {
            let usernameResult = validateInput(document.getElementById("username"));
            let fullNameResult = validateInput(document.getElementById("fullName"));
            let emailResult = validateInput(document.getElementById("email"));
            let phoneNumberResult = validateInput(document.getElementById("phone_number"));
            let birthdayResult = validateInput(document.getElementById("birthday"));
            let addressResult = validateInput(document.getElementById("address"));
            let currentPasswordResult = true;
            let newPasswordResult = true;
            let ConfirmPassword = true;
            let MatchPassword = true;
            if (document.getElementById("change-password-checkbox").checked == true) {
                currentPasswordResult = validateInput(document.getElementById("oldPassword"));
                newPasswordResult = validateInput(document.getElementById("newPassword"));
                ConfirmPassword = validateInput(document.getElementById("confirmPassword"));
                MatchPassword = matchPasswords(document.getElementById("newPassword").value, document.getElementById("confirmPassword").value);
            }
            let validatePhoneNumberValidResult = validatePhoneNumber(document.getElementById("phone_number"));
            let vaidateBirthdayValidResult = validateBirthday(document.getElementById("birthday"));
            resolve(usernameResult
                && fullNameResult
                && emailResult
                && phoneNumberResult
                && birthdayResult
                && addressResult
                && currentPasswordResult
                && newPasswordResult
                && ConfirmPassword
                && MatchPassword
                && validatePhoneNumberValidResult
                && vaidateBirthdayValidResult);
        } catch (e) {
            reject(e);
        }
    })
}

function changeInfomation() {
    validateInfomation().then(valid => {
        var checkbox = document.getElementById("change-password-checkbox");

        if (valid) {
            if (checkbox.checked) {
                checkPassowrdMatchWithCurrentAccount().then(result => {
                    if (result.status == "success") {
                        change();
                    } else if (result.status == "not match") {
                        Swal.fire({
                            icon: 'error',
                            title: 'Thất Bại!',
                            text: 'Mật Khẩu Hiện Tại Không Đúng',
                            confirmButtonText: 'OK'
                        });
                    }
                });
            } else {
                change();
            }
        }
    }).catch(error => {
        console.error('Error:', error);
    });
}

function checkPassowrdMatchWithCurrentAccount() {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: `/api/my-account/checkPasswordMatch?currentPassword=${document.getElementById("oldPassword").value}`,
            method: "GET",
            success: function (data) {
                resolve(data);
            },
            error: function (error) {
                reject(error);
            }
        })
    })
}

function change() {
    let fullname = document.getElementById("fullName").value;
    let phonenumber = document.getElementById("phone_number").value;
    let birthday = document.getElementById("birthday").value;
    let address = document.getElementById("address").value;
    let changepassword = document.getElementById("change-password-checkbox").checked;
    let newPassword = document.getElementById("newPassword").value;
    let avatarImageFile = document.getElementById("avt-image-file").files[0];


    if (avatarImageFile) {
        let formData = new FormData();
        formData.append("file", avatarImageFile);
        $.ajax({
            url: '/api/uploadFile/saveAvatar',
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            success: function(response) {
                console.log("thanh cong")
            },
            error: function(xhr, status, error) {
                console.log("that bai")
            }
        });

    }
    let changeAccountDTO = {
        fullname: fullname,
        birthday: birthday,
        phonenumber: phonenumber,
        address: address,
        changePassword: changepassword,
        newPassword: newPassword
    }

    $.ajax({
        url: "/api/my-account/changeAccountInfo",
        method: "PUT",
        data: JSON.stringify(changeAccountDTO),
        contentType: "application/json",
        success: function (data) {
            Swal.fire({
                icon: 'success',
                title: 'Thành Công!',
                text: 'Thay Đổi Thông Tin Thành Công.',
                confirmButtonText: 'OK'
            });
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Không Thành Công!',
                text: 'Thay Đổi Thông Tin Không Thành Công.',
                confirmButtonText: 'OK'
            });
            console.log(error);
        }
    })
}

function matchPasswords(newPassword, confirmPassword) {
    if (newPassword !== confirmPassword) {
        document.getElementById("confirmPassword").style.borderColor = "red";
        document.getElementById("confirmPassword").parentElement.querySelectorAll(".feedback")[0].innerHTML = "Mật khẩu không trùng khớp";
        return false;
    } else {
        document.getElementById("confirmPassword").style.borderColor = "green";
        document.getElementById("confirmPassword").parentElement.querySelectorAll(".feedback")[0].innerHTML = "";
        return true;
    }
}

function initialization() {
    getInformation().then(currentAccount => {
        renderCurrentAccount(currentAccount);
    })
}

function getInformation() {
    // use ajax to get account from session
    return new Promise((resolve, reject) => {
        $.ajax({
            url: "/api/session/acc",
            method: "GET",
            success: function (currentAccount) {
                resolve(currentAccount);
            },
            error: function (error) {
                reject(error);
            }
        })
    })
}

function renderCurrentAccount(currentAccount) {
    document.getElementById("username").value = currentAccount.username;
    document.getElementById("fullName").value = currentAccount.fullname;
    document.getElementById("email").value = currentAccount.email;
    document.getElementById("phone_number").value = currentAccount.phone_number;
    let date = new Date(currentAccount.birthday);
    let formattedDate = date.toISOString().split('T')[0];
    document.getElementById("birthday").value = formattedDate;
    document.getElementById("address").value = currentAccount.address;
    let selectedImage = document.getElementById("selectedImage");
    selectedImage.src = `/user/img/avatar/${currentAccount.avatar_url}`;
}


function validatePhoneNumber(phoneNumberInput) {
    let phonePattern = /^\d{10}$/;
    let result = phonePattern.test(phoneNumberInput.value);
    if (!result) {
        phoneNumberInput.style.borderColor = "red";
        phoneNumberInput.parentElement.querySelectorAll(".feedback")[0].innerHTML = "Vui Lòng Nhập Đúng Định Dạng Số Điện Thoại";
        return false; // Trường nhập liệu rỗng
    } else {
        phoneNumberInput.style.borderColor = "green";
        phoneNumberInput.parentElement.querySelectorAll(".feedback")[0].innerHTML = "";
        return true; // Trường nhập liệu không rỗng
    }
    return result;
}

function validateBirthday(birthdayInput) {
    var birthday = new Date(birthdayInput.value);
    var today = new Date();
    var age = today.getFullYear() - birthday.getFullYear();

    if (today.getMonth() < birthday.getMonth() || (today.getMonth() === birthday.getMonth() && today.getDate() < birthday.getDate())) {
        age--;
    }
    if (age < 12 || age > 120) {
        birthdayInput.style.borderColor = "red";
        birthdayInput.parentElement.querySelectorAll(".feedback")[0].innerHTML = "Ngày sinh không đủ 12 tuổi hoặc không hợp lệ";
        return false;
    } else {
        birthdayInput.style.borderColor = "green";
        birthdayInput.parentElement.querySelectorAll(".feedback")[0].innerHTML = "";
        return true;
    }
}

function validateInput(inputElement) {
    // Lấy giá trị từ phần tử nhập liệu
    var inputValue = inputElement.value.trim(); // Trim() để loại bỏ khoảng trắng ở đầu và cuối chuỗi

    // Kiểm tra nếu giá trị là rỗng
    if (inputValue === '') {
        inputElement.style.borderColor = "red";
        inputElement.parentElement.querySelectorAll(".feedback")[0].innerHTML = "Vui Vòng Điền Trường Này";
        return false; // Trường nhập liệu rỗng
    } else {
        inputElement.style.borderColor = "green";
        inputElement.parentElement.querySelectorAll(".feedback")[0].innerHTML = "";
        return true; // Trường nhập liệu không rỗng
    }
}

initialization();