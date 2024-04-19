-- MySQL Script generated by MySQL Workbench
-- Fri Apr 19 17:04:38 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Ronda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ronda` (
  `idRonda` INT NOT NULL,
  `premioConseguir` VARCHAR(45) NULL,
  `numRonda` INT NULL,
  PRIMARY KEY (`idRonda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`historial` (
  `idHistorial` INT NOT NULL,
  `jugador_idjugador` INT NOT NULL,
  `nombreJugador` VARCHAR(45) NULL,
  `puntajeFinal` INT NULL,
  `razonTerminoJuego` VARCHAR(45) NULL,
  PRIMARY KEY (`idHistorial`),
  INDEX `fk_historial_jugador_idx` (`jugador_idjugador` ASC) VISIBLE,
  CONSTRAINT `fk_historial_jugador`
    FOREIGN KEY (`jugador_idjugador`)
    REFERENCES `mydb`.`jugador` (`idjugador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`jugador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`jugador` (
  `idjugador` INT NOT NULL,
  `nombreJugador` VARCHAR(45) NULL,
  PRIMARY KEY (`idjugador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pregunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pregunta` (
  `idPregunta` INT NOT NULL,
  `nivelDificultad` VARCHAR(45) NULL,
  `categoria` VARCHAR(45) NULL,
  `textoPregunta` VARCHAR(255) NULL,
  `valorPuntos` INT NULL,
  PRIMARY KEY (`idPregunta`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
