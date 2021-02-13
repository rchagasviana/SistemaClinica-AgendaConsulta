package Controladores;

import Dao.AtendenteDAO;
import Entidades.Atendente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = "/Atendente")
public class AtendenteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws IOException, ServletException {

        RequestDispatcher rd;
        
        Atendente atendente = new Atendente();
        AtendenteDAO atendenteDAO = new AtendenteDAO();
        
        List<Atendente> atendentes;
        String action = requisicao.getParameter("action");
       
        //VARIÁVEIS COMPARTILHADAS      
        String codigoAtendente = requisicao.getParameter("codigoAtendente");
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

        try {

            switch (action) {
                case "listar":
                    //REDIRECIONAMENTO DE PÁGINA
                    atendentes = atendenteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarAtendente.jsp");
                    requisicao.setAttribute("atendentes", atendentes);
                    rd.forward(requisicao, resposta);
                    break;
                case "excluir":
                    atendente.setCodigoUsuario(codigoAtendente);
                    atendente.setCodigoEndereco(Integer.parseInt(codigoEndereco));
                    atendenteDAO.excluir(atendente);
                    atendentes = atendenteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarAtendente.jsp");
                    requisicao.setAttribute("atendentes", atendentes);
                    rd.forward(requisicao, resposta);
                    break;
                case "atualizar":
                    //IMPLEMENTAR
                    atendente.setCodigoAtendente(codigoAtendente);
                    atendente.setDataAdmissao(dataAdmissao);
                    atendente.setNome(nome);
                    atendente.setUsuarioAcesso(usuario);
                    atendente.setRg(rg);
                    atendente.setCpf(cpf);
                    atendente.setEmail(email);
                    atendente.setDataNascimento(dataNascimento);
                    atendente.setCodigoEndereco(Integer.parseInt(codigoEndereco));
                    atendente.setCep(cep);
                    atendente.setBairro(bairro);
                    atendente.setNumero(numero);
                    atendente.setPontoReferencia(pontoReferencia);

                    atendenteDAO.atualizar(atendente);
                    atendentes = atendenteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarAtendente.jsp");
                    //String teste = "sucesso";
                    //requisicao.setAttribute("mensagem", teste);
                    requisicao.setAttribute("atendentes", atendentes);
                    rd.forward(requisicao, resposta);

                    //PrintWriter saida = resposta.getWriter();
                    //saida.println(codigoAtendente+"</br>"+"");
                    break;
                case "cadastrar":
                    //INSERINDO NA TABELA USUÁRIO DO SISTEMA
                    atendente.setCodigoUsuario(codigoAtendente);
                    atendente.setUsuarioAcesso(usuario);
                    atendente.setSenhaAcesso(senha);
                    atendente.setNome(nome);
                    atendente.setEmail(email);
                    atendente.setRg(rg);
                    atendente.setCpf(cpf);
                    atendente.setDataNascimento(dataNascimento);
                    atendente.setSexo(sexo);
                    atendente.setStatusSistema(statusSistema);
                    //INSERINDO NA TABELA ATENDENTE
                    atendente.setCodigoAtendente(codigoAtendente);
                    atendente.setDataAdmissao(dataAdmissao);
                    //INSERINDO NA TABELA ENDEREÇO
                    atendente.setLogradouro(logradouro);
                    atendente.setNumero(numero);
                    atendente.setPontoReferencia(pontoReferencia);
                    atendente.setBairro(bairro);
                    atendente.setCep(cep);
                    //ADICIONANDO ATENDENTE
                    atendenteDAO.adicionar(atendente);
                    
                    atendentes = atendenteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarAtendente.jsp");
                    requisicao.setAttribute("atendentes", atendentes);
                    rd.forward(requisicao, resposta);
                    break;

                case "ativarDesativar":
                    if ("ativado".equals(statusSistema)) {
                        statusSistema = "desativado";
                    } else {
                        statusSistema = "ativado";
                    }

                    atendente.setCodigoAtendente(codigoAtendente);
                    atendente.setStatusSistema(statusSistema);
                    atendenteDAO.ativarDesativar(atendente);

                    atendentes = atendenteDAO.buscar();
                    rd = requisicao.getRequestDispatcher("buscarAtendente.jsp");
                    requisicao.setAttribute("atendentes", atendentes);
                    rd.forward(requisicao, resposta);
                    break;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            rd = requisicao.getRequestDispatcher("adicionarAtendente.jsp");
            requisicao.setAttribute("mensagem", "Erro ao cadastrar!");
            rd.forward(requisicao, resposta);
            Logger.getLogger(AtendenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
