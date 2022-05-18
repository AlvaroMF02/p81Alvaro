CREATE DATABASE  IF NOT EXISTS `p81Alvaro`;
USE `p81Alvaro`;

DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE `proveedores` (
  `codproveedor` int(11) NOT NULL,
  `nomempresa` varchar(50) NOT NULL,
  `nomcontacto` varchar(50) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  `codpostal` char(5) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  PRIMARY KEY (`codproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `proveedores` WRITE;
INSERT INTO `proveedores` VALUES 
	(1,'Cooperativa de Quesos' ,'Antonio del Valle Saavedra ','Calle del Rosal 4','Oviedo','33007','902110011'),
	(2,'Postres para todos','María Reyes','Avda. El rosal s/n','Madrid','28002','912345677'),
	(3,'La pescadilla','Antonio Gutierrez','C/ Calvario 34','Málaga','29017','952230000'),
	(4,'Todotrigo','Luisa Pérez','C/ El viento, 34','Fuengirola','29015','952470000'),
	(5,'Refrescos y bebidas Cantos','Mateo Cantos','Avda. Ischia 12','Estepona','29012','952134567'),
	(6,'Todo del campo','Luciano Sánchez','C/ Agua 1','Málaga','29014','952610000');
    UNLOCK TABLES;
