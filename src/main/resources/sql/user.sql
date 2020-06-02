CREATE TABLE `user`(
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `password`VARCHAR (45) NOT NULL ,
 `name` VARCHAR (45) NOT NULL ,
 `creat_time` DATETIME NOT NULL ,
 PRIMARY KEY (`id`),
 UNIQUE KEY`user_name_UNIQUE`(`name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

--UNIQUE KEY 'user_name_UNIQUE'('name') 唯一索引，名字不能重复
