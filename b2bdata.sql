/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.60-log : Database - b2bdata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`b2bdata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `b2bdata`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `grade` float DEFAULT NULL,
  `grender` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

LOCK TABLES `student` WRITE;

insert  into `student`(`id`,`name`,`grade`,`grender`) values (1,'dsad',2,'男'),(2,'sda',2,'女');

UNLOCK TABLES;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uaccount` int(11) NOT NULL AUTO_INCREMENT COMMENT '账号',
  `upassword` varchar(255) NOT NULL COMMENT '密码',
  `uname` varchar(255) NOT NULL COMMENT '姓名',
  `usex` varchar(50) NOT NULL COMMENT '性别',
  PRIMARY KEY (`uaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=10026 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

insert  into `user`(`uaccount`,`upassword`,`uname`,`usex`) values (10018,'1','12','WS'),(10019,'1','wangjin','1'),(10020,'123','王三','男'),(10021,'1','我','男'),(10022,'1','1211','的'),(10023,'2','whhh','nan'),(10024,'1','whhh','nan'),(10025,'1','hh','nan');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
