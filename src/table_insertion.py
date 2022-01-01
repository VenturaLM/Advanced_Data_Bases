from os import walk
import pandas as pd

# Execution:
#	./python3 table_insetion.py > file.sql

# NOTA: LOS ATRIBUTOS QUE SON NULL SE GENERARÁN ENTRECOMILLADOS. PARA ELLO, ELIMINAR LAS COMILLAS:
#	CTL-H Y REEMPLAZAR 'nan' POR null.


def get_data(dataset):
    try:
        data = pd.read_csv(dataset, header=0, sep=';')
    except FileNotFoundError:
        print("File not found.")
        exit(0)

    df = pd.DataFrame(data)

    X = df.iloc[:, :].values
    features = df.columns.tolist()
    features = (', '.join(features))

    return X, features


def create_insertion(table):
    X, features = get_data('../datasets/' + table)

    for i in X:
        values = []
        for j in range(len(i)):
            values.append(i[j])

        # Remove squared brackets.
        values = str(values)[1:-1]

        print("insert into i72lumav." + table +
              f" ({features}) values ({values});")


# Gets all the files in "datasets" directory.
filenames = next(walk("../datasets/"), (None, None, []))[2]

for file in filenames:
    # Create insertion for all datasets.
    create_insertion(file)
