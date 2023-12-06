-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: new_quiz
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `ID_Account` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`ID_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (0,'admin','123456',0),(1,'sinhvien1','123456',1),(2,'sinhvien2','123456',1),(3,'sinhvien3','123456',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_info` (
  `ID_Info` int NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `MSSV` varchar(20) DEFAULT NULL,
  `LSH` varchar(255) DEFAULT NULL,
  `ID_Account` int DEFAULT NULL,
  PRIMARY KEY (`ID_Info`),
  KEY `ID_Account` (`ID_Account`),
  CONSTRAINT `account_info_ibfk_1` FOREIGN KEY (`ID_Account`) REFERENCES `account` (`ID_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_info`
--

LOCK TABLES `account_info` WRITE;
/*!40000 ALTER TABLE `account_info` DISABLE KEYS */;
INSERT INTO `account_info` VALUES (0,'Admin',NULL,NULL,0),(1,'Duc Son','102210201','21TCLC_DT4',1),(2,'Anh Nguyen','102210202','21TCLC_DT1',2),(3,'Thanh Minh','102210203','21TCLC_DT1',3);
/*!40000 ALTER TABLE `account_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `ID_Question` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `opt1` varchar(255) DEFAULT NULL,
  `opt2` varchar(255) DEFAULT NULL,
  `opt3` varchar(255) DEFAULT NULL,
  `opt4` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_Question`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Which of the below is valid way to instantiate an array in java?','int myArray [] = {1, 3, 5};','int myArray [] [] = {1,2,3,4};','int [] myArray = (5, 4, 3);','int [] myArray = {\"1\", \"2\", \"3\"};','int myArray [] = {1, 3, 5}'),(2,'Which of the below are reserved keyword in Java?','array','def','null','int','int'),(3,'What are the valid statements for static keyword in Java?','We can have static block in a class.','The static block in a class is executed every time an object of class is created.','We can have static method implementations in interface.','We can define static block inside a method.','We can have static method implementations in interface.'),(4,'Which of the following statements are true for inheritance in Java?','The \"extend\" keyword is used to extend a class in java.','You can extend multiple classes in java.','Private members of the superclass are accessible to the subclass.','We can\'t extend Final classes in java.','We can\'t extend Final classes in java.'),(5,'What is the size of byte variable?','8 bit','16 bit','32 bit','64 bit','8 bit'),(6,'What is the size of float variable?','8 bit','16 bit','32 bit','64 bit','32 bit'),(7,'What is the default value of byte variable?','0','0','null','not defined','0'),(8,'Which of the following is true about String?','String is mutable.','String is immutable.','String is a data type.','None of the above.','String is immutable.'),(9,'What is JIT compiler?','JIT improves the runtime performance of computer programs based on bytecode.','JIT is an application development framework.','JIT is an implementation of the Java Virtual Machine which executes Java programs.','None of the above.','JIT improves the runtime performance of computer programs based on bytecode.'),(10,'What is function overriding?','If a subclass uses a method that is already provided by its parent class, it is known as Method Overriding.','If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding.','Both of the above.','None of the above.','If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding.');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `ID_Result` int NOT NULL,
  `Mark` int DEFAULT NULL,
  `Number_Error` int DEFAULT NULL,
  `Detecting_Error` varchar(255) DEFAULT NULL,
  `ID_Account` int DEFAULT NULL,
  PRIMARY KEY (`ID_Result`),
  KEY `ID_Account` (`ID_Account`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`ID_Account`) REFERENCES `account` (`ID_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (0,1,1,'MouseError',1),(1,3,1,'CheckError',2);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-06 13:16:17
