package BancoDeDados;

import java.sql.*;

/**
 *
 * @author Rafael
 */
public class Conexao {

    public static Connection conectar() throws ClassNotFoundException {
        Connection conexao;
        //Parâmetros de conexão da base da dados
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/agendaconsulta";
        String usuario = "root";
        String senha = "";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
           // System.out.println("Classe Conexão. Valor: " + conexao);
            return conexao;
        } catch (SQLException e) {
            return null;
        }
    }
}
