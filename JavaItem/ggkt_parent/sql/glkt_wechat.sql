/*
 Navicat MySQL Data Transfer

 Source Server         : server
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 106.13.210.56:3305
 Source Schema         : glkt_wechat

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/09/2022 09:23:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '上级id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网页 链接，用户点击菜单可打开链接',
  `meun_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单KEY值，用于消息接口推送',
  `sort` tinyint NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单明细 订单明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '直播', NULL, NULL, NULL, 1, '2021-11-24 08:41:53', '2021-11-24 08:44:55', 0);
INSERT INTO `menu` VALUES (2, 0, '课程', NULL, NULL, NULL, 2, '2021-11-24 08:41:57', '2021-11-25 01:33:52', 0);
INSERT INTO `menu` VALUES (3, 0, '我的', NULL, NULL, NULL, 3, '2021-11-24 08:42:00', '2021-11-25 01:34:16', 0);
INSERT INTO `menu` VALUES (4, 3, '关于我们', 'click', NULL, 'aboutUs', 10, '2021-11-24 08:42:05', '2021-11-24 08:45:00', 0);
INSERT INTO `menu` VALUES (5, 1, '微服务架构演进', 'view', '/liveInfo/3', '', 2, '2021-11-24 10:29:12', '2021-11-25 01:26:13', 0);
INSERT INTO `menu` VALUES (6, 1, '大数据Spark全面分析', 'view', '/liveInfo/2', '', 4, '2021-11-24 10:29:24', '2021-11-25 01:27:05', 0);
INSERT INTO `menu` VALUES (7, 2, '后端开发', 'view', '/course/1', '', 1, '2021-11-24 10:31:48', '2021-11-25 01:27:06', 0);
INSERT INTO `menu` VALUES (8, 2, '大数据', 'view', '/course/14', '', 2, '2021-11-24 10:31:59', '2021-11-25 01:27:07', 0);
INSERT INTO `menu` VALUES (9, 3, '我的订单', 'view', '/order', '', 1, '2021-11-25 01:19:25', '2021-11-25 01:27:07', 0);
INSERT INTO `menu` VALUES (10, 3, '我的课程', 'view', '/myCourse', '', 2, '2021-11-25 01:26:51', '2021-11-25 01:26:51', 0);
INSERT INTO `menu` VALUES (11, 1, '全部列表', 'view', '/live', '', 6, '2021-11-25 01:41:47', '2021-11-25 01:41:47', 0);
INSERT INTO `menu` VALUES (12, 3, '我的优惠券', 'view', '/coupon', NULL, 3, '2021-11-26 08:52:27', '2021-11-26 08:52:40', 0);
INSERT INTO `menu` VALUES (13, 1, '11月26日晚8点电商分享', 'view', '/liveInfo/8', '', 1, '2021-11-26 09:21:39', '2021-11-26 09:21:39', 0);

SET FOREIGN_KEY_CHECKS = 1;
