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

 Date: 19/04/2021 00:26:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuid` int(0) NOT NULL AUTO_INCREMENT,
  `menutitle` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `menudate` date NOT NULL,
  `menured` int(0) NOT NULL,
  `menucomment` int(0) NOT NULL,
  `titleid` int(0) NOT NULL,
  `info1` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info2` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `rightto` int(0) NOT NULL,
  `detailstext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`menuid`) USING BTREE,
  UNIQUE INDEX `menutitle`(`menutitle`) USING BTREE,
  UNIQUE INDEX `titleid`(`titleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (31, '小明的日常', '2021-04-12', 0, 0, 1, '沙雕怎么炼成', '如果保持单身', 1, '<h2 style=\"text-align: center;\">沙雕 憨批</h2>');
INSERT INTO `menu` VALUES (38, '雷腾的悲伤生活', '2021-04-13', 0, 0, 2, '666', '666', 1, '<h2><img src=\"http://img.baidu.com/hi/jx2/j_0003.gif\"/>添加内容</h2>');
INSERT INTO `menu` VALUES (39, '假如给你一百万', '2021-04-13', 0, 0, 3, '花钱小能手', '如何炒股', 1, '<h2><img src=\"http://img.baidu.com/hi/jx2/j_0003.gif\"/>添加内容</h2>');
INSERT INTO `menu` VALUES (40, '家', '2021-04-13', 0, 0, 4, '过年的快乐', '新年习俗', 1, '<h2><img src=\"http://img.baidu.com/hi/jx2/j_0003.gif\"/>添加内容</h2>');
INSERT INTO `menu` VALUES (45, 'spring', '2022-10-18', 30, 60, 9, 'springboot', 'springmvc', 0, '我是');
INSERT INTO `menu` VALUES (46, 'Vue', '2022-10-18', 30, 60, 10, 'vue快速入门', 'vuecli', 0, '我是');
INSERT INTO `menu` VALUES (47, 'Mybatis', '2022-10-18', 30, 60, 11, 'jdbc', 'C3p0', 0, '我是');
INSERT INTO `menu` VALUES (48, 'Python', '2022-10-18', 30, 60, 12, '深度学习', '未来展望', 0, '我是');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replecomments
-- ----------------------------
INSERT INTO `replecomments` VALUES (1, 1, 1, 0, 'spring', '你省点把', 2, 99, '2021-10-06');
INSERT INTO `replecomments` VALUES (2, 1, 1, 0, 'spring', '傻逼万一', 2, 99, '2021-10-08');
INSERT INTO `replecomments` VALUES (3, 2, 1, 0, 'spring', '草泥马', 2, 99, '2021-10-08');

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
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topiccomments
-- ----------------------------
INSERT INTO `topiccomments` VALUES (1, 1, 'spring', '你个傻逼玩意', '2021-10-05', 0);
INSERT INTO `topiccomments` VALUES (2, 1, 'spring', '玩尼玛', '2021-10-05', 0);
INSERT INTO `topiccomments` VALUES (3, 1, 'spring', '555', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (4, 1, 'spring', '66', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (5, 1, 'spring', '66666666666666666666666666666666666666666', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (6, 2, 'spring', '傻逼一号', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (7, 2, 'Vue', '吃屎把', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (8, 1, 'Vue', '2', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (9, 1, 'spring', '666', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (10, 1, 'spring', 'rnma', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (11, 1, '小明的日常', '你啊的', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (12, 1, 'spring', '555', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (13, 1, 'spring', '555', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (14, 1, 'spring', 'fg', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (15, 1, 'spring', '666', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (16, 1, 'spring', '1111', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (17, 1, 'Vue', '4444', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (18, 1, 'spring', '4', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (19, 1, 'spring', '444', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (20, 1, 'spring', '4', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (21, 1, 'spring', '555', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (22, 1, 'spring', '444', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (23, 1, 'spring', 'hhh', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (24, 1, 'spring', 'fff', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (25, 1, 'spring', 'dddd\n', '2021-04-18', 0);
INSERT INTO `topiccomments` VALUES (26, 1, 'spring', '4444', '2021-04-19', 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `uphonenubmer` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `uemile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upower` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE,
  UNIQUE INDEX `uphonenubmer`(`uphonenubmer`) USING BTREE,
  UNIQUE INDEX `uemile`(`uemile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', '17797516883', '1670844920@qq.com', '普通');
INSERT INTO `users` VALUES (2, 'admin2', '123456', '17797516882', '1670844922@qq.com', '普通');

SET FOREIGN_KEY_CHECKS = 1;
