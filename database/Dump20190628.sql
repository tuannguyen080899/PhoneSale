-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: javacb9
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitietmuahang`
--

DROP TABLE IF EXISTS `chitietmuahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietmuahang` (
  `mamuahang` int(11) DEFAULT NULL,
  `masanpham` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `tien` int(11) DEFAULT NULL,
  `tienvon` int(11) DEFAULT NULL,
  KEY `mamuahang` (`mamuahang`),
  KEY `masanpham` (`masanpham`),
  CONSTRAINT `chitietmuahang_ibfk_1` FOREIGN KEY (`mamuahang`) REFERENCES `muahang` (`mamuahang`),
  CONSTRAINT `chitietmuahang_ibfk_2` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietmuahang`
--

LOCK TABLES `chitietmuahang` WRITE;
/*!40000 ALTER TABLE `chitietmuahang` DISABLE KEYS */;
INSERT INTO `chitietmuahang` VALUES (30,27,1,15800000,14200000),(31,16,1,5990000,5590000),(31,50,1,8050000,7300000),(31,32,3,19500000,18300000),(32,49,1,12050000,10500000),(33,47,1,9400000,8750000),(33,24,1,13400000,13000000),(33,55,2,30400000,27600000),(29,16,1,5990000,5590000),(34,25,1,3900000,3340000),(34,29,1,11000000,9900000),(36,25,2,7800000,6680000),(36,23,1,12300000,11790000),(36,22,1,14400000,13340000),(36,46,1,8400000,7900000),(36,14,1,3700000,3250000),(37,24,1,13400000,13000000),(38,14,1,3700000,3250000);
/*!40000 ALTER TABLE `chitietmuahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmucsanpham`
--

DROP TABLE IF EXISTS `danhmucsanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhmucsanpham` (
  `madanhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(200) NOT NULL,
  `trangthai` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`madanhmuc`),
  UNIQUE KEY `tendanhmuc` (`tendanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmucsanpham`
--

LOCK TABLES `danhmucsanpham` WRITE;
/*!40000 ALTER TABLE `danhmucsanpham` DISABLE KEYS */;
INSERT INTO `danhmucsanpham` VALUES (2,'Samsung',1),(6,'Oppo',1),(7,'Xiaomi',1),(10,'iPhone',1),(12,'Mezu',1);
/*!40000 ALTER TABLE `danhmucsanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachhang` (
  `makhachhang` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhachhang` varchar(200) DEFAULT NULL,
  `sodienthoai` varchar(10) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `makhuvuc` int(11) DEFAULT NULL,
  PRIMARY KEY (`makhachhang`),
  KEY `makhuvuc` (`makhuvuc`),
  CONSTRAINT `khachhang_ibfk_2` FOREIGN KEY (`makhuvuc`) REFERENCES `tinh` (`makhuvuc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muahang`
--

DROP TABLE IF EXISTS `muahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muahang` (
  `username` varchar(200) DEFAULT NULL,
  `mamuahang` int(11) NOT NULL AUTO_INCREMENT,
  `thoigian` date DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL,
  PRIMARY KEY (`mamuahang`),
  KEY `username` (`username`),
  CONSTRAINT `muahang_ibfk_1` FOREIGN KEY (`username`) REFERENCES `taikhoan` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muahang`
--

LOCK TABLES `muahang` WRITE;
/*!40000 ALTER TABLE `muahang` DISABLE KEYS */;
INSERT INTO `muahang` VALUES ('Phan Hải',29,'2019-06-26',2),('Phạm Quyền',30,'2019-06-13',1),('Phạm Quyền',31,'2019-06-13',1),('Phạm Quyền',32,'2019-06-15',1),('Phạm Quyền',33,'2019-06-26',2),('Phạm Quyền',34,'2019-06-26',2),('Phan Hải',35,'2019-06-26',0),('Phạm Quyền',36,'2019-06-28',1),('Phạm Quyền',37,'2019-06-28',1),('Phạm Quyền',38,'2019-06-28',0),('Phan Quý',39,'2019-06-28',0);
/*!40000 ALTER TABLE `muahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanpham` (
  `masanpham` int(11) NOT NULL AUTO_INCREMENT,
  `tensanpham` varchar(200) DEFAULT NULL,
  `gianhap` int(11) DEFAULT NULL,
  `giaban` int(11) DEFAULT NULL,
  `giagiam` int(11) DEFAULT NULL,
  `mausac` varchar(100) DEFAULT NULL,
  `mota` text,
  `bonho` varchar(20) DEFAULT NULL,
  `madanhmuc` int(11) DEFAULT NULL,
  `loai` tinyint(1) DEFAULT '1',
  `anhtruoc` varchar(200) DEFAULT NULL,
  `anhsau` varchar(200) DEFAULT NULL,
  `anhtuxa` varchar(200) DEFAULT NULL,
  `thoigian` date DEFAULT NULL,
  `quangcao` tinyint(1) DEFAULT '0',
  `anhquangcao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `madanhmuc` (`madanhmuc`),
  CONSTRAINT `sanpham_ibfk_3` FOREIGN KEY (`madanhmuc`) REFERENCES `danhmucsanpham` (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (14,'iPhone 6 32GB Chính Hãng Nguyên Seal Trôi Bảo Hành',3250000,3950000,3700000,'gray','iPhone 6 32Gb mới chính hãng trôi bảo hành. Máy mới chính hãng VN/A, fullbox, nguyên seal, phụ kiện zin chính hãng theo máy., còn bảo hành hãng từ 3 - 6 tháng.','128G',10,1,'1.5595364113885393E12iphone6-grey.png','1.5595364113942944E12iphone-6-cũ-8.jpg','1.5595364114000688E12iphone-6-cũ-7.jpg','2019-06-06',1,'1.5603343265363298E12a20-01.png'),(15,'iPhone 6 Plus 16GB Cũ Nguyên Bản',4450000,5200000,5000000,'gray','iPhone 6 Plus 16GB Cũ bản quốc tế đẹp như mới (cam kết chỉ bán nguyên bản 100%, đẹp long lanh không móp méo, cấn xước). Sản phẩm được test rất kĩ qua quy trình 21 bước chuyên nghiệp. Đặc biệt được tặng kèm sạc, cable TITAN chính hãng 1 đổi 1 trong 12 tháng. Bộ sản phẩm gồm: Thân máy đẹp như mới, sạc, cable, dán màn hình, que chọc sim.','128G',10,1,'1.559537274736809E12iphone6-plus-grey.png','1.5595372747426975E12iphone-6-plus-4.jpg','1.5595372747494834E12iphone-6-plus-5.jpg','2019-06-06',1,'1.5603343442501213E12A50_6190.png'),(16,'iPhone 6S 16Gb Mới Chính Hãng',5590000,6100000,5990000,'black','Apple iPhone 6S mới 100% phân phối chính hãng bởi FPT, Máy mới 100% Nguyên Seal, Chưa kích hoạt Phụ kiện gồm: hộp trùng imei, sạc, cable, tai nghe, sách hướng dẫn, que chọc sim. Di Động Thông Minh cam kết hàng chuẩn Brandnew, nguyên seal xịn và phụ kiện chính hãng, khi kích họat lên sẽ đủ bảo hành chính hãng 12 tháng.','256G',10,1,'1.559538710594968E12xsmax-đen.png','1.5595387105999414E1212-1.jpg','1.559538710604104E122-1.jpg','2019-06-06',1,'1.5603343531775422E12a5s-01-2.png'),(17,'iPhone XS Max 256Gb Mới Chính Hãng',32000000,32900000,32800000,'black','Apple iPhone Xs Max mới 100% phân phối chính hãng bởi FPT, Máy mới 100% Nguyên Seal, Chưa kích hoạt Phụ kiện gồm: hộp trùng imei, sạc, cable, tai nghe, sách hướng dẫn, que chọc sim. Di Động Thông Minh cam kết hàng chuẩn Brandnew, nguyên seal xịn và phụ kiện chính hãng, khi kích họat lên sẽ đủ bảo hành chính hãng 12 tháng.','256G',10,1,'1.5595387599104226E12S9-ln-64GB.png','1.5595387599144807E12iphone-6-plus-5.jpg','1.5595387599194795E1212-1.jpg','2019-06-06',1,'1.56033436371462E127plus-01.png'),(18,'iPhone XR 128Gb Mới Chính Hãng',17600000,18000000,17880000,'red','Apple iPhone Xr mới 100% phân phối chính hãng bởi FPT, Máy mới 100% Nguyên Seal, Chưa kích hoạt Phụ kiện gồm: hộp trùng imei, sạc, cable, tai nghe, sách hướng dẫn, que chọc sim. Di Động Thông Minh cam kết hàng chuẩn Brandnew, nguyên seal xịn và phụ kiện chính hãng, khi kích họat lên sẽ đủ bảo hành chính hãng 12 tháng.','256G',10,1,'1.5595376934645686E12iphone-xr-red.png','1.559537693468837E12iPhone-6s-cũ-1.jpg','1.559537693474751E12iphone-6-cũ-7.jpg','2019-06-06',1,'1.56033437715734E12A70-01.png'),(19,'iPhone X Mới Nguyên Seal Chưa Active',27640000,28460000,28300000,'white','iPhone X chính hãng mới 100% chưa kích hoạt bản do FPT phân phối (phiên bản có thể VN/A, LL/A hoặc bản khác tuỳ đợt phân phối của hãng), nguyên seal, phụ kiện chính hãng sạc, cable, tai nghe. Sản phẩm mới 100% chưa kích hoạt, đủ bảo hành, được bảo hành 12 tháng tại Trung Tâm Chính Hãng Apple. Vui lòng chọn màu, dung lượng, và chế độ bảo hành để website báo giá chính xác','256G',10,1,'1.559537888057639E12xsmax-white.png','1.5595378880615422E12iphone-6-cũ-8.jpg','1.5595378880678892E12iphone-6-cũ-7.jpg','2019-06-06',1,'1.560334386291709E122x2-mi-9-dgw.png'),(20,'iPhone XS 64Gb Cũ Nguyên Bản',20990000,21900000,21700000,'black','iPhone XS cũ bản quốc tế hàng lướt (cam kết chỉ bán nguyên bản 100%, đẹp long lanh không móp méo, cấn xước). Sản phẩm được kiểm tra kĩ lưỡng đảm bảo hoạt động ổn định, pin còn rất tốt trước khi đến tay người dùng. Đặc biệt có chế độ bảo hành siêu việt 1 đổi 1 trong 12 tháng, cả rơi móp chỉ có tại Di Động Thông Minh.','128G',10,1,'1.5595381915788257E12iphone6s-space-gray.png','1.55953819158475E12iPhone-6s-cũ-1.jpg','1.5595381916425063E12iphone-6-cũ-7.jpg','2019-06-06',0,NULL),(21,'iPhone 7 Plus 32Gb Cũ Nguyên Bản',6250000,7200000,7100000,'black','iPhone 7 Plus cũ bản quốc tế mới xài (cam kết chỉ bán nguyên bản 100%, đẹp long lanh không móp méo, cấn xước). Sản phẩm được kiểm tra kĩ lưỡng đảm bảo hoạt động ổn định, pin còn rất tốt trước khi đến tay người dùng. Đặc biệt có chế độ bảo hành siêu tốc 12 tháng, cả rơi móp, 1 đổi 1 trong 45 ngày (dCareS) cho quý khách chọn lựa để an tâm với iPhone 7 Plus cũ tại Di Động Thông Minh. Bộ sản phẩm chuẩn gồm: thân máy, sạc, cable pisen, dán màn hình, và que chọc sim.','128G',10,1,'1.5595383421238984E12xsmax-đen.png','1.5595383421296528E12oppo-reno-7.png','1.5595383421360078E12oppo-a3s-slider.jpg','2019-06-06',0,NULL),(22,'iPhone 7 Plus 32Gb Mới Chính Hãng',13340000,14500000,14400000,'pink','Apple iPhone 7 Plus mới 100% phân phối chính hãng bởi FPT, Máy mới 100% Nguyên Seal, Chưa kích hoạt Phụ kiện gồm: hộp trùng imei, sạc, cable, tai nghe, sách hướng dẫn, que chọc sim. Di Động Thông Minh cam kết hàng chuẩn Brandnew, nguyên seal xịn và phụ kiện chính hãng, khi kích họat lên sẽ đủ bảo hành chính hãng 12 tháng.','128G',10,1,'1.559538374997729E12oppo-a3s.png','1.5595383750021428E12iPhone-6s-cũ-1.jpg','1.559538375008833E12oppo-a3s-slider.jpg','2019-06-06',0,NULL),(23,'iPhone 7 32Gb Mới Chính Hãng',11790000,12540000,12300000,'black','Apple iPhone 7 mới 100% phân phối chính hãng bởi FPT, Máy mới 100% Nguyên Seal, Chưa kích hoạt Phụ kiện gồm: hộp trùng imei, sạc, cable, tai nghe, sách hướng dẫn, que chọc sim. Di Động Thông Minh cam kết hàng chuẩn Brandnew, nguyên seal xịn và phụ kiện chính hãng, khi kích họat lên sẽ đủ bảo hành chính hãng 12 tháng.','256G',10,1,'1.5595384031819282E12reno-den.png','1.5595384031865325E12iPhone-6s-cũ-1.jpg','1.5595384031902544E12iphone-6-cũ-7.jpg','2019-06-06',1,'1.5603449760437678E12asus-01-1.png'),(24,'Samsung Galaxy A80 6Gb/128Gb Chính Hãng',13000000,13500000,13400000,'black','Samsung Galaxy A80 là Smartphone mang tính đột phá của Samsung với thiết kế rất đẹp: Màn hình tràn viền Fullview, Camera trượt xoay, Pin 3.700 mAh kèm sạc nhanh siêu tốc 25W. Máy phù hợp với đối tượng khách hàng thích sự đổi mới, thích camera chính và camera selfie hoàn hảo. Bảo hành chính hãng 12 tháng','256G',2,1,'1.5595385692820327E12iphone6s-space-gray.png','1.5595385692868127E1212-1.jpg','1.5595385692903218E122-1.jpg','2019-06-06',0,NULL),(25,'Samsung Galaxy M10 Chính Hãng',3340000,4032000,3900000,'blue','Samsung Galaxy M10 là Smartphone mới nhất của dòng M với thiết kế màn hình Infinity-V 6.2 inch, độ phân giải HD+ mọi khung hình trở nên sống động bao trùm mọi giác quan, thoả mãn tối đa thị giác. Kết hợp với giao diện One UI tối ưu, Galaxy M10 mang đến cho bạn trải nghiệm người dùng hoàn hảo hơn bao giờ hết.. Bảo hành chính hãng 12 tháng','64G',2,1,'1.5600582263950586E12reno-den.png','1.5600582264046687E1212-1.jpg','1.5600582264106685E12iphone-6-cũ-7.jpg','2019-06-06',0,NULL),(27,'Samsung Galaxy A80 6Gb/128Gb Chính Hãng',14200000,15990000,15800000,'black','Samsung Galaxy A80 là Smartphone mang tính đột phá của Samsung với thiết kế rất đẹp: Màn hình tràn viền Fullview, Camera trượt xoay, Pin 3.700 mAh kèm sạc nhanh siêu tốc 25W. Máy phù hợp với đối tượng khách hàng thích sự đổi mới, thích camera chính và camera selfie hoàn hảo. Bảo hành chính hãng 12 tháng','128G',2,1,'1.5595388046101123E12S9-ln-64GB.png','1.5595388046261475E12iphone-6-plus-5.jpg','1.5595388046407473E122-1.jpg','2019-06-06',0,NULL),(28,'Samsung Galaxy S9 Chính Hãng Likenew',7399000,8400000,7900000,'violet','Samsung Galaxy S9 chính hãng có mức giá cực rẻ - giảm hơn 50%, biến S9 thành smartphone đáng mua nhất thời điểm hiện tại ở tầm giá 8-10 triệu. Máy phiên bản chính hãng thuộc thị trường Việt Nam sử dụng 2 sim. Hàng trưng bày refurbished mới 99% có 2 lựa chọn máy trần hoặc fullbox có đầy đủ phụ kiện: sạc, cable, tai nghe, chọc sim. Bảo hành 6 tháng.','64G',2,1,'1.5595388853045925E12S9-likenew (1).png','1.5595388853105369E12iphone-6-plus-4.jpg','1.5595388853165847E122-1.jpg','2019-06-06',1,'1.5603447969875625E12A70-01.png'),(29,'Samsung Galaxy S9 Plus 6Gb/64Gb Chính Hãng Likenew',9900000,11300000,11000000,'black','Samsung Galaxy S9+ chính hãng có mức giá cực rẻ - giảm hơn 50%, biến S9+ thành smartphone đáng mua nhất thời điểm hiện tại ở tầm giá 10 triệu. Máy phiên bản chính hãng thuộc thị trường Việt Nam sử dụng 2 sim. Hàng trưng bày refurbished mới 99% có 2 lựa chọn máy trần hoặc fullbox có đầy đủ phụ kiện: sạc, cable, tai nghe, chọc sim. Bảo hành 6 tháng.','128G',2,1,'1.5595389126753418E12xsmax-đen.png','1.559538912679678E12iphone-6-plus-4.jpg','1.5595389126865537E12iphone-6-cũ-7.jpg','2019-06-06',0,NULL),(30,'Samsung Galaxy J4 Core Chính Hãng',4010000,5900000,5550000,'blue','Samsung Galaxy J4 Core Chính Hãng là smartphone giá rẻ thứ 2 chạy Andorid Go của hãng. Đây là phiên bản nâng cấp nhẹ về cấu hình khi J4 Core chạy chip Snapdragon 425 chứ không phải Exynos như thế hệ trước. Ngoài ra, màn hình lớn 6.0\" HD+ cùng tỉ lệ 18.5:9 mới giúp người cùng có không gian trải nghiệm tuyệt vời hơn. Bảo hành chính hãng 12 tháng','64G',2,1,'1.5600580799969048E127-mate-128-gb-300x399.png','1.5600580800018357E12iphone6-gold-300x400.png','1.5600580800059204E12iphone-6-cũ-7.jpg','2019-06-06',1,'1.5603454475191116E12A50_6190.png'),(31,'Xiaomi Black Shark 2 128GB Ram 6GB',12200000,13300000,13200000,'black','Xiaomi Black Shark 2 được trang bị một cấu hình mạnh mẽ, thiết kế hầm hố cùng với rất nhiều công nghệ tối ưu cho việc chơi game. Sản Phẩm full hộp. Bộ phụ kiện chuẩn gồm: Thân máy, sạc, cable, sách hướng dẫn sử dụng, chọc sim. Bảo hành 12 tháng','128G',7,1,'1.5595390207844048E12S9-ln-64GB.png','1.5595390207887837E1212-1.jpg','1.559539020793151E122-1.jpg','2019-06-06',0,NULL),(32,'Xiaomi Redmi Note 7 Pro Ram 4GB / 64GB',6100000,6900000,6500000,'red','Redmi Note 7 Pro là siêu phẩm giá rẻ tích hợp nhiều tính năng cao cấp của Xiaomi như: khả năng chống nước; Màn hình được thiết kế theo kiểu giọt nước ấn tượng; Camera cực khủng lên tới 48 MP, bộ vi xử lý cực mạnh Snapdragon 675, mặt lưng bằng kính cứng chống vỡ với dải màu Gradient sang trọng, cao cấp. Bộ phụ kiện chuẩn gồm : Hộp, sạc, cáp type C, que chọc sim, giấy HDSD, ốp silicon.','64G',7,1,'1.5595390410445635E12iphone-xr-red.png','1.5595390410512734E12iphone-6-plus-5.jpg','1.5595390410576938E12iphone-6-cũ-7.jpg','2019-06-06',1,'1.5603339923993052E12redminote7-01.png'),(33,'Xiaomi Mi 8 SE 64Gb Ram 6Gb',5600000,7199000,7000000,'black','Xiaomi Mi 8 SE là flagship mới nhất trong bộ 3 smartphone vừa ra mắt dùng chip Snapdragon 710 mạnh mẽ và mới nhất thị trường hiện tại. Máy có màn hình tràn viền 5.88 inch, cùng với camera AI tích hợp các chức năng hỗ trợ chụp ảnh như máy ảnh chuyên nghiệp. Máy mới 100% nguyên seal gồm: thân máy, sạc, cable, ốp lưng, chọc sim, sách hướng dẫn sử dụng. Bảo hành 12 tháng','128G',7,1,'1.5595390620532344E12xsmax-đen.png','1.5595390620585955E1212-1.jpg','1.559539062063291E1214-1.jpg','2019-06-06',0,NULL),(34,'Xiaomi Mi Pad 4 64Gb Ram 4Gb (Wifi & 4G)',4900000,5120000,5050000,'gray','Sau bao ngày rò rỉ, nay máy tính bảng thế hệ thứ 4 – Mi Pad 4 của Xiaomi đã chính thức ra mắt. Có thể nói đây là dòng tablet đầu tiên trên thế giới được trang bị chip xử lý Snapdragon 660. Tuy có màn hình 8 inch nhưng thiết kế của máy trông rất nhỏ gọn, với kích thước 200.2 x 120.3 x 7.9 mm, không quá bất tiện khi dùng bằng một tay. Ở mặt sau,Xiaomi Mi Pad…','64G',7,1,'1.559539091147207E12note-8-vang-2.png','1.5595390911515713E12iphone-6-cũ-8.jpg','1.5595390911561323E12iphone-6-plus-5.jpg','2019-06-06',0,NULL),(35,'Xiaomi Redmi Note 6 Pro 32Gb / 3Gb – Chính hãng DGW / FPT',4909000,5190000,5090000,'black','Redmi Note 6 Pro là phiên bản nâng cấp hoàn hảo của chiếc Redmi Note 5 Pro mạnh mẽ. Máy được trang bị 4 Camera gồm: Camera kép AI đi kèm cụm camera kép Selfie góc rộng và màn hình tai thỏ tràn viền 6,26 inch cho trải nghiệm cũng như giải trí tuyệt đẹp. Máy chính hãng mới 100% nguyên hộp nguyên seal. Bảo hành 18 tháng Chính hãng trên toàn quốc.','64G',7,1,'1.5600585329469604E12iphone7-plus-gold-1-300x400.png','1.5600585329525886E122-1.jpg','1.5600585329602488E12iphone-6-cũ-8.jpg','2019-06-09',0,NULL),(36,'Xiaomi Redmi Note 7 Chính Hãng DGW Ram 4GB / 64GB',5100000,6299000,6100000,'red','Redmi Note 7 là chiếc smartphone mới nhất của Xiaomi vừa được ra mắt tại Việt Nam. Màn hình được thiết kế theo kiểu giọt nước ấn tượng,trang bị camera cực khủng lên tới 48 MP, bộ vi xử lý cực mạnh Snapdragon 660, mặt lưng bằng kính cứng chống vỡ với dải màu Gradient sang trọng, cao cấp . Bộ phụ kiện chuẩn gồm : Hộp, sạc, cáp type C, que chọc sim, ốp silicon. Bảo hành chính hãng 18 tháng trên toàn quốc.','64G',7,1,'1.5595391462543203E12oppo-a3s.png','1.5595391462598994E12oppo-a3s-slider.jpg','1.559539146263443E12oppo-reno-7.png','2019-06-06',0,NULL),(37,'Xiaomi Redmi 5 Plus 32GB Ram 3GB',2400000,3990000,3500000,'white','Xiaomi Redmi 5 Plus Nhập khẩu 32GB Ram 3GB sở hữu màn hình có kích thước 5,99\'\' và nâng lên độ phân giải Full-HD+, tỉ lệ màn hình 18:9. Máy có thiết kế trẻ trung nhiều màu sắc, màn hình viền siêu mỏng và con chip xử lí S625 từ Qualcomm mạnh mẽ. Redmi 5 Plus sẽ làm nên bước đột phá mới của Xiaomi trong cuối năm nay. Máy mới 100% fullbox, bảo hành 12 tháng.','32G',7,1,'1.559539167279127E12iphoneX-silver.png','1.5595391672838813E12iphone-6-plus-4.jpg','1.5595391672898025E122-1.jpg','2019-06-06',0,NULL),(38,'Oppo F7 Youth Chính Hãng',4900000,5440000,5330000,'red','Điện thoại Oppo F7 Youth chính hãng được phân phối bởi Oppo Việt Nam. OPPO F7 Youth là một phiên bản rút gọn của OPPO F7 không tai thỏ, không cảm biến vân tay, camera độ phân giải thấp hơn nhưng vẫn sở hữu cấu hình mạnh mẽ như người đàn anh trước đó.','32G',6,1,'1.5595392415354075E12iphone6-grey.png','1.5595392415418428E12iphone-6-plus-4.jpg','1.5595392415464834E12iphone-6-plus-5.jpg','2019-06-06',1,'1.560333954840685E12asus-01-1.png'),(39,'OPPO A71 32GB (CPH1801) Chính Hãng',3990000,4190000,4040000,'black','Điện thoại Oppo A71 chính hãng phiên bản 32GB được phân phối bởi Oppo Việt Nam. Bộ Phụ kiện Oppo A71 32GB chuẩn gồm Sạc, cable, tai nghe cao cấp, sách hướng dẫn sử dụng, thẻ bảo hành chính hãng','64G',6,1,'1.5595392705840056E12S9-ln-64GB.png','1.5595392705885293E12iphone-6-plus-5.jpg','1.5595392705959973E12iphone6-grey.png','2019-06-06',0,NULL),(40,'OPPO A71K ( A71 2018 ) chính hãng',5200000,6400000,6100000,'blue','Điện thoại Oppo A71K chính hãng được phân phối bởi Oppo Việt Nam. Bộ Phụ kiện Oppo A71K chuẩn gồm Sạc, cable, sách hướng dẫn sử dụng, thẻ bảo hành chính hãng','32G',6,1,'1.5600586143218174E12Xiaomi-Mi-max-3.png','1.560058614328021E1212-1.jpg','1.5600586143362488E1214-1.jpg','2019-06-06',0,NULL),(41,'OPPO F7 128GB chính hãng',7780000,8990000,8550000,'red','Điện thoại Oppo F7 chính hãng phiên bản cao cấp ram 6G bộ nhớ trong 128G được phân phối bởi Oppo Việt Nam. Bộ Phụ kiện Oppo F7 chuẩn gồm Sạc, cable, tai nghe cao cấp, sách hướng dẫn sử dụng, thẻ bảo hành chính hãng','128G',6,1,'1.5595393339011165E12iphone-xr-red.png','1.5595393339067236E12iphone-6-plus-4.jpg','1.559539333912872E12iphone-6-plus-5.jpg','2019-06-06',0,NULL),(42,'Oppo F5 Ram 4G chính hãng',6900000,7990000,7550000,'gray','Điện thoại Oppo F5 chính hãng được phân phối bởi Oppo Việt Nam. Bộ Phụ kiện Oppo F5 chuẩn gồm Sạc, cable, tai nghe cao cấp, sách hướng dẫn sử dụng, thẻ bảo hành chính hãng','64G',6,1,'1.5595393673230046E12S9-likenew (1).png','1.5595393673275454E12iphone-6-plus-5.jpg','1.5595393673399077E1214-1.jpg','2019-06-06',0,NULL),(43,'Oppo F1S chính hãng (2016)',8990000,10990000,99000000,'gray','OPPO F1S chính hãng được phân phối bởi Oppo Việt Nam, phụ kiện chuẩn gồm Sạc, cable, tai nghe cao cấp, sách hướng dẫn sử dụng, thẻ bảo hành chính hãng.','128G',6,1,'1.5595393880651262E12note-8-vang-2.png','1.5595393880718398E12iphone6-grey.png','1.5595393880767837E12iphone-6-plus-5.jpg','2019-06-06',0,NULL),(44,'OPPO Reno 6GB/256GB chính hãng',4390000,5200000,4990000,'blue','Điện thoại Oppo Reno chính hãng phiên bản RAM 6GB và ROM 256GB được phân phối bởi Oppo Việt Nam. Đây là mẫu smartphone tầm trung đi kèm với vi xử lý Snapdragon 710. Máy có thiết kế tương tự như phiên bản OPPO Reno 10x Zoom với camera selfie “vây cá mập” nhưng nó dùng màn hình AMOLED 6.4 inch nhỏ gọn hơn, cùng độ phân giải Full HD+. Ngoài ra, máy cũng trang bị cảm biến vân tay dưới màn hình. Bộ Phụ kiện Oppo Reno chuẩn gồm Sạc, cable, tai nghe cao cấp, sách hướng dẫn sử dụng, thẻ bảo hành chính hãng','32G',6,1,'1.5595394085985298E12reno-den.png','1.5595394086016694E12iphone-6-plus-4.jpg','1.5595394086088008E1214-1.jpg','2019-06-06',0,NULL),(45,'Samsung Galaxy A80 6Gb/128Gb Chính Hãng',14000000,15000000,14900000,'blue','Smartphone A7 2018 sản phẩm mới nhất của Samsung với ba camera sau ,màn hình Super AMOLED 6 inch, độ phân giải Full HD+ (2220 x 1080 pixel) sắc nét, vi xử lý 8 lõi tốc độ 2.2 GHz mạnh mẽ cùng viên pin 3.300 mAh và chạy Android 8.0 Oreo. Máy sẽ có ba tùy chọn về RAM và bộ nhớ gồm 4GB/64GB, 4GB/128GB và 6GB/128 GB','128G',2,1,'1.5596198885548484E12S9-ln-64GB.png','1.5596198886003062E12iphone6-grey.png','1.5596198886031465E12iphone-6-cũ-8.jpg','2019-06-06',0,NULL),(46,'Samsung Galaxy Note 8 64Gb Cũ 99% Hàn Quốc',7900000,8600000,8400000,'gray','Samsung Galaxy Note 8 Hàn Quốc qua sử dụng cam kết nguyên zin. Máy thuộc thị trường Hàn Quốc. Ưu điễm lớn nhất là có thể dùng được 2 sim và hỗ trợ cập nhật tương tự như phiên bản quốc tế. Sử dụng sóng ổn định tại Việt Nam. Phụ kiện theo kèm gồm sạc, cable nhanh Quick Charge. Di Động Thông Minh luôn tặng những phụ kiện hữu ích và chuẩn theo máy nhằm đem lại cho khách hàng trải nghiệm sử dụng tốt nhất khi mua sản phẩm. Máy được bao test 30 ngày và bảo hành 12 tháng - An Tâm Sử Dụng','64G',2,0,'1.5599286192073403E12oppo-f3-gold-300x400.png','1.559928619211885E1212-1.jpg','1.5599286192162458E122-1.jpg','2019-06-08',1,'1.5603337717299438E122x2-KM-Samsung.png'),(47,'Samsung Galaxy A20 Chính Hãng',8750000,9503000,9400000,'black','Galaxy A20 là Smartphone giá rẻ mang tính đột phá của Samsung với thiết kế màn hình tràn viền Infinity-U, Super AMOLED thay thế và là sản phẩm nâng cấp hoàn hảo của Galaxy J6 Plus. Với mức giá cực rẻ, hướng tới giới trẻ, bảo hành chính hãng 12 tháng. Đây sẽ là sản phẩm rất đáng sở hữu trong tầm giá 3 - 4 triệu','128G',2,1,'1.5599288882615562E127-mate-128-gb-300x399.png','1.5599288882669077E1212-1.jpg','1.559928888270517E122-1.jpg','2019-06-08',1,'1.5603339151734355E122x2-mi-9-dgw.png'),(48,'Samsung Galaxy M10 Chính Hãng ',3450000,4200000,4050000,'blue','Samsung Galaxy M10 là Smartphone mới nhất của dòng M với thiết kế màn hình Infinity-V 6.2 inch, độ phân giải HD+ mọi khung hình trở nên sống động bao trùm mọi giác quan, thoả mãn tối đa thị giác. Kết hợp với giao diện One UI tối ưu, Galaxy M10 mang đến cho bạn trải nghiệm người dùng hoàn hảo hơn bao giờ hết.. Bảo hành chính hãng 12 tháng.','32G',2,1,'1.5600580522847178E12reno-300x399.png','1.5600580522892273E12iphone-6-cũ-8.jpg','1.5600580522937695E12iphone-6-plus-5.jpg','2019-06-08',1,'1.5603339425658374E127plus-01.png'),(49,'Samsung Galaxy Note 9 128Gb cũ 99% Mỹ',10500000,12340000,12050000,'black','Samsung galaxy note 9 128GB mỹ là sản phẩm mới 99%, đây là phiên bản quốc tế được phân phối tại thị trường Mỹ. DDTM cam kết chất lượng sản phẩm nguyên bản, nguyên zin. Phụ kiện kèm theo sẽ bao gồm sạc nhanh quickcharge và cable type- C chuẩn samsung.','128G',2,1,'1.5599291018603184E12oppo-f1s-matteblack-300x400.png','1.5599291018656326E12iphone-6-cũ-8.jpg','1.5599291018698992E1212-1.jpg','2019-06-08',0,NULL),(50,'Samsung Galaxy Note 8 chính hãng',7300000,8300000,8050000,'gray','Samsung Galaxy Note 8 chính hãng Việt Nam mới 100% nguyên hộp, bộ phụ kiện chuẩn gồm sạc, cable, tai nghe, que lấy sim, sách hướng dẫn sử dụng. Giá giảm 50% so với lúc ra mắt, rất thích hợp cho khách hàng muốn trải nghiệm chiếc bút S-pen tiện dụng. Bảo hành 12 tháng. Số lượng có hạn','32G',2,0,'1.5599292242130227E12oppo-f3-plus-vang-300x400.png','1.5599292242183174E1212-1.jpg','1.5599292242224885E12iPhone-6s-cũ-1.jpg','2019-06-08',0,NULL),(51,'Samsung Galaxy A7 2018 64Gb Chính Hãng',7960000,8900000,8880000,'blue','Smartphone A7 2018 sản phẩm mới nhất của Samsung với ba camera sau ,màn hình Super AMOLED 6 inch, độ phân giải Full HD+ (2220 x 1080 pixel) sắc nét, vi xử lý 8 lõi tốc độ 2.2 GHz mạnh mẽ cùng viên pin 3.300 mAh và chạy Android 8.0 Oreo. Máy sẽ có ba tùy chọn về RAM và bộ nhớ gồm 4GB/64GB, 4GB/128GB và 6GB/128 GB','128G',2,1,'1.559929413713234E12reno-300x399.png','1.5599294137202239E1212-1.jpg','1.5599294137277854E122-1.jpg','2019-06-08',0,NULL),(52,'iPhone 6 32GB Chính Hãng Nguyên Seal Trôi Bảo Hành',7950000,8600000,8500000,'white','iPhone 6 32Gb mới chính hãng trôi bảo hành. Máy mới chính hãng VN/A, fullbox, nguyên seal, phụ kiện zin chính hãng theo máy., còn bảo hành hãng từ 3 - 6 tháng','128G',10,1,'1.5599295028629392E12oppo-a37-black-300x400.png','1.5599295028663545E122-1.jpg','1.559929502874107E1214-1.jpg','2019-06-08',1,'1.5603342909909966E12redminote7-01.png'),(53,'iPhone 7 Plus 32Gb Mới Chính Hãng ',7890000,9400000,8900000,'black','Apple iPhone 7 Plus mới 100% phân phối chính hãng bởi FPT, Máy mới 100% Nguyên Seal, Chưa kích hoạt Phụ kiện gồm: hộp trùng imei, sạc, cable, tai nghe, sách hướng dẫn, que chọc sim. Di Động Thông Minh cam kết hàng chuẩn Brandnew, nguyên seal xịn và phụ kiện chính hãng, khi kích họat lên sẽ đủ bảo hành chính hãng 12 tháng.','32G',10,0,'1.5599295831413875E12oppo-a71-black--300x400.png','1.5599295831471624E1212-1.jpg','1.5599295831542532E1214-1.jpg','2019-06-08',1,'1.560334316882301E12iphone-6-chinh-hang-01.png'),(54,'Samsung Galaxy A80 6Gb/128Gb Chính Hãng',5400000,6400000,6230000,'red','Galaxy A50 là Smartphone giá rẻ mang tính đột phá của Samsung với thiết kế màn hình tràn viền Infinity-U, Super AMOLED 6.4 inch tích hợp bảo mật vân tay trên màn hình, Pin 4.000 mAh kèm sạc nhanh siêu tốc. Máy có hệ thống 3 camera sau chụp góc siêu rộng kết hợp xoá phông và camera selfie 25MP chụp ảnh đẹp thần sầu. Với mức giá cực rẻ, hướng tới giới trẻ, bảo hành chính hãng 12 tháng. đây sẽ là sản phẩm rất đáng sở hữu.','64G',2,1,'1.5604531211459863E128plus_64gb-300x399.png','1.5604531211687693E1212-1.jpg','1.5604531211726594E122-1.jpg','2019-06-14',0,NULL),(55,'Samsung Galaxy M10 Chính Hãng',13800000,15400000,15200000,'gray','Mi 9 chính hãng DGW là flagship được trang bị con chip Snapdragon 855 cao cấp nhất và có giá rất rẻ so với các smartphone khác sử dụng cùng con Chip. Máy được tích hợp cảm biến vân tay trong màn hình, cho phép mở khoá cực nhạy. Điểm nổi bật nhất của máy là cụm 3 camera với cảm biến chính lên tới 48MP và được đánh giá là Smartphone có camera chụp ảnh đẹp đứng thứ 3 thế giới. Sản phẩm mới 100% nguyên seal gồm: thân máy, sạc, cable, ốp lưng, chọc sim, sách hướng dẫn sử dụng. Bảo hành 12 tháng chính hãng trên toàn quốc.','128G',2,0,'1.560605512151657E12iphone7-plus-gold-1-300x400.png','1.5606055123064253E122-1.jpg','1.5606055123101306E1214-1.jpg','2019-06-15',1,NULL),(56,'iPhone 7 32Gb Cũ Nguyên Bản',5490000,6540000,6390000,'black','iPhone 7 32Gb cũ bản quốc tế mới xài (cam kết chỉ bán nguyên bản 100%, đẹp long lanh không móp méo, cấn xước). Sản phẩm được kiểm tra kĩ lưỡng đảm bảo hoạt động ổn định, pin còn rất tốt trước khi đến tay người dùng. Đặc biệt có chế độ bảo hành siêu tốc 12 tháng, cả rơi móp, 1 đổi 1 trong 45 ngày (dCareS) cho quý khách chọn lựa để an tâm với iPhone 7 32Gb cũ tại Di Động Thông Minh. Bộ sản phẩm chuẩn gồm: thân máy, sạc, cable pisen, dán màn hình, và que chọc sim.','64G',12,1,'1.5606062590365195E127-mate-128-gb-300x399.png','1.56060625904257E1212-1.jpg','1.5606062590460122E12iphone-6-cũ-8.jpg','2019-06-15',0,NULL);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slider`
--

DROP TABLE IF EXISTS `slider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slider` (
  `maslider` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `anh` varchar(255) DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`maslider`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider` DISABLE KEYS */;
INSERT INTO `slider` VALUES (1,'Samsung Galaxy A20 Chính Hãng.Màn hình tràn viền, pin trâu, giá siêu rẻ','1.560265146520852E12slider1.png',1),(2,'Đại chiến giá rẻ: Redmi Note 7 vẫn bá đạo nhất, lý do đây!','1.5602652712429175E12slider2.png',1),(3,'Đối thủ Redmi 7: Realme C2 chưa đến 3 triệu có ngon không?','1.560265294073882E12slider3.png',1);
/*!40000 ALTER TABLE `slider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taikhoan` (
  `username` varchar(200) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `phanquyen` tinyint(1) DEFAULT '0',
  `tenkhachhang` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `dienthoai` varchar(20) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `makhuvuc` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `makhuvuc` (`makhuvuc`),
  CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`makhuvuc`) REFERENCES `tinh` (`makhuvuc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('Phạm Quyền','123',0,'Phạm Văn Quyền','quyenpv97@gmail.com','0969456215','số 29 ngõ 20',6),('Phan Hải','123',0,'Phan Văn Hải','phanhai@gmail.com','0969456215','Số 30 Đại Cồ Việt',4),('Phan Quý','1234',0,NULL,NULL,NULL,NULL,NULL),('quyenpham','12345',1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongsokithuat`
--

DROP TABLE IF EXISTS `thongsokithuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongsokithuat` (
  `bangtan` varchar(100) NOT NULL,
  `gpu` varchar(100) NOT NULL,
  `cpu` varchar(100) NOT NULL,
  `ram` varchar(100) DEFAULT NULL,
  `bonhotrong` varchar(100) DEFAULT NULL,
  `cambien` varchar(250) NOT NULL,
  `hedieuhanh` varchar(200) NOT NULL,
  `camtruoc` varchar(100) DEFAULT NULL,
  `camsau` varchar(100) DEFAULT NULL,
  `pin` varchar(100) NOT NULL,
  `congnghesacpin` varchar(200) NOT NULL,
  `thenho` varchar(100) NOT NULL,
  `masanpham` int(11) NOT NULL,
  PRIMARY KEY (`masanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongsokithuat`
--

LOCK TABLES `thongsokithuat` WRITE;
/*!40000 ALTER TABLE `thongsokithuat` DISABLE KEYS */;
INSERT INTO `thongsokithuat` VALUES ('123','123','123','123','null','null','null','null','null','null','null','null',46);
/*!40000 ALTER TABLE `thongsokithuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tinh`
--

DROP TABLE IF EXISTS `tinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tinh` (
  `makhuvuc` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhuvuc` varchar(200) DEFAULT NULL,
  `cuocphy` int(11) DEFAULT NULL,
  PRIMARY KEY (`makhuvuc`),
  UNIQUE KEY `tenkhuvuc` (`tenkhuvuc`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tinh`
--

LOCK TABLES `tinh` WRITE;
/*!40000 ALTER TABLE `tinh` DISABLE KEYS */;
INSERT INTO `tinh` VALUES (1,'Hải Dương',200000),(3,'Hà Nội',100000),(4,'Hải Phòng',50000),(5,'Thanh Hóa',200000),(6,'Tp Hồ Chí Minh',500000),(7,'Nam Định',50000),(9,'Hà Nam',100000);
/*!40000 ALTER TABLE `tinh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-28 21:50:36
