CREATE TABLE IF NOT EXISTS Usuarios(
id SERIAL,
Nombre VARCHAR (100) NOT NULL,
Edad INT NULL,
PRIMARY KEY (id)
 );

CREATE TABLE IF NOT EXISTS Rutas(
id SERIAL,
NombreRutas VARCHAR (100)  NULL,
TiempoRutas INT,
PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Camion(
    id SERIAL,
    Horas INT NULL,
    Dias VARCHAR (100) NULL,
    Rutas_id INT  NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(Rutas_id) references Rutas(id)
 );