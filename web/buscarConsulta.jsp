<%@page import="Entidades.Paciente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/cabecalho.jsp"/>
<section id="meio">
    <c:import url="includes/menuLateralAtendente.jsp"/>
    <aside id="conteudo">         
        <h4><a href="atendente.jsp">início</a> > <a href="<c:url value="Consulta?action=agendadas"/>">consultas agendadas</a></h4>        
        </br>
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Codigo Paciente</th>
                    <th>Data marcação</th>
                    <th>Data consulta</th>
                    <th>Horario</th>
                    <th>Médico</th>
                    <th>Especialidade</th>

                    <th>Editar</th>
                    <!-- <th>Excluir</th>-->
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>Codigo Paciente</th>
                    <th>Data marcação</th>
                    <th>Data consulta</th>
                    <th>Horario</th>
                    <th>Médico</th>
                    <th>Especialidade</th>                   
                    <th>Editar</th>
                    <!--   <th>Excluir</th>-->
                </tr>
            </tfoot>
            <tbody>
                <c:forEach var="consultas" items="${consultas}"> 
                    <tr>
                        <td> <c:out value="${consultas.getCodigoPaciente()}"></c:out></td>
                        <td> <c:out value="${consultas.getDataMarcacao()}"></c:out></td>
                        <td> <c:out value="${consultas.getDataConsulta()}"></c:out></td>
                        <td> <c:out value="${consultas.getHorarioConsulta()}"></c:out></td>
                        <td> <c:out value="${consultas.getNome()}"></c:out></td>
                        <td> <c:out value="${consultas.getNomeEspecialidade()}"></c:out></td>
                        
                            <td><a href="#" id="${consultas.getCodigoPaciente()}" data-toggle="modal" data-target="#myModal" >Editar</a></td>

                    </tr>
                    <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-body" style="padding:40px 50px;">
                                <form role="form" action="Paciente?action=atualizar" method="post">
                                    <div class="form-group">                                        
                                        
                                        <label>Código do paciente:</label>
                                        ${consultas.getCodigoPaciente()} </br>
                                        <label>Data da consulta:</label> 
                                        ${consultas.getDataConsulta()}</br>
                                        <label>Horário da consulta:</label>
                                        ${consultas.getHorarioConsulta()}</br>
                                        <label>Médico:</label>
                                        ${consultas.getNome()}
                                                                               

                                    </div>
                                    <div class="modal-footer">                                        
                                        <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Sair</button>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                            </div>
                        </div>
                    </div>
                </div> 
            </c:forEach>
            </tbody>
        </table>   

    </aside>
</section>


<c:import url="includes/rodape.jsp"/>