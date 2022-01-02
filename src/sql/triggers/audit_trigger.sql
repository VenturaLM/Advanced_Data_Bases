-- Trigger de auditoría.
create or replace trigger auditoria_nft
after delete or update or insert on nfts
for each row
begin
	if inserting then
		insert into audit_table 
      		values ('Valores insertados: [TOKEN_ID = ' || :new.token_id || '] [DIRECCION = ' || :new.direccion || '] [EMAIL = ' || :new.email || '] [ID_ALBUM = ' || :new.id_album || '] [ESTANDAR = ' || :new.estandar || '] [BLOCKCHAIN = ' || :new.blockchain || ']', 'nfts');
	end if;

	if deleting then
		insert into audit_table
			values ('Valores insertados: [TOKEN_ID = ' || :old.token_id || '] [DIRECCION = ' || :old.direccion || '] [EMAIL = ' || :old.email || '] [ID_ALBUM = ' || :old.id_album || '] [ESTANDAR = ' || :old.estandar || '] [BLOCKCHAIN = ' || :old.blockchain || ']', 'nfts');
	end if;
end;