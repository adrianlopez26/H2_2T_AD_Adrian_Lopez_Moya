
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
UPDATE PARO SET CodigoComunidad = left(comunidad, 2);
set SQL_SAFE_UPDATES = 1;


select * from paro;

alter table PARO DROP COLUMN COMUNIDAD;

ALTER TABLE PARO ADD foreign key (CodigoComunidad)
REFERENCES Comunidad(codigo);

alter table paro add column identificador
int auto_increment primary key;





--


