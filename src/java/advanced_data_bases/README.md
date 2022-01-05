## App

Aplicación sencilla en `Java` que permite intercambiar información con una base de datos `SQL`. Principalmente realiza las operaciones de inserción, modificación, visualización y borrado de registros.

## Estructura de los directorios

Los directorios contenidos son los siguientes:

- `src`: carpeta que contiene el código fuente.
	- `conexion`
		- `conexion_base_datos.java`: permite crear la conexión y desconexión entre el programa Java y la base de datos mencionada. Para que funcione esta conexión, será necesario preinstalar [mysql-connector](https://dev.mysql.com/downloads/connector/j/) de Java.
	- `usuarios`
		- `usuario_Bean.java`: clase que representa un usuario de la base de datos.
		- `usuario_DAO.java`: clase que permite realizar el intercambio de información entre el objecto usuario y el usuario de la base de datos.

- `lib`: carpeta que contiene las dependencias.
	- `mysql-connector.jar`

La salida compilada se genera automáticamente en el directorio `bin` de manera predeterminada.