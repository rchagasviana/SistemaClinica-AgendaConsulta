<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<article id="menuLateral">
    <nav class="navigation">
        <ul class="mainmenu">
                    
            <li><a href="#">Paciente</a>
                <ul class="submenu">
                   <li><a href="adicionarPaciente.jsp"><h5>+Novo</h5></a></li>
                   <li><a href="<c:url value="Paciente?action=buscar"/>"><h5>+Listar</h5></a></li>                
                </ul>
            </li>
            
             
             <li><a href="#">Consulta</a>
                <ul class="submenu">
                    <li><a href="<c:url value="Consulta?action="/>">+Agendar</a></li>
                    <li><a href="Consulta?action=agendadas"><h5>+Agendadas</h5></a></li>                   
                </ul>
            </li>
            
            <li><a href="index.jsp">Sair </a></li>
        </ul>
    </nav>
</article>