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

 Date: 10/06/2021 20:28:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for luckuser
-- ----------------------------
DROP TABLE IF EXISTS `luckuser`;
CREATE TABLE `luckuser`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sing` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of luckuser
-- ----------------------------
INSERT INTO `luckuser` VALUES (15, 'null', 1);
INSERT INTO `luckuser` VALUES (16, '明明', 1);
INSERT INTO `luckuser` VALUES (17, 'sadsad', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuid` int(0) NOT NULL AUTO_INCREMENT,
  `menutitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `menudate` date NOT NULL,
  `menured` int(0) NOT NULL,
  `menucomment` int(0) NOT NULL,
  `titleid` int(0) NULL DEFAULT NULL,
  `info1` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `info2` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `rightto` int(0) NOT NULL,
  `detailstext` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`menuid`) USING BTREE,
  UNIQUE INDEX `menutitle`(`menutitle`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (17, 'Java GUI 开发', '2021-06-05', 8, 0, 17, 'gui', 'java', 0, '<p style=\"text-indent: 2em;\">Java Swing开发教程：<a href=\"http://c.biancheng.net/view/1206.html\">http://c.biancheng.net/view/1206.html</a>&nbsp; 该网站还有其他编程语言教程</p><p style=\"text-indent: 2em;\">&nbsp;</p><p style=\"text-indent: 2em;\">本篇使用工具：IntelliJ IDEA + maven</p><p style=\"text-indent: 2em;\">1、IntelliJ IDEA安装</p><p style=\"text-indent: 2em;\">参考网址：<a id=\"cb_post_title_url\" class=\"postTitle2 vertical-middle\" href=\"https://www.cnblogs.com/leton/p/12037696.html\">IntelliJ IDEA 2019.3.1安装激活破解使用教程</a></p><p style=\"text-indent: 2em;\">激活：<a href=\"http://medeming.com/\">http://medeming.com/</a></p><p style=\"text-indent: 2em;\">2、Java GUI开发</p><p style=\"text-indent: 2em;\">Gradle项目</p><p style=\"text-indent: 2em;\">Java GUI入门：<a href=\"https://www.jianshu.com/p/cdca9a30b86b\">https://www.jianshu.com/p/cdca9a30b86b</a>&nbsp; &nbsp; gradle项目编译出错解决方法：<a href=\"http://www.mamicode.com/info-detail-3040677.html\">http://www.mamicode.com/info-detail-3040677.html</a></p><p style=\"text-indent: 2em;\">较全面：<a id=\"cb_post_title_url\" class=\"postTitle2 vertical-middle\" href=\"https://www.cnblogs.com/danhuai/p/12275178.html\">【Java】+GUI+swing可视化界面开发</a>&nbsp; 含jar包制作成安装包（jar→exe使用工具：exe4j，exe→安装包使用工具：HofoSetup）</p><p><br/></p>');
INSERT INTO `menu` VALUES (19, 'C语言判断素数（求素数）方法上', '2021-06-05', 32, 3, 19, 'C语言', '素数', 0, '<pre class=\"snippet-textonly sh_sourceCode\" style=\"\"><p style=\"text-indent: 2em;\"><span style=\"font-size: 18px;\"> #include &lt;stdio.h&gt;<br/> &nbsp; &nbsp;#include &lt;math.h&gt;<br/> &nbsp; &nbsp;void main(){<br/> &nbsp; &nbsp;int m; &nbsp;// 输入的整数 <br/> &nbsp; &nbsp;int i; &nbsp;// 循环次数<br/> &nbsp; &nbsp;int k; &nbsp;// m 的平方根 <br/><br/> &nbsp; &nbsp;printf(&quot;输入一个整数：&quot;);<br/> &nbsp; &nbsp;scanf(&quot;%d&quot;,&amp;m);<br/><br/> &nbsp; &nbsp;// 求平方根，注意sqrt()的参数为 double 类型，这里要强制转换m的类型 <br/> &nbsp; &nbsp;k=(int)sqrt( (double)m );<br/> &nbsp; &nbsp;for(i=2;i&lt;=k;i++)<br/> &nbsp; &nbsp; &nbsp; &nbsp;if(m%i==0)<br/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;break;<br/><br/> &nbsp; &nbsp;// 如果完成所有循环，那么m为素数<br/> &nbsp; &nbsp;// 注意最后一次循环，会执行i++，此时 i=k+1，所以有i&gt;k <br/> &nbsp; &nbsp;if(i&gt;k)<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d是素数。\\n&quot;,m);<br/> &nbsp; &nbsp;else<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d不是素数。\\n&quot;,m);<br/><br/> &nbsp; &nbsp;return 0;<br/>}</span><br/></p></pre><p><br/><br/></p><p><span style=\"font-size: 18px;\"></span><br/></p>');
INSERT INTO `menu` VALUES (20, 'C语言判断素数（求素数）方法下', '2021-06-05', 1, 0, 20, 'C语言', '素数', 0, '<pre class=\"snippet-textonly sh_sourceCode\" style=\"display: block;\"><p style=\"text-indent: 2em;\"><span style=\"font-size: 18px;\">#include &lt;stdio.h&gt;<br/><br/> &nbsp; &nbsp;int main(){<br/> &nbsp; &nbsp;int a=0; &nbsp;// 素数的个数<br/> &nbsp; &nbsp;int num=0; &nbsp;// 输入的整数<br/><br/> &nbsp; &nbsp;printf(&quot;输入一个整数：&quot;);<br/> &nbsp; &nbsp;scanf(&quot;%d&quot;,&amp;num);<br/><br/> &nbsp; &nbsp;for(int i=2;i&lt;num;i++){<br/> &nbsp; &nbsp; &nbsp; &nbsp;if(num%i==0){<br/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;a++; &nbsp;// 素数个数加1<br/> &nbsp; &nbsp; &nbsp; &nbsp;}<br/> &nbsp; &nbsp;}<br/><br/> &nbsp; &nbsp;if(a==0){<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d是素数。\\n&quot;, num);<br/> &nbsp; &nbsp;}else{<br/> &nbsp; &nbsp; &nbsp; &nbsp;printf(&quot;%d不是素数。\\n&quot;, num);<br/> &nbsp; &nbsp;}<br/><br/> &nbsp; &nbsp;return 0;<br/>}<br/></span></p></pre><p><br/></p>');
INSERT INTO `menu` VALUES (21, 'jQuery简介', '2021-06-05', 0, 0, 21, 'jquery', '简单学习网页', 0, '<h3><strong>1. JavaScript库的概念</strong></h3><p>JavaScript开发的过程中，处理浏览器的兼容很复杂而且很耗时，于是一些封装了这些操作的库应运而生。这些库还会把一些常用的代码进行封装。</p><p>把一些常用到的方法写到一个单独的js文件，使用的时候直接去引用这js文件就可以了。（animate.js、common.js）</p><p>常见的JavaScript 库 - jQuery、Prototype、MooTools。其中jQuery是最常用的一个</p><p>jQuery其实就是一个js文件，里面封装了一大堆的方法方便我们的开发，其实就是一个加强版的common.js，因此我们学习jQuery，其实就是学习jQuery这个js文件中封装的一大堆方法。</p><h3><strong>2. jQuery的优点好处</strong></h3><p>jQuery设计的宗旨是&#39;Write Less，Do More&#39;，即倡导写更少的代码，做更多的事情。它封装JavaScript常用的功能代码，提供一种简便的操作，优化HTML文档操作、事件处理、动画设计和Ajax交互。</p><p>jQuery的核心特性可以总结为：具有独特的链式语法和短小清晰的多功能接口；具有高效灵活的css选择器，并且可对CSS选择器进行扩展；拥有便捷的插件扩展机制和丰富的插件。jQuery兼容各种主流浏览器。</p><p>极大地简化了 JavaScript 编程。</p><p><strong>3. jQuery的版本</strong></p><p>jQuery版本有很多，分为1.x 2.x 3.x</p><p>1.x版本：能够兼容IE678浏览器</p><p>2.x版本：不兼容IE678浏览器</p><p>1.x和2.x版本jquery都不再更新版本了，现在只更新3.x版本。</p><p>3.x版本：不兼容IE678，更加的精简（在国内不流行，因为国内使用jQuery的主要目的就是兼容IE678）</p><p>国内多数网站还在使用1.x的版本</p><p><br/></p>');
INSERT INTO `menu` VALUES (24, 'it行业', '2021-06-05', 15, 2, 24, 'it前景', '找工作', 1, '<p>程序员最好可以做到世界首富，看看众多大企业的老板，特别是科技类的大部分都是做程序员出身的。</p><p><br/></p><p><strong>不过也要清楚几个问题，因为程序员不是人人都适合的。</strong></p><p><strong><br/></strong></p><p>1.自己适合做什么</p><p>2.自己能做什么</p><p>3.自己想做什么</p><p><br/></p><p><strong>同时学习程序开发也需要一定的基础知识：</strong>当然这些都是可以通过后天学习培养的！</p><p><br/></p><p>java基础：基本语法，各种容器的使用（map，list，队列，栈），面向对象（和js的原型还是差别蛮大的），多线程</p><p><br/></p><p>java web：servlet，spring框架,spring mvc（或是structs），hibernate（或是mybatis）</p><p><br/></p><p>数据库：选择一个数据库（用的比较多的是mysql），学习sql，基本维护（备份还原数据库），索引使</p><p><br/></p><p>用容器使用：tomcat或是jetty，jboss（看公司用啥）</p><p><br/></p><p><strong>做程序员的一些小经验</strong></p><p><strong><br/></strong></p><p>谨慎说&quot;是&quot;</p><p><br/></p><p>没有搞清楚开发需求、任务工作量、团队期望值之前，有前途的程序员不会轻易答应。特别是对于新人来说，比较急于表现自己，对于同事或者老板的工作安排来者不拒，精神可嘉，方法不可取。承诺太多，会出现自己无法按时完成的情况，即使按时完成，也可能没有达到别人的期望值，长期以往别人对你的失望会越来越多。</p><p>敢说“不”</p><p><br/></p><p>看起来和第一条雷同，其实细究起来不一样。第二条执行起来比第一条难得多。当遇到明显不合理的要求时，可以考虑拒绝，前提是准备好了全面充分的理由。不要经常说不，但是一旦说了，就要切中要害。有前途的程序员不会闷头干活，知道自己的定位和团队期望，分清楚哪些是不合理的要求，哪些是合理的要求，然后把明显不合理的要求和领导沟通下，取得支持。</p><p><br/></p><p><br/></p>');
INSERT INTO `menu` VALUES (25, '人际关系处理', '2021-06-05', 8, 0, 25, '社交', '性格锻炼', 1, '<p style=\"line-height: 2em;\">人际交往是人类社会中不可缺少的组成部分，人的许多需要都是在人际交往中得到满足的。如果人际关系不顺利，就意味着心理需要被剥夺，或满足需要的愿望受挫折，因而会产生孤立无援或被社会抛弃的感觉；反之则会因有良好的人际关系而得到心理上的满足。您所提出的问题，正是因人际关系没处理好而造成的心理问题。要想成功地建立良好的人际关系，就要在社会生活中了解、遵循和掌握以下所述的人际交往的一般原则：\n　　（1）平等原则。在人际交往中总要有一定的付出或投入，交往的两个方面的需要和这种需要的满足程度必须是平等的，平等是建立人际关系的前提。人际交往作为人们之间的心理沟通，是主动的、相互的、有来有往的。人都有友爱和受人尊敬的需要，都希望得到别人的平等对待、人的这种需要，就是平等的需要。\n　　（2）相容原则。相容是指人际交往中的心理相容，即指人与人之间的融洽关系，与人相处时的容纳、包涵、宽容及忍让。要做到心理相容，应注意增加交往频率；寻找共同点；谦虚和宽容。为人处世要心胸开阔，宽以待人。要体谅他人，遇事多为别人着想，即使别人犯了错误，或冒犯了自己，也不要斤斤计较，以免因小失大，伤害相互之间的感情。只要干事业、团结有力，做出一些让步是值得的。\n　　（3）互利原则。建立良好的人际关系离不开互助互利。可表现为人际关系的相互依存，通过对物质、能量、精神、感情的交换而使各自的需要得到满足。\n　　（4）信用原则。信用即指一个人诚实、不欺骗、遵守诺言，从而取得他人的信任。人离不开交往，交往离不开信用。要做到说话算数，不轻许诺言．与人交往时要热情友好，以诚相待，不卑不亢，端庄而不过于矜持，谦逊而不矫饰作伪，要充分显示自己的自信心。一个有自信心的人，才可能\n \n取得别人的信赖．处事果断、富有主见、精神饱满、充满自信的人就容易激发别人的交往动机。博取别人的信任，产生使人乐于与你交往的魅力。上述这些人际交往的基本原则，是处理人际关系不可分割的几个方面。运用和掌握这些原则，是处理好人际关系的基本条件。</p>');
INSERT INTO `menu` VALUES (26, '围城里的道理', '2021-06-05', 12, 3, 26, '钱钟书', '围城', 0, '<p style=\"line-height: 1.75em;\">1.想要深入了解一个人，不妨一起去旅行！<br/>“像咱们这种旅行，最试验得出一个人的品性。旅行是最劳顿，最麻烦，叫人本相毕现时候。经过长期苦旅行而彼此不讨厌的人，才可以结交作朋友。”<br/>“结婚以后的蜜月旅行是次序颠倒的。应该先同旅行一个月，一个月舟车仆仆以后，双方还没有彼此看破，彼此要厌恶，还没有吵嘴翻脸，还要维持原来的婚约，这种夫妇保证不会离婚。”<br/>这是他几十年前写的！这些观点在现在也是十分受用<br/><br/>2.不要对一些约定、承诺深信不疑！<br/>“话是空的，人是活的；不是人照着话做，是话跟着人变。假如说了一句话，就至死不变的照做，世界上没有解约，反悔，道歉，离婚许多事了。”<br/>“譬如我跟某人同意一件事，甚而至于跟他定个契约，不管这契约上写的是十年，二十年，我订约的动机总根据着我目前的希望认识以及需要。不过‘目前’是最靠不住的，假使这个‘目前’已经落在背后了，条约上写明‘直到世界末日’都没有用，我们随时可以反悔。”<br/>“我们在社会上，一切说话全像戏院子里的入场券，一边一直‘过期作废’，可是那一边并不注明什么日期，随我们的便可以提早或延迟。”<br/>这些深刻透彻的解释，让我们明白这些承诺或是约定，都是会跟着承诺者产生变化的。<br/><br/>3.辩证的去对待身边的事情<br/>“ 天下只有两种。譬如一串葡萄到手，一种人挑最好吃的先吃，另一种人把最好的，留在最后吃。照例第一种人应该乐观，因为他每吃一颗都是吃剩的葡萄里最好的；第二种人应该悲观，因为他每吃一颗都是葡萄里最坏的。”<br/>“不过事实上适得其反，缘故是第二种人还有希望，第一种人只有回忆。”<br/>其实两种看法都正确，第一种人可以有积极的想法，因为每吃一颗都是好的；当然也可能消极的想，好葡萄越来越少。这都不是绝对的！<br/><br/>其实身边大大小小的事，都没有完全的好事，或完全的坏事！<br/><br/>4.我们一直身处在围城里<br/><br/>其实不只是婚姻、工作，大多数的事情都是围在城里的人想逃出来，城外的人想冲进去！</p>');
INSERT INTO `menu` VALUES (27, '城南旧事', '2021-06-05', 77, 5, 27, '城南旧事', '林海音', 0, '<p style=\"line-height: 2em;\">写作背景：</p><p style=\"line-height: 2em;\">《城南旧事》是林海音以其7岁到13岁的生活为背景创作的。在台湾被日本帝国主义侵占期间，林海音一家不甘在日寇铁蹄下生活，举家迁居北京，小英子即在北京长大。看见冬阳下的骆驼队走过来，听见缓慢悦耳的铃声，童年重临于作者心头。</p><p style=\"line-height: 2em;\">夏天过去，秋天过去，冬天又来了，骆驼队又来了，但是童年一去不还。作者因想念童年住在北京城南时的那些景色和人物，于是把它们写了下来，让实际的童年过去，心灵的童年永存下来。这是林海音写这本小说的初衷。</p><p><br/></p>');

-- ----------------------------
-- Table structure for replecomments
-- ----------------------------
DROP TABLE IF EXISTS `replecomments`;
CREATE TABLE `replecomments`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `commentid` int(0) NULL DEFAULT NULL,
  `repleid` int(0) NULL DEFAULT NULL,
  `repleType` int(0) NULL DEFAULT NULL,
  `repletitle` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `repletext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `fromusid` int(0) NULL DEFAULT NULL,
  `touid` int(0) NULL DEFAULT NULL,
  `repledate` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replecomments
-- ----------------------------

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song`  (
  `id` int(0) NOT NULL,
  `songurl` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `ofNumber` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES (0, 'https:\\www.baidu.com', 55);

-- ----------------------------
-- Table structure for topiccomments
-- ----------------------------
DROP TABLE IF EXISTS `topiccomments`;
CREATE TABLE `topiccomments`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `topicid` int(0) NOT NULL,
  `topictitle` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topictext` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `topicdate` date NOT NULL,
  `topicred` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topiccomments
-- ----------------------------
INSERT INTO `topiccomments` VALUES (1, 1, 'C语言判断素数（求素数）方法上', '这个方法简单', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (2, 1, 'it行业', '这个问题也是我最关心的，我觉得至少我未来选择职业的标准是\n1 这个职业要有发展空间。\n2 这个职业的薪资待遇要说的过去 3 就是不枯燥有趣味性。', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (3, 1, 'it行业', '年轻的时候，还是要学IT比较比较好，有钱途。我当时薪资很低，就是学UI好点 ', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (4, 1, 'C语言判断素数（求素数）方法上', '我去试试看', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (5, 2, 'C语言判断素数（求素数）方法上', '大佬 可以发下用递归怎么做这道题', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (6, 2, '围城里的道理', '以前看过围城，感触非常深', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (7, 2, '围城里的道理', '尤其是这一句： 婚姻就像一座围城，城里的人想逃出去，城外的人想冲进来。', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (8, 2, '城南旧事', '蛮好的书', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (9, 1, '城南旧事', '看完电影的我哭泣了', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (10, 1, '城南旧事', '感动', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (11, 1, '城南旧事', '为啥要推荐书了', '2021-06-05', 0);
INSERT INTO `topiccomments` VALUES (12, 5, '城南旧事', '还是感动', '2021-06-08', 0);
INSERT INTO `topiccomments` VALUES (13, 5, '围城里的道理', '爱好', '2021-06-09', 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `uemile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `upower` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE,
  UNIQUE INDEX `uemile`(`uemile`) USING BTREE,
  UNIQUE INDEX `nickname`(`nickname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (2, 'XIAO', '123456', '2829946723@qq.com', '普通', '程序小酱');
INSERT INTO `users` VALUES (3, '奥术大师', 'dasdsdf', '阿斯顿撒', '普通', 'ass');
INSERT INTO `users` VALUES (4, 'lso', '123456', '2557878393@qq.com', '普通', '潘潘');
INSERT INTO `users` VALUES (5, 'mmm', '55555', '2029518064@qq.com', '普通', '明明');
INSERT INTO `users` VALUES (7, 'sadsad', '123456', '1727493926@qq.com', '普通', 'sadsad');

SET FOREIGN_KEY_CHECKS = 1;
