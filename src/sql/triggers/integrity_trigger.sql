-- Trigger de integridad.
create or replace trigger i_artistas_albumes
before insert or update on artistas_albumes
for each row
declare
	cursor c1 is (select id_artista from artistas);
	cursor c2 is (select id_album from albumes);
	flag_c1 number := 0;
	flag_c2 number := 0;
begin
	-- Comprobar que el dato introducido no es null para una clave primaria:
	if :new.id_artista is null then
		Raise_application_error(-20001, 'ERROR DE INTEGRIDAD: Es necesario el identificador del artista.');
	end if;

	if :new.id_album is null then
		Raise_application_error(-20001, 'ERROR DE INTEGRIDAD: Es necesario el identificador del álbum.');
	end if;

	-- Comprobar si existe el dato introducido en la base de datos:
	for row in c1 loop
		if :new.id_artista = row.id_artista then
			flag_c1 := 1;
		end if;
	end loop;

	for row in c2 loop
		if :new.id_album = row.id_album then
			flag_c2 := 1;
		end if;
	end loop;

	-- Si existe, no deja introducirlo:
	if flag_c1 = 0 then
		Raise_application_error(-20001, 'ERROR DE INTEGRIDAD: El artista no existe en la base de datos.');
		rollback;
	end if;

	if flag_c2 = 0 then
		Raise_application_error(-20001, 'ERROR DE INTEGRIDAD: El álbum no existe en la base de datos.');
		rollback;
	end if;
end;