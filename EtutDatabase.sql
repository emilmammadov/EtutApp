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
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admin` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `id_UNIQUE` (`ID`),
  UNIQUE KEY `userName_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES (5,'admin1','12345'),(7,'admin2','12345');
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dersler`
--

DROP TABLE IF EXISTS `Dersler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Dersler` (
  `dersId` int NOT NULL AUTO_INCREMENT,
  `dersAdi` varchar(45) NOT NULL,
  PRIMARY KEY (`dersId`),
  UNIQUE KEY `id_UNIQUE` (`dersId`),
  UNIQUE KEY `dersAdi_UNIQUE` (`dersAdi`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dersler`
--

LOCK TABLES `Dersler` WRITE;
/*!40000 ALTER TABLE `Dersler` DISABLE KEYS */;
INSERT INTO `Dersler` VALUES (1,'matematik'),(3,'sosyal'),(2,'turkce');
/*!40000 ALTER TABLE `Dersler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ogrenci`
--

DROP TABLE IF EXISTS `Ogrenci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ogrenci` (
  `ogrenciId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adi` varchar(45) NOT NULL,
  `soyadi` varchar(45) NOT NULL,
  PRIMARY KEY (`ogrenciId`),
  UNIQUE KEY `id_UNIQUE` (`ogrenciId`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ogrenci`
--

LOCK TABLES `Ogrenci` WRITE;
/*!40000 ALTER TABLE `Ogrenci` DISABLE KEYS */;
INSERT INTO `Ogrenci` VALUES (1,'kuzey','kuzey1','kuzey','ayyildiz'),(2,'alp','alp1','alp','ayyildiz'),(3,'bugra','bugra1','bugra','bayik'),(4,'bengu','bengu1','bengu','bayik');
/*!40000 ALTER TABLE `Ogrenci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ogretmen`
--

DROP TABLE IF EXISTS `Ogretmen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ogretmen` (
  `ogretmenId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adi` varchar(45) NOT NULL,
  `soyadi` varchar(45) NOT NULL,
  `dersId` int NOT NULL,
  PRIMARY KEY (`ogretmenId`),
  UNIQUE KEY `id_UNIQUE` (`ogretmenId`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_Ogretmen_Dersler1` (`dersId`),
  CONSTRAINT `fk_Ogretmen_Dersler1` FOREIGN KEY (`dersId`) REFERENCES `Dersler` (`dersId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ogretmen`
--

LOCK TABLES `Ogretmen` WRITE;
/*!40000 ALTER TABLE `Ogretmen` DISABLE KEYS */;
INSERT INTO `Ogretmen` VALUES (1,'ipek','ipek1','ipek','ayyildiz',3),(2,'sadettin','sadettin1','sadettin','ayyildiz',1),(3,'hasan','hasan1','hasan','turksoy',2);
/*!40000 ALTER TABLE `Ogretmen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Program`
--

DROP TABLE IF EXISTS `Program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Program` (
  `dersId` int NOT NULL,
  `ogretmenId` int NOT NULL,
  `tarih` date NOT NULL,
  `saat` datetime NOT NULL,
  `ogrenciId` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Program_Ogrenci1_idx` (`ogrenciId`),
  KEY `fk_Program_Dersler1` (`dersId`),
  KEY `fk_Program_Ogretmen1` (`ogretmenId`),
  CONSTRAINT `fk_Program_Dersler1` FOREIGN KEY (`dersId`) REFERENCES `Dersler` (`dersId`),
  CONSTRAINT `fk_Program_Ogrenci1` FOREIGN KEY (`ogrenciId`) REFERENCES `Ogrenci` (`ogrenciId`),
  CONSTRAINT `fk_Program_Ogretmen1` FOREIGN KEY (`ogretmenId`) REFERENCES `Ogretmen` (`ogretmenId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Program`
--

LOCK TABLES `Program` WRITE;
/*!40000 ALTER TABLE `Program` DISABLE KEYS */;
/*!40000 ALTER TABLE `Program` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-04 17:15:32
