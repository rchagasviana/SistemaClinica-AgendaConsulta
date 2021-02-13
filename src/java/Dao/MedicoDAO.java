package Dao;

import BancoDeDados.Conexao;
import Entidades.Medico;
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
public class MedicoDAO {

    public void adicionar(Medico medico) {
        try {
            Connection conexao = Conexao.conectar();

            String sqlUsuarioSistema = "INSERT INTO usuarioSistema (codigoUsuario,usuarioAcesso,senhaAcesso,"
                    + "nome,email,rg,cpf,dataNascimento,sexo,statusSistema)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            String sqlMedico = "INSERT INTO medico (codigoMedico,registroProfissional,dataAdmissao,codigoEspecialidade"
                    + ",codigoUsuario)VALUES(?,?,?,?,?)";
            String sqlEndereco = "INSERT INTO endereco (logradouro,numero,pontoReferencia,"
                    + "bairro,cep,codigoUsuario)" + "VALUES(?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);
            PreparedStatement stmt2 = conexao.prepareStatement(sqlMedico);
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA USUÁRIO SISTEMA
            stmt.setString(1, medico.getCodigoUsuario());
            stmt.setString(2, medico.getUsuarioAcesso());
            stmt.setString(3, medico.getSenhaAcesso());
            stmt.setString(4, medico.getNome());
            stmt.setString(5, medico.getEmail());
            stmt.setString(6, medico.getRg());
            stmt.setString(7, medico.getCpf());
            stmt.setString(8, medico.getDataNascimento());
            stmt.setString(9, medico.getSexo());
            stmt.setString(10, medico.getStatusSistema());
            stmt.execute();
            stmt.close();
            //VALORES PARA A TABELA MÉDICO
            stmt2.setString(1, medico.getCodigoMedico());
            stmt2.setString(2, medico.getRegistroProfissional());
            stmt2.setString(3, medico.getDataAdmissao());
            stmt2.setInt(4, medico.getCodigoEspecialidade());
            stmt2.setString(5, medico.getCodigoUsuario());
            stmt2.execute();
            stmt2.close();
            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setString(1, medico.getLogradouro());
            stmt3.setString(2, medico.getNumero());
            stmt3.setString(3, medico.getPontoReferencia());
            stmt3.setString(4, medico.getBairro());
            stmt3.setString(5, medico.getCep());
            stmt3.setString(6, medico.getCodigoUsuario());

            stmt3.execute();
            stmt3.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public List<Medico> buscar() {

        List<Medico> medicos;
        medicos = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            String sql = "SELECT medico.codigoMedico,medico.registroProfissional,medico.dataAdmissao,medico.codigoEspecialidade,especialidade.nomeEspecialidade,usuariosistema.nome,usuariosistema.usuarioAcesso,usuariosistema.email,usuariosistema.rg,usuariosistema.cpf,usuariosistema.dataNascimento,usuariosistema.sexo,usuariosistema.statusSistema,endereco.codigoEndereco,endereco.cep,endereco.bairro,endereco.logradouro,endereco.numero,endereco.pontoReferencia FROM medico "
                    + "INNER JOIN usuarioSistema ON medico.codigoMedico=usuarioSistema.codigoUsuario "
                    + " INNER JOIN endereco ON usuarioSistema.codigoUsuario=endereco.codigoUsuario INNER JOIN especialidade ON medico.codigoEspecialidade=especialidade.codigoEspecialidade";

            PreparedStatement acessar = conexao.prepareStatement(sql);
            ResultSet resultado = acessar.executeQuery();

            while (resultado.next()) {
                Medico medico = new Medico();
                medico.setCodigoMedico(resultado.getString("codigoMedico"));//ok
                medico.setRegistroProfissional(resultado.getString("registroProfissional"));//ok
                medico.setDataAdmissao(resultado.getString("dataAdmissao"));//ok
                medico.setCodigoEspecialidade(resultado.getInt("codigoEspecialidade"));//ok
                medico.setNomeEspecialidade(resultado.getString("nomeEspecialidade"));//ok
                medico.setNome(resultado.getString("nome"));//ok
                medico.setUsuarioAcesso(resultado.getString("usuarioAcesso"));//ok
                medico.setEmail(resultado.getString("email"));
                medico.setRg(resultado.getString("rg"));
                medico.setCpf(resultado.getString("cpf"));
                medico.setDataNascimento(resultado.getString("dataNascimento"));
                medico.setSexo(resultado.getString("sexo"));
                medico.setStatusSistema(resultado.getString("statusSistema"));
                medico.setCodigoEndereco(resultado.getInt("codigoEndereco"));
                medico.setCep(resultado.getString("cep"));
                medico.setBairro(resultado.getString("bairro"));
                medico.setLogradouro(resultado.getString("logradouro"));
                medico.setNumero(resultado.getString("numero"));
                medico.setPontoReferencia(resultado.getString("pontoReferencia"));

                medicos.add(medico);
            }
            resultado.close();
            acessar.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao consultar médico");
        }
        return medicos;
    }
    
    public void atualizar(Medico medico){
        
        try {
            Connection conexao = Conexao.conectar();

            String sqlUsuarioSistema = "UPDATE usuariosistema SET nome=?,rg=?,cpf=?,email=?,dataNascimento=?"
                    + "WHERE codigoUsuario=?";           
            String sqlEndereco = "UPDATE endereco SET cep=?,bairro=?,numero=?,logradouro=?,pontoReferencia=? WHERE codigoEndereco=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);           
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA USUÁRIO SISTEMA              
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getRg());
            stmt.setString(3, medico.getCpf());
            stmt.setString(4, medico.getEmail());
            stmt.setString(5, medico.getDataNascimento());
            stmt.setString(6, medico.getCodigoMedico());
            stmt.execute();
            stmt.close();
            //VALORES PARA A TABELA MÉDICO
            //
            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setString(1, medico.getCep());
            stmt3.setString(2, medico.getBairro());
            stmt3.setString(3, medico.getNumero());
            stmt3.setString(4, medico.getLogradouro());
            stmt3.setString(5, medico.getPontoReferencia());
            stmt3.setInt(6, medico.getCodigoEndereco());
            stmt3.execute();
            stmt3.close();

            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    
    }
    
    
    
    
    public void ativarDesativar(Medico medico) {

        try {
            Connection conexao = Conexao.conectar();

            String sqlAtivarDesativar = "UPDATE usuariosistema SET statusSistema=? WHERE codigoUsuario=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlAtivarDesativar);
            stmt.setString(1, medico.getStatusSistema());
            stmt.setString(2, medico.getCodigoMedico());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

}
