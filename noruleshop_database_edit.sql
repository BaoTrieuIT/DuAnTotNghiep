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

create table `address_type`(
	address_type_id int auto_increment primary key,
    Address_type_name nvarchar(50)
) ;


-- Addres
create table `address`(
	address_id int auto_increment primary key,  
    recipient_name nvarchar(50),
    recipient_phone_number varchar(10),
    general_address nvarchar(255),
    specific_address nvarchar(255),
    Address_type_id int,
    account_id int,
    foreign key (Address_type_id) references `Address_type`(Address_type_id),
    foreign key (account_id) references `account`(account_id)
);


create table `directory`(
	directory_id int auto_increment primary key,
    directory_name nvarchar(255) not null
);

create table `directory_lv1`(
	directory_lv1_id int auto_increment primary key,
    directory_lv1_name nvarchar(255) not null,
    directory_id int,
	foreign key (directory_id) references `directory`(directory_id)
);


create table `directory_lv2`(
	directory_lv2_id int auto_increment primary key,
    directory_lv2_name nvarchar(255) not null,
    directory_lv1_id int,
	foreign key (directory_lv1_id) references `directory_lv1`(directory_lv1_id)
);


create table `directory_lv3`(
	directory_lv3_id int auto_increment primary key,
    directory_lv3_name nvarchar(255) not null,
    directory_lv2_id int,
	foreign key (directory_lv2_id) references `directory_lv2`(directory_lv2_id)
);

create table `information_type`(
	information_type_id int auto_increment primary key,
    information_type_name nvarchar(255) not null,
    directory_id int, 
    foreign key (directory_id) references `directory`(directory_id)
);

create table `detail_information_type`(
	detail_information_type int auto_increment primary key,
    information_type_id int,
    detail_Information_type_name nvarchar(255),
	foreign key (information_type_id) references `information_type`(information_type_id)
);



create table `brand`(
	brand_id int auto_increment primary key,
    brand_name nvarchar(255) not null,
    logo_url varchar(255) not null,
    website_url varchar(255) not null,
    another_information nvarchar(1000),
    is_excepted bit not null,
    directory_lv1_id int not null,
	foreign key (directory_lv1_id) references `directory_lv1`(directory_lv1_id)
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
	foreign key (brand_id) references `brand`(brand_id)
);


create table `product_discount`(
	product_discount_id int auto_increment primary key,
	product_discount_valid_from date not null,
    product_discount_valid_to date not null,
    product_discount_value float not null,
    quantity int null,
    product_id int,
    foreign key (product_id) references `product`(product_id)
);


create table `product_image`(
	product_image_id int auto_increment primary key,
	image_url varchar(255) not null,
    create_date date not null,
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


create table `delivery_method`(
	delivery_method_id int auto_increment primary key,
    delivery_method_name nvarchar(255)
);

create table `order`(
	order_id int auto_increment primary key, 
    order_time datetime,
    discount_amout int not null,
    recipient_name nvarchar(255) not null,
    phonenunber char(10) not null,
    specified_address nvarchar(255) not null,
	account_id int,
    voucher_id int null ,
	payment_status_id int,
    order_status_id int,
    payment_method_id int,
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
	foreign key (order_id) references `order`(order_id),
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
	deedback_report  int AUTO_INCREMENT primary key,
    report_date date not null,
    `description` nvarchar(1000) not null,
    feedback_id int not null,
    account_id int not null,
    report_status_id int not null,
	foreign key (feedback_id) references `feedback`(feedback_id),
	foreign key (account_id) references `account`(account_id),
	foreign key (report_status_id) references `report_status`(report_status_id)
);

-- Insert data into `account_status` table
INSERT INTO `account_status` (account_status_name) VALUES
    ('Active'),
    ('Suspended'),
    ('Inactive');

-- Insert data into `role` table
INSERT INTO `role` (role_name) VALUES
    ('Admin'),
    ('User');

-- Insert data into `ranked` table
INSERT INTO `ranked` (rank_name, minimum_point) VALUES
    ('Bronze', 0),
    ('Silver', 1000),
    ('Gold', 5000);

-- Insert data into `account` table
INSERT INTO `account` (password, fullname, phone_number, email, username, create_date, birthday, avatar_url, role_id, ranked_id, account_status_id) VALUES
    ('password1', 'John Doe', '1234567890', 'john@example.com', 'johndoe', '2023-09-11', '1990-01-15', 'avatar1.jpg', 2, 1, 1),
    ('password2', 'Jane Smith', '9876543210', 'jane@example.com', 'janesmith', '2023-09-11', '1985-03-20', 'avatar2.jpg', 2, 2, 1);

-- Insert data into `address_type` table
INSERT INTO `address_type` (Address_type_name) VALUES
    ('Home'),
    ('Work');

-- Insert data into `address` table
INSERT INTO `address` (recipient_name, recipient_phone_number, general_address, specific_address, Address_type_id, account_id) VALUES
    ('John Home', '1234567890', '123 Main St', 'Apt 4B', 1, 1),
    ('Jane Work', '9876543210', '456 Elm St', 'Suite 202', 2, 2);
-- Insert data into `directory` table
INSERT INTO `directory` (directory_name) VALUES
    ('Main Directory'),
    ('Sub Directory 1'),
    ('Sub Directory 2');

-- Insert data into `directory_lv1` table
INSERT INTO `directory_lv1` (directory_lv1_name, directory_id) VALUES
    ('Category 1', 1),
    ('Category 2', 1);

-- Insert data into `directory_lv2` table
INSERT INTO `directory_lv2` (directory_lv2_name, directory_lv1_id) VALUES
    ('Subcategory 1-1', 1),
    ('Subcategory 1-2', 1),
    ('Subcategory 2-1', 2);

-- Insert data into `directory_lv3` table
INSERT INTO `directory_lv3` (directory_lv3_name, directory_lv2_id) VALUES
    ('Sub-subcategory 1-1-1', 1),
    ('Sub-subcategory 1-1-2', 1),
    ('Sub-subcategory 1-2-1', 2),
    ('Sub-subcategory 2-1-1', 3);

-- Insert data into `information_type` table
INSERT INTO `information_type` (information_type_name, directory_id) VALUES
    ('Info Type 1', 1),
    ('Info Type 2', 1),
    ('Info Type 3', 2);

-- Insert data into `detail_information_type` table
INSERT INTO `detail_information_type` (information_type_id, detail_Information_type_name) VALUES
    (1, 'Detail Type 1-1'),
    (1, 'Detail Type 1-2'),
    (2, 'Detail Type 2-1');

-- Insert data into `brand` table
INSERT INTO `brand` (brand_name, logo_url, website_url, another_information, is_excepted, directory_lv1_id) VALUES
    ('Brand 1', 'logo1.jpg', 'https://www.brand1.com', 'Additional info about Brand 1', 0, 1),
    ('Brand 2', 'logo2.jpg', 'https://www.brand2.com', 'Additional info about Brand 2', 1, 2);

-- Insert data into `brand_image` table
INSERT INTO `brand_image` (imag_url, brand_id) VALUES
    ('brand1_image.jpg', 1),
    ('brand2_image.jpg', 2);
-- Insert data into `product` table
INSERT INTO `product` (product_name, product_rating, create_date, is_accepted, is_remove, product_description, brand_id, price) VALUES
    ('Product 1', 4.5, '2023-09-11', 1, 0, 'Description of Product 1', 1, 50),
    ('Product 2', 4.2, '2023-09-11', 1, 0, 'Description of Product 2', 1, 60),
    ('Product 3', 4.8, '2023-09-11', 1, 0, 'Description of Product 3', 2, 45);

-- Insert data into `product_discount` table
INSERT INTO `product_discount` (product_discount_valid_from, product_discount_valid_to, product_discount_value, quantity, product_id) VALUES
    ('2023-09-11', '2023-09-30', 10.0, 100, 1),
    ('2023-09-11', '2023-09-30', 15.0, 50, 2),
    ('2023-09-11', '2023-09-30', 5.0, 200, 3);

-- Insert data into `product_image` table
INSERT INTO `product_image` (image_url, create_date, product_id) VALUES
    ('product1_image.jpg', '2023-09-11', 1),
    ('product2_image.jpg', '2023-09-11', 2),
    ('product3_image.jpg', '2023-09-11', 3);

-- Insert data into `category_level_1` table
INSERT INTO `category_level_1` (category_level_1_name) VALUES
    ('Category Level 1-1'),
    ('Category Level 1-2');

-- Insert data into `category_level_2` table
INSERT INTO `category_level_2` (category_level_2_name) VALUES
    ('Category Level 2-1'),
    ('Category Level 2-2');

-- Insert data into `category_level_1_detail` table
INSERT INTO `category_level_1_detail` (category_level_1_detail_name, category_level_1_id) VALUES
    ('Category L1 Detail 1-1', 1),
    ('Category L1 Detail 1-2', 1),
    ('Category L1 Detail 2-1', 2);

-- Insert data into `category_level_2_detail` table
INSERT INTO `category_level_2_detail` (category_level_2_detail_name, category_level_2_id) VALUES
    ('Category L2 Detail 1-1', 1),
    ('Category L2 Detail 1-2', 1),
    ('Category L2 Detail 2-1', 2);

-- Insert data into `category_quantity` table
INSERT INTO `category_quantity` (category_level_1_detail_id, category_level_2_detail_id, product_id, quantity, price) VALUES
    (1, 1, 1, 100, 50),
    (1, 2, 2, 75, 60),
    (2, 3, 3, 150, 45);

-- Insert data into `voucher` table
INSERT INTO `voucher` (voucher_value, voucher_code, valid_from, valid_to, minimize_order_amount, quantity_available) VALUES
    (10.0, 'VOUCHER10', '2023-09-11', '2023-09-30', 50, 100),
    (15.0, 'VOUCHER15', '2023-09-11', '2023-09-30', 75, 200);

-- Insert data into `payment_method` table
INSERT INTO `payment_method` (payment_method_name) VALUES
    ('Credit Card'),
    ('PayPal'),
    ('Cash On Delivery');

-- Insert data into `payment_status` table
INSERT INTO `payment_status` (payment_status_name) VALUES
    ('Pending'),
    ('Paid'),
    ('Failed');

-- Insert data into `order_status` table
INSERT INTO `order_status` (order_status_name) VALUES
    ('Processing'),
    ('Shipped'),
    ('Delivered');

-- Insert data into `delivery_method` table
INSERT INTO `delivery_method` (delivery_method_name) VALUES
    ('Standard Shipping'),
    ('Express Shipping');

-- Insert data into `order` table
INSERT INTO `order` (order_time, discount_amout, recipient_name, phonenunber, specified_address, account_id, voucher_id, payment_status_id, order_status_id, payment_method_id) VALUES
    ('2023-09-11 10:00:00', 10, 'John Doe', '1234567890', '123 Main St, Apt 4B', 1, 1, 2, 1, 1),
    ('2023-09-12 11:30:00', 15, 'Jane Smith', '9876543210', '456 Elm St, Suite 202', 2, 2, 1, 2, 2);

-- Insert data into `order_detail` table
INSERT INTO `order_detail` (quantity, unit_price, discount_amout, total_price_before_discount, total_price, order_id, product_id) VALUES
    (2, 50, 10, 100, 90, 1, 1),
    (3, 60, 15, 180, 165, 2, 2);

-- Insert data into `feedback` table
INSERT INTO `feedback` (feedback_rating, comment, feedback_time, account_id, order_detail_id) VALUES
    (4, 'Great product!', '2023-09-13 09:45:00', 1, 1),
    (5, 'Excellent service!', '2023-09-14 15:30:00', 2, 2);

-- Insert data into `feedback_image` table
INSERT INTO `feedback_image` (image_url, feedback_id) VALUES
    ('feedback_image1.jpg', 1),
    ('feedback_image2.jpg', 2);

-- Insert data into `report_status` table
INSERT INTO `report_status` (report_status_name) VALUES
    ('Open'),
    ('Closed');

-- Insert data into `feedback_report` table
INSERT INTO `feedback_report` (report_date, `description`, feedback_id, account_id, report_status_id) VALUES
    ('2023-09-15', 'Reported inappropriate content', 1, 2, 1),
    ('2023-09-16', 'Resolved issue', 2, 1, 2);

select * from feedback