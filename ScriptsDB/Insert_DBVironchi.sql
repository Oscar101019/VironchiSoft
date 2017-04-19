

use BDVIRONCHI;

-- Query para inserción de primer dato
insert into Cliente (Nombre, Direccion, Telefono)
values('Brian Efren Padilla Simon','Esteban Vaca Calderon #51','3111610756'),
	  ('Juventino Perez Peraza','Miñon #65','3112564565'),
	  ('Brian Alejandro Casas Lopez','Carrillo Puerto #300','3112587898'),
	  ('Cristobal Eluhi Vega Luna','Cerro de las campanas #132','311987822'),
	  ('Oscar Alberto Cordero Villa','lata #95','3241028986');
	  
SELECT * FROM cliente;
-- Se inserta primero el adeudo
-- luego explico porque 
insert into Adeudo (Concepto, Descripcion, CostoTotal)
values('M','Baño y corte de pelo', '180');

-- Se inserta primero la mascota
insert into Mascota(id_Cliente, Nombre, Especie, Raza, Sexo, Descripcion)
values (1,'Max','P','Mimiga','M','Perro conejo raro blanco'),
       (1,'Marilina','P','Mimiga','H','Otro perro conejo raro'),
       (3,'Bianca','P','Criollo','H','Pos otro registro'),
       (5,'Simba','Felino','Callejero','H','Ta chido');

--Inserciones para cita medica
insert into CitaMed(Id_Mascota,Fecha,Oidos,Ojos,Id_Adeudo)
values (3,'2017-03-23 6:30:00','N','A',1);

--Inserciones para cita estetica
insert into CitaEstetica(Id_Mascota,Id_Adeudo,Fecha,TamañoMascota)
values(3,1,'2017-03-23 00:00:00','P'),
	  (2,1,'2017-03-22 00:00:00','P'),
   	  (1,1,'2017-03-22 00:00:00','G')



delete from tablacitasincio  where TipoT like 'Cita Meica'

select * from tablacitasincio

select * from viewmed

select * from citamed

select * from citaestetica

select * from mascota






--Query para calarle que jale XD
select m. id_Mascota, M.Nombre,M.Raza from Cliente C
inner join Mascota M on(c.id_Cliente=M.id_Cliente)
WHERE c.Nombre = 'Brian Efren Padilla Simon';

--Inserciones para la parte de inventarios (se debe insertar en el orden en el que estan)

insert into inventario values
(1,'Medicamentos','Se lleva el control de todos los medicamentos usados en la clinica'),
(2,'Insumos','Son los productos de uso ccotidiano en la clinica veterinaria'),
(3,'Productos Tienda','Son los articulos que se venden en la tienda de la clinica');

insert into proveedores(NombreCompañia,NombreContacto) values
('DogChow','Dylan Parra Dominguez'),
('whiskas','Emanuel Cardenas Ramos'),
('Cositas','Doña Cuca');

INSERT INTO unidadmedida VALUES
(1,'Cajas'),
(2,'Bolsas');

INSERT INTO producto VALUES
(1,3,1,2,'Pedrigri','500gr',60.50,10,1),
(2,3,2,2,'Wiskas','500gr',50.50,5,1),
(3,2,3,1,'Guantes','2 guantes',5.50,20,1),
(4,1,3,1,'Morfina','50ml',99.30,20,1);


