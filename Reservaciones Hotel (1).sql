-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema dbResHotel
-- -----------------------------------------------------
-- Sistema de Control de Reservaciones para Hotel

-- -----------------------------------------------------
-- Schema dbResHotel
--
-- Sistema de Control de Reservaciones para Hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbResHotel` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `dbResHotel` ;

-- -----------------------------------------------------
-- Table `dbResHotel`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbResHotel`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(50) NULL,
  `apellidos` VARCHAR(50) NULL,
  `direccion` varchar(100) NULL,
  `sexo` VARCHAR(10) NULL, 
  `telefono` VARCHAR(10) NULL,
  `email` VARCHAR(100) NULL,
  `dpi` VARCHAR(15) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbResHotel`.`tipoHabitacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbResHotel`.`tipohabitacion` (
  `idtipohabitacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `nohabitacion` INT NULL,
  `precio` DOUBLE ZEROFILL NULL,
  `numeropiso` INT NULL,
  `nopersonas` INT NULL,
  PRIMARY KEY (`idtipohabitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbResHotel`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbResHotel`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT,
  `fechaingreso` Datetime not NULL,
  `fechaegreso` DateTime not null,
  `cantidadpersonas` INT NULL,
  `idTipohabitacion` INT NULL,
  `comentario` varchar(200) NOT NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `fk_tipohabitacion_idtipohabitacion_idx` (`idtipohabitacion` ASC) VISIBLE,
  CONSTRAINT `fk_reserva_idtipohabitacion`
    FOREIGN KEY (`idtipohabitacion`)
    REFERENCES `dbResHotel`.`tipohabitacion` (`idtipohabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbResHotel`.`registroHuespedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbResHotel`.`registrohuespedes` (
  `idregistroHuespedes` INT NOT NULL AUTO_INCREMENT,
  `idcliente` INT NULL,
  `idreserva` INT NULL,
  `fechaentrada` DATETIME NULL,
  `fechasalida` DATETIME NULL,
  `estado` VARCHAR(10) NULL DEFAULT 'Libre',
  `cantidadpersonas` INT NULL,
  PRIMARY KEY (`idregistrohuespedes`),
  INDEX `fk_cliente_idcliente_idx` (`idcliente` ASC) VISIBLE,
  INDEX `fk_cliente_idreserva_idx` (`idreserva` ASC) VISIBLE,
  CONSTRAINT `fk_reghuespedes_idcliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `dbResHotel`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reghuespedes_idreserva`
    FOREIGN KEY (`idreserva`)
    REFERENCES `dbResHotel`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- drop table Pago;

-- -----------------------------------------------------
-- Table `dbResHotel`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbResHotel`.`pago` (
  `idpago` INT NOT NULL AUTO_INCREMENT primary key,
  `idcliente` INT NULL,
  `concepto` VARCHAR(100) NULL,
  `fechasalida` DATE NULL,  
   FOREIGN KEY (`idcliente`)
    REFERENCES `dbResHotel`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


