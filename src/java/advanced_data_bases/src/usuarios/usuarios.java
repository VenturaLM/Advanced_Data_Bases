package usuarios;

public class usuarios {

	private String email;
	private String contrasena;

	/**
	 * Contructor por defecto.
	 */
	public usuarios() {

	}

	/**
	 * Constructor de usuario que recibe como parámetros el email y la contraseña.
	 * 
	 * @param email      Email de un usuario.
	 * @param contrasena Contraseña de un usuario.
	 */
	public usuarios(String email, String contrasena) {
		setEmail(email);
		setContrasena(contrasena);
	}

	/**
	 * Contructor de usuario que recibe los parámetros para la conexión a la base de
	 * datos.
	 * 
	 * @param bd_url        Enlace de la base de datos.
	 * @param bd_usuario    Usuario de la base de datos.
	 * @param bd_contrasena Contraseña de la base de datos.
	 */
	public usuarios(String bd_url, String bd_usuario, String bd_contrasena) {
		/**
		 * Conexión a la base de datos.
		 */
	}

	/**
	 * 
	 * @param email Email a establecer a un usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @param contrasena Contraseña a establecer a un usuario.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * 
	 * @return Email de un usuario.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @return Contraseña de un usuario.
	 */
	public String getContrasena() {
		return this.contrasena;
	}
}
