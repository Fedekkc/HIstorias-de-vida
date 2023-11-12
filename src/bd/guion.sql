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
    `ID_Fuerza` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Nombre` VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Represores`(
    `ID_Represor` INT NOT NULL AUTO_INCREMENT,
    `ID_Fuerza` INT NOT NULL,
    `Nombre` VARCHAR(45),
    PRIMARY KEY(`ID_Represor`),
    FOREIGN KEY(`ID_Fuerza`) REFERENCES `Fuerzas`(`ID_Fuerza`)
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



CREATE TABLE IF NOT EXISTS `Lugares_de_secuestro`(`ID_Lugar`INT NOT NULL AUTO_INCREMENT PRIMARY KEY, `Nombre` VARCHAR(60));

CREATE TABLE IF NOT EXISTS `CCDTyE`.`Detenidos_Identificados`(
	`ID_Detenido_Identificado` INT NOT NULL,
    `Nombre` VARCHAR(45) NOT NULL,
    `DNI` VARCHAR(25) NOT NULL,
    `ID_Lugar_de_secuestro` INT NOT NULL,
    `Ultima_vez_visto` DATETIME,
    `Biografia_personal` TEXT NOT NULL,
    `Ruta_material_audiovisual` VARCHAR(255),
    `Tiempo_en_cautiverio` INT,
    `Sobrevivio` BOOLEAN,   
    PRIMARY KEY (`ID_Detenido_Identificado`),
    FOREIGN KEY (`ID_Lugar_de_secuestro`) REFERENCES Lugares_de_secuestro(`ID_Lugar`)
);

CREATE TABLE IF NOT EXISTS `CCDTyE`.`CCDTyE_Personas`(
    `ID_CCDTyE` INT NOT NULL,
    `ID_Persona` INT NOT NULL,
    PRIMARY KEY (`ID_CCDTyE`, `ID_Persona`),
    FOREIGN KEY(`ID_CCDTyE`) REFERENCES `CCDTyE`(`ID_CCDTyE`),
    FOREIGN KEY(`ID_Persona`) REFERENCES `Personas`(`ID_Persona`)
);


CREATE TABLE IF NOT EXISTS `CCDTyE`.`Detenidos_No_Identificados`(
	`ID_Detenido_No_Identificado` INT NOT NULL,
    `Apodo` VARCHAR(30),
    `Descripcion_significativa` TEXT,
    PRIMARY KEY(`ID_Persona`),
	FOREIGN KEY (`ID_Persona`) REFERENCES Personas(`ID_Persona`)
);

INSERT INTO `Lugares_de_secuestro`(`Nombre`) VALUES ('Casa'),('Calle'),('Trabajo'),('Escuela');

INSERT INTO `Fuerzas`(`Nombre`) VALUES ('Policia'),('Ejercito'),('Gendarmeria');

