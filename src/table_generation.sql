drop table usuarios cascade constraints;
drop table playlists cascade constraints;
drop table nfts cascade constraints;
drop table albumes cascade constraints;
drop table artistas cascade constraints;
drop table estilos_musicales cascade constraints;

drop table artistas_estilos_musicales cascade constraints;
drop table artistas_albumes cascade constraints;
drop table canciones_playlists cascade constraints;

create table usuarios(
	email varchar2(32) primary key,
	contraseña varchar2(32) not null
);

create table playlists(
	titulo varchar2(32) primary key,
	email varchar2(32) primary key,
	n_canciones number(38) not null,
	duracion varchar2(32) not null,
	constraint fk_email foreign key(email) references usuarios(email)
);

create table nfts(
	token_id number(16) primary key,
	direccion varchar2(64) primary key,
	email varchar2(32) not null,
	id_album number(16) not null,
	estandar varchar2(32) not null,
	blockchain varchar2(32) not null,
	constraint fk_nfts_id_album foreign key(id_album) references albumes(id_album)
);

create table albumes(
	id_album number(16) primary key,
	ano number(16) not null,
	titulo varchar2(32) not null,
	duracion varchar2(32) not null,
	n_canciones number(16) not null,
	descripcion varchar2(32),
	tipo varchar2(32) not null,
	constraint ck_tipo check(tipo in ('Single', 'EP', 'LP'))
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
	descripcion varchar2(32),
	ranking number(16) not null
);

create table estilos_musicales(
	nombre_estilo varchar2(32) primary key
);

create table artistas_estilos_musicales(
	id_artista number(16) primary key,
	nombre_estilo varchar2(32) primary key
	constraint fk_artistas_estilos_musicales_id_artista foreign key(id_artista) references artistas(id_artista),
	constraint fk_artistas_estilos_musicales_nombre_estilo foreign key(nombre_estilo) references estilos_musicales(nombre_estilo)
);

create table artistas_albumes(
	id_artista number(16) primary key,
	id_album number(16) primary key
	constraint fk_artistas_albumes_id_artista foreign key(id_artista) references artistas(id_artista),
	constraint fk_artistas_albumes_id_album foreign key(id_album) references albumes(id_album)
);

create table canciones_playlists(
	id_cancion number(16) primary key,
	email varchar2(32) primary key,
	titulo varchar2(32) primary key,
	indice number(16) not null,
	constraint fk_canciones_playlists_id_cancion foreign key(id_cancion) references canciones(id_cancion),
	constraint fk_canciones_playlists_email foreign key(email) references usuarios(email)
);