-- VIRONCHISOFT
-- Crear base de datos
/*Los cambios fueron los siguinetes
--Se le agrego el campo e fecha a la tabla CitamED
--Se le agrego el campo sexo a la tabla Cliente
--Se agrego la tabla Tabla_Citas_Inicio
--Se crearon 2 triggers
--Se creo una vista
*/


create database BDVIRONCHI;

use BDVIRONCHI;
-- Creamos las tablas de Vironchi

create table Cliente(
	id_Cliente int primary key auto_increment,
	Nombre varchar(30),
	Direccion varchar(100),
	Telefono varchar(10),
	Sexo varchar (1)
);

create table Mascota(
	id_Mascota int primary key AUTO_INCREMENT,
	id_Cliente int,
	Nombre varchar (20),
	Especie varchar(15),
	Raza varchar (20),
	Sexo varchar(1),
	Descripcion varchar(150),
	CONSTRAINT FK_Cliente FOREIGN KEY(id_Cliente) REFERENCES Cliente(id_Cliente)
);


create table Adeudo(
	Id_Adeudo int primary key AUTO_INCREMENT,
	concepto varchar(1),
	Descripcion VARCHAR(100),
	CostoTotal double(6,2)
);

create table CitaMed(
	id_CitaMed int primary key AUTO_INCREMENT,
	Fecha date,
	Temperatura varchar(5),
	Peso varchar(5),
	Apariencia_G varchar(1),
        DesAG varchar(150),
	Piel varchar(1),
        DesPiel varchar(150),
	MusculoEsqueleto varchar(1),
        DesME varchar(150),
	Circulatorio varchar(1),
        DesCircu varchar(150),
	Respiratorio varchar(1),
        DesRes varchar(150),
	Digestivo varchar(1),
        DesDige varchar(150),
	GenitoUrinario varchar(1),
        DesGU varchar(150),
	Ojos varchar(1),
        DesOjos varchar(150),
	Oidos varchar(1),
        DesOidos varchar(150),
	SistemaNervioso varchar(1),
        DesSN varchar(150),
	Ganglios varchar(1),
        DesGanglios varchar(150),
	Mucosa varchar(1),
        DesMucosa varchar(150),
      PlanesDiagnostico varchar(100),
	ProblemasTemporal varchar(100),
	PlanesTerapeuticos varchar(100),
	InstruccionesCli varchar(100),
	Id_Mascota int not null,
	Id_Adeudo int not null,
	CONSTRAINT FK_Mascota FOREIGN KEY (Id_Mascota) REFERENCES Mascota(Id_Mascota),
	CONSTRAINT FK_Adeudo FOREIGN KEY (Id_Adeudo) REFERENCES Adeudo(Id_Adeudo)
);



create table CitaEstetica(
	Id_CitaEst int primary key AUTO_INCREMENT,
	Fecha date,
	TamañoMascota varchar(1),
	Descripcion varchar(100),
	precio double(4,2),
	Id_Mascota int,
	Id_Adeudo int,
	CONSTRAINT FK_MASCOTAE FOREIGN KEY(Id_Mascota) REFERENCES Mascota(Id_Mascota),
	CONSTRAINT FK_ADEUDOE FOREIGN KEY(Id_Adeudo) REFERENCES Adeudo(Id_Adeudo)
);

create table Tabla_Citas_Inicio(
  id_Mascota int,
  TipoCit varchar(20),
  Fecha date
)

/*


create trigger TR_CIT_MED BEFORE insert on citamed
	for each row
BEGIN
	insert into Tabla_Citas_Inicio set Id_Mascota=New.Id_Mascota, TipoCit ='Cita Medica',Fecha= NEW.Fecha;

END;




create trigger TR_CIT_EST BEFORE insert on citaestetica
	for each row
BEGIN
	insert into Tabla_Citas_Inicio set Id_Mascota=New.Id_Mascota, TipoCit ='Cita Estetica',Fecha= NEW.Fecha;

END




create view VW_Tabla_Inicio
as
(
select CL.Nombre as Cliente,M.Nombre as Mascota,TCI.TipoCit,TCI.Fecha from  Tabla_Citas_Inicio TCI
inner join mascota M on (M.id_Mascota=TCI.id_Mascota)
inner join cliente CL on (CL.id_Cliente=M.id_Cliente)
);

select * from Tabla_Citas_Inicio;

select * from vw_tabla_inicio



*/