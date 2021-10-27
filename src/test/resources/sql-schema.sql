DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
    `itemId` INT(10) NOT NULL AUTO_INCREMENT,
    `itemName` VARCHAR(30) NOT NULL,
    `itemValue` INT(20) NOT NULL,
    PRIMARY KEY (`itemId`)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
    `orderId` INT(10) NOT NULL AUTO_INCREMENT,
    `id` INT(10) NOT NULL,
    `orderQuantity` INT(20) DEFAULT NULL,
    PRIMARY KEY (`orderId`)
);