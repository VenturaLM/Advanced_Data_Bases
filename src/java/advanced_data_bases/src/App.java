import usuarios.usuario_DAO;
import usuarios.usuario;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {

		System.out.println("Menú:\n1. Operaciones sobre usuarios.\n");
		Scanner cin = new Scanner(System.in);
		int opcion = Integer.parseInt(cin.nextLine());

		switch (opcion) {
			case 1:
				// Usuarios:
				usuario_DAO u = new usuario_DAO("jdbc:mysql://oraclepr.uco.es:3306/", "i72lumav", "PW2021");
				usuario nuevo_usuario = new usuario();

				System.out.println(
						"1. Insertar usuario.\n2. Modificar usuario.\n3. Borrar usuario.\n4. Ver usuario.");
				int op_usuarios = Integer.parseInt(cin.nextLine());

				switch (op_usuarios) {
					case 1:
						// Insertar usuario:
						System.out.println("\nEmail de usuario:");
						nuevo_usuario.setEmail("test@bbddaa.com");

						System.out.println("\nContraseña de usuario:");
						nuevo_usuario.setContrasena("1234");

						u.insertarUsuario(nuevo_usuario);

						break;

					case 2:
						// Modificar usuario:
						break;

					case 3:
						// Borrar usuario:
						break;

					case 4:
						// Ver usuario:
						System.out.println("\nEmail de usuario a buscar:");

						u.verUsuario(cin.nextLine());

						break;
				}

				break;
		}
		cin.close();

	}
}