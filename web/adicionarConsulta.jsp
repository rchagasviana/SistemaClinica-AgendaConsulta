<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/cabecalho.jsp"/>

<section id="meio">

    <c:import url="includes/menuLateralAtendente.jsp"/>


    <aside id="conteudo">
        <h4><a href="atendente.jsp">início</a> > <a href="#">cadastro de consultas</a></h4>
        <form action="Consulta?action=agendar" method="post">
            <table>
                <tr>
                    <td><h3>Agendar Consulta:</h3></br></td>
                    <td></td>                 
                </tr>

              <!--  <tr>
                    <td>Código da consulta:</td>
                    <td><input id="codigoConsulta" name="codigoConsulta" type="text" maxlength="5" required/></td>                 
                </tr>-->

                <tr>
                    <td>Paciente: </td>
                    <td>
                        <select name="codigoPaciente">
                            <option value="0" selected="selected">selecione uma opção</option>
                            <c:forEach var="pacientes" items="${pacientes}"> 
                                <option value="${pacientes.getCodigoPaciente()}"><c:out value="${pacientes.getNome()}"></c:out></option>
                            </c:forEach>

                        </select>
                    </td>                 
                </tr>



                <tr>
                    <td>Data de marcação:</td>
                    <td><input id="dataMarcacao" name="dataMarcacao" type="date" required/></td>                 
                </tr>

                <tr>
                    <td>Data consulta:</td>
                    <td><input id="dataConsulta" name="dataConsulta" type="date" required/></td>                 
                </tr>

                <tr>
                    <td>Horarário:</td>
                    <td><input id="horarioConsulta" name="horarioConsulta" type="time" required/></td>                 
                </tr>



                <tr>
                    <td>Especialidade: </td>
                    <td>
                        <select name="codigoMedico">
                            <option value="0" selected="selected">selecione uma opção</option>
                            <c:forEach var="especialidade" items="${especialidadesMedicas}"> 
                                <option value="${especialidade.getCodigoMedico()}"><c:out value="${especialidade.getNomeEspecialidade()}"></c:out> - <c:out value="${especialidade.getNome()}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>                 
                </tr>



                <tr>
                    <td>Atendente: </td>
                    <td>
                        <select name="codigoAtendente">
                            <option value="0" selected="selected">selecione uma opção</option>
                            <c:forEach var="atendentes" items="${atendentes}"> 
                                <option value="${atendentes.getCodigoAtendente()}"><c:out value="${atendentes.getNome()}"></c:out></option>
                            </c:forEach>

                        </select>
                    </td>                 
                </tr>

                <tr>
                    <td>Status:</td>
                    <td>
                        <input id="statusConsulta" name="statusConsulta" type="radio" value="agendada" checked/> agendada

                    </td>                 
                </tr>


                <tr>
                    <td>Observação:</td>
                    <td><textarea rows="5" cols="50" id="obs" name="obs" type="areatext" resize="none"></textarea></td>                 
                </tr>







                <tr>
                    <td></td>
                    <td></br><input type="submit" value="Agendar"/></td>                    
                </tr>
            </table>
        </form>
    </aside>
</section>


<c:import url="includes/rodape.jsp"/>