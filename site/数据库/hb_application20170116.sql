/*
Navicat MySQL Data Transfer

Source Server         : 10.0.0.231
Source Server Version : 50635
Source Host           : 10.0.0.231:3306
Source Database       : hb_application

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-16 18:38:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_base_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_base_data`;
CREATE TABLE `sys_base_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '类型：0顶级类型，1地区信息2',
  `name` varchar(30) DEFAULT NULL COMMENT '显示名称',
  `value` varchar(100) DEFAULT NULL COMMENT '数值',
  `alias` varchar(30) DEFAULT NULL COMMENT '花费时间',
  `mark` varchar(100) DEFAULT NULL COMMENT 'ip',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0禁用1启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_base_data
-- ----------------------------
INSERT INTO `sys_base_data` VALUES ('1', '0', '地区信息', '1', 'DQXX', '武汉地区', '1');
INSERT INTO `sys_base_data` VALUES ('2', '0', '接口地址', '2', 'WEB_SERVISE', '接口地址', '1');
INSERT INTO `sys_base_data` VALUES ('3', '0', '预警指标', '3', 'YUJIN', '预警指标', '1');
INSERT INTO `sys_base_data` VALUES ('5', '1', '江夏区', '1', 'DQ_JXQ', '江夏区', '1');
INSERT INTO `sys_base_data` VALUES ('6', '2', '小贷数据接口', '183.123.12.1:8080:xdyw', 'JK_XDYW', '接口地址', '1');
INSERT INTO `sys_base_data` VALUES ('7', '2', '担保数据接口', '183.123.12.1:8080:dbyw', 'JK_DBYW', 'db', '0');
INSERT INTO `sys_base_data` VALUES ('8', '1', '江汉区', 'DQ_JH', 'DQ_JH', 'testaa', '1');
INSERT INTO `sys_base_data` VALUES ('9', '100', 'test', 'userService#test#0/5 * * * * ?', 'userTask', '', '0');
INSERT INTO `sys_base_data` VALUES ('175', '0', '定时任务', '100', 'DSRW', '', '1');
INSERT INTO `sys_base_data` VALUES ('176', '100', 'khjl', 'logService#test#0/7 * * * * ?', 'logTestTask', '', '0');
INSERT INTO `sys_base_data` VALUES ('177', '100', '计算小贷平均利率', 'xiaoDaiRateService#calculateRate#0 0 23 * * ?', 'XiaoDaiRateServiceTask', '', '1');
INSERT INTO `sys_base_data` VALUES ('178', '100', '计算利率指数周k', 'rateMonthService#calculateRatepower#0 0 23 ? * SAT', 'rateMonthService', '', '1');
INSERT INTO `sys_base_data` VALUES ('180', '3', '小贷利率预警', '1', 'YUJIN_XDRATE', '', '1');
INSERT INTO `sys_base_data` VALUES ('181', '100', '每天计算一次利率指数', 'rateMonthService#calculateRatepowerOnday#0 10 23 * * ?', 'rateDayServiceTask', '', '1');
INSERT INTO `sys_base_data` VALUES ('182', '3', '计算小贷利率下限值', '15', 'RATE_MIN', '', '1');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sysname` varchar(50) DEFAULT NULL,
  `alias` varchar(50) DEFAULT NULL,
  `update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` int(2) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `filetype` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sys_file` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('120', '1', '2014102214314115853160591066.sql', '2014102214314115853160591066.sql', 'MySQL备份', '2014-10-22 14:31:41', '100', '1', '.sql');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名称',
  `module` varchar(30) DEFAULT NULL COMMENT '模块',
  `action` varchar(30) DEFAULT NULL COMMENT '执行操作',
  `actionTime` varchar(30) DEFAULT NULL COMMENT '花费时间',
  `userIP` varchar(30) DEFAULT NULL COMMENT 'ip',
  `operTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1903 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1639', 'admin', null, 'update操作', '15', '192.168.0.29', '2014-10-22 14:25:08');
INSERT INTO `sys_log` VALUES ('1640', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 14:25:09');
INSERT INTO `sys_log` VALUES ('1641', 'admin', null, 'update操作', '2', '192.168.0.29', '2014-10-22 14:25:10');
INSERT INTO `sys_log` VALUES ('1642', 'admin', null, 'update操作', '2', '192.168.0.29', '2014-10-22 14:25:10');
INSERT INTO `sys_log` VALUES ('1643', 'admin', null, 'update操作', '4', '192.168.0.29', '2014-10-22 14:25:11');
INSERT INTO `sys_log` VALUES ('1644', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 14:25:11');
INSERT INTO `sys_log` VALUES ('1645', 'admin', null, 'update操作', '4', '192.168.0.29', '2014-10-22 14:25:12');
INSERT INTO `sys_log` VALUES ('1646', 'admin', null, 'update操作', '13', '192.168.0.29', '2014-10-22 14:28:08');
INSERT INTO `sys_log` VALUES ('1647', 'admin', null, 'update操作', '18', '192.168.0.29', '2014-10-22 14:28:12');
INSERT INTO `sys_log` VALUES ('1648', 'admin', null, 'update操作', '8', '192.168.0.29', '2014-10-22 14:28:15');
INSERT INTO `sys_log` VALUES ('1649', 'admin', '文件管理', 'download操作', '154', '192.168.0.29', '2014-10-22 14:31:44');
INSERT INTO `sys_log` VALUES ('1650', 'admin', '资源管理', 'update角色的权限', '151', '192.168.0.29', '2014-10-22 14:37:55');
INSERT INTO `sys_log` VALUES ('1651', 'admin', '资源管理', 'update角色的权限', '122', '192.168.0.29', '2014-10-22 14:38:05');
INSERT INTO `sys_log` VALUES ('1652', 'admin', '资源管理', 'update角色的权限', '241', '192.168.0.29', '2014-10-22 14:39:20');
INSERT INTO `sys_log` VALUES ('1653', 'admin', '资源管理', 'update角色的权限', '120', '192.168.0.29', '2014-10-22 14:39:35');
INSERT INTO `sys_log` VALUES ('1654', 'admin', '资源管理', 'update角色的权限', '156', '192.168.0.29', '2014-10-22 14:39:52');
INSERT INTO `sys_log` VALUES ('1655', 'admin', '资源管理', 'update角色的权限', '70', '192.168.0.29', '2014-10-22 14:41:46');
INSERT INTO `sys_log` VALUES ('1656', 'admin', '资源管理', 'update角色的权限', '48', '192.168.0.29', '2014-10-22 14:42:07');
INSERT INTO `sys_log` VALUES ('1657', 'abc', '用户管理', 'update操作', '20', '192.168.0.29', '2014-10-22 14:42:33');
INSERT INTO `sys_log` VALUES ('1658', 'abc', '用户管理', 'update操作', '13', '192.168.0.29', '2014-10-22 14:42:35');
INSERT INTO `sys_log` VALUES ('1659', 'abc', '用户管理', 'update操作', '3', '192.168.0.29', '2014-10-22 14:42:41');
INSERT INTO `sys_log` VALUES ('1660', 'test', '用户管理', 'update操作', '5', '192.168.0.29', '2014-10-22 15:02:46');
INSERT INTO `sys_log` VALUES ('1661', 'test', '用户管理', 'update操作', '18', '192.168.0.29', '2014-10-22 15:02:46');
INSERT INTO `sys_log` VALUES ('1662', 'test', '用户管理', 'update操作', '4', '192.168.0.29', '2014-10-22 15:02:47');
INSERT INTO `sys_log` VALUES ('1663', 'test', '用户管理', 'update操作', '5', '192.168.0.29', '2014-10-22 15:02:49');
INSERT INTO `sys_log` VALUES ('1664', 'test', '用户管理', 'update操作', '4', '192.168.0.29', '2014-10-22 15:02:49');
INSERT INTO `sys_log` VALUES ('1665', 'test', '用户管理', 'update操作', '4', '192.168.0.29', '2014-10-22 15:02:50');
INSERT INTO `sys_log` VALUES ('1666', 'test', '用户管理', 'update操作', '3', '192.168.0.29', '2014-10-22 15:02:51');
INSERT INTO `sys_log` VALUES ('1667', 'test', '用户管理', 'update操作', '3', '192.168.0.29', '2014-10-22 15:02:52');
INSERT INTO `sys_log` VALUES ('1668', 'test', '用户管理', 'update操作', '24', '192.168.0.29', '2014-10-22 15:02:54');
INSERT INTO `sys_log` VALUES ('1669', 'test', '用户管理', 'update操作', '5', '192.168.0.29', '2014-10-22 15:02:55');
INSERT INTO `sys_log` VALUES ('1670', 'test', '用户管理', 'update操作', '4', '192.168.0.29', '2014-10-22 15:03:17');
INSERT INTO `sys_log` VALUES ('1671', null, null, 'save操作', '66', '192.168.0.29', '2014-10-22 15:41:15');
INSERT INTO `sys_log` VALUES ('1672', null, null, 'save操作', '18', '192.168.0.29', '2014-10-22 15:41:16');
INSERT INTO `sys_log` VALUES ('1673', 'admin', null, 'update操作', '4', '192.168.0.29', '2014-10-22 16:26:19');
INSERT INTO `sys_log` VALUES ('1674', 'admin', null, 'save操作', '31', '192.168.0.29', '2014-10-22 16:29:12');
INSERT INTO `sys_log` VALUES ('1675', 'admin', null, 'update操作', '9', '192.168.0.29', '2014-10-22 16:29:51');
INSERT INTO `sys_log` VALUES ('1676', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 16:30:21');
INSERT INTO `sys_log` VALUES ('1677', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 16:30:39');
INSERT INTO `sys_log` VALUES ('1678', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 16:30:40');
INSERT INTO `sys_log` VALUES ('1679', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 16:30:41');
INSERT INTO `sys_log` VALUES ('1680', 'admin', null, 'delete操作', '6', '192.168.0.29', '2014-10-22 16:30:41');
INSERT INTO `sys_log` VALUES ('1681', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 16:30:42');
INSERT INTO `sys_log` VALUES ('1682', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 16:30:42');
INSERT INTO `sys_log` VALUES ('1683', 'admin', null, 'update操作', '6', '192.168.0.29', '2014-10-22 16:41:11');
INSERT INTO `sys_log` VALUES ('1684', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 16:42:35');
INSERT INTO `sys_log` VALUES ('1685', 'admin', '资源管理', 'delete操作', '4', '192.168.0.29', '2014-10-22 16:51:36');
INSERT INTO `sys_log` VALUES ('1686', 'admin', '资源管理', 'delete操作', '3', '192.168.0.29', '2014-10-22 16:51:43');
INSERT INTO `sys_log` VALUES ('1687', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 16:55:28');
INSERT INTO `sys_log` VALUES ('1688', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 16:56:43');
INSERT INTO `sys_log` VALUES ('1689', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 16:57:00');
INSERT INTO `sys_log` VALUES ('1690', 'admin', null, 'update操作', '5', '192.168.0.29', '2014-10-22 17:04:16');
INSERT INTO `sys_log` VALUES ('1691', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 17:04:22');
INSERT INTO `sys_log` VALUES ('1692', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 17:04:28');
INSERT INTO `sys_log` VALUES ('1693', 'admin', null, 'delete操作', '12', '192.168.0.29', '2014-10-22 17:04:30');
INSERT INTO `sys_log` VALUES ('1694', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 17:05:12');
INSERT INTO `sys_log` VALUES ('1695', 'admin', null, 'save操作', '3', '192.168.0.29', '2014-10-22 17:22:17');
INSERT INTO `sys_log` VALUES ('1696', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 17:27:00');
INSERT INTO `sys_log` VALUES ('1697', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 17:27:01');
INSERT INTO `sys_log` VALUES ('1698', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 17:27:02');
INSERT INTO `sys_log` VALUES ('1699', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:31:05');
INSERT INTO `sys_log` VALUES ('1700', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 17:31:24');
INSERT INTO `sys_log` VALUES ('1701', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:32:32');
INSERT INTO `sys_log` VALUES ('1702', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 17:35:29');
INSERT INTO `sys_log` VALUES ('1703', 'admin', null, 'update操作', '7', '192.168.0.29', '2014-10-22 17:35:35');
INSERT INTO `sys_log` VALUES ('1704', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 17:37:08');
INSERT INTO `sys_log` VALUES ('1705', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 17:39:44');
INSERT INTO `sys_log` VALUES ('1706', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 17:39:47');
INSERT INTO `sys_log` VALUES ('1707', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 17:40:41');
INSERT INTO `sys_log` VALUES ('1708', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:44:40');
INSERT INTO `sys_log` VALUES ('1709', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:45:25');
INSERT INTO `sys_log` VALUES ('1710', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:45:43');
INSERT INTO `sys_log` VALUES ('1711', 'admin', null, 'update操作', '4', '192.168.0.29', '2014-10-22 17:46:05');
INSERT INTO `sys_log` VALUES ('1712', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:51:24');
INSERT INTO `sys_log` VALUES ('1713', 'admin', null, 'update操作', '36', '192.168.0.29', '2014-10-22 17:51:46');
INSERT INTO `sys_log` VALUES ('1714', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 17:52:16');
INSERT INTO `sys_log` VALUES ('1715', 'admin', null, 'delete操作', '16265', '192.168.0.29', '2014-10-22 17:52:33');
INSERT INTO `sys_log` VALUES ('1716', 'admin', null, 'delete操作', '15301', '192.168.0.29', '2014-10-22 17:52:33');
INSERT INTO `sys_log` VALUES ('1717', 'admin', null, 'delete操作', '14388', '192.168.0.29', '2014-10-22 17:52:33');
INSERT INTO `sys_log` VALUES ('1718', 'admin', null, 'delete操作', '12810', '192.168.0.29', '2014-10-22 17:52:33');
INSERT INTO `sys_log` VALUES ('1719', 'admin', null, 'update操作', '3', '192.168.0.29', '2014-10-22 17:53:11');
INSERT INTO `sys_log` VALUES ('1720', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 18:07:27');
INSERT INTO `sys_log` VALUES ('1721', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 18:07:27');
INSERT INTO `sys_log` VALUES ('1722', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 18:07:28');
INSERT INTO `sys_log` VALUES ('1723', 'admin', null, 'delete操作', '13', '192.168.0.29', '2014-10-22 18:07:28');
INSERT INTO `sys_log` VALUES ('1724', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 18:07:29');
INSERT INTO `sys_log` VALUES ('1725', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 18:07:29');
INSERT INTO `sys_log` VALUES ('1726', 'admin', null, 'delete操作', '5', '192.168.0.29', '2014-10-22 18:07:29');
INSERT INTO `sys_log` VALUES ('1727', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 18:07:30');
INSERT INTO `sys_log` VALUES ('1728', 'admin', null, 'delete操作', '12', '192.168.0.29', '2014-10-22 18:07:30');
INSERT INTO `sys_log` VALUES ('1729', 'admin', null, 'delete操作', '17', '192.168.0.29', '2014-10-22 18:07:31');
INSERT INTO `sys_log` VALUES ('1730', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 18:07:31');
INSERT INTO `sys_log` VALUES ('1731', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 18:07:31');
INSERT INTO `sys_log` VALUES ('1732', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 18:07:32');
INSERT INTO `sys_log` VALUES ('1733', 'admin', null, 'delete操作', '2', '192.168.0.29', '2014-10-22 18:07:32');
INSERT INTO `sys_log` VALUES ('1734', 'admin', null, 'delete操作', '4', '192.168.0.29', '2014-10-22 18:07:33');
INSERT INTO `sys_log` VALUES ('1735', 'admin', null, 'delete操作', '3', '192.168.0.29', '2014-10-22 18:07:33');
INSERT INTO `sys_log` VALUES ('1736', 'admin', null, 'delete操作', '7', '192.168.0.29', '2014-10-22 18:07:34');
INSERT INTO `sys_log` VALUES ('1737', 'admin', null, '平均利率操作', '6', '192.168.0.124', '2015-03-04 10:53:49');
INSERT INTO `sys_log` VALUES ('1738', 'admin', null, 'update操作', '22', '192.168.0.118', '2015-03-30 18:42:05');
INSERT INTO `sys_log` VALUES ('1739', 'admin', null, 'update操作', '6', '192.168.0.118', '2015-03-30 18:42:08');
INSERT INTO `sys_log` VALUES ('1740', 'admin', null, 'update操作', '4', '192.168.0.118', '2015-03-30 18:42:10');
INSERT INTO `sys_log` VALUES ('1741', 'admin', null, 'update操作', '7', '192.168.0.118', '2015-03-30 18:42:11');
INSERT INTO `sys_log` VALUES ('1742', 'admin', null, 'update操作', '3', '192.168.0.118', '2015-03-30 18:42:13');
INSERT INTO `sys_log` VALUES ('1743', 'admin', null, 'update操作', '3', '192.168.0.118', '2015-03-30 18:42:13');
INSERT INTO `sys_log` VALUES ('1744', 'admin', null, 'update操作', '5', '192.168.0.118', '2015-03-30 18:42:14');
INSERT INTO `sys_log` VALUES ('1745', 'admin', '资源管理', 'save操作', '12', '192.168.0.118', '2015-03-30 20:46:29');
INSERT INTO `sys_log` VALUES ('1746', 'admin', '资源管理', 'save操作', '5', '192.168.0.118', '2015-03-30 20:50:31');
INSERT INTO `sys_log` VALUES ('1747', 'admin', '资源管理', 'update操作', '3', '192.168.0.118', '2015-03-30 20:53:02');
INSERT INTO `sys_log` VALUES ('1748', 'admin', '资源管理', 'update操作', '5', '192.168.0.118', '2015-03-30 20:54:18');
INSERT INTO `sys_log` VALUES ('1749', 'admin', '资源管理', 'update角色的权限', '136', '192.168.0.118', '2015-03-30 20:54:38');
INSERT INTO `sys_log` VALUES ('1750', 'admin', null, 'save操作', '16', '192.168.0.118', '2015-03-30 20:56:32');
INSERT INTO `sys_log` VALUES ('1751', 'admin', '用户管理', 'update操作', '49', '10.0.0.23', '2017-01-11 15:15:41');
INSERT INTO `sys_log` VALUES ('1752', 'admin', '用户管理', 'update操作', '5', '10.0.0.23', '2017-01-11 15:15:50');
INSERT INTO `sys_log` VALUES ('1753', 'admin', '用户管理', 'update操作', '23', '10.0.0.23', '2017-01-11 16:14:35');
INSERT INTO `sys_log` VALUES ('1754', 'admin', '用户管理', 'update操作', '7', '10.0.0.23', '2017-01-11 16:14:36');
INSERT INTO `sys_log` VALUES ('1755', 'admin', '用户管理', 'update操作', '11', '10.0.0.23', '2017-01-11 16:29:12');
INSERT INTO `sys_log` VALUES ('1756', 'admin', '用户管理', 'update操作', '8', '10.0.0.23', '2017-01-11 16:29:13');
INSERT INTO `sys_log` VALUES ('1757', 'admin', '用户管理', 'update操作', '9', '10.0.0.23', '2017-01-11 16:29:15');
INSERT INTO `sys_log` VALUES ('1758', 'admin', '用户管理', 'update操作', '7', '10.0.0.23', '2017-01-11 16:29:17');
INSERT INTO `sys_log` VALUES ('1759', 'admin', '用户管理', 'update操作', '7', '10.0.0.23', '2017-01-11 16:29:18');
INSERT INTO `sys_log` VALUES ('1760', 'admin', '角色管理', 'update用户的角色', '5', '10.0.0.23', '2017-01-11 16:38:08');
INSERT INTO `sys_log` VALUES ('1761', 'admin', '用户管理', 'update操作', '10', '10.0.0.23', '2017-01-11 17:35:01');
INSERT INTO `sys_log` VALUES ('1762', 'admin', '角色管理', 'update用户的角色', '7', '10.0.0.23', '2017-01-11 17:35:01');
INSERT INTO `sys_log` VALUES ('1763', 'admin', '用户管理', 'update操作', '6', '10.0.0.23', '2017-01-11 17:35:13');
INSERT INTO `sys_log` VALUES ('1764', 'admin', '角色管理', 'update用户的角色', '6', '10.0.0.23', '2017-01-11 17:35:13');
INSERT INTO `sys_log` VALUES ('1765', 'admin', '资源管理', 'update操作', '5', '10.0.0.23', '2017-01-11 17:36:09');
INSERT INTO `sys_log` VALUES ('1766', 'admin', '资源管理', 'delete操作', '10', '10.0.0.23', '2017-01-11 17:36:25');
INSERT INTO `sys_log` VALUES ('1767', 'admin', '资源管理', 'delete操作', '11', '10.0.0.23', '2017-01-11 17:38:33');
INSERT INTO `sys_log` VALUES ('1768', 'admin', '资源管理', 'save操作', '13', '10.0.0.23', '2017-01-12 11:45:07');
INSERT INTO `sys_log` VALUES ('1769', 'admin', '资源管理', 'delete操作', '6', '10.0.0.23', '2017-01-12 11:45:46');
INSERT INTO `sys_log` VALUES ('1770', 'admin', '资源管理', 'save操作', '13', '10.0.0.23', '2017-01-12 11:46:20');
INSERT INTO `sys_log` VALUES ('1771', 'admin', '资源管理', 'save操作', '6', '10.0.0.23', '2017-01-12 11:47:28');
INSERT INTO `sys_log` VALUES ('1772', 'admin', '资源管理', 'save操作', '9', '10.0.0.23', '2017-01-12 11:48:43');
INSERT INTO `sys_log` VALUES ('1773', 'admin', '资源管理', 'update操作', '7', '10.0.0.23', '2017-01-12 11:49:07');
INSERT INTO `sys_log` VALUES ('1774', 'admin', '资源管理', 'update操作', '8', '10.0.0.23', '2017-01-12 11:50:36');
INSERT INTO `sys_log` VALUES ('1775', 'admin', '资源管理', 'update操作', '7', '10.0.0.23', '2017-01-12 11:50:47');
INSERT INTO `sys_log` VALUES ('1776', 'admin', '资源管理', 'update操作', '9', '10.0.0.23', '2017-01-12 11:50:54');
INSERT INTO `sys_log` VALUES ('1777', 'admin', '资源管理', 'update操作', '9', '10.0.0.23', '2017-01-12 11:52:36');
INSERT INTO `sys_log` VALUES ('1778', 'admin', '资源管理', 'update操作', '8', '10.0.0.23', '2017-01-12 11:52:50');
INSERT INTO `sys_log` VALUES ('1779', 'admin', '资源管理', 'delete操作', '156', '10.0.0.23', '2017-01-12 11:53:31');
INSERT INTO `sys_log` VALUES ('1780', 'admin', '资源管理', 'update操作', '7', '10.0.0.23', '2017-01-12 11:54:36');
INSERT INTO `sys_log` VALUES ('1781', 'admin', '资源管理', 'save操作', '8', '10.0.0.23', '2017-01-12 11:54:58');
INSERT INTO `sys_log` VALUES ('1782', 'admin', '资源管理', 'save操作', '6', '10.0.0.23', '2017-01-12 11:55:35');
INSERT INTO `sys_log` VALUES ('1783', 'admin', '资源管理', 'save操作', '8', '10.0.0.23', '2017-01-12 11:56:13');
INSERT INTO `sys_log` VALUES ('1784', 'admin', '资源管理', 'save操作', '8', '10.0.0.23', '2017-01-12 11:56:50');
INSERT INTO `sys_log` VALUES ('1785', 'admin', '资源管理', 'update操作', '36', '10.0.0.23', '2017-01-12 11:57:21');
INSERT INTO `sys_log` VALUES ('1786', 'admin', '角色管理', 'save操作', '10', '10.0.0.23', '2017-01-12 11:59:20');
INSERT INTO `sys_log` VALUES ('1787', 'admin', '资源管理', 'update角色的权限', '782', '10.0.0.23', '2017-01-12 11:59:46');
INSERT INTO `sys_log` VALUES ('1788', 'admin', '资源管理', 'save操作', '14', '10.0.0.23', '2017-01-12 12:07:16');
INSERT INTO `sys_log` VALUES ('1789', 'admin', '资源管理', 'update操作', '126', '10.0.0.19', '2017-01-13 02:28:47');
INSERT INTO `sys_log` VALUES ('1790', 'admin', '资源管理', 'update操作', '6', '10.0.0.19', '2017-01-13 02:29:37');
INSERT INTO `sys_log` VALUES ('1791', 'admin', '资源管理', 'update操作', '8', '10.0.0.19', '2017-01-13 02:29:57');
INSERT INTO `sys_log` VALUES ('1792', 'admin', '资源管理', 'update操作', '9', '192.168.209.1', '2017-01-13 02:35:13');
INSERT INTO `sys_log` VALUES ('1793', 'admin', '资源管理', 'update操作', '8', '192.168.209.1', '2017-01-13 02:36:01');
INSERT INTO `sys_log` VALUES ('1794', 'admin', '资源管理', 'update操作', '8', '192.168.209.1', '2017-01-13 02:38:16');
INSERT INTO `sys_log` VALUES ('1795', 'admin', '资源管理', 'update操作', '9', '192.168.209.1', '2017-01-13 02:45:08');
INSERT INTO `sys_log` VALUES ('1796', 'admin', '资源管理', 'delete操作', '16', '10.0.0.23', '2017-01-13 03:11:04');
INSERT INTO `sys_log` VALUES ('1797', 'admin', '用户管理', 'save操作', '11', '10.0.0.23', '2017-01-13 04:27:27');
INSERT INTO `sys_log` VALUES ('1798', 'admin', '角色管理', 'update用户的角色', '16', '10.0.0.23', '2017-01-13 04:27:40');
INSERT INTO `sys_log` VALUES ('1799', 'admin', '角色管理', 'save操作', '128', '192.168.209.1', '2017-01-13 04:43:52');
INSERT INTO `sys_log` VALUES ('1800', 'admin', '角色管理', 'save操作', '11', '192.168.209.1', '2017-01-13 04:45:48');
INSERT INTO `sys_log` VALUES ('1801', 'admin', '角色管理', 'save操作', '35', '192.168.209.1', '2017-01-13 04:45:59');
INSERT INTO `sys_log` VALUES ('1802', 'admin', null, 'update操作', '105', '192.168.209.1', '2017-01-13 04:48:38');
INSERT INTO `sys_log` VALUES ('1803', 'admin', null, 'update操作', '156', '192.168.209.1', '2017-01-13 06:20:26');
INSERT INTO `sys_log` VALUES ('1804', 'admin', null, 'update操作', '171', '192.168.209.1', '2017-01-13 06:21:29');
INSERT INTO `sys_log` VALUES ('1805', 'admin', null, 'update操作', '125', '192.168.209.1', '2017-01-13 21:38:51');
INSERT INTO `sys_log` VALUES ('1806', 'admin', null, 'update操作', '124', '192.168.209.1', '2017-01-13 21:38:55');
INSERT INTO `sys_log` VALUES ('1807', 'admin', null, 'update操作', '93', '192.168.209.1', '2017-01-13 21:38:57');
INSERT INTO `sys_log` VALUES ('1808', 'admin', '资源管理', 'update操作', '21', '10.0.0.23', '2017-01-13 21:41:38');
INSERT INTO `sys_log` VALUES ('1809', 'admin', null, 'update操作', '141', '192.168.209.1', '2017-01-13 21:55:57');
INSERT INTO `sys_log` VALUES ('1810', 'admin', null, 'update操作', '94', '192.168.209.1', '2017-01-13 22:11:57');
INSERT INTO `sys_log` VALUES ('1811', 'admin', null, 'update操作', '140', '192.168.209.1', '2017-01-13 22:12:05');
INSERT INTO `sys_log` VALUES ('1812', 'admin', null, 'update操作', '93', '192.168.209.1', '2017-01-13 22:12:05');
INSERT INTO `sys_log` VALUES ('1813', 'admin', null, 'update操作', '94', '192.168.209.1', '2017-01-13 22:16:17');
INSERT INTO `sys_log` VALUES ('1814', 'admin', null, 'update操作', '141', '192.168.209.1', '2017-01-13 22:16:21');
INSERT INTO `sys_log` VALUES ('1815', 'admin', null, 'update操作', '156', '192.168.209.1', '2017-01-13 22:30:28');
INSERT INTO `sys_log` VALUES ('1816', 'admin', null, 'update操作', '109', '192.168.209.1', '2017-01-13 22:30:31');
INSERT INTO `sys_log` VALUES ('1817', 'admin', null, 'update操作', '125', '192.168.209.1', '2017-01-13 22:33:28');
INSERT INTO `sys_log` VALUES ('1818', 'admin', null, 'update操作', '124', '192.168.209.1', '2017-01-13 23:03:34');
INSERT INTO `sys_log` VALUES ('1819', 'admin', '资源管理', 'update操作', '16', '192.168.209.1', '2017-01-13 23:59:43');
INSERT INTO `sys_log` VALUES ('1820', 'admin', '资源管理', 'update操作', '0', '192.168.209.1', '2017-01-14 00:05:18');
INSERT INTO `sys_log` VALUES ('1821', 'admin', '资源管理', 'update操作', '15', '192.168.209.1', '2017-01-14 00:39:47');
INSERT INTO `sys_log` VALUES ('1822', 'admin', '资源管理', 'update操作', '9', '192.168.80.1', '2017-01-14 00:40:19');
INSERT INTO `sys_log` VALUES ('1823', 'admin', '资源管理', 'update操作', '8', '192.168.80.1', '2017-01-14 00:45:03');
INSERT INTO `sys_log` VALUES ('1824', 'admin', '资源管理', 'update操作', '8', '192.168.80.1', '2017-01-14 00:59:40');
INSERT INTO `sys_log` VALUES ('1825', 'admin', '资源管理', 'update操作', '9', '192.168.80.1', '2017-01-14 01:05:10');
INSERT INTO `sys_log` VALUES ('1826', 'admin', '资源管理', 'update操作', '10', '192.168.80.1', '2017-01-14 01:08:43');
INSERT INTO `sys_log` VALUES ('1827', 'admin', '资源管理', 'update操作', '7', '192.168.80.1', '2017-01-14 01:09:13');
INSERT INTO `sys_log` VALUES ('1828', 'admin', '资源管理', 'update操作', '14', '192.168.80.1', '2017-01-14 01:35:27');
INSERT INTO `sys_log` VALUES ('1829', '13500000000', null, 'update操作', '36009', '10.0.0.23', '2017-01-14 02:16:07');
INSERT INTO `sys_log` VALUES ('1830', '13500000000', null, 'update操作', '120', '10.0.0.23', '2017-01-14 02:16:32');
INSERT INTO `sys_log` VALUES ('1831', '13500000000', null, 'update操作', '67307', '10.0.0.23', '2017-01-14 02:18:03');
INSERT INTO `sys_log` VALUES ('1832', '13500000000', null, 'update操作', '64891', '10.0.0.23', '2017-01-14 02:46:58');
INSERT INTO `sys_log` VALUES ('1833', '13500000000', null, 'update操作', '20073', '10.0.0.23', '2017-01-14 02:49:06');
INSERT INTO `sys_log` VALUES ('1834', '13500000000', null, 'update操作', '140', '10.0.0.23', '2017-01-14 02:50:05');
INSERT INTO `sys_log` VALUES ('1835', '13500000000', null, 'update操作', '131', '10.0.0.23', '2017-01-14 02:55:50');
INSERT INTO `sys_log` VALUES ('1836', '13500000000', null, 'update操作', '115', '10.0.0.23', '2017-01-14 02:56:18');
INSERT INTO `sys_log` VALUES ('1837', '13500000000', null, 'update操作', '91', '10.0.0.23', '2017-01-14 03:03:24');
INSERT INTO `sys_log` VALUES ('1838', 'admin', '资源管理', 'save操作', '7', '10.0.0.19', '2017-01-14 03:12:01');
INSERT INTO `sys_log` VALUES ('1839', 'admin', '资源管理', 'update角色的权限', '74', '10.0.0.23', '2017-01-14 03:12:37');
INSERT INTO `sys_log` VALUES ('1840', '13500000000', null, 'update操作', '113', '10.0.0.23', '2017-01-14 03:27:45');
INSERT INTO `sys_log` VALUES ('1841', '13500000000', null, 'update操作', '127', '10.0.0.23', '2017-01-14 03:37:43');
INSERT INTO `sys_log` VALUES ('1842', '13500000000', null, 'update操作', '96', '10.0.0.23', '2017-01-14 03:45:38');
INSERT INTO `sys_log` VALUES ('1843', '13700000001', null, 'update操作', '125', '10.0.0.23', '2017-01-14 04:05:51');
INSERT INTO `sys_log` VALUES ('1844', 'admin', '资源管理', 'delete操作', '13', '10.0.0.23', '2017-01-14 04:21:25');
INSERT INTO `sys_log` VALUES ('1845', 'admin', '资源管理', 'save操作', '21', '10.0.0.23', '2017-01-14 04:23:45');
INSERT INTO `sys_log` VALUES ('1846', 'admin', '资源管理', 'update角色的权限', '50', '10.0.0.23', '2017-01-14 04:25:18');
INSERT INTO `sys_log` VALUES ('1847', 'admin', '资源管理', 'update角色的权限', '162', '10.0.0.23', '2017-01-14 04:25:25');
INSERT INTO `sys_log` VALUES ('1848', 'admin', '资源管理', 'update操作', '8', '10.0.0.23', '2017-01-14 04:27:15');
INSERT INTO `sys_log` VALUES ('1849', 'admin', '资源管理', 'update角色的权限', '58', '10.0.0.23', '2017-01-14 04:27:35');
INSERT INTO `sys_log` VALUES ('1850', 'admin', '资源管理', 'update角色的权限', '101', '10.0.0.23', '2017-01-14 04:55:01');
INSERT INTO `sys_log` VALUES ('1851', null, null, 'save操作', '751', '10.0.0.19', '2017-01-14 04:55:05');
INSERT INTO `sys_log` VALUES ('1852', 'admin', '资源管理', 'update角色的权限', '47', '10.0.0.23', '2017-01-14 04:57:58');
INSERT INTO `sys_log` VALUES ('1853', null, null, 'save操作', '710', '10.0.0.19', '2017-01-14 05:05:56');
INSERT INTO `sys_log` VALUES ('1854', null, null, 'save操作', '225', '10.0.0.19', '2017-01-14 05:06:56');
INSERT INTO `sys_log` VALUES ('1855', null, null, 'save操作', '269', '10.0.0.19', '2017-01-14 05:07:15');
INSERT INTO `sys_log` VALUES ('1856', null, null, 'save操作', '276', '10.0.0.19', '2017-01-14 05:08:00');
INSERT INTO `sys_log` VALUES ('1857', null, null, 'save操作', '247', '10.0.0.19', '2017-01-14 05:10:23');
INSERT INTO `sys_log` VALUES ('1858', null, null, 'save操作', '812', '10.0.0.19', '2017-01-14 05:13:53');
INSERT INTO `sys_log` VALUES ('1859', null, null, 'save操作', '303', '10.0.0.19', '2017-01-14 05:14:44');
INSERT INTO `sys_log` VALUES ('1860', null, null, 'save操作', '817', '10.0.0.19', '2017-01-14 05:28:27');
INSERT INTO `sys_log` VALUES ('1861', 'admin', '资源管理', 'save操作', '16', '192.168.209.1', '2017-01-15 20:31:58');
INSERT INTO `sys_log` VALUES ('1862', 'admin', '资源管理', 'delete操作', '16', '192.168.209.1', '2017-01-15 20:35:41');
INSERT INTO `sys_log` VALUES ('1863', '13356561234', null, 'update操作', '175', '10.0.0.23', '2017-01-16 01:06:18');
INSERT INTO `sys_log` VALUES ('1864', null, null, 'save操作', '133', '10.0.0.23', '2017-01-16 01:13:40');
INSERT INTO `sys_log` VALUES ('1865', null, null, 'save操作', '180', '10.0.0.23', '2017-01-16 01:19:40');
INSERT INTO `sys_log` VALUES ('1866', '13500000000', null, 'update操作', '250', '192.168.209.1', '2017-01-16 01:23:08');
INSERT INTO `sys_log` VALUES ('1867', '13500000000', null, 'update操作', '124', '192.168.209.1', '2017-01-16 01:24:35');
INSERT INTO `sys_log` VALUES ('1868', '13500000000', null, 'update操作', '93', '192.168.209.1', '2017-01-16 01:24:35');
INSERT INTO `sys_log` VALUES ('1869', 'admin', '用户管理', 'save操作', '118', '192.168.56.1', '2017-01-16 01:48:14');
INSERT INTO `sys_log` VALUES ('1870', 'admin', '用户管理', 'update操作', '56', '192.168.56.1', '2017-01-16 01:48:35');
INSERT INTO `sys_log` VALUES ('1871', 'admin', '用户管理', 'delete操作', '17', '192.168.56.1', '2017-01-16 01:50:49');
INSERT INTO `sys_log` VALUES ('1872', 'admin', '用户管理', 'save操作', '16', '192.168.56.1', '2017-01-16 01:51:36');
INSERT INTO `sys_log` VALUES ('1873', 'admin', '用户管理', 'update操作', '26', '192.168.56.1', '2017-01-16 01:52:01');
INSERT INTO `sys_log` VALUES ('1874', 'admin', '用户管理', 'update操作', '14', '192.168.56.1', '2017-01-16 01:53:48');
INSERT INTO `sys_log` VALUES ('1875', '13356561233', null, 'update操作', '111', '10.0.0.231', '2017-01-16 03:26:22');
INSERT INTO `sys_log` VALUES ('1876', '13356561233', null, 'update操作', '3146', '10.0.0.23', '2017-01-16 03:27:30');
INSERT INTO `sys_log` VALUES ('1877', '13356561233', null, 'update操作', '92', '10.0.0.23', '2017-01-16 03:28:22');
INSERT INTO `sys_log` VALUES ('1878', null, null, 'save操作', '139', '10.0.0.23', '2017-01-16 03:28:57');
INSERT INTO `sys_log` VALUES ('1879', '13356561233', null, 'update操作', '87', '10.0.0.23', '2017-01-16 03:39:10');
INSERT INTO `sys_log` VALUES ('1880', '13356561233', null, 'update操作', '122', '10.0.0.23', '2017-01-16 03:39:24');
INSERT INTO `sys_log` VALUES ('1881', '13356561233', null, 'update操作', '100', '10.0.0.23', '2017-01-16 03:46:16');
INSERT INTO `sys_log` VALUES ('1882', '13356561233', null, 'update操作', '94', '10.0.0.23', '2017-01-16 03:47:57');
INSERT INTO `sys_log` VALUES ('1883', '13356561233', null, 'update操作', '114', '10.0.0.23', '2017-01-16 03:53:26');
INSERT INTO `sys_log` VALUES ('1884', '13356561233', null, 'update操作', '116', '10.0.0.23', '2017-01-16 03:58:07');
INSERT INTO `sys_log` VALUES ('1885', '13356561233', null, 'update操作', '92', '10.0.0.23', '2017-01-16 03:58:23');
INSERT INTO `sys_log` VALUES ('1886', '13356561233', null, 'update操作', '81', '10.0.0.23', '2017-01-16 04:11:44');
INSERT INTO `sys_log` VALUES ('1887', '13356561233', null, 'update操作', '86', '10.0.0.23', '2017-01-16 04:12:45');
INSERT INTO `sys_log` VALUES ('1888', '13356561233', null, 'update操作', '89', '10.0.0.23', '2017-01-16 04:17:21');
INSERT INTO `sys_log` VALUES ('1889', '13356561233', null, 'update操作', '72', '10.0.0.23', '2017-01-16 04:26:44');
INSERT INTO `sys_log` VALUES ('1890', '13356561233', null, 'update操作', '136', '10.0.0.23', '2017-01-16 04:27:26');
INSERT INTO `sys_log` VALUES ('1891', '13356561233', null, 'update操作', '71', '10.0.0.231', '2017-01-16 04:44:17');
INSERT INTO `sys_log` VALUES ('1892', '13356561233', null, 'update操作', '83', '10.0.0.231', '2017-01-16 04:44:21');
INSERT INTO `sys_log` VALUES ('1893', '13356561233', null, 'update操作', '170', '10.0.0.231', '2017-01-16 04:44:32');
INSERT INTO `sys_log` VALUES ('1894', '13356561233', null, 'update操作', '85', '10.0.0.231', '2017-01-16 04:44:43');
INSERT INTO `sys_log` VALUES ('1895', '13356561233', null, 'update操作', '168', '10.0.0.23', '2017-01-16 04:45:41');
INSERT INTO `sys_log` VALUES ('1896', '13356561233', null, 'update操作', '95', '10.0.0.23', '2017-01-16 04:50:38');
INSERT INTO `sys_log` VALUES ('1897', '13356561233', null, 'update操作', '96', '10.0.0.23', '2017-01-16 04:51:00');
INSERT INTO `sys_log` VALUES ('1898', '13356561233', null, 'update操作', '106', '10.0.0.23', '2017-01-16 04:52:07');
INSERT INTO `sys_log` VALUES ('1899', '13356561233', null, 'update操作', '106', '10.0.0.23', '2017-01-16 05:10:52');
INSERT INTO `sys_log` VALUES ('1900', '13356561233', null, 'update操作', '90', '10.0.0.23', '2017-01-16 05:13:10');
INSERT INTO `sys_log` VALUES ('1901', '13356561233', null, 'update操作', '106', '10.0.0.23', '2017-01-16 05:13:16');
INSERT INTO `sys_log` VALUES ('1902', '13356561233', null, 'update操作', '114', '10.0.0.23', '2017-01-16 05:13:26');

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单id',
  `resKey` varchar(50) DEFAULT NULL COMMENT '资源KEY',
  `type` varchar(10) DEFAULT NULL COMMENT '类型：0目录1菜单2按钮',
  `resUrl` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `level` int(11) DEFAULT NULL COMMENT '优先级：目录使用',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `order_by` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------
INSERT INTO `sys_resources` VALUES ('1', '用户管理', '57', 'sys_user', '0', 'user', null, '用户管理', null);
INSERT INTO `sys_resources` VALUES ('2', '用户列表', '1', 'sys_user_find', '1', '/background/system/user/query.html', null, '查询用户', null);
INSERT INTO `sys_resources` VALUES ('3', '新增用户', '1', 'sys_user_addUI', '2', '/background/system/user/addUI.html', null, '新增用户', null);
INSERT INTO `sys_resources` VALUES ('4', '角色管理', '57', 'sys_role', '0', 'role', null, '角色管理', null);
INSERT INTO `sys_resources` VALUES ('5', '角色列表', '4', 'sys_role_find', '1', '/background/system/role/query.html', null, '角色列表', null);
INSERT INTO `sys_resources` VALUES ('6', '资源管理', '57', 'sys_resc', '0', 'resc', null, '资源管理', null);
INSERT INTO `sys_resources` VALUES ('7', '资源列表', '6', 'sys_resc_find', '1', '/background/system/resources/query.html', null, '资源列表', null);
INSERT INTO `sys_resources` VALUES ('8', '添加资源', '6', 'sys_resc_addUI', '2', '/background/system/resources/addUI.html', null, '添加资源', null);
INSERT INTO `sys_resources` VALUES ('11', '新增角色', '4', 'sys_role_add', '2', '/background/system/role/addUI.html', null, '新增角色', null);
INSERT INTO `sys_resources` VALUES ('41', '分配角色', '2', 'sys_user_fenpeirole', '2', 'sys_user_fenpeirole', null, '分配角色', null);
INSERT INTO `sys_resources` VALUES ('42', '分配权限', '2', 'sys_user_permissions', '2', 'sys_user_permissions', null, '分配权限', null);
INSERT INTO `sys_resources` VALUES ('43', '编辑用户', '2', 'sys_user_edit', '2', '/background/system/user/getById.html', null, '编辑', null);
INSERT INTO `sys_resources` VALUES ('44', '删除用户', '2', 'sys_user_delete', '2', '/background/system/user/deleteById.html', null, '删除用户', null);
INSERT INTO `sys_resources` VALUES ('45', '分配权限', '5', 'sys_role_permissions', '2', 'sys_role_permissions', null, '分配权限', null);
INSERT INTO `sys_resources` VALUES ('46', '显示详细信息', '5', 'sys_role_show', '2', 'sys_role_show', null, '显示详细信息', null);
INSERT INTO `sys_resources` VALUES ('47', '编辑角色', '5', 'sys_role_edit', '2', '/background/system/role/getById.html', null, '编辑角色', null);
INSERT INTO `sys_resources` VALUES ('48', '删除角色', '5', 'sys_role_delete', '2', '/background/system/role/deleteById.html', null, '删除角色', null);
INSERT INTO `sys_resources` VALUES ('49', '显示详细信息', '7', 'sys_res_show', '2', 'sys_res_show', null, '显示详细信息', null);
INSERT INTO `sys_resources` VALUES ('50', '编辑权限资源', '7', 'sys_res_edit', '2', '/background/system/resources/getById.html', null, '编辑权限资源', null);
INSERT INTO `sys_resources` VALUES ('51', '删除权限资源', '7', 'sys_res_delete', '2', '/background/system/resources/deleteById.html', null, '删除权限资源', null);
INSERT INTO `sys_resources` VALUES ('57', '系统管理', '1010', 'sys', '0', 'sys', '5', '系统管理', null);
INSERT INTO `sys_resources` VALUES ('102', '初始化密码', '2', 'sys_user_reset', '2', '/background/system/user/reset.html', null, '', null);
INSERT INTO `sys_resources` VALUES ('104', '业务办理', '1010', 'business', '0', 'business', '1', '', null);
INSERT INTO `sys_resources` VALUES ('105', '业务列表', '104', 'x', '0', 'x', null, '', null);
INSERT INTO `sys_resources` VALUES ('107', '实名认证', '105', 'Authentication', '1', '/background/business/authentication/authentication.html', null, '', '1');
INSERT INTO `sys_resources` VALUES ('110', '订单列表', '105', 'orderlist', '1', '/background/system/order/gotoOrderList.html', null, '', '4');
INSERT INTO `sys_resources` VALUES ('111', '联系人信息', '105', 'biz_linkPeople', '1', '/biz/bussiness/linkpeople/queryLinkPeople.html', null, '', '3');
INSERT INTO `sys_resources` VALUES ('112', '支付密码', '105', 'payPassword', '1', '/background/system/paypassword/payPassword.html', null, '', '2');
INSERT INTO `sys_resources` VALUES ('113', '新增', '111', 'link', '2', '/biz/bussiness/linkpeople/addLinkpeople.html', null, '', null);

-- ----------------------------
-- Table structure for sys_resources_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources_role`;
CREATE TABLE `sys_resources_role` (
  `resc_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`resc_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resources_role
-- ----------------------------
INSERT INTO `sys_resources_role` VALUES ('1', '1');
INSERT INTO `sys_resources_role` VALUES ('2', '1');
INSERT INTO `sys_resources_role` VALUES ('3', '1');
INSERT INTO `sys_resources_role` VALUES ('4', '1');
INSERT INTO `sys_resources_role` VALUES ('5', '1');
INSERT INTO `sys_resources_role` VALUES ('6', '1');
INSERT INTO `sys_resources_role` VALUES ('7', '1');
INSERT INTO `sys_resources_role` VALUES ('8', '1');
INSERT INTO `sys_resources_role` VALUES ('11', '1');
INSERT INTO `sys_resources_role` VALUES ('41', '1');
INSERT INTO `sys_resources_role` VALUES ('42', '1');
INSERT INTO `sys_resources_role` VALUES ('43', '1');
INSERT INTO `sys_resources_role` VALUES ('44', '1');
INSERT INTO `sys_resources_role` VALUES ('45', '1');
INSERT INTO `sys_resources_role` VALUES ('46', '1');
INSERT INTO `sys_resources_role` VALUES ('47', '1');
INSERT INTO `sys_resources_role` VALUES ('48', '1');
INSERT INTO `sys_resources_role` VALUES ('49', '1');
INSERT INTO `sys_resources_role` VALUES ('50', '1');
INSERT INTO `sys_resources_role` VALUES ('51', '1');
INSERT INTO `sys_resources_role` VALUES ('57', '1');
INSERT INTO `sys_resources_role` VALUES ('102', '1');
INSERT INTO `sys_resources_role` VALUES ('104', '1');
INSERT INTO `sys_resources_role` VALUES ('104', '2');
INSERT INTO `sys_resources_role` VALUES ('105', '1');
INSERT INTO `sys_resources_role` VALUES ('105', '2');
INSERT INTO `sys_resources_role` VALUES ('107', '1');
INSERT INTO `sys_resources_role` VALUES ('107', '2');
INSERT INTO `sys_resources_role` VALUES ('110', '1');
INSERT INTO `sys_resources_role` VALUES ('110', '2');
INSERT INTO `sys_resources_role` VALUES ('111', '1');
INSERT INTO `sys_resources_role` VALUES ('111', '2');
INSERT INTO `sys_resources_role` VALUES ('112', '1');
INSERT INTO `sys_resources_role` VALUES ('112', '2');
INSERT INTO `sys_resources_role` VALUES ('113', '1');
INSERT INTO `sys_resources_role` VALUES ('113', '2');
INSERT INTO `sys_resources_role` VALUES ('114', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `roleKey` varchar(50) DEFAULT NULL COMMENT '角色KEY',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `enable` int(11) DEFAULT NULL COMMENT '是否启用：0禁用1启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'ROLE_USER', '用户角色', '1');
INSERT INTO `sys_role` VALUES ('2', '客户', 'cust', '客户角色', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL COMMENT '登录名',
  `userPassword` varchar(40) DEFAULT NULL COMMENT '密码',
  `userNickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `userRealname` varchar(20) DEFAULT NULL COMMENT '真实名',
  `userAge` int(11) DEFAULT NULL COMMENT '年龄',
  `userSex` varchar(10) DEFAULT NULL COMMENT '性别',
  `userAddress` varchar(100) DEFAULT NULL COMMENT '地址',
  `userPhone` varchar(30) DEFAULT NULL COMMENT '电话',
  `userMail` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `userQQ` varchar(30) DEFAULT NULL COMMENT 'qq',
  `regTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `lastLogintime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后登录时间',
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `mark` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `parentNumber` varchar(100) DEFAULT NULL COMMENT '上级代理用户编号',
  `style` varchar(2) DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'ISMvKXpXpadDiUoOSoAfww==', 'admin1', 'admin1', '10', '男', '枯霜下要孤', '0253526', 'jnfjfjj@163.com', '1111111', '2014-08-08 18:14:28', '0000-00-00 00:00:00', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('73', '13500000000', 'JfnnlDI7RTiF9RgfG2JNCw==', '欧欧欧', '欧欧欧', '5', 'M', '车陂高地大街吉星里', '13500000000', '222@qq.com', '13500000000', '2017-01-14 13:08:22', '2017-01-16 16:05:30', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('74', '13700000001', 'JP6aGibjAHl3tvXqvdZK+g==', '欧小欧', '欧小欧', '4', 'M', '顿饭复旦复华', '13700000001', '12@163.com', '13700000001', '2017-01-13 16:50:35', '2017-01-16 17:51:05', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('75', '13700000003', '7s053ju0IqH+xhrxBUzIIA==', 'null', 'null', '0', 'null', 'null', '13700000003', 'null', '13700000003', '2017-01-13 17:41:06', '2017-01-16 15:34:37', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('76', '13700000004', 'M0E5ZHxKFDhZ4a2Hip7Gig==', 'null', 'null', '0', 'null', 'null', '13700000004', 'null', '13700000004', '2017-01-13 17:54:19', '2017-01-13 04:53:52', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('77', '13356561234', 'nkM9T9A4mHgeHZAUshgTsQ==', '弘贝lx', '弘贝lx', '12', 'M', '广州市天和去高地大街吉星里9号6楼', '13356561234', '111@qq.com', '13356561234', '2017-01-14 13:10:56', '2017-01-16 03:03:15', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('79', '弘贝1', '4QrcOUm6Wau+VuBX8g+IPg==', 'null', 'null', '0', 'null', 'null', '13621111111', 'null', '11111111', '2017-01-16 01:51:36', '2017-01-16 02:10:21', null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('80', '13356561236', '4QrcOUm6Wau+VuBX8g+IPg==', 'null', 'null', '0', 'null', 'null', '13356561236', 'null', '13356561236', '2017-01-16 02:10:51', '2017-01-16 02:42:19', '1', '', null, null, '1');
INSERT INTO `sys_user` VALUES ('81', '13356561233', 'xi2Snnt+e2Flkjpd/GDLVg==', '弘小贝', '弘小贝', '12', 'M', '广州市天河区高地大街吉星里9号6楼', '13356561233', '112@qq.com', '13356561233', '2017-01-16 02:11:52', '2017-01-16 18:35:00', '1', '', null, null, '1');

-- ----------------------------
-- Table structure for sys_userloginlist
-- ----------------------------
DROP TABLE IF EXISTS `sys_userloginlist`;
CREATE TABLE `sys_userloginlist` (
  `loginId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `loginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `loginIP` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`loginId`),
  KEY `FK_userloginlist` (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=149000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_userloginlist
-- ----------------------------
INSERT INTO `sys_userloginlist` VALUES ('148665', '1', '2014-10-22 14:39:08', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148666', '1', '2014-10-22 14:39:44', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148667', '1', '2014-10-22 14:40:32', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148668', '5', '2014-10-22 14:42:18', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148669', '4', '2014-10-22 14:43:24', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148670', '1', '2014-10-22 15:03:39', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148671', '1', '2014-10-22 16:04:54', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148672', '1', '2014-10-22 16:24:35', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148673', '1', '2014-10-22 16:40:19', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148674', '1', '2014-10-22 16:54:54', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148675', '1', '2015-03-04 10:41:36', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148676', '1', '2015-03-26 11:50:54', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148677', '1', '2015-03-26 13:25:34', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148678', '1', '2015-03-26 14:11:44', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148679', '1', '2015-03-30 15:58:25', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148680', '1', '2015-03-30 18:38:09', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148681', '1', '2015-03-30 20:42:05', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148682', '1', '2015-03-30 20:51:36', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148683', '1', '2015-03-30 20:54:46', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148684', '1', '2017-01-11 15:16:16', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148685', '1', '2017-01-11 15:36:15', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148686', '1', '2017-01-11 16:14:10', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148687', '1', '2017-01-11 16:16:54', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148688', '1', '2017-01-11 16:26:50', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148689', '1', '2017-01-11 16:37:38', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148690', '1', '2017-01-11 16:55:44', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148691', '1', '2017-01-11 17:34:18', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148692', '1', '2017-01-12 10:07:28', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148693', '1', '2017-01-12 10:18:47', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148694', '1', '2017-01-12 10:21:37', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148695', '1', '2017-01-12 10:29:29', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148696', '1', '2017-01-12 11:43:43', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148697', '1', '2017-01-12 14:09:29', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148698', '1', '2017-01-12 14:44:46', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148699', '1', '2017-01-12 14:44:47', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148700', '1', '2017-01-12 14:45:22', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148701', '1', '2017-01-12 14:46:59', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148702', '1', '2017-01-12 14:50:14', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148703', '1', '2017-01-12 14:56:17', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148704', '1', '2017-01-12 14:56:23', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148705', '1', '2017-01-12 15:51:56', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148706', '1', '2017-01-12 04:43:36', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148707', '1', '2017-01-12 22:29:25', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148708', '2', '2017-01-13 00:11:14', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148709', '2', '2017-01-13 00:13:37', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148710', '0', '2017-01-13 00:14:49', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148711', '2', '2017-01-13 00:16:02', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148712', '2', '2017-01-13 00:20:30', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148713', '1', '2017-01-13 02:16:20', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148714', '1', '2017-01-13 02:21:12', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148715', '1', '2017-01-13 02:44:08', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148716', '1', '2017-01-13 02:47:38', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148717', '1', '2017-01-13 02:49:24', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148718', '1', '2017-01-13 02:50:22', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148719', '1', '2017-01-13 02:51:47', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148720', '1', '2017-01-13 02:55:41', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148721', '1', '2017-01-13 03:02:37', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148722', '1', '2017-01-13 03:10:25', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148723', '1', '2017-01-13 03:18:50', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148724', '1', '2017-01-13 03:49:01', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148725', '74', '2017-01-13 03:50:35', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148726', '74', '2017-01-13 04:02:23', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148727', '1', '2017-01-13 04:04:04', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148728', '74', '2017-01-13 04:07:12', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148729', '1', '2017-01-13 04:07:35', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148730', '74', '2017-01-13 04:12:33', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148731', '1', '2017-01-13 04:12:39', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148732', '74', '2017-01-13 04:14:23', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148733', '74', '2017-01-13 04:22:50', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148734', '1', '2017-01-13 04:23:51', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148735', '1', '2017-01-13 04:24:05', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148736', '1', '2017-01-13 04:32:39', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148737', '74', '2017-01-13 04:37:05', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148738', '1', '2017-01-13 04:38:17', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148739', '74', '2017-01-13 04:38:33', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148740', '75', '2017-01-13 04:41:06', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148741', '75', '2017-01-13 04:41:57', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148742', '74', '2017-01-13 04:42:15', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148743', '1', '2017-01-13 04:43:27', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148744', '74', '2017-01-13 04:47:59', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148745', '1', '2017-01-13 04:49:56', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148746', '1', '2017-01-13 04:49:57', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148747', '74', '2017-01-13 04:50:24', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148748', '74', '2017-01-13 04:50:46', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148749', '74', '2017-01-13 04:50:49', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148750', '1', '2017-01-13 04:52:56', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148751', '74', '2017-01-13 04:53:15', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148752', '76', '2017-01-13 04:54:19', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148753', '1', '2017-01-13 05:01:18', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148754', '75', '2017-01-13 05:10:37', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148755', '1', '2017-01-13 05:12:13', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148756', '1', '2017-01-13 05:25:39', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148757', '74', '2017-01-13 05:33:19', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148758', '1', '2017-01-13 05:36:37', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148759', '1', '2017-01-13 05:40:14', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148760', '74', '2017-01-13 05:42:47', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148761', '1', '2017-01-13 05:50:13', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148762', '1', '2017-01-13 06:00:14', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148763', '1', '2017-01-13 06:28:34', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148764', '1', '2017-01-13 06:32:46', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148765', '1', '2017-01-13 21:24:34', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148766', '1', '2017-01-13 21:28:13', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148767', '74', '2017-01-13 21:30:46', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148768', '74', '2017-01-13 21:31:11', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148769', '1', '2017-01-13 21:36:48', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148770', '74', '2017-01-13 21:39:13', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148771', '74', '2017-01-13 21:40:14', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148772', '1', '2017-01-13 21:40:50', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148773', '74', '2017-01-13 21:43:23', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148774', '74', '2017-01-13 21:43:51', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148775', '1', '2017-01-13 21:46:02', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148776', '74', '2017-01-13 21:53:17', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148777', '74', '2017-01-13 21:54:41', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148778', '74', '2017-01-13 22:00:59', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148779', '1', '2017-01-13 22:06:42', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148780', '74', '2017-01-13 22:07:07', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148781', '74', '2017-01-13 22:10:41', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148782', '1', '2017-01-13 22:11:13', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148783', '74', '2017-01-13 22:20:42', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148784', '1', '2017-01-13 22:29:01', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148785', '74', '2017-01-13 22:40:36', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148786', '74', '2017-01-13 22:43:24', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148787', '74', '2017-01-13 22:45:30', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148788', '74', '2017-01-13 22:53:04', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148789', '1', '2017-01-13 22:53:21', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148790', '74', '2017-01-13 22:55:01', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148791', '74', '2017-01-13 22:58:03', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148792', '1', '2017-01-13 23:02:54', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148793', '1', '2017-01-13 23:11:07', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148794', '74', '2017-01-13 23:11:40', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148795', '1', '2017-01-13 23:17:41', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148796', '1', '2017-01-13 23:21:17', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148797', '74', '2017-01-13 23:23:01', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148798', '74', '2017-01-13 23:25:09', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148799', '74', '2017-01-13 23:30:34', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148800', '74', '2017-01-13 23:48:16', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148801', '1', '2017-01-13 23:58:41', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148802', '74', '2017-01-14 00:05:28', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148803', '73', '2017-01-14 00:08:16', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148804', '74', '2017-01-14 00:09:43', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148805', '1', '2017-01-14 00:10:04', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148806', '77', '2017-01-14 00:11:02', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148807', '1', '2017-01-14 00:14:27', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148808', '73', '2017-01-14 00:16:29', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148809', '1', '2017-01-14 00:17:07', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148810', '74', '2017-01-14 00:19:15', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148811', '74', '2017-01-14 00:19:15', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148812', '1', '2017-01-14 00:31:53', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148813', '1', '2017-01-14 00:39:11', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148814', '73', '2017-01-14 00:39:25', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148815', '1', '2017-01-14 00:41:54', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148816', '73', '2017-01-14 01:03:39', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148817', '1', '2017-01-14 01:08:11', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148818', '1', '2017-01-14 01:14:00', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148819', '74', '2017-01-14 01:18:22', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148820', '1', '2017-01-14 01:38:44', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148821', '74', '2017-01-14 01:59:09', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148822', '73', '2017-01-14 02:15:15', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148823', '74', '2017-01-14 02:15:18', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148824', '74', '2017-01-14 02:19:01', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148825', '1', '2017-01-14 02:19:10', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148826', '1', '2017-01-14 02:20:30', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148827', '74', '2017-01-14 02:22:08', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148828', '1', '2017-01-14 02:23:59', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148829', '74', '2017-01-14 02:24:13', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148830', '74', '2017-01-14 02:27:02', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148831', '1', '2017-01-14 02:28:55', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148832', '74', '2017-01-14 02:32:51', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148833', '1', '2017-01-14 02:34:46', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148834', '74', '2017-01-14 02:35:53', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148835', '1', '2017-01-14 02:36:05', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148836', '74', '2017-01-14 02:36:34', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148837', '73', '2017-01-14 02:39:34', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148838', '73', '2017-01-14 02:39:39', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148839', '74', '2017-01-14 02:40:33', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148840', '74', '2017-01-14 02:42:24', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148841', '73', '2017-01-14 02:43:16', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148842', '1', '2017-01-14 02:44:51', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148843', '73', '2017-01-14 02:45:45', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148844', '1', '2017-01-14 02:46:23', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148845', '74', '2017-01-14 02:46:50', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148846', '1', '2017-01-14 02:52:31', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148847', '1', '2017-01-14 02:55:53', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148848', '74', '2017-01-14 02:58:15', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148849', '1', '2017-01-14 03:04:49', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148850', '1', '2017-01-14 03:11:05', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148851', '74', '2017-01-14 03:12:42', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148852', '74', '2017-01-14 03:12:54', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148853', '74', '2017-01-14 03:13:54', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148854', '1', '2017-01-14 03:15:30', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148855', '74', '2017-01-14 03:16:05', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148856', '73', '2017-01-14 03:16:53', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148857', '1', '2017-01-14 03:19:26', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148858', '74', '2017-01-14 03:26:35', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148859', '1', '2017-01-14 03:31:05', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148860', '1', '2017-01-14 03:33:58', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148861', '1', '2017-01-14 03:36:55', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148862', '1', '2017-01-14 03:46:55', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148863', '1', '2017-01-14 03:48:22', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148864', '1', '2017-01-14 03:49:04', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148865', '73', '2017-01-14 04:03:11', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148866', '74', '2017-01-14 04:04:17', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148867', '1', '2017-01-14 04:04:27', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148868', '1', '2017-01-14 04:05:45', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148869', '1', '2017-01-14 04:07:50', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148870', '1', '2017-01-14 04:08:45', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148871', '1', '2017-01-14 04:21:12', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148872', '73', '2017-01-14 04:21:53', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148873', '74', '2017-01-14 04:22:40', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148874', '1', '2017-01-14 04:22:50', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148875', '75', '2017-01-14 04:23:14', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148876', '1', '2017-01-14 04:24:27', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148877', '1', '2017-01-14 04:25:33', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148878', '73', '2017-01-14 04:25:49', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148879', '1', '2017-01-14 04:26:08', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148880', '1', '2017-01-14 04:26:28', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148881', '75', '2017-01-14 04:26:30', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148882', '73', '2017-01-14 04:27:47', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148883', '75', '2017-01-14 04:29:12', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148884', '1', '2017-01-14 04:31:28', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148885', '73', '2017-01-14 04:32:01', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148886', '1', '2017-01-14 04:47:36', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148887', '73', '2017-01-14 04:48:08', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148888', '1', '2017-01-14 04:50:42', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148889', '1', '2017-01-14 04:50:50', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148890', '1', '2017-01-14 04:50:51', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148891', '73', '2017-01-14 04:51:28', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148892', '73', '2017-01-14 04:53:37', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148893', '74', '2017-01-14 04:53:45', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148894', '1', '2017-01-14 04:54:16', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148895', '73', '2017-01-14 04:57:30', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148896', '1', '2017-01-14 04:57:49', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148897', '73', '2017-01-14 04:58:10', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148898', '1', '2017-01-14 05:00:41', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148899', '73', '2017-01-14 05:01:07', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148900', '74', '2017-01-14 05:03:02', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148901', '1', '2017-01-14 05:20:09', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148902', '74', '2017-01-14 05:25:38', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148903', '73', '2017-01-14 05:34:28', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148904', '73', '2017-01-14 05:36:49', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148905', '73', '2017-01-14 05:45:26', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148906', '1', '2017-01-14 05:46:17', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148907', '73', '2017-01-14 05:47:05', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148908', '73', '2017-01-14 05:47:41', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148909', '73', '2017-01-14 05:50:02', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148910', '1', '2017-01-14 05:51:11', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148911', '73', '2017-01-14 05:55:32', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148912', '74', '2017-01-14 06:05:10', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148913', '1', '2017-01-14 06:21:03', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148914', '1', '2017-01-14 06:36:33', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148915', '73', '2017-01-14 06:37:01', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148916', '73', '2017-01-14 07:08:55', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148917', '73', '2017-01-14 07:16:40', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148918', '73', '2017-01-15 19:55:46', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148919', '1', '2017-01-15 20:11:14', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148920', '73', '2017-01-15 20:15:18', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148921', '1', '2017-01-15 20:25:04', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148922', '73', '2017-01-15 20:26:32', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148923', '74', '2017-01-15 20:28:11', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148924', '73', '2017-01-15 20:29:36', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148925', '1', '2017-01-15 20:30:08', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148926', '73', '2017-01-15 20:31:04', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148927', '1', '2017-01-15 20:32:42', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148928', '73', '2017-01-15 20:36:08', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148929', '73', '2017-01-15 20:59:31', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148930', '74', '2017-01-15 21:11:38', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148931', '73', '2017-01-15 21:43:26', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148932', '73', '2017-01-15 21:51:21', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148933', '73', '2017-01-15 23:59:07', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148934', '73', '2017-01-16 00:03:30', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148935', '74', '2017-01-16 00:03:33', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148936', '73', '2017-01-16 00:10:18', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148937', '74', '2017-01-16 00:40:09', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148938', '74', '2017-01-16 00:40:12', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148939', '73', '2017-01-16 01:00:40', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148940', '77', '2017-01-16 01:02:05', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148941', '77', '2017-01-16 01:02:05', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148942', '77', '2017-01-16 01:04:15', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148943', '1', '2017-01-16 01:07:20', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148944', '1', '2017-01-16 01:16:46', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148945', '1', '2017-01-16 01:19:09', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148946', '73', '2017-01-16 01:22:02', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148947', '1', '2017-01-16 01:22:35', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148948', '1', '2017-01-16 01:26:17', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148949', '1', '2017-01-16 01:27:40', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148950', '74', '2017-01-16 01:40:16', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148951', '74', '2017-01-16 01:41:50', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148952', '74', '2017-01-16 01:43:11', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148953', '74', '2017-01-16 01:44:30', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148954', '1', '2017-01-16 01:46:06', '192.168.56.1');
INSERT INTO `sys_userloginlist` VALUES ('148955', '1', '2017-01-16 01:50:36', '192.168.56.1');
INSERT INTO `sys_userloginlist` VALUES ('148956', '1', '2017-01-16 01:50:37', '192.168.56.1');
INSERT INTO `sys_userloginlist` VALUES ('148957', '1', '2017-01-16 01:52:39', '192.168.56.1');
INSERT INTO `sys_userloginlist` VALUES ('148958', '74', '2017-01-16 01:53:13', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148959', '1', '2017-01-16 01:54:09', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148960', '77', '2017-01-16 02:03:52', '10.0.0.23');
INSERT INTO `sys_userloginlist` VALUES ('148961', '1', '2017-01-16 02:09:50', '10.0.0.19');
INSERT INTO `sys_userloginlist` VALUES ('148962', '74', '2017-01-16 02:10:48', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148963', '80', '2017-01-16 02:10:51', '10.0.0.2');
INSERT INTO `sys_userloginlist` VALUES ('148964', '81', '2017-01-16 02:11:52', '10.0.0.15');
INSERT INTO `sys_userloginlist` VALUES ('148965', '80', '2017-01-16 02:12:20', '10.0.0.2');
INSERT INTO `sys_userloginlist` VALUES ('148966', '73', '2017-01-16 02:14:28', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148967', '1', '2017-01-16 02:15:40', '10.0.0.13');
INSERT INTO `sys_userloginlist` VALUES ('148968', '74', '2017-01-16 02:20:04', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148969', '75', '2017-01-16 02:23:23', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148970', '75', '2017-01-16 02:24:38', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148971', '75', '2017-01-16 02:26:20', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148972', '75', '2017-01-16 02:29:49', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148973', '75', '2017-01-16 02:34:38', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148974', '73', '2017-01-16 02:35:02', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148975', '73', '2017-01-16 02:38:05', '10.0.0.23');
INSERT INTO `sys_userloginlist` VALUES ('148976', '1', '2017-01-16 02:39:04', '10.0.0.19');
INSERT INTO `sys_userloginlist` VALUES ('148977', '81', '2017-01-16 02:40:06', '10.0.0.15');
INSERT INTO `sys_userloginlist` VALUES ('148978', '80', '2017-01-16 02:42:19', '10.0.0.2');
INSERT INTO `sys_userloginlist` VALUES ('148979', '1', '2017-01-16 02:46:32', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148980', '74', '2017-01-16 02:47:41', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148981', '77', '2017-01-16 03:03:15', '10.0.0.23');
INSERT INTO `sys_userloginlist` VALUES ('148982', '73', '2017-01-16 03:05:10', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148983', '1', '2017-01-16 03:19:34', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148984', '1', '2017-01-16 03:22:33', '192.168.56.1');
INSERT INTO `sys_userloginlist` VALUES ('148985', '81', '2017-01-16 03:24:57', '10.0.0.23');
INSERT INTO `sys_userloginlist` VALUES ('148986', '74', '2017-01-16 03:26:24', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148987', '81', '2017-01-16 03:26:55', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148988', '81', '2017-01-16 03:39:57', '10.0.0.15');
INSERT INTO `sys_userloginlist` VALUES ('148989', '81', '2017-01-16 03:45:58', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148990', '81', '2017-01-16 04:11:07', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148991', '81', '2017-01-16 04:16:30', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148992', '74', '2017-01-16 04:41:17', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148993', '81', '2017-01-16 04:44:02', '10.0.0.23');
INSERT INTO `sys_userloginlist` VALUES ('148994', '81', '2017-01-16 04:45:13', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148995', '74', '2017-01-16 04:45:27', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148996', '74', '2017-01-16 04:51:16', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_userloginlist` VALUES ('148997', '81', '2017-01-16 05:24:36', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148998', '81', '2017-01-16 05:31:30', '127.0.0.1');
INSERT INTO `sys_userloginlist` VALUES ('148999', '81', '2017-01-16 05:35:01', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '2');
INSERT INTO `sys_user_role` VALUES ('73', '2');
INSERT INTO `sys_user_role` VALUES ('74', '2');
INSERT INTO `sys_user_role` VALUES ('75', '2');
INSERT INTO `sys_user_role` VALUES ('76', '2');
INSERT INTO `sys_user_role` VALUES ('77', '2');
INSERT INTO `sys_user_role` VALUES ('80', '2');
INSERT INTO `sys_user_role` VALUES ('81', '2');
