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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(65) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Não definido',
  `price` decimal(5,2) NOT NULL DEFAULT '0.00',
  `stock` int NOT NULL DEFAULT '0',
  `publisher` varchar(45) NOT NULL DEFAULT 'Não definido',
  `author` varchar(45) NOT NULL DEFAULT 'Não definido',
  `genero` varchar(45) NOT NULL DEFAULT 'Não definido',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Harry Potter e a Pedra Filosofal',25.00,4,'Panini','J.K. Rowling','Aventura'),(2,'Harry Potter e o Prisioneiro de Azkaban',31.00,8,'Rocco','J.K. Rowling','Comedia'),(3,'It - A Coisa',69.91,15,'Schwarcz S.A.','Stephen King','Ação'),(5,'JoJos Bizarre Adventure - Phantom Blood',39.90,13,'Shounen Jump','Hirohiko Araki','Ação'),(6,'O Diário de Anne Frank',10.00,80,'Record','Anne Frank','Ação'),(7,'Sherlock Holmes - Um Estudo em Vermelho',80.00,25,'Record','Arthur Conan Doyle','Suspense'),(8,'Harry Potter E a Pedra Filosofal',319.00,89,'Rocco','J.K. Rowling','Aventura'),(9,'Harry Potter e Câmara Secreta',69.90,64,'Rocco','J.K. Rowling','Aventura'),(10,'Harry Potter e o Cálice de Fogo',99.00,57,'Rocco','J.K. Rowling','Aventura'),(11,'Harry Potter e a Ordem da Fênix',10.00,4,'Rocco','J.K. Rowling','Aventura'),(12,'Harry Potter e o Enigma do Principe',79.00,167,'Rocco','J.K. Rowling','Aventura'),(13,'Harry Potter e as Relíquias da Morte',79.00,2,'Rocco','J.K. Rowling','Aventura'),(14,'Guerra Civil',99.99,18,'Marvel','Stan Lee','Ação'),(15,'H.P. Lovecraft - Medo Clássico - Vol. 1',69.90,7,'Panini','H.P. Lovecraft','Terror'),(16,'H.P. Lovecraft - Medo Clássico - Vol. 2',69.90,5,'Panini','H.P. Lovecraft','Terror'),(17,'Senhor dos Anéis - A Sociedade do Anel',22.00,90,'Martins Fontes','J.R.R Tolkien','Ação'),(18,'Senhor dos Anéis - As Duas Torres',23.00,2,'Martins Fontes','J.R.R Tolkien','Conto'),(19,'Senhor dos Anéis - O Retorno do Rei',24.00,3,'Martins Fontes','J.R.R Tolkien','Tecnologia e Ciência');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
