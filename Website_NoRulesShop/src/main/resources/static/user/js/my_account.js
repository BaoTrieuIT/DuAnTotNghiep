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
        document.getElementById("phoneErrorDiv").innerText = "Đã xảy ra lỗi khi upload ảnh";
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
    var phonenumberInput = document.getElementById("phone_number")
    var newPassword = document.getElementById('password');
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
});

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

//
// var citis = document.getElementById("city");
// var districts = document.getElementById("district");
// var wards = document.getElementById("ward");
// var Parameter = {
//     url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
//     method: "GET",
//     responseType: "application/json",
// };
// var promise = axios(Parameter);
// promise.then(function (result) {
//     renderCity(result.data);
//     console.log(result.data);
// });
//
// function renderCity(data) {
//     for (const x of data) {
//         citis.options[citis.options.length] = new Option(x.Name, x.Id);
//     }
//     citis.onchange = function () {
//         district.length = 1;
//         ward.length = 1;
//         if (this.value != "") {
//             const result = data.filter(n => n.Id === this.value);
//
//             for (const k of result[0].Districts) {
//                 district.options[district.options.length] = new Option(k.Name, k.Id);
//             }
//         }
//     };
//     district.onchange = function () {
//         ward.length = 1;
//         const dataCity = data.filter((n) => n.Id === citis.value);
//         if (this.value != "") {
//             const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;
//
//             for (const w of dataWards) {
//                 wards.options[wards.options.length] = new Option(w.Name, w.Id);
//             }
//         }
//     };
// }
//
//
// function updateAddress() {
//     var citySelect = document.getElementById("city");
//     var districtSelect = document.getElementById("district");
//     var wardSelect = document.getElementById("ward");
//     var city = citySelect.options[citySelect.selectedIndex].text;
//     var district = districtSelect.options[districtSelect.selectedIndex].text;
//     var ward = wardSelect.options[wardSelect.selectedIndex].text;
//
//     var address = "";
//
//     if (ward) {
//         address += ward;
//     }
//     if (district) {
//         address += ", " + district;
//     }
//     if (city) {
//         address += ", " + city;
//     }
//
//
//     // Hiển thị địa chỉ lên một thẻ span
//     // document.getElementById("address_detail").innerText = address;
//     console.log("D/c: " + address);
//
//     // Cập nhật giá trị của input để có thể gửi lên server nếu cần thiết
//     document.getElementById("hiddenAddress").value = address;
//     console.log(document.getElementById("hiddenAddress").value)
// }


// <!--                                <div class="col-3 mb-3 ml-3 form-group">-->
// <!--                                    <label class="col-form-label">Tỉnh/ Thành phố</label>-->
// <!--                                    <select class="form-select" id="city"  aria-label="Default select example"-->
// <!--                                            onchange="updateAddress()">-->
// <!--                                        <option selected="" value="" th:text="${city}">Tỉnh/ Thành phố</option>-->
// <!--                                    </select>-->
// <!--                                </div>-->
// <!--                                <div class="col-3 mb-3 ml-3 form-group">-->
// <!--                                    <label class="col-form-label">Quận/ Huyện</label>-->
// <!--                                    <select class="form-select" id="district" aria-label="Default select example"-->
// <!--                                            onchange="updateAddress()">-->
// <!--                                        <option selected="" value="" th:text="${district}">Quận/ Huyện</option>-->
// <!--                                    </select>-->
// <!--                                </div>-->
// <!--                                <div class="col-3 mb-3 ml-3 form-group">-->
// <!--                                    <label class="col-form-label">Phường/Thị trấn</label>-->
// <!--                                    <select class="form-select" id="ward"  aria-label="Default select example"-->
// <!--                                            onchange="updateAddress()">-->
// <!--                                        <option selected="" value="" th:text="${ward}">Phường/Thị trấn</option>-->
// <!--                                    </select>-->
// <!--                                </div>-->
// <!--                                <div class="form-group col-12 ml-3 mr-3">-->
// <!--                                    <label class="col-form-label" for="generalAddress">Phường/Thị trấn, Quận/ Huyện,-->
// <!--                                        Tỉnh/ Thành phố</label>-->
// <!--                                    <input type="text" class="form-control" id="generalAddress" name="generalAddress"-->
// <!--                                           th:value="${acc.address.generalAddress}"-->
// <!--                                           th:field="*{address.generalAddress}">-->
// <!--                                </div>-->
// <!--                                <div class="form-group col-12 ml-3 mr-3">-->
// <!--                                    <label class="col-form-label" for="specificAddress">Số nhà, tên đường</label>-->
// <!--                                    <input type="text" class="form-control" id="specificAddress" name="specificAddress"-->
// <!--                                           th:value="${acc.address.specificAddress}"-->
// <!--                                           th:field="*{address.specificAddress}">-->
// <!--                                </div>-->
//
// <!--                                <input type="hidden" id="hiddenAddress" name="hiddenAddress"-->
// <!--                                       >-->
