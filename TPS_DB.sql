-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 19-07-2020 a las 20:57:38
-- Versión del servidor: 5.7.28
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tps_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

DROP TABLE IF EXISTS `articulo`;
CREATE TABLE IF NOT EXISTS `articulo` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArticulo` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `precioArticulo` int(20) NOT NULL,
  `cantidadArticulo` int(10) NOT NULL,
  PRIMARY KEY (`idArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`idArticulo`, `nombreArticulo`, `precioArticulo`, `cantidadArticulo`) VALUES
(1, 'Botas', 68000, 350),
(2, 'Botas de agua', 50000, 61),
(3, 'Babucha', 65000, 73),
(4, 'Alpargata', 67200, 438),
(5, 'Calzado bailarina', 64000, 340),
(6, 'Plantilla', 8300, 140);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion_entrada`
--

DROP TABLE IF EXISTS `devolucion_entrada`;
CREATE TABLE IF NOT EXISTS `devolucion_entrada` (
  `idDevolucionEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `idEntrada` int(11) NOT NULL,
  `fechaDevEntrada` date NOT NULL,
  `cantidadDevEntrada` int(10) NOT NULL,
  PRIMARY KEY (`idDevolucionEntrada`),
  KEY `idEntrada` (`idEntrada`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `devolucion_entrada`
--

INSERT INTO `devolucion_entrada` (`idDevolucionEntrada`, `idEntrada`, `fechaDevEntrada`, `cantidadDevEntrada`) VALUES
(1, 4, '2020-07-19', 120),
(2, 6, '2020-07-19', 34),
(3, 4, '2020-07-19', 56),
(4, 1, '2020-07-19', 90),
(5, 4, '2020-07-19', 62);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion_salida`
--

DROP TABLE IF EXISTS `devolucion_salida`;
CREATE TABLE IF NOT EXISTS `devolucion_salida` (
  `idDevolucionSalida` int(11) NOT NULL AUTO_INCREMENT,
  `idSalida` int(11) NOT NULL,
  `fechaDevSalida` date NOT NULL,
  `cantidadDevSalida` int(10) NOT NULL,
  PRIMARY KEY (`idDevolucionSalida`),
  KEY `idSalida` (`idSalida`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `devolucion_salida`
--

INSERT INTO `devolucion_salida` (`idDevolucionSalida`, `idSalida`, `fechaDevSalida`, `cantidadDevSalida`) VALUES
(1, 2, '2020-07-19', 30),
(2, 3, '2020-07-19', 58),
(3, 1, '2020-07-19', 100),
(4, 6, '2020-07-19', 12),
(5, 4, '2020-07-19', 122);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

DROP TABLE IF EXISTS `entrada`;
CREATE TABLE IF NOT EXISTS `entrada` (
  `idEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `idArticulo` int(11) NOT NULL,
  `fechaEtrada` date NOT NULL,
  `cantidadArticulo` int(10) NOT NULL,
  PRIMARY KEY (`idEntrada`),
  KEY `idArticulo` (`idArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`idEntrada`, `idArticulo`, `fechaEtrada`, `cantidadArticulo`) VALUES
(1, 4, '2020-07-19', 10),
(2, 2, '2020-07-19', 28),
(3, 4, '2020-07-19', 64),
(4, 1, '2020-07-19', 142),
(5, 5, '2020-07-19', 246),
(6, 3, '2020-07-19', 538);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

DROP TABLE IF EXISTS `salida`;
CREATE TABLE IF NOT EXISTS `salida` (
  `idSalida` int(11) NOT NULL AUTO_INCREMENT,
  `idArticulo` int(11) NOT NULL,
  `fechaSalida` date NOT NULL,
  `cantidadArticulo` int(10) NOT NULL,
  PRIMARY KEY (`idSalida`),
  KEY `idArticulo` (`idArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `salida`
--

INSERT INTO `salida` (`idSalida`, `idArticulo`, `fechaSalida`, `cantidadArticulo`) VALUES
(1, 2, '2020-07-19', 100),
(2, 5, '2020-07-19', 90),
(3, 3, '2020-07-19', 85),
(4, 6, '2020-07-19', 80),
(5, 2, '2020-07-19', 100),
(6, 2, '2020-07-19', 12);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `devolucion_entrada`
--
ALTER TABLE `devolucion_entrada`
  ADD CONSTRAINT `devolucion_entrada_ibfk_1` FOREIGN KEY (`idEntrada`) REFERENCES `entrada` (`idEntrada`);

--
-- Filtros para la tabla `devolucion_salida`
--
ALTER TABLE `devolucion_salida`
  ADD CONSTRAINT `devolucion_salida_ibfk_1` FOREIGN KEY (`idSalida`) REFERENCES `salida` (`idSalida`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`idArticulo`) REFERENCES `articulo` (`idArticulo`);

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `salida_ibfk_1` FOREIGN KEY (`idArticulo`) REFERENCES `articulo` (`idArticulo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
