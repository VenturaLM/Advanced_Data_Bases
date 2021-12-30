import pandas as pd

table = "albumes"

# Load '.csv' file.
data = pd.read_csv('../datasets/albumes.csv', header=0, sep=';')
df = pd.DataFrame(data)

if table == "albumes":
    for i in df:
        print(i)
