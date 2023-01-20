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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `login` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `idade` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Admim','123','admin@email.com','Admilson','10',NULL,NULL,NULL,NULL,NULL),('Admin','123','admin@email.com','Admilson','10',NULL,NULL,NULL,NULL,NULL),('CarlosAdm','1234','Carlos123@gmail.com','Carlos','45','03125040','Rua Domingos Da Fonseca','35','SP','São Paulo'),('Drepo','123','pedro@gmail.com','Pedro','18',NULL,NULL,NULL,NULL,NULL),('Drepo1','666','as','pedro','1','03125040','Rua Domingos Da Fonseca','77','SP','São Paulo'),('Drepo123','123','pedrofreitas@gmail.com','Pedro','18','03125040','Rua Domingos Da Fonseca','35','SP','São Paulo'),('jonas','123','jonas123@gmail.com','Jonas','31','03125040','Rua Domingos Da Fonseca','35','SP','São Paulo'),('pepe','123','pepe123@gmail.com','Pedro','18','03125040','Rua Domingos Da Fonseca','35','SP','São Paulo'),('Teste','123','teste123@gmail.com','Teste','25','03125040','Rua Domingos Da Fonseca','30','SP','São Paulo'),('Thiago','123','email@gmail.com','Thiago','19',NULL,NULL,NULL,NULL,NULL),('Thiago2','123','login@gmail.com','Thiago','19','09820680','Avenida Omar Daibert','x779','SP','São Bernardo do Campo');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
