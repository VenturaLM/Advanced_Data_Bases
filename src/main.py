import os

def main():
    # Generate the '.sql' script with 'nan' values from '.csv' file.
    os.system("python3 table_insertion.py > test.sql")

    # Read in the file.
    with open("test.sql", "r") as file :
        filedata = file.read()

    # Replace the target string: < nan>.
    filedata = filedata.replace(" nan", " null")

    # Write the file out again.
    with open("test.sql", "w") as file:
        file.write(filedata)

if __name__ == "__main__":
    main()