CREATE SCHEMA IF NOT EXISTS `CCDTyE`;
USE `CCDTyE` ;
CREATE TABLE IF NOT EXISTS `CCDTyE`.`CCDTyE` (
  `ID_CCDTyE` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Ubicacion` VARCHAR(60) NOT NULL,
  `Fecha_puesta_en_marcha` DATE NOT NULL,
  `Fecha_de_cierre` DATE NOT NULL,
  PRIMARY KEY (`ID_CCDTyE`));

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Fuerzas`(
    `ID_Fuerza` INT NOT NULL PRIMARY KEY,
    `Nombre` VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`CCDTyE_Fuerzas`(
    `CCDTyE_id` INT,
    `Fuerzas_id` INT,
    PRIMARY KEY (`CCDTyE_id`, `Fuerzas_id`),
    FOREIGN KEY (`CCDTyE_id`) REFERENCES `CCDTyE`(`ID_CCDTyE`),
    FOREIGN KEY (`Fuerzas_id`) REFERENCES `Fuerzas`(`ID_Fuerza`)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Testigos`(
	`ID_Testigo` INT NOT NULL,
    `Nombre` VARCHAR(45) NOT NULL,
    `DNI` VARCHAR(25) NOT NULL,
    `Testimonio` TEXT NOT NULL,
    PRIMARY KEY(`ID_Testigo`)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Personas`(
	`ID_Persona` INT NOT NULL AUTO_INCREMENT,
    `ID_CCDTyE` INT,
    `ID_Testigo` INT,
    FOREIGN KEY(`ID_CCDTyE`) REFERENCES CCDTyE(`ID_CCDTyE`),
    PRIMARY KEY (`ID_Persona`)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Detenidos_Identificados`(
	`ID_Persona` INT NOT NULL,
    `Nombre` VARCHAR(45) NOT NULL,
    `DNI` VARCHAR(25) NOT NULL,
    `Lugar_de_secuestro` VARCHAR(45),
    `Ultima_vez_visto` DATETIME,
    `Biografia_personal` TEXT NOT NULL,
    `Ruta_material_audiovisual` VARCHAR(255),
    PRIMARY KEY (`ID_Persona`),
    FOREIGN KEY (`ID_Persona`) REFERENCES Personas(`ID_Persona`)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Detenidos_No_Identificados`(
	`ID_Persona` INT NOT NULL,
    `Apodo` VARCHAR(30),
    `Descripcion_significativa` TEXT,
    PRIMARY KEY(`ID_Persona`),
	FOREIGN KEY (`ID_Persona`) REFERENCES Personas(`ID_Persona`)
);



  
  
