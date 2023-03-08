-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: saveratiles
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `name` varchar(15) NOT NULL,
  `contract` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `adress` varchar(20) DEFAULT NULL,
  `bill` varchar(15) DEFAULT NULL,
  `amount` varchar(15) DEFAULT NULL,
  `discount` varchar(45) DEFAULT NULL,
  `less` varchar(15) DEFAULT NULL,
  `totalamount` varchar(45) DEFAULT NULL,
  `paid` varchar(45) DEFAULT NULL,
  `due` varchar(45) DEFAULT NULL,
  `date` varchar(15) DEFAULT NULL,
  `time` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Rasu','xxxxxxxxxxx','xxxxxxxxxx','xxxxxxxxxxxx','ST-7985467','500','10','50','450','200','250','2022/15/02','03:58 PM'),('Rasuu','xxxxxx','xxxxxxxxx','xxxxxxxxxx','ST-2428411','1700','10','170','1530','15','1515','2022/16/02','04:06 PM'),('Raskibul','xxxxxxxxx','xxxxxxxxxx','xxxxxxxxxx','ST-1500108','400000','20','80000','320000','200','319800','2022/19/02','07:40 PM'),('Ras','xxxxxx','xxxxxxxxx','xxxxxxxx','ST-7620832','3060000','20','612000.0','2448000','100000','2348000','2022/23/02','11:15 PM'),('x','xxxx','xxxxxx','xxxxxxx','ST-8271857','1530000','10','153000.0','1377000','1500','1375500','2022/23/02','11:52 PM');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-03  7:52:36
