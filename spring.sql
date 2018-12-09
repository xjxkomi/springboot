/*
SQLyog Ultimate v11.52 (64 bit)
MySQL - 5.6.21-log : Database - spring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_name` char(20) DEFAULT NULL,
  `create_timer` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`r_name`,`create_timer`,`is_deleted`) values (1,'系统管理员','2018-12-02 15:39:23',0),(2,'测试管理员','2018-11-14 15:39:29',0);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `u_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) DEFAULT NULL,
  `u_name` char(20) DEFAULT NULL,
  `u_password` char(100) DEFAULT NULL,
  `u_last_login_timer` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`u_id`),
  KEY `user_role_pk` (`role_id`),
  CONSTRAINT `FK4dm5kxn3potpfgdigehw7pdyu` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`u_id`,`role_id`,`u_name`,`u_password`,`u_last_login_timer`,`is_deleted`) values (1,2,'admin','21232f297a57a5a743894a0e4a801fc3','2018-12-02 11:14:21',0),(2,1,'komi','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(3,1,'test1','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(4,1,'test2','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(5,1,'test3','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(6,1,'test4','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(7,1,'test5','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(8,1,'test6','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(9,1,'test7','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(10,1,'test8','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(11,1,'test9','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(12,1,'test10','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(13,1,'test11','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(14,1,'test12','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(15,1,'test13','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(16,1,'test14','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(17,1,'test15','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(18,1,'test16','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(19,1,'test17','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0),(20,1,'test18','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
