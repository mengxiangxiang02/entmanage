

DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  USERID varchar(30) NOT NULL COMMENT '登录账户	',
  USERNAME varchar(30) NOT NULL COMMENT '用户名',
  PASSWORD varchar(32) DEFAULT NULL COMMENT '密码',
  STATUS varchar(2) DEFAULT NULL COMMENT '邮箱',
  EXTS varchar(100) DEFAULT NULL COMMENT '手机号',
  GMT_CREATE timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  GMT_MODIFIED timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY idx_account (USERID) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO user_info VALUES ('1', 'meng', '孟祥祥', 'C4CA4238A0B923820DCC509A6F75849B', 'Y', null, '2017-09-19 00:00:00', null);


DROP TABLE IF EXISTS ent_info;
CREATE TABLE ent_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  entname varchar(30) NOT NULL COMMENT '企业名称	',
  entlocation varchar(200) NOT NULL COMMENT '企业地点',
  entbusiness varchar(500) DEFAULT NULL COMMENT '企业业务',
  entperson varchar(100) DEFAULT NULL COMMENT '企业人数',
  enttype varchar(100) DEFAULT NULL COMMENT '企业类型',
  interviewstudent varchar(100) DEFAULT NULL COMMENT '面试学员',
  interviewaspect varchar(100) DEFAULT NULL COMMENT '面试方向',
  studentclass varchar(100) DEFAULT NULL COMMENT '学员班级',
  entwhite varchar(2) DEFAULT NULL COMMENT ' 是否黑名单企业',
  remark  varchar(500) DEFAULT NULL COMMENT '备注',
  GMT_CREATE timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  GMT_MODIFIED timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业信息';

DROP TABLE IF EXISTS class_info;
CREATE TABLE class_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  classname varchar(30) NOT NULL COMMENT '班级名称	',
  classyear varchar(200) NOT NULL COMMENT '班级年份',
  remark  varchar(500) DEFAULT NULL COMMENT '备注',
  GMT_CREATE timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  GMT_MODIFIED timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='班级信息';



DROP TABLE IF EXISTS student_ent_info;
CREATE TABLE student_ent_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  entname varchar(30) NOT NULL COMMENT '企业名称	',
  entlocation varchar(200) NOT NULL COMMENT '企业地点',
  entbusiness varchar(500) DEFAULT NULL COMMENT '企业业务',
  entperson varchar(100) DEFAULT NULL COMMENT '企业人数',
  enttype varchar(100) DEFAULT NULL COMMENT '企业类型',
  interviewstudent varchar(100) DEFAULT NULL COMMENT '面试学员',
  interviewaspect varchar(100) DEFAULT NULL COMMENT '面试方向',
  studentclass varchar(100) DEFAULT NULL COMMENT '学员班级',
  entwhite varchar(2) DEFAULT NULL COMMENT ' 是否黑名单企业',
  remark  varchar(500) DEFAULT NULL COMMENT '备注',
  GMT_CREATE timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  GMT_MODIFIED timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业信息';