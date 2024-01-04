CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    userid varchar(24),
    name varchar(50),
    email varchar(255),
    PRIMARY KEY (id, userid)
);

CREATE TABLE booktable(
id INT AUTO_INCREMENT,
book_name VARCHAR(50) NOT NULL,
volume_num INT NOT NULL,
author_name VARCHAR(50) NOT NULL,
published_date DATE NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE `demo_db`.`userinfo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(255) NULL,
  `phone` VARCHAR(50) NULL,
  `update_date` DATETIME NOT NULL,
  `create_date` DATETIME NOT NULL,
  `delete_date` DATETIME NULL,
  PRIMARY KEY (`id`));

 create table booksinfo (
       id   INT         AUTO_INCREMENT NOT NULL
     , title VARCHAR(50) NOT NULL
     , price   INT      NOT NULL
     , dt   DATETIME    DEFAULT CURRENT_TIMESTAMP
     , PRIMARY KEY (id)
 ) ;
