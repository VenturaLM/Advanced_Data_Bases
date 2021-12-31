import pandas as pd
import numpy as np

# NOTA: LOS ATRIBUTOS QUE SON NULL SE GENERARÁN ENTRECOMILLADOS. PARA ELLO, ELIMINAR LAS COMILLAS:
#	CTL-H Y REEMPLAZAR 'nan' POR null.

quote = "'"


def get_data(dataset):
    data = pd.read_csv(dataset, header=0, sep=';')
    df = pd.DataFrame(data)

    X = df.iloc[:, :].values
    features = df.columns.tolist()
    features = (', '.join(features))

    return X, features


def create_insertion(X, features):
    for i in X:
        # Remove '[' and ']' from the list.
        values = str(i)[1: -1]
        print(values)
        # Falta separarlos por comas los values.
        #print(f"insert into i72lumav.usuarios({features}) values ({values});")


def insert_usuarios():
    # USUARIOS:
    X, features = get_data('../datasets/usuarios.csv')
    for i in X:
        print(
            f"insert into i72lumav.usuarios({features}) values ('{i[0]}', '{i[1]}');")


def insert_albumes():
    # ÁLBUMES:
    X, features = get_data('../datasets/albumes.csv')
    for i in X:
        print(
            f"insert into i72lumav.albumes({features}) values ({i[0]}, '{i[1]}', '{i[2]}', {i[3]}, {i[4]}, '{i[5]}', '{i[6]}');")


def insert_canciones():
    # CANCIONES:
    X, features = get_data('../datasets/canciones.csv')

    for i in X:
        print(
            f"insert into i72lumav.canciones({features}) values ({i[0]}, {i[1]}, {i[2]}, '{i[3]}', '{i[4]}', {i[5]});")


def insert_artistas():
    # ARTISTAS:
    X, features = get_data('../datasets/artistas.csv')

    for i in X:
        print(
            f"insert into i72lumav.artistas({features}) values ({i[0]}, '{i[1]}', {i[2]}, '{i[3]}');")


def insert_estilos():
    # ESTILOS:
    X, features = get_data('../datasets/estilos_musicales.csv')

    for i in X:
        print(
            f"insert into i72lumav.estilos_musicales({features}) values ('{i[0]}');")


def insert_nfts():
    # NFT:
    X, features = get_data('../datasets/nfts.csv')

    for i in X:
        print(
            f"insert into i72lumav.nfts({features}) values ({i[0]}, '{i[1]}', '{i[2]}', '{i[3]}', '{i[4]}', {i[5]});")


def insert_playlist():
    # PLAYLIST:
    X, features = get_data('../datasets/playlist.csv')

    for i in X:
        print(
            f"insert into i72lumav.playlist({features}) values ('{i[0]}', '{i[1]}', '{i[2]}', {i[3]}, '{i[4]}');")


def insert_artistas_albumes():
    # ARTISTAS-ALBUMES:
    X, features = get_data('../datasets/artistas_albumes.csv')

    for i in X:
        print(
            f"insert into i72lumav.artistas_albumes({features}) values ({i[0]}, {i[1]});")


def insert_artistas_estilos_musicales():
    # ARTISTAS-ESTILOS_MUSICALES:
    X, features = get_data('../datasets/artistas_estilos_musicales.csv')

    for i in X:
        print(
            f"insert into i72lumav.artistas_estilos_musicales({features}) values ({i[0]}, '{i[1]}');")


def insert_canciones_playlists():
    # CANCIONES-PLAYLIST:
    X, features = get_data('../datasets/canciones_playlist.csv')

    for i in X:
        print(
            f"insert into i72lumav.canciones_playlists({features}) values ({i[0]}, '{i[1]}', '{i[2]}', {i[3]});")


def main():
    # insert_usuarios()
    insert_albumes()
    # insert_canciones()
    # insert_artistas()
    # insert_estilos()
    # insert_nfts()
    # insert_playlist()
    # insert_canciones_playlist()
    # insert_artistas_albumes()
    # insert_artistas_estilos_musicales()


if __name__ == "__main__":
    main()
