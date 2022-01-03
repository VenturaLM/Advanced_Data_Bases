drop table audit_table cascade constraints;
drop table usuarios cascade constraints;
drop table playlist cascade constraints;
drop table nfts cascade constraints;
drop table albumes cascade constraints;
drop table artistas cascade constraints;
drop table estilos_musicales cascade constraints;
drop table canciones cascade constraints;

drop table artistas_em cascade constraints;
drop table artistas_albumes cascade constraints;
drop table canciones_playlist cascade constraints;

drop type album_reparto_tab;
drop type instrumentos_t;
drop type reparto_t;

create table audit_table(
	datos varchar2(1024 byte), 
	tabla varchar2(1024 byte)
);

create table usuarios(
	email varchar2(32) primary key,
	contrasena varchar2(32) not null
);

create table playlist(
	titulo varchar2(32),
	email varchar2(32),
	n_canciones number(38) not null,
	duracion varchar2(32) not null,
	descripcion varchar2(64),
	primary key (titulo, email) disable,
	constraint fk_email foreign key(email) references usuarios(email)
);

-- Apartado 4.
/
create type reparto_t as object(
	nombre varchar2(1024),

	member function getnombre return varchar2,
	member procedure display_reparto (self in out nocopy reparto_t)
);
/
-- Creo el tipo.
create type album_reparto_tab as table of reparto_t;
/
create type instrumentos_t as varray(10) of varchar2(64);
/
create table albumes(
	id_album number(16) primary key,
	ano number(16) not null,
	titulo varchar2(32) not null,
	duracion varchar2(32) not null,
	n_canciones number(16) not null,
	descripcion varchar2(2048),
	tipo varchar2(32) not null,
	reparto album_reparto_tab,
	instrumentos instrumentos_t,
	constraint ck_tipo check(tipo in ('Single', 'EP', 'LP'))
)
nested table reparto store as reparto_album;

create table nfts(
	token_id number(16),
	direccion varchar2(64),
	email varchar2(32) not null,
	id_album number(16) not null,
	estandar varchar2(32) not null,
	blockchain varchar2(32) not null,
	primary key (token_id, direccion) disable,
	constraint fk_nfts_id_album foreign key(id_album) references albumes(id_album)
);

create table canciones(
	id_cancion number(16) primary key,
	id_album number(16) not null,
	indice number(16) not null,
	titulo varchar2(32) not null,
	duracion varchar2(32) not null,
	reproducciones number(32),
	constraint fk_canciones_id_album foreign key(id_album) references albumes(id_album)
);

create table artistas(
	id_artista number(16) primary key,
	nombre varchar2(32) not null,
	descripcion varchar2(2048),
	ranking number(16) not null
);

create table estilos_musicales(
	nombre_estilo varchar2(32) primary key
);

create table artistas_em(
	id_artista number(16),
	nombre_estilo varchar2(32),
	primary key (id_artista, nombre_estilo) disable,
	constraint fk_artistas_em_id_artista foreign key(id_artista) references artistas(id_artista),
	constraint fk_artistas_em_nombre_estilo foreign key(nombre_estilo) references estilos_musicales(nombre_estilo)
);

create table artistas_albumes(
	id_artista number(16),
	id_album number(16),
	primary key (id_artista, id_album) disable,
	constraint fk_artistas_albumes_id_artista foreign key(id_artista) references artistas(id_artista),
	constraint fk_artistas_albumes_id_album foreign key(id_album) references albumes(id_album)
);

create table canciones_playlist(
	id_cancion number(16),
	email varchar2(32),
	titulo varchar2(32),
	indice number(16) not null,
	primary key (id_cancion, email, titulo) disable,
	constraint fk_canciones_p_id_cancion foreign key(id_cancion) references canciones(id_cancion),
	constraint fk_canciones_p_email foreign key(email) references usuarios(email)
);