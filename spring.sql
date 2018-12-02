/*
SQLyog Professional v12.14 (64 bit)
MySQL - 8.0.13 : Database - spring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `spring`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_name` char(20) DEFAULT NULL,
  `create_timer` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`r_name`,`create_timer`,`is_deleted`) values 
(1,'系统管理员','2018-12-02 15:39:23',0),
(2,'测试管理员','2018-11-14 15:39:29',0);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `u_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) DEFAULT NULL,
  `u_name` char(20) DEFAULT NULL,
  `u_password` char(100) DEFAULT NULL,
  `u_last_login_timer` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `sys_role_role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `user_role_pk` (`role_id`),
  KEY `FKcpwqci8wwfv8qhwg08fy3hgfi` (`sys_role_role_id`),
  CONSTRAINT `FKcpwqci8wwfv8qhwg08fy3hgfi` FOREIGN KEY (`sys_role_role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `user_role_pk` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_user` */

insert  into `sys_user`(`u_id`,`role_id`,`u_name`,`u_password`,`u_last_login_timer`,`is_deleted`,`sys_role_role_id`) values 
(1,2,'admin','21232f297a57a5a743894a0e4a801fc3','2018-12-02 11:14:21',0,NULL),
(2,1,'komi','21232f297a57a5a743894a0e4a801fc3','2018-11-15 11:14:34',0,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
