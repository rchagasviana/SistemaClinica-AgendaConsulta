<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/cabecalho.jsp"/>

<section id="meio">

    <c:import url="includes/menuLateralRoot.jsp"/>


    <aside id="conteudo">
        <h4><a href="root.jsp">início</a> ></h4>
        <h3>Especialidade Médica:</h3></br>
        <form action="EspecialidadeMedica?action=cadastrar" method="post">
            <table>                
                <tr>
                    <td>Nome:</td>
                    <td><input id="nomeEspecialidade" name="nomeEspecialidade" type="text" maxlength="45" required/></td>                 
                </tr>         
                <tr>
                    <td></td>
                    <td></br><input type="submit" value="Cadastrar"/></td>                    
                </tr>
            </table>
        </form>


        </br>
        </br>
        </br>




        <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>     
                    <th></th>  
                    <th></th>

                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>  
                    <th></th>  
                    <th></th>

                </tr>
            </tfoot>
            <tbody>
                <c:forEach var="especialidade" items="${especialidadesMedicas}"> 
                    <tr>
                        <td> <c:out value="${especialidade.getCodigoEspecialidade()}"></c:out></td>
                        <td> <c:out value="${especialidade.getNomeEspecialidade()}"></c:out></td>
                        <td><a href="#" id="${especialidade.getCodigoEspecialidade()}" data-toggle="modal" data-target="#myModal" onclick="startModalEspecialidade('${especialidade.getCodigoEspecialidade()}', '${especialidade.getNomeEspecialidade()}')" >Editar</a></td>
                            <th><a href="#">Excluir</a></th>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
        
        
        
        
        
         <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-body" style="padding:40px 50px;">
                                <form role="form" action="EspecialidadeMedica?action=atualizar" method="post">
                                    <div class="form-group">
                                        <label for="codigoEspecialidade" ></span> Código</label>
                                        <input id="codigoEspecialidade" name="codigoEspecialidade" type="text" class="form-control"  readonly="true"/>
                                        
                                        <label for="nomeEspecialidade"></span> Nome:</label>
                                        <input id="nomeEspecialidadeAtualizar" name="nomeEspecialidade" type="text" class="form-control" placeholder="Nome da especialidade"/>
                                        
                                        
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
        
        
        

    </aside>
</section>


<c:import url="includes/rodape.jsp"/>