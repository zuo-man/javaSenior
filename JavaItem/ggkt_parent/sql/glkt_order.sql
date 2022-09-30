/*
 Navicat MySQL Data Transfer

 Source Server         : server
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 106.13.210.56:3305
 Source Schema         : glkt_order

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/09/2022 09:23:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_id` bigint NULL DEFAULT NULL COMMENT '课程id',
  `course_name` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程封面',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `origin_amount` decimal(16, 2) NULL DEFAULT NULL COMMENT '原始金额',
  `coupon_reduce` decimal(16, 2) NULL DEFAULT NULL COMMENT '优惠劵减免金额',
  `final_amount` decimal(16, 2) NULL DEFAULT NULL COMMENT '最终金额',
  `session_id` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会话id 当前会话id 继承购物车中会话id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_oid_cid`(`order_id`, `course_id`) USING BTREE,
  INDEX `idx_cid`(`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单明细 订单明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (1, 19, 'JAVA之Mysql基础', 'http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg', 1, 1, 1000.00, 0.00, 1000.00, NULL, '2021-11-22 13:38:47', '2021-11-26 03:07:25', 0);
INSERT INTO `order_detail` VALUES (2, 7, '尚硅谷大数据技术之Sqoop', 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/9452b057-6ad6-4600-891e-b168083fee4d.jpg', 2, 1, 23800.00, 0.00, 23800.00, NULL, '2021-11-23 10:09:08', '2021-11-26 03:08:05', 0);
INSERT INTO `order_detail` VALUES (3, 19, 'JAVA之Mysql基础', 'http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg', 3, 25, 1000.00, 0.00, 1000.00, NULL, '2021-11-23 10:54:51', '2021-11-26 03:07:26', 0);
INSERT INTO `order_detail` VALUES (4, 18, 'Java精品课程', 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/e4ee03d7-52bd-41ca-99f9-04dc23250a71.jpg', 4, 1, 22800.00, 0.00, 22800.00, NULL, '2021-11-23 10:57:27', '2021-11-26 03:07:41', 0);
INSERT INTO `order_detail` VALUES (5, 19, 'JAVA之Mysql基础', 'http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg', 5, 27, 1000.00, 0.00, 1000.00, NULL, '2021-11-23 10:57:52', '2021-11-26 03:07:27', 0);
INSERT INTO `order_detail` VALUES (6, 4, '尚硅谷大数据技术之HBase（2019新版）', 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/a16c5694-3037-4330-b1c5-438052081fcb.jpg', 6, 1, 19800.00, 0.00, 19800.00, NULL, '2021-11-26 08:56:07', '2021-11-26 08:56:07', 0);
INSERT INTO `order_detail` VALUES (7, 19, 'JAVA之Mysql基础', 'http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg', 7, 29, 1000.00, 0.00, 1000.00, NULL, '2021-11-26 10:35:46', '2021-11-26 10:35:46', 0);
INSERT INTO `order_detail` VALUES (8, 19, 'JAVA之Mysql基础', 'http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg', 8, 32, 1000.00, 0.00, 1000.00, NULL, '2021-12-28 15:25:01', '2021-12-28 15:25:01', 0);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `origin_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '原始金额',
  `coupon_reduce` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券减免',
  `final_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '最终金额',
  `order_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单交易编号（第三方支付用)',
  `trade_body` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单描述(第三方支付用)',
  `session_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'session id',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区id',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '失效时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uid`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表 订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 1, '晴天', '15010546384', 1000.00, 500.00, 500.00, '1', '20211122213847830', 'JAVA之Mysql基础', NULL, '成都', '2021-11-22 21:39:12', NULL, '2021-11-22 13:38:47', '2021-11-22 13:39:12', 0);
INSERT INTO `order_info` VALUES (2, 1, '晴天', '15010546384', 23800.00, 0.00, 23800.00, '1', '20211123180908744', '尚硅谷大数据技术之Sqoop', NULL, '成都', '2021-11-23 18:09:32', NULL, '2021-11-23 10:09:08', '2021-11-23 10:09:32', 0);
INSERT INTO `order_info` VALUES (3, 25, '晨', '13810168266', 1000.00, 0.00, 1000.00, '1', '20211123185451570', 'JAVA之Mysql基础', NULL, '', '2021-11-23 18:55:04', NULL, '2021-11-23 10:54:51', '2021-11-23 10:55:04', 0);
INSERT INTO `order_info` VALUES (4, 1, '晴天', '15069352568', 22800.00, 500.00, 22300.00, '0', '20211123185726513', 'Java精品课程', NULL, '成都', NULL, NULL, '2021-11-23 10:57:26', '2021-11-23 10:57:26', 0);
INSERT INTO `order_info` VALUES (5, 27, '******', '17512080612', 1000.00, 500.00, 500.00, '0', '20211123185752103', 'JAVA之Mysql基础', NULL, '', NULL, NULL, '2021-11-23 10:57:52', '2021-11-23 10:57:52', 0);
INSERT INTO `order_info` VALUES (6, 1, '晴天', NULL, 19800.00, 0.00, 19800.00, '1', '20211126165606808', '尚硅谷大数据技术之HBase（2019新版）', NULL, '成都', '2021-11-26 16:56:25', NULL, '2021-11-26 08:56:07', '2021-11-26 08:56:24', 0);
INSERT INTO `order_info` VALUES (7, 29, NULL, '13500009888', 1000.00, 0.00, 1000.00, '1', '20211126183546799', 'JAVA之Mysql基础', NULL, '', '2021-11-26 18:36:14', NULL, '2021-11-26 10:35:46', '2021-11-26 10:36:13', 0);
INSERT INTO `order_info` VALUES (8, 32, '', NULL, 1000.00, 0.00, 1000.00, '0', '20211228152501327', 'JAVA之Mysql基础', NULL, '', NULL, NULL, '2021-12-28 15:25:01', '2021-12-28 15:25:01', 0);

-- ----------------------------
-- Table structure for payment_info
-- ----------------------------
DROP TABLE IF EXISTS `payment_info`;
CREATE TABLE `payment_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint NULL DEFAULT NULL,
  `alipay_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `trade_body` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `payment_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payment_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付状态',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `callback_time` datetime NULL DEFAULT NULL COMMENT '回调时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_oid`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_info
-- ----------------------------
INSERT INTO `payment_info` VALUES (1, '20211122213847830', 1, 1, NULL, 0.01, 'JAVA之Mysql基础', '2', '2', '{transaction_id=4200001236202111223264279278, nonce_str=60QD7Oevf9wU02zc, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC56A4KDJuNRgj7hSoOqbxtDw, sign=1D685646F5D4D5BB4AEA9A3285A322B0, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211122213847830, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211122213909, is_subscribe=Y, return_code=SUCCESS}', '2021-11-22 21:39:12', '2021-11-22 21:38:55', '2021-11-22 13:39:12', 0);
INSERT INTO `payment_info` VALUES (2, '20211123180908744', 2, 1, NULL, 0.01, '尚硅谷大数据技术之Sqoop', '2', '2', '{transaction_id=4200001120202111230211882387, nonce_str=wn4XulMGtpBWmHvP, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC56A4KDJuNRgj7hSoOqbxtDw, sign=0F505EC786ECC4C649578D8A71DE139C, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211123180908744, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211123180927, is_subscribe=Y, return_code=SUCCESS}', '2021-11-23 18:09:32', '2021-11-23 18:09:15', '2021-11-23 10:09:32', 0);
INSERT INTO `payment_info` VALUES (3, '20211123185451570', 3, 25, NULL, 0.01, 'JAVA之Mysql基础', '2', '2', '{transaction_id=4200001123202111233106099225, nonce_str=VNHOOhJVvGW8V0xo, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC5zyE9p-gp7T_qUnFlv8VbB0, sign=CE0049BC9A1922CF70F423AC406BEB88, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211123185451570, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211123185502, is_subscribe=N, return_code=SUCCESS}', '2021-11-23 18:55:04', '2021-11-23 18:54:53', '2021-11-23 10:55:04', 0);
INSERT INTO `payment_info` VALUES (4, '20211123185726513', 4, 1, NULL, 0.01, 'Java精品课程', '2', '1', NULL, NULL, '2021-11-23 18:57:30', '2021-11-23 10:57:30', 0);
INSERT INTO `payment_info` VALUES (5, '20211123185752103', 5, 27, NULL, 0.01, 'JAVA之Mysql基础', '2', '1', NULL, NULL, '2021-11-23 18:57:53', '2021-11-23 10:57:53', 0);
INSERT INTO `payment_info` VALUES (6, '20211126165606808', 6, 1, NULL, 0.01, '尚硅谷大数据技术之HBase（2019新版）', '2', '2', '{transaction_id=4200001146202111266807786474, nonce_str=xTJGeq7F0Dz0c0U8, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC56A4KDJuNRgj7hSoOqbxtDw, sign=201D5B989A83376A3AA34DFDAB457CFF, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211126165606808, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211126165619, is_subscribe=Y, return_code=SUCCESS}', '2021-11-26 16:56:24', '2021-11-26 16:56:09', '2021-11-26 08:56:24', 0);
INSERT INTO `payment_info` VALUES (7, '20211126183546799', 7, 29, NULL, 0.01, 'JAVA之Mysql基础', '2', '2', '{transaction_id=4200001228202111261700574727, nonce_str=pzhJ1kkbfSwFMslY, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC51A-QwGey9bsMH0rwP6pj0g, sign=5B8528ED454C09E24F4297A97345FD87, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211126183546799, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211126183611, is_subscribe=Y, return_code=SUCCESS}', '2021-11-26 18:36:14', '2021-11-26 18:35:48', '2021-11-26 10:36:13', 0);

SET FOREIGN_KEY_CHECKS = 1;
