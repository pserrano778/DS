-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2020 a las 01:49:40
-- Versión del servidor: 10.4.11-MariaDB-log
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
-- Base de datos: `ruletapalabras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticas`
--

CREATE TABLE `estadisticas` (
  `usuario` varchar(15) NOT NULL,
  `ruletasFinalizadas` int(11) NOT NULL DEFAULT 0,
  `totalAciertos` int(11) NOT NULL DEFAULT 0,
  `totalSinResponder` int(11) NOT NULL DEFAULT 0,
  `totalErrores` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estadisticas`
--

INSERT INTO `estadisticas` (`usuario`, `ruletasFinalizadas`, `totalAciertos`, `totalSinResponder`, `totalErrores`) VALUES
('user', 0, 0, 0, 0),
('usuario', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `palabra`
--

CREATE TABLE `palabra` (
  `palabra` varchar(20) NOT NULL,
  `definicion` text NOT NULL,
  `letra` enum('a','b','c','d','e','f','g','h','i','j','l','m','n','ni','o','p','q','r','s','t','u','v','x','y','z') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `palabra`
--

INSERT INTO `palabra` (`palabra`, `definicion`, `letra`) VALUES
('a', 'Primera letra del abecedario español, que representa el fonema vocálico abierto central.', 'a'),
('abeja', 'Insecto himenóptero, de unos quince milímetros de largo, de color pardo negruzco y vello rojizo, que vive en colonias y produce cera y miel.', 'a'),
('agua', 'Líquido transparente, incoloro, inodoro e insípido en estado puro, cuyas moléculas están formadas por dos átomos de hidrógeno y uno de oxígeno, y que constituye el componente más abundante de la superficie terrestre y el mayoritario de todos los organismos vivos.', 'a'),
('árbol', 'Planta perenne, de tronco leñoso y elevado, que se ramifica a cierta altura del suelo.', 'a'),
('atril', 'Mueble en forma de plano inclinado, con pie o sin él, que sirve para sostener libros, partituras, etc., y leer con más comodidad.', 'a'),
('avestruz', 'Ave del orden de las estrucioniformes, de gran tamaño, que llega a los dos metros de altura, alas cortas no aptas para el vuelo, cuello largo y desnudo, largas patas que le permiten correr a gran velocidad, y que habita en África y en Arabia.', 'a'),
('b', 'Segunda letra del abecedario español, que representa el fonema consonántico bilabial sonoro.', 'b'),
('basto', 'Palo de los cuatro que constituyen la baraja española, cuyas cartas llevan estampados uno o varios leños en forma de porras toscas.', 'b'),
('basura', 'Residuos desechados y otros desperdicios.', 'b'),
('beber', 'Ingerir un líquido.', 'b'),
('bosque', 'Sitio poblado de árboles y matas.', 'b'),
('buscar', 'Hacer algo para hallar a alguien o algo.', 'b'),
('c', ' Tercera letra del abecedario español, que representa, ante las vocales a, o, u, el fonema consonántico oclusivo velar sordo, y ante e, i, el fonema consonántico fricativo interdental sordo en áreas no seseantes, y algún alófono de /s/ en áreas de seseo.', 'c'),
('casa', 'Edificio para habitar', 'c'),
('cascanueces', 'Instrumento a modo de tenaza para partir nueces.', 'c'),
('castillo', 'Lugar fuerte, cercado de murallas, baluartes, fosos y otras fortificaciones.', 'c'),
('castor', 'Mamífero roedor de hasta 65 cm de largo, pelo castaño muy fino, patas cortas, pies con cinco dedos palmeados, cola aplastada, oval y escamosa, que habita en Asia, América septentrional y norte de Europa, y construye sus viviendas formando diques de gran extensión en ríos y lagos.', 'c'),
('coco', 'Árbol de la familia de las palmas, que suele alcanzar de 20 a 25 m de altura, con las hojas divididas en lacinias ensiformes plegadas hacia atrás, y flores en racimos. Suele producir anualmente dos o tres veces su fruto. Del tronco se saca una bebida alcohólica.', 'c'),
('d', 'Cuarta letra del abecedario español, que representa el fonema consonántico dental sonoro.', 'd'),
('dado', 'En los juegos de azar, objeto generalmente cúbico en cuyas caras aparecen puntos, que representan distintos números, o figuras diferentes.', 'd'),
('dedal', 'Utensilio pequeño, ligeramente cónico y hueco, con la superficie llena de hoyuelos y cerrado a veces por un casquete esférico para proteger el dedo al coser.', 'd'),
('dedo', 'Cada uno de los cinco apéndices articulados en que terminan la mano y el pie del hombre y, en el mismo o menor número, de muchos animales.', 'd'),
('derogar', 'Dejar sin efecto una norma vigente.', 'd'),
('diente', 'Cuerpo duro que, engastado en las mandíbulas del hombre y de muchos animales, queda descubierto en parte, para servir como órgano de masticación o de defensa.', 'd'),
('e', 'Quinta letra del abecedario español, que representa el fonema vocálico medio anterior.', 'e'),
('escalar', 'Subir, trepar por una gran pendiente o a una gran altura.', 'e'),
('espada', 'Arma blanca, larga, recta, aguda y cortante, con guarnición y empuñadura.', 'e'),
('estable', 'Que se mantiene sin peligro de cambiar, caer o desaparecer.', 'e'),
('estornudar', 'Despedir o arrojar con violencia el aire de los pulmones, por la espiración involuntaria y repentina promovida por un estímulo que actúa sobre la membrana pituitaria.', 'e'),
('estupidez', 'Torpeza notable en comprender las cosas.', 'e'),
('f', 'Sexta letra del abecedario español, que representa el fonema consonántico fricativo labiodental sordo.', 'f'),
('fachada', 'Paramento exterior de un edificio, especialmente el principal.', 'f'),
('fascinante', 'Sumamente atractivo.', 'f'),
('febledad', 'Debilidad, flaqueza.', 'f'),
('febrero', 'Segundo mes del año, que en los comunes tiene 28 días y en los bisiestos 29.', 'f'),
('ferrocarril', ' Conjunto de instalaciones, vehículos y equipos que constituyen el tren.', 'f'),
('g', 'Séptima letra del abecedario español, que representa, ante las vocales e, i, el fonema consonántico fricativo velar sordo, y en los demás casos el fonema consonántico velar sonoro.', 'g'),
('gabacho', 'Natural de algún pueblo de las faldas de los Pirineos.', 'g'),
('gabardina', 'Tela resistente de tejido diagonal.', 'g'),
('gobelino', 'Tapicero de la fábrica que estableció el rey de Francia Luis XIV en la de tejidos fundada por Gobelin.', 'g'),
('guijarro', 'Pequeño canto rodado.', 'g'),
('gusano', 'Nombre común que se aplica a animales metazoos, invertebrados, de vida libre o parásitos, de cuerpo blando, segmentado o no y ápodo.', 'g'),
('h', 'Octava letra del abecedario español, que en la lengua estándar actual no representa sonido alguno, si bien se aspira en determinadas voces de origen extranjero y en algunas zonas españolas y americanas como rasgo dialectal.', 'h'),
('habanero', 'Natural de La Habana, capital de Cuba y de la provincia de Ciudad de La Habana.', 'h'),
('hebilla', 'Pieza de metal o de otra materia, generalmente con uno o varios clavos articulados en una varilla que la cierra por un lado, los cuales sujetan la correa, cinta, etc., que pasa por dicha pieza.', 'h'),
('hebreo', 'Dicho de una persona: Del pueblo semítico, también llamado israelita y judío, que conquistó y habitó la antigua región de Canaán, después Palestina.', 'h'),
('helado', 'Alimento dulce, hecho generalmente con leche o zumo de frutas, que se consume en cierto grado de congelación.', 'h'),
('humo', 'Mezcla visible de gases producida por la combustión de una sustancia, generalmente compuesta de carbono, y que arrastra partículas en suspensión.', 'h'),
('i', 'Novena letra del abecedario español, que representa el fonema vocálico cerrado anterior.', 'i'),
('ilegal', 'Contrario a la ley.', 'i'),
('ira', 'Sentimiento de indignación que causa enojo.', 'i'),
('isla', 'Porción de tierra rodeada de agua por todas partes.', 'i'),
('iterar', 'Capaz de repetirse.', 'i'),
('iva', 'Impuesto indirecto sobre el consumo y la prestación de servicios empresariales o profesionales, repercutible en cada una de las fases del proceso económico.', 'i'),
('j', 'Décima letra del abecedario español, que representa el fonema consonántico fricativo velar sordo, el cual, en zonas meridionales de España y amplias zonas de América, se relaja hasta hacerse aspirado.', 'j'),
('jabalina', 'Arma, a manera de pica o venablo, que se usaba más comúnmente en la caza mayor, y actualmente en una modalidad deportiva.', 'j'),
('jabato', 'Cría de jabalí.', 'j'),
('jaguar', 'Felino americano de hasta dos metros de longitud y unos 80 cm de alzada, pelaje de color amarillo dorado con manchas en forma de anillos negros, garganta y vientre blanquecinos, que vive en zonas pantanosas de América, desde California hasta la Patagonia.', 'j'),
('jugar', 'Hacer algo con alegría con el fin de entretenerse, divertirse o desarrollar determinadas capacidades.', 'j'),
('juzgar', 'Formar opinión sobre algo o alguien.', 'j'),
('l', 'Duodécima letra del abecedario español, que representa el fonema consonántico lateral alveolar.', 'l'),
('lanzar', 'Arrojar.', 'l'),
('legado', 'Disposición legalmente formalizada que de un bien o de una parte del conjunto de sus bienes hace el testador a favor de alguien y que debe ser respetada por el heredero o herederos.', 'l'),
('legal', 'Prescrito por ley y conforme a ella.', 'l'),
('lienzo', 'Tela preparada para pintar sobre ella.', 'l'),
('lucrar', 'Ganar, sacar provecho de un negocio o encargo.', 'l'),
('m', 'Decimotercera letra del abecedario español, que representa el fonema consonántico nasal bilabial.', 'm'),
('madre', 'Mujer que ha concebido o ha parido uno o más hijos.', 'm'),
('madriguera', 'Cueva en que habitan ciertos animales, especialmente los conejos.', 'm'),
('mamut', 'Especie de elefante fósil que vivió en las regiones de clima frío durante la época cuaternaria. Tenía la piel cubierta de pelo áspero y largo, los dientes incisivos de la mandíbula superior, curvos y tan desarrollados, que se hallan algunos de tres metros.', 'm'),
('mascar', 'Partir y triturar algo con la dentadura.', 'm'),
('mastodonte', 'Mamífero fósil, parecido al elefante, con dos dientes incisivos en cada mandíbula, que llegan a tener más de un metro de longitud, y molares en los que sobresalen puntas redondeadas a manera de mamas, y cuyos restos se encuentran en los terrenos terciarios.', 'm'),
('n', 'Decimocuarta letra del abecedario español, que representa el fonema consonántico nasal alveolar, aunque cuando es implosiva suele adoptar la zona de articulación de la consonante siguiente.', 'n'),
('ñame', 'Persona que da muestras de escasa inteligencia, cultura o instrucción.', 'ni'),
('ñampearse', 'Volverse loco.', 'ni'),
('naranja', 'Fruto del naranjo, de forma globosa, de seis a ocho centímetros de diámetro, corteza rugosa, de color entre rojo y amarillo, como el de la pulpa, que está dividida en gajos, y es comestible, jugosa y de sabor agridulce.', 'n'),
('ñeco', 'Dicho de una persona: Que ha perdido un brazo o una mano, o los tiene inutilizados.', 'ni'),
('negligencia', 'Descuido, falta de cuidado.', 'n'),
('niñez', 'Período de la vida humana, que se extiende desde el nacimiento a la pubertad.', 'n'),
('ñipe', 'Arbusto de la familia de las mirtáceas, cuyas ramas se emplean para teñir.', 'ni'),
('ñire', 'Árbol o arbusto de la familia de las fagáceas, de hojas caedizas y polimorfas, propio de los bosques andino-patagónicos. Toma frecuentemente un porte achaparrado y carece de valor forestal.', 'ni'),
('nirvana', 'En algunas religiones de la India, estado resultante de la liberación de los deseos, de la consciencia individual y de la reencarnación, que se alcanza mediante la meditación y la iluminación.', 'n'),
('ñoña', 'Dicho de una cosa: Sosa, de poca sustancia.', 'ni'),
('noticia', 'Información sobre algo que se considera interesante divulgar.', 'n'),
('o', 'Decimosexta letra del abecedario español, que representa el fonema vocálico medio posterior.', 'o'),
('opaco', 'Que impide el paso a la luz, a diferencia de diáfano.', 'o'),
('opio', 'Extracto de la adormidera que contiene diversos alcaloides, como la morfina, la codeína y la papaverina, muy adictivo y con propiedades analgésicas, narcóticas y astringentes.', 'o'),
('oracular', 'Propio o característico de un oráculo.', 'o'),
('osado', 'Que tiene osadía.', 'o'),
('oscuro', 'Que carece de luz o claridad.', 'o'),
('p', 'Decimoséptima letra del abecedario español, que representa el fonema consonántico oclusivo bilabial sordo.', 'p'),
('paisaje', 'Parte de un territorio que puede ser observada desde un determinado lugar.', 'p'),
('pesadilla', 'Ensueño angustioso y tenaz.', 'p'),
('pescado', 'Pez comestible sacado del agua por cualquiera de los procedimientos de pesca.', 'p'),
('poblado', 'Población, ciudad, villa o lugar.', 'p'),
('prestigio', 'Pública estima de alguien o de algo, fruto de su mérito.', 'p'),
('q', 'Decimoctava letra del abecedario español, que representa el fonema consonántico oclusivo velar sordo.', 'q'),
('que', 'Introduce el segundo término en las comparativas de desigualdad, normalmente en correlación con más o menos.', 'q'),
('quemar', 'Destruir algo o a alguien con fuego.', 'q'),
('queso', 'Producto obtenido por maduración de la cuajada de la leche con características propias para cada uno de los tipos según su origen o método de fabricación.', 'q'),
('quiche', 'Bromeliácea epifita de hojas acanaladas y espigas de flores con brácteas rojas.', 'q'),
('quorum', 'Número de individuos necesario para que un cuerpo deliberante tome ciertos acuerdos.', 'q'),
('r', 'Decimonovena letra del abecedario español, que puede representar el fonema consonántico vibrante simple, o el fonema consonántico vibrante múltiple.', 'r'),
('rata', 'Mamífero roedor, de unos 36 cm desde el hocico a la extremidad de la cola, muy larga, con cabeza pequeña, hocico puntiagudo, orejas tiesas, cuerpo grueso, patas cortas, pelaje gris oscuro, muy fecundo y voraz.', 'r'),
('reabrir', 'Volver a abrir lo que estaba cerrado.', 'r'),
('residuo', 'Aquello que resulta de la descomposición o destrucción de algo.', 'r'),
('reverso', 'Parte opuesta al frente de una cosa.', 'r'),
('ruleta', 'Rueda giratoria utilizada en juegos de azar.', 'r'),
('s', 'Vigésima letra del abecedario español, que representa el fonema consonántico fricativo dentoalveolar sordo, el cual, entre muchas variedades de articulación, tiene dos principales: la apical y la predorsal.', 's'),
('saciar', 'Hacer que alguien vea cumplidos o resueltos un deseo o una necesidad anímica.', 's'),
('secar', 'Extraer la humedad, o hacer que se evapore de un cuerpo mojado, mediante el aire o el calor que se le aplica.', 's'),
('silvestre', 'Dicho de un animal: No domesticado.', 's'),
('siniestro', 'Avieso y malintencionado.', 's'),
('sirena', 'Ninfa marina con busto de mujer y cuerpo de ave según la tradición grecolatina, y con cuerpo de pez en otras tradiciones, que extraviaba a los navegantes atrayéndolos con la dulzura de su canto.', 's'),
('t', 'Vigesimoprimera letra del abecedario español, que representa el fonema consonántico oclusivo dental sordo.', 't'),
('terrorista', 'Que practica actos de terrorismo.', 't'),
('trapo', 'Paño de uso doméstico para secar, limpiar, quitar el polvo, etc.', 't'),
('tribu', 'Cada uno de los grupos de origen familiar que existían en algunos pueblos antiguos.', 't'),
('tronco', 'Tallo fuerte y macizo de los árboles y arbustos.', 't'),
('tropezar', 'Dicho de una persona: Dar con los pies en un obstáculo al ir andando, con lo que se puede caer.', 't'),
('u', 'Vigesimosegunda letra del abecedario español, que representa el fonema vocálico cerrado posterior.', 'u'),
('umbral', 'Valor mínimo de una magnitud a partir del cual se produce un efecto determinado.', 'u'),
('uralita', 'Material de construcción hecho a base de cemento y de fibras, generalmente de asbesto, usado sobre todo en cubiertas y tejados.', 'u'),
('urticaria', 'Enfermedad eruptiva de la piel, cuyo síntoma más notable es una comezón parecida a la que producen las picaduras de la ortiga.', 'u'),
('usar', 'Hacer servir una cosa para algo.', 'u'),
('uva', 'Baya o grano más o menos redondo y jugoso, fruto de la vid, que forma racimos.', 'u'),
('v', 'Vigesimotercera letra del abecedario español, que, al igual que la b, representa el fonema consonántico oclusivo bilabial sonoro.', 'v'),
('vaca', 'Hembra del toro.', 'v'),
('vaciar', 'Dejar vacío algo.', 'v'),
('vencer', 'Sujetar, derrotar o rendir al enemigo.', 'v'),
('viable', 'Dicho de un asunto: Que, por sus circunstancias, tiene probabilidades de poderse llevar a cabo.', 'v'),
('viscoso', 'Pegajoso, glutinoso.', 'v'),
('x', 'Vigesimoquinta letra del abecedario español, que, al igual que la s, representa el fonema fricativo dentoalveolar sordo en posición inicial de palabra, y el grupo formado por el fonema oclusivo velar sordo y el fonema fricativo dentoalveolar sordo en posición intervocálica, y a final de sílaba o de palabra.', 'x'),
('xantina', 'Compuesto derivado de la purina, que tiene efectos estimulantes sobre el sistema nervioso y el corazón, diuréticos y broncodilatadores; p. ej., la cafeína, la teofilina y la teobromina.', 'x'),
('xerocopia', 'Compuesto derivado de la purina, que tiene efectos estimulantes sobre el sistema nervioso y el corazón, diuréticos y broncodilatadores; p. ej., la cafeína, la teofilina y la teobromina.', 'x'),
('xerocopiar', 'Reproducir en copia xerográfica.', 'x'),
('xifoideo', 'Perteneciente o relativo al apéndice xifoides.', 'x'),
('xifoides', 'Dicho de un apéndice: Cartilaginoso, de forma puntiaguda y que constituye el extremo del esternón del ser humano.', 'x'),
('y', 'Vigesimosexta letra del abecedario español, que representa, cuando aparece aislada o en final de palabra precedida de una vocal, el fonema vocálico cerrado anterior y, en las demás posiciones, el fonema consonántico palatal sonoro.', 'y'),
('yayo', 'Abuelo.', 'y'),
('yeco', 'Especie de cormorán.', 'y'),
('yo', 'Parte consciente del individuo, mediante la cual cada persona se hace cargo de su propia identidad y de sus relaciones con el medio.', 'y'),
('yodar', 'Aplicar o añadir yodo a una sustancia.', 'y'),
('yodo', 'Elemento químico de núm. atóm. 53, de color azul violeta y muy reactivo, que se encuentra principalmente en el nitrato de Chile, en el agua del mar y concentrado en ciertas algas marinas, forma parte de la estructura de las hormonas tiroideas y se usa como colorante, como reactivo en química y fotografía, y como desinfectante en medicina.', 'y'),
('z', 'Vigesimoséptima letra del abecedario español, que representa el fonema fricativo interdental sordo en los territorios no seseantes, y en las áreas seseantes el mismo fonema que la letra s.', 'z'),
('zabarcero', 'Persona que revende por menudo frutos y otros comestibles.', 'z'),
('zamanca', 'Paliza, zurra, somanta.', 'z'),
('zoca', 'Plaza de una población.', 'z'),
('zona', 'Parte de terreno o de superficie encuadrada entre ciertos límites.', 'z'),
('zoquete', 'Persona tarda en comprender.', 'z');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombreUsuario` varchar(15) NOT NULL,
  `password` varchar(200) NOT NULL,
  `ruleta` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombreUsuario`, `password`, `ruleta`) VALUES
('user', '$2y$10$btB4A8ynj3bmczzvKKXrXevKjQyiosEJnigAebsyJZYsg/KdZvKMm', NULL),
('usuario', '$2y$10$Pw/8/4m3f0DedzAc3jq6oOaQFK5M.1hU0mBi6yJ8mr9iF3D10bQT6', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `palabra`
--
ALTER TABLE `palabra`
  ADD PRIMARY KEY (`palabra`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nombreUsuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD CONSTRAINT `user` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`nombreUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
