/*
 Navicat MySQL Data Transfer

 Source Server         : data
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 121.36.198.221:3306
 Source Schema         : 3

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 20/12/2021 18:43:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for athlete
-- ----------------------------
DROP TABLE IF EXISTS `athlete`;
CREATE TABLE `athlete`  (
  `athlete_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `athlete_sex` int NULL DEFAULT NULL,
  `athlete_age` int NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `athlete_tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `athlete_number` int NULL DEFAULT NULL,
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of athlete
-- ----------------------------
INSERT INTO `athlete` VALUES ('wangwu', 0, 7, 1, '12323145453', 1001, 'wudi', '1');
INSERT INTO `athlete` VALUES ('tomy', 0, 8, 2, '43424256567', 2001, 'great', '2');
INSERT INTO `athlete` VALUES ('Candy', 0, 7, 3, '34567879797', 4001, 'summit', '4');
INSERT INTO `athlete` VALUES ('sharo', 0, 8, 12, '13242525324', 1002, 'wudi', '1');
INSERT INTO `athlete` VALUES ('Amy', 0, 8, 14, '18350245849', 2002, 'great', '2');
INSERT INTO `athlete` VALUES ('John', 0, 7, 15, '34214143432', 3001, 'brilliant', '3');
INSERT INTO `athlete` VALUES ('Lucy', 0, 7, 16, '13242525525', 3002, 'brilliant', '3');
INSERT INTO `athlete` VALUES ('Jack', 0, 8, 17, '13632636232', 4002, 'summit', '4');
INSERT INTO `athlete` VALUES ('Tim', 0, 7, 18, '13526362747', 2003, 'great', '2');
INSERT INTO `athlete` VALUES ('Lisa', 0, 8, 19, '18438388383', 1003, 'wudi', '1');

-- ----------------------------
-- Table structure for athlete_join
-- ----------------------------
DROP TABLE IF EXISTS `athlete_join`;
CREATE TABLE `athlete_join`  (
  `order_number` int NOT NULL AUTO_INCREMENT COMMENT '自增',
  `project_number` int NULL DEFAULT NULL,
  `athlete_number` int NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  `group_number` int NULL DEFAULT NULL,
  `athlete_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `judge_ID` int NULL DEFAULT NULL,
  PRIMARY KEY (`order_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 251 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of athlete_join
-- ----------------------------
INSERT INTO `athlete_join` VALUES (200, 10106, 1001, 6, 1, 'wangwu', '1', 7001);
INSERT INTO `athlete_join` VALUES (201, 10106, 1001, 9, 1, 'wangwu', '1', 7002);
INSERT INTO `athlete_join` VALUES (202, 10106, 1001, 4, 1, 'wangwu', '1', 7003);
INSERT INTO `athlete_join` VALUES (203, 10106, 1001, 7, 1, 'wangwu', '1', 7004);
INSERT INTO `athlete_join` VALUES (204, 10106, 1001, 8, 1, 'wangwu', '1', 7005);
INSERT INTO `athlete_join` VALUES (205, 10106, 2001, 4, 1, 'tomy', '2', 7001);
INSERT INTO `athlete_join` VALUES (206, 10106, 2001, 8, 1, 'tomy', '2', 7002);
INSERT INTO `athlete_join` VALUES (207, 10106, 2001, 5, 1, 'tomy', '2', 7003);
INSERT INTO `athlete_join` VALUES (208, 10106, 2001, 9, 1, 'tomy', '2', 7004);
INSERT INTO `athlete_join` VALUES (209, 10106, 2001, 8, 1, 'tomy', '2', 7005);
INSERT INTO `athlete_join` VALUES (210, 10106, 4001, 7, 1, 'Candy', '4', 7001);
INSERT INTO `athlete_join` VALUES (211, 10106, 4001, 7, 1, 'Candy', '4', 7002);
INSERT INTO `athlete_join` VALUES (212, 10106, 4001, 9, 1, 'Candy', '4', 7003);
INSERT INTO `athlete_join` VALUES (213, 10106, 4001, 8, 1, 'Candy', '4', 7004);
INSERT INTO `athlete_join` VALUES (214, 10106, 4001, 7, 1, 'Candy', '4', 7005);
INSERT INTO `athlete_join` VALUES (215, 10106, 2002, 5, 1, 'Amy', '2', 7001);
INSERT INTO `athlete_join` VALUES (216, 10106, 2002, 2, 1, 'Amy', '2', 7002);
INSERT INTO `athlete_join` VALUES (217, 10106, 2002, 4, 1, 'Amy', '2', 7003);
INSERT INTO `athlete_join` VALUES (218, 10106, 2002, 6, 1, 'Amy', '2', 7004);
INSERT INTO `athlete_join` VALUES (219, 10106, 2002, 4, 1, 'Amy', '2', 7005);
INSERT INTO `athlete_join` VALUES (220, 10106, 3001, 2, 1, 'John', '3', 7001);
INSERT INTO `athlete_join` VALUES (221, 10106, 3001, 8, 1, 'John', '3', 7002);
INSERT INTO `athlete_join` VALUES (222, 10106, 3001, 7, 1, 'John', '3', 7003);
INSERT INTO `athlete_join` VALUES (223, 10106, 3001, 6, 1, 'John', '3', 7004);
INSERT INTO `athlete_join` VALUES (224, 10106, 3001, 4, 1, 'John', '3', 7005);
INSERT INTO `athlete_join` VALUES (225, 10106, 1002, 5, 1, 'Sharo', '1', 7001);
INSERT INTO `athlete_join` VALUES (226, 10106, 1002, 6, 1, 'Sharo', '1', 7002);
INSERT INTO `athlete_join` VALUES (227, 10106, 1002, 6, 1, 'Sharo', '1', 7003);
INSERT INTO `athlete_join` VALUES (228, 10106, 1002, 9, 1, 'Sharo', '1', 7004);
INSERT INTO `athlete_join` VALUES (229, 10106, 1002, 8, 1, 'Sharo', '1', 7005);
INSERT INTO `athlete_join` VALUES (230, 10106, 3002, 8, 1, 'Lucy', '3', 7001);
INSERT INTO `athlete_join` VALUES (231, 10106, 3002, 5, 1, 'Lucy', '3', 7002);
INSERT INTO `athlete_join` VALUES (232, 10106, 3002, 7, 1, 'Lucy', '3', 7003);
INSERT INTO `athlete_join` VALUES (233, 10106, 3002, 5, 1, 'Lucy', '3', 7004);
INSERT INTO `athlete_join` VALUES (234, 10106, 3002, 6, 1, 'Lucy', '3', 7005);
INSERT INTO `athlete_join` VALUES (235, 10106, 4002, 4, 1, 'Jack', '4', 7001);
INSERT INTO `athlete_join` VALUES (236, 10106, 4002, 7, 1, 'Jack', '4', 7002);
INSERT INTO `athlete_join` VALUES (237, 10106, 4002, 8, 1, 'Jack', '4', 7003);
INSERT INTO `athlete_join` VALUES (238, 10106, 4002, 9, 1, 'Jack', '4', 7004);
INSERT INTO `athlete_join` VALUES (239, 10106, 4002, 8, 1, 'Jack', '4', 7005);
INSERT INTO `athlete_join` VALUES (240, 10106, 2003, 6, 2, 'Tim', '2', 7001);
INSERT INTO `athlete_join` VALUES (241, 10106, 2003, 5, 2, 'Tim', '2', 7002);
INSERT INTO `athlete_join` VALUES (242, 10106, 2003, 8, 2, 'Tim', '2', 7003);
INSERT INTO `athlete_join` VALUES (243, 10106, 2003, 9, 2, 'Tim', '2', 7004);
INSERT INTO `athlete_join` VALUES (244, 10106, 2003, 7, 2, 'Tim', '2', 7005);
INSERT INTO `athlete_join` VALUES (245, 10106, 1003, 8, 2, 'Lisa', '1', 7001);
INSERT INTO `athlete_join` VALUES (246, 10106, 1003, 2, 2, 'Lisa', '1', 7002);
INSERT INTO `athlete_join` VALUES (247, 10106, 1003, 6, 2, 'Lisa', '1', 7003);
INSERT INTO `athlete_join` VALUES (248, 10106, 1003, 8, 2, 'Lisa', '1', 7004);
INSERT INTO `athlete_join` VALUES (249, 10106, 1003, 5, 2, 'Lisa', '1', 7005);
INSERT INTO `athlete_join` VALUES (250, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for athlete_join_preliminary
-- ----------------------------
DROP TABLE IF EXISTS `athlete_join_preliminary`;
CREATE TABLE `athlete_join_preliminary`  (
  `order_number` int NOT NULL AUTO_INCREMENT COMMENT '自增',
  `project_number` int NULL DEFAULT NULL,
  `athlete_number` int NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  `group_number` int NULL DEFAULT NULL,
  `athlete_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `judge_ID` int NULL DEFAULT NULL,
  PRIMARY KEY (`order_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 557 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of athlete_join_preliminary
-- ----------------------------
INSERT INTO `athlete_join_preliminary` VALUES (577, 10106, 2001, 7, NULL, 'tomy', '2', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (578, 10106, 4001, 7, NULL, 'Candy', '4', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (579, 10106, 2002, 4, NULL, 'Amy', '2', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (580, 10106, 4002, 7, NULL, 'Jack', '4', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (581, 10106, 2003, 7, NULL, 'Tim', '2', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (582, 10106, 1001, 7, NULL, 'wangwu', '1', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (583, 10106, 3001, 5, NULL, 'John', '3', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (584, 10106, 1002, 6, NULL, 'Sharo', '1', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (585, 10106, 3002, 6, NULL, 'Lucy', '3', NULL);
INSERT INTO `athlete_join_preliminary` VALUES (586, 10106, 1003, 6, NULL, 'Lisa', '1', NULL);

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES ('洪金源', '16', '189', '1', '男');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('18350245849', '洪金源', '12', '1');

-- ----------------------------
-- Table structure for judge
-- ----------------------------
DROP TABLE IF EXISTS `judge`;
CREATE TABLE `judge`  (
  `judgeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` int NULL DEFAULT NULL,
  `judge_ID` int NOT NULL,
  `Tel` int NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`judge_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judge
-- ----------------------------
INSERT INTO `judge` VALUES ('lisi', 0, 7001, 133, '1', 'gg');
INSERT INTO `judge` VALUES ('zhangsan', 0, 7002, 155, '2', 'whustu');
INSERT INTO `judge` VALUES ('kuqi', 0, 7003, 123, '1', 'bbb');
INSERT INTO `judge` VALUES ('mary', 0, 7004, 145, '3', 'ccc');
INSERT INTO `judge` VALUES ('tom', 0, 7005, 138604, '1', 'aaa');

-- ----------------------------
-- Table structure for leader
-- ----------------------------
DROP TABLE IF EXISTS `leader`;
CREATE TABLE `leader`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leader
-- ----------------------------
INSERT INTO `leader` VALUES ('徐梓萌', '12', '189', '1');
INSERT INTO `leader` VALUES ('洪金源', '16', '189', '1');
INSERT INTO `leader` VALUES ('徐梓', '19', '189', '1');
INSERT INTO `leader` VALUES ('徐三', '551559969', '123123', '2');
INSERT INTO `leader` VALUES ('徐二', '5515645', '123123', '1');
INSERT INTO `leader` VALUES ('徐', '551564564', '123123', '1');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `project_number` int NULL DEFAULT NULL,
  `project_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `group_number` int NULL DEFAULT NULL,
  `project_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_number` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`order_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (10106, 'room1', '7-8', '男', '单杠', NULL, '2021/12/19/18:00', 70);
INSERT INTO `project` VALUES (10107, 'room1', '7-8', '男', '双杠', NULL, '2021/12/19/18:00', 71);
INSERT INTO `project` VALUES (12, '12', '12', '男', '12', NULL, '12', 72);
INSERT INTO `project` VALUES (12, '12', '12', '女', '12', NULL, '12', 73);
INSERT INTO `project` VALUES (12, '12', '12', '女', '12', NULL, '12', 74);
INSERT INTO `project` VALUES (10108, 'room1', '10-11', '男', '单杠', NULL, '2021.09.22-11.00', 75);

-- ----------------------------
-- Table structure for sign_in
-- ----------------------------
DROP TABLE IF EXISTS `sign_in`;
CREATE TABLE `sign_in`  (
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `team_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_number` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`order_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign_in
-- ----------------------------
INSERT INTO `sign_in` VALUES ('wudi', '1', '123', 1);
INSERT INTO `sign_in` VALUES ('great', '2', '124', 2);
INSERT INTO `sign_in` VALUES ('brilliant', '3', '567', 3);
INSERT INTO `sign_in` VALUES ('summit', '4', '678', 4);
INSERT INTO `sign_in` VALUES ('sun', '5', 'ddd', 5);

SET FOREIGN_KEY_CHECKS = 1;
