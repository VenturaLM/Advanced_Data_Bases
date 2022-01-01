from os import walk
import pandas as pd

def get_data(dataset):
    """
    Get data from a '.csv' file.

    Parameters
    ----------
    dataset: string
        Path of the data file.

    Returns
    -------
    X: ndarray
        Values of the data.

    features: list
        Headers of the dataset.
    """
    try:
        # encoding='unicode_escape' in Linux.
        data = pd.read_csv(dataset, header=0, sep=';', encoding='unicode_escape')
    except FileNotFoundError:
        print("File not found.")
        exit(0)

    df = pd.DataFrame(data)

    X = df.iloc[:, :].values
    features = df.columns.tolist()
    features = (', '.join(features))

    return X, features


def create_insertion(table):
    """
    Create the 'insert' command for a '.sql' script.

    Parameters
    ----------
    table: string
        Name of the '.csv' file. For instance: <albumes.csv>.

    Returns
    -------
    Nothing.
    """
    X, features = get_data('../datasets/' + table)

    for i in X:
        values = []
        for j in range(len(i)):
            values.append(i[j])

        # Remove squared brackets.
        values = str(values)[1:-1]

        # Change 'i72lumav.' for the database name.
        print("insert into i72lumav." + table[: -4] +
              f" ({features}) values ({values});")


# Gets all the files in "datasets" directory.
filenames = next(walk("../datasets/"), (None, None, []))[2]

for file in filenames:
    # Create insertion for all datasets.
    create_insertion(file)
