/*Creacion de BD*/
CREATE DATABASE BD_Expotec;

/*Activar base de datos*/
USE BD_Expotec;

/*Creacion de tablas para la BD*/
CREATE TABLE Users(
    ID_User INT NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    Username VARCHAR (15) UNIQUE,
    Pass VARCHAR (25),
    Email VARCHAR (256) UNIQUE
);

CREATE TABLE Scores(
 ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 ID_User INT UNIQUE,
 Score INT,
 Datee DATE,
 Times TIME,
 FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

/*Insertar datos en la tabla Users para realizar pruebas*/
INSERT INTO Users  VALUES  (1,"Brandon","12345b", "br44leon@gmail.com");
INSERT INTO Users (Username, Pass, Email) VALUES  ("Carlos","12345c", "@emilianisomascos.edu.gt");
INSERT INTO Users (Username, Pass, Email) VALUES  ("David","12345d", "josecocarlosconochardon@emilianisomascos.edu.gt");


/*Insertar datos en la tabla Scores para realizar pruebas*/
INSERT INTO Scores (ID_User, Score, Datee, Times) VALUES 
(2,2900, '2024-05-01', '00:05:46'),
(1,9000, "2024-05-01", "01:59:29");
INSERT INTO Scores (ID_User, Score, Datee, Times) VALUES (3,3000, '2024-05-01', '00:05:46');


/*Visualizar los datos al final de las partidas*/
/*El inner join sirve para mostrar los datos de 2 tablas al mismo tiempo
Siempre y cuando se cumpla la condicion que coincida el ID del usuario*/
SELECT Users.Username, Scores.Score, Scores.Datee, Scores.Times
FROM Scores
INNER JOIN Users
ON Scores.ID_User = Users.ID_User
ORDER BY Scores.Score DESC;


SELECT * FROM scores
SELECT * FROM Users
ALTER TABLE scores MODIFY Datee VARCHAR(25);

/*Esto va a variar cuando se cambien las consultas en java, con el 
fin de verificar horas, minutos y segundos*/
ALTER TABLE scores MODIFY Times VARCHAR(100); 

UPDATE scores SET Score = 1, Datee = "5/22/2024", Times = 1 WHERE ID_User = 1;
