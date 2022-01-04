import usuarios.usuarios;

public class App {
	public static void main(String[] args) throws Exception {
		usuarios u = new usuarios("a@a.com", "1234");

		System.out.println(u.getEmail());
	}
}