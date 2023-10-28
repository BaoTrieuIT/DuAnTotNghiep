
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
INSERT INTO `product` (`product_name`,`product_rating`,`create_date`,`is_remove`,`product_description`,`brand_id`,`directory_lv1_id`) VALUES 
 ('Đầm Nữ Banks',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc YELLOW/ GOLD Chất liệu Body: 18% Polyamide, 82% VISCOSE',1,NULL),
 ('Áo Liền Quần Iggyp',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BLACK Chất liệu 98% Cotton, 02% Elastane',1,NULL),
 ('Áo Len Foilc',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc RUST - COPPER Chất liệu 100% Acrylic',1,NULL),
 ('Quần Jeans Violet',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DARK BLUE Chất liệu 99% Cotton 01% Elastane',1,NULL),
 ('Quần Khaki Nam Ngắn Chino Shorts',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc HARVEST GOLD TWILL Chất liệu 100% Cotton',1,NULL),
 ('Áo Thun Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc SPORTSWEAR LOGO WHITE Chất liệu 100% Cotton',1,NULL),
 ('Áo Lạnh Nữ',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc CK BLACK Chất liệu 62% Organic Cotton, 35% Polyester, 3% Elastane',1,NULL),
 ('Áo Khoác Nữ Micro Cardigan',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc IVORY Chất liệu 100% Cotton',1,NULL),
 ('Quần Jeans Nam Body Fit',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc DENIM BLACK Chất liệu 70% Cotton 28% Polyester 2% Elastane',1,NULL),
 ('Áo Khoác Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ASPHALT Chất liệu 100% Polyester',1,NULL),
 ('Product 11',4.8,'2023-09-11 00:00:00.000000',0,'Description of Product 3',1,NULL),
 ('Product 15',4.5,'2023-10-12 00:00:00.000000',0,'Product 1 Description',1,NULL),
 ('Product 16',3.8,'2023-10-12 00:00:00.000000',0,'Product 2 Description',2,NULL),
 ('Product 17',4.2,'2023-10-12 00:00:00.000000',0,'Product 3 Description',1,NULL);



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
