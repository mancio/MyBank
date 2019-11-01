-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema QR9KltXLfl
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema QR9KltXLfl
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `QR9KltXLfl` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `QR9KltXLfl` ;

-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`bank` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`bank` (
  `bankid` BIGINT(20) NOT NULL,
  `bankdetails` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`bankid`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`bankaccount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`bankaccount` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`bankaccount` (
  `senderaccountnumber` VARCHAR(255) NOT NULL,
  `balance` DECIMAL(19,2) NOT NULL,
  `userid` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`senderaccountnumber`),
  INDEX `FKpan6ppr6eevwfoemf9sfusqsx` (`userid` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`branchaddresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`branchaddresses` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`branchaddresses` (
  `baddressid` BIGINT(20) NOT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `country` VARCHAR(255) NOT NULL,
  `region` VARCHAR(255) NOT NULL,
  `street` VARCHAR(255) NULL DEFAULT NULL,
  `zip` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`baddressid`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`branches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`branches` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`branches` (
  `branchid` BIGINT(20) NOT NULL,
  `baddressid` BIGINT(20) NULL DEFAULT NULL,
  `bankid` BIGINT(20) NULL DEFAULT NULL,
  `branchdetails` VARCHAR(255) NULL DEFAULT NULL,
  `branchtypecode` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`branchid`),
  INDEX `FKkwlgfabubtuj79022slfui5gs` (`bankid` ASC) VISIBLE,
  INDEX `FKgis79bl3eqb1wc0hx4harokfp` (`baddressid` ASC) VISIBLE,
  INDEX `FK43bsy21ojg21ntx03rlvjjhav` (`branchtypecode` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`branchservices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`branchservices` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`branchservices` (
  `branchtypecode` VARCHAR(255) NOT NULL,
  `servicelist` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`branchtypecode`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`hibernate_sequence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`hibernate_sequence` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`role` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`role` (
  `roleid` BIGINT(20) NOT NULL,
  `rolename` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`roleid`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`transaction` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`transaction` (
  `transactionid` BIGINT(20) NOT NULL,
  `transamount` DECIMAL(19,2) NOT NULL,
  `transferdate` DATE NOT NULL,
  `transdescription` VARCHAR(255) NOT NULL,
  `receiveraccountnumber` VARCHAR(255) NOT NULL,
  `receivername` VARCHAR(255) NOT NULL,
  `senderaccountnumber` VARCHAR(255) NOT NULL,
  `transstatus` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`transactionid`),
  INDEX `FKom44wgrhqmpoulfotxdqu33yh` (`senderaccountnumber` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`user` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`user` (
  `userid` BIGINT(20) NOT NULL,
  `accessstatuscode` INT(11) NOT NULL,
  `branchid` BIGINT(20) NOT NULL,
  `mail` VARCHAR(255) NOT NULL,
  `middlename` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `phoneprefix` VARCHAR(255) NULL DEFAULT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  `uaddressid` BIGINT(20) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE INDEX `UK_9a5o9s3o28sca81u3v960pye3` (`branchid` ASC) VISIBLE,
  UNIQUE INDEX `UK_6sou31qus5dnws6dwfu61e71v` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `UK_o7ojh6x1eodmos6yo4t2olest` (`uaddressid` ASC) VISIBLE,
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`useraddresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`useraddresses` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`useraddresses` (
  `uaddressid` BIGINT(20) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `country` VARCHAR(255) NOT NULL,
  `region` VARCHAR(255) NOT NULL,
  `street` VARCHAR(255) NOT NULL,
  `zip` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`uaddressid`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `QR9KltXLfl`.`userrole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QR9KltXLfl`.`userrole` ;

CREATE TABLE IF NOT EXISTS `QR9KltXLfl`.`userrole` (
  `userroleid` BIGINT(20) NOT NULL,
  `roleid` BIGINT(20) NULL DEFAULT NULL,
  `userid` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`userroleid`),
  INDEX `FKp9uqhbg64l2v6p5i1ixunb645` (`roleid` ASC) VISIBLE,
  INDEX `FKljkcg6w3npwi6u5ua4gqp59sj` (`userid` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
