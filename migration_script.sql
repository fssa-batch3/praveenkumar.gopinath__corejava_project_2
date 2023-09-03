-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: savinglives
-- Source Schemata: savinglives
-- Created: Fri Sep  1 16:55:43 2023
-- Workbench Version: 8.0.32
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema savinglives
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `savinglives` ;
CREATE SCHEMA IF NOT EXISTS `savinglives` ;

-- ----------------------------------------------------------------------------
-- Table savinglives.blood_groupsuser
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `savinglives`.`blood_groupsuser` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bloodgroupname` VARCHAR(10) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table savinglives.request
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `savinglives`.`request` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(30) NULL DEFAULT NULL,
  `description` VARCHAR(30) NULL DEFAULT NULL,
  `blood_group` VARCHAR(30) NULL DEFAULT NULL,
  `date` VARCHAR(30) NULL DEFAULT NULL,
  `number` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table savinglives.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `savinglives`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table savinglives.users
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `savinglives`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
