function validateInput(input) {
    let result = [];
    if(input){
        switch (input.type) {
            case "text":
                result = { valid: validateText(input.value), message: 'Trường văn bản là bắt buộc và không được quá 255 ký tự.' };
                break;
            case 'file':
                result = { valid: validateText(input.value), message: 'Chưa có file được chọn.' };
                break;
            case 'email':
                result =  { valid: validateEmail(input.value), message: 'Vui lòng nhập một địa chỉ email hợp lệ.' };
                break;
            case 'number':
                result =  { valid: validateNumber(input.value), message: 'Vui lòng nhập một số hợp lệ.' };
                break;
            case 'checkbox':
                result =  { valid: validateCheckbox(input), message: 'Checkbox phải được chọn.' };
                break;
            case 'select-one':
                result =  { valid: validateSelect(input), message: 'Vui lòng chọn một tùy chọn.' };
                break;
            case 'textarea':
                result =  { valid: validateTextArea(input.value), message: 'Trường văn bản là bắt buộc và không được quá 255 ký tự.' };
                break;
            default:
                result =  { valid: false, message: 'Loại dữ liệu không hợp lệ.' };
        }
        if(result.valid == false){
            input.style.borderColor = "red";
        }else{
            input.style.borderColor = "green";
        }
    }
    return result;
}


function validateText(inputValue) {
    return inputValue.trim() !== '';
}

function validateEmail(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function validateNumber(number) {
    if(number == ""){
        return false;
    }
    return !isNaN(number);
}

function validateSelect(input) {
    return input.selectedIndex !== 0; // Kiểm tra nếu không chọn giá trị mặc định (index = 0)
}


function validateCheckbox(input) {
    return input.checked;
}

function validateTextArea(inputValue) {
    return inputValue.trim() !== ''; // Kiểm tra xem textarea có giá trị không
}
