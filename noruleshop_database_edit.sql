drop database norule_shop;
create database norule_shop;
use norule_shop;
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
    password varchar(50),
    fullname nvarchar(50),
    phone_number varchar(10),
	email varchar(50), 
    username varchar(50) not null ,
    create_date date not null ,
    birthday date,
    avatar_url varchar(50) not null,
    role_id int not null ,
    ranked_id int,
    account_status_id int,
    foreign key (role_id) references `role`(role_id),
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
    another_information nvarchar(1000)
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
	is_remove bit not null,
    product_description nvarchar(1000) not null,
    brand_id  int  not null,
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


create table `directory_lv1_brand`(
	directory_lv1_brand_id int auto_increment primary key ,
    directory_lv1_id int,
    brand_id int,
    foreign key (directory_lv1_id) references directory_lv1(directory_lv1_id),
    foreign key (brand_id) references brand(brand_id)
);

INSERT INTO account_status (account_status_name) VALUES ('Active');
INSERT INTO account_status (account_status_name) VALUES ('Inactive');
-- Thêm các dòng dữ liệu khác nếu cần thiết

INSERT INTO role (role_name) VALUES ('Admin');
INSERT INTO role (role_name) VALUES ('User');
-- Thêm các dòng dữ liệu khác nếu cần thiết

INSERT INTO ranked (rank_name, minimum_point) VALUES ('Silver', 100);
INSERT INTO ranked (rank_name, minimum_point) VALUES ('Gold', 500);
-- Thêm các dòng dữ liệu khác nếu cần thiết


INSERT INTO gender (gender_name) VALUES ('Male');
INSERT INTO gender (gender_name) VALUES ('Female');
-- Thêm các dòng dữ liệu khác nếu cần thiết


INSERT INTO type (type_name) VALUES ('Type A');
INSERT INTO type (type_name) VALUES ('Type B');
-- Thêm các dòng dữ liệu khác nếu cần thiết

INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (1,'Đầm Nữ Banks',4.5,'2023-09-11 00:00:00.000000','0','1','Màu Sắc YELLOW/ GOLD Chất liệu Body: 18% Polyamide, 82% VISCOSE',1,1490000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (2,'Áo Liền Quần Iggyp',4.2,'2023-09-11 00:00:00.000000','1','0','Màu Sắc BLACK Chất liệu 98% Cotton, 02% Elastane',1,1999000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (3,'Áo Len Foilc',4.5,'2023-09-11 00:00:00.000000','0','1','Màu Sắc RUST - COPPER Chất liệu 100% Acrylic',1,1999000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (4,'Quần Jeans Violet',4.2,'2023-09-11 00:00:00.000000','1','0','Màu Sắc DARK BLUE Chất liệu 99% Cotton, 01% Elastane',1,1699000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (5,'Quần Khaki Nam Ngắn Chino Shorts',4.5,'2023-09-11 00:00:00.000000','0','1','Màu Sắc HARVEST GOLD TWILL Chất liệu 100% Cotton',1,999000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (6,'Áo Thun Nữ',4.2,'2023-09-11 00:00:00.000000','0','1','Màu Sắc SPORTSWEAR LOGO WHITE Chất liệu 100% Cotton',1,2599000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (7,'Áo Lạnh Nữ',4.5,'2023-09-11 00:00:00.000000','0','1','Màu Sắc CK BLACK Chất liệu 62% Organic Cotton, 35% Polyester, 3% Elastane',1,1999000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (8,'Áo Khoác Nữ Micro Cardigan',4.2,'2023-09-11 00:00:00.000000','0','1','Màu Sắc IVORY Chất liệu 100% Cotton',1,1599000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (9,'Quần Jeans Nam Body Fit',4.5,'2023-09-11 00:00:00.000000','0','1','Màu Sắc DENIM BLACK Chất liệu 70% Cotton 28% Polyester 2% Elastane',1,999000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (10,'Áo Khoác Nam',4.2,'2023-09-11 00:00:00.000000','0','1','Màu Sắc ASPHALT Chất liệu 100% Polyester',1,1799000,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (11,'Product 11',4.8,'2023-09-11 00:00:00.000000','1','0','Description of Product 3',1,45,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (12,'Product 15',4.5,'2023-10-12 00:00:00.000000','1','0','Product 1 Description',1,100,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (13,'Product 16',3.8,'2023-10-12 00:00:00.000000','0','1','Product 2 Description',2,150,NULL);
INSERT INTO product (product_id,product_name,product_rating,create_date,is_accepted,is_remove,product_description,brand_id,price,directory_lv1_id) VALUES (14,'Product 17',4.2,'2023-10-12 00:00:00.000000','0','1','Product 3 Description',1,120,NULL);



