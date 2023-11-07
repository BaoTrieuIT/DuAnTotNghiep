
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

-- Insert data into `product` table
INSERT INTO `product` (`product_name`,`product_rating`,`create_date`,`is_remove`,`product_description`,`brand_id`,`directory_lv1_id`,`price_min`,`price_max`,`total_quantity`) VALUES 
('Đầm Nữ Banks',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc YELLOW/ GOLD Chất liệu Body: 18% Polyamide, 82% VISCOSE',1,1,800000,1000000,100),
('Áo Liền Quần Iggyp',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BLACK Chất liệu 98% Cotton, 02% Elastane',1,1,300000,500000,0),
('Áo Len Foilc',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc RUST - COPPER Chất liệu 100% Acrylic',1,1,2000000,2500000,100),
('Quần Jeans Violet',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DARK BLUE Chất liệu 99% Cotton 01% Elastane',1,1,800000,1000000,100),
('Quần Khaki Nam Ngắn Chino Shorts',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc HARVEST GOLD TWILL Chất liệu 100% Cotton',1,1,600000,800000,100),
('Áo Thun Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc SPORTSWEAR LOGO WHITE Chất liệu 100% Cotton',1,1,1500000,1800000,100),
('Áo Lạnh Nữ',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc CK BLACK Chất liệu 62% Organic Cotton, 35% Polyester, 3% Elastane',1,1,990000,1200000,100),
('Áo Khoác Nữ Micro Cardigan',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc IVORY Chất liệu 100% Cotton',1,1,3900000,4200000,0),
('Quần Jeans Nam Body Fit',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc DENIM BLACK Chất liệu 70% Cotton 28% Polyester 2% Elastane',1,1,799000,999000,100),
('Áo Khoác Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ASPHALT Chất liệu 100% Polyester',1,1,690000,890000,100),
('Quần Vải Dài Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc	TRUE BLACK',1,1,1000000,1200000,1000),
('Áo Sơ Mi Tay Dài Nam',4.7,'2023-09-11 00:00:00.000000',0,'Màu Sắc	GREEN STRIPE',1,2,690000,890000,100),
('Quần Vải Dài Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc	BLACK MOSS',1,2,1690000,1890000,1000),
('Quần Vải Dài Nam - Essential Khaki Slim Fit',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ICONIC KHAKI',1,1,2690000,2890000,100), 
('Nón Nam - Logo',4.7,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP GARNET RED 501',1,3,290000,490000,1000),
('Áo Sơ Mi Tay Ngắn Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc NAVY GINGHAM',1,1,890000,1890000,100), 
('Quần Short Vải Nam - 8 Inch Vintage Short',4.9,'2023-09-11 00:00:00.000000',0,'Màu Sắc PILOT GREY',1,2,1690000,1890000,1000),
('Đầm Vải Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BURGUNDY PINK FLORAL',1,1,3890000,4290000,100),
('Đầm Vải Nữ Deep',4.3,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP DEPTHS GRN 190413',1,2,490000,690000,1000),
('Đầm Thun Nữ - Logo',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP GARNET RED 501',1,1,899000,990000,100);


INSERT INTO `category_level_1` (`category_level_1_id`,`category_level_1_name`) VALUES
('1','Size'),
('2','Size'),
('3','Size'),
('4','Size'),
('5','Size'),
('6','Size'),
('7','Size'),
('8','Size'),
('9','Size'),
('10','Size'),
('11','Size'),
('12','Size'),
('13','Size'),
('14','Size'),
('15','Size'),
('16','Size'),
('17','Size'),
('18','Size'),
('19','Size'),
('20','Size');

INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (1,'S',1);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (2,'M',1);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (3,'L',1);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (4,'XL',1);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (5,'S',2);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (6,'M',2);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (7,'L',2);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (8,'XL',2);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (9,'S',3);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (10,'M',3);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (11,'L',3);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (12,'XL',3);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (13,'S',4);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (14,'M',4);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (15,'L',4);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (16,'XL',4);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (17,'S',5);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (18,'M',5);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (19,'L',5);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (20,'XL',5);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (21,'S',6);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (22,'M',6);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (23,'L',6);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (24,'XL',6);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (25,'S',7);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (26,'M',7);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (27,'L',7);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (28,'XL',7);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (29,'S',8);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (30,'M',8);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (31,'L',8);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (32,'XL',8);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (33,'S',9);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (34,'M',9);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (35,'L',9);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (36,'XL',9);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (37,'S',10);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (38,'M',10);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (39,'L',10);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (40,'XL',10);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (41,'S',11);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (42,'M',11);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (43,'L',11);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (44,'XL',11);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (45,'S',12);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (46,'M',12);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (47,'L',12);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (48,'XL',12);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (49,'S',13);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (50,'M',13);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (51,'L',13);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (52,'XL',13);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (53,'S',14);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (54,'M',14);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (55,'L',14);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (56,'XL',14);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (57,'S',15);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (58,'M',15);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (59,'L',15);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (60,'XL',15);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (61,'S',16);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (62,'M',16);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (63,'L',16);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (64,'XL',16);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (65,'S',17);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (66,'M',17);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (67,'L',17);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (68,'XL',17);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (69,'S',18);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (70,'M',18);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (71,'L',18);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (72,'XL',18);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (73,'S',19);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (74,'M',19);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (75,'L',19);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (76,'XL',19);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (77,'S',20);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (78,'M',20);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (79,'L',20);
INSERT INTO `category_level_1_detail` (`category_level_1_detail_id`,`category_level_1_detail_name`,`category_level_1_id`) VALUES (80,'XL',20);



INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (1,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (2,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (3,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (4,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (5,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (6,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (7,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (8,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (9,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (10,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (11,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (12,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (13,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (14,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (15,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (16,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (17,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (18,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (19,'Color');
INSERT INTO `category_level_2` (`category_level_2_id`,`category_level_2_name`) VALUES (20,'Color');


INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (1,'Cam',1);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (2,'Vang',1);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (3,'Trang',1);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (4,'Do',1);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (5,'Cam',2);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (6,'Vang',2);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (7,'Trang',2);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (8,'Do',2);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (9,'Cam',3);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (10,'Vang',3);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (11,'Trang',3);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (12,'Do',3);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (13,'Cam',4);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (14,'Vang',4);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (15,'Trang',4);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (16,'Do',4);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (17,'Cam',5);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (18,'Vang',5);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (19,'Trang',5);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (20,'Do',5);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (21,'Cam',6);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (22,'Vang',6);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (23,'Trang',6);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (24,'Do',6);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (25,'Cam',7);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (26,'Vang',7);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (27,'Trang',7);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (28,'Do',7);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (29,'Cam',8);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (30,'Vang',8);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (31,'Trang',8);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (32,'Do',8);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (33,'Cam',9);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (34,'Vang',9);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (35,'Trang',9);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (36,'Do',9);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (37,'Cam',10);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (38,'Vang',10);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (39,'Trang',10);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (40,'Do',10);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (41,'Cam',11);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (42,'Vang',11);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (43,'Trang',11);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (44,'Do',11);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (45,'Cam',12);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (46,'Vang',12);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (47,'Trang',12);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (48,'Do',12);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (49,'Cam',13);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (50,'Vang',13);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (51,'Trang',13);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (52,'Do',13);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (53,'Cam',14);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (54,'Vang',14);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (55,'Trang',14);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (56,'Do',14);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (57,'Cam',15);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (58,'Vang',15);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (59,'Trang',15);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (60,'Do',15);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (61,'Cam',16);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (62,'Vang',16);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (63,'Trang',16);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (64,'Do',16);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (65,'Cam',17);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (66,'Vang',17);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (67,'Trang',17);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (68,'Do',17);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (69,'Cam',18);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (70,'Vang',18);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (71,'Trang',18);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (72,'Do',18);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (73,'Cam',19);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (74,'Vang',19);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (75,'Trang',19);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (76,'Do',19);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (77,'Cam',20);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (78,'Vang',20);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (79,'Trang',20);
INSERT INTO `category_level_2_detail` (`category_level_2_detail_id`,`category_level_2_detail_name`,`category_level_2_id`) VALUES (80,'Do',20);

-- Insert data into `directory` table
INSERT INTO `directory` (`directory_name`,`gender_id`) VALUES 
('Quần','1'),
('Áo','1'),
('Phụ kiện','2'),
('Váy','2');



INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Quần tây', '1');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Quần jean', '1');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Áo Sơ mi', '2');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Áo thun ', '2');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Áo tay dài', '2');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Quần ngắn', '1');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('KÍnh', '3');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Mũ vành', '3');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Mũ phớt', '3');
INSERT INTO `norule_shop`.`directory_lv1` (`directory_lv1_name`, `directory_id`) VALUES ('Nón sơn', '3');
-- Thêm các dòng dữ liệu khác nếu cần thiết

INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (1,1,1,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (2,1,2,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (3,1,3,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (4,1,4,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (5,2,1,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (6,2,2,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (7,2,3,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (8,2,4,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (9,3,1,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (10,3,2,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (11,3,3,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (12,3,4,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (13,4,1,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (14,4,2,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (15,4,3,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (16,4,4,1,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (17,5,5,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (18,5,6,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (19,5,7,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (20,5,8,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (21,6,5,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (22,6,6,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (23,6,7,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (24,6,8,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (25,7,5,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (26,7,6,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (27,7,7,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (28,7,8,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (29,8,5,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (30,8,6,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (31,8,7,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (32,8,8,2,0,500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (33,9,9,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (34,9,10,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (35,9,11,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (36,9,12,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (37,10,9,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (38,10,10,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (39,10,11,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (40,10,12,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (41,11,9,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (42,11,10,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (43,11,11,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (44,11,12,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (45,12,9,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (46,12,10,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (47,12,11,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (48,12,12,3,100,2500000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (49,13,13,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (50,13,14,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (51,13,15,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (52,13,16,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (53,14,13,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (54,14,14,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (55,14,15,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (56,14,16,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (57,15,13,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (58,15,14,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (59,15,15,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (60,15,16,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (61,16,13,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (62,16,14,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (63,16,15,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (64,16,16,4,100,1000000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (65,17,17,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (66,17,18,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (67,17,19,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (68,17,20,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (69,18,17,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (70,18,18,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (71,18,19,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (72,18,20,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (73,19,17,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (74,19,18,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (75,19,19,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (76,19,20,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (77,20,17,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (78,20,18,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (79,20,19,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (80,20,20,5,100,800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (81,21,21,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (82,21,22,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (83,21,23,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (84,21,24,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (85,22,21,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (86,22,22,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (87,22,23,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (88,22,24,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (89,23,21,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (90,23,22,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (91,23,23,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (92,23,24,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (93,24,21,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (94,24,22,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (95,24,23,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (96,24,24,6,100,1800000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (97,25,25,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (98,25,26,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (99,25,27,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (100,25,28,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (101,26,25,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (102,26,26,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (103,26,27,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (104,26,28,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (105,27,25,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (106,27,26,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (107,27,27,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (108,27,28,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (109,28,25,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (110,28,26,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (111,28,27,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (112,28,28,7,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (113,29,29,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (114,29,30,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (115,29,31,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (116,29,32,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (117,30,29,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (118,30,30,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (119,30,31,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (120,30,32,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (121,31,29,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (122,31,30,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (123,31,31,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (124,31,32,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (125,32,29,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (126,32,30,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (127,32,31,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (128,32,32,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (129,33,33,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (130,33,34,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (131,33,35,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (132,33,36,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (133,34,33,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (134,34,34,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (135,34,35,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (136,34,36,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (137,35,33,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (138,35,34,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (139,35,35,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (140,35,36,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (141,36,33,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (142,36,34,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (143,36,35,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (144,36,36,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (145,37,37,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (146,37,38,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (147,37,39,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (148,37,40,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (149,38,37,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (150,38,38,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (151,38,39,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (152,38,40,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (153,39,37,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (154,39,38,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (155,39,39,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (156,39,40,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (157,40,37,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (158,40,38,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (159,40,39,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (160,40,40,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (161,41,41,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (162,41,42,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (163,41,43,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (164,41,44,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (165,42,41,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (166,42,42,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (167,42,43,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (168,42,44,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (169,43,41,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (170,43,42,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (171,43,43,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (172,43,44,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (173,44,41,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (174,44,42,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (175,44,43,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (176,44,44,11,100,1200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (177,45,45,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (178,45,46,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (179,45,47,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (180,45,48,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (181,46,45,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (182,46,46,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (183,46,47,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (184,46,48,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (185,47,45,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (186,47,46,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (187,47,47,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (188,47,48,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (189,48,45,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (190,48,46,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (191,48,47,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (192,48,48,12,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (193,49,49,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (194,49,50,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (195,49,51,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (196,49,52,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (197,50,49,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (198,50,50,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (199,50,51,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (200,50,52,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (201,51,49,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (202,51,50,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (203,51,51,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (204,51,52,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (205,52,49,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (206,52,50,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (207,52,51,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (208,52,52,13,1000,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (209,53,53,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (210,53,54,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (211,53,55,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (212,53,56,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (213,54,53,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (214,54,54,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (215,54,55,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (216,54,56,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (217,55,53,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (218,55,54,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (219,55,55,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (220,55,56,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (221,56,53,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (222,56,54,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (223,56,55,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (224,56,56,14,100,2890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (225,57,57,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (226,57,58,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (227,57,59,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (228,57,60,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (229,58,57,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (230,58,58,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (231,58,59,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (232,58,60,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (233,59,57,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (234,59,58,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (235,59,59,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (236,59,60,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (237,60,57,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (238,60,58,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (239,60,59,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (240,60,60,15,1000,490000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (241,61,61,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (242,61,62,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (243,61,63,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (244,61,64,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (245,62,61,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (246,62,62,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (247,62,63,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (248,62,64,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (249,63,61,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (250,63,62,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (251,63,63,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (252,63,64,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (253,64,61,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (254,64,62,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (255,64,63,16,100,1890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (256,64,64,16,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (257,65,65,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (258,65,66,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (259,65,67,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (260,65,68,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (261,66,65,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (262,66,66,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (263,66,67,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (264,66,68,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (265,67,65,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (266,67,66,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (267,67,67,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (268,67,68,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (269,68,65,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (270,68,66,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (271,68,67,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (272,68,68,17,1000,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (273,69,69,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (274,69,70,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (275,69,71,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (276,69,72,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (277,70,69,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (278,70,70,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (279,70,71,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (280,70,72,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (281,71,69,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (282,71,70,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (283,71,71,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (284,71,72,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (285,72,69,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (286,72,70,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (287,72,71,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (288,72,72,18,100,4290000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (289,73,73,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (290,73,74,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (291,73,75,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (292,73,76,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (293,74,73,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (294,74,74,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (295,74,75,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (296,74,76,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (297,75,73,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (298,75,74,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (299,75,75,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (300,75,76,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (301,76,73,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (302,76,74,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (303,76,75,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (304,76,76,19,1000,690000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (305,77,77,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (306,77,78,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (307,77,79,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (308,77,80,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (309,78,77,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (310,78,78,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (311,78,79,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (312,78,80,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (313,79,77,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (314,79,78,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (315,79,79,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (316,79,80,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (317,80,77,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (318,80,78,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (319,80,79,20,100,990000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (320,80,80,20,100,990000);

INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (1,'product1.png',1);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (2,'product2.png',2);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (3,'product3.png',3);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (4,'product4.png',4);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (5,'product5.png',5);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (6,'product6.png',6);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (7,'product7.png',7);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (8,'product8.png',8);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (9,'product9.png',9);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (10,'product10.png',10);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (11,'product11.png',11);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (12,'product12.png',12);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (13,'product13.png',13);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (14,'product14.png',14);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (15,'product15.png',15);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (16,'product16.png',16);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (17,'product17.png',17);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (18,'product18.png',18);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (19,'product19.png',19);
INSERT INTO `product_image` (`product_image_id`,`image_url`,`product_id`) VALUES (20,'product20.png',20);
