
/**
 * 不用做配置文件,仅做sql同步使用
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/2/14
 */

CREATE TABLE `test`.`category` (
 `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
 `name` VARCHAR (512) NULL COMMENT '类目名称',
 `type` VARCHAR (3) NOT NULL COMMENT '1:一级类目,2:二级类目 3:三级类目',
 `parent` VARCHAR (10) NOT NULL COMMENT '父节点',
 `date` DATE  COMMENT '创建时间',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='唯一类目表';

CREATE TABLE `test`.`reservation` (
 `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
 `name` VARCHAR (512) NULL COMMENT '预约名称',
 `url` VARCHAR (1024) NOT NULL COMMENT '图片url',
 `date` DATE  COMMENT '创建时间',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='唯一预约表';

CREATE TABLE `test`.`product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品自增ID',
  `product_name` varchar(255) NOT NULL COMMENT '产品类名',
  `product_number` varchar(40) DEFAULT NULL COMMENT '产品编号',
  `promotion_price` double(10,2) DEFAULT NULL COMMENT '促销价',
  `is_spot` int(1) NOT NULL DEFAULT '0' COMMENT '是否现货0位现货1为期货',
  `promotion` int(1) NOT NULL DEFAULT '0' COMMENT '是否促销，0为非促销，1为促销',
  `product_length` double(6,2) NOT NULL COMMENT '物体长，不可数如水果蔬菜按每公斤算',
  `product_width` double(6,2) NOT NULL COMMENT '物体宽，不可数如水果蔬菜按每公斤算',
  `product_high` double(6,2) NOT NULL COMMENT '物体高，不可数如水果蔬菜按每公斤算',
  `product_icon_url` varchar(255) NOT NULL COMMENT '商品图标',
  `weight` int(5) NOT NULL DEFAULT '1' COMMENT '权重，用于商品排序与竞价排名',
  `promotion_begin_time` datetime DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime DEFAULT NULL COMMENT '促销结束时间',
  `id_restriction_number` int(11) DEFAULT '99' COMMENT '促销ID限购量',
  `promotion_number` int(11) DEFAULT NULL COMMENT '参与促销的产品数量',
  `credit_score` int(5) DEFAULT '1' COMMENT '参与促销的信用分数阈值',
  `category_code_one` varchar(4) NOT NULL COMMENT '一级类目代码',
  `category_code_two` varchar(4) NOT NULL COMMENT '二级类目代码',
  `category_code_three` varchar(4) NOT NULL COMMENT '三级类目代码',
  `reservation` varchar(255) DEFAULT NULL COMMENT '预约名称',
  PRIMARY KEY (`id`),
  KEY `product_number` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

ALTER table `test`.`product` add alert_number int(11) COMMENT '低库存预警';
ALTER table `test`.`product` add unit varchar(32) COMMENT '产品单位';

CREATE TABLE `test`.`product_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL DEFAULT '0',
  `price` double(6,2) NOT NULL,
  `enable_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produc_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `test`.`product_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `product_picture_url` varchar(255) NOT NULL COMMENT '产品图片路径',
  `coverpicture` int(1) NOT NULL DEFAULT '0' COMMENT '是否为主展示图1为是，0为否',
  `product_id` int(11) NOT NULL COMMENT '产品id外键',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `test`.`district` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `district_name` varchar(255) NOT NULL COMMENT '城区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `test`.`residential_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `residential_area_name` varchar(255) NOT NULL COMMENT '城区',
  `distric_id` int(11) NOT NULL COMMENT '地区id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

ALTER table `test`.`residential_area`
 add `building` int(5) COMMENT '多少栋楼',
 add `house` int(5) COMMENT '多少户',
 add `house_price` int(5) COMMENT '可输建自提柜数据',
 add `cabinet_count` int(5) COMMENT '可输建自提柜数据',
 add `rent_one` int(5) COMMENT '一居租金',
 add `rent_two` int(5) COMMENT '二居租金',
 add `rent_three` int(5) COMMENT '三居租金';

CREATE TABLE `test`.`self_lifting_cabinet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `cabinet_number` varchar(11) NOT NULL COMMENT '自提柜编号',
  `business_outlet_id` int(11) NOT NULL COMMENT '自提点ID',
  `warehouse_id` int(11) NOT NULL COMMENT '供货仓库ID',
  `stocking_base` int(11) NOT NULL COMMENT '备货基数',
  `district_id` int(11) NOT NULL COMMENT '地区id',
  `residential_area_id` int(11) NOT NULL COMMENT '小区ID（如花园小区)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

ALTER table `test`.`self_lifting_cabinet`
 add `location` varchar(512) COMMENT '自提柜具体位置';

ALTER TABLE `test`.`category`
ADD  `is_fresh` int(2) NOT NULL DEFAULT 0 comment '是否是生鲜类商品,0:正常商品 1:生鲜商品(24小时不能退货)'

CREATE TABLE `test`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL comment '电子邮箱',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` TINYINT DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`),
  INDEX phone_index(`phone`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

ALTER TABLE `test`.`user`
ADD  `role` int(11) not NULL DEFAULT '0' comment '权限id',
ADD  `url` VARCHAR (1024) DEFAULT NULL comment '权限页';