// Hàm để thêm lớp "active" và gán sự kiện "click" cho các thẻ <a>
function addActiveClassAndClickEvent() {
    // Lấy tất cả các thẻ <a>
    const myLinks = document.querySelectorAll("a");

    // Thêm sự kiện "click" cho mỗi thẻ <a>
    myLinks.forEach(function (link) {
        link.addEventListener("click", function (event) {
            // Ngăn chặn hành vi mặc định của thẻ <a> (chẳng hạn, điều hướng đến URL)
            event.preventDefault();

            // Loại bỏ lớp "active" từ tất cả các thẻ trước đó
            myLinks.forEach(function (link) {
                link.classList.remove("active");
            });
            console.log("Done")
            // Thêm lớp "active" vào thẻ <a> được click
            link.classList.add("active");
        });
    });
}

// Gọi hàm để thêm lớp "active" và gán sự kiện "click"
addActiveClassAndClickEvent();
