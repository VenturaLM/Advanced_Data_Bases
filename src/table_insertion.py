import pandas as pd
import numpy as np

# NOTA: LOS ATRIBUTOS QUE SON NULL SE GENERARÁN ENTRECOMILLADOS. PARA ELLO, ELIMINAR LAS COMILLAS:
#	CTL-H Y REEMPLAZAR 'nan' POR null.


def get_data(dataset):
    data = pd.read_csv(dataset, header=0, sep=';')
    df = pd.DataFrame(data)

    X = df.iloc[:, :].values
    features = df.columns.tolist()
    features = (', '.join(features))

    return X, features


def create_insertion(table):
    X, features = get_data('../datasets/' + table + '.csv')

    for i in X:
        values = []
        for j in range(len(i)):
            values.append(i[j])

        # Remove squared brackets.
        values = str(values)[1:-1]

        print(f"insert into i72lumav." + table +
              "({features}) values ({values});")


# TABLES:

create_insertion('usuarios')
