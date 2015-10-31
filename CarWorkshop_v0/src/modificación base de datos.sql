--Añadir columna horas
alter table TTIPOSVEHICULO add column HorasMaestria integer;

--Crear curso
create table tcurso(
codigo 			varchar(255)	not null,
nombre 			varchar(255)	not null,
descripcion		varchar(255)	not null,
horasTotales	integer			not null,
primary key(codigo)
);

--Crear tabla asistencia
CREATE TABLE Tasistencia(
idCurso 		varchar(255)	not null,
idMecanico 		bigint  		not null,
fechain 		date,
fechaout 		date,
porcentaje      integer         not null,
apto 			varchar(255)	not null,
primary key(idCurso, idMecanico)
);

--Crear tabla experto
create table TExperto(
idMecanico		bigint		not null,
idTiposvehiculo	bigint		not null,
fechaExperto	DATE		not null,
primary key(idMecanico, idTiposvehiculo)
);

--Crear tabla TContenidoCurso
create table TContenidoCurso(
idCurso         varchar(255)    not null,
idTiposvehiculo bigint          not null,
porcentaje      integer         not null,
primary key(idCurso, idTiposvehiculo)
);

--Unir tabla Tcurso con TTiposVehiculo
ALTER TABLE TContenidoCurso      ADD FOREIGN KEY    (idCurso) 		    REFERENCES TCURSO 		    (CODIGO);
ALTER TABLE TContenidoCurso      ADD FOREIGN KEY    (idTiposvehiculo) 	REFERENCES TTIPOSVEHICULO 	(id);

--Unir tabla Tcurso y Tmecanicos por Tasistenca
ALTER TABLE Tasistencia         ADD FOREIGN KEY	    (idMecanico)    	REFERENCES TMECANICOS 	    (id);
ALTER TABLE Tasistencia         ADD FOREIGN KEY     (idCurso) 		    REFERENCES TCURSO 		    (CODIGO);

--Unir tabla TMecanico y TTIPOSVEHICULO por TExperto
ALTER TABLE TExperto 	        ADD FOREIGN KEY	    (idMecanico) 	    	REFERENCES TMECANICOS 		(id);
ALTER TABLE TExperto 	        ADD FOREIGN KEY	    (idTiposvehiculo) 	    REFERENCES TTIPOSVEHICULO 	(id);

