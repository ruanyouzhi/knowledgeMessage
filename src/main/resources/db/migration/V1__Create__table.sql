/*
Navicat MySQL Data Transfer

Source Server         : knowledgemessage
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : knowledgemessage

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2020-06-24 08:07:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `creator_id` bigint(20) DEFAULT NULL,
                        `gmt_create` bigint(20) DEFAULT NULL,
                        `gmt_modified` bigint(20) DEFAULT NULL,
                        `is_public` tinyint(1) DEFAULT '1',
                        `title` varchar(200) DEFAULT NULL,
                        `card_description` varchar(200) DEFAULT NULL,
                        `card_text` text,
                        `img_src` varchar(500) DEFAULT NULL,
                        `label_name` varchar(50) DEFAULT NULL,
                        `user_id` bigint(20) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `card_user_id_fk` (`creator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for `flyway_schema_history`
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
                                         `installed_rank` int(11) NOT NULL,
                                         `version` varchar(50) DEFAULT NULL,
                                         `description` varchar(200) NOT NULL,
                                         `type` varchar(20) NOT NULL,
                                         `script` varchar(1000) NOT NULL,
                                         `checksum` int(11) DEFAULT NULL,
                                         `installed_by` varchar(100) NOT NULL,
                                         `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                         `execution_time` int(11) NOT NULL,
                                         `success` tinyint(1) NOT NULL,
                                         PRIMARY KEY (`installed_rank`),
                                         KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------

-- ----------------------------
-- Table structure for `knowledge_base`
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_base`;
CREATE TABLE `knowledge_base` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                  `card_id` bigint(20) DEFAULT NULL,
                                  `review_time` bigint(20) DEFAULT NULL,
                                  `gmt_create` bigint(20) DEFAULT NULL,
                                  `gmt_modified` bigint(20) DEFAULT NULL,
                                  `review_num` bigint(20) DEFAULT NULL,
                                  `user_id` bigint(20) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `knowledge_base_card_id_fk` (`card_id`),
                                  CONSTRAINT `knowledge_base_card_id_fk` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_base
-- ----------------------------

-- ----------------------------
-- Table structure for `label_base`
-- ----------------------------
DROP TABLE IF EXISTS `label_base`;
CREATE TABLE `label_base` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `label_name` varchar(20) DEFAULT NULL,
                              `user_id` bigint(20) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label_base
-- ----------------------------

-- ----------------------------
-- Table structure for `public_card`
-- ----------------------------
DROP TABLE IF EXISTS `public_card`;
CREATE TABLE `public_card` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `gmt_create` bigint(20) DEFAULT NULL,
                               `gmt_modified` bigint(20) DEFAULT NULL,
                               `card_id` bigint(20) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of public_card
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `name` varchar(50) DEFAULT NULL,
                        `token` varchar(36) DEFAULT NULL,
                        `gmt_create` bigint(20) DEFAULT NULL,
                        `gmt_modified` bigint(20) DEFAULT NULL,
                        `mail` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王牌飞行员', '123456', null, null, '1@qq.com');
