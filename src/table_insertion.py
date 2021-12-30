import pandas as pd

# NOTA: LOS ATRIBUTOS QUE SON NULL SE GENERARÁN ENTRECOMILLADOS. PARA ELLO, ELIMINAR LAS COMILLAS:
#	CTL-H Y REEMPLAZAR 'nan' POR null.


def get_data(dataset):
    data = pd.read_csv(dataset, header=0, sep=';')
    df = pd.DataFrame(data)

    X = df.iloc[:, :].values
    features = df.columns.tolist()
    features = (', '.join(features))

    return X, features


# USUARIOS:
X, features = get_data('../datasets/usuarios.csv')

""" for i in X:
    print(
        f"insert into i72lumav.usuarios({features}) values ('{i[0]}', '{i[1]}')") """

# ÁLBUMES:
X, features = get_data('../datasets/albumes.csv')

""" for i in X:
    print(
        f"insert into i72lumav.albumes({features}) values ({i[0]}, '{i[1]}', '{i[2]}', {i[3]}, {i[4]}, '{i[5]}', '{i[6]}')") """

# CANCIONES:
X, features = get_data('../datasets/canciones.csv')

for i in X:
    print(
        f"insert into i72lumav.albumes({features}) values ({i[0]}, {i[1]}, {i[2]}, '{i[3]}', '{i[4]}', {i[5]})")
