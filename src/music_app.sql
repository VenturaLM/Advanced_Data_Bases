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
	titulo varchar2(64) primary key,
	email varchar2(32) primary key,
	n_canciones number(38) not null,
	duracion varchar2(64) not null,
	constraint fk_email foreign key(email) references usuarios(email)
);