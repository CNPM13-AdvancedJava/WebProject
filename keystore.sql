-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: keystore
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `ranked` tinyint(4) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_name_UNIQUE` (`admin_name`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'administrator','abc@gmail.com','123456',0);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalog` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
INSERT INTO `catalog` VALUES (1,'PC Game'),(2,'PS4 XBOX ONE PS3');
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `manufacturer_id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'Không rõ'),(2,'Electronic Arts');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `method_id` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `method_id_idx` (`method_id`),
  CONSTRAINT `method_id` FOREIGN KEY (`method_id`) REFERENCES `payment_method` (`method_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,1,1,1000000),(2,1,2,1,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `order_id` int(11) NOT NULL,
  `key_id` varchar(50) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`key_id`),
  KEY `key_id_idx2` (`key_id`),
  CONSTRAINT `keyId` FOREIGN KEY (`key_id`) REFERENCES `product_key` (`key_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_method` (
  `method_id` int(11) NOT NULL AUTO_INCREMENT,
  `method_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (1,'Thanh toán trực tuyến'),(2,'Chuyển khoản'),(3,'Nạp thẻ cào');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_detail` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(200) NOT NULL,
  `release_time` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `language` varchar(200) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `description` longtext,
  `introduction` mediumtext,
  `price` double NOT NULL,
  `manufacturer_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `viewed_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `manufacturer_id_idx` (`manufacturer_id`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`manufacturer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
INSERT INTO `product_detail` VALUES (1,'DARK SOULS 3 III (Global)','2013-10-29',1,'All','All','	Bắn súng - Hành động','Battlefield 4™ is the genre-defining action blockbuster made from moments that blur the line between game and glory. Fueled by the next-generation power and fidelity of Frostbite™ 3, Battlefield 4™ provides a visceral, dramatic experience unlike any other. Only in Battlefield can you demolish the buildings shielding your enemy. Only in Battlefield will you lead an assault from the back of a gun boat. Battlefield grants you the freedom to do more and be more while playing to your strengths and carving your own path to victory. In addition to its hallmark multiplayer, Battlefield 4™ features an intense, dramatic character-driven campaign that starts with the evacuation of American VIPs from Shanghai and follows your squad\'s struggle to find its way home. There is no comparison. Immerse yourself in the glorious chaos of all-out war, found only in Battlefield. Key Features: • Only in Battlefield can you change the landscape in real-time with interactive environments that react to your every move. • Only in Battlefield will you find the awe-inspiring power of the next generation Frostbite™ 3 engine, with unrivaled audio and visual fidelity making your game more human, dramatic, and believable. • Only in Battlefield can you experience an unmatched level of all-out war that grants you the freedom to play to your strengths and carve your own path to victory. • Only in Battlefield do you have the power to dominate land, air and sea with all-new, intense water-based vehicular combat.Battlefield 4™ is the genre-defining action blockbuster made from moments that blur the line between game and glory. Fueled by the next-generation power and fidelity of Frostbite™ 3, Battlefield 4™ provides a visceral, dramatic experience unlike any other. Only in Battlefield can you demolish the buildings shielding your enemy. Only in Battlefield will you lead an assault from the back of a gun boat. Battlefield grants you the freedom to do more and be more while playing to your strengths and carving your own path to victory. In addition to its hallmark multiplayer, Battlefield 4™ features an intense, dramatic character-driven campaign that starts with the evacuation of American VIPs from Shanghai and follows your squad\'s struggle to find its way home. There is no comparison. Immerse yourself in the glorious chaos of all-out war, found only in Battlefield. Key Features: • Only in Battlefield can you change the landscape in real-time with interactive environments that react to your every move. • Only in Battlefield will you find the awe-inspiring power of the next generation Frostbite™ 3 engine, with unrivaled audio and visual fidelity making your game more human, dramatic, and believable. • Only in Battlefield can you experience an unmatched level of all-out war that grants you the freedom to play to your strengths and carve your own path to victory. • Only in Battlefield do you have the power to dominate land, air and sea with all-new, intense water-based vehicular combat.',1000000,2,3,1),(2,'Battlefield 4 ( Global /Mutilanguage )','2013-10-29',1,'All','All','	Bắn súng - Hành động','This is dummy data, never mind about this',1000000,1,3,3),(3,'Dummy Data number 1 abccbcbcbcb','2013-10-29',1,'All','All','	Bắn súng - Hành động','This is dummy data, never mind about this',1000000,1,3,12),(4,'Dummy Data ','2013-10-29',1,'All','All','	Bắn súng - Hành động','This is dummy data, never mind about this',1,2,3,11),(5,'Dummy Data number 3','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,15),(6,'Dummy Data ','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(7,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(8,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(9,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(10,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(11,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(12,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(13,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(14,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(15,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(16,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(17,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(18,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(19,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,0),(20,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,1),(21,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,1),(22,'Dummy Data','2013-10-29',1,'All','All','No thing to say','This is dummy data, never mind about this',1,1,3,1);
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_image` (
  `image_id` int(11) NOT NULL,
  `image_link` varchar(200) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `is_ava` tinyint(4) DEFAULT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  `image_type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `product_id_3_idx` (`product_id`),
  CONSTRAINT `product_id_3` FOREIGN KEY (`product_id`) REFERENCES `product_detail` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (1,'images/product/product1.jpg',1,1,1,1),(2,'images/product/product3.jpg',2,1,1,1);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_key`
--

DROP TABLE IF EXISTS `product_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_key` (
  `key_id` varchar(50) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`key_id`),
  KEY `product_id_idx_2` (`product_id`),
  CONSTRAINT `product_id_2` FOREIGN KEY (`product_id`) REFERENCES `product_detail` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_key`
--

LOCK TABLES `product_key` WRITE;
/*!40000 ALTER TABLE `product_key` DISABLE KEYS */;
INSERT INTO `product_key` VALUES ('ABCD-1234-ABCD-1212',2,1),('ABCD-1234-ABCD-1234',1,1),('ABCD-1234-ABCD-1235',1,1),('ABCD-1234-ABCD-1236',1,1),('ABCF-SDFD-1111-ABCD',2,1);
/*!40000 ALTER TABLE `product_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(200) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  KEY `CATALOG_IDX` (`catalog_id`),
  CONSTRAINT `catalog_id` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`catalog_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Battlefield (series)',1),(2,'Call of Duty (series)',1),(3,'Action/Adventure',1),(4,'Sports',1),(5,'Racing',1),(6,'MMO GAMES',1),(7,'Strategy',1);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `money` double DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Hứa Hoàng Linh','123123123','dcmclgt@gmail.com','01654988696',1,'Thụy Khuê, Hà Nội','1993-04-03',3000000),(2,'dhgghdfgh','123123123','hehe@gmail.com','',1,'','1996-01-12',0),(3,'dfghdfg','123123123','erin@gmail.com','0912345678',1,'Thuy Khue','1998-12-11',0),(4,'Đậu','12345678','abcd1234@gmail.com','123456789',1,'','1999-03-02',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 14:45:20
