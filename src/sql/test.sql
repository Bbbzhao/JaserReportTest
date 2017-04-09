/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-04-09 11:13:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reportable
-- ----------------------------
DROP TABLE IF EXISTS `reportable`;
CREATE TABLE `reportable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `outgo` varchar(60) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `remark` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reportable
-- ----------------------------
INSERT INTO `reportable` VALUES ('1', '小红', '化妆品', '2017-04-11 08:15:11', '100.50', 'YSL');
INSERT INTO `reportable` VALUES ('2', '小红', '化妆品', '2017-03-22 08:15:42', '30.00', 'YSL');
INSERT INTO `reportable` VALUES ('3', '小红', '化妆品', '2017-04-29 08:15:55', '399.00', 'YSL');
INSERT INTO `reportable` VALUES ('4', '小红', '零食', '2017-03-15 08:16:25', '55.00', '巧克力');
INSERT INTO `reportable` VALUES ('5', '小红', '零食', '2017-04-06 08:16:42', '42.00', '薯片');
INSERT INTO `reportable` VALUES ('6', '小红', '零食', '2017-04-11 08:16:54', '33.70', '薯片');
INSERT INTO `reportable` VALUES ('7', '小红', '生活用品', '2017-04-26 08:17:20', '30.00', '洗衣液');
INSERT INTO `reportable` VALUES ('8', '小红', '生活用品', '2017-04-10 08:18:36', '25.30', '纸巾');
INSERT INTO `reportable` VALUES ('9', '小红', '生活用品', '2017-04-04 08:18:48', '15.00', '牙刷');
INSERT INTO `reportable` VALUES ('10', '小红', '电影', '2017-04-18 08:19:03', '28.00', '电影');
INSERT INTO `reportable` VALUES ('11', '小红', '交通', '2017-04-18 08:19:26', '30.00', 'bus');
INSERT INTO `reportable` VALUES ('12', '陈明', '生活用品', '2017-04-04 08:20:54', '33.00', '生活');
INSERT INTO `reportable` VALUES ('13', '陈明', '生活用品', '2017-05-24 08:20:57', '40.00', '生活');
INSERT INTO `reportable` VALUES ('14', '陈明', '生活用品', '2017-04-12 08:21:00', '36.00', '生活');
INSERT INTO `reportable` VALUES ('15', '陈明', '交通', '2017-04-26 08:21:18', '30.00', 'bus');
INSERT INTO `reportable` VALUES ('16', '陈明', '餐饮', '2017-04-13 08:21:21', '25.00', '饭');
INSERT INTO `reportable` VALUES ('17', '陈明', '电影', '2017-04-14 08:21:25', '30.00', '电影');
INSERT INTO `reportable` VALUES ('18', '大雄', '电子产品', '2017-04-26 08:21:59', '600.00', '手机');
INSERT INTO `reportable` VALUES ('19', '大雄', '电子产品', '2017-04-28 08:22:24', '1000.00', '手机');
INSERT INTO `reportable` VALUES ('20', '大雄', '餐饮', '2017-04-19 08:22:33', '30.00', '饭');
INSERT INTO `reportable` VALUES ('21', '大雄', '生活用品', '2017-04-18 08:22:44', '40.00', '生活');
