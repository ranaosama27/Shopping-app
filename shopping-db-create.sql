DROP SCHEMA IF EXISTS `shopping-db`;

CREATE SCHEMA `shopping-db`;

use `shopping-db`;



DROP TABLE IF EXISTS `suppliers`;

CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `phone_number` varchar(45) Not NULL unique,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `color` varchar(45) not NULL,
  `category` varchar(45) not NULL,
  `price` int not NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` CURRENT_DATE ,
  `total_amount` int not NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `supplier_product`;

CREATE TABLE `supplier_product` (
  `supplier_id` int NOT NULL,
  `product_id` int NOT NULL,
  
  PRIMARY KEY (`supplier_id`,`product_id`),
  
  FOREIGN KEY (`supplier_id`) 
  REFERENCES `supplier` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `order_product` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  
  PRIMARY KEY (`order_id`,`product_id`),
  
  FOREIGN KEY (`order_id`) 
  REFERENCES `orders` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

