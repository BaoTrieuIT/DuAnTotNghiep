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
    address varchar(255),
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

create table `address`(
	address_id int auto_increment primary key,  
    recipient_name nvarchar(50),
    recipient_phone_number varchar(10),
    general_address nvarchar(255),
    specific_address nvarchar(255),
    account_id int,
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
	is_remove bit not null,
    product_description nvarchar(1000) not null,
    brand_id  int  not null,
    directory_lv1_id int,
    total_quantity int,
    -- new update 
    price_old float,
    price_new float,
    discount float,
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

create table `accounts_roles`(
account_roles int AUTO_INCREMENT primary key,
	account_id int,
    role_id int,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
    ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);



