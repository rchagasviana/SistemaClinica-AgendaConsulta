<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="includes/cabecalho.jsp"/>

<section id="meio">

    <c:import url="includes/menuLateralRoot.jsp"/>


    <aside id="conteudo">
        <h4><a href="root.jsp">início</a> > <a href="#">cadastrar médico</a></h4>
        <form action="Medico?action=cadastrar" method="post">
            <table>
                <tr>
                    <td><h3>Dados pessoais:</h3></br></td>
                    <td></td>                 
                </tr>
                <tr>
                    <td>Nome completo:</td>
                    <td><input id="nome" name="nome" type="text" maxlength="45" required/></td>                 
                </tr>

                <tr>
                    <td>RG:</td>
                    <td><input id="rg" name="rg" type="text" maxlength="20" required/></td>                 
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input id="cpf" name="cpf" type="text" maxlength="11" onblur=(validarCpf()) required/></td>                 
                </tr>

                <tr>
                    <td>E-mail:</td>
                    <td><input id="email" name="email" type="email" maxlength="45" required/></td>                 
                </tr>

                <tr>
                    <td>Data de nascimento:</td>
                    <td><input id="dataNascimento" name="dataNascimento" type="date" required/></td>                 
                </tr>

                <tr>
                    <td>Sexo:</td>
                    <td>
                        Masculino: <input id="sexo" name="sexo" type="radio" value="masculino" checked/>
                        Feminino: <input id="sexo" name="sexo" type="radio" value="feminino"/>
                    </td>                 
                </tr>

                <tr>
                    <td><h3></br>Endereço:</h3></br></td>
                    <td></td>                 
                </tr>
                <tr>
                    <td>Cep:</td>
                    <td><input id="cep" name="cep" type="text" maxlength="7" required/></td>                 
                </tr>


                <tr>
                    <td>Logradouro:</td>
                    <td><input id="logradouro" name="logradouro" type="text" maxlength="45" required/></td>                 
                </tr>
                <tr>
                    <td>Bairro:</td>
                    <td><input id="bairro" name="bairro" type="text" maxlength="45" required/></td>                 
                </tr>


                <tr>
                    <td>Número:</td>
                    <td><input id="numero" name="numero" type="text" maxlength="10" required/></td>                 
                </tr>
                <tr>
                    <td>Ponto de referência:</td>
                    <td><input id="pontoReferencia" name="pontoReferencia" type="text" maxlength="45" required/></td>                 
                </tr>
                <!-- <tr>
                     <td>Ponto de Referência:</td>
                     <td><input id="pontoReferencia" name="pontoReferencia" type="text" maxlength="45" required/></td>                 
                 </tr>-->

                <tr>
                    <td><h3></br>Acesso ao sistema</h3></br></td>
                    <td></td>                 
                </tr>
                <tr>
                    <td>Código:</td>
                    <td><input id="codigoMedico" name="codigoMedico" type="text" maxlength="5" required/></td>                 
                </tr>   

                <tr>
                    <td>Usuário:</td>
                    <td><input id="usuario" name="usuario" type="text" maxlength="30" required/></td>                 
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input id="senha" name="senha" type="password" maxlength="15" required/></td>                 
                </tr>


                <tr>
                    <td>Situação:</td>
                    <td>
                        Ativado: <input id="statusSistema" name="statusSistema" type="radio" value="ativado" checked/>
                        Desativado: <input id="statusSistema" name="statusSistema" type="radio" value="desativado"/>
                    </td>                 
                </tr>



                <tr>
                    <td><h3></br>Dados Profissionais</h3></br></td>
                    <td></td>                 
                </tr>

                <tr>
                    <td>Data de admissão:</td>
                    <td><input id="dataAdmissao" name="dataAdmissao" type="date" required/></td>                 
                </tr>


                <tr>
                    <td>Nº CRM:</td>
                    <td><input id="registroProfissional" name="registroProfissional" type="text" maxlength="15" required/></td>                 
                </tr>


                <tr>
                    <td>Especialidade: </td>
                    <td>
                        <select name="codigoEspecialidade">
                            <option value="0" selected="selected">selecione uma opção</option>
                            <c:forEach var="especialidade" items="${especialidadesMedicas}"> 
                                <option value="${especialidade.getCodigoEspecialidade()}"><c:out value="${especialidade.getNomeEspecialidade()}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>                 
                </tr>

                <tr>
                    <td></td>
                    <td></br><input type="submit" value="Adicionar"/></td>                    
                </tr>
            </table>
        </form>
    </aside>
</section>


<c:import url="includes/rodape.jsp"/>