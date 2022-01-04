package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion_base_datos {

	private Connection conexion;
	private String bd_url, bd_usuario, bd_contrasena;

	public conexion_base_datos(String bd_url, String bd_usuario, String bd_contrasena) {
		setURL(bd_url);
		setUsuario(bd_usuario);
		setContrasena(bd_contrasena);
	}

	/**
	 * Establece la URL de conexión de la base de datos.
	 * 
	 * @param bd_url
	 */
	public void setURL(String bd_url) {
		this.bd_url = bd_url;
	}

	/**
	 * Establece el usuario de conexión de la base de datos.
	 * 
	 * @param bd_usuario
	 */
	public void setUsuario(String bd_usuario) {
		this.bd_usuario = bd_usuario;
	}

	/**
	 * Establece la contraseña de conexión de la base de datos.
	 * 
	 * @param bd_contrasena
	 */
	public void setContrasena(String bd_contrasena) {
		this.bd_contrasena = bd_contrasena;
	}

	/**
	 * Establece la conexión con la base de datos.
	 */
	public void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(bd_url, bd_usuario, bd_contrasena);
			System.out.println("Conexión establecida con éxito.");

		} catch (Exception e) {
			System.err.println("Error en la conexión con la base de datos.");
		}
	}

	/**
	 * Desconecta la conexión con la base de datos.
	 */
	public void desconectar() {
		try {
			conexion.close();
			System.out.println("Desconexión establecida con éxito.");

		} catch (Exception e) {
			System.err.println("Error en la desconexión con la base de datos.");
		}
	}

	/**
	 * 
	 * @return Objeto de conexión con la base de datos.
	 */
	public Connection getConexion() {
		return conexion;
	}
}
