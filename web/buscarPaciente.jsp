<%@page import="Entidades.Paciente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/cabecalho.jsp"/>
<section id="meio">
    <c:import url="includes/menuLateralAtendente.jsp"/>
    <aside id="conteudo">         
        <h4><a href="atendente.jsp">início</a> > <a href="<c:url value="Paciente?action=buscar"/>">lista de pacientes</a></h4>        
        </br>
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Codigo</th>

                    <th>Usuário de Acesso</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>CPF</th>
                    <th>Sexo</th>
                    <th>Data Nascimento</th>
                    <th>Status</th>                    
                    <th>Editar</th>
                    <!-- <th>Excluir</th>-->
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>Codigo</th>

                    <th>Usuário de Acesso</th>
                    <th>Nome</th>
                    <th>E-mail</th>                   
                    <th>CPF</th>
                    <th>Sexo</th>
                    <th>Data Nascimento</th>
                    <th>Status</th>                    
                    <th>Editar</th>
                    <!--   <th>Excluir</th>-->
                </tr>
            </tfoot>
            <tbody>
                <c:forEach var="paciente" items="${pacientes}"> 
                    <tr>
                        <td> <c:out value="${paciente.getCodigoPaciente()}"></c:out></td>

                        <td> <c:out value="${paciente.getUsuarioAcesso()}"></c:out></td>
                        <td> <c:out value="${paciente.getNome()}"></c:out></td>
                        <td> <c:out value="${paciente.getEmail()}"></c:out></td>
                        <td> <c:out value="${paciente.getCpf()}"></c:out></td>
                        <td> <c:out value="${paciente.getSexo()}"></c:out></td>
                        <td> <c:out value="${paciente.getDataNascimento()}"></c:out></td>

                            <td><a href="<c:url value="Paciente?action=ativarDesativar&codigoPaciente=${paciente.getCodigoPaciente()}&statusSistema=${paciente.getStatusSistema()}"/>"> <c:out value="${paciente.getStatusSistema()}"></c:out></a></td>

                            <td><a href="#" id="${paciente.getCodigoPaciente()}" data-toggle="modal" data-target="#myModal" onclick="startModalPaciente(this.id, '${paciente.getNome()}', '${paciente.getRg()}', '${paciente.getCpf()}', '${paciente.getEmail()}', '${paciente.getDataNascimento()}', '${paciente.getCodigoEndereco()}', '${paciente.getCep()}', '${paciente.getLogradouro()}', '${paciente.getBairro()}', '${paciente.getNumero()}', '${paciente.getPontoReferencia()}')" >Editar</a></td>
                        <%--  <td><a href="<c:url value="Paciente?action=excluir&codigoPaciente=${atendente.getCodigoAtendente()}&codigoEndereco=${atendente.getCodigoEndereco()}"/>">Excluir</a></td>--%>
                    </tr>
                    <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-body" style="padding:40px 50px;">
                                <form role="form" action="Paciente?action=atualizar" method="post">
                                    <div class="form-group">
                                        <label for="codigoPaciente" ></span> Código</label>
                                        <input id="codigoPaciente" name="codigoPaciente" type="text" class="form-control"  readonly="true">

                                        <label for="nome"> Nome completo</label>
                                        <input id="nome" name="nome"type="text" class="form-control" placeholder="Nome completo" required>
                                        <label for="rg"></span> RG:</label>
                                        <input id="rg" name="rg" type="text" class="form-control" placeholder="número RG" required>
                                        <label for="cpf"></span> CPF:</label>
                                        <input id="cpf" name="cpf" type="text" class="form-control" placeholder="número CPF" required>
                                        <label for="email"></span> E-mail:</label>
                                        <input id="email" name="email" type="text" class="form-control" placeholder="e-mail" required>
                                        <label for="dataNascimento"></span> Data de nascimento:</label>
                                        <input id="dataNascimento" name="dataNascimento" type="date" class="form-control" placeholder="data de nascimento" required>
                                        <label for="codigoEndereco"></span> Código do Endereço:</label>
                                        <input id="codigoEndereco" name="codigoEndereco" type="text" class="form-control" placeholder="codigo do endereco" readonly="true" required>
                                        <label for="cep"></span> CEP:</label>
                                        <input id="cep" name="cep" type="text" class="form-control" placeholder="CEP" required>
                                        <label for="logradouro"></span>Logradouro:</label>
                                        <input id="logradouro" name="logradouro" type="text" class="form-control" placeholder="nome da rua" required>
                                        <label for="bairro"></span> Bairro:</label>
                                        <input id="bairro" name="bairro" type="text" class="form-control" placeholder="bairro" required>
                                        <label for="numero"></span> Número da casa:</label>
                                        <input id="numero" name="numero" type="text" class="form-control" placeholder="Número da casa" required>
                                        <label for="pontoReferencia"></span> Ponto de referência:</label>
                                        <input id="pontoReferencia" name="pontoReferencia" type="text" class="form-control" placeholder="Ponto de referência" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-success"></span> Atualizar</button>
                                        <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">Cancelar</button>
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