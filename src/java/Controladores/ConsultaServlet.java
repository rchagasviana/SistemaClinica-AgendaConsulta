/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dao.AtendenteDAO;
import Dao.ConsultaDAO;
import Dao.EspecialidadeMedicaDAO;
import Dao.PacienteDAO;
import Entidades.Atendente;
import Entidades.Consulta;
import Entidades.EspecialidadeMedica;
import Entidades.Medico;
import Entidades.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael
 */
@WebServlet(urlPatterns = "/Consulta")
public class ConsultaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws IOException, ServletException {

        //PARÂMETROS
        //String codigoConsulta = requisicao.getParameter("codigoConsulta");
        String codigoMedico = requisicao.getParameter("codigoMedico");
        String codigoPaciente = requisicao.getParameter("codigoPaciente");
        String codigoAtendente = requisicao.getParameter("codigoAtendente");
        String dataMarcacao = requisicao.getParameter("dataMarcacao");
        String dataConsulta = requisicao.getParameter("dataConsulta");
        String horarioConsulta = requisicao.getParameter("horarioConsulta");
        String statusConsulta = requisicao.getParameter("statusConsulta");
        String obs = requisicao.getParameter("obs");

        //AÇÃO A SER EXECUTADA
        String action = requisicao.getParameter("action");
        RequestDispatcher rd;
        //LISTA PARA EXIBIÇÃO DE DADOS
        List<EspecialidadeMedica> especialidadesMedicas;
        List<Medico> medicos;
        List<Paciente> pacientes;
        List<Atendente> atendentes;
         List<Consulta> consultas;
        //OBJETOS PARA PERSISTÊNCIA DE DADOS       
        EspecialidadeMedicaDAO especialidadeMedicaDAO = new EspecialidadeMedicaDAO();
        Paciente paciente = new Paciente();
        PacienteDAO pacienteDAO = new PacienteDAO();
        AtendenteDAO atendenteDAO = new AtendenteDAO();
        Consulta consulta = new Consulta();
        ConsultaDAO consultaDAO = new ConsultaDAO();

        switch (action) {
            case "":
                try {
                    especialidadesMedicas = especialidadeMedicaDAO.buscarAssociada();
                    pacientes = pacienteDAO.buscar();
                    atendentes = atendenteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("adicionarConsulta.jsp");
                    requisicao.setAttribute("pacientes", pacientes);
                    requisicao.setAttribute("especialidadesMedicas", especialidadesMedicas);
                    requisicao.setAttribute("atendentes", atendentes);
                    rd.forward(requisicao, resposta);
                } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
                }
                break;
            case "agendar":
                //consulta.setCodigoConsulta(codigoConsulta);
                consulta.setCodigoMedico(codigoMedico);
                consulta.setCodigoPaciente(codigoPaciente);
                consulta.setCodigoAtendente(codigoAtendente);
                consulta.setDataMarcacao(dataMarcacao);
                consulta.setDataConsulta(dataConsulta);
                consulta.setHorarioConsulta(horarioConsulta);
                consulta.setStatusConsulta(statusConsulta);
                consulta.setObs(obs);
                //AGENDANDO CONSULTA
                consultaDAO.agendar(consulta);
                /*PrintWriter saida = resposta.getWriter();
                saida.println("codigoConsulta: " + codigoConsulta);
                saida.println("codigoMedico: " + codigoMedico);
                saida.println("codigoPaciente: " + codigoPaciente);
                saida.println("codigoAtendente: " + codigoAtendente);
                saida.println("dataMarcacao: " + dataMarcacao);
                saida.println("dataConsulta: " + dataConsulta);
                saida.println("horarioConsulta: " + horarioConsulta);
                saida.println("statusConsulta: " + statusConsulta);
                saida.println("obs: " + obs);*/
                break;

            case "agendadas":
                consultas = consultaDAO.buscar();
                rd = requisicao.getRequestDispatcher("buscarConsulta.jsp");
                requisicao.setAttribute("consultas", consultas);
                rd.forward(requisicao, resposta);
                
                break;

        }

    }

}
