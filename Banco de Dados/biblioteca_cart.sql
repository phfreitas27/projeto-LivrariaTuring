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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `idBook` int NOT NULL,
  `idUser` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES ('c3c9e794-7c37-4740-b284-8ae98e9a70c2',19,'Thiago'),('c3c9e794-7c37-4740-b284-8ae98e9a70c2',18,'Thiago'),('c3c9e794-7c37-4740-b284-8ae98e9a70c2',13,'Thiago'),('c3c9e794-7c37-4740-b284-8ae98e9a70c2',13,'Thiago'),('e89180a8-db77-44cb-95c7-7bae1c528f98',5,'Thiago'),('e89180a8-db77-44cb-95c7-7bae1c528f98',5,'Thiago'),('ae74a29f-f13c-439d-afa1-772fbd05d82e',5,'Thiago'),('ae74a29f-f13c-439d-afa1-772fbd05d82e',2,'Thiago'),('ae74a29f-f13c-439d-afa1-772fbd05d82e',2,'Thiago'),('d442eb38-5b6a-4049-8f0f-e6c02fee9ea2',2,'Thiago'),('d442eb38-5b6a-4049-8f0f-e6c02fee9ea2',5,'Thiago'),('d442eb38-5b6a-4049-8f0f-e6c02fee9ea2',5,'Thiago'),('9873a90a-e10f-450a-9a2a-55bbfc7413ad',2,'Thiago'),('9873a90a-e10f-450a-9a2a-55bbfc7413ad',2,'Thiago'),('9873a90a-e10f-450a-9a2a-55bbfc7413ad',5,'Thiago'),('93a24b3a-49a7-4628-bfb5-b2fab6eff093',3,'Thiago'),('93a24b3a-49a7-4628-bfb5-b2fab6eff093',2,'Thiago'),('24a5e12c-cac6-462a-aade-455617341dca',3,'Thiago'),('24a5e12c-cac6-462a-aade-455617341dca',5,'Thiago'),('24a5e12c-cac6-462a-aade-455617341dca',2,'Thiago'),('8ef138cd-fec2-4fbd-b191-015dfa07651a',2,'Thiago'),('0cde03d2-e24b-496c-aae5-2f2297d05da3',5,'Thiago'),('fde35621-c4fa-4191-a9e7-ed58c44ee622',2,'Thiago'),('e4c63cb2-026c-4ee2-b045-ebd1fcb6353d',7,'Thiago2'),('ac31d305-8567-4fa4-8b7e-fd48111a2666',6,'Drepo'),('ac31d305-8567-4fa4-8b7e-fd48111a2666',1,'Drepo'),('1d457846-b67d-43a0-9a31-5edb7c32fd30',6,'Drepo123'),('1d457846-b67d-43a0-9a31-5edb7c32fd30',7,'Drepo123'),('cf1f5059-56f1-46b6-b9cf-02feabf4997e',9,'Drepo123'),('4c46a5df-407a-4229-9e53-a2e2846833a5',9,'Drepo123'),('2dc5ec79-6833-45c1-a3f7-4d1c9ac643af',16,'Drepo123'),('2dc5ec79-6833-45c1-a3f7-4d1c9ac643af',17,'Drepo123'),('13dc9307-b9fa-4413-959f-9c8fef051736',1,'Drepo123'),('13dc9307-b9fa-4413-959f-9c8fef051736',1,'Drepo123'),('13dc9307-b9fa-4413-959f-9c8fef051736',7,'Drepo123'),('1dc584e1-1cfb-43f3-bdaf-a9d95293becb',2,'Drepo123'),('1dc584e1-1cfb-43f3-bdaf-a9d95293becb',5,'Drepo123'),('d0b953e1-4e7b-4356-a5ce-1a05d8e68ac7',5,'Drepo123'),('d0b953e1-4e7b-4356-a5ce-1a05d8e68ac7',7,'Drepo123'),('94087d63-9869-40db-8429-84eeec9602cb',14,'Drepo'),('94087d63-9869-40db-8429-84eeec9602cb',17,'Drepo'),('5f56891a-a197-4ef4-b6ef-58efc19abc22',7,'Teste'),('5f56891a-a197-4ef4-b6ef-58efc19abc22',14,'Teste'),('3378de60-1c59-47c1-b0e0-998bbd8c917c',9,'jonas'),('3378de60-1c59-47c1-b0e0-998bbd8c917c',3,'jonas'),('3378de60-1c59-47c1-b0e0-998bbd8c917c',3,'jonas'),('efe9a596-c5e7-4abf-a0bd-aa8318f4ea4f',1,'jonas'),('efe9a596-c5e7-4abf-a0bd-aa8318f4ea4f',3,'jonas'),('23dd8221-0e72-4f4a-ba75-829ddfa68a3b',2,'Teste'),('23dd8221-0e72-4f4a-ba75-829ddfa68a3b',9,'Teste'),('bee2058a-3873-4169-a170-8209504ce18f',3,'Drepo'),('bee2058a-3873-4169-a170-8209504ce18f',19,'Drepo'),('8f5a67f6-f849-4104-b83b-d22b7659c81b',5,'Drepo'),('8f5a67f6-f849-4104-b83b-d22b7659c81b',13,'Drepo'),('5db4f5bf-4356-469e-afaa-d6fb635d3e98',6,'Teste'),('5db4f5bf-4356-469e-afaa-d6fb635d3e98',1,'Teste'),('f5fd9c9e-53c7-4e85-9301-5f610dae1c9b',2,'Teste'),('608389ef-5eec-4c22-aa0a-b558c34070d3',3,'Teste'),('608389ef-5eec-4c22-aa0a-b558c34070d3',1,'Teste'),('da67f404-d871-4413-852c-c0c74f2833ac',9,'Drepo'),('da67f404-d871-4413-852c-c0c74f2833ac',6,'Drepo'),('6bf8f952-4448-4446-81e5-c1226a3a07d5',6,'Drepo'),('cb203bc5-0ce7-4af6-ba74-784b910650b6',6,'Drepo'),('cb203bc5-0ce7-4af6-ba74-784b910650b6',6,'Drepo'),('1ecf8492-6b7d-46e1-9834-273817de0cd0',6,'Drepo'),('1ecf8492-6b7d-46e1-9834-273817de0cd0',7,'Drepo'),('1ecf8492-6b7d-46e1-9834-273817de0cd0',6,'Drepo'),('987a5b9f-d7df-487e-9755-f27eab6323c6',6,'Drepo'),('987a5b9f-d7df-487e-9755-f27eab6323c6',6,'Drepo'),('987a5b9f-d7df-487e-9755-f27eab6323c6',7,'Drepo'),('d1ecbd0f-ed8c-49e5-a92b-215f4ce688ca',6,'Teste'),('d1ecbd0f-ed8c-49e5-a92b-215f4ce688ca',2,'Teste'),('d1ecbd0f-ed8c-49e5-a92b-215f4ce688ca',2,'Teste'),('e6822b12-f2d4-43a0-9d75-ab9a2344f37d',3,'Teste'),('e6822b12-f2d4-43a0-9d75-ab9a2344f37d',6,'Teste'),('e6822b12-f2d4-43a0-9d75-ab9a2344f37d',6,'Teste'),('5a372c8a-6354-4789-a528-c886df78f170',1,'Teste'),('97ff8e2a-b038-4bb3-8993-a0d0d3aaee31',1,'Teste'),('8e41105f-eb91-4f9e-89a5-7c54975ae7dc',5,'Teste'),('437de84d-8f29-439a-b8a8-ddeb3efa65fb',2,'Drepo'),('d37f307c-02d1-414f-9c84-aab53f2b2034',3,'Teste'),('2fb98ec0-b580-4f47-b031-656602d15a87',6,'Teste'),('2fb98ec0-b580-4f47-b031-656602d15a87',6,'Teste'),('2fb98ec0-b580-4f47-b031-656602d15a87',3,'Teste'),('aa1f620b-e59a-4509-90de-01a09a03a22b',17,'Drepo'),('aa1f620b-e59a-4509-90de-01a09a03a22b',14,'Drepo'),('aa1f620b-e59a-4509-90de-01a09a03a22b',14,'Drepo'),('aa1f620b-e59a-4509-90de-01a09a03a22b',5,'Drepo'),('aa1f620b-e59a-4509-90de-01a09a03a22b',5,'Drepo'),('aa1f620b-e59a-4509-90de-01a09a03a22b',6,'Drepo'),('aa1f620b-e59a-4509-90de-01a09a03a22b',6,'Drepo'),('00579a6c-e5cf-4591-a8d6-d8c1055d6bc4',2,'Drepo'),('35d1c164-a2ff-4a08-8268-22cc9bf6c916',2,'Drepo'),('416d3707-345c-4ab0-b277-8f6572b386bc',3,'Drepo'),('f566b97c-b240-46da-b6cc-bdf907c62111',3,'Drepo'),('d0fa8ebb-e362-46ec-9991-05507992b518',1,'jonas'),('d0fa8ebb-e362-46ec-9991-05507992b518',1,'jonas'),('f8503760-f2b8-4046-9d25-ed13704a7d00',2,'Drepo'),('f8503760-f2b8-4046-9d25-ed13704a7d00',2,'Drepo'),('7cc449c2-6bda-4918-b280-83921547fddb',1,'pepe');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-20 19:34:51
