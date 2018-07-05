-- создаем таблицу
CREATE TABLE `shop_less2`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prodid` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `cost` DECIMAL(10) NOT NULL,
  PRIMARY KEY (`id`));

-- выбрать все строки из таблицы
SELECT * FROM shop_less2.products;

-- создаем несколько строк
INSERT INTO `shop_less2`.`products` (`prodid`, `title`, `cost`) VALUES ('23', 'prod23', '345');
INSERT INTO `shop_less2`.`products` (`prodid`, `title`, `cost`) VALUES ('24', 'prod24', '245');
INSERT INTO `shop_less2`.`products` (`prodid`, `title`, `cost`) VALUES ('25', 'prod25', '853');

  