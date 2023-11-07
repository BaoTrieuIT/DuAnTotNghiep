
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
 ('Áo Khoác Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ASPHALT Chất liệu 100% Polyester',1,1,690000,890000,100);


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
('10','Size');

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
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (33,9,9,2,0,500000);
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
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (109,28,25,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (110,28,26,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (111,28,27,8,0,4200000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (112,28,28,8,0,4200000);
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
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (125,32,29,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (126,32,30,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (127,32,31,9,100,999000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (128,32,32,9,100,999000);
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
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (141,36,33,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (142,36,34,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (143,36,35,10,100,890000);
INSERT INTO `category_quantity` (`category_quantity_id`,`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES (144,36,36,10,100,890000);
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
