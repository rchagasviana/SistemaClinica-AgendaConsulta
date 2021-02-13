package Controladores;

import Dao.AtendenteDAO;
import Dao.RootDAO;
import Entidades.Atendente;
import Entidades.Root;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/login")
public class RootServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws IOException, ServletException {

        //VARIÁVEIS PARA ARMAZENAR OS DADOS ENVIADOS DA PÁGINA JSP
        String usuario = requisicao.getParameter("usuario");
        String senha = requisicao.getParameter("senha");
        String tipoUsuario = requisicao.getParameter("tipoUsuario");
        RequestDispatcher rd;

        switch (tipoUsuario) {
            case "1":
                Root root = new Root();
                RootDAO rootDAO = new RootDAO();
                root.setUsuario(usuario);
                root.setSenha(senha);
                if (rootDAO.verificar(root)) {
                    rd = requisicao.getRequestDispatcher("root.jsp");
                    rd.forward(requisicao, resposta);
                } else {
                    rd = requisicao.getRequestDispatcher("index.jsp");
                    rd.forward(requisicao, resposta);
                }
                break;
            case "2":
                Atendente atendente = new Atendente();
                AtendenteDAO atendenteDAO = new AtendenteDAO();
                atendente.setUsuarioAcesso(usuario);
                atendente.setSenhaAcesso(senha);

                if (atendenteDAO.verificarUsuarioSistema(atendente)) {
                    rd = requisicao.getRequestDispatcher("atendente.jsp");
                    rd.forward(requisicao, resposta);
                } else {
                    rd = requisicao.getRequestDispatcher("index.jsp");
                    rd.forward(requisicao, resposta);
                }
                break;            
            
            default:
                rd = requisicao.getRequestDispatcher("index.jsp");
                rd.forward(requisicao, resposta);
                break;

        }

    }

}
