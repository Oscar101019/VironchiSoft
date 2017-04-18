-- VIRONCHISOFT
-- Crear base de datos
-- Los cambios fueron los siguinetes
-- Se le agrego el campo e fecha a la tabla CitamED
-- Se le agrego el campo sexo a la tabla Cliente
-- Se agrego la tabla Tabla_Citas_Inicio
-- Se crearon 2 triggers
-- Se creo una vista

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
	Apariencia_G char(1),
	Piel char(1),
	MusculoEsqueleto char(1),
	Circulatorio char(1),
	Respiratorio char(1),
	Digestivo char(1),
	GenitoUrinario char(1),
	Ojos char(1),
	Oidos char(1),
	SistemaNervioso char(1),
	Ganglios char(1),
	Mucosa char(1),
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

/*Creacion de tablas de relacion con cita medica*/

create table Tipos(
  id_Tipo char(3) primary key ,
  Nombre varchar(20)
);

create table Detalle_Citas (
  Id_CitaMed int ,
  Observacion varchar(250),
  Tipo char(3) ,
  constraint FK_DETCIT_CITMED FOREIGN KEY (id_CitaMed) REFERENCES CitaMed (id_CitaMed),
  constraint FK_DETCIT_TIP FOREIGN KEY (Tipo) REFERENCES Tipos(id_Tipo)
);


-- Insertamos todos los tpo validos de observaciones

insert into Tipos VALUES 
('APG','Apariencia General'),
('PIL','Piel'),
('MES','	MusculoEsqueleto'),
('CIR'	,'Circulatorio'),
('RES','Respiratorio'),
('DIJ','Dijestivo'),
('OJO','Ojos'),
('OID','Oidos'),
('SNE','Sistema Nervioso'),
('GAN','Ganglios'),
('MUC','Mucosa');


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

-- Crear vista
create view VW_Tabla_Inicio
as
(
select CL.Nombre as Cliente,M.Nombre as Mascota,TCI.TipoCit,TCI.Fecha from  Tabla_Citas_Inicio TCI
inner join mascota M on (M.id_Mascota=TCI.id_Mascota)
inner join cliente CL on (CL.id_Cliente=M.id_Cliente)
);

-- LOS TRIGGER SOLO HAN FUNCIONADO EN DATAGRIP
-- Primer trigger
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
END;

-- Los SELECT
select * from Tabla_Citas_Inicio;
select * from vw_tabla_inicio;

SELECT * FROM Inventario;

--Creamos la vista para los productos de un inventario x
create view vw_buscar_prod
as
(
select p.Nombre,p.CantidadPorUnidad,p.PrecioUnitario,p.UnidadesAlmacenadas,i.Nombre as Inventario,i.ID_Inventario from producto p inner join
inventario i on (p.ID_Inventario=i.ID_Inventario)
);

CREATE VIEW vistaBuscarCliente AS
(
select c.Nombre as Cliente, m.Nombre as Mascota, c.Telefono, c.Direccion FROM cliente c
INNER JOIN Mascota m ON (c.id_Cliente = m.id_Cliente));

select * FROM vistaBuscarCliente
-- De la siguiente manera es como se hace la consulta para mostrar los datos del producto deseado

select Nombre,CantidadPorUnidad,PrecioUnitario,UnidadesAlmacenadas from vw_buscar_prod where Inventario='Medicamentos';

select Nombre,CantidadPorUnidad,PrecioUnitario,UnidadesAlmacenadas from vw_buscar_prod where Inventario='Insumos';

select Nombre,CantidadPorUnidad,PrecioUnitario,UnidadesAlmacenadas from vw_buscar_prod where Inventario='Productos Tienda';


