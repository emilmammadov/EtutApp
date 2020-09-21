-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: EtutDatabase
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `userName_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (5,'admin1','12345'),(7,'admin2','12345');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dersler`
--

DROP TABLE IF EXISTS `dersler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dersler` (
  `ders_id` int NOT NULL AUTO_INCREMENT,
  `ders_adi` varchar(45) NOT NULL,
  `dersid` int NOT NULL,
  `dersadi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ders_id`),
  UNIQUE KEY `id_UNIQUE` (`ders_id`),
  UNIQUE KEY `dersAdi_UNIQUE` (`ders_adi`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dersler`
--

LOCK TABLES `dersler` WRITE;
/*!40000 ALTER TABLE `dersler` DISABLE KEYS */;
INSERT INTO `dersler` VALUES (1,'matematik',0,NULL),(2,'turkce',0,NULL),(3,'sosyal',0,NULL);
/*!40000 ALTER TABLE `dersler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ogrenci`
--

DROP TABLE IF EXISTS `ogrenci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ogrenci` (
  `ogrenci_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adi` varchar(45) NOT NULL,
  `soyadi` varchar(45) NOT NULL,
  `ogrenciid` int NOT NULL,
  PRIMARY KEY (`ogrenci_id`),
  UNIQUE KEY `id_UNIQUE` (`ogrenci_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ogrenci`
--

LOCK TABLES `ogrenci` WRITE;
/*!40000 ALTER TABLE `ogrenci` DISABLE KEYS */;
INSERT INTO `ogrenci` VALUES (1,'kuzey','kuzey1','kuzey','ayyildiz',0),(2,'alp','alp1','alp','ayyildiz',0),(3,'bugra','bugra1','bugra','bayik',0),(4,'bengu','bengu1','bengu','bayik',0);
/*!40000 ALTER TABLE `ogrenci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ogretmen`
--

DROP TABLE IF EXISTS `ogretmen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ogretmen` (
  `ogretmen_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adi` varchar(45) NOT NULL,
  `soyadi` varchar(45) NOT NULL,
  `ders_id` int NOT NULL,
  `ogretmenid` int NOT NULL,
  `dersid` int DEFAULT NULL,
  PRIMARY KEY (`ogretmen_id`),
  UNIQUE KEY `id_UNIQUE` (`ogretmen_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_Ogretmen_Dersler1` (`ders_id`),
  CONSTRAINT `fk_Ogretmen_Dersler1` FOREIGN KEY (`ders_id`) REFERENCES `dersler` (`ders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ogretmen`
--

LOCK TABLES `ogretmen` WRITE;
/*!40000 ALTER TABLE `ogretmen` DISABLE KEYS */;
INSERT INTO `ogretmen` VALUES (1,'ipek','ipek1','ipek','ayyildiz',3,0,NULL),(2,'sadettin','sadettin1','sadettin','ayyildiz',1,0,NULL),(3,'hasan','hasan1','hasan','turksoy',2,0,NULL);
/*!40000 ALTER TABLE `ogretmen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `ders_id` int NOT NULL,
  `ogretmen_id` int NOT NULL,
  `tarih` date NOT NULL,
  `saat` datetime NOT NULL,
  `ogrenci_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `dersid` int DEFAULT NULL,
  `ogrenciid` int DEFAULT NULL,
  `ogretmenid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Program_Ogrenci1_idx` (`ogrenci_id`),
  KEY `fk_Program_Dersler1` (`ders_id`),
  KEY `fk_Program_Ogretmen1` (`ogretmen_id`),
  CONSTRAINT `fk_Program_Dersler1` FOREIGN KEY (`ders_id`) REFERENCES `dersler` (`ders_id`),
  CONSTRAINT `fk_Program_Ogrenci1` FOREIGN KEY (`ogrenci_id`) REFERENCES `ogrenci` (`ogrenci_id`),
  CONSTRAINT `fk_Program_Ogretmen1` FOREIGN KEY (`ogretmen_id`) REFERENCES `ogretmen` (`ogretmen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-21 21:04:28
