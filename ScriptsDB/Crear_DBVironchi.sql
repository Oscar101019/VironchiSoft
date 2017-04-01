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
);

/*Creación de tablas para inventario*/

CREATE TABLE Inventario
(
  ID_Inventario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(20),
  Descripcion VARCHAR(250)
);

CREATE TABLE UnidadMedida
(
  ID_UnidadMedida INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(15)
);

CREATE TABLE Proveedores
(
  ID_Proveedor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NombreCompañia VARCHAR(50),
  NombreContacto VARCHAR(50),
  Direccion VARCHAR(50),
  Ciudad VARCHAR(20),
  Estado VARCHAR(20),
  Telefono VARCHAR(10)
);

CREATE TABLE Producto
(
  ID_Producto INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  ID_Inventario INT NOT NULL,
  ID_Proveedor INT NOT NULL,
  ID_UnidadMedida INT NOT NULL,
  Nombre VARCHAR(30),
  CantidadPorUnidad VARCHAR(20),
  PrecioUnitario DOUBLE(4,2),
  UnidadesAlmacenadas INT,
  Descontinuado BOOL,
  CONSTRAINT FK_InventarioProducto FOREIGN KEY (ID_INVENTARIO) REFERENCES Inventario(ID_Inventario),
  CONSTRAINT FK_UnidadMedProducto FOREIGN KEY (ID_UnidadMedida) REFERENCES UnidadMedida(ID_UnidadMedida),
  CONSTRAINT FK_ProveedoresProducto FOREIGN KEY (ID_Proveedor) REFERENCES Proveedores(ID_Proveedor)
);

--Crear vista
create view VW_Tabla_Inicio
as
(
select CL.Nombre as Cliente,M.Nombre as Mascota,TCI.TipoCit,TCI.Fecha from  Tabla_Citas_Inicio TCI
inner join mascota M on (M.id_Mascota=TCI.id_Mascota)
inner join cliente CL on (CL.id_Cliente=M.id_Cliente)
);

--LOS TRIGGER SOLO HAN FUNCIONADO EN DATAGRIP
--Primer trigger
create trigger TR_CIT_MED BEFORE insert on citamed
	for each row
BEGIN
	insert into Tabla_Citas_Inicio set Id_Mascota=New.Id_Mascota, TipoCit ='Cita Medica',Fecha= NEW.Fecha;
END;
-- Segundo Trigger
create trigger TR_CIT_EST BEFORE insert on citaestetica
	for each row
BEGIN
	insert into Tabla_Citas_Inicio set Id_Mascota=New.Id_Mascota, TipoCit ='Cita Estetica',Fecha= NEW.Fecha;
END

--Los SELECT
select * from Tabla_Citas_Inicio;
select * from vw_tabla_inicio

