/*
 Navicat MySQL Data Transfer

 Source Server         : server
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 106.13.210.56:3305
 Source Schema         : glkt_activity

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/09/2022 09:22:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coupon_info
-- ----------------------------
DROP TABLE IF EXISTS `coupon_info`;
CREATE TABLE `coupon_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_type` tinyint NOT NULL DEFAULT 1 COMMENT '购物券类型 1 注册卷 2：推荐赠送卷',
  `coupon_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠卷名字',
  `amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '金额',
  `condition_amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '使用门槛 0->没门槛',
  `start_time` date NULL DEFAULT NULL COMMENT '可以领取的开始日期',
  `end_time` date NULL DEFAULT NULL COMMENT '可以领取的结束日期',
  `range_type` tinyint NOT NULL DEFAULT 1 COMMENT '使用范围[1->全场通用]',
  `rule_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则描述',
  `publish_count` int NOT NULL DEFAULT 1 COMMENT '发行数量',
  `per_limit` int NOT NULL DEFAULT 1 COMMENT '每人限领张数',
  `use_count` int NOT NULL DEFAULT 0 COMMENT '已使用数量',
  `receive_count` int NOT NULL DEFAULT 0 COMMENT '领取数量',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
  `publish_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '发布状态[0-未发布，1-已发布]',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_info
-- ----------------------------
INSERT INTO `coupon_info` VALUES (1, 1, '双十一新用户注册赠送100元卷', 100.00, 0.00, '2021-06-03', '2022-07-10', 2, '双十一新用户注册赠送100元卷，全程通用，没有限制', 100, 1, 0, 3, '2021-07-02 00:00:00', 1, '2021-06-06 18:29:14', '2021-11-12 08:30:39', 0);
INSERT INTO `coupon_info` VALUES (2, 1, '双十一推荐课程并购买600福利卷', 600.00, 0.00, '2021-08-04', '2022-10-06', 2, '双十一推荐课程，新用户购买并支付，赠送推荐人600福利卷，全程通用，没有限制', 100, 1, 0, 4, '2022-08-26 00:00:00', 1, '2021-08-17 11:35:56', '2021-11-12 08:31:37', 0);
INSERT INTO `coupon_info` VALUES (3, 2, '国庆新用户注册赠送100元卷', 100.00, 0.00, '2021-09-05', '2022-10-06', 1, '国庆新用户注册赠送100元卷，全程通用，没有限制', 100, 1, 0, 4, '2021-10-07 00:00:00', 1, '2021-09-28 06:14:38', '2021-11-12 08:31:10', 0);
INSERT INTO `coupon_info` VALUES (4, 1, '国庆推荐课程并购买500福利卷', 500.00, 0.00, '2021-09-27', '2022-09-23', 1, '双十一推荐课程，新用户购买并支付，赠送推荐人500福利卷，全程通用，没有限制', 100, 1, 0, 25, '2022-09-30 00:00:00', 1, '2021-09-28 06:50:17', '2021-11-12 08:31:16', 0);

-- ----------------------------
-- Table structure for coupon_use
-- ----------------------------
DROP TABLE IF EXISTS `coupon_use`;
CREATE TABLE `coupon_use`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `coupon_id` bigint NULL DEFAULT NULL COMMENT '购物券ID',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单ID',
  `coupon_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购物券状态（1：未使用 2：已使用）',
  `get_time` datetime NULL DEFAULT NULL COMMENT '获取时间',
  `using_time` datetime NULL DEFAULT NULL COMMENT '使用时间',
  `used_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券领用表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_use
-- ----------------------------
INSERT INTO `coupon_use` VALUES (1, 1, 1, NULL, '0', '2021-11-10 09:02:23', NULL, NULL, '2021-07-02 00:00:00', '2021-11-10 09:02:23', '2021-11-22 07:59:00', 0);
INSERT INTO `coupon_use` VALUES (2, 1, 1, NULL, '0', '2021-11-10 09:02:23', NULL, NULL, '2022-07-02 00:00:00', '2021-11-10 09:02:28', '2021-11-22 07:59:02', 0);
INSERT INTO `coupon_use` VALUES (5, 4, 1, 4, '1', '2021-11-12 16:37:00', '2021-11-23 18:57:27', NULL, '2022-09-30 00:00:00', '2021-11-12 08:36:58', '2021-11-23 10:57:27', 0);
INSERT INTO `coupon_use` VALUES (9, 4, 1, 1, '1', '2021-11-22 14:50:05', '2021-11-22 21:38:48', '2021-11-22 21:39:12', '2022-09-30 00:00:00', '2021-11-22 14:50:05', '2021-11-22 13:39:12', 0);
INSERT INTO `coupon_use` VALUES (27, 4, 24, NULL, '0', '2021-11-23 18:14:01', NULL, NULL, '2022-09-30 00:00:00', '2021-11-23 10:14:01', '2021-11-23 10:14:01', 0);
INSERT INTO `coupon_use` VALUES (28, 4, 25, NULL, '0', '2021-11-23 18:49:01', NULL, NULL, '2022-09-30 00:00:00', '2021-11-23 10:49:00', '2021-11-23 10:49:00', 0);
INSERT INTO `coupon_use` VALUES (29, 4, 26, NULL, '0', '2021-11-23 18:49:03', NULL, NULL, '2022-09-30 00:00:00', '2021-11-23 10:49:03', '2021-11-23 10:49:03', 0);
INSERT INTO `coupon_use` VALUES (30, 4, 27, 5, '1', '2021-11-23 18:50:03', '2021-11-23 18:57:52', NULL, '2022-09-30 00:00:00', '2021-11-23 10:50:02', '2021-11-23 10:57:52', 0);
INSERT INTO `coupon_use` VALUES (31, 4, 28, NULL, '0', '2021-11-23 18:52:49', NULL, NULL, '2022-09-30 00:00:00', '2021-11-23 10:52:49', '2021-11-23 10:52:49', 0);
INSERT INTO `coupon_use` VALUES (32, 4, 29, NULL, '0', '2021-11-26 08:57:40', NULL, NULL, '2022-09-30 00:00:00', '2021-11-26 00:57:39', '2021-11-26 00:57:39', 0);
INSERT INTO `coupon_use` VALUES (33, 4, 29, NULL, '0', '2021-11-26 18:33:04', NULL, NULL, '2022-09-30 00:00:00', '2021-11-26 10:33:03', '2021-11-26 10:33:03', 0);
INSERT INTO `coupon_use` VALUES (34, 4, 30, NULL, '0', '2021-11-26 18:34:12', NULL, NULL, '2022-09-30 00:00:00', '2021-11-26 10:34:11', '2021-11-26 10:34:11', 0);
INSERT INTO `coupon_use` VALUES (35, 4, 31, NULL, '0', '2021-11-28 16:46:53', NULL, NULL, '2022-09-30 00:00:00', '2021-11-28 08:46:53', '2021-11-28 08:46:53', 0);
INSERT INTO `coupon_use` VALUES (36, 4, 32, NULL, '0', '2021-12-28 12:29:18', NULL, NULL, '2022-09-30 00:00:00', '2021-12-28 12:29:17', '2021-12-28 12:29:17', 0);
INSERT INTO `coupon_use` VALUES (37, 4, 33, NULL, '0', '2022-01-05 14:35:16', NULL, NULL, '2022-09-30 00:00:00', '2022-01-05 14:35:15', '2022-01-05 14:35:15', 0);

SET FOREIGN_KEY_CHECKS = 1;
