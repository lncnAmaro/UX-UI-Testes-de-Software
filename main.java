package login;

import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Login e senha do usuário
        System.out.print("Digite seu login: ");
        String login = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        // Cria objeto User e verifica o login
        User user = new User();
        boolean autenticado = user.verificarUsuario(login, senha);

        // Mostra resultado
        if (autenticado) {
            System.out.println("Login bem-sucedido! Nome: " + user.nome);
        } else {
            System.out.println("Login ou senha incorretos.");
        }

        sc.close();
    }
}
