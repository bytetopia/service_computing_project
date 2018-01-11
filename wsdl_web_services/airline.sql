-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: airline
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
-- Table structure for table `airline1`
--

DROP TABLE IF EXISTS `airline1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airline1` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `flightno` char(11) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `flightdate` char(8) DEFAULT NULL,
  `departtime` char(5) DEFAULT NULL,
  `arrivetime` char(5) DEFAULT NULL,
  `departcity` varchar(20) DEFAULT NULL,
  `arrivecity` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline1`
--

LOCK TABLES `airline1` WRITE;
/*!40000 ALTER TABLE `airline1` DISABLE KEYS */;
INSERT INTO `airline1` VALUES (1,'20180103101','中国航空','20180103','09:10','11:40','北京','上海',1400),(2,'20180104101','中国航空','20180104','10:00','12:50','北京','成都',1800),(3,'20180103102','中国航空','20180103','17:40','19:25','上海','北京',1350),(4,'20180104102','中国航空','20180104','21:30','23:55','成都','北京',1500),(5,'20180104103','中国航空','20180104','12:20','14:00','上海','成都',1280),(6,'20180104104','中国航空','20180104','15:15','16:45','成都','上海',1300);
/*!40000 ALTER TABLE `airline1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airline2`
--

DROP TABLE IF EXISTS `airline2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airline2` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `flightno` char(11) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `flightdate` char(8) DEFAULT NULL,
  `departtime` char(5) DEFAULT NULL,
  `arrivetime` char(5) DEFAULT NULL,
  `departcity` varchar(20) DEFAULT NULL,
  `arrivecity` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline2`
--

LOCK TABLES `airline2` WRITE;
/*!40000 ALTER TABLE `airline2` DISABLE KEYS */;
INSERT INTO `airline2` VALUES (1,'20180103201','南方航空','20180104','12:40','14:10','北京','上海',1220),(2,'20180103202','南方航空','20180104','14:30','16:10','上海','北京',1300),(3,'20180104201','南方航空','20180104','08:00','09:45','北京','成都',1900),(4,'20180104202','南方航空','20180104','10:00','11:55','成都','北京',1850),(5,'20180104203','南方航空','20180104','17:25','19:45','上海','成都',1600),(6,'20180104204','南方航空','20180104','20:10','22:30','成都','上海',1650);
/*!40000 ALTER TABLE `airline2` ENABLE KEYS */;
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
  `flightno` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
  `flightno` char(11) DEFAULT NULL,
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

-- Dump completed on 2017-12-22 14:54:24
