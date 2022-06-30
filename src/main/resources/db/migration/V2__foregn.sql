ALTER TABLE Docentes
    ADD COLUMN padres_id INT NOT NULL;


ALTER TABLE Docentes
    ADD FOREIGN KEY (padres_id) REFERENCES Padres(id);

