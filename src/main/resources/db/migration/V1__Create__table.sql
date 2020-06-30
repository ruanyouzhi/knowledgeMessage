/*
Navicat MySQL Data Transfer

Source Server         : knowledgemessage
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : knowledgemessage

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2020-06-30 09:09:50
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('26', '1', '1593476410453', '1593476410453', '1', 'test', 'test', '英语单词', 'test', 'test', '1');
INSERT INTO `card` VALUES ('27', '1', '1593476411178', '1593476411178', '1', 'test', 'test', '英语单词', 'test', 'test', '1');
INSERT INTO `card` VALUES ('28', '1', '1593476412014', '1593476412014', '1', 'test', 'test', '英语单词', 'test', 'test', '1');
INSERT INTO `card` VALUES ('29', '1', '1593476472072', '1593476472072', '1', 'test', 'test', '英语单词', 'test', 'test', '1');
INSERT INTO `card` VALUES ('30', '1', '1593476846132', '1593476846132', '1', 'test', 'test', '英语单词', 'test', 'test', '1');

-- ----------------------------
-- Table structure for `card_num`
-- ----------------------------
DROP TABLE IF EXISTS `card_num`;
CREATE TABLE `card_num` (
                            `card_id` bigint(20) NOT NULL DEFAULT '0',
                            `like_num` bigint(20) DEFAULT '0',
                            `comment_num` bigint(20) DEFAULT '0',
                            `collect_num` bigint(20) DEFAULT '0',
                            PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card_num
-- ----------------------------
INSERT INTO `card_num` VALUES ('26', '4', '0', '0');
INSERT INTO `card_num` VALUES ('27', '3', '0', '0');
INSERT INTO `card_num` VALUES ('28', '4', '0', '0');
INSERT INTO `card_num` VALUES ('29', '1', '0', '0');
INSERT INTO `card_num` VALUES ('30', '0', '0', '0');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `card_id` bigint(20) DEFAULT NULL,
                           `commentor` bigint(20) DEFAULT NULL,
                           `gmt_create` bigint(20) DEFAULT NULL,
                           `gmt_modified` bigint(20) DEFAULT NULL,
                           `content` varchar(500) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
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
                                  `card_name` varchar(20) DEFAULT NULL,
                                  `creator_id` bigint(20) DEFAULT NULL,
                                  `card_description` varchar(200) DEFAULT NULL,
                                  `last_review_time` bigint(20) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `knowledge_base_card_id_fk` (`card_id`),
                                  CONSTRAINT `knowledge_base_card_id_fk` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_base
-- ----------------------------
INSERT INTO `knowledge_base` VALUES ('25', '26', '1593476410453', '1593476410453', '1593476410453', '0', '1', 'test', '1', 'test', null);
INSERT INTO `knowledge_base` VALUES ('26', '27', '1593476411178', '1593476411178', '1593476411178', '0', '1', 'test', '1', 'test', null);
INSERT INTO `knowledge_base` VALUES ('27', '28', '1593476412014', '1593476412014', '1593476412014', '0', '1', 'test', '1', 'test', null);
INSERT INTO `knowledge_base` VALUES ('28', '29', '1593476472072', '1593476472072', '1593476472072', '0', '1', 'test', '1', 'test', null);
INSERT INTO `knowledge_base` VALUES ('29', '30', '1593476846132', '1593476846132', '1593476846132', '0', '1', 'test', '1', 'test', null);

-- ----------------------------
-- Table structure for `label_base`
-- ----------------------------
DROP TABLE IF EXISTS `label_base`;
CREATE TABLE `label_base` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `label_name` varchar(20) DEFAULT NULL,
                              `user_id` bigint(20) DEFAULT NULL,
                              `card_id` bigint(20) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label_base
-- ----------------------------
INSERT INTO `label_base` VALUES ('13', 'test', '1', '26');
INSERT INTO `label_base` VALUES ('14', 'test', '1', '27');
INSERT INTO `label_base` VALUES ('15', 'test', '1', '28');
INSERT INTO `label_base` VALUES ('16', 'test', '1', '29');
INSERT INTO `label_base` VALUES ('17', 'test', '1', '30');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `notifier` bigint(20) DEFAULT NULL,
                          `receiver` bigint(20) DEFAULT NULL,
                          `card_id` bigint(20) DEFAULT NULL,
                          `card_name` varchar(500) DEFAULT NULL,
                          `notifier_name` varchar(50) DEFAULT NULL,
                          `status` int(11) DEFAULT NULL,
                          `gmtCreate` bigint(20) DEFAULT NULL,
                          `type` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for `public_card`
-- ----------------------------
DROP TABLE IF EXISTS `public_card`;
CREATE TABLE `public_card` (
                               `card_id` bigint(20) NOT NULL DEFAULT '0',
                               `gmt_create` bigint(20) DEFAULT NULL,
                               `gmt_modified` bigint(20) DEFAULT NULL,
                               PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of public_card
-- ----------------------------
INSERT INTO `public_card` VALUES ('26', '1593476410453', '1593476410453');
INSERT INTO `public_card` VALUES ('27', '1593476411178', '1593476411178');
INSERT INTO `public_card` VALUES ('28', '1593476412014', '1593476412014');
INSERT INTO `public_card` VALUES ('29', '1593476472072', '1593476472072');
INSERT INTO `public_card` VALUES ('30', '1593476846132', '1593476846132');

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
                        `password` varchar(20) DEFAULT NULL,
                        `avatar_url` varchar(100) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_mail_uindex` (`mail`),
                        UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王牌飞行员', '123456', null, null, '1@qq.com', null, null);

-- ----------------------------
-- Table structure for `user_like`
-- ----------------------------
DROP TABLE IF EXISTS `user_like`;
CREATE TABLE `user_like` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `card_id` bigint(20) DEFAULT NULL,
                             `user_id` bigint(20) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_like
-- ----------------------------
INSERT INTO `user_like` VALUES ('1', '43', '1');
INSERT INTO `user_like` VALUES ('30', '29', '1');
INSERT INTO `user_like` VALUES ('32', '28', '1');
INSERT INTO `user_like` VALUES ('33', '26', '1');
