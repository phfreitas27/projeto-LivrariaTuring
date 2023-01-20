-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `idUser` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `idCart` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `idBook` int NOT NULL,
  `value` double NOT NULL,
  KEY `idBook` (`idBook`),
  CONSTRAINT `idBook` FOREIGN KEY (`idBook`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES ('0a048469-59cd-4561-9a09-dd5fd5664cc6','Drepo123','cf1f5059-56f1-46b6-b9cf-02feabf4997e',9,69.9),('4fc7c16d-d8f6-4856-bb55-1f4184b05cb3','Drepo123','13dc9307-b9fa-4413-959f-9c8fef051736',1,25),('573aca01-ce6f-49a4-88d2-8c18b8a88875','Drepo123','4c46a5df-407a-4229-9e53-a2e2846833a5',9,69.9),('a2a4857e-01ea-4feb-8950-b02ad3dfaad9','Drepo123','1d457846-b67d-43a0-9a31-5edb7c32fd30',6,10),('c9205ad0-2351-4d7b-834c-f3d5bdf36940','Drepo123','2dc5ec79-6833-45c1-a3f7-4d1c9ac643af',16,69.9),('ef549c3e-49af-48d8-89d5-c97d825999cf','Drepo123','1dc584e1-1cfb-43f3-bdaf-a9d95293becb',2,31),('ffd2edce-9817-4928-894b-1405d5d978a7','Drepo','ac31d305-8567-4fa4-8b7e-fd48111a2666',6,10),('94e5d824-7027-43d1-afc7-e7a9bc94c8d6','Drepo123','d0b953e1-4e7b-4356-a5ce-1a05d8e68ac7',5,39.9),('94e5d824-7027-43d1-afc7-e7a9bc94c8d6','Drepo123','d0b953e1-4e7b-4356-a5ce-1a05d8e68ac7',7,80),('d2d30dd5-700f-4729-a372-7761f5fec134','Teste','5f56891a-a197-4ef4-b6ef-58efc19abc22',7,80),('d2d30dd5-700f-4729-a372-7761f5fec134','Teste','5f56891a-a197-4ef4-b6ef-58efc19abc22',14,99.99),('4f0c5a63-3a48-41d4-990f-9852227aa045','jonas','3378de60-1c59-47c1-b0e0-998bbd8c917c',9,69.9),('4f0c5a63-3a48-41d4-990f-9852227aa045','jonas','3378de60-1c59-47c1-b0e0-998bbd8c917c',3,69.91),('4f0c5a63-3a48-41d4-990f-9852227aa045','jonas','3378de60-1c59-47c1-b0e0-998bbd8c917c',3,69.91),('d1824983-8fbc-4451-adbd-c0f4fd38af95','jonas','d0fa8ebb-e362-46ec-9991-05507992b518',1,25),('d1824983-8fbc-4451-adbd-c0f4fd38af95','jonas','d0fa8ebb-e362-46ec-9991-05507992b518',1,25),('78d52efe-6a6c-4d61-acd2-2b985694f31f','pepe','7cc449c2-6bda-4918-b280-83921547fddb',1,25);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-20 19:34:54
