-- adboard_test.address definition

CREATE TABLE `address` (
  `address_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `city` VARCHAR(20) DEFAULT NULL,
  `country` VARCHAR(255) NOT NULL,
  `VERSION` INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- adboard_test.advertisement definition

CREATE TABLE `advertisement` (
  `ad_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `cost` decimal(19,2) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `publication` date DEFAULT NULL,
  `text` VARCHAR(20) DEFAULT NULL,
  `VERSION` INT DEFAULT 0,
  `FK_Advert_Author` INT DEFAULT NULL,
  `FK_Advert_Rubric` INT DEFAULT NULL,
  KEY `FKqri6ljur7p5ehos2uf6b0dtw3` (`FK_Advert_Author`),
  KEY `FKt46shcbwxbse8di27gbl4v4ay` (`FK_Advert_Rubric`),
  CONSTRAINT `FKqri6ljur7p5ehos2uf6b0dtw3` FOREIGN KEY (`FK_Advert_Author`) REFERENCES `author` (`author_id`),
  CONSTRAINT `FKt46shcbwxbse8di27gbl4v4ay` FOREIGN KEY (`FK_Advert_Rubric`) REFERENCES `rubric` (`rubric_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- adboard_test.author definition

CREATE TABLE `author` (
  `author_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20) DEFAULT NULL,
  `VERSION` INT DEFAULT 0,
  `FK_Author_Address` INT NOT NULL,
  `FK_Author_Email` INT NOT NULL,
  KEY `FKf3u12ibj03el6746basr8toig` (`FK_Author_Address`),
  KEY `FKogfio7ut0l0d9hmvgsr9edwja` (`FK_Author_Email`),
  CONSTRAINT `FKf3u12ibj03el6746basr8toig` FOREIGN KEY (`FK_Author_Address`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FKogfio7ut0l0d9hmvgsr9edwja` FOREIGN KEY (`FK_Author_Email`) REFERENCES `mail` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- adboard_test.mail definition

CREATE TABLE `mail` (
  `email_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL,
  `VERSION` INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- adboard_test.matchingad definition

CREATE TABLE `matchingad` (
  `mad_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `priceFrom` decimal(19,2) DEFAULT NULL,
  `priceTo` decimal(19,2) DEFAULT NULL,
  `title` VARCHAR(20) DEFAULT NULL,
  `VERSION` INT DEFAULT 0,
  `FK_Mad_Author` INT DEFAULT NULL,
  `FK_Mad_Rubric` INT DEFAULT NULL,
  KEY `FKrlbpu8gwackeh2thjldooggv5` (`FK_Mad_Author`),
  KEY `FK32bek8jpnxwmdlv1pos27pjae` (`FK_Mad_Rubric`),
  CONSTRAINT `FK32bek8jpnxwmdlv1pos27pjae` FOREIGN KEY (`FK_Mad_Rubric`) REFERENCES `rubric` (`rubric_id`),
  CONSTRAINT `FKrlbpu8gwackeh2thjldooggv5` FOREIGN KEY (`FK_Mad_Author`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- adboard_test.phone definition

CREATE TABLE `phone` (
  `phone_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `number` VARCHAR(20) DEFAULT NULL,
  `VERSION` INT DEFAULT 0,
  `FK_Phone_Author` INT DEFAULT NULL,
  KEY `FKc7o78kbjp6v12wublw0l7vhkk` (`FK_Phone_Author`),
  CONSTRAINT `FKc7o78kbjp6v12wublw0l7vhkk` FOREIGN KEY (`FK_Phone_Author`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- adboard_test.rubric definition

CREATE TABLE `rubric` (
  `rubric_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20) DEFAULT NULL,
  `VERSION` INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;