select * from usuarios;
select * from playlist;
select * from nfts;
select * from albumes;
select * from artistas;
select * from estilos_musicales;
select * from canciones;
select * from artistas_em;
select * from artistas_albumes;
select * from canciones_playlist;

-- Selección de todas las características de las tablas nfts y álbumes.
select *
from nfts, albumes
where nfts.id_album = albumes.id_album;

-- Selección de los temas musicales y sus álbumes.
select canciones.titulo "Tema musical", albumes.titulo "Álbum"
from canciones, albumes
where canciones.id_album = albumes.id_album;

-- Selección de todos los estilos de música que abarca un artista.
select artistas.nombre "Artista", artistas_em.nombre_estilo "Estilo musical"
from artistas, artistas_em
where artistas.id_artista = artistas_em.id_artista;

-- Selección de los artistas, el título del álbum y el estádar de la cadena de bloques a la que pertenece el NFT del álbum.
select unique(artistas.nombre) "Artista", albumes.titulo "Álbum", nfts.estandar "Estándar del NFT"
from artistas, artistas_albumes, albumes, nfts
where artistas.id_artista = artistas_albumes.id_artista and
artistas_albumes.id_album = albumes.id_album and
albumes.id_album = nfts.id_album;

-- Selección de los temas musicales, de sus álbumes correspondientes y el nombre de la playlist a la que pertenecen de todas las playlists existentes.
select albumes.titulo "Álbum", canciones.titulo "Tema musical", canciones_playlist.titulo "Título playlist"
from albumes, canciones, canciones_playlist
where canciones.id_album = albumes.id_album and
canciones.id_cancion = canciones_playlist.id_cancion
order by canciones.id_cancion;

-- Selección de las direcciones de los NFTs de los usuarios.
select nfts.direccion "Dirección NFT", usuarios.email "Usuario"
from nfts, usuarios
where nfts.email = usuarios.email;