-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-04-2022 a las 08:38:32
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sofka`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(2) NOT NULL,
  `nom_categoria` varchar(20) NOT NULL,
  `id_premio` int(2) NOT NULL,
  `id_ronda` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nom_categoria`, `id_premio`, `id_ronda`) VALUES
(1, 'FACIL', 1, 1),
(2, 'INTERMEDIO', 2, 2),
(3, 'MEDIO', 3, 3),
(4, 'ALTO', 4, 4),
(5, 'DIFICIL', 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `Id_jugador` int(100) NOT NULL,
  `nom_jugador` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id_pregunta` int(100) NOT NULL,
  `enunciado` varchar(200) NOT NULL,
  `correcta` varchar(100) NOT NULL,
  `res_2` varchar(100) NOT NULL,
  `res_3` varchar(100) NOT NULL,
  `res_4` varchar(100) NOT NULL,
  `id_categoria` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id_pregunta`, `enunciado`, `correcta`, `res_2`, `res_3`, `res_4`, `id_categoria`) VALUES
(1, '¿Cual de estos vehiculos esta provisto de freno de urgencia?', 'Tren', 'Avion', 'Autobus', 'Helicpetero', 1),
(2, '¿cual de estos no es un comestible?', 'Coraza', 'Arandano', 'Cereza', 'Fresa', 1),
(3, '¿Quienes son los fundadores legendarios de roma?', 'Romulo y Remo', 'Zeus y Ares', 'Jesus', 'Chuk Y Get', 1),
(4, '¿Que muestras se exhiben en el famoso muse o de Madame Tussaud?', 'Figuras de Cera', 'Plantas exoticas', 'Animales fosiles', 'Cuadros', 1),
(5, 'Segun el famoso proverbio como se da el gato?', 'Por liebre', 'Por oso', 'Por perro', 'Por raton', 1),
(6, '¿Cual es el otro nombre del petroleo?', 'Oro negro', 'Agua Negra', 'Sangre negra', 'Tierra Negra', 2),
(7, '¿Quien publico la teoria de la relatividad en 1905?', 'Albert Einstein', 'Thomas Edison', 'Johannes Kepler', 'Sigmund Freud', 2),
(8, '¿Cual de estos tipos de leche se almacena a la temperatura interior durante un tiempo mas largo de los otros?', 'En lata', 'Fresca', 'Uperizada', 'Paterizada', 2),
(9, '¿Cuales de estos paises tienen la cuidad de Cartagena?', 'España y Colombia', 'Colombia y Marruecos', 'Marruecos y Argentina', 'España y Chile', 2),
(10, 'Blancanieves y los _____ enanitos', '7', '10', '12', '9', 2),
(11, '¿Como se llaman las sustancias desinfectantes?', 'Antisepticas', 'Antihistaminicas', 'Antipireticas', 'Tranquilizantes', 3),
(12, 'En los juegos olimpicos¿Que se entrega como simbolo de Olimpia?', 'La llama olimpica', 'Bandera Olimpica', 'Bote de premios', 'Medalla Olimpica', 3),
(13, 'Joseph Haydn fue famoso en el dominio de:', 'Musica', 'Matematicas', 'Fisica', 'Pintura', 3),
(14, '¿Que hongos pueden encontrar los cerdos especialmente entrenados?', 'Trufas', 'Rebozuelos', 'Colmenillas', 'Rusulas', 3),
(15, 'El consumo de que sustancia puede ocacionar cirrosis', 'Alcohol', 'Tabaco', 'Marihuana', 'LSD', 3),
(16, '¿Como se llama el arte japones de arreglo floral?', 'Ikebana', 'Sushi', 'Kendo', 'Harakiri', 4),
(17, 'La egiptologia es el estudio de: ', 'El Egipto antiguo', 'El lenguaje', 'La piel ', 'El lenguaje por señas', 4),
(18, '¿Cual es el simbolo principal de los juegos olimpicos?', 'Llama olimpica', 'Mascota olimpica', 'Estadio', 'Medallas', 4),
(19, '¿Cual de las siguentes peliculas esta dirigida por David Lynch?', 'Blue Velvet', 'El elefante blanco', 'El espejo', 'Melancolia', 4),
(20, '¿Cual de los siguientes animales no es in insecto?', 'Cienpies', 'Mosquito', 'Mariposa', 'Mosca', 4),
(21, '¿De que parte de Italia es originaria la organizacion criminal la Cosa Nostra?', 'Sicilia', 'Milan', 'Roma', 'Florencia', 5),
(22, 'En que lugar crian a los perros de utilidad', 'Criadero', 'Vedado', 'Catacumbas', 'Zoologico', 5),
(23, '¿Cual es la capital de la provinvia de Buenos Aires Argentina?', 'La Plata', 'Gran Buenos Aires', 'Mar de la Plata', 'Ciudad de Buenos Aires', 5),
(24, '¿El encendido de un coche se da en?', 'En el motor', 'En e silenciador', 'En el radiador', 'En el habitaculo', 5),
(25, 'Hugh Hefner es el fundador de la famosa revista: ', 'Playboy', 'Vogue', 'People', 'Glamur', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `id_premio` int(3) NOT NULL,
  `nom_premio` varchar(20) NOT NULL,
  `puntaje_premio` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `premio`
--

INSERT INTO `premio` (`id_premio`, `nom_premio`, `puntaje_premio`) VALUES
(1, 'USB', 10),
(2, 'Tablet', 20),
(3, 'Smarth Phone', 30),
(4, 'Portatil', 40),
(5, 'Pc-Mesa', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda`
--

CREATE TABLE `ronda` (
  `id_ronda` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ronda`
--

INSERT INTO `ronda` (`id_ronda`) VALUES
(1),
(2),
(3),
(4),
(5),
(6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`),
  ADD KEY `id_premio` (`id_premio`),
  ADD KEY `id_ronda` (`id_ronda`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`Id_jugador`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`id_pregunta`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`id_premio`);

--
-- Indices de la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`id_ronda`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `Id_jugador` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `id_premio` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`id_premio`) REFERENCES `premio` (`id_premio`),
  ADD CONSTRAINT `categoria_ibfk_2` FOREIGN KEY (`id_ronda`) REFERENCES `ronda` (`id_ronda`);

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
