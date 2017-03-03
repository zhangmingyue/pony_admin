
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

