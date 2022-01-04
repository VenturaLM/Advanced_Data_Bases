package usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.conexion_base_datos;

public class usuario_DAO {

	private conexion_base_datos c;
	private Connection conexion;

	/**
	 * SQL Queries:
	 */
	private String INSERT = "insert into usuarios (email, contrasena) values (?, ?);";
	private String SELECT = "select * from usuarios where usuarios.email = ?;";

	/**
	 * Contructor de usuario que recibe los parámetros para la conexión a la base de
	 * datos.
	 * 
	 * @param bd_url        Enlace de la base de datos.
	 * @param bd_usuario    Usuario de la base de datos.
	 * @param bd_contrasena Contraseña de la base de datos.
	 */
	public usuario_DAO(String bd_url, String bd_usuario, String bd_contrasena) {
		c = new conexion_base_datos(bd_url, bd_usuario, bd_contrasena);
	}

	public void insertarUsuario(usuario u) {
		int estado = 0;

		PreparedStatement stat = null;
		c.conectar();
		conexion = c.getConexion();

		try {
			stat = conexion.prepareStatement(INSERT);

			stat.setString(1, u.getEmail());
			stat.setString(2, u.getContrasena());

			estado = stat.executeUpdate();
			c.desconectar();

		} catch (Exception e) {
			System.err.print("Error al insertar el usuario en la base de datos.\n");
			estado = -1;
		}
	}

	public void verUsuario(String email) {
		int estado = 0;

		PreparedStatement stat = null;
		c.conectar();
		conexion = c.getConexion();

		try {
			stat = conexion.prepareStatement(SELECT);

			stat.setString(1, email);

			ResultSet res = stat.executeQuery();

			if (res.next()) {
				System.out.print("El usuario existe.");
				estado = 0;
			} else {
				System.err.print("El usuario no existe.");
				estado = -1;
			}

			c.desconectar();

		} catch (Exception e) {
			System.err.print("Error al insertar el usuario en la base de datos.\n");
			estado = -1;
		}
	}

}