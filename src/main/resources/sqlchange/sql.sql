
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
