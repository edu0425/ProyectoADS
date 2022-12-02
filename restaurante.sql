-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2021 a las 18:51:47
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restaurante`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `archivoinsertar` (IN `a_fecha` VARCHAR(20), IN `a_total` INT, IN `a_idcliente` INT)  INSERT INTO archivo(fecha ,total,idcliente) VALUES(a_fecha ,a_total,a_idcliente)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `boletainsertar` (IN `b_cantidad` INT(1), IN `b_precio` INT(25), IN `b_subtotal` INT(1), IN `b_idelemento` INT(2), IN `b_idarchivo` INT(1))  INSERT INTO boleta(cantidad ,precio,subtotal,idelemento,idarchivo ) VALUES (b_cantidad ,b_precio,b_subtotal,b_idelemento,b_idarchivo )$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivo`
--

CREATE TABLE `archivo` (
  `idarchivo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `archivo`
--

INSERT INTO `archivo` (`idarchivo`, `fecha`, `total`, `idcliente`) VALUES
(1, '2021-07-22', 50, 9),
(2, '2021-07-22', 34, 10),
(3, '2021-07-22', 50, 11),
(4, '2021-07-22', 72, 12),
(5, '2021-07-23', 45, 13),
(6, '2021-07-23', 45, 14),
(7, '2021-07-23', 70, 16),
(8, '2021-07-23', 44, 17),
(9, '2021-07-27', 65, 20),
(10, '2021-07-27', 105, 15),
(11, '2021-07-27', 135, 15),
(12, '2021-07-28', 98, 23),
(13, '2021-07-28', 120, 26),
(14, '2021-07-28', 99, 28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE `boleta` (
  `idboleta` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `precio` double NOT NULL,
  `subtotal` double NOT NULL,
  `idelemento` int(10) NOT NULL,
  `idarchivo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `boleta`
--

INSERT INTO `boleta` (`idboleta`, `cantidad`, `precio`, `subtotal`, `idelemento`, `idarchivo`) VALUES
(1, 1, 20, 130, 13, 1),
(12, 1, 15, 15, 2, 5),
(13, 2, 15, 30, 16, 5),
(14, 1, 15, 15, 2, 6),
(15, 3, 10, 30, 17, 6),
(16, 2, 20, 40, 1, 7),
(17, 3, 10, 30, 17, 7),
(18, 1, 4, 4, 18, 8),
(19, 2, 20, 40, 3, 8),
(20, 3, 15, 45, 2, 9),
(21, 2, 10, 20, 15, 9),
(22, 3, 35, 105, 6, 10),
(23, 3, 35, 105, 6, 11),
(24, 3, 10, 30, 15, 11),
(25, 2, 25, 50, 13, 12),
(26, 4, 12, 48, 20, 12),
(27, 2, 40, 80, 9, 13),
(28, 4, 10, 40, 19, 13),
(29, 3, 25, 75, 11, 14),
(30, 2, 12, 24, 20, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `numero` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre`, `numero`) VALUES
(1, 'EDGAR CUSI', 981347777),
(2, 'MARIA OSCCORIMA', 981347224),
(4, 'SERGIO MADRID', 999234555),
(6, 'DAYANA PEREZ', 999999999),
(7, 'EDGAR CUSI', NULL),
(8, 'MARIA CUSI', NULL),
(9, 'ed', NULL),
(10, 'ANALI QUISPE', NULL),
(11, 'MELISA PEREZ', NULL),
(12, 'MONICA CHAVEZ', NULL),
(13, 'ANDRES MARTIN ADAN', NULL),
(14, 'NGELA CUSI', NULL),
(15, 'Humberto', NULL),
(16, 'EMERSON QUISPE', NULL),
(17, 'Angela Cusi', NULL),
(18, 'Angela', 985678951),
(19, 'EDGAR CUSI', 981347777),
(20, 'Juancito', 999888777),
(21, 'Luis', NULL),
(22, 'Pedro', NULL),
(23, 'Sebastian', NULL),
(24, 'Juan', 999888777),
(26, 'Enrrique', NULL),
(27, 'Tito', 963852741),
(28, 'Carlos', NULL),
(29, 'Edgar', 987654321);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `elemento`
--

CREATE TABLE `elemento` (
  `idelemento` int(11) NOT NULL,
  `elemento` varchar(50) NOT NULL,
  `precio` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `elemento`
--

INSERT INTO `elemento` (`idelemento`, `elemento`, `precio`) VALUES
(1, 'MENU MARINO', 20),
(2, 'MENU CRIOLLO', 15),
(3, 'LECHE DE TIGRE', 20),
(4, 'CHORITOS A LA CHALACA', 25),
(5, 'CEVICHE', 35),
(6, 'CHICHARRON', 35),
(7, 'ARROZ CON MARISCO', 30),
(8, 'CHUPE DE MARISCO', 35),
(9, 'JALEA MIXTA', 40),
(10, 'TIRADITO DE CORVINA', 38),
(11, 'LOMO SALTADO', 25),
(12, 'BISTEC A LO POBRE', 30),
(13, 'CHAUFA', 25),
(14, 'CHICHA MORADA', 15),
(15, 'MARACUYÁ', 10),
(16, 'LIMONADA', 15),
(17, 'GASEOSA 1.5L', 10),
(18, 'GASEOSA 0.5L', 4),
(19, 'CERVEZA PILSEN', 10),
(20, 'CERVEZA CUZQUEÑA', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idreserva` int(10) NOT NULL,
  `npersonas` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `idcliente` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idreserva`, `npersonas`, `fecha`, `hora`, `idcliente`) VALUES
(1, 3, '2021-06-11', '10:20', 1),
(3, 12, '2021-05-11', '12', 2),
(4, 1, '2021-07-23', '1:00', 4),
(6, 2, '2021-07-30', '6:30', 18),
(10, 10, '2021-07-28', '16:30', 27),
(11, 8, '2021-07-28', '23:45', 29);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `archivo`
--
ALTER TABLE `archivo`
  ADD PRIMARY KEY (`idarchivo`),
  ADD KEY `arc_cli_cfk` (`idcliente`);

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD PRIMARY KEY (`idboleta`),
  ADD KEY `bol_ele_cfk` (`idelemento`),
  ADD KEY `arc_bol_cfk` (`idarchivo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indices de la tabla `elemento`
--
ALTER TABLE `elemento`
  ADD PRIMARY KEY (`idelemento`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idreserva`),
  ADD KEY `res_cli_cfk` (`idcliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `archivo`
--
ALTER TABLE `archivo`
  MODIFY `idarchivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `boleta`
--
ALTER TABLE `boleta`
  MODIFY `idboleta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `elemento`
--
ALTER TABLE `elemento`
  MODIFY `idelemento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idreserva` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `archivo`
--
ALTER TABLE `archivo`
  ADD CONSTRAINT `arc_cli_cfk` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`);

--
-- Filtros para la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD CONSTRAINT `arc_bol_cfk` FOREIGN KEY (`idarchivo`) REFERENCES `archivo` (`idarchivo`),
  ADD CONSTRAINT `bol_ele_cfk` FOREIGN KEY (`idelemento`) REFERENCES `elemento` (`idelemento`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `res_cli_cfk` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
