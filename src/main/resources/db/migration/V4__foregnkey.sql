ALTER TABLE Usuarios
    ADD COLUMN usuarios_id INT NOT NULL;


ALTER TABLE Usuarios
    ADD FOREIGN KEY (usuarios_id) REFERENCES Usuarios(id);