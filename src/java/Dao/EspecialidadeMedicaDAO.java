package Dao;

import BancoDeDados.Conexao;
import Entidades.EspecialidadeMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class EspecialidadeMedicaDAO {

    public void adicionar(EspecialidadeMedica especialidadeMedica) {

        try {
            Connection conexao = Conexao.conectar();
            String sqlAdicionar = "INSERT INTO especialidade (nomeEspecialidade)" + "values(?)";

            PreparedStatement stmt = conexao.prepareStatement(sqlAdicionar);
            stmt.setString(1, especialidadeMedica.getNomeEspecialidade());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EspecialidadeMedicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<EspecialidadeMedica> buscar() {
        List<EspecialidadeMedica> especialidadesMedicas = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            String sqlBuscar = "SELECT codigoEspecialidade,nomeEspecialidade FROM especialidade";
            PreparedStatement acessar = conexao.prepareStatement(sqlBuscar);
            ResultSet resultado = acessar.executeQuery();

            while (resultado.next()) {
                EspecialidadeMedica especialidadeMedica = new EspecialidadeMedica();
                especialidadeMedica.setCodigoEspecialidade(resultado.getInt("codigoEspecialidade"));
                especialidadeMedica.setNomeEspecialidade(resultado.getString("nomeEspecialidade"));
                especialidadesMedicas.add(especialidadeMedica);
            }

            resultado.close();
            acessar.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EspecialidadeMedicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return especialidadesMedicas;
    }
    
     public List<EspecialidadeMedica> buscarAssociada() {
        List<EspecialidadeMedica> especialidadesMedicas = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            String sqlBuscar = "select especialidade.codigoEspecialidade,especialidade.nomeEspecialidade,"
                    + "medico.codigoMedico,usuariosistema.nome from especialidade"
                    + " inner join medico on especialidade.codigoEspecialidade=medico.codigoEspecialidade "
                    + "inner join usuariosistema on usuariosistema.codigoUsuario=medico.codigoMedico";
            
            PreparedStatement acessar = conexao.prepareStatement(sqlBuscar);
            ResultSet resultado = acessar.executeQuery();

            while (resultado.next()) {
                EspecialidadeMedica especialidadeMedica = new EspecialidadeMedica();
                especialidadeMedica.setCodigoEspecialidade(resultado.getInt("codigoEspecialidade"));
                especialidadeMedica.setNomeEspecialidade(resultado.getString("nomeEspecialidade"));
                especialidadeMedica.setCodigoMedico(resultado.getString("codigoMedico"));
                especialidadeMedica.setNome(resultado.getString("nome"));
                especialidadesMedicas.add(especialidadeMedica);
            }

            resultado.close();
            acessar.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EspecialidadeMedicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return especialidadesMedicas;
    }
    
    
    
    

    public void atualizar(EspecialidadeMedica especialidadeMedica) {
        try {
            Connection conexao = Conexao.conectar();

            String sqlAtualizar = "UPDATE especialidade SET nomeEspecialidade=? WHERE codigoEspecialidade=?";
            PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar);
            
            //VALORES PARA A TABELA USUÁRIO SISTEMA              
            stmt.setString(1, especialidadeMedica.getNomeEspecialidade());
            stmt.setInt(2, especialidadeMedica.getCodigoEspecialidade());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

}
