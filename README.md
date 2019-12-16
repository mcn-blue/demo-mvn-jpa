# demo-mvn-jpa

Mantenedor de Clientes Demo

Desarrollado con eclipse Spring Tool Suite

Base de datos mysql

edicion de datos de conexion en src\main\resources\application.properties

CREATE DATABASE `demo` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

INSERT INTO `demo`.`cliente` ( `age`, `name`) VALUES ( 20, 'Azu');

Tecnologias Fron-end

AngularJS,
Bootstrap,
Jquery,
Jquery-floatHead,


Tecnologias Back-end

Spring,
JPA

Consumos de servicios REST por Ajax con AnjularJS

