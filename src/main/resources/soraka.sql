/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.24 : Database - soraka
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`soraka` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `soraka`;

/*Table structure for table `basic_table` */

DROP TABLE IF EXISTS `basic_table`;

CREATE TABLE `basic_table`
(
    `id`           int(11)  NOT NULL AUTO_INCREMENT
        COMMENT '主键',
    `gmt_create`   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` datetime          DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    ROW_FORMAT = DYNAMIC;

/*Data for the table `basic_table` */

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info`
(
    `order_id`      int(11)     NOT NULL AUTO_INCREMENT
        COMMENT '主键',
    `gmt_create`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_pay`       varchar(50)          DEFAULT NULL,
    `user_id`       varchar(50) NOT NULL
        COMMENT '用户id',
    `qr_code`       BLOB
        COMMENT '二维码',
    `parking_name`  varchar(32) NOT NULL DEFAULT ''
        COMMENT '停车场名',
    `parking_id`    varchar(50) NOT NULL
        COMMENT '停车场id',
    `parking_place` varchar(50) NOT NULL
        COMMENT '车位',
    `price`         varchar(32)          DEFAULT NULL
        COMMENT '价格',
    `state`         varchar(2)           DEFAULT NULL
        COMMENT '状态',
    PRIMARY KEY (`order_id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 7
    DEFAULT CHARSET = utf8
    ROW_FORMAT = DYNAMIC
    COMMENT = '订单信息表';

/*Data for the table `order_info` */

/*Table structure for table `sys_authorities` */

DROP TABLE IF EXISTS `sys_authorities`;

CREATE TABLE `sys_authorities`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT
        COMMENT '主键',
    `gmt_create`   datetime(6) NOT NULL,
    `gmt_modified` datetime(6) DEFAULT NULL,
    `user_id`      varchar(50) NOT NULL
        COMMENT '用户id',
    `authority`    varchar(50) NOT NULL
        COMMENT '用户角色（默认ROLE_USER）',
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARSET = utf8
    ROW_FORMAT = DYNAMIC;

/*Data for the table `sys_authorities` */

insert into `sys_authorities` (`id`, `gmt_create`, `gmt_modified`, `user_id`, `authority`)
values (1, '2019-02-22 09:08:22.000000', '2019-02-22 09:08:22.000000', 'qpDdvw5vR12iFpXJAH+QBQ', 'ROLE_USER');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT
        COMMENT '主键',
    `gmt_create`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `user_id`      varchar(50)  NOT NULL
        COMMENT '用户id',
    `password`     varchar(255) NOT NULL
        COMMENT '用户密码',
    `enabled`      tinyint(1)   NOT NULL
        COMMENT '是否启用(0未启用1启用）',
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 8
    DEFAULT CHARSET = utf8
    ROW_FORMAT = DYNAMIC;

/*Data for the table `sys_user` */

insert into `sys_user` (`id`, `gmt_create`, `gmt_modified`, `user_id`, `password`, `enabled`)
values (7,
        '2019-02-22 09:08:22',
        '2019-02-22 09:08:22',
        'qpDdvw5vR12iFpXJAH+QBQ',
        '$2a$10$X7QFJYhIZPNhIkmMAfAq/eZA99F0BSQ.8gCWe2hmqPkgoV.Z2D0ya',
        1);

/*Table structure for table `sys_user_info` */

DROP TABLE IF EXISTS `sys_user_info`;

CREATE TABLE `sys_user_info`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT
        COMMENT '主键',
    `gmt_create`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified`  datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `user_id`       varchar(50) NOT NULL
        COMMENT '用户id',
    `user_name`     varchar(32) NOT NULL DEFAULT ''
        COMMENT '用户名',
    `gender`        tinyint(1)  NOT NULL
        COMMENT '性别(0女1男)',
    `age`           int(3)               DEFAULT NULL
        COMMENT '年龄',
    `birthday`      datetime             DEFAULT CURRENT_TIMESTAMP
        COMMENT '生日',
    `address`       varchar(100)         DEFAULT NULL
        COMMENT '地址',
    `user_type`     varchar(2)           DEFAULT NULL
        COMMENT '用户类型',
    `real_name`     varchar(32)          DEFAULT NULL
        COMMENT '真实姓名',
    `qq`            varchar(14)          DEFAULT NULL
        COMMENT 'QQ',
    `email`         varchar(100)         DEFAULT NULL
        COMMENT '电子邮箱',
    `tel`           varchar(255)         DEFAULT NULL
        COMMENT '联系电话',
    `license_plate` varchar(100)         DEFAULT NULL
        COMMENT '车牌',
    `vehicle_type`  varchar(100)         DEFAULT NULL
        COMMENT '车型',
    PRIMARY KEY (`id`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 8
    DEFAULT CHARSET = utf8
    ROW_FORMAT = DYNAMIC
    COMMENT = '用户信息表';

/*Data for the table `sys_user_info` */

insert into `sys_user_info` (`id`,
                             `gmt_create`,
                             `gmt_modified`,
                             `user_id`,
                             `user_name`,
                             `gender`,
                             `age`,
                             `birthday`,
                             `address`,
                             `user_type`,
                             `real_name`,
                             `qq`,
                             `email`,
                             `tel`,
                             `license_plate`,
                             `vehicle_type`)
values (7,
        '2019-02-22 09:08:22',
        '2019-02-22 09:08:22',
        'qpDdvw5vR12iFpXJAH+QBQ',
        'admin',
        1,
        1,
        '2019-02-22 09:08:22',
        '1',
        '1',
        '1',
        '1',
        '1',
        '1',
        NULL,
        NULL);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
