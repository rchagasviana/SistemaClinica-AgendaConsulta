/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BancoDeDados.Conexao;
import Entidades.Paciente;
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
public class PacienteDAO {

    public void adicionar(Paciente paciente) {

        try {
            Connection conexao = Conexao.conectar();

            String sqlUsuarioSistema = "insert into usuarioSistema (codigoUsuario,usuarioAcesso,senhaAcesso,"
                    + "nome,email,rg,cpf,dataNascimento,sexo,statusSistema)" + "values(?,?,?,?,?,?,?,?,?,?)";
            String sqlPaciente = "insert into paciente (codigoPaciente,codigoUsuario)"
                    + "values(?,?)";
            String sqlEndereco = "insert into endereco (logradouro,numero,pontoReferencia,"
                    + "bairro,cep,codigoUsuario)" + "values(?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);
            PreparedStatement stmt2 = conexao.prepareStatement(sqlPaciente);
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA USUÁRIO SISTEMA
            stmt.setString(1, paciente.getCodigoUsuario());
            stmt.setString(2, paciente.getUsuarioAcesso());
            stmt.setString(3, paciente.getSenhaAcesso());
            stmt.setString(4, paciente.getNome());
            stmt.setString(5, paciente.getEmail());
            stmt.setString(6, paciente.getRg());
            stmt.setString(7, paciente.getCpf());
            stmt.setString(8, paciente.getDataNascimento());
            stmt.setString(9, paciente.getSexo());
            stmt.setString(10, paciente.getStatusSistema());
            stmt.execute();
            stmt.close();
            //VALORES PARA A TABELA PACIENTE
            stmt2.setString(1, paciente.getCodigoPaciente());
            stmt2.setString(2, paciente.getCodigoUsuario());
            stmt2.execute();
            stmt2.close();
            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setString(1, paciente.getLogradouro());
            stmt3.setString(2, paciente.getNumero());
            stmt3.setString(3, paciente.getPontoReferencia());
            stmt3.setString(4, paciente.getBairro());
            stmt3.setString(5, paciente.getCep());
            stmt3.setString(6, paciente.getCodigoUsuario());

            stmt3.execute();
            stmt3.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao adicionar paciente");
        }

    }
    
    
    public List<Paciente> buscar() throws SQLException, ClassNotFoundException {

        List<Paciente> pacientes;
        pacientes = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            String sql = "SELECT paciente.codigoPaciente,endereco.codigoEndereco,usuariosistema.usuarioAcesso,"
                    + "usuariosistema.nome,usuariosistema.email,usuariosistema.rg,usuariosistema.cpf,"
                    + "usuariosistema.dataNascimento,usuariosistema.sexo,usuariosistema.statusSistema,"
                    + "endereco.logradouro,endereco.numero,endereco.pontoReferencia,endereco.bairro,"
                    + "endereco.cep FROM paciente INNER JOIN usuarioSistema ON"
                    + " paciente.codigoPaciente=usuarioSistema.codigoUsuario"
                    + " INNER JOIN endereco ON usuarioSistema.codigoUsuario=endereco.codigoUsuario";

            PreparedStatement acessar = conexao.prepareStatement(sql);
            ResultSet resultado = acessar.executeQuery();

            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setCodigoPaciente(resultado.getString("codigoPaciente"));
                paciente.setCodigoEndereco(resultado.getInt("codigoEndereco"));                
                paciente.setUsuarioAcesso(resultado.getString("usuarioAcesso"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setRg(resultado.getString("rg"));
                paciente.setCpf(resultado.getString("cpf"));
                paciente.setDataNascimento(resultado.getString("dataNascimento"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setStatusSistema(resultado.getString("statusSistema"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setNumero(resultado.getString("numero"));
                paciente.setPontoReferencia(resultado.getString("pontoReferencia"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setCep(resultado.getString("cep"));
                pacientes.add(paciente);
            }
            resultado.close();
            acessar.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao consultar paciente");

        }
        return pacientes;
    }
    
    
    public void atualizar(Paciente paciente){
    
        
        try {
            Connection conexao = Conexao.conectar();

            String sqlUsuarioSistema = "UPDATE usuariosistema SET nome=?,rg=?,cpf=?,email=?,dataNascimento=?"
                    + "WHERE codigoUsuario=?";
            
            String sqlEndereco = "UPDATE endereco SET cep=?,bairro=?,numero=?,pontoReferencia=? WHERE codigoEndereco=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlUsuarioSistema);
           
            PreparedStatement stmt3 = conexao.prepareStatement(sqlEndereco);

            //VALORES PARA A TABELA USUÁRIO SISTEMA              
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getRg());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getEmail());
            stmt.setString(5, paciente.getDataNascimento());
            stmt.setString(6, paciente.getCodigoPaciente());
            stmt.execute();
            stmt.close();
            //VALORES PARA A TABELA PACIENTE           
           
            //VALORES PARA A TABELA ENDEREÇO
            stmt3.setString(1, paciente.getCep());
            stmt3.setString(2, paciente.getBairro());
            stmt3.setString(3, paciente.getNumero());
            stmt3.setString(4, paciente.getPontoReferencia());
            stmt3.setInt(5, paciente.getCodigoEndereco());
            stmt3.execute();
            stmt3.close();

            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
    
    
    }
    
    
    
    
      public void ativarDesativar(Paciente paciente) {

        try {
            Connection conexao = Conexao.conectar();

            String sqlAtivarDesativar = "UPDATE usuariosistema SET statusSistema=? WHERE codigoUsuario=?";

            PreparedStatement stmt = conexao.prepareStatement(sqlAtivarDesativar);
            stmt.setString(1, paciente.getStatusSistema());
            stmt.setString(2, paciente.getCodigoPaciente());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    
    

}
