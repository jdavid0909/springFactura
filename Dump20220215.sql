CREATE DATABASE  IF NOT EXISTS `factura` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `factura`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: factura
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_customer` (
  `id_customer` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int NOT NULL,
  `status` int NOT NULL,
  `added_date` date NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
INSERT INTO `t_customer` VALUES (1,'Josue','aldea Santa rosa',99206291,1,'2022-02-15'),(2,'Laurent','Quezada',95984131,1,'2022-02-15');
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_invoice`
--

DROP TABLE IF EXISTS `t_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_invoice` (
  `id_invoice` int NOT NULL AUTO_INCREMENT,
  `invoice_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_customer` int NOT NULL,
  `status` int NOT NULL,
  `added_date` date NOT NULL,
  PRIMARY KEY (`id_invoice`),
  KEY `id_customer` (`id_customer`),
  CONSTRAINT `t_invoice_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `t_customer` (`id_customer`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_invoice`
--

LOCK TABLES `t_invoice` WRITE;
/*!40000 ALTER TABLE `t_invoice` DISABLE KEYS */;
INSERT INTO `t_invoice` VALUES (1,'001',1,1,'2022-02-15'),(2,'002',2,1,'2022-02-16');
/*!40000 ALTER TABLE `t_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_invoice_detail`
--

DROP TABLE IF EXISTS `t_invoice_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_invoice_detail` (
  `id_invoice_detail` int NOT NULL AUTO_INCREMENT,
  `id_invoice` int NOT NULL,
  `id_product` int NOT NULL,
  `amount` int NOT NULL,
  `price` double NOT NULL,
  `total_parcial` double NOT NULL,
  `isv` double NOT NULL,
  `discount` double NOT NULL,
  `total` double NOT NULL,
  `status` int NOT NULL,
  `added_date` date NOT NULL,
  PRIMARY KEY (`id_invoice_detail`),
  KEY `id_invoice` (`id_invoice`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `t_invoice_detail_ibfk_1` FOREIGN KEY (`id_invoice`) REFERENCES `t_invoice` (`id_invoice`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_invoice_detail_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `t_products` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_invoice_detail`
--

LOCK TABLES `t_invoice_detail` WRITE;
/*!40000 ALTER TABLE `t_invoice_detail` DISABLE KEYS */;
INSERT INTO `t_invoice_detail` VALUES (1,1,1,100,115,115,15,0,115,1,'2022-02-15'),(2,2,2,130,130,130,45,0,130,1,'2022-02-15');
/*!40000 ALTER TABLE `t_invoice_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_products`
--

DROP TABLE IF EXISTS `t_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_products` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `stock` int NOT NULL,
  `status` int NOT NULL,
  `added_date` date NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_products`
--

LOCK TABLES `t_products` WRITE;
/*!40000 ALTER TABLE `t_products` DISABLE KEYS */;
INSERT INTO `t_products` VALUES (1,'carro',1,1,'2022-02-15'),(2,'car',1,1,'2022-02-15');
/*!40000 ALTER TABLE `t_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-15  8:34:34
