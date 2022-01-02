-- Trigger de seguridad.
create or replace trigger seguridad_nft
before update or insert on nfts
for each row
declare
	cursor c is (select nfts.direccion from nfts);
  	flag NUMBER := 0;
begin
	for row in c loop
    	if :new.direccion = row.direccion then
      		flag := 1;
    	end if;
  	end loop;
  
  	if flag = 0 then
    	insert into nfts values (:new.token_id, :new.direccion, :new.email, :new.id_album, :new.estandar, :new.blockchain);
  	else
    	Raise_application_error(-20001, 'La dirección del NFT ya existe.');
    	rollback;
  	end if;
end;