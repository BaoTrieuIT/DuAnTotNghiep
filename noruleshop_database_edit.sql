--  drop database norule_shop;
--  create database norule_shop;
--  use norule_shop;
create table `account_status`(
	account_status_id int auto_increment primary key,
    account_status_name nvarchar(50)
);

create table `role`(
	role_id int auto_increment primary key,
    role_name nvarchar(50) not null 
);

create table `ranked`(
	ranked_id int auto_increment primary key,
    rank_name nvarchar(50) not null , 
    minimum_point int not null 
);


create table `account`(
	account_id int auto_increment primary key,
    password varchar(100),
    fullname nvarchar(50),
    phone_number varchar(10),
	email varchar(50), 
    username varchar(50) not null ,
    create_date date not null ,
    birthday date,
    avatar_url varchar(50) not null,
    ranked_id int,
    account_status_id int,
    foreign key (account_status_id) references `account_status`(account_status_id),
    foreign key (ranked_id) references `ranked`(ranked_id)
);

create table `points`(
	points_id int  auto_increment primary key,
    account_id int,
    points int,
    `year` int,
    foreign key (account_id) references `account`(account_id)
);

-- delete this table 
-- create table `address_type`(
-- 	address_type_id int auto_increment primary key,
--     Address_type_name nvarchar(50)
-- ) ;


-- Addres
create table `address`(
	address_id int auto_increment primary key,  
    recipient_name nvarchar(50),
    recipient_phone_number varchar(10),
    general_address nvarchar(255),
    specific_address nvarchar(255),
 --    Address_type_id int,
    account_id int,
--    foreign key (Address_type_id) references `Address_type`(Address_type_id),
    foreign key (account_id) references `account`(account_id)
);

create table `gender`(
	gender_id int primary key auto_increment,
    gender_name nvarchar(255) not null
);

create table `directory`(
	directory_id int auto_increment primary key,
    directory_name nvarchar(255) not null,
    gender_id int not null,
    foreign key (gender_id) references gender(gender_id)
);

create table `directory_lv1`(
	directory_lv1_id int auto_increment primary key,
    directory_lv1_name nvarchar(255) not null,
    directory_id int,
	foreign key (directory_id) references `directory`(directory_id)
);

create table type(
	type_id int primary key auto_increment,
    type_name nvarchar(255)
);

create table `information_type`(
	information_type_id int auto_increment primary key,
    information_type_name nvarchar(255) not null,
    directory_lv1_id int not null, 
    type_id int not null,
    foreign key (directory_lv1_id) references `directory_lv1`(directory_lv1_id),
    foreign key (type_id) references `type`(type_id)
);

create table `detail_information_type`(
	detail_information_type_id int auto_increment primary key,
    information_type_id int,
    detail_Information_type_name nvarchar(255),
	foreign key (information_type_id) references `information_type`(information_type_id)
);



create table `brand`(
	brand_id int auto_increment primary key,
    brand_name nvarchar(255) not null,
    logo_url varchar(255) not null,
    another_information nvarchar(1000),
    website_url nvarchar(50),
    is_active bit
);


create table `brand_image`(
	brand_image_id int auto_increment primary key,
    imag_url varchar(255),
    brand_id int,
    foreign key (brand_id) references `brand`(brand_id)
);

create table `product`(
	product_id int auto_increment primary key,
    product_name nvarchar(255),
    product_rating float null,
    create_date date not null,
    is_accepted bit not null,
	is_remove bit not null,
    product_description nvarchar(1000) not null,
    brand_id  int  not null,
    price int not null,
    directory_lv1_id int,
	foreign key (brand_id) references `brand`(brand_id),
    foreign key (directory_lv1_id) references `directory_lv1`(directory_lv1_id)
);


create table `product_discount`(
	product_discount_id int auto_increment primary key,
    product_discount_name nvarchar(255),
	product_discount_valid_from date not null,
    product_discount_valid_to date not null,
    product_discount_value float not null,
    product_discount_description nvarchar(1000),
    quantity int null,
    product_id int,
    foreign key (product_id) references `product`(product_id)
);


create table `product_image`(
	product_image_id int auto_increment primary key,
	image_url varchar(255) not null,
--     create_date date not null,
--     create_date date not null,
    product_id int not null,
    foreign key (product_id) references `product`(product_id)
);


create table `category_level_1`(
	category_level_1_id int auto_increment primary key,
    category_level_1_name nvarchar(255) not null
);
create table `category_level_2`(
	category_level_2_id int auto_increment primary key,
    category_level_2_name nvarchar(255) not null
);

create table `category_level_1_detail`(
	category_level_1_detail_id int auto_increment primary key,
    category_level_1_detail_name nvarchar(255) not null,
    category_level_1_id int,
    foreign key (category_level_1_id) references `category_level_1`(category_level_1_id)
);


create table `category_level_2_detail`(
	category_level_2_detail_id int auto_increment primary key,
    category_level_2_detail_name nvarchar(255) not null,
    category_level_2_id int,
    foreign key (category_level_2_id) references `category_level_2`(category_level_2_id)
);


create table `category_quantity`(
	category_quantity_id int auto_increment primary key,
    category_level_1_detail_id int,
    category_level_2_detail_id int,
    product_id int,
    quantity int,
    price int,
	foreign key (category_level_1_detail_id) references `category_level_1_detail`(category_level_1_detail_id),
    foreign key (category_level_2_detail_id) references `category_level_2_detail`(category_level_2_detail_id),
    foreign key (product_id) references `product`(product_id)
);

-- Voucher 
create table `voucher`(
	voucher_id  int auto_increment primary key,
    voucher_value float not null,
    voucher_code varchar(50) not null,
    valid_from date not null,
    valid_to date not null,
    minimize_order_amount bigint null,
    quantity_available int not null
);


create table `payment_method`(
	payment_method_id int auto_increment primary key, 
    payment_method_name nvarchar(255)
);


create table `payment_status`(
	payment_status_id int auto_increment primary key, 
    payment_status_name nvarchar(255) not null
);

create table `order_status`(
	order_status_id int auto_increment primary key, 
    order_status_name nvarchar(255) not null
);

-- delete this database 
-- create table `delivery_method`(
-- 	delivery_method_id int auto_increment primary key,
--     delivery_method_name nvarchar(255)
-- );

create table `orders`(
	order_id int auto_increment primary key, 
    order_time datetime,
    discount_amout int not null,
    recipient_name nvarchar(255) not null,
    phonenumber varchar(255)  not null,
    specified_address nvarchar(255) not null,
	account_id int,
    voucher_id int null ,
	payment_status_id int,
    order_status_id int,
    payment_method_id int,
    order_note nvarchar(10000),
    foreign key (account_id) references `account`(account_id),
    foreign key (voucher_id) references `voucher`(voucher_id),
    foreign key (payment_status_id) references `payment_status`(payment_status_id),
    foreign key (order_status_id) references `order_status`(order_status_id),
    foreign key (payment_method_id) references `payment_method`(payment_method_id)
);


create table `order_detail`(
	order_detail_id int auto_increment primary key,
    quantity int not null,
    unit_price bigint not null,
    discount_amout int not null,
    total_price_before_discount int not null,
    total_price int not null,
    order_id int not null,
    product_id int not null,
	foreign key (order_id) references `orders`(order_id),
    foreign key (product_id) references `product`(product_id)
);

create table `feedback`(
	feedback_id int AUTO_INCREMENT primary key,
    feedback_rating int null,
    comment nvarchar(255) not null,
    feedback_time datetime,
    account_id int , 
    order_detail_id int,
    foreign key (account_id) references `account`(account_id),
    foreign key (order_detail_id) references `order_detail`(order_detail_id)
);

create table `feedback_image`(
	feedback_image_id int AUTO_INCREMENT primary key,
    image_url varchar(255) null,
    feedback_id int ,
    foreign key (feedback_id) references `feedback`(feedback_id)
);


create table `report_status`(
	report_status_id int auto_increment primary key,
	report_status_name nvarchar(255)
);

create table `feedback_report`(
	feedback_report_id  int AUTO_INCREMENT primary key,
    report_date date not null,
    `description` nvarchar(1000) not null,
    feedback_id int not null,
    account_id int not null,
    report_status_id int not null,
	foreign key (feedback_id) references `feedback`(feedback_id),
	foreign key (account_id) references `account`(account_id),
	foreign key (report_status_id) references `report_status`(report_status_id)
);

create table `product_infromation_type`(
	product_infromation_type_id int auto_increment primary key,
    product_id int,
    information_type_id int,
    infromation_type_value nvarchar(10000),
    foreign key (product_id) references product(product_id)
);

-- Insert data into `account_status` table
INSERT INTO `account_status` (account_status_name) VALUES
    ('Active'),
    ('Suspended'),
    ('Inactive');


-- Insert data into `ranked` table
INSERT INTO `ranked` (rank_name, minimum_point) VALUES
    ('Bronze', 0),
    ('Silver', 1000),
    ('Gold', 5000);

-- Insert data into `account` table
INSERT INTO `account` (password, fullname, phone_number, email, username, create_date, birthday, avatar_url, ranked_id, account_status_id) VALUES
    ('$2a$10$G0oBI5UCm4KeAvVI6/BEQ.lZhmBzbf4D.PeURGaLP3rFVbtwPfzLK', 'John Doe', '1234567890', 'john@example.com', 'johndoe', '2023-09-11', '1990-01-15', 'avatar1.jpg', 1, 1),
    ('$2a$10$S9FZWpmWtF2hrpHpCNPz8eQ8xDxPth/LFpbk.aYVB/.HwZyb.49yy', 'Jane Smith', '9876543210', 'jane@example.com', 'janesmith', '2023-09-11', '1985-03-20', 'avatar2.jpg', 2, 1);

-- delete this data
-- Insert data into `address_type` table
-- INSERT INTO `address_type` (Address_type_name) VALUES
--     ('Home'),
--     ('Work');
INSERT INTO gender (gender_name) VALUES ('Male');
INSERT INTO gender (gender_name) VALUES ('Female');
-- Insert data into `directory` table
INSERT INTO `directory` (directory_name, gender_id) VALUES
    ('Main Directory',1),
    ('Sub Directory 1',1),
    ('Sub Directory 2',1);

-- Insert data into `directory_lv1` table
INSERT INTO `directory_lv1` (directory_lv1_name, directory_id) VALUES
    ('Category 1', 1),
    ('Category 2', 1);



create table `directory_lv1_brand`(
	directory_lv1_brand_id int auto_increment primary key ,
    directory_lv1_id int,
    brand_id int,
    foreign key (directory_lv1_id) references directory_lv1(directory_lv1_id),
    foreign key (brand_id) references brand(brand_id)
);

-- Insert data into `address` table
INSERT INTO `address` (recipient_name, recipient_phone_number, general_address, specific_address, account_id) VALUES
    ('John Home', '1234567890', '123 Main St', 'Apt 4B', 1),
    ('Jane Work', '9876543210', '456 Elm St', 'Suite 202', 2);

INSERT INTO account_status (account_status_name) VALUES ('Active');
INSERT INTO account_status (account_status_name) VALUES ('Inactive');
-- Thêm các dòng dữ liệu khác nếu cần thiết

INSERT INTO role (role_name) VALUES ('Admin');
INSERT INTO role (role_name) VALUES ('User');
-- Thêm các dòng dữ liệu khác nếu cần thiết




-- Thêm các dòng dữ liệu khác nếu cần thiết


INSERT INTO type (type_name) VALUES ('Type A');
INSERT INTO type (type_name) VALUES ('Type B');
-- Thêm các dòng dữ liệu khác nếu cần thiết





create table `accounts_roles`(
	account_id int,
    role_id int,
    FOREIGN KEY (account_id) REFERENCES account(account_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

INSERT INTO `accounts_roles` VALUES 
(1,1),
(2,2);
SELECt * from account;

INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Louis Vuitton','images/cac-thuong-hieu-thoi-trang-noi-tieng.png','Các dòng sản phẩm đang kinh doanh: Quần áo, giày dép, trang sức, đồng hồ đeo tay, đồ da,…','louisvuitton.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Gucci','images/cac-thuong-hieu-thoi-trang-noi-tieng-1.png','Gucci có sự phát triển vô cùng mạnh mẽ, trở thành biểu tượng thời trang hàng đầu thế giới với những dòng sản phẩm độc đáo, đẳng cấp và đại diện cho thương hiệu xa xỉ bậc nhất hiện nay.','gucci.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Hermès','images/cac-thuong-hieu-thoi-trang-noi-tieng-2.png','Hermès sở hữu những bộ sưu tập vô cùng đa dạng, phong phú với thiết kế thủ công tinh xảo, tỉ mỉ đến từng chi tiết. Đó cũng là lý do khiến thương hiệu này trở thành cái tên số 1 thế giới trong lĩnh vực thời trang.','hermes.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Céline','images/tui-xach-celine-duoc-thiet-ke-don-gian-nhung-vo-cung-sang-trong.png','Thương hiệu Céline nổi tiếng về đồ da và quần áo nổi tiếng, cao cấp. Những mẫu thiết kế của Céline luôn hướng đến phong cách sang trọng, trẻ trung, thời thượng, vừa cổ điển vừa hiện đại, đặc biệt là tính ứng dụng cao trong cuộc sống hàng ngày.','céline.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Loewe','images/mau-tui-xach-moi-la-cao-cap-cua-loewe.png','Loewe được biết đến là một thương hiệu thời trang nổi tiếng thế giới với các mẫu túi xách, quần áo cao cấp.','loewe.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Chanel','images/cac-thuong-hieu-thoi-trang-noi-tieng-5.png','Mỗi sản phẩm của Chanel đều mang phong cách đẳng cấp, luôn đề cao sự sang trọng, xa hoa, quyền quý và sự tinh tế lên đến cực đỉnh từ nước hoa, quần áo, đồng hồ,…','chanel.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Prada','images/cac-thuong-hieu-thoi-trang-noi-tieng-6.png','Các sản phẩm của hãng luôn được thiết kế với phong cách độc lạ nhưng cũng không kém phần cổ điển để khẳng định được đẳng cấp và sự khác biệt của mình.','Prada.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Christian Dior','images/cac-thuong-hieu-thoi-trang-noi-tieng-7.png','Thành công của Dior đến từ những sản phẩm thời trang nam nữ kết hợp với các thương hiệu cũng như các nhà thiết kế nổi tiếng như Nike, Matthew Williams của Alyx.','Dior.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Versace','images/cac-thuong-hieu-thoi-trang-noi-tieng-8.png','Phong cách thiết kế thời trang của Versace luôn mang nét đặc trưng nghệ thuật trong đường nét, chất liệu, màu sắc, họa tiết.','versace.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Burberry','images/cac-thuong-hieu-thoi-trang-noi-tieng-9.png','Điểm nổi bật của những sản phẩm trong Burberry chính là họa tiết các hình sọc vuông ấn tượng, độc lạ, đặc trưng giữa hàng trăm thương hiệu thời trang nổi tiếng khác.','Burberry.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('CHANCOS','images/thuong-hieu-thoi-trang-cao-cap-tai-viet-nam-chancos-600x600.jpg','Cho dù bạn có vóc dáng cao thấp, gầy béo như thế nào đi chăng nữa thì CHANCOS đều có thiết kế phù hợp. Đến với CHANCOS đảm bảo bạn sẽ không bao giờ phải thất vọng.','chancosvn.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('SIXDO','images/hang-thoi-trang-cao-cap-sixdo-600x458.jpg','SIXDO là hãng thời trang cao cấp của nhà thiết kế Đỗ Mạnh Cường. Nếu như bạn thường xuyên xem các show thời trang thì chắc hẳn không còn quá xa lạ với thương hiệu này nữa.','sixdo.vn',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Dolce & Gabbana','images/a1_2.jpg','Dolce & Gabbana là một thương hiệu thời trang cao cấp, được thành lập bởi hai nhà thiết kế thời trang người Ý là Domenico Dolce và Stefano Gabbana.','dolcegabbana.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Giorgio Armani S.p. A.','images/w1200.webp','Giorgio Armani S.p.A được biết đến nhiều hơn dưới tên Armani, là một hãng thời trang nổi tiếng thế giới của Ý','armani.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Vera Wang','images/homepage-23-wedding.jpg','Thương hiệu váy cưới nổi tiếng','verawang.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('DKNY','images/dk_10.15_hp_desktop_hero.webp','DKNY là một hãng thời trang có trụ sở tại Thành phố New York chuyên về hàng thời trang cho nam và nữ','donnakaran.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Paul Stuart','images/80663061-3280-20.jpg','Paul Stuart là thương hiệu quần áo cao cấp dành cho nam và nữ được thành lập vào năm 1938 tại thành phố New York','paulstuart.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Loro Piana','images/Cocooning-Assets-411x514-11-.jpg','Loro Piana là một công ty vải và quần áo của Ý chuyên về các sản phẩm cashmere và len cao cấp, sang trọng.','us.loropiana.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Calvin Klein','images/Fall_Outerwear_M_2x.webp','Calvin Klein là một nhãn hiệu thời trang được nhà thiết kế cùng tên Calvin Klein thành lập năm 1968.','calvinklein.us',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Miu Miu','images/MiuMiuNUXlogo.svg','Miu Miu là thương hiệu quần áo và phụ kiện thời trang cao cấp của Ý và là công ty con thuộc sở hữu hoàn toàn của Prada.','miumiu.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('Cesare Attolini','images/tải xuống.webp','Cesare Attolini là một thương hiệu thời trang nam sang trọng được thành lập tại Naples vào những năm 1930 bởi Vincenzo Attolini.aaaa','cesareattolini.com',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('JUNO','images/brand-viet-nam-1_72.jpg','Là một trong những thương hiệu thời trang Việt Nam nổi tiếng với hệ thống chi nhánh khắp cả nước, JUNO đã chinh phục những người yêu thích thời trang bằng những sản phẩm thời trang, hiện đại được thiết kế từ chính người Việt.','juno.vn',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('OWEN','images/brand-viet-nam-3_51.webp','Đối với các quý ông, OWEN chính là thương hiệu thời trang nổi tiếng dành riêng cho nam giới. Tuy ra nhập thị trường Việt Nam khá muộn, nhưng OWEN đã nhanh chóng khẳng định vị thế của mình bằng chất lượng cực tốt.','owen.vn',b'1');
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES ('NOVELTY','images/brand-viet-nam-7_1.webp','NOVELTY là thương hiệu thời trang chuẩn mực, lịch lãm nhưng cũng rất cá tính và năng động.','www.novelty.com.vn',b'1');
