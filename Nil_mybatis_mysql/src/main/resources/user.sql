CREATE TABLE IF NOT EXISTS user ( `id` INT(10) NOT NULL AUTO_INCREMENT, `name` VARCHAR(50) NULL DEFAULT NULL , `age` INT(2) NOT NULL , PRIMARY KEY (id) );

INSERT INTO `user`(name,age) VALUES ('tom', 11), ('jerry', 12),('jake', 13);