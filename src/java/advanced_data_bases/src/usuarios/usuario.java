package usuarios;

public class usuario {

	private String email;
	private String contrasena;

	/**
	 * Contructor por defecto.
	 */
	public usuario() {

	}

	/**
	 * Constructor de usuario que recibe como parámetros el email y la contraseña.
	 * 
	 * @param email      Email de un usuario.
	 * @param contrasena Contraseña de un usuario.
	 */
	public usuario(String email, String contrasena) {
		setEmail(email);
		setContrasena(contrasena);
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
