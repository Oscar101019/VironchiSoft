

use BDVIRONCHI;

-- Query para inserción de primer dato
insert into Cliente (Nombre, Direccion, Telefono)
values('Brian Efren Padilla Simon','Esteban Vaca Calderon #51','3111610756'),
	  ('Juventino Perez Peraza','Cetro #65','3112564565'),
	  ('Brian Alejandro Casas Lopez','No me acuerdo #432','3112587898'),
	  ('Cristobal Eluhi Vega Luna','Tampoco se #132','311987822'),
	  ('Oscar Alberto Cordero Villa','lata #95','3241028986')
	  

-- Se inserta primero el adeudo
-- luego explico porque 
insert into Adeudo (Concepto, Descripcion, CostoTotal)
values('M','Baño y corte de pelo', '180');

-- Se inserta primero la mascota
insert into Mascota(id_Cliente, Nombre, Especie, Raza, Sexo, Descripcion)
values (1,'Max','P','Mimiga','M','Perro conejo raro blanco'),
       (1,'Marilina','P','Mimiga','H','Otro perro conejo raro'),
       (5,'Simba','Felino','Callejero','H','Ta chido')

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


