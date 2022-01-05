package usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.conexion_base_datos;

public class usuario_DAO {

	private conexion_base_datos c;
	private Connection conexion;

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

	/**
	 * Ejecuta una inserción de un usuario en la base de datos.
	 * 
	 * @param u Usuario a insertar en la base de datos.
	 */
	public void insertarUsuario(usuario_Bean u) {
		// Comando SQL:
		String INSERT = "insert into usuarios (email, contrasena) values (?, ?);";

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

	/**
	 * Ejecuta una modificación de un usuario en la base de datos.
	 * 
	 * @param email      Email del usuario a modificar.
	 * @param contrasena Contraseña a modificar (único campo modificable).
	 */
	public void modificarUsuario(String email, String contrasena) {
		// Comando SQL:
		String UPDATE = "update usuarios set email = ?, contrasena = ? where email = ?;";

		int estado = 0;

		PreparedStatement stat = null;
		conexion = c.getConexion();

		try {
			stat = conexion.prepareStatement(UPDATE);

			// Establecer los datos.
			stat.setString(1, email);
			stat.setString(2, contrasena);
			stat.setString(3, email);

			estado = stat.executeUpdate();
			c.desconectar();

			System.out.println("\nModificación realizada con éxito.");

		} catch (Exception e) {
			System.err.println("\nError al modificar el usuario en la base de datos.\n");
			estado = -1;
		}
	}

	/**
	 * Ejecuta una eliminación de un usuario de la base de datos.
	 * 
	 * @param email Email del usuario a elinar.
	 */
	public void eliminarUsuario(String email) {
		// Comando SQL:
		String UPDATE = "delete from usuarios where email = ?;";

		int estado = 0;

		PreparedStatement stat = null;
		conexion = c.getConexion();

		try {
			stat = conexion.prepareStatement(UPDATE);

			// Establecer los datos.
			stat.setString(1, email);

			estado = stat.executeUpdate();
			c.desconectar();

			System.out.println("\nEliminación realizada con éxito.");

		} catch (Exception e) {
			System.err.println("\nError al eliminar el usuario en la base de datos.\n");
			estado = -1;
		}
	}

	/**
	 * Ejecuta una vista de un usuario (si existe) de la base de datos.
	 * 
	 * @param email Email del usuario a mostrar.
	 */
	public void verUsuario(String email) {
		// Comando SQL:
		String SELECT = "select * from usuarios where usuarios.email = ?;";

		int estado = 0;

		PreparedStatement stat = null;
		c.conectar();
		conexion = c.getConexion();

		try {
			stat = conexion.prepareStatement(SELECT);

			stat.setString(1, email);

			ResultSet res = stat.executeQuery();

			if (res.next()) {
				// El usuario existe.
				System.out.format("\nEmail: %s", email);
				System.out.format("\nContraseña: %s\n", res.getString("contrasena"));

				estado = 0;
			} else {
				System.err.print("\nEl usuario no existe.");
				estado = -1;
			}

			c.desconectar();

		} catch (Exception e) {
			System.err.println("\nError al ver el usuario en la base de datos.\n");
			estado = -1;
		}
	}

	/**
	 * Comprueba si existe un usuario en la base de datos.
	 * 
	 * @param email Email del usuario a buscar en la base de datos.
	 * @return True si el usuario existe; False si el usuario no existe.
	 */
	public boolean existeUsuario(String email) {
		// Comando SQL:
		String SELECT = "select email from usuarios where email = ?;";

		boolean estado = false;

		PreparedStatement stat = null;
		c.conectar();
		conexion = c.getConexion();

		try {
			stat = conexion.prepareStatement(SELECT);

			stat.setString(1, email);

			ResultSet res = stat.executeQuery();

			if (res.next()) {
				estado = true;
			} else {
				estado = false;
			}

		} catch (Exception e) {
			System.err.print(e);
		}

		return estado;
	}

}