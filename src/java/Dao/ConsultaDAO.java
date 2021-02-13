package Dao;

import BancoDeDados.Conexao;
import Entidades.Consulta;
import Entidades.Medico;
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
public class ConsultaDAO {

    public void agendar(Consulta consulta) {

        try {
            Connection conexao = Conexao.conectar();
            String sqlAgendar = "INSERT INTO consulta (codigoMedico,codigoPaciente,"
                    + "dataMarcacao,dataConsulta,horarioConsulta,"
                    + "statusConsulta,codigoAtendente,obs)"
                    + "VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sqlAgendar);
            //stmt.setString(1, consulta.getCodigoConsulta());
            stmt.setString(1, consulta.getCodigoMedico());
            stmt.setString(2, consulta.getCodigoPaciente());
            stmt.setString(3, consulta.getDataMarcacao());
            stmt.setString(4, consulta.getDataMarcacao());
            stmt.setString(5, consulta.getHorarioConsulta());
            stmt.setString(6, consulta.getStatusConsulta());
            stmt.setString(7, consulta.getCodigoAtendente());
            stmt.setString(8, consulta.getObs());

            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Consulta não agendada" + "erro: " + ex.getMessage());

        }

    }

    public List<Consulta> buscar() {

        List<Consulta> consultas;
        consultas = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            String sql = "select consulta.codigoConsulta,consulta.codigoMedico,consulta.codigoPaciente,consulta.dataMarcacao,consulta.dataConsulta,consulta.horarioConsulta,consulta.statusConsulta,consulta.obs,especialidade.nomeEspecialidade,usuariosistema.nome,atendente.codigoAtendente from consulta inner join paciente on consulta.codigoPaciente = paciente.codigoPaciente inner join atendente on consulta.codigoAtendente=atendente.codigoAtendente inner join medico on consulta.codigoMedico=medico.codigoMedico inner join especialidade on medico.codigoEspecialidade=especialidade.codigoEspecialidade inner join usuariosistema on medico.codigoUsuario = usuariosistema.codigoUsuario";

            PreparedStatement acessar = conexao.prepareStatement(sql);
            ResultSet resultado = acessar.executeQuery();

            while (resultado.next()) {
                Consulta consulta = new Consulta();
                consulta.setCodigoConsulta(resultado.getString("codigoConsulta"));
                consulta.setCodigoMedico(resultado.getString("codigoMedico"));//ok
                consulta.setCodigoPaciente(resultado.getString("codigoPaciente"));//ok
                consulta.setDataMarcacao(resultado.getString("dataMarcacao"));//ok
                consulta.setDataConsulta(resultado.getString("dataConsulta"));//ok
                consulta.setHorarioConsulta(resultado.getString("horarioConsulta"));//ok
                consulta.setObs(resultado.getString("obs"));//ok
                consulta.setNomeEspecialidade(resultado.getString("nomeEspecialidade"));//ok
                consulta.setNome(resultado.getString("nome"));//ok
                consulta.setCodigoAtendente("codigoAtendente");
                

                consultas.add(consulta);
            }
            resultado.close();
            acessar.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao consultar agenda de consultas"+e.getLocalizedMessage());
        }
        return consultas;
    }

}
