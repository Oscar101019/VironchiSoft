-- Query para inserción de primer dato
insert into Cliente (Nombre, Direccion, Telefono)
values('Brian Efren Padilla Simon','Esteban Vaca Calderon #51','3111610756');

-- Se inserta primero el adeudo
-- luego explico porque 
insert into Adeudo (Concepto, Descripcion, CostoTotal)
values('M','Baño y corte de pelo', '180');

-- Se inserta primero la mascota
insert into Mascota(id_Cliente, Nombre, Especie, Raza, Sexo, Descripcion)
values (1,'Max','P','Mimiga','M','Perro conejo raro blanco'),
       (1,'Marilina','P','Mimiga','H','Otro perro conejo raro');


select * from Cliente;

select * from Mascota;


select m. id_Mascota, M.Nombre,M.Raza from Cliente C
inner join Mascota M on(c.id_Cliente=M.id_Cliente)
WHERE c.Nombre = 'Brian Efren Padilla Simon';
