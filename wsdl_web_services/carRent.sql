-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: carRent
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
-- Table structure for table `carRent1`
--

DROP TABLE IF EXISTS `carRent1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carRent1` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `drivemode` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carRent1`
--

LOCK TABLES `carRent1` WRITE;
/*!40000 ALTER TABLE `carRent1` DISABLE KEYS */;
INSERT INTO `carRent1` VALUES (1,'神州租车','北京','五座','手动挡',300),(2,'神州租车','北京','五座','自动挡',350),(3,'神州租车','北京','七座','手动挡',400),(4,'神州租车','北京','七座','自动挡',450),(5,'神州租车','上海','五座','手动挡',250),(6,'神州租车','上海','五座','自动挡',280),(7,'神州租车','上海','七座','手动挡',310),(8,'神州租车','上海','七座','自动挡',340),(9,'神州租车','成都','五座','手动挡',180),(10,'神州租车','成都','五座','自动挡',220),(11,'神州租车','成都','七座','手动挡',260),(12,'神州租车','成都','七座','自动挡',300);
/*!40000 ALTER TABLE `carRent1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carRent2`
--

DROP TABLE IF EXISTS `carRent2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carRent2` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `drivemode` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carRent2`
--

LOCK TABLES `carRent2` WRITE;
/*!40000 ALTER TABLE `carRent2` DISABLE KEYS */;
INSERT INTO `carRent2` VALUES (1,'首汽租车','北京','五座','手动挡',320),(2,'首汽租车','北京','五座','自动挡',340),(3,'首汽租车','北京','七座','手动挡',370),(4,'首汽租车','北京','七座','自动挡',390),(5,'首汽租车','上海','五座','手动挡',290),(6,'首汽租车','上海','五座','自动挡',320),(7,'首汽租车','上海','七座','手动挡',350),(8,'首汽租车','上海','七座','自动挡',380),(9,'首汽租车','成都','五座','手动挡',200),(10,'首汽租车','成都','五座','自动挡',230),(11,'首汽租车','成都','七座','手动挡',280),(12,'首汽租车','成都','七座','自动挡',320);
/*!40000 ALTER TABLE `carRent2` ENABLE KEYS */;
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
  `c_id` int(11) DEFAULT NULL,
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
  `c_id` int(11) DEFAULT NULL,
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

-- Dump completed on 2017-12-22 14:56:56
