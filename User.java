package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe que representa um usuário e permite verificar login em um banco de dados SQL.
 */
public class User {

    // Armazena o nome do usuário encontrado no banco
    public String nome = "";

    // Resultado da verificação do login
    public boolean result = false;

    /**
     * Método para conectar ao banco de dados MySQL.
     * @return Connection - objeto de conexão com o banco
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            // URL de conexão (usuário e senha conforme estava no exemplo da tarefa postada no Canvas)
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Conecta ao banco
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
            // Imprime erros de conexão, se houver
            e.printStackTrace();
        }
        return conn;
    }

    //Verifica se o usuário existe no banco e se a senha confere.

    public boolean verificarUsuario(String login, String senha) {
        Connection conn = conectarBD();

        // Monta a instrução SQL (vulnerável a SQL injection)
        String sql = "SELECT nome FROM usuarios WHERE login = '" + login + "' AND senha = '" + senha + "';";

        try {
            // Cria objeto Statement e executa consulta
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Se houver resultado, o usuário existe
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Fim da classe User
}
