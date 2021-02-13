package Controladores;

import Dao.PacienteDAO;
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
@WebServlet(urlPatterns = "/Paciente")
public class PacienteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws IOException, ServletException {

        RequestDispatcher rd;
        String action = requisicao.getParameter("action");
        //VARIÁVEIS COMPARTILHADAS      
        String codigoPaciente = requisicao.getParameter("codigoPaciente");
        String usuario = requisicao.getParameter("usuario");
        String senha = requisicao.getParameter("senha");
        String nome = requisicao.getParameter("nome");
        String email = requisicao.getParameter("email");
        String rg = requisicao.getParameter("rg");
        String cpf = requisicao.getParameter("cpf");
        String dataNascimento = requisicao.getParameter("dataNascimento");
        String sexo = requisicao.getParameter("sexo");
        String statusSistema = requisicao.getParameter("statusSistema");
        String dataAdmissao = requisicao.getParameter("dataAdmissao");
        String logradouro = requisicao.getParameter("logradouro");
        String numero = requisicao.getParameter("numero");
        String pontoReferencia = requisicao.getParameter("pontoReferencia");
        String bairro = requisicao.getParameter("bairro");
        String cep = requisicao.getParameter("cep");
        String codigoEndereco = requisicao.getParameter("codigoEndereco");

        //OBJETOS PARA PERSISTÊNCIA
        Paciente paciente = new Paciente();
        PacienteDAO pacienteDAO = new PacienteDAO();

        //Listas usadas
        List<Paciente> pacientes;

        switch (action) {
            case "cadastrar":

                paciente.setCodigoPaciente(codigoPaciente);
                paciente.setCodigoUsuario(codigoPaciente);

                paciente.setUsuarioAcesso(usuario);
                paciente.setSenhaAcesso(senha);
                paciente.setNome(nome);
                paciente.setEmail(email);
                paciente.setRg(rg);
                paciente.setCpf(cpf);
                paciente.setDataNascimento(dataNascimento);
                paciente.setSexo(sexo);
                paciente.setStatusSistema(statusSistema);

                paciente.setLogradouro(logradouro);
                paciente.setNumero(numero);
                paciente.setPontoReferencia(pontoReferencia);
                paciente.setBairro(bairro);
                paciente.setCep(cep);
                //ADICIONANDO 
                pacienteDAO.adicionar(paciente);

                try {

                    pacientes = pacienteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarPaciente.jsp");
                    requisicao.setAttribute("pacientes", pacientes);
                    rd.forward(requisicao, resposta);

                } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
                }

                /* PrintWriter saida = resposta.getWriter();
                saida.println("codigo: " + codigoPaciente);
                saida.println("usuário: " + usuario);
                saida.println("senha: " + senha);
                saida.println("nome: " + nome);
                saida.println("email: " + email);
                saida.println("rg: " + rg);
                saida.println("cpf: " + cpf);
                saida.println("data: " + dataNascimento);
                saida.println("sexo: " + sexo);
                saida.println("status: " + statusSistema);
                saida.println("logradouro: " + logradouro);
                saida.println("numero: " + numero);
                saida.println("pontoreferencia: " + pontoReferencia);
                saida.println("bairro: " + bairro);
                saida.println("cep: " + cep);*/
                break;
            case "buscar":
                try {
                    pacientes = pacienteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarPaciente.jsp");
                    requisicao.setAttribute("pacientes", pacientes);
                    rd.forward(requisicao, resposta);

                } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
                }

                break;
            case "atualizar":
                paciente.setCodigoPaciente(codigoPaciente);
                paciente.setNome(nome);
                paciente.setUsuarioAcesso(usuario);
                paciente.setRg(rg);
                paciente.setCpf(cpf);
                paciente.setEmail(email);
                paciente.setDataNascimento(dataNascimento);
                paciente.setCodigoEndereco(Integer.parseInt(codigoEndereco));
                paciente.setCep(cep);
                paciente.setBairro(bairro);
                paciente.setNumero(numero);
                paciente.setPontoReferencia(pontoReferencia);

                pacienteDAO.atualizar(paciente);

                try {
                    pacientes = pacienteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarPaciente.jsp");
                    //String teste = "sucesso";
                    //requisicao.setAttribute("mensagem", teste);
                    requisicao.setAttribute("pacientes", pacientes);
                    rd.forward(requisicao, resposta);
                    //PrintWriter saida = resposta.getWriter();
                    //saida.println(codigoAtendente+"</br>"+"");
                } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
                }
                break;
            case "deletar":

                break;

            case "ativarDesativar":
                if ("ativado".equals(statusSistema)) {
                    statusSistema = "desativado";
                } else {
                    statusSistema = "ativado";
                }

                paciente.setCodigoPaciente(codigoPaciente);
                paciente.setStatusSistema(statusSistema);
                pacienteDAO.ativarDesativar(paciente);
                try {
                    pacientes = pacienteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarPaciente.jsp");
                    requisicao.setAttribute("pacientes", pacientes);
                    rd.forward(requisicao, resposta);
                } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
                }
                break;
        }

    }

}
