USE prueba;

-- Eliminar todas las tablas si existen
DROP TABLE IF EXISTS comentarios;
DROP TABLE IF EXISTS ideas;
DROP TABLE IF EXISTS participante;
DROP TABLE IF EXISTS propuesta;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS proyecto;

-- create table proyecto
CREATE TABLE proyecto (
  id_proyecto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  fecha_de_creacion DATE NOT NULL
);

-- create table funcionario
CREATE TABLE funcionario (
  id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  celular VARCHAR(50) NOT NULL,
  correo VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  contrasena VARCHAR(50) NOT NULL
);


-- create table propuesta
CREATE TABLE propuesta (
  id_propuesta INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  url_archivo VARCHAR(50) NOT NULL,
  estado VARCHAR(50) NOT NULL,
  id_funcionario INT NOT NULL,
  id_proyecto INT NOT NULL,
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario),
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)
);

-- create table participante
CREATE TABLE participante (
  id_participante INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  es_participante_interno BOOLEAN NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  username VARCHAR(20) NOT NULL UNIQUE,
  contrasena VARCHAR(50) NOT NULL,
  celular VARCHAR(10) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  fecha_union DATE NOT NULL,
  correo VARCHAR(50) NOT NULL UNIQUE,
  
  id_proyecto INT NOT NULL,
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)
);

-- create table ideas
CREATE TABLE ideas (
  id_idea INT PRIMARY KEY AUTO_INCREMENT,
  nivel INT NOT NULL,
  formato VARCHAR(50) NOT NULL,
  id_funcionario_lider INT NOT NULL,
  id_funcionario_generador INT NOT NULL,
  id_proyecto INT NOT NULL,
  FOREIGN KEY (id_funcionario_lider) REFERENCES funcionario(id_funcionario),
  FOREIGN KEY (id_funcionario_generador) REFERENCES funcionario(id_funcionario),
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)
);

-- create table comentarios
CREATE TABLE comentarios (
  id_comentario INT PRIMARY KEY AUTO_INCREMENT,
  comentario VARCHAR(200) NOT NULL,
  fecha_publicacion DATE NOT NULL,
  calificacion FLOAT NOT NULL, -- Cambio de tipo de datos
  id_comentario_replicado INT DEFAULT NULL,
  id_participante INT NOT NULL,
  id_idea INT NOT NULL,
  FOREIGN KEY (id_comentario_replicado) REFERENCES comentarios(id_comentario),
  FOREIGN KEY (id_participante) REFERENCES participante(id_participante),
  FOREIGN KEY (id_idea) REFERENCES ideas(id_idea)  
);

-- Insertar registros en la tabla proyecto
INSERT INTO proyecto (nombre, fecha_de_creacion) VALUES
('Proyecto 1', '2024-01-01'),
('Proyecto 2', '2024-02-15'),
('Proyecto 3', '2024-03-10'),
('Proyecto 4', '2024-04-05'),
('Proyecto 5', '2024-01-20'),
('Proyecto 6', '2024-02-28'),
('Proyecto 7', '2024-03-15'),
('Proyecto 8', '2024-04-10'),
('Proyecto 9', '2024-02-05'),
('Proyecto 10', '2024-03-01');

-- Insertar registros en la tabla funcionario
INSERT INTO funcionario (nombre, apellido, direccion, celular, correo, username, contrasena) VALUES
('Juan', 'Perez', 'Calle 123', '123456789', 'juan@example.com', 'juanperez', 'dasdsadsdsa'),
('María', 'González', 'Avenida 456', '987654321', 'maria@example.com', 'mariagonzalez', 'contraseñad22232'),
('Pedro', 'Sánchez', 'Calle 789', '456789123', 'pedro@example.com', 'pedrosanchez', 'sdsdsad'),
('Laura', 'López', 'Avenida 789', '789123456', 'laura@example.com', 'lauralopez', 'contraseña4'),
('Carlos', 'Martínez', 'Calle 456', '654321987', 'carlos@example.com', 'carlosmartinez', 'asdsddsds'),
('Ana', 'Ruiz', 'Avenida 123', '321654987', 'ana@example.com', 'anaruiz', 'contraseña6'),
('Luis', 'Díaz', 'Calle 789', '987321654', 'luis@example.com', 'luisdiaz', 'contraseña7'),
('Sofía', 'Fernández', 'Avenida 456', '789654321', 'sofia@example.com', 'sofiafernandez', 'contsdssdsraseña8'),
('Diego', 'Gómez', 'Calle 123', '456987321', 'diego@example.com', 'diegogomez', 'contraseña9'),
('Elena', 'Hernández', 'Avenida 789', '321987654', 'elena@example.com', 'elenahernandez', 'contraseña10');

-- Insertar registros en la tabla propuesta
-- Se relacionan con un proyecto y un funcionario aleatorio
INSERT INTO propuesta (nombre, url_archivo, estado, id_funcionario, id_proyecto) VALUES
('Propuesta 1', 'url1', 'Aceptada', 1, 1),
('Propuesta 2', 'url2', 'Pendiente', 2, 2),
('Propuesta 3', 'url3', 'Rechazada', 3, 1),
('Propuesta 4', 'url4', 'Aceptada', 4, 1),
('Propuesta 5', 'url5', 'Pendiente', 1, 5),
('Propuesta 6', 'url6', 'Rechazada', 6, 6),
('Propuesta 7', 'url7', 'Aceptada', 7, 7),
('Propuesta 8', 'url8', 'Pendiente', 8, 8),
('Propuesta 9', 'url9', 'Rechazada', 9, 9),
('Propuesta 10', 'url10', 'Aceptada', 10, 10);

-- Insertar registros en la tabla participante
-- Se relacionan con un proyecto aleatorio
INSERT INTO participante (nombre, es_participante_interno, apellido, username, contrasena, celular, direccion, fecha_union, correo, id_proyecto) VALUES
('Participant1', true, 'Apellido1', 'participante1', 'contraseña1', '1234567890', 'Dirección 1', '2024-01-01', 'correo1@example.com', 1),
('Participant2', false, 'Apellido2', 'participante2', 'contrassdfdfeña2', '1234567891', 'Dirección 2', '2024-02-15', 'correo2@example.com', 2),
('Participant3', true, 'Apellido3', 'participante3', 'contraseña3', '1234567892', 'Dirección 3', '2024-03-10', 'correo3@example.com', 3),
('Participant4', false, 'Apellido4', 'participante4', 'cfdsfsdfdsf', '1234567893', 'Dirección 4', '2024-04-05', 'correo4@example.com', 4),
('Participant5', true, 'Apellido5', 'participante5', 'contraseña5', '1234567894', 'Dirección 5', '2024-01-20', 'correo5@example.com', 5),
('Participant6', false, 'Apellido6', 'participante6', 'dsfsdfdf', '1234567895', 'Dirección 6', '2024-02-28', 'correo6@example.com', 6),
('Participant7', true, 'Apellido7', 'participante7', 'sdfdf', '1234567896', 'Dirección 7', '2024-03-15', 'correo7@example.com', 7),
('Participant8', false, 'Apellido8', 'participante8', 'dfd', '1234567897', 'Dirección 8', '2024-04-10', 'correo8@example.com', 8),
('Participant9', true, 'Apellido9', 'participante9', 'contraseña9', '1234567898', 'Dirección 9', '2024-02-05', 'correo9@example.com', 9),
('Participant10', false, 'Apellido10', 'participante10', 'contraseña10', '1234567899', 'Dirección 10', '2024-03-01', 'correo10@example.com', 10);

-- Insertar registros en la tabla ideas
-- Se relacionan con un proyecto y dos funcionarios aleatorios
INSERT INTO ideas (nivel, formato, id_funcionario_lider, id_funcionario_generador, id_proyecto) VALUES
(1, 'Formato1', 1, 2, 1),
(2, 'Formato2', 3, 4, 1),
(3, 'Formato3', 5, 6, 3),
(4, 'Formato4', 7, 8, 4),
(5, 'Formato5', 9, 10, 5),
(6, 'Formato6', 1, 3, 6),
(7, 'Formato7', 4, 6, 7),
(8, 'Formato8', 7, 9, 1),
(9, 'Formato9', 2, 5, 9),
(10, 'Formato10', 3, 7, 10);

-- Insertar registros en la tabla comentarios
-- Se relacionan con una idea y un participante aleatorio
INSERT INTO comentarios (comentario, fecha_publicacion, calificacion, id_participante, id_idea) VALUES
('Comentario1', '2024-01-01', 4.5, 1, 1),
('Comentario2', '2024-02-15', 3.2, 2, 2),
('Comentario3', '2024-03-10', 2.8, 3, 3),
('Comentario4', '2024-04-05', 4.1, 4, 4),
('Comentario5', '2024-01-20', 3.9, 5, 5),
('Comentario6', '2024-02-28', 4.7, 6, 6),
('Comentario7', '2024-03-15', 3.5, 7, 7),
('Comentario8', '2024-04-10', 2.6, 8, 8),
('Comentario9', '2024-02-05', 4.9, 9, 9),
('Comentario10', '2024-03-01', 3.3, 10, 10);

-- Consulta 1: Propuestas con Estado Aceptado y Funcionarios Asignados
SELECT p.*, f.nombre AS nombre_funcionario
FROM propuesta p
JOIN funcionario f ON p.id_funcionario = f.id_funcionario
WHERE p.estado = 'Aceptada';

-- Consulta 2: Participantes que se Unieron Después de una Fecha Específica
SELECT *
FROM participante
WHERE fecha_union > '2024-03-01';

-- Consulta 3: Funcionarios que Han Presentado Propuestas en Más de un Proyecto
SELECT f.*
FROM funcionario f
JOIN propuesta p ON f.id_funcionario = p.id_funcionario
GROUP BY f.id_funcionario
HAVING COUNT(DISTINCT p.id_proyecto) > 1;

-- Consulta 4: Los 3 Proyectos con Más Ideas Presentadas y su Cantidad de Ideas
SELECT p.*, COUNT(i.id_idea) AS cantidad_de_ideas
FROM proyecto p
JOIN ideas i ON p.id_proyecto = i.id_proyecto
GROUP BY p.id_proyecto
ORDER BY cantidad_de_ideas DESC
LIMIT 3;

-- Consulta 5: Comentarios con Calificación Mayor a la Media
SELECT *
FROM comentarios
WHERE calificacion > (SELECT AVG(calificacion) FROM comentarios);

-- Consulta 6: Las 3 ideas con nivel mas alto
SELECT *
FROM ideas
ORDER BY nivel DESC
LIMIT 3;

-- Consulta 7: Proyectos cuyas propuestas han sido aceptadas
SELECT DISTINCT p.id_proyecto, p.nombre, pr.estado
FROM proyecto p
JOIN propuesta pr ON p.id_proyecto = pr.id_proyecto
WHERE pr.estado = 'Aceptada';

-- Consulta 8: Funcionarios cuya contraseña contiene al menos un número y logintud igual o mayor a 8 caracteres
SELECT f.id_funcionario, f.nombre, f.contrasena
FROM funcionario f
WHERE contrasena REGEXP '[0-9]' AND LENGTH(contrasena) >= 8;

-- Consulta 9: Obtener los IDs y nombres de los proyectos en los que hay al menos un participante externo
SELECT DISTINCT p.id_proyecto, p.nombre, pa.id_participante, pa.nombre
FROM proyecto p
INNER JOIN participante pa ON p.id_proyecto = pa.id_proyecto
WHERE pa.es_participante_interno = false;

-- Consulta 10: Obtener el nombre de la idea, nombre del funcionario líder, nombre del funcionario generador, ID del proyecto y nombre del proyecto
SELECT i.id_idea AS "Id de la Idea",
       fl.nombre AS "Nombre del Funcionario Líder",
       fg.nombre AS "Nombre del Funcionario Generador",
       i.id_proyecto AS "ID del Proyecto",
       p.nombre AS "Nombre del Proyecto"
FROM ideas i
INNER JOIN funcionario fl ON i.id_funcionario_lider = fl.id_funcionario
INNER JOIN funcionario fg ON i.id_funcionario_generador = fg.id_funcionario
INNER JOIN proyecto p ON i.id_proyecto = p.id_proyecto;
