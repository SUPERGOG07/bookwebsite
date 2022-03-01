/*
 Navicat Premium Data Transfer

 Source Server         : test_1
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : bookweb

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 01/03/2022 23:57:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '111');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bookName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ptUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sumIntro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `oncheck` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hot` int NOT NULL,
  INDEX `name`(`bookName`) USING BTREE,
  INDEX `author`(`author`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('霸道总裁爱上我', 'http://www.yetianlian.com/files/article/image/20/20281/20281s.jpg', '1111', '言情', '唐四', 'F', 5);
INSERT INTO `books` VALUES ('我的赛车手男友', 'http://www.yetianlian.com/files/article/image/20/20281/20281s.jpg', '22222', '言情', '胡说', 'F', 3);
INSERT INTO `books` VALUES ('龙王赘婿', 'http://www.yetianlian.com/files/article/image/20/20281/20281s.jpg', '33333', '爽文', '我吃番茄', 'F', 5);
INSERT INTO `books` VALUES ('夜的命名术', 'http://www.yetianlian.com/files/article/image/20/20281/20281s.jpg', '蓝与紫的霓虹中，浓密的钢铁苍穹下，数据洪流的前端，是科技革命之后的世界，也是现实与虚幻的分界。 钢铁与身体，过去与未来。这里，表世界与里世界并存，面前的一切，像是时间之墙近在眼前。 黑暗逐渐笼罩。可你要明白啊我的朋友，我们不能用温柔去应对黑暗，要用火。', '玄幻', '会说话的肘子', 'F', 4);
INSERT INTO `books` VALUES ('诡秘之主', 'https://bkimg.cdn.bcebos.com/pic/8435e5dde71190ef76c64df449578a16fdfaaf51cac1?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', '蒸汽与机械的浪潮中，谁能触及非凡。历史和黑暗的迷雾里，又是谁在耳语。我从诡秘中醒来，睁眼看见这个世界：\r\n枪械，大炮，巨舰，飞空艇，差分机；魔药，占卜，诅咒，倒吊人，封印物……光明依旧照耀，神秘从未远离，这是一段“愚者”的传说。', '奇幻', '爱潜水的乌贼', 'F', 5);
INSERT INTO `books` VALUES ('神雕侠侣', 'https://bkimg.cdn.bcebos.com/pic/79f0f736afc37931b96bf130efc4b74543a911a3?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', '小说的主脉写的是杨康之遗孤杨过与其师小龙女之间的爱情故事。杨过14岁起师从18岁的小龙女，于古墓派之中苦练武功，师徒二人情深义重、日久生情，却无奈于江湖阴鸷险恶、蒙古铁骑来犯使得有情之人难成眷属。历经一番坎坷与磨难的考验，杨过冲破封建礼教之禁锢，最终与小龙女由师徒变为“侠侣”。同时，在这段磨难经历中，杨过也消除了对郭靖、黄蓉夫妇的误会，在家仇与国难间作出抉择，成为真正的“侠之大者”。', '武侠', '金庸', 'F', 10);
INSERT INTO `books` VALUES ('尘缘', 'https://bkimg.cdn.bcebos.com/pic/0df431adcbef76094b36e5af3c92b4cc7cd98d1030e6?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', '这一握，握定了百世轮回，千载尘缘。', '仙侠', '烟雨江南', 'F', 2);
INSERT INTO `books` VALUES ('贩罪', 'https://bkimg.cdn.bcebos.com/pic/8ad4b31c8701a18be3f28fa2962f07082938fec6?x-bce-process=image/resize,m_lfit,w_536,limit_1/format,f_jpg', '天才。\r\n自闭、孤独、偏执、疯狂。\r\n每当时代变迁，逆十字的旗帜由他祭起。\r\n成则王侯将相，败则蛆蝇粪秽。\r\n平乱世，麾下四方辐辏，钟灵毓秀。\r\n隐市井，此生睥睨天下，唯有一人。', '都市', '三天两觉', 'F', 1);
INSERT INTO `books` VALUES ('111', 'https://tse1-mm.cn.bing.net/th/id/R-C.aeef803dd857e9739130e6c850149cf5?rik=F1YXyrIV%2bY5%2fEw&riu=http%3a%2f%2fww4.sinaimg.cn%2flarge%2fc8363850gw1f1ktsupp0pj21hc0xcwsi.jpg&ehk=EEr1zwba3oAg1C%2f3CJIqP9hEmQUhUFbzv7k4P8sFn1k%3d&risl=&pid=ImgRaw&r=0', '11111222', '武侠', '亚瑟', 'F', 2);
INSERT INTO `books` VALUES ('222', 'https://tse1-mm.cn.bing.net/th/id/R-C.aeef803dd857e9739130e6c850149cf5?rik=F1YXyrIV%2bY5%2fEw&riu=http%3a%2f%2fww4.sinaimg.cn%2flarge%2fc8363850gw1f1ktsupp0pj21hc0xcwsi.jpg&ehk=EEr1zwba3oAg1C%2f3CJIqP9hEmQUhUFbzv7k4P8sFn1k%3d&risl=&pid=ImgRaw&r=0', '22223333', '都市', '艾伦', 'F', 1);
INSERT INTO `books` VALUES ('沙滩排球', 'https://tse1-mm.cn.bing.net/th/id/R-C.aeef803dd857e9739130e6c850149cf5?rik=F1YXyrIV%2bY5%2fEw&riu=http%3a%2f%2fww4.sinaimg.cn%2flarge%2fc8363850gw1f1ktsupp0pj21hc0xcwsi.jpg&ehk=EEr1zwba3oAg1C%2f3CJIqP9hEmQUhUFbzv7k4P8sFn1k%3d&risl=&pid=ImgRaw&r=0', '嘿嘿嘿', '都市', '奶排', 'F', 1);
INSERT INTO `books` VALUES ('雷电将军', NULL, '我永远喜欢刻晴', '涩图', '米哈游', 'T', 0);
INSERT INTO `books` VALUES ('123', NULL, '11', '11', '456', 'F', 0);

-- ----------------------------
-- Table structure for bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `bookshelf`;
CREATE TABLE `bookshelf`  (
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `email`(`email`) USING BTREE,
  INDEX `bookName`(`bookName`) USING BTREE,
  CONSTRAINT `bookName` FOREIGN KEY (`bookName`) REFERENCES `books` (`bookName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookshelf
-- ----------------------------
INSERT INTO `bookshelf` VALUES ('1436216510@qq.com', '霸道总裁爱上我', '唐四');
INSERT INTO `bookshelf` VALUES ('1436216510@qq.com', '我的赛车手男友', '胡说');
INSERT INTO `bookshelf` VALUES ('1436216510@qq.com', '诡秘之主', '爱潜水的乌贼');
INSERT INTO `bookshelf` VALUES ('956347097@qq.com', '夜的命名术', '会说话的肘子');
INSERT INTO `bookshelf` VALUES ('956347097@qq.com', '诡秘之主', '爱潜水的乌贼');
INSERT INTO `bookshelf` VALUES ('956347097@qq.com', '神雕侠侣', '金庸');
INSERT INTO `bookshelf` VALUES ('956347097@qq.com', '尘缘', '烟雨江南');
INSERT INTO `bookshelf` VALUES ('956347097@qq.com', '贩罪', '三天两觉');
INSERT INTO `bookshelf` VALUES ('956347097@qq.com', '龙王赘婿', '我吃番茄');
INSERT INTO `bookshelf` VALUES ('123@qq.com', '尘缘', '烟雨江南');
INSERT INTO `bookshelf` VALUES ('123@qq.com', '我的赛车手男友', '胡说');
INSERT INTO `bookshelf` VALUES ('123@qq.com', '龙王赘婿', '我吃番茄');
INSERT INTO `bookshelf` VALUES ('123@qq.com', '霸道总裁爱上我', '唐四');

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype`  (
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('111', '亚瑟', '111BY亚瑟.txt');
INSERT INTO `booktype` VALUES ('222', '艾伦', '222BY艾伦.txt');
INSERT INTO `booktype` VALUES ('1', '2', '1646146397474寒假合作轮.pdf');
INSERT INTO `booktype` VALUES ('霸道总裁爱上我', '唐四', '霸道总裁爱上我BY唐四.txt');
INSERT INTO `booktype` VALUES ('测试', '测试', '测试BY测试.txt');
INSERT INTO `booktype` VALUES ('尘缘', '烟雨江南', '尘缘BY烟雨江南.txt');
INSERT INTO `booktype` VALUES ('贩罪', '三天两觉', '贩罪BY三天两觉.txt');
INSERT INTO `booktype` VALUES ('诡秘之主', '爱潜水的乌贼', '诡秘之主BY爱潜水的乌贼.txt');
INSERT INTO `booktype` VALUES ('龙王赘婿', '我吃番茄', '龙王赘婿BY我吃番茄.txt');
INSERT INTO `booktype` VALUES ('神雕侠侣', '金庸', '神雕侠侣BY金庸.txt');
INSERT INTO `booktype` VALUES ('我的赛车手男友', '胡说', '我的赛车手男友BY胡说.txt');
INSERT INTO `booktype` VALUES ('夜的命名术', '会说话的肘子', '夜的命名术BY会说话的肘子.txt');
INSERT INTO `booktype` VALUES ('1111111', '2', '1646147873182工业实习计划书20220222(new).docx');
INSERT INTO `booktype` VALUES ('雷电将军', '米哈游', '1646148653355QQ图片20220226173315 - 副本.pdf');
INSERT INTO `booktype` VALUES ('123', '456', '1646149697281工业实习计划书20220222(new).docx');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `tleNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`email`) USING BTREE,
  INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('15111111111', '123@qq.com', 'ABC12345678');
INSERT INTO `user` VALUES ('15105949725', '1436216510@qq.com', 'ABC12345678');
INSERT INTO `user` VALUES ('13850950635', '956347097@qq.co', 'QWE123456789');
INSERT INTO `user` VALUES ('13850950635', '956347097@qq.com', 'QWE123456789');

SET FOREIGN_KEY_CHECKS = 1;
