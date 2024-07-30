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
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

CREATE TABLE M1N1(
	ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_User INT UNIQUE,
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

CREATE TABLE M1N2(
	ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_User INT UNIQUE,
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

CREATE TABLE M2N1(
	ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_User INT UNIQUE,
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

CREATE TABLE M2N2(
	ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_User INT UNIQUE,
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

CREATE TABLE M3N1(
	ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_User INT UNIQUE,
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);

CREATE TABLE M3N2(
	ID_Score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ID_User INT UNIQUE,
	Puntaje INT,
	Fecha VARCHAR(100),
	Tiempo_Restante VARCHAR(100),
	FOREIGN KEY (ID_User) REFERENCES Users(ID_User) ON DELETE CASCADE
);
 
/*Visualizar los datos al final de las partidas*/
/*El inner join sirve para mostrar los datos de 2 tablas al mismo tiempo
Siempre y cuando se cumpla la condicion que coincida el ID del usuario*/
SELECT Users.Username AS Usuario, Scores.Puntaje, Scores.Fecha, Scores.Tiempo_Restante
FROM Scores
INNER JOIN Users
ON Scores.ID_User = Users.ID_User
ORDER BY Scores.Puntaje DESC;

SELECT * FROM scores;
SELECT * FROM Users;



SELECT * FROM M1N1;
SELECT * FROM M1N2;
SELECT * FROM M2N1;
SELECT * FROM M2N2;
SELECT * FROM M3N1;
SELECT * FROM M3N2;

DELETE FROM M1N1 WHERE ID_User = 1;
DELETE FROM M1N2 WHERE ID_User = 1;
DELETE FROM M2N1 WHERE ID_User = 1;
DELETE FROM M2N2 WHERE ID_User = 1;
DELETE FROM M3N1 WHERE ID_User = 1;
DELETE FROM M3N2 WHERE ID_User = 1;

DELETE FROM Users WHERE ID_User =1;


SELECT U.Username AS Usuario,
       SUM(TotalScores.Puntaje) AS Total_Puntos
FROM (SELECT ID_User, Puntaje FROM M1N1
    UNION ALL
    SELECT ID_User, Puntaje FROM M1N2
    UNION ALL
    SELECT ID_User, Puntaje FROM M2N1
    UNION ALL
    SELECT ID_User, Puntaje FROM M2N2
    UNION ALL
    SELECT ID_User, Puntaje FROM M3N1
    UNION ALL
    SELECT ID_User, Puntaje FROM M3N2) AS TotalScores
INNER JOIN Users AS U ON TotalScores.ID_User = U.ID_User
GROUP BY U.Username
ORDER BY U.Username ASC;