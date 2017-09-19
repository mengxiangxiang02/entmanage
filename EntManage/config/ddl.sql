

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(30) NOT NULL COMMENT '��¼�˻�	',
  `USERNAME` varchar(30) NOT NULL COMMENT '�û���',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '����',
  `STATUS` varchar(2) DEFAULT NULL COMMENT '����',
  `EXTS` varchar(100) DEFAULT NULL COMMENT '�ֻ���',
  `GMT_CREATE` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '���ݸ���ʱ��',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_account` (`USERID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�û�';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'meng', '������', 'C4CA4238A0B923820DCC509A6F75849B', 'Y', null, '2017-09-19 00:00:00', null);