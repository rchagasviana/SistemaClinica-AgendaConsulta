package Controladores;

import Dao.EspecialidadeMedicaDAO;
import Entidades.EspecialidadeMedica;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/EspecialidadeMedica")
public class EspecialidadeMedicaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws IOException, ServletException {

        //OBJETO PARA ENVIO ENTRE PÁGINAS
        RequestDispatcher rd;

        String nomeEspecialidade = requisicao.getParameter("nomeEspecialidade");
        String action = requisicao.getParameter("action");
        //OBJETOS PARA PERSISTÊNCIA DE DADOS
        EspecialidadeMedica especialidadeMedica = new EspecialidadeMedica();
        EspecialidadeMedicaDAO especialidadeMedicaDAO = new EspecialidadeMedicaDAO();
        //LISTA DE ESPECIALIDADES MÉDICAS
        List<EspecialidadeMedica> especialidadesMedicas;

        switch (action) {
            case "cadastrar":
                especialidadeMedica.setNomeEspecialidade(nomeEspecialidade);
                especialidadeMedicaDAO.adicionar(especialidadeMedica);
                //BUSCANDO ESPECIALIDADES E REDIRECIONANDO
                especialidadesMedicas = especialidadeMedicaDAO.buscar();
                rd = requisicao.getRequestDispatcher("adicionarEspecialidadeMedica.jsp");
                requisicao.setAttribute("especialidadesMedicas", especialidadesMedicas);
                rd.forward(requisicao, resposta);
                break;

            case "buscar":
                especialidadesMedicas = especialidadeMedicaDAO.buscar();
                rd = requisicao.getRequestDispatcher("adicionarEspecialidadeMedica.jsp");
                requisicao.setAttribute("especialidadesMedicas", especialidadesMedicas);
                rd.forward(requisicao, resposta);
                break;

            case "atualizar":
                int codigoEspecialidade = Integer.parseInt(requisicao.getParameter("codigoEspecialidade"));
                especialidadeMedica.setCodigoEspecialidade(codigoEspecialidade);
                especialidadeMedica.setNomeEspecialidade(nomeEspecialidade);
                especialidadeMedicaDAO.atualizar(especialidadeMedica);
                especialidadesMedicas = especialidadeMedicaDAO.buscar();
                rd = requisicao.getRequestDispatcher("adicionarEspecialidadeMedica.jsp");
                requisicao.setAttribute("especialidadesMedicas", especialidadesMedicas);
                rd.forward(requisicao, resposta);
                break;

            case "excluir":
                break;

        }

    }
}
