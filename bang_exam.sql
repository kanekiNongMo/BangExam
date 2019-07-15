/*
 Navicat Premium Data Transfer

 Source Server         : kaneki-mysql
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 192.168.56.102:3306
 Source Schema         : bang_exam

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 15/07/2019 09:44:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_entity
-- ----------------------------
DROP TABLE IF EXISTS `base_entity`;
CREATE TABLE `base_entity`  (
  `question_no` int(11) NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`question_no`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for essay_question
-- ----------------------------
DROP TABLE IF EXISTS `essay_question`;
CREATE TABLE `essay_question`  (
  `question_no` int(255) NOT NULL AUTO_INCREMENT COMMENT '问答题号',
  `type_id` int(20) NOT NULL COMMENT '专业类型，暂时定为1为java,2为测试',
  `question_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题目',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案',
  PRIMARY KEY (`question_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of essay_question
-- ----------------------------
INSERT INTO `essay_question` VALUES (1, 1, '什么是面向对象？', '一切皆对象');

-- ----------------------------
-- Table structure for exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper`  (
  `paper_no` int(255) NOT NULL AUTO_INCREMENT COMMENT '试卷编号',
  `major_type` int(255) NULL DEFAULT NULL COMMENT '试题类型,暂定1为java,2为测试',
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '试卷创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '试卷修改时间',
  PRIMARY KEY (`paper_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES (1, 1, '2019JAVA金典三十题', '2019-07-14 10:19:30', '2019-07-14 15:03:58');
INSERT INTO `exam_paper` VALUES (2, 1, '2018JAVA金典三十题', '2018-07-14 14:21:23', '2019-07-14 15:04:01');
INSERT INTO `exam_paper` VALUES (3, 1, '2017JAVA金典三十题', '2017-07-14 14:23:03', '2019-07-14 15:04:03');
INSERT INTO `exam_paper` VALUES (4, 1, '2016JAVA金典三十题', '2016-07-14 14:23:12', '2019-07-14 15:04:08');
INSERT INTO `exam_paper` VALUES (5, 2, '2019测试金典三十题', '2019-07-14 14:23:18', '2019-07-14 15:04:10');
INSERT INTO `exam_paper` VALUES (6, 2, '2018测试金典三十题', '2018-07-14 14:23:24', '2019-07-14 15:04:13');
INSERT INTO `exam_paper` VALUES (7, 2, '2017测试金典三十题', '2017-07-14 14:23:30', '2019-07-14 15:04:18');
INSERT INTO `exam_paper` VALUES (8, 2, '2016测试金典三十题', '2016-07-14 14:23:36', '2019-07-14 15:04:21');
INSERT INTO `exam_paper` VALUES (9, 3, '1', '2019-07-11 15:03:47', '2019-07-14 15:04:24');
INSERT INTO `exam_paper` VALUES (10, 4, '2', '2019-07-24 15:03:51', '2019-07-14 15:04:26');
INSERT INTO `exam_paper` VALUES (11, 5, '1', '2019-07-16 15:03:54', '2019-07-14 15:04:29');
INSERT INTO `exam_paper` VALUES (13, 2, '2020java', '2019-07-14 03:35:09', '2019-07-14 06:27:02');
INSERT INTO `exam_paper` VALUES (14, 2, '2020java', '2019-07-14 03:35:53', '2019-07-14 03:35:53');
INSERT INTO `exam_paper` VALUES (15, 2, '123456', '2019-07-14 03:59:44', '2019-07-14 03:59:44');
INSERT INTO `exam_paper` VALUES (16, 1, '55', '2019-07-14 03:59:57', '2019-07-14 03:59:57');
INSERT INTO `exam_paper` VALUES (17, NULL, '33', '2019-07-14 04:00:08', '2019-07-14 04:00:08');
INSERT INTO `exam_paper` VALUES (18, NULL, '11', '2019-07-14 04:08:27', '2019-07-14 04:08:27');
INSERT INTO `exam_paper` VALUES (19, 1, '111', '2019-07-14 04:12:07', '2019-07-14 04:12:07');
INSERT INTO `exam_paper` VALUES (20, 2, '111', '2019-07-14 04:12:17', '2019-07-14 04:12:17');
INSERT INTO `exam_paper` VALUES (21, 1, '33', '2019-07-14 04:15:37', '2019-07-14 04:15:37');
INSERT INTO `exam_paper` VALUES (22, 2, '11', '2019-07-14 04:15:51', '2019-07-14 04:15:51');
INSERT INTO `exam_paper` VALUES (23, NULL, '1', '2019-07-14 04:16:35', '2019-07-14 04:16:35');

-- ----------------------------
-- Table structure for exam_user
-- ----------------------------
DROP TABLE IF EXISTS `exam_user`;
CREATE TABLE `exam_user`  (
  `user_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_status` int(10) NULL DEFAULT NULL COMMENT '0禁用，1正常',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_user
-- ----------------------------
INSERT INTO `exam_user` VALUES (1, 'kaneki', '123456', 1);

-- ----------------------------
-- Table structure for major_type
-- ----------------------------
DROP TABLE IF EXISTS `major_type`;
CREATE TABLE `major_type`  (
  `type_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '题目专业类型编号',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目类型名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for multiple_choice_question
-- ----------------------------
DROP TABLE IF EXISTS `multiple_choice_question`;
CREATE TABLE `multiple_choice_question`  (
  `question_no` int(255) NOT NULL AUTO_INCREMENT COMMENT '多选题号',
  `type_id` int(20) NOT NULL COMMENT '专业类型,暂时定为1为java,2为测试',
  `question_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题目',
  `option_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项A',
  `option_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项B',
  `option_c` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项C',
  `option_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项D',
  `option_e` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项E',
  `option_f` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项F',
  `answer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案进行拼接保存',
  `explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案解释',
  PRIMARY KEY (`question_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of multiple_choice_question
-- ----------------------------
INSERT INTO `multiple_choice_question` VALUES (1, 1, '请选择?', '不能选c和b', '不能选c', '不能选择d', '不能选d', '不能选e和d', '不能选b', 'a+f', 'a+f');

-- ----------------------------
-- Table structure for paper_essay
-- ----------------------------
DROP TABLE IF EXISTS `paper_essay`;
CREATE TABLE `paper_essay`  (
  `paper_essay_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `paper_id` int(255) NULL DEFAULT NULL COMMENT '试卷编号',
  `essay_id` int(255) NULL DEFAULT NULL COMMENT '问答题编号',
  PRIMARY KEY (`paper_essay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_essay
-- ----------------------------
INSERT INTO `paper_essay` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for paper_multiple
-- ----------------------------
DROP TABLE IF EXISTS `paper_multiple`;
CREATE TABLE `paper_multiple`  (
  `paper_multiple_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `paper_id` int(255) NULL DEFAULT NULL COMMENT '试卷编号',
  `multiple_id` int(255) NULL DEFAULT NULL COMMENT '多选题编号',
  PRIMARY KEY (`paper_multiple_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_multiple
-- ----------------------------
INSERT INTO `paper_multiple` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for paper_single
-- ----------------------------
DROP TABLE IF EXISTS `paper_single`;
CREATE TABLE `paper_single`  (
  `paper_single_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `paper_id` int(255) NULL DEFAULT NULL COMMENT '试卷编号',
  `single_id` int(255) NULL DEFAULT NULL COMMENT '单选题编号',
  PRIMARY KEY (`paper_single_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_single
-- ----------------------------
INSERT INTO `paper_single` VALUES (1, 1, 1);
INSERT INTO `paper_single` VALUES (2, 1, 2);

-- ----------------------------
-- Table structure for paper_true_false
-- ----------------------------
DROP TABLE IF EXISTS `paper_true_false`;
CREATE TABLE `paper_true_false`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `paper_id` int(255) NULL DEFAULT NULL COMMENT '试卷编号',
  `true_false_id` int(255) NULL DEFAULT NULL COMMENT '判断题编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_true_false
-- ----------------------------
INSERT INTO `paper_true_false` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `score_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '成绩编号',
  `user_id` int(255) NULL DEFAULT NULL COMMENT '用户编号',
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分数',
  `exam_time` datetime(0) NULL DEFAULT NULL COMMENT '考试时间',
  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for single_choice_question
-- ----------------------------
DROP TABLE IF EXISTS `single_choice_question`;
CREATE TABLE `single_choice_question`  (
  `question_no` int(255) NOT NULL AUTO_INCREMENT COMMENT '单选题号',
  `type_id` int(11) NOT NULL COMMENT '专业类型，暂时定为1为java,2为测试',
  `question_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题目',
  `option_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项A',
  `option_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项B',
  `option_c` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项C',
  `option_d` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项D',
  `answer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答案',
  `explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案解释',
  PRIMARY KEY (`question_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of single_choice_question
-- ----------------------------
INSERT INTO `single_choice_question` VALUES (1, 1, '请选择a?', 'a', 'b', 'c', 'd', 'a', 'a');
INSERT INTO `single_choice_question` VALUES (2, 1, '请选择B?', 'A', 'B', 'C', 'D', 'A', 'B');

-- ----------------------------
-- Table structure for true_false_question
-- ----------------------------
DROP TABLE IF EXISTS `true_false_question`;
CREATE TABLE `true_false_question`  (
  `question_no` int(255) NOT NULL AUTO_INCREMENT COMMENT '判断题号',
  `type_id` int(255) NOT NULL COMMENT '专业类型，暂时定为1为java,2为测试',
  `question_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题目',
  `answer` int(20) NOT NULL COMMENT '答案，0为false,1为true',
  `explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案解释',
  PRIMARY KEY (`question_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of true_false_question
-- ----------------------------
INSERT INTO `true_false_question` VALUES (1, 1, '选错', 1, '错');

-- ----------------------------
-- Table structure for user_answer
-- ----------------------------
DROP TABLE IF EXISTS `user_answer`;
CREATE TABLE `user_answer`  (
  `answer_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(255) NULL DEFAULT NULL COMMENT '用户编号',
  `true_number` int(11) NULL DEFAULT NULL COMMENT '答对题数',
  `false_number` int(11) NULL DEFAULT NULL COMMENT '答错题数',
  PRIMARY KEY (`answer_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
