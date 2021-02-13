<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<article id="menuLateral">
    <nav class="navigation">
        <ul class="mainmenu">
                    
            <li><a href="#">Atendente</a>
                <ul class="submenu">
                   <li><a href="adicionarAtendente.jsp"><h5>+Novo</h5></a></li>
                   <li><a href="<c:url value="Atendente?action=listar"/>"><h5>+Listar</h5></a></li>                
                </ul>
            </li>
            
             <li><a href="#">Especialidade médica</a>
                <ul class="submenu">
                     <li><a href="<c:url value="EspecialidadeMedica?action=buscar"/>"><h5>+Cadastrar</h5></a></li>                                        
                </ul>
            </li>
             <li><a href="#">Médico</a>
                <ul class="submenu">
                    <li><a href="<c:url value="Medico?action="/>">+Novo</a></li>
                    <li><a href="<c:url value="Medico?action=buscar"/>"><h5>+Listar</h5></a></li>                   
                </ul>
            </li>
            <li><a href="#">Sobre </a></li>
            <li><a href="index.jsp">Sair </a></li>
        </ul>
    </nav>
</article>