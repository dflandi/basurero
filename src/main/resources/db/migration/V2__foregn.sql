ALTER TABLE Camion
    ADD COLUMN rutas_id INT NOT NULL;


ALTER TABLE Camion
    ADD FOREIGN KEY (rutas_id) REFERENCES Rutas(id);

