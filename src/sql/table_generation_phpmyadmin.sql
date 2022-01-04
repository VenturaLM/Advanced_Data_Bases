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

create table audit_table(
	datos varchar(1024 byte), 
	tabla varchar(1024 byte)
);

create table usuarios(
	email varchar(32) primary key,
	contrasena varchar(32) not null
);

create table playlist(
	titulo varchar(32),
	email varchar(32),
	n_canciones int(38) not null,
	duracion varchar(32) not null,
	descripcion varchar(64),
	primary key (titulo, email) ,
	constraint fk_email foreign key(email) references usuarios(email)
);

create table albumes(
	id_album int(16) primary key,
	ano int(16) not null,
	titulo varchar(32) not null,
	duracion varchar(32) not null,
	n_canciones int(16) not null,
	descripcion varchar(2048),
	tipo varchar(32) not null,
	constraint ck_tipo check(tipo in ('Single', 'EP', 'LP'))
);

create table nfts(
	token_id int(16),
	direccion varchar(64),
	email varchar(32) not null,
	id_album int(16) not null,
	estandar varchar(32) not null,
	blockchain varchar(32) not null,
	primary key (token_id, direccion) ,
	constraint fk_nfts_id_album foreign key(id_album) references albumes(id_album)
);

create table canciones(
	id_cancion int(16) primary key,
	id_album int(16) not null,
	indice int(16) not null,
	titulo varchar(32) not null,
	duracion varchar(32) not null,
	reproducciones int(32),
	constraint fk_canciones_id_album foreign key(id_album) references albumes(id_album)
);

create table artistas(
	id_artista int(16) primary key,
	nombre varchar(32) not null,
	descripcion varchar(2048),
	ranking int(16) not null
);

create table estilos_musicales(
	nombre_estilo varchar(32) primary key
);

create table artistas_em(
	id_artista int(16),
	nombre_estilo varchar(32),
	primary key (id_artista, nombre_estilo) ,
	constraint fk_artistas_em_id_artista foreign key(id_artista) references artistas(id_artista),
	constraint fk_artistas_em_nombre_estilo foreign key(nombre_estilo) references estilos_musicales(nombre_estilo)
);

create table artistas_albumes(
	id_artista int(16),
	id_album int(16),
	primary key (id_artista, id_album) ,
	constraint fk_artistas_albumes_id_artista foreign key(id_artista) references artistas(id_artista),
	constraint fk_artistas_albumes_id_album foreign key(id_album) references albumes(id_album)
);

create table canciones_playlist(
	id_cancion int(16),
	email varchar(32),
	titulo varchar(32),
	indice int(16) not null,
	primary key (id_cancion, email, titulo) ,
	constraint fk_canciones_p_id_cancion foreign key(id_cancion) references canciones(id_cancion),
	constraint fk_canciones_p_email foreign key(email) references usuarios(email)
);