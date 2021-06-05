/*
 Navicat Premium Data Transfer

 Source Server         : cl
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : cl

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 05/06/2021 16:29:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuid` int(0) NOT NULL AUTO_INCREMENT,
  `menutitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `menudate` date NOT NULL,
  `menured` int(0) NOT NULL,
  `menucomment` int(0) NOT NULL,
  `titleid` int(0) NOT NULL,
  `info1` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info2` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `rightto` int(0) NOT NULL,
  `detailstext` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`menuid`) USING BTREE,
  UNIQUE INDEX `menutitle`(`menutitle`) USING BTREE,
  UNIQUE INDEX `titleid`(`titleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for replecomments
-- ----------------------------
DROP TABLE IF EXISTS `replecomments`;
CREATE TABLE `replecomments`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `commentid` int(0) NULL DEFAULT NULL,
  `repleid` int(0) NULL DEFAULT NULL,
  `repleType` int(0) NULL DEFAULT NULL,
  `repletitle` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `repletext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `fromusid` int(0) NULL DEFAULT NULL,
  `touid` int(0) NULL DEFAULT NULL,
  `repledate` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replecomments
-- ----------------------------

-- ----------------------------
-- Table structure for topiccomments
-- ----------------------------
DROP TABLE IF EXISTS `topiccomments`;
CREATE TABLE `topiccomments`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `topicid` int(0) NOT NULL,
  `topictitle` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topictext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topicdate` date NOT NULL,
  `topicred` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topiccomments
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `uemile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upower` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE,
  UNIQUE INDEX `uemile`(`uemile`) USING BTREE,
  UNIQUE INDEX `nickname`(`nickname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'kkk', '123456', '1727493926@qq.com', '普通', 'dfhdfh');

SET FOREIGN_KEY_CHECKS = 1;
