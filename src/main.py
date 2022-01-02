import os


def main():
    # Generate the '.sql' script with 'nan' values from '.csv' file.
    os.system("python3 table_insertion.py > table_insertions.sql")

    # Read in the file.
    with open("table_insertions.sql", "r") as file:
        filedata = file.read()

    # Replace the target string: < nan>.
    filedata = filedata.replace(" nan", " null")

    # Write the file out again.
    with open("table_insertions.sql", "w") as file:
        file.write(filedata)


if __name__ == "__main__":
    main()
