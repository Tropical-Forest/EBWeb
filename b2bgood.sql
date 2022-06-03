/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.60-log : Database - b2bgoods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`b2bgoods` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `b2bgoods`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) NOT NULL,
  `number` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `goodid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

LOCK TABLES `cart` WRITE;

insert  into `cart`(`id`,`goodsname`,`number`,`price`,`goodid`,`uid`) values (1,'fg',0,0,0,0);

UNLOCK TABLES;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gname` varchar(255) NOT NULL COMMENT '商品名称',
  `gremain` varchar(255) NOT NULL COMMENT '商品图片地址',
  `gdetails` varchar(255) NOT NULL COMMENT '商品介绍',
  `gprice` int(11) NOT NULL COMMENT '商品价格',
  `types` int(64) NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

LOCK TABLES `goods` WRITE;

insert  into `goods`(`gid`,`gname`,`gremain`,`gdetails`,`gprice`,`types`) values (1,'草莓','http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods003.jpg','可口草莓',4,0),(2,'苹果','http://localhost:8894/b2b-goods-consumer/templates/img/2.jpg','红富士苹果',2,0),(3,'橙子','http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods001.jpg','金黄的大橙子',4,0),(4,'葡萄','http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods002.jpg','吐鲁番葡萄',12,0),(5,'大虾','http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods018.jpg','山东大虾',5,2),(6,'带鱼','http://localhost:8894/goods-consumer/templates/img/goods/goods020.jpg','好吃的带鱼',50,2),(7,'扇贝','http://localhost:8894/goods-consumer/templates/img/goods/goods019.jpg','大神快来快来',20,2),(8,'皮皮虾','http://localhost:8894/goods-consumer/templates/img/goods/goods021.jpg','啥的客户',10,2),(9,'脉动','http://localhost:8894/goods-consumer/templates/img/goods/maidong.png','不在状态，脉动一下',4,1),(10,'汽水','http://localhost:8894/goods-consumer/templates/img/goods/qishui.png','栓双',8,1),(11,'沙棘汁','http://localhost:8894/goods-consumer/templates/img/goods/shajizhi.png','好喝',3,1),(12,'和其正','http://localhost:8894/goods-consumer/templates/img/goods/heqizheng.png','dsa asd',5,1),(13,'菠菜','http://localhost:8894/goods-consumer/templates/img/goods/bocai.png','大',2,3),(14,'生菜','http://localhost:8894/goods-consumer/templates/img/goods/shengcai.png','asdajlskdja',2,3),(15,'番茄','http://localhost:8894/goods-consumer/templates/img/goods/fanqie.png','好吃',1,3),(16,'胡萝卜','http://localhost:8894/goods-consumer/templates/img/goods/huluobo.png','asdkjlajkld',2,3);

UNLOCK TABLES;

/*Table structure for table `userorder` */

DROP TABLE IF EXISTS `userorder`;

CREATE TABLE `userorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goodsname` varchar(255) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '购买数量',
  `price` int(11) NOT NULL COMMENT '总价',
  `time` datetime NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

/*Data for the table `userorder` */

LOCK TABLES `userorder` WRITE;

insert  into `userorder`(`id`,`goodsname`,`number`,`price`,`time`,`uid`) values (139,'脉动',17,68,'2019-10-16 11:11:45',10023),(140,'沙棘汁',2,6,'2019-10-16 11:11:45',10023);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
