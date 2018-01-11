-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: Hotel
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
-- Table structure for table `hotel1`
--

DROP TABLE IF EXISTS `hotel1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel1` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `checkindate` char(8) DEFAULT NULL,
  `checkoutdate` char(8) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel1`
--

LOCK TABLES `hotel1` WRITE;
/*!40000 ALTER TABLE `hotel1` DISABLE KEYS */;
INSERT INTO `hotel1` VALUES (1,'如家','20180103','20180105','北京','经济',280),(2,'如家','20180103','20180105','北京','商务',560),(3,'如家','20180103','20180107','北京','豪华',1200),(4,'如家','20180103','20180104','上海','经济',300),(5,'如家','20180103','20180105','上海','商务',600),(6,'如家','20180103','20180106','上海','豪华',1500),(7,'如家','20180103','20180104','成都','经济',230),(8,'如家','20180103','20180104','成都','商务',480),(9,'如家','20180103','20180106','成都','豪华',990);
/*!40000 ALTER TABLE `hotel1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel2`
--

DROP TABLE IF EXISTS `hotel2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel2` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `checkindate` char(8) DEFAULT NULL,
  `checkoutdate` char(8) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel2`
--

LOCK TABLES `hotel2` WRITE;
/*!40000 ALTER TABLE `hotel2` DISABLE KEYS */;
INSERT INTO `hotel2` VALUES (1,'锦江之星','20180103','20180107','北京','经济',320),(2,'锦江之星','20180103','20180107','北京','商务',690),(3,'锦江之星','20180103','20180109','北京','豪华',1150),(4,'锦江之星','20180103','20180104','上海','经济',350),(5,'锦江之星','20180103','20180105','上海','商务',750),(6,'锦江之星','20180103','20180105','上海','豪华',1050),(7,'锦江之星','20180103','20180106','成都','经济',290),(8,'锦江之星','20180103','20180105','成都','商务',590),(9,'锦江之星','20180103','20180106','成都','豪华',890);
/*!40000 ALTER TABLE `hotel2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders1`
--

DROP TABLE IF EXISTS `orders1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders1` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderno` varchar(20) DEFAULT NULL,
  `h_id` int(11) DEFAULT NULL,
  `checkindate` char(8) DEFAULT '0',
  `checkoutdate` char(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders1`
--

LOCK TABLES `orders1` WRITE;
/*!40000 ALTER TABLE `orders1` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders2`
--

DROP TABLE IF EXISTS `orders2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders2` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderno` varchar(20) DEFAULT NULL,
  `h_id` int(11) DEFAULT NULL,
  `checkindate` char(8) DEFAULT '0',
  `checkoutdate` char(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders2`
--

LOCK TABLES `orders2` WRITE;
/*!40000 ALTER TABLE `orders2` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-22 14:55:56
