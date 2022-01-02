-- Trigger de dominio.
create or replace trigger dominio_albumes
before update or insert on albumes
for each row
begin
  	if :new.tipo = 'Single' and :new.n_canciones > 3 then
	  	Raise_application_error(-20001, 'Si el álbum es un "Single", la cantidad máxima de canciones es [3].');
		rollback;
	end if;

	if :new.tipo = 'EP' and (:new.n_canciones > 6 or :new.n_canciones < 4) then
		Raise_application_error(-20001, 'Si el álbum es un "EP", la cantidad mínima de canciones es [4] y la máxima es [6].');
		rollback;
	end if;

	if :new.tipo = 'LP' and :new.n_canciones < 6 then
		Raise_application_error(-20001, 'Si el álbum es un "LP", la cantidad mínima de canciones es [6].');
		rollback;
	end if;
end;