create database PARO;
use PARO;

select * from PARO;

CREATE TABLE COMUNIDAD(
	Codigo char(2) primary key,
    Comunidad varchar(100)
);

insert into COMUNIDAD
	(SELECT
		distinct left(COMUNIDAD, 2) AS CODIGO,
        substring(COMUNIDAD, 4)
	from PARO);

select * FROM COMUNIDAD;

ALTER TABLE PARO
ADD COLUMN CodigoComunidad char(2);

set SQL_SAFE_UPDATES = 0;
UPDATE PARO SET CodigoComunidad = left(Comunidad, 2);
set SQL_SAFE_UPDATES = 1;


select * from paro;

alter table PARO DROP COLUMN COMUNIDAD;

ALTER TABLE PARO ADD foreign key (CodigoComunidad)
REFERENCES Comunidad(codigo);

alter table paro add column identificador
int auto_increment primary key;


#1 Total de desempleo por comunidad:
SELECT c.Comunidad, SUM(p.Total) AS TotalDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad;

#2 Desempleo total por sexo:
SELECT Sexo, SUM(Total) AS TotalDesempleo
FROM paro
GROUP BY Sexo;

#3 Desempleo total por rango de edad:
SELECT Edad, SUM(Total) AS TotalDesempleo
FROM paro
GROUP BY Edad;

#4 Promedio de desempleo por comunidad:
SELECT c.Comunidad, AVG(p.Total) AS PromedioDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad;

#5 Comunidad con mayor desempleo total:
SELECT c.Comunidad, SUM(p.Total) AS TotalDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad
ORDER BY TotalDesempleo DESC
LIMIT 1;

#6 Comunidad con menor desempleo total:
SELECT c.Comunidad, SUM(p.Total) AS TotalDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad
ORDER BY TotalDesempleo ASC
LIMIT 1;

#7 Desempleo por sexo y comunidad:
SELECT c.Comunidad, p.Sexo, SUM(p.Total) AS TotalDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad, p.Sexo;

#8 Tendencia del desempleo por periodo y comunidad:
SELECT c.Comunidad, p.Periodo, SUM(p.Total) AS TotalDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad, p.Periodo
ORDER BY c.Comunidad, p.Periodo;

#9 Porcentaje de desempleo por sexo en cada comunidad:
SELECT c.Comunidad, p.Sexo,
       (SUM(p.Total) / (SELECT SUM(p2.Total)
                        FROM paro p2
                        WHERE p2.CodigoComunidad = c.Codigo) * 100) AS Porcentaje
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
GROUP BY c.Comunidad, p.Sexo;

#10 Desempleo total por comunidad para un rango de edad específico:
SELECT c.Comunidad, SUM(p.Total) AS TotalDesempleo
FROM paro p
JOIN comunidad c ON p.CodigoComunidad = c.Codigo
WHERE p.Edad = '25-34'
GROUP BY c.Comunidad;





