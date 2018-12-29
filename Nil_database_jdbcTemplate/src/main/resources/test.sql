 CREATE TABLE `students` (
     `id` int(11) DEFAULT NULL,
     `name` text,
     `age` int(11) DEFAULT NULL
 ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

 insert into `students` values(1,"tom",23),(2,"jake",19),(3,"jerry",17);
