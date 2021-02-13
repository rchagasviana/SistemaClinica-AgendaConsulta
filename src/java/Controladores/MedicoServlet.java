package Controladores;

import Dao.EspecialidadeMedicaDAO;
import Dao.MedicoDAO;
import Entidades.EspecialidadeMedica;
import Entidades.Medico;
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
@WebServlet(urlPatterns = "/Medico")
public class MedicoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws IOException, ServletException {

        //AÇÃO A SER EXECUTADA
        String action = requisicao.getParameter("action");
        RequestDispatcher rd;
        //OBJETOS PARA PERSISTÊNCIA DE DADOS       
        EspecialidadeMedicaDAO especialidadeMedicaDAO = new EspecialidadeMedicaDAO();
        //LISTA PARA EXIBIÇÃO DE DADOS
        List<EspecialidadeMedica> especialidadesMedicas;
        List<Medico> medicos;

        //PARÂMETROS URL   
        String nome = requisicao.getParameter("nome");
        String rg = requisicao.getParameter("rg");
        String cpf = requisicao.getParameter("cpf");
        String email = requisicao.getParameter("email");
        String dataNascimento = requisicao.getParameter("dataNascimento");
        String sexo = requisicao.getParameter("sexo");
        String cep = requisicao.getParameter("cep");
        String logradouro = requisicao.getParameter("logradouro");
        String bairro = requisicao.getParameter("bairro");
        String numero = requisicao.getParameter("numero");
        String pontoReferencia = requisicao.getParameter("pontoReferencia");
        String codigoMedico = requisicao.getParameter("codigoMedico");
        String usuario = requisicao.getParameter("usuario");
        String senha = requisicao.getParameter("senha");
        String statusSistema = requisicao.getParameter("statusSistema");
        String dataAdmissao = requisicao.getParameter("dataAdmissao");
        String registroProfissional = requisicao.getParameter("registroProfissional");
        String codigoEspecialidade = requisicao.getParameter("codigoEspecialidade");
        String codigoEndereco = requisicao.getParameter("codigoEndereco");

        //OBJETOS PARA PERSISTÊNCIA DE DADOS
        Medico medico = new Medico();
        MedicoDAO medicoDAO = new MedicoDAO();

        switch (action) {
            case "cadastrar":
                //TABELA USUÁRIO
                medico.setCodigoUsuario(codigoMedico);
                medico.setUsuarioAcesso(usuario);
                medico.setSenhaAcesso(senha);
                medico.setNome(nome);
                medico.setEmail(email);
                medico.setRg(rg);
                medico.setCpf(cpf);
                medico.setDataNascimento(dataNascimento);
                medico.setSexo(sexo);
                medico.setStatusSistema(statusSistema);
                //TABELA MÉDICO
                medico.setCodigoMedico(codigoMedico);
                medico.setRegistroProfissional(registroProfissional);
                medico.setDataAdmissao(dataAdmissao);
                medico.setCodigoEspecialidade(Integer.parseInt(codigoEspecialidade));
                //TABELA ENDEREÇO
                medico.setLogradouro(logradouro);
                medico.setNumero(numero);
                medico.setPontoReferencia(pontoReferencia);
                medico.setBairro(bairro);
                medico.setCep(cep);
                //GRAVANDO NO BANCO DE DADOS
                medicoDAO.adicionar(medico);

                /* PrintWriter saida = resposta.getWriter();
                    saida.println("Nome: " + nome);
                    saida.println("Rg: " + rg);
                    saida.println("Cpf: " + cpf);
                    saida.println("E-mail: " + email);
                    saida.println("Data nascimento: " + dataNascimento);
                    saida.println("Sexo: " + sexo);
                    saida.println();
                    saida.println("Logradouro: " + logradouro);
                    saida.println("Bairro: " + bairro);
                    saida.println("Nuúmero: " + numero);
                    saida.println("Ponto de referência: " + cpf);
                    saida.println();
                    saida.println("Código médico: " + codigoMedico);
                    saida.println("Usuário: " + usuario);
                    saida.println("Senha: " + senha);
                    saida.println("Status Sistema: " + statusSistema);
                    saida.println("Data de admissão: " + dataAdmissao);
                    saida.println("Registro profissional: : " + registroProfissional);
                    saida.println("Código Especialidade: " + codigoEspecialidade);*/
                medicos = medicoDAO.buscar();
                rd = requisicao.getRequestDispatcher("buscarMedico.jsp");
                requisicao.setAttribute("medicos", medicos);
                rd.forward(requisicao, resposta);
                break;
            case "buscar":
                medicos = medicoDAO.buscar();
                rd = requisicao.getRequestDispatcher("buscarMedico.jsp");
                requisicao.setAttribute("medicos", medicos);
                rd.forward(requisicao, resposta);
                break;
            case "atualizar":
                medico.setCodigoMedico(codigoMedico);
                medico.setNome(nome);
                medico.setEmail(email);
                medico.setRg(rg);
                medico.setCpf(cpf);
                medico.setDataNascimento(dataNascimento);
                medico.setCodigoEndereco(Integer.parseInt(codigoEndereco));
                medico.setCep(cep);
                medico.setBairro(bairro);
                medico.setLogradouro(logradouro);
                medico.setNumero(numero);
                medico.setPontoReferencia(pontoReferencia);
                //Gravando no banco de dados
                medicoDAO.atualizar(medico);

                medicos = medicoDAO.buscar();
                rd = requisicao.getRequestDispatcher("buscarMedico.jsp");
                requisicao.setAttribute("medicos", medicos);
                rd.forward(requisicao, resposta);
                break;
            case "excluir":
                break;
            case "":
                especialidadesMedicas = especialidadeMedicaDAO.buscar();
                rd = requisicao.getRequestDispatcher("adicionarMedico.jsp");
                requisicao.setAttribute("especialidadesMedicas", especialidadesMedicas);
                rd.forward(requisicao, resposta);
                break;

            case "ativarDesativar":
                if ("ativado".equals(statusSistema)) {
                    statusSistema = "desativado";
                } else {
                    statusSistema = "ativado";
                }

                medico.setCodigoMedico(codigoMedico);
                medico.setStatusSistema(statusSistema);

                medicoDAO.ativarDesativar(medico);

                medicos = medicoDAO.buscar();
                rd = requisicao.getRequestDispatcher("buscarMedico.jsp");
                requisicao.setAttribute("medicos", medicos);
                rd.forward(requisicao, resposta);
                break;

        }

    }

}
