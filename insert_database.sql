
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
	('Nam'),
	('Nữ'),
    ('Unisex');
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
 ('MANGO','images/cac-thuong-hieu-thoi-trang-noi-tieng.png','Các dòng sản phẩm đang kinh doanh: Quần áo, giày dép, trang sức, đồng hồ đeo tay, đồ da,…','shop.mango.com/vn/men',1),
 ('GAP','images/cac-thuong-hieu-thoi-trang-noi-tieng-1.png','Gucci có sự phát triển vô cùng mạnh mẽ, trở thành biểu tượng thời trang hàng đầu thế giới với những dòng sản phẩm độc đáo, đẳng cấp và đại diện cho thương hiệu xa xỉ bậc nhất hiện nay.','gap.com',1),
 ('LEVI\'S','images/cac-thuong-hieu-thoi-trang-noi-tieng-2.png','Hermès sở hữu những bộ sưu tập vô cùng đa dạng, phong phú với thiết kế thủ công tinh xảo, tỉ mỉ đến từng chi tiết. Đó cũng là lý do khiến thương hiệu này trở thành cái tên số 1 thế giới trong lĩnh vực thời trang.','levi.com.vn',1),
 ('BANANA REPUBLIC','images/tui-xach-celine-duoc-thiet-ke-don-gian-nhung-vo-cung-sang-trong.png','Thương hiệu Céline nổi tiếng về đồ da và quần áo nổi tiếng, cao cấp. Những mẫu thiết kế của Céline luôn hướng đến phong cách sang trọng, trẻ trung, thời thượng, vừa cổ điển vừa hiện đại, đặc biệt là tính ứng dụng cao trong cuộc sống hàng ngày.','bananarepublic.gap.com',1),
 ('OLD NAVY','images/mau-tui-xach-moi-la-cao-cap-cua-loewe.png','Loewe được biết đến là một thương hiệu thời trang nổi tiếng thế giới với các mẫu túi xách, quần áo cao cấp.','oldnavy.gap.com',1),
 ('TOMMY HILFIGER','images/cac-thuong-hieu-thoi-trang-noi-tieng-5.png','Mỗi sản phẩm của Chanel đều mang phong cách đẳng cấp, luôn đề cao sự sang trọng, xa hoa, quyền quý và sự tinh tế lên đến cực đỉnh từ nước hoa, quần áo, đồng hồ,…','usa.tommy.com',1),
 ('OVS','images/cac-thuong-hieu-thoi-trang-noi-tieng-6.png','Các sản phẩm của hãng luôn được thiết kế với phong cách độc lạ nhưng cũng không kém phần cổ điển để khẳng định được đẳng cấp và sự khác biệt của mình.','www.ovsfashion.com',1),
 ('SISLEY','images/cac-thuong-hieu-thoi-trang-noi-tieng-7.png','Thành công của Dior đến từ những sản phẩm thời trang nam nữ kết hợp với các thương hiệu cũng như các nhà thiết kế nổi tiếng như Nike, Matthew Williams của Alyx.','world.sisley.com',1),
 ('KARL LAGERFELD','images/cac-thuong-hieu-thoi-trang-noi-tieng-8.png','Phong cách thiết kế thời trang của Versace luôn mang nét đặc trưng nghệ thuật trong đường nét, chất liệu, màu sắc, họa tiết.','www.karl.com',1),
 ('PARFOIS','images/hang-thoi-trang-cao-cap-sixdo-600x458.jpg','SIXDO là hãng thời trang cao cấp của nhà thiết kế Đỗ Mạnh Cường. Nếu như bạn thường xuyên xem các show thời trang thì chắc hẳn không còn quá xa lạ với thương hiệu này nữa.','www.parfois.com',1),
 ('FITFLOP','images/a1_2.jpg','Dolce & Gabbana là một thương hiệu thời trang cao cấp, được thành lập bởi hai nhà thiết kế thời trang người Ý là Domenico Dolce và Stefano Gabbana.','www.fitflop.com',1),
 ('TYPO','images/w1200.webp','Giorgio Armani S.p.A được biết đến nhiều hơn dưới tên Armani, là một hãng thời trang nổi tiếng thế giới của Ý','typo.com',1),
 ('DOCKERS','images/homepage-23-wedding.jpg','Thương hiệu váy cưới nổi tiếng','us.dockers.com',1),
 ('SWAROVSKI','images/dk_10.15_hp_desktop_hero.webp','DKNY là một hãng thời trang có trụ sở tại Thành phố New York chuyên về hàng thời trang cho nam và nữ','www.swarovski.com',1),
 ('UNITED COLORS OF BENETTON','images/80663061-3280-20.jpg','Paul Stuart là thương hiệu quần áo cao cấp dành cho nam và nữ được thành lập vào năm 1938 tại thành phố New York','us.benetton.com',1),
 ('POLO RALPH LAUREN','images/Cocooning-Assets-411x514-11-.jpg','Loro Piana là một công ty vải và quần áo của Ý chuyên về các sản phẩm cashmere và len cao cấp, sang trọng.','www.ralphlauren.com',1),
 ('CALVIN KLEIN','images/Fall_Outerwear_M_2x.webp','Calvin Klein là một nhãn hiệu thời trang được nhà thiết kế cùng tên Calvin Klein thành lập năm 1968.','calvinklein.us',1),
 ('SUNNIES STUDIOS','images/MiuMiuNUXlogo.svg','Miu Miu là thương hiệu quần áo và phụ kiện thời trang cao cấp của Ý và là công ty con thuộc sở hữu hoàn toàn của Prada.','sunniesstudios.com',1),
 ('OWNDAYS','images/tải xuống.webp','Cesare Attolini là một thương hiệu thời trang nam sang trọng được thành lập tại Naples vào những năm 1930 bởi Vincenzo Attolini','www.owndays.com',1),
 ('FRENCH CONNECTION','images/brand-viet-nam-1_72.jpg','Là một trong những thương hiệu thời trang Việt Nam nổi tiếng với hệ thống chi nhánh khắp cả nước, JUNO đã chinh phục những người yêu thích thời trang bằng những sản phẩm thời trang, hiện đại được thiết kế từ chính người Việt.','www.frenchconnection.com',1),
 ('OWEN','images/brand-viet-nam-3_51.webp','Đối với các quý ông, OWEN chính là thương hiệu thời trang nổi tiếng dành riêng cho nam giới. Tuy ra nhập thị trường Việt Nam khá muộn, nhưng OWEN đã nhanh chóng khẳng định vị thế của mình bằng chất lượng cực tốt.','owen.vn',1),
 ('MOTHERCARE','images/brand-viet-nam-7_1.webp','NOVELTY là thương hiệu thời trang chuẩn mực, lịch lãm nhưng cũng rất cá tính và năng động.','www.mothercare.com.vn',1);

-- Insert data into `category_level_1` table
INSERT INTO `category_level_1` (`category_level_1_name`) VALUES
('Size');
-- Insert data into `category_level_1_detail` table
INSERT INTO `category_level_1_detail` (`category_level_1_detail_name`,`category_level_1_id`) VALUES 
('S',1),
('M',1),
('L',1),
('XL',1);

-- Insert data into `category_level_2` table
INSERT INTO `category_level_2` (`category_level_2_name`) VALUES 
('Color');
-- Insert data into `category_level_2_detail` table
INSERT INTO `category_level_2_detail` (`category_level_2_detail_name`,`category_level_2_id`) VALUES 
('Đen',1),
('Trắng',1),
('Nhiều màu',1);

-- Insert data into `directory` table
INSERT INTO `directory` (`directory_name`,`gender_id`) VALUES
    ('TRANG PHỤC NAM',1),
    ('TÚI VÍ NAM',1),
    ('GIÀY DÉP NAM',1),
    ('PHỤ KIỆN NAM',1),
    ('PHỤ KIỆN NỮ',2),
    ('GIÀY DÉP NỮ',2),
    ('TRANG SỨC NỮ',2),
    ('TÚI VÍ NỮ',2),
    ('MẮT KÍNH NỮ',2),
    ('TRANG PHỤC NỮ',2);
SELECT * from directory;
SELECT * from category_level_2_detail;
-- Insert data into `directory_lv1` table
INSERT INTO `directory_lv1` (`directory_lv1_name`,`directory_id`) VALUES
	('Mũ Nón', 4),
    ('Khăn Choàng', 4),
    ('Thắt Lưng', 4),
    ('Vớ', 4),
    ('Phụ kiện Vest', 4),
    ('Phụ kiện khác', 4),
    ('Ba Lô', 2),
    ('Túi Đeo Chéo/ Đeo Hông', 2),
    ('Ví Nam', 2),
    ('Túi Xách', 8),
    ('Túi Tote', 8),
    ('Túi - Ví Da', 8),
    ('Túi Cầm tay', 8),
    ('Giày Tây', 3),
    ('Sandel', 3),
    ('Giày Bốt', 3),
    ('Giày Thể Thao', 3),
    ('Dép Quai Ngang', 3),
    ('Giày Sneaker', 3),
    ('Giày Lười', 3),
    ('Dép Xỏ Ngón', 3),
    ('Thắt Lưng nữ', 5),
    ('Mũ Nón nữ', 5),
    ('Khăn & Khăn Choàng', 5),
    ('Găng Tay nữ', 5),
    ('Vớ nữ & Quần Tất', 5),
    ('Đồng Hồ', 5),
    ('Phụ kiện khác', 5),
    ('Giày Hở Gót', 6),
    ('Giày Búp Bê', 6),
    ('Giày Thể Thao', 6),
    ('Giày Cao Gót', 6),
    ('Giày Bốt nữ', 6),
    ('Sandal', 6),
    ('Giày Sneaker', 6),
    ('Giày Lười', 6),
    ('Dép Quai Ngang', 6),
    ('Dép Xỏ Ngón', 6),
    ('Hoa Tai', 7),
    ('Nhẫn', 7),
    ('Vòng Tay', 7),
    ('Dây Chuyền', 7),
    ('Trang sức khác', 7),
    ('Ba Lô nữ', 8),
    ('Túi Xách nữ', 8),
    ('Túi Đeo Chéo nữ', 8),
    ('Ví - Ví Đựng Thẻ nữ', 8),
    ('Ví Cầm Tay nữ', 8),
    ('Túi Tote', 8),
    ('Túi Ví Đi Tiệc', 8),
    ('Túi Đựng Mỹ Phẩm', 8),
    ('Kính Mát', 9),
    ('Gọng Kính Cận', 9),
    ('Kính Chống Ánh Sáng Xanh', 9),
    ('Phụ Kiện Mắt Kính', 9),
    ('Hộp Đựng Kính', 9),
    ('Đầm', 10),
    ('Váy', 10),
    ('Áo Sơ mi nữ', 10),
    ('Áo dây - Áo Ba Lỗ', 10),
    ('Áo Polo nữ', 10),
    ('Đồ Vest', 10),
    ('Áo Kiểu', 10),
    ('Áo Khoác nữ', 10),
    ('Áo Sweater nữ', 10),
    ('Áo Sweatshirt nữ', 10),
    ('Áo Hoodie & Sweater nữ', 10),
    ('Áo Thun nữ', 10),
    ('Quần Dài nữ', 10),
    ('Quần Jeans nữ', 10),
    ('Quần Short', 10),
    ('Jumpsuit & Playsuit', 10),
    ('Quần Yếm', 10),
    ('Đồ Ngủ', 10),
    ('Đồ Lót nữ', 10),
    ('Áo Sơ mi', 1),
    ('Áo Thun', 1),
    ('Áo Hoodie & Sweater', 1),
    ('Áo dệt kim- Cardigan', 1),
    ('Áo Blazer', 1),
    ('Áo Jacket', 1),
    ('Quần Dài', 1),
    ('Quần Jeans', 1),
    ('Quần Short', 1),
    ('Đồ Vest', 1),
    ('Đồ Thể Thao', 1),
    ('Đồ Lót', 1),
    ('Áo Polo', 1),
    ('Áo Khoác Nam', 1),
	('Áo Len Nữ', 10),
	('Quần Khaki Nam', 1);
select * from directory_lv1;
select * from product;
select * from brand;
select * from category_quantity;
-- Insert data into `product` table
INSERT INTO `product` (`product_name`,`product_rating`,`create_date`,`is_remove`,`product_description`,`brand_id`,`directory_lv1_id`,`price_min`,`price_max`,`total_quantity`) VALUES 
('Đầm Nữ Banks',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc YELLOW/ GOLD Chất liệu Body: 18% Polyamide, 82% VISCOSE',10 ,57,800000,1000000,5),
('Áo Liền Quần Iggyp',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BLACK Chất liệu 98% Cotton, 02% Elastane',1,63,300000,500000,0),
('Áo Len Foilc',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc RUST - COPPER Chất liệu 100% Acrylic',1,90,2000000,2500000,10),
('Quần Jeans Violet',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DARK BLUE Chất liệu 99% Cotton 01% Elastane',1,70,800000,1000000,1600),
('Quần Khaki Nam Ngắn Chino Shorts',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc HARVEST GOLD TWILL Chất liệu 100% Cotton',3,91,600000,800000,1600),
('Áo Thun Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc SPORTSWEAR LOGO WHITE Chất liệu 100% Cotton',1,68,1500000,1800000,1600),
('Áo Lạnh Nữ',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc CK BLACK Chất liệu 62% Organic Cotton, 35% Polyester, 3% Elastane',1,64,990000,1200000,1600),
('Áo Khoác Nữ Micro Cardigan',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc IVORY Chất liệu 100% Cotton',17,64,3900000,4200000,0),
('Quần Jeans Nam Body Fit',4.5,'2023-09-11 00:00:00.000000',0,'Màu Sắc DENIM BLACK Chất liệu 70% Cotton 28% Polyester 2% Elastane',17,83,799000,999000,1600),
('Áo Khoác Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ASPHALT Chất liệu 100% Polyester',7,89,690000,890000,1600),
('Quần Vải Dài Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc TRUE BLACK',2,82,1000000,1200000,16000),
('Áo Sơ Mi Tay Dài Nam',4.7,'2023-09-11 00:00:00.000000',0,'Màu Sắc GREEN STRIPE',2,76,690000,890000,1600),
('Quần Vải Dài Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BLACK MOSS',2,82,1690000,1890000,16000),
('Quần Vải Dài Nam - Essential Khaki Slim Fit',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc ICONIC KHAKI',2,82,2690000,2890000,1600), 
('Nón Nam - Logo',4.7,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP GARNET RED 501',2,1,290000,490000,16000),
('Áo Sơ Mi Tay Ngắn Nam',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc NAVY GINGHAM',1,76,890000,1890000,1600), 
('Quần Short Vải Nam - 8 Inch Vintage Short',4.9,'2023-09-11 00:00:00.000000',0,'Màu Sắc PILOT GREY',2,84,1690000,1890000,16000),
('Đầm Vải Nữ',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc BURGUNDY PINK FLORAL',2,57,3890000,4290000,1600),
('Đầm Vải Nữ Deep',4.3,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP DEPTHS GRN 190413',2,57,490000,690000,16000),
('Đầm Thun Nữ - Logo',4.2,'2023-09-11 00:00:00.000000',0,'Màu Sắc DEEP GARNET RED 501',2,57,899000,990000,1600);


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
select * from category_level_1_detail;
select * from category_level_2_detail;
SELECT * from category_quantity;
-- Insert data into `category_quantity` table
INSERT INTO `category_quantity` (`category_level_1_detail_id`,`category_level_2_detail_id`,`product_id`,`quantity`,`price`) VALUES 
 (1,1,1,100,1000000),
 (1,2,1,100,1000000),
 (1,3,2,0,500000),
 (2,1,2,0,500000),
 (1,1,3,100,2500000),
 (2,3,3,100,2500000),
 (2,1,4,100,1000000),
 (3,3,4,100,1000000),
 (2,1,5,100,800000),
 (4,2,5,100,800000),
 (1,3,6,100,1800000),
 (2,3,6,100,1800000),
 (3,2,6,100,1800000),
 (2,1,7,100,1200000),
 (1,2,7,100,1200000),
 (3,3,7,100,1200000),
 (1,1,8,0,4200000),
 (2,1,8,0,4200000),
 (3,2,8,0,4200000),
 (2,3,9,100,999000),
 (3,2,9,100,999000),
 (1,1,10,100,890000),
 (2,3,10,100,890000),
 (1,2,11,100,1200000),
 (2,2,11,100,1200000),
 (4,1,12,100,890000),
 (4,2,12,100,890000),
 (4,3,13,1000,1890000),
 (3,1,13,1000,1890000),
 (1,2,14,100,2890000),
 (2,1,14,100,2890000),
 (3,2,14,100,2890000),
 (4,1,15,1000,490000),
 (2,3,15,1000,490000),
 (3,2,15,1000,490000),
 (1,2,16,100,1890000),
 (4,1,16,100,1890000),
 (3,1,17,1000,1890000),
 (2,1,18,100,4290000),
 (3,3,18,100,4290000),
 (1,2,18,100,4290000),
 (3,3,19,1000,690000),
 (1,2,20,100,990000),
 (4,1,20,100,990000);
 
SELECT DISTINCT *
FROM category_quantity
WHERE category_level_1_detail_id = 1 and product_id = 1;
SELECT DISTINCT  *
FROM category_quantity
WHERE category_level_1_detail_id = 1 and product_id = 1