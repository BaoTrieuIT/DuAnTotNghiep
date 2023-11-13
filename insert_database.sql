
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

-- Insert data into `gender` table
INSERT INTO gender (gender_name) VALUES 
	('Male'),
	('Female');
    
-- Insert data into `directory` table
INSERT INTO `directory` (directory_name, gender_id) VALUES
    ('Main Directory',1),
    ('Sub Directory 1',1),
    ('Sub Directory 2',1);
    
-- Insert data into `directory_lv1` table
INSERT INTO `directory_lv1` (directory_lv1_name, directory_id) VALUES
    ('Category 1', 1),
    ('Category 2', 1);
    
-- Insert data into `address` table
INSERT INTO `address` (recipient_name, recipient_phone_number, general_address, specific_address, account_id) VALUES
	('John Home', '1234567890', '123 Main St', 'Apt 4B', 1),
	('Jane Work', '9876543210', '456 Elm St', 'Suite 202', 2);
    
-- Insert data into `account_status` table
INSERT INTO account_status (account_status_name) VALUES 
	('Active'),
	('Inactive');
    
-- Insert data into `role` table
INSERT INTO role (role_name) VALUES 
	('Admin'),
	('User');
    
-- Insert data into `type` table
INSERT INTO type (type_name) VALUES 
	('Type A'),
	('Type B');
    
-- Insert data into `accounts_roles` table
INSERT INTO `accounts_roles` VALUES 
(1,1),
(2,2);

-- Insert data into `brand` table
INSERT INTO `brand` (`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES 
 ('Louis Vuitton','images/cac-thuong-hieu-thoi-trang-noi-tieng.png','Các dòng sản phẩm đang kinh doanh: Quần áo, giày dép, trang sức, đồng hồ đeo tay, đồ da,…','louisvuitton.com',b'1'),
 ('Gucci','images/cac-thuong-hieu-thoi-trang-noi-tieng-1.png','Gucci có sự phát triển vô cùng mạnh mẽ, trở thành biểu tượng thời trang hàng đầu thế giới với những dòng sản phẩm độc đáo, đẳng cấp và đại diện cho thương hiệu xa xỉ bậc nhất hiện nay.','gucci.com',b'1'),
 ('Hermès','images/cac-thuong-hieu-thoi-trang-noi-tieng-2.png','Hermès sở hữu những bộ sưu tập vô cùng đa dạng, phong phú với thiết kế thủ công tinh xảo, tỉ mỉ đến từng chi tiết. Đó cũng là lý do khiến thương hiệu này trở thành cái tên số 1 thế giới trong lĩnh vực thời trang.','hermes.com',b'1'),
 ('Céline','images/tui-xach-celine-duoc-thiet-ke-don-gian-nhung-vo-cung-sang-trong.png','Thương hiệu Céline nổi tiếng về đồ da và quần áo nổi tiếng, cao cấp. Những mẫu thiết kế của Céline luôn hướng đến phong cách sang trọng, trẻ trung, thời thượng, vừa cổ điển vừa hiện đại, đặc biệt là tính ứng dụng cao trong cuộc sống hàng ngày.','céline.com',b'1'),
 ('Loewe','images/mau-tui-xach-moi-la-cao-cap-cua-loewe.png','Loewe được biết đến là một thương hiệu thời trang nổi tiếng thế giới với các mẫu túi xách, quần áo cao cấp.','loewe.com',b'1'),
 ('Chanel','images/cac-thuong-hieu-thoi-trang-noi-tieng-5.png','Mỗi sản phẩm của Chanel đều mang phong cách đẳng cấp, luôn đề cao sự sang trọng, xa hoa, quyền quý và sự tinh tế lên đến cực đỉnh từ nước hoa, quần áo, đồng hồ,…','chanel.com',b'1'),
 ('Prada','images/cac-thuong-hieu-thoi-trang-noi-tieng-6.png','Các sản phẩm của hãng luôn được thiết kế với phong cách độc lạ nhưng cũng không kém phần cổ điển để khẳng định được đẳng cấp và sự khác biệt của mình.','Prada.com',b'1'),
 ('Christian Dior','images/cac-thuong-hieu-thoi-trang-noi-tieng-7.png','Thành công của Dior đến từ những sản phẩm thời trang nam nữ kết hợp với các thương hiệu cũng như các nhà thiết kế nổi tiếng như Nike, Matthew Williams của Alyx.','Dior.com',b'1'),
 ('Versace','images/cac-thuong-hieu-thoi-trang-noi-tieng-8.png','Phong cách thiết kế thời trang của Versace luôn mang nét đặc trưng nghệ thuật trong đường nét, chất liệu, màu sắc, họa tiết.','versace.com',b'1'),
 ('Burberry','images/cac-thuong-hieu-thoi-trang-noi-tieng-9.png','Điểm nổi bật của những sản phẩm trong Burberry chính là họa tiết các hình sọc vuông ấn tượng, độc lạ, đặc trưng giữa hàng trăm thương hiệu thời trang nổi tiếng khác.','Burberry.com',b'1'),
 ('CHANCOS','images/thuong-hieu-thoi-trang-cao-cap-tai-viet-nam-chancos-600x600.jpg','Cho dù bạn có vóc dáng cao thấp, gầy béo như thế nào đi chăng nữa thì CHANCOS đều có thiết kế phù hợp. Đến với CHANCOS đảm bảo bạn sẽ không bao giờ phải thất vọng.','chancosvn.com',b'1'),
 ('SIXDO','images/hang-thoi-trang-cao-cap-sixdo-600x458.jpg','SIXDO là hãng thời trang cao cấp của nhà thiết kế Đỗ Mạnh Cường. Nếu như bạn thường xuyên xem các show thời trang thì chắc hẳn không còn quá xa lạ với thương hiệu này nữa.','sixdo.vn',b'1'),
 ('Dolce & Gabbana','images/a1_2.jpg','Dolce & Gabbana là một thương hiệu thời trang cao cấp, được thành lập bởi hai nhà thiết kế thời trang người Ý là Domenico Dolce và Stefano Gabbana.','dolcegabbana.com',b'1'),
 ('Giorgio Armani S.p. A.','images/w1200.webp','Giorgio Armani S.p.A được biết đến nhiều hơn dưới tên Armani, là một hãng thời trang nổi tiếng thế giới của Ý','armani.com',b'1'),
 ('Vera Wang','images/homepage-23-wedding.jpg','Thương hiệu váy cưới nổi tiếng','verawang.com',b'1'),
 ('DKNY','images/dk_10.15_hp_desktop_hero.webp','DKNY là một hãng thời trang có trụ sở tại Thành phố New York chuyên về hàng thời trang cho nam và nữ','donnakaran.com',b'1'),
 ('Paul Stuart','images/80663061-3280-20.jpg','Paul Stuart là thương hiệu quần áo cao cấp dành cho nam và nữ được thành lập vào năm 1938 tại thành phố New York','paulstuart.com',b'1'),
 ('Loro Piana','images/Cocooning-Assets-411x514-11-.jpg','Loro Piana là một công ty vải và quần áo của Ý chuyên về các sản phẩm cashmere và len cao cấp, sang trọng.','us.loropiana.com',b'1'),
 ('Calvin Klein','images/Fall_Outerwear_M_2x.webp','Calvin Klein là một nhãn hiệu thời trang được nhà thiết kế cùng tên Calvin Klein thành lập năm 1968.','calvinklein.us',b'1'),
 ('Miu Miu','images/MiuMiuNUXlogo.svg','Miu Miu là thương hiệu quần áo và phụ kiện thời trang cao cấp của Ý và là công ty con thuộc sở hữu hoàn toàn của Prada.','miumiu.com',b'1'),
 ('Cesare Attolini','images/tải xuống.webp','Cesare Attolini là một thương hiệu thời trang nam sang trọng được thành lập tại Naples vào những năm 1930 bởi Vincenzo Attolini','cesareattolini.com',b'1'),
 ('JUNO','images/brand-viet-nam-1_72.jpg','Là một trong những thương hiệu thời trang Việt Nam nổi tiếng với hệ thống chi nhánh khắp cả nước, JUNO đã chinh phục những người yêu thích thời trang bằng những sản phẩm thời trang, hiện đại được thiết kế từ chính người Việt.','juno.vn',b'1'),
 ('OWEN','images/brand-viet-nam-3_51.webp','Đối với các quý ông, OWEN chính là thương hiệu thời trang nổi tiếng dành riêng cho nam giới. Tuy ra nhập thị trường Việt Nam khá muộn, nhưng OWEN đã nhanh chóng khẳng định vị thế của mình bằng chất lượng cực tốt.','owen.vn',b'1'),
 ('NOVELTY','images/brand-viet-nam-7_1.webp','NOVELTY là thương hiệu thời trang chuẩn mực, lịch lãm nhưng cũng rất cá tính và năng động.','www.novelty.com.vn',b'1');

-- Insert data into `category_level_1` table
INSERT INTO `category_level_1` (`category_level_1_name`) VALUES
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size'),
('Size');
-- Insert data into `category_level_1_detail` table
INSERT INTO `category_level_1_detail` (`category_level_1_detail_name`,`category_level_1_id`) VALUES 
('S',1),
('M',1),
('L',1),
('XL',1),
('S',2),
('M',2),
('L',2),
('XL',2),
('S',3),
('M',3),
('L',3),
('XL',3),
('S',4),
('M',4),
('L',4),
('XL',4),
('S',5),
('M',5),
('L',5),
('XL',5),
('S',6),
('M',6),
('L',6),
('XL',6),
('S',7),
('M',7),
('L',7),
('XL',7),
('S',8),
('M',8),
('L',8),
('XL',8),
('S',9),
('M',9),
('L',9),
('XL',9),
('S',10),
('M',10),
('L',10),
('XL',10),
('S',11),
('M',11),
('L',11),
('XL',11),
('S',12),
('M',12),
('L',12),
('XL',12),
('S',13),
('M',13),
('L',13),
('XL',13),
('S',14),
('M',14),
('L',14),
('XL',14),
('S',15),
('M',15),
('L',15),
('XL',15),
('S',16),
('M',16),
('L',16),
('XL',16),
('S',17),
('M',17),
('L',17),
('XL',17),
('S',18),
('M',18),
('L',18),
('XL',18),
('S',19),
('M',19),
('L',19),
('XL',19),
('S',20),
('M',20),
('L',20),
('XL',20);


-- Insert data into `category_level_2` table
INSERT INTO `category_level_2` (`category_level_2_name`) VALUES 
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color'),
('Color');

-- Insert data into `category_level_2_detail` table
INSERT INTO `category_level_2_detail` (`category_level_2_detail_name`,`category_level_2_id`) VALUES 
('Cam',1),
('Vang',1),
('Trang',1),
('Do',1),
('Cam',2),
('Vang',2),
('Trang',2),
('Do',2),
('Cam',3),
('Vang',3),
('Trang',3),
('Do',3),
('Cam',4),
('Vang',4),
('Trang',4),
('Do',4),
('Cam',5),
('Vang',5),
('Trang',5),
('Do',5),
('Cam',6),
('Vang',6),
('Trang',6),
('Do',6),
('Cam',7),
('Vang',7),
('Trang',7),
('Do',7),
('Cam',8),
('Vang',8),
('Trang',8),
('Do',8),
('Cam',9),
('Vang',9),
('Trang',9),
('Do',9),
('Cam',10),
('Vang',10),
('Trang',10),
('Do',10),
('Cam',11),
('Vang',11),
('Trang',11),
('Do',11),
('Cam',12),
('Vang',12),
('Trang',12),
('Do',12),
('Cam',13),
('Vang',13),
('Trang',13),
('Do',13),
('Cam',14),
('Vang',14),
('Trang',14),
('Do',14),
('Cam',15),
('Vang',15),
('Trang',15),
('Do',15),
('Cam',16),
('Vang',16),
('Trang',16),
('Do',16),
('Cam',17),
('Vang',17),
('Trang',17),
('Do',17),
('Cam',18),
('Vang',18),
('Trang',18),
('Do',18),
('Cam',19),
('Vang',19),
('Trang',19),
('Do',19),
('Cam',20),
('Vang',20),
('Trang',20),
('Do',20);

-- Insert data into `directory` table
INSERT INTO `directory` (`directory_name`,`gender_id`) VALUES 
('Quần','1'),
('Áo','1'),
('Phụ kiện','2'),
('Váy','2');


-- Insert data into `directory_lv1` table
INSERT INTO `directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES 
('Quần tây', '1'),
('Quần jean', '1'),
('Áo Sơ mi', '2'),
('Áo thun ', '2'),
('Áo tay dài', '2'),
('Quần ngắn', '1'),
('KÍnh', '3'),
('Mũ vành', '3'),
('Mũ phớt', '3'),
('Nón sơn', '3');



-- Insert data into `product` table
INSERT INTO `product` (`product_name`,`product_rating`,`create_date`,`is_remove`,`product_description`,`brand_id`,`directory_lv1_id`,`price_min`,`price_max`,`total_quantity`) VALUES 
('Đầm Nữ Banks',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc YELLOW/ GOLD Chất liệu Body: 18% Polyamide, 82% VISCOSE',1,1,800000,1000000,1600),
('Áo Liền Quần Iggyp',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BLACK Chất liệu 98% Cotton, 02% Elastane',1,1,300000,500000,0),
('Áo Len Foilc',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc RUST - COPPER Chất liệu 100% Acrylic',1,1,2000000,2500000,1600),
('Quần Jeans Violet',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DARK BLUE Chất liệu 99% Cotton 01% Elastane',1,1,800000,1000000,1600),
('Quần Khaki Nam Ngắn Chino Shorts',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc HARVEST GOLD TWILL Chất liệu 100% Cotton',1,1,600000,800000,1600),
('Áo Thun Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc SPORTSWEAR LOGO WHITE Chất liệu 100% Cotton',1,1,1500000,1800000,1600),
('Áo Lạnh Nữ',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc CK BLACK Chất liệu 62% Organic Cotton, 35% Polyester, 3% Elastane',1,1,990000,1200000,1600),
('Áo Khoác Nữ Micro Cardigan',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc IVORY Chất liệu 100% Cotton',1,1,3900000,4200000,0),
('Quần Jeans Nam Body Fit',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc DENIM BLACK Chất liệu 70% Cotton 28% Polyester 2% Elastane',1,1,799000,999000,1600),
('Áo Khoác Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ASPHALT Chất liệu 100% Polyester',1,1,690000,890000,1600),
('Quần Vải Dài Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc TRUE BLACK',1,1,1000000,1200000,16000),
('Áo Sơ Mi Tay Dài Nam',4.7,'2023-09-11 00:00:00.000000',0,'Màu Sắc GREEN STRIPE',1,2,690000,890000,1600),
('Quần Vải Dài Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BLACK MOSS',1,2,1690000,1890000,16000),
('Quần Vải Dài Nam - Essential Khaki Slim Fit',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ICONIC KHAKI',1,1,2690000,2890000,1600), 
('Nón Nam - Logo',4.7,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP GARNET RED 501',1,3,290000,490000,16000),
('Áo Sơ Mi Tay Ngắn Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc NAVY GINGHAM',1,1,890000,1890000,1600), 
('Quần Short Vải Nam - 8 Inch Vintage Short',4.9,'2023-09-11 00:00:00.000000',0,'Màu Sắc PILOT GREY',1,2,1690000,1890000,16000),
('Đầm Vải Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BURGUNDY PINK FLORAL',1,1,3890000,4290000,1600),
('Đầm Vải Nữ Deep',4.3,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP DEPTHS GRN 190413',1,2,490000,690000,16000),
('Đầm Thun Nữ - Logo',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP GARNET RED 501',1,1,899000,990000,1600);


-- Insert data into `product_image` table
INSERT INTO `product_image` (`image_url`,`product_id`) VALUES 
('product1.png',1),
('product1_1.png',1),
('product1_2.png',1),
('product2.png',2),
('product2_1.png',2),
('product2_2.png',2),
('product3.png',3),
('product3_1.png',3),
('product3_2.png',3),
('product4.png',4),
('product4_1.png',4),
('product4_2.png',4),
('product5.png',5),
('product5_1.png',5),
('product5_2.png',5),
('product6.png',6),
('product6_1.png',6),
('product6_2.png',6),
('product7.png',7),
('product7_1.png',7),
('product7_2.png',7),
('product8.png',8),
('product8_1.png',8),
('product8_2.png',8),
('product9.png',9),
('product9_1.png',9),
('product9_2.png',9),
('product10.png',10),
('product10_1.png',10),
('product10_2.png',10),
('product11.png',11),
('product11_1.png',11),
('product11_2.png',11),
('product12.png',12),
('product12_1.png',12),
('product12_2.png',12),
('product13.png',13),
('product13_1.png',13),
('product13_2.png',13),
('product14.png',14),
('product14_1.png',14),
('product14_2.png',14),
('product15.png',15),
('product15_1.png',15),
('product15_2.png',15),
('product15_3.png',15),
('product16.png',16),
('product16_1.png',16),
('product16_2.png',16),
('product17.png',17),
('product17_1.png',17),
('product17_2.png',17),
('product17_3.png',17),
('product18.png',18),
('product18_1.png',18),
('product18_2.png',18),
('product19.png',19),
('product19_1.png',19),
('product19_2.png',19),
('product20.png',20),
('product20_1.png',20),
('product20_2.png',20),
('product20_3.png',20);

INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (1,'MANGO','images/cac-thuong-hieu-thoi-trang-noi-tieng.png','Các dòng sản phẩm đang kinh doanh: Quần áo, giày dép, trang sức, đồng hồ đeo tay, đồ da,…','shop.mango.com/vn/men','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (2,'GAP','images/cac-thuong-hieu-thoi-trang-noi-tieng-1.png','Gucci có sự phát triển vô cùng mạnh mẽ, trở thành biểu tượng thời trang hàng đầu thế giới với những dòng sản phẩm độc đáo, đẳng cấp và đại diện cho thương hiệu xa xỉ bậc nhất hiện nay.','gap.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (3,'LEVI\'S','images/cac-thuong-hieu-thoi-trang-noi-tieng-2.png','Hermès sở hữu những bộ sưu tập vô cùng đa dạng, phong phú với thiết kế thủ công tinh xảo, tỉ mỉ đến từng chi tiết. Đó cũng là lý do khiến thương hiệu này trở thành cái tên số 1 thế giới trong lĩnh vực thời trang.','levi.com.vn','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (4,'BANANA REPUBLIC','images/tui-xach-celine-duoc-thiet-ke-don-gian-nhung-vo-cung-sang-trong.png','Thương hiệu Céline nổi tiếng về đồ da và quần áo nổi tiếng, cao cấp. Những mẫu thiết kế của Céline luôn hướng đến phong cách sang trọng, trẻ trung, thời thượng, vừa cổ điển vừa hiện đại, đặc biệt là tính ứng dụng cao trong cuộc sống hàng ngày.','bananarepublic.gap.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (5,'OLD NAVY','images/mau-tui-xach-moi-la-cao-cap-cua-loewe.png','Loewe được biết đến là một thương hiệu thời trang nổi tiếng thế giới với các mẫu túi xách, quần áo cao cấp.','oldnavy.gap.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (6,'TOMMY HILFIGER','images/cac-thuong-hieu-thoi-trang-noi-tieng-5.png','Mỗi sản phẩm của Chanel đều mang phong cách đẳng cấp, luôn đề cao sự sang trọng, xa hoa, quyền quý và sự tinh tế lên đến cực đỉnh từ nước hoa, quần áo, đồng hồ,…','usa.tommy.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (7,'OVS','images/cac-thuong-hieu-thoi-trang-noi-tieng-6.png','Các sản phẩm của hãng luôn được thiết kế với phong cách độc lạ nhưng cũng không kém phần cổ điển để khẳng định được đẳng cấp và sự khác biệt của mình.','www.ovsfashion.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (8,'SISLEY','images/cac-thuong-hieu-thoi-trang-noi-tieng-7.png','Thành công của Dior đến từ những sản phẩm thời trang nam nữ kết hợp với các thương hiệu cũng như các nhà thiết kế nổi tiếng như Nike, Matthew Williams của Alyx.','world.sisley.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (9,'KARL LAGERFELD','images/cac-thuong-hieu-thoi-trang-noi-tieng-8.png','Phong cách thiết kế thời trang của Versace luôn mang nét đặc trưng nghệ thuật trong đường nét, chất liệu, màu sắc, họa tiết.','www.karl.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (12,'PARFOIS','images/hang-thoi-trang-cao-cap-sixdo-600x458.jpg','SIXDO là hãng thời trang cao cấp của nhà thiết kế Đỗ Mạnh Cường. Nếu như bạn thường xuyên xem các show thời trang thì chắc hẳn không còn quá xa lạ với thương hiệu này nữa.','www.parfois.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (13,'FITFLOP','images/a1_2.jpg','Dolce & Gabbana là một thương hiệu thời trang cao cấp, được thành lập bởi hai nhà thiết kế thời trang người Ý là Domenico Dolce và Stefano Gabbana.','www.fitflop.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (14,'TYPO','images/w1200.webp','Giorgio Armani S.p.A được biết đến nhiều hơn dưới tên Armani, là một hãng thời trang nổi tiếng thế giới của Ý','typo.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (15,'DOCKERS','images/homepage-23-wedding.jpg','Thương hiệu váy cưới nổi tiếng','us.dockers.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (16,'SWAROVSKI','images/dk_10.15_hp_desktop_hero.webp','DKNY là một hãng thời trang có trụ sở tại Thành phố New York chuyên về hàng thời trang cho nam và nữ','www.swarovski.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (17,'UNITED COLORS OF BENETTON','images/80663061-3280-20.jpg','Paul Stuart là thương hiệu quần áo cao cấp dành cho nam và nữ được thành lập vào năm 1938 tại thành phố New York','us.benetton.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (18,'POLO RALPH LAUREN','images/Cocooning-Assets-411x514-11-.jpg','Loro Piana là một công ty vải và quần áo của Ý chuyên về các sản phẩm cashmere và len cao cấp, sang trọng.','www.ralphlauren.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (19,'CALVIN KLEIN','images/Fall_Outerwear_M_2x.webp','Calvin Klein là một nhãn hiệu thời trang được nhà thiết kế cùng tên Calvin Klein thành lập năm 1968.','calvinklein.us','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (20,'SUNNIES STUDIOS','images/MiuMiuNUXlogo.svg','Miu Miu là thương hiệu quần áo và phụ kiện thời trang cao cấp của Ý và là công ty con thuộc sở hữu hoàn toàn của Prada.','sunniesstudios.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (21,'OWNDAYS','images/tải xuống.webp','Cesare Attolini là một thương hiệu thời trang nam sang trọng được thành lập tại Naples vào những năm 1930 bởi Vincenzo Attolini','www.owndays.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (22,'FRENCH CONNECTION','images/brand-viet-nam-1_72.jpg','Là một trong những thương hiệu thời trang Việt Nam nổi tiếng với hệ thống chi nhánh khắp cả nước, JUNO đã chinh phục những người yêu thích thời trang bằng những sản phẩm thời trang, hiện đại được thiết kế từ chính người Việt.','www.frenchconnection.com','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (23,'OWEN','images/brand-viet-nam-3_51.webp','Đối với các quý ông, OWEN chính là thương hiệu thời trang nổi tiếng dành riêng cho nam giới. Tuy ra nhập thị trường Việt Nam khá muộn, nhưng OWEN đã nhanh chóng khẳng định vị thế của mình bằng chất lượng cực tốt.','owen.vn','1');
INSERT INTO `brand` (`brand_id`,`brand_name`,`logo_url`,`another_information`,`website_url`,`is_active`) VALUES (24,'MOTHERCARE','images/brand-viet-nam-7_1.webp','NOVELTY là thương hiệu thời trang chuẩn mực, lịch lãm nhưng cũng rất cá tính và năng động.','www.mothercare.com.vn','1');

-- Insert data into `category_quantity` table
INSERT INTO `category_quantity` (`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES 
 (1,1,1,100,1000000),
 (1,2,1,100,1000000),
 (1,3,1,100,1000000),
 (1,4,1,100,1000000),
 (2,1,1,100,1000000),
 (2,2,1,100,1000000),
 (2,3,1,100,1000000),
 (2,4,1,100,1000000),
 (3,1,1,100,1000000),
 (3,2,1,100,1000000),
 (3,3,1,100,1000000),
 (3,4,1,100,1000000),
 (4,1,1,100,1000000),
 (4,2,1,100,1000000),
 (4,3,1,100,1000000),
 (4,4,1,100,1000000),
 (5,5,2,0,500000),
 (5,6,2,0,500000),
 (5,7,2,0,500000),
 (5,8,2,0,500000),
 (6,5,2,0,500000),
 (6,6,2,0,500000),
 (6,7,2,0,500000),
 (6,8,2,0,500000),
 (7,5,2,0,500000),
 (7,6,2,0,500000),
 (7,7,2,0,500000),
 (7,8,2,0,500000),
 (8,5,2,0,500000),
 (8,6,2,0,500000),
 (8,7,2,0,500000),
 (8,8,2,0,500000),
 (9,9,3,100,2500000),
 (9,10,3,100,2500000),
 (9,11,3,100,2500000),
 (9,12,3,100,2500000),
 (10,9,3,100,2500000),
 (10,10,3,100,2500000),
 (10,11,3,100,2500000),
 (10,12,3,100,2500000),
 (11,9,3,100,2500000),
 (11,10,3,100,2500000),
 (11,11,3,100,2500000),
 (11,12,3,100,2500000),
 (12,9,3,100,2500000),
 (12,10,3,100,2500000),
 (12,11,3,100,2500000),
 (12,12,3,100,2500000),
 (13,13,4,100,1000000),
 (13,14,4,100,1000000),
 (13,15,4,100,1000000),
 (13,16,4,100,1000000),
 (14,13,4,100,1000000),
 (14,14,4,100,1000000),
 (14,15,4,100,1000000),
 (14,16,4,100,1000000),
 (15,13,4,100,1000000),
 (15,14,4,100,1000000),
 (15,15,4,100,1000000),
 (15,16,4,100,1000000),
 (16,13,4,100,1000000),
 (16,14,4,100,1000000),
 (16,15,4,100,1000000),
 (16,16,4,100,1000000),
 (17,17,5,100,800000),
 (17,18,5,100,800000),
 (17,19,5,100,800000),
 (17,20,5,100,800000),
 (18,17,5,100,800000),
 (18,18,5,100,800000),
 (18,19,5,100,800000),
 (18,20,5,100,800000),
 (19,17,5,100,800000),
 (19,18,5,100,800000),
 (19,19,5,100,800000),
 (19,20,5,100,800000),
 (20,17,5,100,800000),
 (20,18,5,100,800000),
 (20,19,5,100,800000),
 (20,20,5,100,800000),
 (21,21,6,100,1800000),
 (21,22,6,100,1800000),
 (21,23,6,100,1800000),
 (21,24,6,100,1800000),
 (22,21,6,100,1800000),
 (22,22,6,100,1800000),
 (22,23,6,100,1800000),
 (22,24,6,100,1800000),
 (23,21,6,100,1800000),
 (23,22,6,100,1800000),
 (23,23,6,100,1800000),
 (23,24,6,100,1800000),
 (24,21,6,100,1800000),
 (24,22,6,100,1800000),
 (24,23,6,100,1800000),
 (24,24,6,100,1800000),
 (25,25,7,100,1200000),
 (25,26,7,100,1200000),
 (25,27,7,100,1200000),
 (25,28,7,100,1200000),
 (26,25,7,100,1200000),
 (26,26,7,100,1200000),
 (26,27,7,100,1200000),
 (26,28,7,100,1200000),
 (27,25,7,100,1200000),
 (27,26,7,100,1200000),
 (27,27,7,100,1200000),
 (27,28,7,100,1200000),
 (28,25,7,100,1200000),
 (28,26,7,100,1200000),
 (28,27,7,100,1200000),
 (28,28,7,100,1200000),
 (29,29,8,0,4200000),
 (29,30,8,0,4200000),
 (29,31,8,0,4200000),
 (29,32,8,0,4200000),
 (30,29,8,0,4200000),
 (30,30,8,0,4200000),
 (30,31,8,0,4200000),
 (30,32,8,0,4200000),
 (31,29,8,0,4200000),
 (31,30,8,0,4200000),
 (31,31,8,0,4200000),
 (31,32,8,0,4200000),
 (32,29,8,0,4200000),
 (32,30,8,0,4200000),
 (32,31,8,0,4200000),
 (32,32,8,0,4200000),
 (33,33,9,100,999000),
 (33,34,9,100,999000),
 (33,35,9,100,999000),
 (33,36,9,100,999000),
 (34,33,9,100,999000),
 (34,34,9,100,999000),
 (34,35,9,100,999000),
 (34,36,9,100,999000),
 (35,33,9,100,999000),
 (35,34,9,100,999000),
 (35,35,9,100,999000),
 (35,36,9,100,999000),
 (36,33,9,100,999000),
 (36,34,9,100,999000),
 (36,35,9,100,999000),
 (36,36,9,100,999000),
 (37,37,10,100,890000),
 (37,38,10,100,890000),
 (37,39,10,100,890000),
 (37,40,10,100,890000),
 (38,37,10,100,890000),
 (38,38,10,100,890000),
 (38,39,10,100,890000),
 (38,40,10,100,890000),
 (39,37,10,100,890000),
 (39,38,10,100,890000),
 (39,39,10,100,890000),
 (39,40,10,100,890000),
 (40,37,10,100,890000),
 (40,38,10,100,890000),
 (40,39,10,100,890000),
 (40,40,10,100,890000),
 (41,41,11,100,1200000),
 (41,42,11,100,1200000),
 (41,43,11,100,1200000),
 (41,44,11,100,1200000),
 (42,41,11,100,1200000),
 (42,42,11,100,1200000),
 (42,43,11,100,1200000),
 (42,44,11,100,1200000),
 (43,41,11,100,1200000),
 (43,42,11,100,1200000),
 (43,43,11,100,1200000),
 (43,44,11,100,1200000),
 (44,41,11,100,1200000),
 (44,42,11,100,1200000),
 (44,43,11,100,1200000),
 (44,44,11,100,1200000),
 (45,45,12,100,890000),
 (45,46,12,100,890000),
 (45,47,12,100,890000),
 (45,48,12,100,890000),
 (46,45,12,100,890000),
 (46,46,12,100,890000),
 (46,47,12,100,890000),
 (46,48,12,100,890000),
 (47,45,12,100,890000),
 (47,46,12,100,890000),
 (47,47,12,100,890000),
 (47,48,12,100,890000),
 (48,45,12,100,890000),
 (48,46,12,100,890000),
 (48,47,12,100,890000),
 (48,48,12,100,890000),
 (49,49,13,1000,1890000),
 (49,50,13,1000,1890000),
 (49,51,13,1000,1890000),
 (49,52,13,1000,1890000),
 (50,49,13,1000,1890000),
 (50,50,13,1000,1890000),
 (50,51,13,1000,1890000),
 (50,52,13,1000,1890000),
 (51,49,13,1000,1890000),
 (51,50,13,1000,1890000),
 (51,51,13,1000,1890000),
 (51,52,13,1000,1890000),
 (52,49,13,1000,1890000),
 (52,50,13,1000,1890000),
 (52,51,13,1000,1890000),
 (52,52,13,1000,1890000),
 (53,53,14,100,2890000),
 (53,54,14,100,2890000),
 (53,55,14,100,2890000),
 (53,56,14,100,2890000),
 (54,53,14,100,2890000),
 (54,54,14,100,2890000),
 (54,55,14,100,2890000),
 (54,56,14,100,2890000),
 (55,53,14,100,2890000),
 (55,54,14,100,2890000),
 (55,55,14,100,2890000),
 (55,56,14,100,2890000),
 (56,53,14,100,2890000),
 (56,54,14,100,2890000),
 (56,55,14,100,2890000),
 (56,56,14,100,2890000),
 (57,57,15,1000,490000),
 (57,58,15,1000,490000),
 (57,59,15,1000,490000),
 (57,60,15,1000,490000),
 (58,57,15,1000,490000),
 (58,58,15,1000,490000),
 (58,59,15,1000,490000),
 (58,60,15,1000,490000),
 (59,57,15,1000,490000),
 (59,58,15,1000,490000),
 (59,59,15,1000,490000),
 (59,60,15,1000,490000),
 (60,57,15,1000,490000),
 (60,58,15,1000,490000),
 (60,59,15,1000,490000),
 (60,60,15,1000,490000),
 (61,61,16,100,1890000),
 (61,62,16,100,1890000),
 (61,63,16,100,1890000),
 (61,64,16,100,1890000),
 (62,61,16,100,1890000),
 (62,62,16,100,1890000),
 (62,63,16,100,1890000),
 (62,64,16,100,1890000),
 (63,61,16,100,1890000),
 (63,62,16,100,1890000),
 (63,63,16,100,1890000),
 (63,64,16,100,1890000),
 (64,61,16,100,1890000),
 (64,62,16,100,1890000),
 (64,63,16,100,1890000),
 (64,64,16,100,1890000),
 (65,65,17,1000,1890000),
 (65,66,17,1000,1890000),
 (65,67,17,1000,1890000),
 (65,68,17,1000,1890000),
 (66,65,17,1000,1890000),
 (66,66,17,1000,1890000),
 (66,67,17,1000,1890000),
 (66,68,17,1000,1890000),
 (67,65,17,1000,1890000),
 (67,66,17,1000,1890000),
 (67,67,17,1000,1890000),
 (67,68,17,1000,1890000),
 (68,65,17,1000,1890000),
 (68,66,17,1000,1890000),
 (68,67,17,1000,1890000),
 (68,68,17,1000,1890000),
 (69,69,18,100,4290000),
 (69,70,18,100,4290000),
 (69,71,18,100,4290000),
 (69,72,18,100,4290000),
 (70,69,18,100,4290000),
 (70,70,18,100,4290000),
 (70,71,18,100,4290000),
 (70,72,18,100,4290000),
 (71,69,18,100,4290000),
 (71,70,18,100,4290000),
 (71,71,18,100,4290000),
 (71,72,18,100,4290000),
 (72,69,18,100,4290000),
 (72,70,18,100,4290000),
 (72,71,18,100,4290000),
 (72,72,18,100,4290000),
 (73,73,19,1000,690000),
 (73,74,19,1000,690000),
 (73,75,19,1000,690000),
 (73,76,19,1000,690000),
 (74,73,19,1000,690000),
 (74,74,19,1000,690000),
 (74,75,19,1000,690000),
 (74,76,19,1000,690000),
 (75,73,19,1000,690000),
 (75,74,19,1000,690000),
 (75,75,19,1000,690000),
 (75,76,19,1000,690000),
 (76,73,19,1000,690000),
 (76,74,19,1000,690000),
 (76,75,19,1000,690000),
 (76,76,19,1000,690000),
 (77,77,20,100,990000),
 (77,78,20,100,990000),
 (77,79,20,100,990000),
 (77,80,20,100,990000),
 (78,77,20,100,990000),
 (78,78,20,100,990000),
 (78,79,20,100,990000),
 (78,80,20,100,990000),
 (79,77,20,100,990000),
 (79,78,20,100,990000),
 (79,79,20,100,990000),
 (79,80,20,100,990000),
 (80,77,20,100,990000),
 (80,78,20,100,990000),
 (80,79,20,100,990000),
 (80,80,20,100,990000);