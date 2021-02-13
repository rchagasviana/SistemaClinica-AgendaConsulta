<%@page import="Entidades.Atendente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/cabecalho.jsp"/>
<section id="meio">
    <c:import url="includes/menuLateralRoot.jsp"/>
    <aside id="conteudo">                 
    
        <h4><a href="root.jsp">início</a> > <a href="<c:url value="Medico?action=buscar"/>">lista de médicos</a></h4>        
        </br>
        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>CRM</th> 
                    <th>Data admissão</th>                      
                    <th>Especialidade</th>                    
                    <th>Nome</th>
                    <th>Usuário sistema</th> 
                    <th>E-mail</th> 
                    <th>Status</th> 
                    <th></th>  
                    <th></th>
                </tr>
            </thead>
            <tfoot>
                <tr>   
                    <th>CRM</th>  
                    <th>Data admissão</th>                    
                    <th>Especialidade</th>                    
                    <th>Nome</th>
                    <th>Usuário sistema</th> 
                    <th>E-mail</th>     
                    <th>Status</th> 
                    <th></th>  
                    <th></th>
                </tr>
            </tfoot>
            <tbody>
                <c:forEach var="medico" items="${medicos}"> 
                    <tr>

                        <td> <c:out value="${medico.getRegistroProfissional()}"></c:out></td>
                        <td> <c:out value="${medico.getDataAdmissao()}"></c:out></td>                        
                        <td> <c:out value="${medico.getNomeEspecialidade()}"></c:out></td>                        
                        <td> <c:out value="${medico.getNome()}"></c:out></td>
                        <td> <c:out value="${medico.getUsuarioAcesso()}"></c:out></td>
                        <td> <c:out value="${medico.getEmail()}"></c:out></td>                    
                        <td><a href="<c:url value="Medico?action=ativarDesativar&codigoMedico=${medico.getCodigoMedico()}&statusSistema=${medico.getStatusSistema()}"/>"> <c:out value="${medico.getStatusSistema()}"></c:out></a></td> 
                        <td><a href="" id="${medico.getCodigoMedico()}" data-toggle="modal" data-target="#myModal"  onclick="startModalMedico('${medico.getCodigoMedico()}', '${medico.getRegistroProfissional()}', '${medico.getDataAdmissao()}', '${medico.getCodigoEspecialidade()}','${medico.getNomeEspecialidade()}', '${medico.getNome()}','${medico.getEmail()}', '${medico.getRg()}', '${medico.getCpf()}', '${medico.getDataNascimento()}', '${medico.getCodigoEndereco()}', '${medico.getCep()}', '${medico.getBairro()}', '${medico.getLogradouro()}', '${medico.getNumero()}', '${medico.getPontoReferencia()}')" >Editar</a></td>
                        
                    </tr>


                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-body" style="padding:40px 50px;">
                                <form role="form" action="Medico?action=atualizar" method="post">
                                    <div class="form-group">
                                        <label for="codigoMedico" ></span> Código</label>
                                        <input id="codigoMedico" name="codigoMedico" type="text" class="form-control"  readonly="true">

                                        <label for="registroProfissional" ></span> CRM</label>
                                        <input id="registroProfissional" name="registroProfissional" type="text" class="form-control"  readonly="true">

                                        <label for="dataAdmissao"></span> Data Admissão:</label>
                                        <input id="dataAdmissao" name="dataAdmissao" type="date" class="form-control" placeholder="Data de admissão"  readonly="true">

                                       
                                        <label for="codigoEspecialidade" ></span> Codigo Especialidade</label>
                                         <input id="codigoEspecialidade" name="codigoEspecialidade" type="text" class="form-control"  readonly="true">
 
                                         <label for="nomeEspecialidade" ></span> Nome Especialidade</label>
                                         <input id="nomeEspecialidade" name="nomeEspecialidade" type="text" class="form-control" readonly="true">
             
                                        
                                        <label for="nome"> Nome completo</label>
                                        <input id="nome" name="nome"type="text" class="form-control" placeholder="Nome completo" required>

                                        <label for="email"></span> E-mail:</label>
                                        <input id="email" name="email" type="text" class="form-control" placeholder="e-mail" required>

                                        <label for="rg"></span> RG:</label>
                                        <input id="rg" name="rg" type="text" class="form-control" placeholder="número RG" required>

                                        <label for="cpf"></span> CPF:</label>
                                        <input id="cpf" name="cpf" type="text" class="form-control" placeholder="número CPF" required>


                                        <label for="dataNascimento"></span> Data de nascimento:</label>
                                        <input id="dataNascimento" name="dataNascimento" type="date" class="form-control" placeholder="data de nascimento" required>

                                        <label for="codigoEndereco"></span> Código do Endereço:</label>
                                        <input id="codigoEndereco" name="codigoEndereco" type="text" class="form-control" placeholder="codigo do endereco" readonly="true" required>

                                        <label for="cep"></span> CEP:</label>
                                        <input id="cep" name="cep" type="text" class="form-control" placeholder="CEP" required>


                                        <label for="bairro"></span> Bairro:</label>
                                        <input id="bairro" name="bairro" type="text" class="form-control" placeholder="bairro" required>

                                        <label for="logradouro"></span>Logradouro:</label>
                                        <input id="logradouro" name="logradouro" type="text" class="form-control" placeholder="nome da rua" required>


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