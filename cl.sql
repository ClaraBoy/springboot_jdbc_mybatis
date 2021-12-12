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

 Date: 21/11/2021 23:37:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `adminName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `adminPwd` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `imageUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upower` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `lastTime` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `adminName`(`adminName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES (1, 'admin', '123456', 'image', '管理员', 'admin');

-- ----------------------------
-- Table structure for applicationuser
-- ----------------------------
DROP TABLE IF EXISTS `applicationuser`;
CREATE TABLE `applicationuser`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `applicationid` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `applicationrealityName` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `applicationcardID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `applicationNickName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `applicationimageUrl` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `applicationdate` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `remark1` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `remark2` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `applicationid`(`applicationid`) USING BTREE,
  UNIQUE INDEX `applicationcardID`(`applicationcardID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of applicationuser
-- ----------------------------
INSERT INTO `applicationuser` VALUES (1, 'admin1', '马新强', '620121282516164', '姜比', '', '2021-10-21 17:21:53', 'yes', 'sss');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `collectName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `collectTitle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `collectapplicationid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (16, 'admin2', 'C语言判断素数（求素数）方法上', 'rootClaraTo365');
INSERT INTO `collect` VALUES (21, 'admin2', 'it行业', 'rootClaraTo365');

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `focusName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `focusapplicationid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of focus
-- ----------------------------
INSERT INTO `focus` VALUES (5, 'admin2', 'rootClaraTo365');

-- ----------------------------
-- Table structure for luckuser
-- ----------------------------
DROP TABLE IF EXISTS `luckuser`;
CREATE TABLE `luckuser`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sing` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of luckuser
-- ----------------------------

-- ----------------------------
-- Table structure for manner
-- ----------------------------
DROP TABLE IF EXISTS `manner`;
CREATE TABLE `manner`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `mannerName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `mannerTitle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `mannerapplicationid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manner
-- ----------------------------
INSERT INTO `manner` VALUES (20, 'admin2', 'C语言判断素数（求素数）方法上', 'rootClaraTo365');
INSERT INTO `manner` VALUES (21, 'admin2', 'C语言判断素数（求素数）方法上', 'rootClaraTo365');

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
  `titleid` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info1` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info1Url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `info2` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info2Url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `rightto` int NOT NULL,
  `detailstext` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `applicationid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `Review` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `likeNum` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`menuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 188 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 'C语言判断素数（求素数）方法上', '2021-06-05', 360, 5, '19', 'C语言', 'http://localhost:8081/Release_Article?titleName', '素数', 'http://localhost:8081/Release_Article?titleName', 0, '<pre class=\"snippet-textonly sh_sourceCode\" style=\"\"><p style=\"text-indent: 2em;\"><span style=\"font-size: 18px;\"> #include &lt;stdio.h&gt;<br/> &nbsp; &nbsp;#include &lt;math.h&gt;<br/> &nbsp; &nbsp;void main(){<br/> &nbsp; &nbsp;int m; &nbsp;// 输入的整数 <br/> &nbsp; &nbsp;int i; &nbsp;// 循环次数<br/> &nbsp; &nbsp;int k; &nbsp;// m 的平方根 <br/><br/> &nbsp; &nbsp;printf(&quot;输入一个整数：&quot;);<br/> &nbsp; &nbsp;scanf(&quot;%d&quot;,&amp;m);<br/><br/> &nbsp; &nbsp;// 求平方根，注意sqrt()的参数为 double 类型，这里要强制转换m的类型 <br/> &nbsp; &nbsp;k=(int)sqrt( (double)m );<br/> &nbsp; &nbsp;for(i=2;i&lt;=k;i++)<br/> &nbsp; &nbsp; &nbsp; &nbsp;if(m%i==0)<br/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;break;<br/><br/> &nbsp; &nbsp;// 如果完成所有循环，那么m为素数<br/> &nbsp; &nbsp;// 注意最后一次循环，会执行i++，此时 i=k+1，所以有i&gt;k <br/> &nbsp; &nbsp;if(i&gt;k)<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d是素数。\\n&quot;,m);<br/> &nbsp; &nbsp;else<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d不是素数。\\n&quot;,m);<br/><br/> &nbsp; &nbsp;return 0;<br/>}<br/>666<br/></span><br/></p></pre><p><br/><br/></p><p><span style=\"font-size: 18px;\"></span><br/></p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (2, 'C语言判断素数（求素数）方法下下', '2021-06-05', 9, 0, '20', 'C语言', '', '素数', '', 0, '<pre class=\"snippet-textonly sh_sourceCode\" style=\"display: block;\"><p style=\"text-indent: 2em;\"><span style=\"font-size: 18px;\">#include &lt;stdio.h&gt;<br/><br/> &nbsp; &nbsp;int main(){<br/> &nbsp; &nbsp;int a=0; &nbsp;// 素数的个数<br/> &nbsp; &nbsp;int num=0; &nbsp;// 输入的整数<br/><br/> &nbsp; &nbsp;printf(&quot;输入一个整数：&quot;);<br/> &nbsp; &nbsp;scanf(&quot;%d&quot;,&amp;num);<br/><br/> &nbsp; &nbsp;for(int i=2;i&lt;num;i++){<br/> &nbsp; &nbsp; &nbsp; &nbsp;if(num%i==0){<br/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;a++; &nbsp;// 素数个数加1<br/> &nbsp; &nbsp; &nbsp; &nbsp;}<br/> &nbsp; &nbsp;}<br/><br/> &nbsp; &nbsp;if(a==0){<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d是素数。\\n&quot;, num);<br/> &nbsp; &nbsp;}else{<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d不是素数。\\n&quot;, num);<br/> &nbsp; &nbsp;}<br/><br/> &nbsp; &nbsp;return 0;<br/>}<br/></span></p></pre><p><br/></p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (3, 'Java GUI 开发', '2021-06-05', 20, 0, '17', 'gui', '', 'java', '', 0, '<p style=\"text-indent: 2em;\">Java Swing开发教程：<a href=\"http://c.biancheng.net/view/1206.html\">http://c.biancheng.net/view/1206.html</a>&nbsp; 该网站还有其他编程语言教程</p><p style=\"text-indent: 2em;\">&nbsp;</p><p style=\"text-indent: 2em;\">本篇使用工具：IntelliJ IDEA + maven</p><p style=\"text-indent: 2em;\">1、IntelliJ IDEA安装</p><p style=\"text-indent: 2em;\">参考网址：<a id=\"cb_post_title_url\" class=\"postTitle2 vertical-middle\" href=\"https://www.cnblogs.com/leton/p/12037696.html\">IntelliJ IDEA 2019.3.1安装激活破解使用教程</a></p><p style=\"text-indent: 2em;\">激活：<a href=\"http://medeming.com/\">http://medeming.com/</a></p><p style=\"text-indent: 2em;\">2、Java GUI开发</p><p style=\"text-indent: 2em;\">Gradle项目</p><p style=\"text-indent: 2em;\">Java GUI入门：<a href=\"https://www.jianshu.com/p/cdca9a30b86b\">https://www.jianshu.com/p/cdca9a30b86b</a>&nbsp; &nbsp; gradle项目编译出错解决方法：<a href=\"http://www.mamicode.com/info-detail-3040677.html\">http://www.mamicode.com/info-detail-3040677.html</a></p><p style=\"text-indent: 2em;\">较全面：<a id=\"cb_post_title_url\" class=\"postTitle2 vertical-middle\" href=\"https://www.cnblogs.com/danhuai/p/12275178.html\">【Java】+GUI+swing可视化界面开发</a>&nbsp; 含jar包制作成安装包（jar→exe使用工具：exe4j，exe→安装包使用工具：HofoSetup）</p><p><br/></p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (4, 'it行业', '2021-06-05', 304, 7, '24', 'it前景', 'https://zhuanlan.zhihu.com/p/40891951', '找工作', 'https://www.baidu.com/baidu.php?url=K60000avpXkFvm720cjsYTyr4WtY6RlevG5DYhVb8mq_PmmHCzX-SzYugFs4On9evgyoAS033S4l4YX2sVw3vchA0HzdN9RqtgGRke0e71xYpd1exX7Zf-IZGpgu7VW9qvqhTO7kn8rw-UGA9UHTusmgs5UTHvvwzHy9mRIzKZdh14aHjxqL6rihNyHQ9E-EH4D5DfLhKtjG89jftleuG0yD7JnX.7b_NR2Ar5Od669BCXgjRzeASFDZtwhUVHf632MRRt_Q_DNKnLeMX5DkgboozuPvHWdsHRy2J7jZZOlsfRymoM4EQ9JuIWxDBaurGtIKnLxKfYt_U_DY2yQvTyjtLsqT7jHzlRL5spy59OPt5gKfYtVKnv-WFEozNtUnMgKfYt_QCJamJj7jQdsRP5Qa1Gk_EdwnRPZyrlAWv3h5U8HWq8egSGg8zT5wPtCSWrGyAp7WIggEtN0.U1Yk0ZDqdI24GPxL0ZKGm1Ys0ZK1pyI85ymzryR1mWNWnyFhuAD4PWfYnynYPhD3P1f1uAwWPyfv0ZfqdI24GPxL0A-V5HczPfKM5yq-TZns0ZNG5yF9pywd0ZKGujYknfKWpyfqnWR30AdY5HDsnH-xnH0kPdtznjRkg1DsPjuxrH0dn7t1PW0k0AVG5H00TMfqPW640AFG5HDdr7tznjwxnWDLg1RsnsKVm1YkrjmzPj6YPjndg1D4nHD3nWn1Pj-xnW0dnNtknjFxnWfLn164nHm4nj7xn0KkTA-b5H00TyPGujYs0ZFMIA7M5H00mycqn7ts0ANzu1Ys0ZKs5H00UMus5H08nj0snj0snj00Ugws5H00uAwETjYs0ZFJ5H00uANv5gKW0AuY5H00TA6qn0KET1Ys0AFL5HDs0A4Y5H00TLCq0A71gv-bm1dbnzdBuAw30A-bm1dcfbD0TA9YXHY0IA7zuvNY5Hm1g1KxnHRs0ZwdT1Y3nHR4nWbsn1RkrH04rjfkPW0d0ZF-TgfqnHm1PHbzPjTLPHRdnsK1pyfqmHD3P16vPvRsnjK9nH6YPfKWTvYqwH7jPWm1wWm4n1wDn1wjn0K9m1Yk0ZK85H00TydY5H00Tyd15H00uANYgvPsmHYs0ZGY5H00UyPxuMFEUHYsg1Kxn7tsg1Kxn0Kbmy4dmhNxTAk9Uh-bT1Ysg1Kxn7tkPjmsrHc1g1Kxn0Ksmgwxuhk9u1Ys0AwWpyfqn0K-IA-b5iYk0A71TAPW5H00IgKGUhPW5H00Tydh5H00uhPdIjYs0A-1mvsqn0K9uAu_myTqnfK_uhnqn0KbmvPb5fKYTh7buHYLPW0znjc0mhwGujYvfRcLwWmLwRn3nWTknWR1f16knRn1wH77rDmLnYfLr0KEm1Yk0AFY5H00Uv7YI1Ys0AqY5HD0ULFsIjYzc10Wnznzc1n4PjcvnHfdnBnkP10sc1DLnj08nj0snj0sc1DWnBnsczYWna3knHfvrHDWna34rHTvnj00XZPYIHYzP1RLPjTL0Z7xIWYsQWbLg108njKxna3sn7tsQWndg108nW9xni3sn7tsQWczg100mMPxTZFEuA-b5H00ThqGuhk9u1Ys0APv5fKGTdqWTADqn0KWTjYs0AN1IjYs0APzm1YdnWRYPs&us=newvui&xst=mWYvfRcLwWmLwRn3nWTknWR1f16knRn1wH77rDmLnYfLr0715HDkPWn4PjD4PWnLPW6vrHb4nH04g1czPNts0gTqdI24GPxL0gDqdI24GPxL0gRqnWTdP1fLPs7Y5HDvn1R4nWfLP1RKUgDqn0cs0BYKmv6quhPxTAnKUZRqn07WUWdBmy-bIfDzrjTYnjT3Pj6z&word=&ck=1760.2.84.357.149.392.138.1067&shh=www.baidu.com&wd=&bc=110101', 1, '<p>程序员最好可以做到世界首富，看看众多大企业的老板，特别是科技类的大部分都是做程序员出身的。</p><p><br/></p><p><strong>不过也要清楚几个问题，因为程序员不是人人都适合的。</strong></p><p><strong><br/></strong></p><p>1.自己适合做什么</p><p>2.自己能做什么</p><p>3.自己想做什么</p><p><br/></p><p><strong>同时学习程序开发也需要一定的基础知识：</strong>当然这些都是可以通过后天学习培养的！</p><p><br/></p><p>java基础：基本语法，各种容器的使用（map，list，队列，栈），面向对象（和js的原型还是差别蛮大的），多线程</p><p><br/></p><p>java web：servlet，spring框架,spring mvc（或是structs），hibernate（或是mybatis）</p><p><br/></p><p>数据库：选择一个数据库（用的比较多的是mysql），学习sql，基本维护（备份还原数据库），索引使</p><p><br/></p><p>用容器使用：tomcat或是jetty，jboss（看公司用啥）</p><p><br/></p><p><strong>做程序员的一些小经验</strong></p><p><strong><br/></strong></p><p>谨慎说&quot;是&quot;</p><p><br/></p><p>没有搞清楚开发需求、任务工作量、团队期望值之前，有前途的程序员不会轻易答应。特别是对于新人来说，比较急于表现自己，对于同事或者老板的工作安排来者不拒，精神可嘉，方法不可取。承诺太多，会出现自己无法按时完成的情况，即使按时完成，也可能没有达到别人的期望值，长期以往别人对你的失望会越来越多。</p><p>敢说“不”</p><p><br/></p><p>看起来和第一条雷同，其实细究起来不一样。第二条执行起来比第一条难得多。当遇到明显不合理的要求时，可以考虑拒绝，前提是准备好了全面充分的理由。不要经常说不，但是一旦说了，就要切中要害。有前途的程序员不会闷头干活，知道自己的定位和团队期望，分清楚哪些是不合理的要求，哪些是合理的要求，然后把明显不合理的要求和领导沟通下，取得支持。</p><p><br/></p><p><br/></p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (5, '围城里的道理', '2021-06-05', 138, 0, '26', '钱钟书', '', '围城', '', 0, '<p style=\"line-height: 1.75em;\">1.想要深入了解一个人，不妨一起去旅行！<br/>“像咱们这种旅行，最试验得出一个人的品性。旅行是最劳顿，最麻烦，叫人本相毕现时候。经过长期苦旅行而彼此不讨厌的人，才可以结交作朋友。”<br/>“结婚以后的蜜月旅行是次序颠倒的。应该先同旅行一个月，一个月舟车仆仆以后，双方还没有彼此看破，彼此要厌恶，还没有吵嘴翻脸，还要维持原来的婚约，这种夫妇保证不会离婚。”<br/>这是他几十年前写的！这些观点在现在也是十分受用<br/><br/>2.不要对一些约定、承诺深信不疑！<br/>“话是空的，人是活的；不是人照着话做，是话跟着人变。假如说了一句话，就至死不变的照做，世界上没有解约，反悔，道歉，离婚许多事了。”<br/>“譬如我跟某人同意一件事，甚而至于跟他定个契约，不管这契约上写的是十年，二十年，我订约的动机总根据着我目前的希望认识以及需要。不过‘目前’是最靠不住的，假使这个‘目前’已经落在背后了，条约上写明‘直到世界末日’都没有用，我们随时可以反悔。”<br/>“我们在社会上，一切说话全像戏院子里的入场券，一边一直‘过期作废’，可是那一边并不注明什么日期，随我们的便可以提早或延迟。”<br/>这些深刻透彻的解释，让我们明白这些承诺或是约定，都是会跟着承诺者产生变化的。<br/><br/>3.辩证的去对待身边的事情<br/>“ 天下只有两种。譬如一串葡萄到手，一种人挑最好吃的先吃，另一种人把最好的，留在最后吃。照例第一种人应该乐观，因为他每吃一颗都是吃剩的葡萄里最好的；第二种人应该悲观，因为他每吃一颗都是葡萄里最坏的。”<br/>“不过事实上适得其反，缘故是第二种人还有希望，第一种人只有回忆。”<br/>其实两种看法都正确，第一种人可以有积极的想法，因为每吃一颗都是好的；当然也可能消极的想，好葡萄越来越少。这都不是绝对的！<br/><br/>其实身边大大小小的事，都没有完全的好事，或完全的坏事！<br/><br/>4.我们一直身处在围城里<br/><br/>其实不只是婚姻、工作，大多数的事情都是围在城里的人想逃出来，城外的人想冲进去！</p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (6, '城南旧事', '2021-06-05', 116, 0, '27', '城南旧事', '', '林海音', '', 0, '<p style=\"line-height: 2em;\">写作背景：</p><p style=\"line-height: 2em;\">《城南旧事》是林海音以其7岁到13岁的生活为背景创作的。在台湾被日本帝国主义侵占期间，林海音一家不甘在日寇铁蹄下生活，举家迁居北京，小英子即在北京长大。看见冬阳下的骆驼队走过来，听见缓慢悦耳的铃声，童年重临于作者心头。</p><p style=\"line-height: 2em;\">夏天过去，秋天过去，冬天又来了，骆驼队又来了，但是童年一去不还。作者因想念童年住在北京城南时的那些景色和人物，于是把它们写了下来，让实际的童年过去，心灵的童年永存下来。这是林海音写这本小说的初衷。</p><p><br/></p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (120, '4', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (121, '5', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (122, '6', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (123, '7', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (124, '8', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (125, '9', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (126, '10', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (127, '11', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (128, '12', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (129, '13', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (130, '14', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (131, '15', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (132, '16', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (133, '17', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (134, '18', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (135, '19', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (136, '20', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (137, '21', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (138, '22', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (139, '23', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (140, '24', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (141, '25', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (142, '26', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (143, '27', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (144, '28', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (145, '29', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (146, '30', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (147, '31', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (148, '32', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (149, '33', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (150, '34', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (151, '35', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (152, '36', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (153, '37', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (154, '38', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (156, '40', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (157, '41', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (158, '42', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (159, '43', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (161, '44', '2021-10-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'admin1', 'yes', 0);
INSERT INTO `menu` VALUES (164, '城南旧事', '2021-11-19', 0, 0, '164', '陈楠出', 'http://www.baidu.com', '陈楠出', 'http://www.baidu.com', 1, '<p>6666</p>', 'admin1', 'yes', 0);
INSERT INTO `menu` VALUES (166, '220', '2021-06-10', 1, 2, '2', 'c', 'http://localhost:8081/', 'c', 'http://localhost:8081/', 1, '<p>123</p>', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (167, '221', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (168, '222', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (169, '223', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (170, '224', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (171, '225', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (172, '226', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (173, '227', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (174, '228', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (175, '229', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (176, '2220', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (177, '2221', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (178, '2222', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (179, '2223', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (180, '2224', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (181, '2225', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (182, '2226', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (183, '2227', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (184, '2228', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (185, '2229', '2021-06-10', 1, 2, '2', 'c', '', 'c', '', 1, '1', 'rootClaraTo365', 'yes', 0);
INSERT INTO `menu` VALUES (186, '220', '2021-11-20', 0, 0, '0', 'c', 'http://localhost:8081/', 'c', 'http://localhost:8081/', 1, '<p>12</p>', 'admin1', 'yes', 0);
INSERT INTO `menu` VALUES (187, '城南旧事里的故事', '2021-11-21', 0, 0, '0', '故事个', 'http://localhost:8081/Release_Article?titleName', '故事个', 'http://localhost:8081/Release_Article?titleName', 1, '<p><img src=\"https://p6.itc.cn/images01/20210306/9cfe362b81d64da9a02398462503dae1.jpeg\" alt=\"\" width=\"500\" height=\"245\" /></p>\n<p>5555556666</p>\n<p><img src=\"https://imgsa.baidu.com/forum/pic/item/6f061d950a7b02083ca2d0b563d9f2d3572cc87f.jpg\" alt=\"\" width=\"500\" height=\"133\" /></p>', 'admin1', 'yes', 0);

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS `notify`;
CREATE TABLE `notify`  (
  `notify_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `target_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `action` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `sender_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `is_read` int NULL DEFAULT NULL,
  `created_at` date NULL DEFAULT NULL,
  PRIMARY KEY (`notify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

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
INSERT INTO `notify` VALUES (15, '6666', '回复', '那块哪', '用户', '姜比', 1, '2021-08-23');
INSERT INTO `notify` VALUES (16, '66666', '回复', '那块哪', '用户', '姜比', 1, '2021-08-23');
INSERT INTO `notify` VALUES (17, '不一样', '回复', '花儿', '用户', '那块哪', 1, '2021-08-23');
INSERT INTO `notify` VALUES (18, '62', '回复', '花儿', '用户', '那块哪', 1, '2021-08-23');
INSERT INTO `notify` VALUES (19, '66666', '回复', '那块哪', '用户', '花儿', 1, '2021-08-23');
INSERT INTO `notify` VALUES (20, '4444', '回复', '那块哪', '用户', '花儿', 1, '2021-08-23');
INSERT INTO `notify` VALUES (21, '666', '回复', '姜比', '用户', '花儿', 1, '2021-10-18');
INSERT INTO `notify` VALUES (22, '6', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (23, 'uuu', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (24, 'sss', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (25, '6666', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (26, 'sdasd', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (27, 'sssss', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (28, '11111', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (29, '11111', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (30, 'e', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (31, 'e', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (32, 'e', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (33, 'e', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (34, '66', '回复', '花儿', '用户', '姜比', 1, '2021-10-21');
INSERT INTO `notify` VALUES (35, ' 审核通过', '0', 'Clara', '0', 'admin1', 0, '2021-10-29');
INSERT INTO `notify` VALUES (36, ' 审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (37, ' 审核 通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (38, ' 审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (39, ' 创作者审核未通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (40, ' admin 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (41, ' 创作者审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (42, ' admin 文章未审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-29');
INSERT INTO `notify` VALUES (43, ' 对对对 文章未审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-30');
INSERT INTO `notify` VALUES (44, ' 666 文章未审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-30');
INSERT INTO `notify` VALUES (45, ' 博客园和CSDN哪个将发展得更好？ 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-30');
INSERT INTO `notify` VALUES (46, ' opopopo 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-30');
INSERT INTO `notify` VALUES (47, ' 水电费 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-30');
INSERT INTO `notify` VALUES (48, ' ddd 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (49, ' hhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (50, ' hhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (51, ' hhhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (52, ' hhhhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (53, ' hhhhhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (54, ' hhhhhhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (55, ' hhhhhhhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (56, ' hhhhhhhhhh 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (57, ' ssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (58, ' sssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (59, ' ssssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (60, ' sssssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (61, ' ssssssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (62, ' sssssssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (63, ' ssssssssss 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-10-31');
INSERT INTO `notify` VALUES (64, ' 烦烦烦 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-01');
INSERT INTO `notify` VALUES (65, ' dddd 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-02');
INSERT INTO `notify` VALUES (66, ' dfsd 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-02');
INSERT INTO `notify` VALUES (67, ' 444 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-02');
INSERT INTO `notify` VALUES (68, ' 城南旧事 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-19');
INSERT INTO `notify` VALUES (69, ' dsf 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-20');
INSERT INTO `notify` VALUES (70, ' 城南旧事的背景 文章审核通过', '0', 'Clara', '0', '姜比', 1, '2021-11-20');
INSERT INTO `notify` VALUES (71, ' 220 文章未审核通过', '0', 'Clara', '0', '姜比', 0, '2021-11-21');
INSERT INTO `notify` VALUES (72, ' 城南旧事里的故事 文章审核通过', '0', 'Clara', '0', '姜比', 0, '2021-11-21');
INSERT INTO `notify` VALUES (73, ' 220 文章审核通过', '0', 'Clara', '0', '姜比', 0, '2021-11-21');
INSERT INTO `notify` VALUES (74, '属性\n', '回复', '姜比', '用户', '花儿', 0, '2021-11-21');
INSERT INTO `notify` VALUES (75, '傻子', '回复', '姜比', '用户', '花儿', 0, '2021-11-21');
INSERT INTO `notify` VALUES (76, '不支持的人\n', '回复', '姜比', '用户', '花儿', 0, '2021-11-21');
INSERT INTO `notify` VALUES (77, '数组', '回复', '花儿', '用户', '花儿', 0, '2021-11-21');
INSERT INTO `notify` VALUES (78, '开玩笑', '回复', '姜比', '用户', '花儿', 0, '2021-11-21');
INSERT INTO `notify` VALUES (79, '你不懂', '回复', '花儿', '用户', '花儿', 0, '2021-11-21');

-- ----------------------------
-- Table structure for replecomments
-- ----------------------------
DROP TABLE IF EXISTS `replecomments`;
CREATE TABLE `replecomments`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `commentname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `replename` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `repleType` int NOT NULL,
  `repletitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `repletext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `fromusid` int NULL DEFAULT NULL,
  `touid` int NOT NULL,
  `repledate` date NOT NULL,
  `applicationid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of replecomments
-- ----------------------------
INSERT INTO `replecomments` VALUES (51, '姜比', '花儿', 0, 'C语言判断素数（求素数）方法上', '属性\n', 2, 4, '2021-11-21', 'rootClaraTo365');
INSERT INTO `replecomments` VALUES (52, '姜比', '花儿', 0, 'C语言判断素数（求素数）方法上', '傻子', 2, 4, '2021-11-21', 'rootClaraTo365');
INSERT INTO `replecomments` VALUES (53, '姜比', '花儿', 0, 'C语言判断素数（求素数）方法上', '不支持的人\n', 2, 3, '2021-11-21', 'rootClaraTo365');
INSERT INTO `replecomments` VALUES (54, '花儿', '花儿', 0, 'C语言判断素数（求素数）方法上', '数组', 3, 4, '2021-11-21', 'rootClaraTo365');
INSERT INTO `replecomments` VALUES (55, '姜比', '花儿', 0, 'C语言判断素数（求素数）方法上', '开玩笑', 2, 4, '2021-11-21', 'rootClaraTo365');
INSERT INTO `replecomments` VALUES (56, '花儿', '花儿', 0, 'C语言判断素数（求素数）方法上', '你不懂', 3, 3, '2021-11-21', 'rootClaraTo365');

-- ----------------------------
-- Table structure for search_history
-- ----------------------------
DROP TABLE IF EXISTS `search_history`;
CREATE TABLE `search_history`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `searchhistry` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of search_history
-- ----------------------------
INSERT INTO `search_history` VALUES (17, 'admin2', '城南旧事里的故事');
INSERT INTO `search_history` VALUES (18, 'admin2', '22');

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
  `topictitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `topictext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topicdate` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topicred` int NULL DEFAULT NULL,
  `applicationid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of topiccomments
-- ----------------------------
INSERT INTO `topiccomments` VALUES (92, '花儿', 'C语言判断素数（求素数）方法上', '666', '2021-11-21 21:30:06', 0, 'rootClaraTo365');
INSERT INTO `topiccomments` VALUES (93, '花儿', 'C语言判断素数（求素数）方法上', '萨达', '2021-11-21 21:30:09', 1, 'rootClaraTo365');
INSERT INTO `topiccomments` VALUES (94, '花儿', 'C语言判断素数（求素数）方法上', '萨达啊', '2021-11-21 21:30:12', 2, 'rootClaraTo365');
INSERT INTO `topiccomments` VALUES (95, '花儿', 'C语言判断素数（求素数）方法上', '萨达萨达萨达', '2021-11-21 21:30:17', 3, 'rootClaraTo365');
INSERT INTO `topiccomments` VALUES (96, '花儿', 'C语言判断素数（求素数）方法上', '6994456', '2021-11-21 21:30:23', 4, 'rootClaraTo365');

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
  `applicationid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `nickname`(`nickname`) USING BTREE,
  UNIQUE INDEX `uemile`(`uemile`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'a99999999', '1727493926@qq.com', '普通', '那块哪', 'admin');
INSERT INTO `users` VALUES (2, 'admin1', 'qazqazqazqaz', '1670844920@qq.com', '会员', '姜比', 'admin1');
INSERT INTO `users` VALUES (3, 'admin2', 'qazqaz', '2829946723@qq.com', '会员', '花儿', 'admin2');

SET FOREIGN_KEY_CHECKS = 1;
