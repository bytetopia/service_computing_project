-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: sight
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
-- Table structure for table `guides`
--

DROP TABLE IF EXISTS `guides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guides` (
  `g_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `g_name` varchar(30) DEFAULT '',
  `company` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guides`
--

LOCK TABLES `guides` WRITE;
/*!40000 ALTER TABLE `guides` DISABLE KEYS */;
INSERT INTO `guides` VALUES (1,'小红','阳光景点管理公司'),(2,'小明','阳光景点管理公司'),(3,'小华','阳光景点管理公司'),(4,'小辉','阳光景点管理公司'),(5,'小强','阳光景点管理公司'),(6,'小白','阳光景点管理公司'),(7,'阿宽','阳光景点管理公司'),(8,'阿满','阳光景点管理公司'),(9,'阿牛','阳光景点管理公司'),(10,'阿刚','阳光景点管理公司');
/*!40000 ALTER TABLE `guides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gv`
--

DROP TABLE IF EXISTS `gv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) unsigned DEFAULT '0',
  `v_id` int(11) unsigned DEFAULT '0',
  `price` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `g_id` (`g_id`),
  KEY `v_id` (`v_id`),
  CONSTRAINT `gv_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `guides` (`g_id`),
  CONSTRAINT `gv_ibfk_2` FOREIGN KEY (`v_id`) REFERENCES `views` (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gv`
--

LOCK TABLES `gv` WRITE;
/*!40000 ALTER TABLE `gv` DISABLE KEYS */;
INSERT INTO `gv` VALUES (1,1,1,50),(2,2,2,10),(3,3,4,60),(4,3,5,60),(5,4,6,20),(6,4,7,15),(7,8,1,45),(8,8,2,5),(9,8,3,15),(10,9,6,30),(11,10,7,10);
/*!40000 ALTER TABLE `gv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderno` varchar(20) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `views`
--

DROP TABLE IF EXISTS `views`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `views` (
  `v_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `v_name` varchar(30) DEFAULT '',
  `v_city` varchar(30) DEFAULT '',
  `v_county` varchar(30) DEFAULT '',
  `v_price` int(11) DEFAULT '0',
  PRIMARY KEY (`v_id`),
  UNIQUE KEY `name` (`v_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `views`
--

LOCK TABLES `views` WRITE;
/*!40000 ALTER TABLE `views` DISABLE KEYS */;
INSERT INTO `views` VALUES (1,'长城','北京','延庆',85),(2,'香山','北京','海淀',10),(3,'颐和园','北京','海淀',30),(4,'杜莎夫人蜡像馆','上海','黄浦',190),(5,'外滩','上海','黄浦',0),(6,'锦里','成都','武侯',0),(7,'大熊猫繁育研究基地','成都','成华',85);
/*!40000 ALTER TABLE `views` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-22 14:57:40
