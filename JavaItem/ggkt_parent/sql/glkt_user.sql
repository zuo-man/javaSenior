/*
 Navicat MySQL Data Transfer

 Source Server         : server
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 106.13.210.56:3305
 Source Schema         : glkt_user

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/09/2022 09:23:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `nick_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` tinyint NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `province` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subscribe` tinyint NOT NULL DEFAULT 0 COMMENT '0：未订阅 1：已订阅',
  `open_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '小程序open id',
  `union_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信开放平台unionID',
  `recommend_id` bigint NULL DEFAULT NULL COMMENT '推荐人用户id',
  `status` tinyint NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '15611248741', NULL, NULL, '晴天', 1, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXvnJccFhOR1cSpVpdQ3BP5eTPCUO9CyI1feDefMoUFyA4E2C1oe2j8VMLrtAyBricvA/132', '成都', 0, 'oQTXC56A4KDJuNRgj7hSoOqbxtDw', NULL, NULL, NULL, '2021-10-21 07:19:29', '2021-11-23 11:32:44', 0);
INSERT INTO `user_info` VALUES (24, '13562359685', NULL, NULL, '简', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/2GVkdw3J3kLruw37EYdW6RsFNUEL5mX5K3tgDolibM8hYICibPXpFIneMzyQpkFI0TsnE8R5ryUMvriaBmBNmNOsQ/132', '', 0, 'oQTXC51A-QwGey9bsMH0rwP6pj0g0', NULL, 1, NULL, '2021-11-23 10:14:00', '2021-11-26 10:31:55', 0);
INSERT INTO `user_info` VALUES (25, '13810168266', NULL, NULL, '晨', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXsnvhFoEV7vpEMZkCfT0E9ib1TnUFHUYSppWy575onuuEDH8NRwU4aDj8PwXjQjY9OA/132', '', 0, 'oQTXC5zyE9p-gp7T_qUnFlv8VbB0', NULL, 1, NULL, '2021-11-23 10:49:00', '2021-11-26 08:45:40', 0);
INSERT INTO `user_info` VALUES (26, '13716962779', NULL, NULL, '张晓飞', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/vByI6bJx9js2GLBicLYGXJKy5cnRq9ojCBNmk3Zesakia8eShdfwV6JLfIumJyEPtLerUlQDwcF6ng8OuugaKEjg/132', '', 0, 'oQTXC5xUafs2LDYATkXsXigZkE98', NULL, 1, NULL, '2021-11-23 10:49:03', '2021-11-26 08:45:40', 0);
INSERT INTO `user_info` VALUES (27, '17512080612', NULL, NULL, '我是', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqhPquGcKzauUrwFxf82UfZVGbXApUU2vXhnQ7ZmSyHkGnPpUibahRs49vJcibTp1Co8iawppr0McL2A/132', '', 0, 'oQTXC5znK6fxptadSmzTwjNIPbKo', NULL, 1, NULL, '2021-11-23 10:50:02', '2021-11-26 08:45:41', 0);
INSERT INTO `user_info` VALUES (28, '15901520518', NULL, NULL, '婷儿姐', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVXAe2FkRhjYicibOVzMZrsEaObjmNMes9ru9ZNjx6WXt6aQSQsiccw25r2FzeGIqlUcYson4uQ8Bcw/132', '', 0, 'oQTXC51Qq1bxuVcpivsiW3xeC6Us', NULL, 1, NULL, '2021-11-23 10:52:48', '2021-11-26 08:45:42', 0);
INSERT INTO `user_info` VALUES (29, '13500009888', NULL, NULL, '吧', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/2GVkdw3J3kLruw37EYdW6RsFNUEL5mX5K3tgDolibM8hYICibPXpFIneMzyQpkFI0TsnE8R5ryUMvriaBmBNmNOsQ/132', '', 0, 'oQTXC51A-QwGey9bsMH0rwP6pj0g', NULL, NULL, NULL, '2021-11-26 10:33:03', '2021-11-26 10:39:46', 0);
INSERT INTO `user_info` VALUES (30, '13766816630', NULL, NULL, '环', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTInJ6LZx4So2d41ZWmv0z9hmM4yaE2dn2gvBeiasssw66NQCibuou4icHyMhjdu9ZQR6xiav2qswyNylA/132', '', 0, 'oQTXC5x67M6p0kvuP8aDUrz3WZPg', NULL, NULL, NULL, '2021-11-26 10:34:11', '2021-11-26 10:39:52', 0);
INSERT INTO `user_info` VALUES (31, NULL, NULL, NULL, 'ya', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/fw0kHmJ1rqCwcibxTYUTBZ3KltT74MG7hnhCRd5EAazTDibckZ4gKR11iaVa1dM8BiccZXpnXv2rVnJLDltB7mCnrA/132', '', 0, 'oQTXC51_nDWnWRosSd-LxCfq_5l0', NULL, NULL, NULL, '2021-11-28 08:46:52', '2021-11-28 08:46:52', 0);
INSERT INTO `user_info` VALUES (32, '15611248741', NULL, NULL, '', 0, '', '', 1, 'oQTXC56lAy3xMOCkKCImHtHoLLN4', NULL, NULL, NULL, '2021-12-28 12:29:17', '2021-12-28 12:29:17', 0);
INSERT INTO `user_info` VALUES (33, '13521096172', NULL, NULL, 'testatguigu', 0, '', '', 0, 'oQTXC52GRKUUFk6WVH4yF22R3NlM', NULL, NULL, NULL, '2022-01-05 14:35:15', '2022-01-05 14:35:15', 0);

-- ----------------------------
-- Table structure for user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录城市',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '登录类型【0-web，1-移动】',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登陆记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
