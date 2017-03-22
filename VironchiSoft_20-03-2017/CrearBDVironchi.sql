-- VIRONCHISOFT
-- Crear base de datos

create database BDVIRONCHI;

/*on primary (
name='BDVIRONCHI.mdf',
filename='C:\VironchiSoft\BDVIRONCHI.mdf'
)

log on(
name='BDVIRONCHI.ldf',
filename='C:\VironchiSoft\BDVIRONCHI.ldf'
)*/


use BDVIRONCHI;
-- Creamos las tablas de Vironchi

create table Cliente(
	id_Cliente int primary key auto_increment,
	-- id_Adeudo int,
	Nombre varchar(30),
	Direccion varchar(100),
	Telefono varchar(10) 
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
	Tempeatura varchar(5),
	Peso varchar(5),
	Apariencia_G varchar(1),
	Piel varchar(1),
	MusculoEsqueleto varchar(1),
	Circulatorio varchar(1),
	Resiratorio varchar(1),
	Digestivo varchar(1),
	GenitoUrinario varchar(1),
	Ojos varchar(1),
	Oidos varchar(1),
	SistemaNervioso varchar(1),
	Ganglios varchar(1),
	Mucosa varchar(1),
	DescripcionAnormal varchar(200),
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
	Fecha datetime, 
	TamañoMascota varchar(1),
	Descripcion varchar(100),
	precio double(4,2),
	Id_Mascota int,
	Id_Adeudo int,
	CONSTRAINT FK_MASCOTAE FOREIGN KEY(Id_Mascota) REFERENCES Mascota(Id_Mascota),
	CONSTRAINT FK_ADEUDOE FOREIGN KEY(Id_Adeudo) REFERENCES Adeudo(Id_Adeudo)
);

