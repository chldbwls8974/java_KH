CREATE DATABASE  IF NOT EXISTS `test`;
USE `test`;

DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `bo_number` int NOT NULL AUTO_INCREMENT,
  `bo_title` varchar(45) NOT NULL,
  `bo_me_id` varchar(10) NOT NULL,
  PRIMARY KEY (`bo_number`),
  KEY `bo_me_id_idx` (`bo_me_id`),
  CONSTRAINT `bo_me_id` FOREIGN KEY (`bo_me_id`) REFERENCES `member` (`me_id`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `dash_board`;
CREATE TABLE `dash_board` (
  `db_number` int NOT NULL AUTO_INCREMENT,
  `db_member` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_number`)
);

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `me_id` varchar(10) NOT NULL,
  `me_pw` varchar(40) NOT NULL,
  `me_board_count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`me_id`)
);