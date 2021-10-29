DROP TABLE IF EXISTS `orderitems`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;


CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `itemId` INT NOT NULL AUTO_INCREMENT,
    `itemName` VARCHAR(30) NOT NULL,
    `itemValue` INT NOT NULL,
    PRIMARY KEY (`itemId`)
);


CREATE TABLE IF NOT EXISTS `orders` (
    `orderId` INT(10) NOT NULL AUTO_INCREMENT,
    `id` INT(10) NOT NULL,
    `orderQuantity` INT(20) DEFAULT NULL,
    PRIMARY KEY (`orderId`),
    FOREIGN KEY (`id`) REFERENCES customers(`id`)
);


CREATE TABLE `orderitems` (
  `orderItemsId` int NOT NULL AUTO_INCREMENT,
  `orderId` int NOT NULL,
  `itemId` int NOT NULL,
  `totalCost` float NOT NULL,
  PRIMARY KEY (`orderItemsId`),
   FOREIGN KEY (`itemId`) REFERENCES `items` (`itemId`),
   FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`)
) 
