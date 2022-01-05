package usuarios;

import java.io.Serializable;

public class usuario_Bean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String contrasena;

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
