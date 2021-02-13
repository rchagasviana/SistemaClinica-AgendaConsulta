package Dao;

import BancoDeDados.Conexao;
import Entidades.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class RootDAO {

    public boolean verificar(Root root) {
        boolean retorno = false;

        try {
            Connection conexao = Conexao.conectar();
            String sql = "SELECT usuario,senha  FROM root WHERE usuario=? && senha=?";

            PreparedStatement acessar = conexao.prepareStatement(sql);
            acessar.setString(1, root.getUsuario());
            acessar.setString(2, root.getSenha());

            ResultSet resultado = acessar.executeQuery();
            retorno = resultado.next();
            acessar.execute();
            acessar.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return retorno;

    }

}
