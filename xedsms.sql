/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : xedsms

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2012-06-21 14:19:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL COMMENT 'id',
  `city_name` varchar(16) NOT NULL COMMENT '城市名',
  `city_zcode` char(6) NOT NULL COMMENT '邮编',
  `city_pcode` varchar(6) NOT NULL COMMENT '电话区号',
  `prov_id` int(11) NOT NULL COMMENT '省id',
  `city_py` varchar(32) NOT NULL COMMENT '省名拼音',
  `city_zm` varchar(8) NOT NULL COMMENT '省名字母',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京市', '100000', '010', '1', 'Beijing Shi', 'BJS');
INSERT INTO `city` VALUES ('2', '天津市', '300000', '022', '2', 'Tianjin Shi', 'TJS');
INSERT INTO `city` VALUES ('3', '石家庄市', '050000', '0311', '3', 'Shijiazhuang Shi', 'SJWS');
INSERT INTO `city` VALUES ('4', '唐山市', '063000', '0315', '3', 'Tangshan Shi', 'TGS');
INSERT INTO `city` VALUES ('5', '秦皇岛市', '066000', '0335', '3', 'Qinhuangdao Shi', 'QHDS');
INSERT INTO `city` VALUES ('6', '邯郸市', '056000', '0310', '3', 'Handan Shi', 'HDS');
INSERT INTO `city` VALUES ('7', '邢台市', '054000', '0319', '3', 'Xingtai Shi', 'XTS');
INSERT INTO `city` VALUES ('8', '保定市', '071000', '0312', '3', 'Baoding Shi', 'BDS');
INSERT INTO `city` VALUES ('9', '张家口市', '075000', '0313', '3', 'Zhangjiakou Shi ', 'ZJKS');
INSERT INTO `city` VALUES ('10', '承德市', '067000', '0314', '3', 'Chengde Shi', 'CDS');
INSERT INTO `city` VALUES ('11', '沧州市', '061000', '0317', '3', 'Cangzhou Shi', 'CZS');
INSERT INTO `city` VALUES ('12', '廊坊市', '065000', '0316', '3', 'Langfang Shi', 'LFS');
INSERT INTO `city` VALUES ('13', '衡水市', '053000', '0318', '3', 'Hengshui Shi ', 'HSS');
INSERT INTO `city` VALUES ('14', '太原市', '030000', '0351', '4', 'Taiyuan Shi', 'TYS');
INSERT INTO `city` VALUES ('15', '大同市', '037000', '0352', '4', 'Datong Shi ', 'DTS');
INSERT INTO `city` VALUES ('16', '阳泉市', '045000', '0353', '4', 'Yangquan Shi', 'YQS');
INSERT INTO `city` VALUES ('17', '长治市', '046000', '0355', '4', 'Changzhi Shi', 'CZS');
INSERT INTO `city` VALUES ('18', '晋城市', '048000', '0356', '4', 'Jincheng Shi ', 'JCG');
INSERT INTO `city` VALUES ('19', '朔州市', '036000', '0349', '4', 'Shuozhou Shi ', 'SZJ');
INSERT INTO `city` VALUES ('20', '晋中市', '030600', '0354', '4', 'Jinzhong Shi', 'JZS');
INSERT INTO `city` VALUES ('21', '运城市', '044000', '0359', '4', 'Yuncheng Shi', 'YZE');
INSERT INTO `city` VALUES ('22', '忻州市', '034000', '0350', '4', 'Xinzhou Shi', 'XZS');
INSERT INTO `city` VALUES ('23', '临汾市', '041000', '0357', '4', 'Linfen Shi', 'LFN');
INSERT INTO `city` VALUES ('24', '吕梁市', '033000', '0358', '4', 'Lvliang Shi', 'LLS');
INSERT INTO `city` VALUES ('25', '呼和浩特市', '010000', '0471', '5', 'Hohehaote Shi', 'HhhtS');
INSERT INTO `city` VALUES ('26', '包头市', '014000', '0472', '5', 'Baotou Shi ', 'BTS');
INSERT INTO `city` VALUES ('27', '乌海市', '016000', '0473', '5', 'Wuhai Shi ', 'WHS');
INSERT INTO `city` VALUES ('28', '赤峰市', '024000', '0476', '5', 'Chifeng Shi', 'CFS');
INSERT INTO `city` VALUES ('29', '通辽市', '028000', '0475', '5', 'Tongliao Shi', 'TLO');
INSERT INTO `city` VALUES ('30', '鄂尔多斯市', '014300', '0477', '5', 'Eerduosi Shi', 'EEDSS');
INSERT INTO `city` VALUES ('31', '呼伦贝尔市', '010000', '0471', '5', 'Hulunbeier Shi', 'HLBES');
INSERT INTO `city` VALUES ('32', '巴彦淖尔市', '015000', '0478', '5', 'Bayannaoer shi', 'BYNES');
INSERT INTO `city` VALUES ('33', '乌兰察布市', '011800', '0474', '5', 'Wulanchabu Shi', 'WLCBS');
INSERT INTO `city` VALUES ('34', '兴安盟', '029400', '0482', '5', 'Xingan Meng', 'XAM');
INSERT INTO `city` VALUES ('35', '锡林郭勒盟', '026000', '0479', '5', 'Xilingol Meng', 'XLGLM');
INSERT INTO `city` VALUES ('36', '阿拉善盟', '735400', '0483', '5', 'Alashan Meng', 'ALSM');
INSERT INTO `city` VALUES ('37', '沈阳市', '110000', '024', '6', 'Shenyang Shi', 'SYS');
INSERT INTO `city` VALUES ('38', '大连市', '116000', '0411', '6', 'Dalian Shi', 'DLS');
INSERT INTO `city` VALUES ('39', '鞍山市', '114000', '0412', '6', 'AnShan Shi', 'ASS');
INSERT INTO `city` VALUES ('40', '抚顺市', '113000', '0413', '6', 'Fushun Shi', 'FSS');
INSERT INTO `city` VALUES ('41', '本溪市', '117000', '0414', '6', 'Benxi Shi', 'BXS');
INSERT INTO `city` VALUES ('42', '丹东市', '118000', '0415', '6', 'Dandong Shi', 'DDS');
INSERT INTO `city` VALUES ('43', '锦州市', '121000', '0416', '6', 'Jinzhou Shi', 'JZS');
INSERT INTO `city` VALUES ('44', '营口市', '115000', '0417', '6', 'Yingkou Shi', 'YKS');
INSERT INTO `city` VALUES ('45', '阜新市', '123000', '0418', '6', 'Fuxin Shi', 'FXS');
INSERT INTO `city` VALUES ('46', '辽阳市', '111000', '0419', '6', 'Liaoyang Shi', 'LYS');
INSERT INTO `city` VALUES ('47', '盘锦市', '124000', '0427', '6', 'Panjin Shi', 'PJS');
INSERT INTO `city` VALUES ('48', '铁岭市', '112000', '0410', '6', 'Tieling Shi', 'TLS');
INSERT INTO `city` VALUES ('49', '朝阳市', '122000', '0421', '6', 'Chaoyang Shi', 'CYS');
INSERT INTO `city` VALUES ('50', '葫芦岛市', '125000', '0429', '6', 'Huludao Shi', 'HLDS');
INSERT INTO `city` VALUES ('51', '长春市', '130000', '0431', '7', 'Changchun Shi ', 'CCS');
INSERT INTO `city` VALUES ('52', '吉林市', '132000', '0432', '7', 'Jilin Shi ', 'JLS');
INSERT INTO `city` VALUES ('53', '四平市', '136000', '0434', '7', 'Siping Shi', 'SPS');
INSERT INTO `city` VALUES ('54', '辽源市', '136200', '0437', '7', 'Liaoyuan Shi', 'LYS');
INSERT INTO `city` VALUES ('55', '通化市', '134000', '0435', '7', 'Tonghua Shi', 'THS');
INSERT INTO `city` VALUES ('56', '白山市', '134300', '0439', '7', 'Baishan Shi', 'BSN');
INSERT INTO `city` VALUES ('57', '松原市', '138000', '0438', '7', 'Songyuan Shi', 'SYS');
INSERT INTO `city` VALUES ('58', '白城市', '137000', '0436', '7', 'Baicheng Shi', 'BCS');
INSERT INTO `city` VALUES ('59', '延边朝鲜族自治州', '133000', '0433', '7', 'YanbianChaoxianzu Zizhizhou', 'YBZXZZZZ');
INSERT INTO `city` VALUES ('60', '哈尔滨市', '150000', '0451', '8', 'Haerbin Shi', 'HRBS');
INSERT INTO `city` VALUES ('61', '齐齐哈尔市', '161000', '0452', '8', 'Qiqihar Shi', 'NDG');
INSERT INTO `city` VALUES ('62', '鸡西市', '158100', '0467', '8', 'Jixi Shi', 'JXI');
INSERT INTO `city` VALUES ('63', '鹤岗市', '154100', '0468', '8', 'Hegang Shi', 'HEG');
INSERT INTO `city` VALUES ('64', '双鸭山市', '155100', '0469', '8', 'Shuangyashan Shi', 'SYS');
INSERT INTO `city` VALUES ('65', '大庆市', '163000', '0459', '8', 'Daqing Shi', 'DQG');
INSERT INTO `city` VALUES ('66', '伊春市', '153000', '0458', '8', 'Yichun Shi', 'YCH');
INSERT INTO `city` VALUES ('67', '佳木斯市', '154000', '0454', '8', 'Jiamusi Shi', 'JMU');
INSERT INTO `city` VALUES ('68', '七台河市', '154600', '0464', '8', 'Qitaihe Shi', 'QTH');
INSERT INTO `city` VALUES ('69', '牡丹江市', '157000', '0453', '8', 'Mudanjiang Shi', 'MDG');
INSERT INTO `city` VALUES ('70', '黑河市', '164300', '0456', '8', 'Heihe Shi', 'HEK');
INSERT INTO `city` VALUES ('71', '绥化市', '152000', '0455', '8', 'Suihua Shi', 'SUH');
INSERT INTO `city` VALUES ('72', '大兴安岭地区', '165000', '0457', '8', 'Da Hinggan Ling Diqu', 'DHL');
INSERT INTO `city` VALUES ('73', '上海市', '200000', '021', '9', 'Shanghai Shi', 'SH');
INSERT INTO `city` VALUES ('74', '南京市', '210000', '025', '10', 'Nanjing Shi', 'NKG');
INSERT INTO `city` VALUES ('75', '无锡市', '214000', '0510', '10', 'Wuxi Shi', 'WUX');
INSERT INTO `city` VALUES ('76', '徐州市', '221000', '0516', '10', 'Xuzhou Shi', 'XUZ');
INSERT INTO `city` VALUES ('77', '常州市', '213000', '0519', '10', 'Changzhou Shi', 'CZX');
INSERT INTO `city` VALUES ('78', '苏州市', '215000', '0512', '10', 'Suzhou Shi', 'SZH');
INSERT INTO `city` VALUES ('79', '南通市', '226000', '0513', '10', 'Nantong Shi', 'NTG');
INSERT INTO `city` VALUES ('80', '连云港市', '222000', '0518', '10', 'Lianyungang Shi', 'LYG');
INSERT INTO `city` VALUES ('81', '淮安市', '223001', '0517', '10', 'Huai,an Xian', 'HAS');
INSERT INTO `city` VALUES ('82', '盐城市', '224000', '0515', '10', 'Yancheng Shi', 'YCK');
INSERT INTO `city` VALUES ('83', '扬州市', '225000', '0514', '10', 'Yangzhou Shi', 'YZH');
INSERT INTO `city` VALUES ('84', '镇江市', '212000', '0511', '10', 'Zhenjiang Shi', 'ZHE');
INSERT INTO `city` VALUES ('85', '泰州市', '225300', '0523', '10', 'Taizhou Shi', 'TZS');
INSERT INTO `city` VALUES ('86', '宿迁市', '223800', '0527', '10', 'Suqian Shi', 'SUQ');
INSERT INTO `city` VALUES ('87', '杭州市', '310000', '0571', '11', 'Hangzhou Shi', 'HGH');
INSERT INTO `city` VALUES ('88', '宁波市', '315000', '0574', '11', 'Ningbo Shi', 'NGB');
INSERT INTO `city` VALUES ('89', '温州市', '325000', '0577', '11', 'Wenzhou Shi', 'WNZ');
INSERT INTO `city` VALUES ('90', '嘉兴市', '314000', '0573', '11', 'Jiaxing Shi', 'JIX');
INSERT INTO `city` VALUES ('91', '湖州市', '313000', '0572', '11', 'Huzhou Shi ', 'HZH');
INSERT INTO `city` VALUES ('92', '绍兴市', '312000', '0575', '11', 'Shaoxing Shi', 'SXG');
INSERT INTO `city` VALUES ('93', '金华市', '321000', '0579', '11', 'Jinhua Shi', 'JHA');
INSERT INTO `city` VALUES ('94', '衢州市', '324000', '0570', '11', 'Quzhou Shi', 'QUZ');
INSERT INTO `city` VALUES ('95', '舟山市', '316000', '0580', '11', 'Zhoushan Shi', 'ZOS');
INSERT INTO `city` VALUES ('96', '台州市', '318000', '0576', '11', 'Taizhou Shi', 'TZZ');
INSERT INTO `city` VALUES ('97', '丽水市', '323000', '0578', '11', 'Lishui Shi', 'LSS');
INSERT INTO `city` VALUES ('98', '合肥市', '230000', '0551', '12', 'Hefei Shi', 'HFE');
INSERT INTO `city` VALUES ('99', '芜湖市', '241000', '0553', '12', 'Wuhu Shi', 'WHI');
INSERT INTO `city` VALUES ('100', '蚌埠市', '233000', '0552', '12', 'Bengbu Shi', 'BBU');
INSERT INTO `city` VALUES ('101', '淮南市', '232000', '0554', '12', 'Huainan Shi', 'HNS');
INSERT INTO `city` VALUES ('102', '马鞍山市', '243000', '0555', '12', 'Ma,anshan Shi', 'MAA');
INSERT INTO `city` VALUES ('103', '淮北市', '235000', '0561', '12', 'Huaibei Shi', 'HBE');
INSERT INTO `city` VALUES ('104', '铜陵市', '244000', '0562', '12', 'Tongling Shi', 'TOL');
INSERT INTO `city` VALUES ('105', '安庆市', '246000', '0556', '12', 'Anqing Shi', 'AQG');
INSERT INTO `city` VALUES ('106', '黄山市', '242700', '0559', '12', 'Huangshan Shi', 'HSN');
INSERT INTO `city` VALUES ('107', '滁州市', '239000', '0550', '12', 'Chuzhou Shi', 'CUZ');
INSERT INTO `city` VALUES ('108', '阜阳市', '236000', '0558', '12', 'Fuyang Shi', 'FYS');
INSERT INTO `city` VALUES ('109', '宿州市', '234000', '0557', '12', 'Suzhou Shi', 'SUZ');
INSERT INTO `city` VALUES ('110', '巢湖市', '238000', '0565', '12', 'Chaohu Shi', 'CAH');
INSERT INTO `city` VALUES ('111', '六安市', '237000', '0564', '12', 'Liu,an Shi', 'LAW');
INSERT INTO `city` VALUES ('112', '亳州市', '236000', '0558', '12', 'Bozhou Shi', 'BOZ');
INSERT INTO `city` VALUES ('113', '池州市', '247100', '0566', '12', '', '');
INSERT INTO `city` VALUES ('114', '宣城市', '242000', '0563', '12', '', '');
INSERT INTO `city` VALUES ('115', '福州市', '350000', '0591', '13', 'Fuzhou Shi', 'FOC');
INSERT INTO `city` VALUES ('116', '厦门市', '361000', '0592', '13', 'Xiamen Shi', 'XMN');
INSERT INTO `city` VALUES ('117', '莆田市', '351100', '0594', '13', 'Putian Shi', 'PUT');
INSERT INTO `city` VALUES ('118', '三明市', '365000', '0598', '13', 'Sanming Shi', 'SMS');
INSERT INTO `city` VALUES ('119', '泉州市', '362000', '0595', '13', 'Quanzhou Shi', 'QZJ');
INSERT INTO `city` VALUES ('120', '漳州市', '363000', '0596', '13', 'Zhangzhou Shi', 'ZZU');
INSERT INTO `city` VALUES ('121', '南平市', '353000', '0599', '13', 'Nanping Shi', 'NPS');
INSERT INTO `city` VALUES ('122', '龙岩市', '364000', '0597', '13', 'Longyan Shi', 'LYF');
INSERT INTO `city` VALUES ('123', '宁德市', '352000', '0593', '13', 'Ningde Shi', 'NDS');
INSERT INTO `city` VALUES ('124', '南昌市', '330000', '0791', '14', 'Nanchang Shi', 'KHN');
INSERT INTO `city` VALUES ('125', '景德镇市', '333000', '0798', '14', 'Jingdezhen Shi', 'JDZ');
INSERT INTO `city` VALUES ('126', '萍乡市', '337000', '0799', '14', 'Pingxiang Shi', 'PXS');
INSERT INTO `city` VALUES ('127', '九江市', '332000', '0792', '14', 'Jiujiang Shi', 'JIU');
INSERT INTO `city` VALUES ('128', '新余市', '338000', '0790', '14', 'Xinyu Shi', 'XYU');
INSERT INTO `city` VALUES ('129', '鹰潭市', '335000', '0701', '14', 'Yingtan Shi', 'YTS');
INSERT INTO `city` VALUES ('130', '赣州市', '341000', '0797', '14', 'Ganzhou Shi', 'GZH');
INSERT INTO `city` VALUES ('131', '吉安市', '343000', '0796', '14', 'Ji,an Shi', 'JAS');
INSERT INTO `city` VALUES ('132', '宜春市', '336000', '0795', '14', 'Yichun Shi', 'YCN');
INSERT INTO `city` VALUES ('133', '抚州市', '344000', '0794', '14', '', '');
INSERT INTO `city` VALUES ('134', '上饶市', '334000', '0793', '14', 'Shangrao Shi', 'SRS');
INSERT INTO `city` VALUES ('135', '济南市', '250000', '0531', '15', 'Jinan Shi', 'TNA');
INSERT INTO `city` VALUES ('136', '青岛市', '266000', '0532', '15', 'Qingdao Shi', 'TAO');
INSERT INTO `city` VALUES ('137', '淄博市', '255000', '0533', '15', 'Zibo Shi', 'ZBO');
INSERT INTO `city` VALUES ('138', '枣庄市', '277000', '0632', '15', 'Zaozhuang Shi', 'ZZG');
INSERT INTO `city` VALUES ('139', '东营市', '257000', '0546', '15', 'Dongying Shi', 'DYG');
INSERT INTO `city` VALUES ('140', '烟台市', '264000', '0535', '15', 'Yantai Shi', 'YNT');
INSERT INTO `city` VALUES ('141', '潍坊市', '261000', '0536', '15', 'Weifang Shi', 'WEF');
INSERT INTO `city` VALUES ('142', '济宁市', '272000', '0537', '15', 'Jining Shi', 'JNG');
INSERT INTO `city` VALUES ('143', '泰安市', '271000', '0538', '15', 'Tai,an Shi', 'TAI');
INSERT INTO `city` VALUES ('144', '威海市', '264200', '0631', '15', 'Weihai Shi', 'WEH');
INSERT INTO `city` VALUES ('145', '日照市', '276800', '0633', '15', 'Rizhao Shi', 'RZH');
INSERT INTO `city` VALUES ('146', '莱芜市', '271100', '0634', '15', 'Laiwu Shi', 'LWS');
INSERT INTO `city` VALUES ('147', '临沂市', '276000', '0539', '15', 'Linyi Shi', 'LYI');
INSERT INTO `city` VALUES ('148', '德州市', '253000', '0534', '15', 'Dezhou Shi', 'DZS');
INSERT INTO `city` VALUES ('149', '聊城市', '252000', '0635', '15', 'Liaocheng Shi', 'LCH');
INSERT INTO `city` VALUES ('150', '滨州市', '256600', '0543', '15', 'Binzhou Shi', 'BZH');
INSERT INTO `city` VALUES ('151', '荷泽市', '274000', '0530', '15', '', '');
INSERT INTO `city` VALUES ('152', '郑州市', '450000', '0371', '16', 'Zhengzhou Shi', 'CGO');
INSERT INTO `city` VALUES ('153', '开封市', '475000', '0378', '16', 'Kaifeng Shi', 'KFS');
INSERT INTO `city` VALUES ('154', '洛阳市', '471000', '0379', '16', 'Luoyang Shi', 'LYA');
INSERT INTO `city` VALUES ('155', '平顶山市', '467000', '0375', '16', 'Pingdingshan Shi', 'PDS');
INSERT INTO `city` VALUES ('156', '安阳市', '455000', '0372', '16', 'Anyang Shi', 'AYS');
INSERT INTO `city` VALUES ('157', '鹤壁市', '458000', '0392', '16', 'Hebi Shi', 'HBS');
INSERT INTO `city` VALUES ('158', '新乡市', '453000', '0373', '16', 'Xinxiang Shi', 'XXS');
INSERT INTO `city` VALUES ('159', '焦作市', '454150', '0391', '16', 'Jiaozuo Shi', 'JZY');
INSERT INTO `city` VALUES ('160', '濮阳市', '457000', '0393', '16', 'Puyang Shi', 'PYS');
INSERT INTO `city` VALUES ('161', '许昌市', '461000', '0374', '16', 'Xuchang Shi', 'XCS');
INSERT INTO `city` VALUES ('162', '漯河市', '462000', '0395', '16', 'Luohe Shi', 'LHS');
INSERT INTO `city` VALUES ('163', '三门峡市', '472000', '0398', '16', 'Sanmenxia Shi', 'SMX');
INSERT INTO `city` VALUES ('164', '南阳市', '473000', '0377', '16', 'Nanyang Shi', 'NYS');
INSERT INTO `city` VALUES ('165', '商丘市', '476000', '0370', '16', 'Shangqiu Shi', 'SQS');
INSERT INTO `city` VALUES ('166', '信阳市', '464000', '0376', '16', 'Xinyang Shi', 'XYG');
INSERT INTO `city` VALUES ('167', '周口市', '466000', '0394', '16', 'Zhoukou Shi', 'ZKS');
INSERT INTO `city` VALUES ('168', '驻马店市', '463000', '0396', '16', 'Zhumadian Shi', 'ZMD');
INSERT INTO `city` VALUES ('169', '武汉市', '430000', '027', '17', 'Wuhan Shi', 'WUH');
INSERT INTO `city` VALUES ('170', '黄石市', '435000', '0714', '17', 'Huangshi Shi', 'HIS');
INSERT INTO `city` VALUES ('171', '十堰市', '442000', '0719', '17', 'Shiyan Shi', 'SYE');
INSERT INTO `city` VALUES ('172', '宜昌市', '443000', '0717', '17', 'Yichang Shi', 'YCO');
INSERT INTO `city` VALUES ('173', '襄樊市', '441000', '0710', '17', 'Xiangfan Shi', 'XFN');
INSERT INTO `city` VALUES ('174', '鄂州市', '436000', '0711', '17', 'Ezhou Shi', 'EZS');
INSERT INTO `city` VALUES ('175', '荆门市', '448000', '0724', '17', 'Jingmen Shi', 'JMS');
INSERT INTO `city` VALUES ('176', '孝感市', '432000', '0712', '17', 'Xiaogan Shi', 'XGE');
INSERT INTO `city` VALUES ('177', '荆州市', '434000', '0716', '17', 'Jingzhou Shi', 'JGZ');
INSERT INTO `city` VALUES ('178', '黄冈市', '438000', '0713', '17', 'Huanggang Shi', 'HE');
INSERT INTO `city` VALUES ('179', '咸宁市', '437000', '0715', '17', 'Xianning Xian', 'XNS');
INSERT INTO `city` VALUES ('180', '随州市', '441300', '0722', '17', 'Suizhou Shi', 'SZR');
INSERT INTO `city` VALUES ('181', '恩施土家族苗族自治州', '445000', '0718', '17', 'Enshi Tujiazu Miaozu Zizhizhou', 'ESH');
INSERT INTO `city` VALUES ('182', '神农架', '442400', '0719', '17', '', '');
INSERT INTO `city` VALUES ('183', '长沙市', '410000', '0731', '18', 'Changsha Shi', 'CSX');
INSERT INTO `city` VALUES ('184', '株洲市', '412000', '0733', '18', 'Zhuzhou Shi', 'ZZS');
INSERT INTO `city` VALUES ('185', '湘潭市', '411100', '0732', '18', 'Xiangtan Shi', 'XGT');
INSERT INTO `city` VALUES ('186', '衡阳市', '421000', '0734', '18', 'Hengyang Shi', 'HNY');
INSERT INTO `city` VALUES ('187', '邵阳市', '422000', '0739', '18', 'Shaoyang Shi', 'SYR');
INSERT INTO `city` VALUES ('188', '岳阳市', '414000', '0730', '18', 'Yueyang Shi', 'YYG');
INSERT INTO `city` VALUES ('189', '常德市', '415000', '0736', '18', 'Changde Shi', 'CDE');
INSERT INTO `city` VALUES ('190', '张家界市', '427000', '0744', '18', 'Zhangjiajie Shi', 'ZJJ');
INSERT INTO `city` VALUES ('191', '益阳市', '413000', '0737', '18', 'Yiyang Shi', 'YYS');
INSERT INTO `city` VALUES ('192', '郴州市', '423000', '0735', '18', 'Chenzhou Shi', 'CNZ');
INSERT INTO `city` VALUES ('193', '永州市', '425000', '0746', '18', 'Yongzhou Shi', 'YZS');
INSERT INTO `city` VALUES ('194', '怀化市', '418000', '0745', '18', 'Huaihua Shi', 'HHS');
INSERT INTO `city` VALUES ('195', '娄底市', '417000', '0738', '18', 'Loudi Shi', 'LDI');
INSERT INTO `city` VALUES ('196', '湘西土家族苗族自治州', '416000', '0743', '18', 'Xiangxi Tujiazu Miaozu Zizhizhou', 'XXZ');
INSERT INTO `city` VALUES ('197', '广州市', '510000', '020', '19', 'Guangzhou Shi', 'CAN');
INSERT INTO `city` VALUES ('198', '韶关市', '512000', '0751', '19', 'Shaoguan Shi', 'HSC');
INSERT INTO `city` VALUES ('199', '深圳市', '518000', '0755', '19', 'Shenzhen Shi', 'SZX');
INSERT INTO `city` VALUES ('200', '珠海市', '519000', '0756', '19', 'Zhuhai Shi', 'ZUH');
INSERT INTO `city` VALUES ('201', '汕头市', '515000', '0754', '19', 'Shantou Shi', 'SWA');
INSERT INTO `city` VALUES ('202', '佛山市', '528000', '0757', '19', 'Foshan Shi', 'FOS');
INSERT INTO `city` VALUES ('203', '江门市', '529000', '0750', '19', 'Jiangmen Shi', 'JMN');
INSERT INTO `city` VALUES ('204', '湛江市', '524000', '0759', '19', 'Zhanjiang Shi', 'ZHA');
INSERT INTO `city` VALUES ('205', '茂名市', '525000', '0668', '19', 'Maoming Shi', 'MMI');
INSERT INTO `city` VALUES ('206', '肇庆市', '526000', '0758', '19', 'Zhaoqing Shi', 'ZQG');
INSERT INTO `city` VALUES ('207', '惠州市', '516000', '0752', '19', 'Huizhou Shi', 'HUI');
INSERT INTO `city` VALUES ('208', '梅州市', '514000', '0753', '19', 'Meizhou Shi', 'MXZ');
INSERT INTO `city` VALUES ('209', '汕尾市', '516600', '0660', '19', 'Shanwei Shi', 'SWE');
INSERT INTO `city` VALUES ('210', '河源市', '517000', '0762', '19', 'Heyuan Shi', 'HEY');
INSERT INTO `city` VALUES ('211', '阳江市', '529500', '0662', '19', 'Yangjiang Shi', 'YJI');
INSERT INTO `city` VALUES ('212', '清远市', '511500', '0763', '19', 'Qingyuan Shi', 'QYN');
INSERT INTO `city` VALUES ('213', '东莞市', '523000', '0769', '19', 'Dongguan Shi', 'DGG');
INSERT INTO `city` VALUES ('214', '中山市', '528400', '0760', '19', 'Zhongshan Shi', 'ZSN');
INSERT INTO `city` VALUES ('215', '潮州市', '521000', '0768', '19', 'Chaozhou Shi', 'CZY');
INSERT INTO `city` VALUES ('216', '揭阳市', '522000', '0663', '19', 'Jieyang Shi', 'JIY');
INSERT INTO `city` VALUES ('217', '云浮市', '527300', '0766', '19', 'Yunfu Shi', 'YFS');
INSERT INTO `city` VALUES ('218', '南宁市', '530000', '0771', '20', 'Nanning Shi', 'NNG');
INSERT INTO `city` VALUES ('219', '柳州市', '545000', '0772', '20', 'Liuzhou Shi', 'LZH');
INSERT INTO `city` VALUES ('220', '桂林市', '541000', '0773', '20', 'Guilin Shi', 'KWL');
INSERT INTO `city` VALUES ('221', '梧州市', '543000', '0774', '20', 'Wuzhou Shi', 'WUZ');
INSERT INTO `city` VALUES ('222', '北海市', '536000', '0779', '20', 'Beihai Shi', 'BHY');
INSERT INTO `city` VALUES ('223', '防城港市', '538000', '0770', '20', 'Fangchenggang Shi', 'FAN');
INSERT INTO `city` VALUES ('224', '钦州市', '535000', '0777', '20', 'Qinzhou Shi', 'QZH');
INSERT INTO `city` VALUES ('225', '贵港市', '537000', '0775', '20', 'Guigang Shi', 'GUG');
INSERT INTO `city` VALUES ('226', '玉林市', '537000', '0775', '20', 'Yulin Shi', 'YUL');
INSERT INTO `city` VALUES ('227', '百色市', '533000', '0776', '20', 'Baise Shi', 'BSS');
INSERT INTO `city` VALUES ('228', '贺州市', '542800', '0774', '20', 'Hezhou Shi', 'HZB');
INSERT INTO `city` VALUES ('229', '河池市', '547000', '0778', '20', 'Hechi Shi', 'HCS');
INSERT INTO `city` VALUES ('230', '来宾市', '546100', '0772', '20', '', '');
INSERT INTO `city` VALUES ('231', '崇左市', '532200', '0771', '20', '', '');
INSERT INTO `city` VALUES ('232', '海口市', '570100', '0898', '21', 'Haikou Shi', 'HAK');
INSERT INTO `city` VALUES ('233', '三亚市', '572000', '0898', '21', 'Sanya Shi', 'SYX');
INSERT INTO `city` VALUES ('234', '重庆市', '404100', '023', '22', 'Chongqing Shi', 'CQ');
INSERT INTO `city` VALUES ('235', '成都市', '610000', '028', '23', 'Chengdu Shi', 'CTU');
INSERT INTO `city` VALUES ('236', '自贡市', '643000', '0813', '23', 'Zigong Shi', 'ZGS');
INSERT INTO `city` VALUES ('237', '攀枝花市', '617000', '0812', '23', 'Panzhihua Shi', 'PZH');
INSERT INTO `city` VALUES ('238', '泸州市', '646000', '0830', '23', 'Luzhou Shi', 'LUZ');
INSERT INTO `city` VALUES ('239', '德阳市', '618000', '0838', '23', 'Deyang Shi', 'DEY');
INSERT INTO `city` VALUES ('240', '绵阳市', '621000', '0816', '23', 'Mianyang Shi', 'MYG');
INSERT INTO `city` VALUES ('241', '广元市', '638500', '0826', '23', 'Guangyuan Shi', 'GYC');
INSERT INTO `city` VALUES ('242', '遂宁市', '629000', '0825', '23', 'Suining Shi', 'SNS');
INSERT INTO `city` VALUES ('243', '内江市', '641000', '0832', '23', 'Neijiang Shi', 'NJS');
INSERT INTO `city` VALUES ('244', '乐山市', '614000', '0833', '23', 'Leshan Shi', 'LES');
INSERT INTO `city` VALUES ('245', '南充市', '637000', '0817', '23', 'Nanchong Shi', 'NCO');
INSERT INTO `city` VALUES ('246', '眉山市', '620000', '0833', '23', '', '');
INSERT INTO `city` VALUES ('247', '宜宾市', '644000', '0831', '23', 'Yibin Shi', 'YBS');
INSERT INTO `city` VALUES ('248', '广安市', '638500', '0826', '23', 'Guang,an Shi', 'GAC');
INSERT INTO `city` VALUES ('249', '达州市', '635000', '0818', '23', '', '');
INSERT INTO `city` VALUES ('250', '雅安市', '625000', '0835', '23', 'Ya,an Shi', 'YAS');
INSERT INTO `city` VALUES ('251', '巴中市', '636600', '0827', '23', 'Bazhong Shi', 'BZS');
INSERT INTO `city` VALUES ('252', '资阳市', '641300', '0832', '23', 'Ziyang Shi', 'ZYS');
INSERT INTO `city` VALUES ('253', '阿坝藏族羌族自治州', '624000', '0837', '23', 'Aba(Ngawa) Zangzu Qiangzu Zizhiz', 'ABA');
INSERT INTO `city` VALUES ('254', '甘孜藏族自治州', '626000', '0836', '23', 'Garze Zangzu Zizhizhou', 'GAZ');
INSERT INTO `city` VALUES ('255', '凉山彝族自治州', '615000', '0834', '23', 'Liangshan Yizu Zizhizhou', 'LSY');
INSERT INTO `city` VALUES ('256', '贵阳市', '550000', '0851', '24', 'Guiyang Shi', 'KWE');
INSERT INTO `city` VALUES ('257', '六盘水市', '553000', '0858', '24', 'Liupanshui Shi', 'LPS');
INSERT INTO `city` VALUES ('258', '遵义市', '563000', '0852', '24', 'Zunyi Shi', 'ZNY');
INSERT INTO `city` VALUES ('259', '安顺市', '561000', '0853', '24', 'Anshun Xian', 'ASS');
INSERT INTO `city` VALUES ('260', '铜仁地区', '554300', '0856', '24', 'Tongren Diqu', 'TRD');
INSERT INTO `city` VALUES ('261', '黔西南布依族苗族自治州', '562400', '0859', '24', 'Qianxinan Buyeizu Zizhizhou', 'QXZ');
INSERT INTO `city` VALUES ('262', '毕节地区', '551700', '0857', '24', 'Bijie Diqu', 'BJD');
INSERT INTO `city` VALUES ('263', '黔东南苗族侗族自治州', '556000', '0855', '24', 'Qiandongnan Miaozu Dongzu Zizhiz', 'QND');
INSERT INTO `city` VALUES ('264', '黔南布依族苗族自治州', '558000', '0854', '24', 'Qiannan Buyeizu Miaozu Zizhizhou', 'QNZ');
INSERT INTO `city` VALUES ('265', '昆明市', '650000', '0871', '25', 'Kunming Shi', 'KMG');
INSERT INTO `city` VALUES ('266', '曲靖市', '655000', '0874', '25', 'Qujing Shi', 'QJS');
INSERT INTO `city` VALUES ('267', '玉溪市', '653100', '0877', '25', 'Yuxi Shi', 'YXS');
INSERT INTO `city` VALUES ('268', '保山市', '678000', '0875', '25', 'Baoshan Shi', 'BOS');
INSERT INTO `city` VALUES ('269', '昭通市', '657000', '0870', '25', 'Zhaotong Shi', 'ZTS');
INSERT INTO `city` VALUES ('270', '丽江市', '674100', '0888', '25', '', '');
INSERT INTO `city` VALUES ('271', '思茅市', '665000', '0879', '25', 'Simao Shi', 'SYM');
INSERT INTO `city` VALUES ('272', '临沧市', '677000', '0883', '25', '', '');
INSERT INTO `city` VALUES ('273', '楚雄彝族自治州', '675000', '0878', '25', 'Chuxiong Yizu Zizhizhou', 'CXD');
INSERT INTO `city` VALUES ('274', '红河哈尼族彝族自治州', '651400', '0873', '25', 'Honghe Hanizu Yizu Zizhizhou', 'HHZ');
INSERT INTO `city` VALUES ('275', '文山壮族苗族自治州', '663000', '0876', '25', 'Wenshan Zhuangzu Miaozu Zizhizho', 'WSZ');
INSERT INTO `city` VALUES ('276', '西双版纳傣族自治州', '666100', '0691', '25', 'Xishuangbanna Daizu Zizhizhou', 'XSB');
INSERT INTO `city` VALUES ('277', '大理白族自治州', '671000', '0872', '25', 'Dali Baizu Zizhizhou', 'DLZ');
INSERT INTO `city` VALUES ('278', '德宏傣族景颇族自治州', '678400', '0692', '25', 'Dehong Daizu Jingpozu Zizhizhou', 'DHG');
INSERT INTO `city` VALUES ('279', '怒江傈僳族自治州', '373100', '0886', '25', 'Nujiang Lisuzu Zizhizhou', 'NUJ');
INSERT INTO `city` VALUES ('280', '迪庆藏族自治州', '674400', '0887', '25', 'Deqen Zangzu Zizhizhou', 'DEZ');
INSERT INTO `city` VALUES ('281', '拉萨市', '850000', '0891', '26', 'Lhasa Shi', 'LXA');
INSERT INTO `city` VALUES ('282', '昌都地区', '854000', '0895', '26', 'Qamdo Diqu', 'QAD');
INSERT INTO `city` VALUES ('283', '山南地区', '856000', '0893', '26', 'Shannan Diqu', 'SND');
INSERT INTO `city` VALUES ('284', '日喀则地区', '857000', '0892', '26', 'Xigaze Diqu', 'XID');
INSERT INTO `city` VALUES ('285', '那曲地区', '852000', '0896', '26', 'Nagqu Diqu', 'NAD');
INSERT INTO `city` VALUES ('286', '阿里地区', '859000', '0897', '26', 'Ngari Diqu', 'NGD');
INSERT INTO `city` VALUES ('287', '林芝地区', '860000', '0894', '26', 'Nyingchi Diqu', 'NYD');
INSERT INTO `city` VALUES ('288', '西安市', '710000', '029', '27', 'Xi,an Shi', 'SIA');
INSERT INTO `city` VALUES ('289', '铜川市', '727000', '0919', '27', 'Tongchuan Shi', 'TCN');
INSERT INTO `city` VALUES ('290', '宝鸡市', '721000', '0917', '27', 'Baoji Shi', 'BJI');
INSERT INTO `city` VALUES ('291', '咸阳市', '712000', '029', '27', 'Xianyang Shi', 'XYS');
INSERT INTO `city` VALUES ('292', '渭南市', '714000', '0913', '27', 'Weinan Shi', 'WNA');
INSERT INTO `city` VALUES ('293', '延安市', '716000', '0911', '27', 'Yan,an Shi', 'YNA');
INSERT INTO `city` VALUES ('294', '汉中市', '723000', '0916', '27', 'Hanzhong Shi', 'HZJ');
INSERT INTO `city` VALUES ('295', '榆林市', '719000', '0912', '27', 'Yulin Shi', 'YLN');
INSERT INTO `city` VALUES ('296', '安康市', '725000', '0915', '27', 'Ankang Shi', 'ANK');
INSERT INTO `city` VALUES ('297', '商洛市', '726000', '0914', '27', '', '');
INSERT INTO `city` VALUES ('298', '兰州市', '730000', '0931', '28', 'Lanzhou Shi', 'LHW');
INSERT INTO `city` VALUES ('299', '嘉峪关市', '735100', '0937', '28', 'Jiayuguan Shi', 'JYG');
INSERT INTO `city` VALUES ('300', '金昌市', '737100', '0935', '28', 'Jinchang Shi', 'JCS');
INSERT INTO `city` VALUES ('301', '白银市', '730900', '0943', '28', 'Baiyin Shi', 'BYS');
INSERT INTO `city` VALUES ('302', '天水市', '741000', '0938', '28', 'Tianshui Shi', 'TSU');
INSERT INTO `city` VALUES ('303', '武威市', '733000', '0935', '28', 'Wuwei Shi', 'WWS');
INSERT INTO `city` VALUES ('304', '张掖市', '734000', '0936', '28', 'Zhangye Shi', 'ZYE');
INSERT INTO `city` VALUES ('305', '平凉市', '744000', '0933', '28', 'Pingliang Shi', 'PLS');
INSERT INTO `city` VALUES ('306', '酒泉市', '735000', '0937', '28', 'Jiuquan Shi', 'JQG');
INSERT INTO `city` VALUES ('307', '庆阳市', '745000', '0934', '28', 'Qingyang Shi', 'QYG');
INSERT INTO `city` VALUES ('308', '定西市', '743000', '0932', '28', '', '');
INSERT INTO `city` VALUES ('309', '陇南市', '742500', '0939', '28', '', '');
INSERT INTO `city` VALUES ('310', '临夏回族自治州', '731100', '0930', '28', 'Linxia Huizu Zizhizhou ', 'LXH');
INSERT INTO `city` VALUES ('311', '甘南藏族自治州', '747000', '0941', '28', 'Gannan Zangzu Zizhizhou', 'GNZ');
INSERT INTO `city` VALUES ('312', '西宁市', '810000', '0971', '29', 'Xining Shi', 'XNN');
INSERT INTO `city` VALUES ('313', '海东地区', '810600', '0972', '29', 'Haidong Diqu', 'HDD');
INSERT INTO `city` VALUES ('314', '海北藏族自治州', '812200', '0970', '29', 'Haibei Zangzu Zizhizhou', 'HBZ');
INSERT INTO `city` VALUES ('315', '黄南藏族自治州', '811300', '0973', '29', 'Huangnan Zangzu Zizhizhou', 'HNZ');
INSERT INTO `city` VALUES ('316', '海南藏族自治州', '813000', '0974', '29', 'Hainan Zangzu Zizhizhou', 'HNN');
INSERT INTO `city` VALUES ('317', '果洛藏族自治州', '814000', '0975', '29', 'Golog Zangzu Zizhizhou', 'GOL');
INSERT INTO `city` VALUES ('318', '玉树藏族自治州', '815000', '0976', '29', 'Yushu Zangzu Zizhizhou', 'YSZ');
INSERT INTO `city` VALUES ('319', '海西蒙古族藏族自治州', '817000', '0979', '29', 'Haixi Mongolzu Zangzu Zizhizhou', 'HXZ');
INSERT INTO `city` VALUES ('320', '银川市', '750000', '0951', '30', 'Yinchuan Shi', 'INC');
INSERT INTO `city` VALUES ('321', '石嘴山市', '753000', '0952', '30', 'Shizuishan Shi', 'SZS');
INSERT INTO `city` VALUES ('322', '吴忠市', '751100', '0953', '30', 'Wuzhong Shi', 'WZS');
INSERT INTO `city` VALUES ('323', '固原市', '756000', '0954', '30', '', '');
INSERT INTO `city` VALUES ('324', '中卫市', '755000', '0955', '30', '', '');
INSERT INTO `city` VALUES ('325', '乌鲁木齐市', '830000', '0991', '31', 'Urumqi Shi', 'URC');
INSERT INTO `city` VALUES ('326', '克拉玛依市', '834000', '0990', '31', 'Karamay Shi', 'KAR');
INSERT INTO `city` VALUES ('327', '吐鲁番地区', '838000', '0995', '31', 'Turpan Diqu', 'TUD');
INSERT INTO `city` VALUES ('328', '哈密地区', '839000', '0902', '31', 'Hami(kumul) Diqu', 'HMD');
INSERT INTO `city` VALUES ('329', '昌吉回族自治州', '831100', '0994', '31', 'Changji Huizu Zizhizhou', 'CJZ');
INSERT INTO `city` VALUES ('330', '博尔塔拉蒙古自治州', '833400', '0909', '31', 'Bortala Monglo Zizhizhou', 'BOR');
INSERT INTO `city` VALUES ('331', '巴音郭楞蒙古自治州', '841000', '0996', '31', '', '');
INSERT INTO `city` VALUES ('332', '阿克苏地区', '843000', '0997', '31', 'Aksu Diqu', 'AKD');
INSERT INTO `city` VALUES ('333', '克孜勒苏柯尔克孜自治州', '845350', '0908', '31', 'Kizilsu Kirgiz Zizhizhou', 'KIZ');
INSERT INTO `city` VALUES ('334', '喀什地区', '844000', '0998', '31', 'Kashi(Kaxgar) Diqu', 'KSI');
INSERT INTO `city` VALUES ('335', '和田地区', '848000', '0903', '31', 'Hotan Diqu', 'HOD');
INSERT INTO `city` VALUES ('336', '伊犁哈萨克自治州', '835000', '0999', '31', 'Ili Kazak Zizhizhou', 'ILD');
INSERT INTO `city` VALUES ('337', '塔城地区', '834700', '0901', '31', 'Tacheng(Qoqek) Diqu', 'TCD');
INSERT INTO `city` VALUES ('338', '阿勒泰地区', '836500', '0906', '31', 'Altay Diqu', 'ALD');
INSERT INTO `city` VALUES ('339', '石河子市', '832000', '0993', '31', 'Shihezi Shi', 'SHZ');
INSERT INTO `city` VALUES ('340', '阿拉尔市', '843300', '0997', '31', '', '');
INSERT INTO `city` VALUES ('341', '图木舒克市', '844000', '0998', '31', '', '');
INSERT INTO `city` VALUES ('342', '五家渠市', '831300', '0994', '31', '', '');
INSERT INTO `city` VALUES ('343', '香港特别行政区', '999077', '00852', '32', 'Hongkong Tebiexingzhengqu', 'HK');
INSERT INTO `city` VALUES ('344', '澳门特别行政区', '999078', '00853', '33', '', '');
INSERT INTO `city` VALUES ('345', '台湾省', '222', '8862', '34', 'Taiwan Sheng', 'TW');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `cellphone` char(20) DEFAULT NULL,
  `homephone` char(20) DEFAULT NULL,
  `officephone` char(20) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `companyname` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `salerid` int(11) DEFAULT NULL,
  `interview` varchar(2048) DEFAULT NULL,
  `remark` varchar(2048) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `provinceid` int(11) DEFAULT NULL,
  `cityid` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for `dkspecinfo`
-- ----------------------------
DROP TABLE IF EXISTS `dkspecinfo`;
CREATE TABLE `dkspecinfo` (
  `dkspec_id` int(11) NOT NULL AUTO_INCREMENT,
  `dkspec_name` char(64) DEFAULT NULL,
  PRIMARY KEY (`dkspec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dkspecinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `instock`
-- ----------------------------
DROP TABLE IF EXISTS `instock`;
CREATE TABLE `instock` (
  `in_id` int(11) NOT NULL AUTO_INCREMENT,
  `in_time` datetime DEFAULT NULL,
  `operator` char(20) DEFAULT NULL,
  PRIMARY KEY (`in_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instock
-- ----------------------------

-- ----------------------------
-- Table structure for `instockproduct`
-- ----------------------------
DROP TABLE IF EXISTS `instockproduct`;
CREATE TABLE `instockproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `in_id` int(11) NOT NULL DEFAULT '0',
  `product_id` int(11) NOT NULL DEFAULT '0',
  `count` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instockproduct
-- ----------------------------

-- ----------------------------
-- Table structure for `outstock`
-- ----------------------------
DROP TABLE IF EXISTS `outstock`;
CREATE TABLE `outstock` (
  `out_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `sale_time` datetime DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `saler_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `operator` char(20) DEFAULT NULL,
  PRIMARY KEY (`out_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstock
-- ----------------------------

-- ----------------------------
-- Table structure for `outstockproduct`
-- ----------------------------
DROP TABLE IF EXISTS `outstockproduct`;
CREATE TABLE `outstockproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `out_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `barcode` char(128) DEFAULT NULL,
  `usage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstockproduct
-- ----------------------------

-- ----------------------------
-- Table structure for `productbatch`
-- ----------------------------
DROP TABLE IF EXISTS `productbatch`;
CREATE TABLE `productbatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productbatch
-- ----------------------------

-- ----------------------------
-- Table structure for `productinfo`
-- ----------------------------
DROP TABLE IF EXISTS `productinfo`;
CREATE TABLE `productinfo` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(64) DEFAULT NULL,
  `dkspec_id` int(11) DEFAULT NULL,
  `spec_id` int(11) DEFAULT NULL,
  `temp` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `prov_id` int(11) NOT NULL COMMENT 'id',
  `prov_name` varchar(16) DEFAULT NULL COMMENT '省名',
  `prov_py` varchar(32) DEFAULT NULL,
  `prov_zm` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`prov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京市', 'Beijing Shi', 'BJS');
INSERT INTO `province` VALUES ('2', '天津市', 'Tianjin Shi', 'TJS');
INSERT INTO `province` VALUES ('3', '河北省', 'Hebei Sheng', 'HBS');
INSERT INTO `province` VALUES ('4', '山西省', 'Shanxi Sheng', 'SXS');
INSERT INTO `province` VALUES ('5', '内蒙古自治区', 'Neimenggu Zizhiqu', 'NMGZZQ');
INSERT INTO `province` VALUES ('6', '辽宁省', 'Liaoning Sheng', 'LNS');
INSERT INTO `province` VALUES ('7', '吉林省', 'Jilin Sheng', 'JLS');
INSERT INTO `province` VALUES ('8', '黑龙江省', 'Heilongjiang Sheng', 'HLJS');
INSERT INTO `province` VALUES ('9', '上海市', 'Shanghai Shi', 'SHS');
INSERT INTO `province` VALUES ('10', '江苏省', 'Jiangsu Sheng', 'JSS');
INSERT INTO `province` VALUES ('11', '浙江省', 'Zhejiang Sheng', 'ZJS');
INSERT INTO `province` VALUES ('12', '安徽省', 'Anhui Sheng', 'AHS');
INSERT INTO `province` VALUES ('13', '福建省', 'Fujian Sheng', 'FJS');
INSERT INTO `province` VALUES ('14', '江西省', 'Jiangxi Sheng', 'JXS');
INSERT INTO `province` VALUES ('15', '山东省', 'Shandong Sheng', 'SDS');
INSERT INTO `province` VALUES ('16', '河南省', 'Henan Sheng', 'HNS');
INSERT INTO `province` VALUES ('17', '湖北省', 'Hubei Sheng', 'HBS');
INSERT INTO `province` VALUES ('18', '湖南省', 'Hunan Sheng', 'HNS');
INSERT INTO `province` VALUES ('19', '广东省', 'Guangdong Sheng', 'GDS');
INSERT INTO `province` VALUES ('20', '广西壮族自治区', 'Guangxizhuangzu Zizhiqu', 'GXZZZZQ');
INSERT INTO `province` VALUES ('21', '海南省', 'Hainan Sheng', 'HNS');
INSERT INTO `province` VALUES ('22', '重庆市', 'Chongqing Shi', 'CQS');
INSERT INTO `province` VALUES ('23', '四川省', 'Sichuan Sheng', 'SCS');
INSERT INTO `province` VALUES ('24', '贵州省', 'Guizhou Sheng', 'GZS');
INSERT INTO `province` VALUES ('25', '云南省', 'Yunnan Sheng', 'YNS');
INSERT INTO `province` VALUES ('26', '西藏自治区', 'Xizang Zizhiqu', 'XZZZQ');
INSERT INTO `province` VALUES ('27', '陕西省', 'Shanxi Sheng', 'SXS');
INSERT INTO `province` VALUES ('28', '甘肃省', 'Gansu Sheng', 'GSS');
INSERT INTO `province` VALUES ('29', '青海省', 'Qinghai Sheng', 'QHS');
INSERT INTO `province` VALUES ('30', '宁夏回族自治区', 'Ningxiahuizu Zizhiqu', 'NXHZZZQ');
INSERT INTO `province` VALUES ('31', '新疆维吾尔自治区', 'Xinjiangweiwuer Zizhiqu', 'XJWWEZZQ');
INSERT INTO `province` VALUES ('32', '香港特别行政区', 'Xianggang Tebiexingzhengqu', 'XGTBXZQ');
INSERT INTO `province` VALUES ('33', '澳门特别行政区', 'Aomen Tebiexingzhengqu', 'AMTBXZQ');
INSERT INTO `province` VALUES ('34', '台湾省', 'Taiwan Sheng', 'TWS');

-- ----------------------------
-- Table structure for `saler`
-- ----------------------------
DROP TABLE IF EXISTS `saler`;
CREATE TABLE `saler` (
  `saler_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(10) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `position` char(10) DEFAULT NULL,
  PRIMARY KEY (`saler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saler
-- ----------------------------

-- ----------------------------
-- Table structure for `specinfo`
-- ----------------------------
DROP TABLE IF EXISTS `specinfo`;
CREATE TABLE `specinfo` (
  `spec_id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_name` char(64) DEFAULT NULL,
  PRIMARY KEY (`spec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `stockstatus`
-- ----------------------------
DROP TABLE IF EXISTS `stockstatus`;
CREATE TABLE `stockstatus` (
  `product_id` int(11) NOT NULL,
  `incount` int(11) DEFAULT NULL,
  `outcount` int(11) DEFAULT NULL,
  `remaincount` int(11) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockstatus
-- ----------------------------

-- ----------------------------
-- Table structure for `usageinfo`
-- ----------------------------
DROP TABLE IF EXISTS `usageinfo`;
CREATE TABLE `usageinfo` (
  `usage_id` int(11) NOT NULL AUTO_INCREMENT,
  `usage_name` char(128) DEFAULT NULL,
  PRIMARY KEY (`usage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usageinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` char(20) NOT NULL DEFAULT '',
  `password` char(32) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `name` char(10) DEFAULT NULL,
  `phone` char(16) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '21218cca77804d2ba1922c33e0151105', '1', '管理员', '111');

-- ----------------------------
-- Table structure for `user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `userid` char(20) NOT NULL,
  `authority` char(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('admin', 'ROLE_ADMIN');
