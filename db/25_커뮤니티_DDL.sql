# https://www.erdcloud.com/d/PsDTmWwCgyxQgbSxe

DROP DATABASE IF EXISTS COMMUNITY;

CREATE DATABASE COMMUNITY;

USE COMMUNITY;

DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER` (
	`me_id`	varchar(15) primary key	NOT NULL,
	`me_pw`	varchar(255) not	NULL,
	`me_email`	varchar(255) not	NULL,
	`me_authority`	varchar(5) default "USER" not	NULL,
    `me_cookie` varchar(255),
    `me_limit` datetime
);

DROP TABLE IF EXISTS `BOARD`;

CREATE TABLE `BOARD` (
	`bo_num`	int  primary key auto_increment	NOT NULL,
	`bo_name`	varchar(20) unique not	NULL
);

DROP TABLE IF EXISTS `POST`;

CREATE TABLE `POST` (
	`po_num`	int  primary key auto_increment	NOT NULL,
	`po_title`	varchar(255) not	NULL,
	`po_content`	longtext not	NULL,
	`po_date`	datetime default current_timestamp not	NULL,
	`po_view`	int default 0 not	NULL,
	`po_up`	int default 0 not	NULL,
	`po_down`	int default 0 not	NULL,
	`po_me_id`	varchar(15)	NULL,
	`po_bo_num`	int	NOT NULL,
	`po_del`	char(1) default 'N' not	NULL
);

DROP TABLE IF EXISTS `LIKE`;

CREATE TABLE `LIKE` (
	`li_num`	int primary key auto_increment	NOT NULL,
	`li_state`	int not	NULL,
	`li_me_id`	varchar(15)	NOT NULL,
	`li_po_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `FILE`;

CREATE TABLE `FILE` (
	`fi_num`	int  primary key auto_increment	NOT NULL,
	`fi_ori_name`	varchar(255) not	NULL,
	`fi_name`	varchar(255) not	NULL,
	`fi_po_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `COMMENT`;

CREATE TABLE `COMMENT` (
	`co_num`	int primary key	NOT NULL,
	`co_content`	varchar(200) not	NULL,
	`co_date`	datetime default current_timestamp not	NULL,
	`co_ori_num`	int not	NULL,
	`co_del`	char(1) default 'N' not	NULL,
	`co_me_id`	varchar(15)	NOT NULL,
	`co_po_num`	int	NOT NULL
);

ALTER TABLE `POST` ADD CONSTRAINT `FK_MEMBER_TO_POST_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `MEMBER` (
	`me_id`
);

ALTER TABLE `POST` ADD CONSTRAINT `FK_BOARD_TO_POST_1` FOREIGN KEY (
	`po_bo_num`
)
REFERENCES `BOARD` (
	`bo_num`
);

ALTER TABLE `LIKE` ADD CONSTRAINT `FK_MEMBER_TO_LIKE_1` FOREIGN KEY (
	`li_me_id`
)
REFERENCES `MEMBER` (
	`me_id`
);

ALTER TABLE `LIKE` ADD CONSTRAINT `FK_POST_TO_LIKE_1` FOREIGN KEY (
	`li_po_num`
)
REFERENCES `POST` (
	`po_num`
);

ALTER TABLE `FILE` ADD CONSTRAINT `FK_POST_TO_FILE_1` FOREIGN KEY (
	`fi_po_num`
)
REFERENCES `POST` (
	`po_num`
);

ALTER TABLE `COMMENT` ADD CONSTRAINT `FK_MEMBER_TO_COMMENT_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `MEMBER` (
	`me_id`
);

ALTER TABLE `COMMENT` ADD CONSTRAINT `FK_POST_TO_COMMENT_1` FOREIGN KEY (
	`co_po_num`
)
REFERENCES `POST` (
	`po_num`
);

