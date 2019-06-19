RBAC



CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '账号',
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '名称（昵称或者真实姓名，不同系统不同定义）',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `salt` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '加密密码的盐',
  `state` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建用户',
  `operator` varchar(40) DEFAULT NULL COMMENT '操作用户',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 CHARSET=utf8 COMMENT='用户信息表';

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL UNIQUE COMMENT '角色标识程序中判断使用,如"admin",这个是唯一的:',
  `description` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '角色描述,UI界面显示使用',
   `available` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '是否可用,如果不可用将不会添加给用户',
     `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建用户',
  `operator` varchar(40) DEFAULT NULL COMMENT '操作用户',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `resource_type` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '资源类型，[menu|button]',
   `url` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '资源路径',
    `permission` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
     `parent_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '父编号',
     `parent_ids` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '父编号列表',
     `available` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '是否可用',
       `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建用户',
  `operator` varchar(40) DEFAULT NULL COMMENT '操作用户',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 CHARSET=utf8 COMMENT='权限表';

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `uid` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
    `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建用户',
  `operator` varchar(40) DEFAULT NULL COMMENT '操作用户',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 CHARSET=utf8 COMMENT='用户角色表';

CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `permission_id` int(11) NOT NULL COMMENT '角色权限',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
    `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建用户',
  `operator` varchar(40) DEFAULT NULL COMMENT '操作用户',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 CHARSET=utf8 COMMENT='角色权限表';


INSERT INTO `user_info` (`uid`,`username`,`name`,`password`,`salt`,`state`) VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (1,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/userList');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/userAdd');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/userDel');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (1,0,'管理员','admin');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (2,0,'VIP会员','vip');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (3,1,'test','test');

INSERT INTO `sys_role_permission` (`id`,`permission_id`,`role_id`) VALUES (1,1,1);
INSERT INTO `sys_role_permission` (`id`,`permission_id`,`role_id`) VALUES (3,2,1);
INSERT INTO `sys_role_permission` (`id`,`permission_id`,`role_id`) VALUES (2,3,2);
INSERT INTO `sys_user_role` (`id`,`role_id`,`uid`) VALUES (1,1,1);