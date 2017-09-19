

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(30) NOT NULL COMMENT '登录账户	',
  `USERNAME` varchar(30) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `STATUS` varchar(2) DEFAULT NULL COMMENT '邮箱',
  `EXTS` varchar(100) DEFAULT NULL COMMENT '手机号',
  `GMT_CREATE` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '数据更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_account` (`USERID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'meng', '孟祥祥', 'C4CA4238A0B923820DCC509A6F75849B', 'Y', null, '2017-09-19 00:00:00', null);