-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema freedb_VAARI_APP
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema freedb_VAARI_APP
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `freedb_VAARI_APP` DEFAULT CHARACTER SET utf8mb3 ;
USE `freedb_VAARI_APP` ;

-- -----------------------------------------------------
-- Table `freedb_VAARI_APP`.`Ancianos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freedb_VAARI_APP`.`Ancianos` (
  `idAncianos` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Anciano` VARCHAR(255) NOT NULL,
  `Apellidos_Anciano` VARCHAR(255) NOT NULL,
  `Edad_Anciano` INT NOT NULL,
  `Sexo` ENUM('Mujer', 'Hombre') NOT NULL,
  `DescripcionAnciano` LONGTEXT NOT NULL,
  `DescripcionTrastorno` LONGTEXT NOT NULL,
  `Medicacion` VARCHAR(255) NOT NULL,
  `Dosis` VARCHAR(45) NOT NULL,
  `Dependencia` ENUM('Independiente', 'Media', 'Total') NOT NULL,
  `Movilidad` ENUM('Total', 'Media', 'Baja') NOT NULL,
  PRIMARY KEY (`idAncianos`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `freedb_VAARI_APP`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freedb_VAARI_APP`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Usuario` VARCHAR(255) NOT NULL,
  `Apellidos_Usuario` VARCHAR(255) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `Email_Usuario` VARCHAR(255) NOT NULL,
  `tipoUsuario` ENUM('Funcionario', 'Familiar') NOT NULL,
  PRIMARY KEY (`idUsuarios`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `freedb_VAARI_APP`.`Usuarios_has_Ancianos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freedb_VAARI_APP`.`Usuarios_has_Ancianos` (
  `Usuarios_idUsuarios` INT NOT NULL,
  `Ancianos_idAncianos` INT NOT NULL,
  PRIMARY KEY (`Usuarios_idUsuarios`, `Ancianos_idAncianos`),
  INDEX `fk_Usuarios_has_Ancianos_Usuarios1_idx` (`Usuarios_idUsuarios` ASC) VISIBLE,
  INDEX `fk_Usuarios_has_Ancianos_Ancianos1_idx` (`Ancianos_idAncianos` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_has_Ancianos_Ancianos1`
    FOREIGN KEY (`Ancianos_idAncianos`)
    REFERENCES `freedb_VAARI_APP`.`Ancianos` (`idAncianos`),
  CONSTRAINT `fk_Usuarios_has_Ancianos_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuarios`)
    REFERENCES `freedb_VAARI_APP`.`Usuarios` (`idUsuarios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
