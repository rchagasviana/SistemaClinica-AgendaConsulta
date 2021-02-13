<%-- 
    Document   : index
    Created on : 14/05/2017, 00:03:37
    Author     : Rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso ao Sistema</title>
        <link rel="stylesheet" href="css/login.css"> 
    </head>
    <body>

        <div class="formulario">
            <form action="login" method="POST">   
                <table>
                    <tr>
                        <td>Usuário:</td>
                        <td><input name="usuario" type="text"required/></td>
                    </tr>
                    <tr>
                        <td>Senha:</td>
                        <td><input name="senha" type="password" required/></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <select name="tipoUsuario">
                                <option value="0" selected="selected">selecione uma opção</option>
                                <option value="1">Administrador</option>
                                <option value="2">Atendente</option>
                                

                            </select>
                        </td>
                    <tr>   


                    <tr>
                        <td></td>
                        <td><input type="submit" value="Entrar"/></td>
                    </tr>
                </table>  
            </form>
        </div>

    </body>
</html>
