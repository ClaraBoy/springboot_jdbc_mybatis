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

 Date: 23/08/2021 16:53:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for luckuser
-- ----------------------------
DROP TABLE IF EXISTS `luckuser`;
CREATE TABLE `luckuser`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sing` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of luckuser
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuid` mediumint NOT NULL AUTO_INCREMENT,
  `menutitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `menudate` date NOT NULL,
  `menured` int NOT NULL,
  `menucomment` int NOT NULL,
  `titleid` int NULL DEFAULT NULL,
  `info1` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info2` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `rightto` int NOT NULL,
  `detailstext` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`menuid`) USING BTREE,
  UNIQUE INDEX `menutitle`(`menutitle`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 'C语言判断素数（求素数）方法上', '2021-06-05', 179, 8, 19, 'C语言', '素数', 0, '<pre class=\"snippet-textonly sh_sourceCode\" style=\"\"><p style=\"text-indent: 2em;\"><span style=\"font-size: 18px;\"> #include &lt;stdio.h&gt;<br/> &nbsp; &nbsp;#include &lt;math.h&gt;<br/> &nbsp; &nbsp;void main(){<br/> &nbsp; &nbsp;int m; &nbsp;// 输入的整数 <br/> &nbsp; &nbsp;int i; &nbsp;// 循环次数<br/> &nbsp; &nbsp;int k; &nbsp;// m 的平方根 <br/><br/> &nbsp; &nbsp;printf(&quot;输入一个整数：&quot;);<br/> &nbsp; &nbsp;scanf(&quot;%d&quot;,&amp;m);<br/><br/> &nbsp; &nbsp;// 求平方根，注意sqrt()的参数为 double 类型，这里要强制转换m的类型 <br/> &nbsp; &nbsp;k=(int)sqrt( (double)m );<br/> &nbsp; &nbsp;for(i=2;i&lt;=k;i++)<br/> &nbsp; &nbsp; &nbsp; &nbsp;if(m%i==0)<br/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;break;<br/><br/> &nbsp; &nbsp;// 如果完成所有循环，那么m为素数<br/> &nbsp; &nbsp;// 注意最后一次循环，会执行i++，此时 i=k+1，所以有i&gt;k <br/> &nbsp; &nbsp;if(i&gt;k)<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d是素数。\\n&quot;,m);<br/> &nbsp; &nbsp;else<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d不是素数。\\n&quot;,m);<br/><br/> &nbsp; &nbsp;return 0;<br/>}</span><br/></p></pre><p><br/><br/></p><p><span style=\"font-size: 18px;\"></span><br/></p>');
INSERT INTO `menu` VALUES (2, 'C语言判断素数（求素数）方法下', '2021-06-05', 2, 0, 20, 'C语言', '素数', 0, '<pre class=\"snippet-textonly sh_sourceCode\" style=\"display: block;\"><p style=\"text-indent: 2em;\"><span style=\"font-size: 18px;\">#include &lt;stdio.h&gt;<br/><br/> &nbsp; &nbsp;int main(){<br/> &nbsp; &nbsp;int a=0; &nbsp;// 素数的个数<br/> &nbsp; &nbsp;int num=0; &nbsp;// 输入的整数<br/><br/> &nbsp; &nbsp;printf(&quot;输入一个整数：&quot;);<br/> &nbsp; &nbsp;scanf(&quot;%d&quot;,&amp;num);<br/><br/> &nbsp; &nbsp;for(int i=2;i&lt;num;i++){<br/> &nbsp; &nbsp; &nbsp; &nbsp;if(num%i==0){<br/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;a++; &nbsp;// 素数个数加1<br/> &nbsp; &nbsp; &nbsp; &nbsp;}<br/> &nbsp; &nbsp;}<br/><br/> &nbsp; &nbsp;if(a==0){<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d是素数。\\n&quot;, num);<br/> &nbsp; &nbsp;}else{<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d不是素数。\\n&quot;, num);<br/> &nbsp; &nbsp;}<br/><br/> &nbsp; &nbsp;return 0;<br/>}<br/></span></p></pre><p><br/></p>');
INSERT INTO `menu` VALUES (3, 'Java GUI 开发', '2021-06-05', 10, 0, 17, 'gui', 'java', 0, '<p style=\"text-indent: 2em;\">Java Swing开发教程：<a href=\"http://c.biancheng.net/view/1206.html\">http://c.biancheng.net/view/1206.html</a>&nbsp; 该网站还有其他编程语言教程</p><p style=\"text-indent: 2em;\">&nbsp;</p><p style=\"text-indent: 2em;\">本篇使用工具：IntelliJ IDEA + maven</p><p style=\"text-indent: 2em;\">1、IntelliJ IDEA安装</p><p style=\"text-indent: 2em;\">参考网址：<a id=\"cb_post_title_url\" class=\"postTitle2 vertical-middle\" href=\"https://www.cnblogs.com/leton/p/12037696.html\">IntelliJ IDEA 2019.3.1安装激活破解使用教程</a></p><p style=\"text-indent: 2em;\">激活：<a href=\"http://medeming.com/\">http://medeming.com/</a></p><p style=\"text-indent: 2em;\">2、Java GUI开发</p><p style=\"text-indent: 2em;\">Gradle项目</p><p style=\"text-indent: 2em;\">Java GUI入门：<a href=\"https://www.jianshu.com/p/cdca9a30b86b\">https://www.jianshu.com/p/cdca9a30b86b</a>&nbsp; &nbsp; gradle项目编译出错解决方法：<a href=\"http://www.mamicode.com/info-detail-3040677.html\">http://www.mamicode.com/info-detail-3040677.html</a></p><p style=\"text-indent: 2em;\">较全面：<a id=\"cb_post_title_url\" class=\"postTitle2 vertical-middle\" href=\"https://www.cnblogs.com/danhuai/p/12275178.html\">【Java】+GUI+swing可视化界面开发</a>&nbsp; 含jar包制作成安装包（jar→exe使用工具：exe4j，exe→安装包使用工具：HofoSetup）</p><p><br/></p>');
INSERT INTO `menu` VALUES (4, 'it行业', '2021-06-05', 157, 2, 24, 'it前景', '找工作', 1, '<p>程序员最好可以做到世界首富，看看众多大企业的老板，特别是科技类的大部分都是做程序员出身的。</p><p><br/></p><p><strong>不过也要清楚几个问题，因为程序员不是人人都适合的。</strong></p><p><strong><br/></strong></p><p>1.自己适合做什么</p><p>2.自己能做什么</p><p>3.自己想做什么</p><p><br/></p><p><strong>同时学习程序开发也需要一定的基础知识：</strong>当然这些都是可以通过后天学习培养的！</p><p><br/></p><p>java基础：基本语法，各种容器的使用（map，list，队列，栈），面向对象（和js的原型还是差别蛮大的），多线程</p><p><br/></p><p>java web：servlet，spring框架,spring mvc（或是structs），hibernate（或是mybatis）</p><p><br/></p><p>数据库：选择一个数据库（用的比较多的是mysql），学习sql，基本维护（备份还原数据库），索引使</p><p><br/></p><p>用容器使用：tomcat或是jetty，jboss（看公司用啥）</p><p><br/></p><p><strong>做程序员的一些小经验</strong></p><p><strong><br/></strong></p><p>谨慎说&quot;是&quot;</p><p><br/></p><p>没有搞清楚开发需求、任务工作量、团队期望值之前，有前途的程序员不会轻易答应。特别是对于新人来说，比较急于表现自己，对于同事或者老板的工作安排来者不拒，精神可嘉，方法不可取。承诺太多，会出现自己无法按时完成的情况，即使按时完成，也可能没有达到别人的期望值，长期以往别人对你的失望会越来越多。</p><p>敢说“不”</p><p><br/></p><p>看起来和第一条雷同，其实细究起来不一样。第二条执行起来比第一条难得多。当遇到明显不合理的要求时，可以考虑拒绝，前提是准备好了全面充分的理由。不要经常说不，但是一旦说了，就要切中要害。有前途的程序员不会闷头干活，知道自己的定位和团队期望，分清楚哪些是不合理的要求，哪些是合理的要求，然后把明显不合理的要求和领导沟通下，取得支持。</p><p><br/></p><p><br/></p>');
INSERT INTO `menu` VALUES (5, '围城里的道理', '2021-06-05', 137, 6, 26, '钱钟书', '围城', 0, '<p style=\"line-height: 1.75em;\">1.想要深入了解一个人，不妨一起去旅行！<br/>“像咱们这种旅行，最试验得出一个人的品性。旅行是最劳顿，最麻烦，叫人本相毕现时候。经过长期苦旅行而彼此不讨厌的人，才可以结交作朋友。”<br/>“结婚以后的蜜月旅行是次序颠倒的。应该先同旅行一个月，一个月舟车仆仆以后，双方还没有彼此看破，彼此要厌恶，还没有吵嘴翻脸，还要维持原来的婚约，这种夫妇保证不会离婚。”<br/>这是他几十年前写的！这些观点在现在也是十分受用<br/><br/>2.不要对一些约定、承诺深信不疑！<br/>“话是空的，人是活的；不是人照着话做，是话跟着人变。假如说了一句话，就至死不变的照做，世界上没有解约，反悔，道歉，离婚许多事了。”<br/>“譬如我跟某人同意一件事，甚而至于跟他定个契约，不管这契约上写的是十年，二十年，我订约的动机总根据着我目前的希望认识以及需要。不过‘目前’是最靠不住的，假使这个‘目前’已经落在背后了，条约上写明‘直到世界末日’都没有用，我们随时可以反悔。”<br/>“我们在社会上，一切说话全像戏院子里的入场券，一边一直‘过期作废’，可是那一边并不注明什么日期，随我们的便可以提早或延迟。”<br/>这些深刻透彻的解释，让我们明白这些承诺或是约定，都是会跟着承诺者产生变化的。<br/><br/>3.辩证的去对待身边的事情<br/>“ 天下只有两种。譬如一串葡萄到手，一种人挑最好吃的先吃，另一种人把最好的，留在最后吃。照例第一种人应该乐观，因为他每吃一颗都是吃剩的葡萄里最好的；第二种人应该悲观，因为他每吃一颗都是葡萄里最坏的。”<br/>“不过事实上适得其反，缘故是第二种人还有希望，第一种人只有回忆。”<br/>其实两种看法都正确，第一种人可以有积极的想法，因为每吃一颗都是好的；当然也可能消极的想，好葡萄越来越少。这都不是绝对的！<br/><br/>其实身边大大小小的事，都没有完全的好事，或完全的坏事！<br/><br/>4.我们一直身处在围城里<br/><br/>其实不只是婚姻、工作，大多数的事情都是围在城里的人想逃出来，城外的人想冲进去！</p>');
INSERT INTO `menu` VALUES (6, '城南旧事', '2021-06-05', 97, 1, 27, '城南旧事', '林海音', 0, '<p style=\"line-height: 2em;\">写作背景：</p><p style=\"line-height: 2em;\">《城南旧事》是林海音以其7岁到13岁的生活为背景创作的。在台湾被日本帝国主义侵占期间，林海音一家不甘在日寇铁蹄下生活，举家迁居北京，小英子即在北京长大。看见冬阳下的骆驼队走过来，听见缓慢悦耳的铃声，童年重临于作者心头。</p><p style=\"line-height: 2em;\">夏天过去，秋天过去，冬天又来了，骆驼队又来了，但是童年一去不还。作者因想念童年住在北京城南时的那些景色和人物，于是把它们写了下来，让实际的童年过去，心灵的童年永存下来。这是林海音写这本小说的初衷。</p><p><br/></p>');

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS `notify`;
CREATE TABLE `notify`  (
  `notify_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `target_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `action` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `sender_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `is_read` int NULL DEFAULT NULL,
  `created_at` date NULL DEFAULT NULL,
  PRIMARY KEY (`notify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notify
-- ----------------------------
INSERT INTO `notify` VALUES (1, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (2, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (3, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (4, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (5, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (6, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (7, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (8, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (9, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (10, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (11, '开启预购', '0', '小花', '0', '那块哪', 1, '2021-05-05');
INSERT INTO `notify` VALUES (12, '666', '回复', '姜比', '用户', '那块哪', 1, '2021-08-23');
INSERT INTO `notify` VALUES (13, 'ok', '回复', '那块哪', '用户', '姜比', 1, '2021-08-23');
INSERT INTO `notify` VALUES (14, '没问题', '回复', '姜比', '用户', '那块哪', 1, '2021-08-23');
INSERT INTO `notify` VALUES (15, '6666', '回复', '那块哪', '用户', '姜比', 0, '2021-08-23');
INSERT INTO `notify` VALUES (16, '66666', '回复', '那块哪', '用户', '姜比', 0, '2021-08-23');
INSERT INTO `notify` VALUES (17, '不一样', '回复', '花儿', '用户', '那块哪', 1, '2021-08-23');
INSERT INTO `notify` VALUES (18, '62', '回复', '花儿', '用户', '那块哪', 1, '2021-08-23');
INSERT INTO `notify` VALUES (19, '66666', '回复', '那块哪', '用户', '花儿', 1, '2021-08-23');
INSERT INTO `notify` VALUES (20, '4444', '回复', '那块哪', '用户', '花儿', 1, '2021-08-23');

-- ----------------------------
-- Table structure for replecomments
-- ----------------------------
DROP TABLE IF EXISTS `replecomments`;
CREATE TABLE `replecomments`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `commentname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `replename` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `repleType` int NOT NULL,
  `repletitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `repletext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `fromusid` int NULL DEFAULT NULL,
  `touid` int NOT NULL,
  `repledate` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of replecomments
-- ----------------------------
INSERT INTO `replecomments` VALUES (37, '那块哪', '花儿', 0, 'it行业', '66666', 1, 1, '2021-08-23');
INSERT INTO `replecomments` VALUES (38, '那块哪', '花儿', 0, 'it行业', '4444', 1, 0, '2021-08-23');

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song`  (
  `id` int NOT NULL,
  `songurl` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `ofNumber` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of song
-- ----------------------------

-- ----------------------------
-- Table structure for topiccomments
-- ----------------------------
DROP TABLE IF EXISTS `topiccomments`;
CREATE TABLE `topiccomments`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `topicname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topictitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topictext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topicdate` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topicred` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topiccomments
-- ----------------------------
INSERT INTO `topiccomments` VALUES (55, '花儿', 'it行业', '44444', '2021-8-23 16:33:26', 0);
INSERT INTO `topiccomments` VALUES (56, '花儿', 'it行业', '6666', '2021-8-23 16:33:31', 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `uemile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upower` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `nickname`(`nickname`) USING BTREE,
  UNIQUE INDEX `uemile`(`uemile`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'a99999999', '1727493926@qq.com', '普通', '那块哪');
INSERT INTO `users` VALUES (2, 'admin1', 'qazqaz', '1670844920@qq.com', '普通', '姜比');
INSERT INTO `users` VALUES (3, 'admin2', 'qazqaz', '2829946723@qq.com', '普通', '花儿');

SET FOREIGN_KEY_CHECKS = 1;
