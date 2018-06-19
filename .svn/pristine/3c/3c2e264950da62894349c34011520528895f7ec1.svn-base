/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50522
Source Host           : 127.0.0.1:3306
Source Database       : power

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2018-06-15 20:27:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_power
-- ----------------------------
DROP TABLE IF EXISTS `sys_power`;
CREATE TABLE `sys_power` (
  `power_id` varchar(32) NOT NULL,
  `power_name` varchar(64) DEFAULT NULL,
  `power_resource` varchar(240) DEFAULT NULL,
  `power_message` varchar(240) DEFAULT NULL,
  `power_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_power
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  `role_info` varchar(160) DEFAULT NULL,
  `role_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_power
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_power`;
CREATE TABLE `sys_role_power` (
  `role_power_id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `power_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`role_power_id`),
  KEY `FK_Reference_3` (`role_id`),
  KEY `FK_Reference_4` (`power_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`power_id`) REFERENCES `sys_power` (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_power
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_tel` varchar(11) DEFAULT NULL,
  `user_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '12345', '1');
INSERT INTO `sys_user` VALUES ('2', 'root', 'root', '12306', '1');
INSERT INTO `sys_user` VALUES ('3', 'sa', 'sa', '10086', '1');
INSERT INTO `sys_user` VALUES ('4', 'test', 'test', '12315', '1');
INSERT INTO `sys_user` VALUES ('5', 'cs', 'cs', '10010', '1');
INSERT INTO `sys_user` VALUES ('6', 'scott', 'tiger', '54321', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_2` (`role_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
