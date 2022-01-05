import usuarios.usuario_DAO;
import usuarios.usuario_Bean;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {

		System.out.println("\nMiddleware de prueba para la ejecución de sentencias SQL desde Java.");
		System.out.println("----------------------------------------------------------------------\n");
		System.out.println(
				"Menú:\n1. Operaciones sobre usuarios.\n2. Resto de operaciones (No implementado: Salida del programa).\n");
		Scanner cin = new Scanner(System.in);
		int opcion = Integer.parseInt(cin.nextLine());

		switch (opcion) {
			case 1:
				// Usuarios:
				usuario_DAO u = new usuario_DAO("jdbc:mysql://oraclepr.uco.es:3306/i72lumav", "i72lumav", "PW2021");
				usuario_Bean usuario_Bean = new usuario_Bean();

				System.out.println(
						"\n1. Insertar usuario.\n2. Modificar usuario.\n3. Borrar usuario.\n4. Ver usuario.");
				int op_usuarios = Integer.parseInt(cin.nextLine());

				switch (op_usuarios) {
					case 1: {
						// Insertar usuario:
						System.out.println("\nEmail de usuario:");
						usuario_Bean.setEmail(cin.nextLine());

						System.out.println("\nContraseña de usuario:");
						usuario_Bean.setContrasena(cin.nextLine());

						u.insertarUsuario(usuario_Bean);

						break;
					}

					case 2: {
						// Modificar usuario:
						System.out.println("\nEmail de usuario a modificar:");
						String email = cin.nextLine();

						if (u.existeUsuario(email)) {
							System.out.println("\nNueva contraseña:");
							String contrasena = cin.nextLine();

							u.modificarUsuario(email, contrasena);
						} else {
							System.out.format("El usuario %s no existe.", email);
						}

						break;
					}

					case 3: {
						// Borrar usuario:
						System.out.println("\nEmail de usuario a eliminar:");
						String email = cin.nextLine();

						if (u.existeUsuario(email)) {
							System.out.format("¿Está seguro de que desea eliminar el usuario %s? [y/n]:\n", email);
							String question = cin.nextLine().toLowerCase();

							if (question.equals("y")) {
								u.eliminarUsuario(email);
							} else {
								System.out.println("\nBorrado de usuario cancelado.");
							}
						} else {
							System.out.format("El usuario %s no existe.", email);
						}
						break;
					}

					case 4: {
						// Ver usuario:
						System.out.println("\nEmail de usuario a buscar:");

						u.verUsuario(cin.nextLine());

						break;
					}

					default:
						System.exit(0);
				}

				break;
			// El resto de casos de implementarían de manera análoga.
			default:
				System.exit(0);
		}
		cin.close();

	}
}