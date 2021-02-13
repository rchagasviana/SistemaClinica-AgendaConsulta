package Dao;

import BancoDeDados.Conexao;
import Entidades.Atendente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class AtendenteDAO {

    public void adicionar(Atendente atendente) throws SQLException, ClassNotFoundException {
        try {
            Connection conexao = Conexao.conectar();

            String sqlUsuarioSistema = "insert into usuarioSistema (codigoUsuario,usuarioAcesso,senhaAcesso,"
                    + "nome,email,rg,cpf,dataNascimento,sexo,statusSistema)" + "values(?,?,?,?,?,?,?,?,?,?)";
            String sqlAtendente = "insert into atendente (codigoAtendente,dataAdmissao,codigoUsuario)"
                    + "values(?,?,?)";
            String sqlEndereco = "insert into endereco (logradouro,numero,pontoReferencia,"
                    + "bairro,cep,codigoUsuario)" + "values(?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);
            PreparedStatement stmt2 = conexao.prepareStatement(sqlAtendente);
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA USUÁRIO SISTEMA
            stmt.setString(1, atendente.getCodigoUsuario());
            stmt.setString(2, atendente.getUsuarioAcesso());
            stmt.setString(3, atendente.getSenhaAcesso());
            stmt.setString(4, atendente.getNome());
            stmt.setString(5, atendente.getEmail());
            stmt.setString(6, atendente.getRg());
            stmt.setString(7, atendente.getCpf());
            stmt.setString(8, atendente.getDataNascimento());
            stmt.setString(9, atendente.getSexo());
            stmt.setString(10, atendente.getStatusSistema());
            stmt.execute();
            stmt.close();
            //VALORES PARA A TABELA ATENDENTE
            stmt2.setString(1, atendente.getCodigoAtendente());
            stmt2.setString(2, atendente.getDataAdmissao());
            stmt2.setString(3, atendente.getCodigoUsuario());
            stmt2.execute();
            stmt2.close();
            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setString(1, atendente.getLogradouro());
            stmt3.setString(2, atendente.getNumero());
            stmt3.setString(3, atendente.getPontoReferencia());
            stmt3.setString(4, atendente.getBairro());
            stmt3.setString(5, atendente.getCep());
            stmt3.setString(6, atendente.getCodigoUsuario());

            stmt3.execute();
            stmt3.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public List<Atendente> buscar() throws SQLException, ClassNotFoundException {

        List<Atendente> atendentes;
        atendentes = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            String sql = "SELECT atendente.codigoAtendente,endereco.codigoEndereco,atendente.dataAdmissao,usuariosistema.usuarioAcesso,"
                    + "usuariosistema.nome,usuariosistema.email,usuariosistema.rg,usuariosistema.cpf,"
                    + "usuariosistema.dataNascimento,usuariosistema.sexo,usuariosistema.statusSistema,"
                    + "endereco.logradouro,endereco.numero,endereco.pontoReferencia,endereco.bairro,"
                    + "endereco.cep FROM atendente INNER JOIN usuarioSistema ON"
                    + " atendente.codigoAtendente=usuarioSistema.codigoUsuario"
                    + " INNER JOIN endereco ON usuarioSistema.codigoUsuario=endereco.codigoUsuario";

            PreparedStatement acessar = conexao.prepareStatement(sql);
            ResultSet resultado = acessar.executeQuery();

            while (resultado.next()) {
                Atendente atendente = new Atendente();
                atendente.setCodigoAtendente(resultado.getString("codigoAtendente"));
                atendente.setCodigoEndereco(resultado.getInt("codigoEndereco"));
                atendente.setDataAdmissao(resultado.getString("dataAdmissao"));
                atendente.setUsuarioAcesso(resultado.getString("usuarioAcesso"));
                atendente.setNome(resultado.getString("nome"));
                atendente.setEmail(resultado.getString("email"));
                atendente.setRg(resultado.getString("rg"));
                atendente.setCpf(resultado.getString("cpf"));
                atendente.setDataNascimento(resultado.getString("dataNascimento"));
                atendente.setSexo(resultado.getString("sexo"));
                atendente.setStatusSistema(resultado.getString("statusSistema"));
                atendente.setLogradouro(resultado.getString("logradouro"));
                atendente.setNumero(resultado.getString("numero"));
                atendente.setPontoReferencia(resultado.getString("pontoReferencia"));
                atendente.setBairro(resultado.getString("bairro"));
                atendente.setCep(resultado.getString("cep"));
                atendentes.add(atendente);
            }
            resultado.close();
            acessar.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao consultar atendente");

        }
        return atendentes;
    }

    public void excluir(Atendente atendente) {

        try {
            Connection conexao = Conexao.conectar();

            String sqlEndereco = "DELETE FROM endereco WHERE codigoEndereco=?";
            String sqlAtendente = "DELETE FROM atendente WHERE codigoAtendente=?";
            String sqlUsuarioSistema = "DELETE FROM usuariosistema WHERE codigoUsuario=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);
            PreparedStatement stmt2 = conexao.prepareStatement(sqlAtendente);
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setInt(1, atendente.getCodigoEndereco());
            stmt3.execute();
            stmt3.close();
            //VALORES PARA A TABELA ATENDENTE
            stmt2.setString(1, atendente.getCodigoUsuario());
            stmt2.execute();
            stmt2.close();

            //VALORES PARA A TABELA USUÁRIO SISTEMA
            stmt.setString(1, atendente.getCodigoUsuario());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public void atualizar(Atendente atendente) {

        try {
            Connection conexao = Conexao.conectar();

            String sqlUsuarioSistema = "UPDATE usuariosistema SET nome=?,rg=?,cpf=?,email=?,dataNascimento=?"
                    + "WHERE codigoUsuario=?";
            String sqlAtendente = "UPDATE atendente SET dataAdmissao=? WHERE codigoAtendente=?";
            String sqlEndereco = "UPDATE endereco SET cep=?,bairro=?,numero=?,pontoReferencia=? WHERE codigoEndereco=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);
            PreparedStatement stmt2 = conexao.prepareStatement(sqlAtendente);
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA USUÁRIO SISTEMA              
            stmt.setString(1, atendente.getNome());
            stmt.setString(2, atendente.getRg());
            stmt.setString(3, atendente.getCpf());
            stmt.setString(4, atendente.getEmail());
            stmt.setString(5, atendente.getDataNascimento());
            stmt.setString(6, atendente.getCodigoAtendente());
            stmt.execute();
            stmt.close();
            //VALORES PARA A TABELA ATENDENTE
            stmt2.setString(1, atendente.getDataAdmissao());
            stmt2.setString(2, atendente.getCodigoAtendente());
            stmt2.execute();
            stmt2.close();
            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setString(1, atendente.getCep());
            stmt3.setString(2, atendente.getBairro());
            stmt3.setString(3, atendente.getNumero());
            stmt3.setString(4, atendente.getPontoReferencia());
            stmt3.setInt(5, atendente.getCodigoEndereco());
            stmt3.execute();
            stmt3.close();

            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void ativarDesativar(Atendente atendente) {

        try {
            Connection conexao = Conexao.conectar();

            String sqlAtivarDesativar = "UPDATE usuariosistema SET statusSistema=? WHERE codigoUsuario=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlAtivarDesativar);
            stmt.setString(1, atendente.getStatusSistema());
            stmt.setString(2, atendente.getCodigoAtendente());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public boolean verificarUsuarioSistema(Atendente atendente) {

        boolean retorno = false;

        try {
            Connection conexao = Conexao.conectar();

            //USADA PRA VERIFICAR SE O USUÁRIO É UM ATENDENTE
            String sqlAtendente = "SELECT * FROM atendente WHERE codigoatendente ="
                    + "(SELECT codigoUsuario FROM usuariosistema WHERE usuarioAcesso=?); ";

            PreparedStatement acessar = conexao.prepareStatement(sqlAtendente);
            acessar.setString(1, atendente.getUsuarioAcesso());
            ResultSet resultado = acessar.executeQuery();

            //SE O USUÁRIO EXISTIR NA TABELA ATENDENTE, FAZ A VERIFICAÇÃO 
            if (resultado.next()) {
                String sqlUsuarioSistema = "SELECT usuarioAcesso,senhaAcesso  FROM usuarioSistema"
                        + " WHERE usuarioAcesso=? && senhaAcesso=? && statusSistema='ativado' ";
                PreparedStatement acessar2 = conexao.prepareStatement(sqlUsuarioSistema);
                acessar2.setString(1, atendente.getUsuarioAcesso());
                acessar2.setString(2, atendente.getSenhaAcesso());

                ResultSet resultado2 = acessar2.executeQuery();
                retorno = resultado2.next();
            }
            acessar.execute();
            acessar.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return retorno;

    }

}
