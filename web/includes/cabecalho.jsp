<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>ConsulPro</title>        
        <!--Chamada estilo próprio-->
        <link type="text/css" rel="stylesheet" href="css/estilo.css"> 
        <link type="text/css" rel="stylesheet" href="css/estiloMenuLateral.css">     

        <!--Arquivos da dataTable-->
        <link rel="stylesheet" href="css/dataTable/jquery.dataTables.min.css"> 
        <script src="css/dataTable/jquery-1.12.4.js"></script>
        <script src="css/dataTable/jquery.dataTables.min.js"></script>

        <script src="js/funcoesEspeciais.js"></script>
        <!--Arquivos da bootstrap-->
        <link type="text/css" rel="stylesheet" href="css/boostrap/bootstrap.min.css">   
        <script>
            $(document).ready(function () {
                $('#example').DataTable({
                    "language": {
                        "sEmptyTable": "Nenhum registro encontrado",
                        "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                        "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                        "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                        "sInfoPostFix": "",
                        "sInfoThousands": ".",
                        "sLengthMenu": "Resultados por página _MENU_ ",
                        "sLoadingRecords": "Carregando...",
                        "sProcessing": "Processando...",
                        "sZeroRecords": "Nenhum registro encontrado",
                        "sSearch": "Pesquisar",
                        "oPaginate": {
                            "sNext": "Próximo",
                            "sPrevious": "Anterior",
                            "sFirst": "Primeiro",
                            "sLast": "Último"
                        },
                        "oAria": {
                            "sSortAscending": ": Ordenar colunas de forma ascendente",
                            "sSortDescending": ": Ordenar colunas de forma descendente"
                        }
                    }
                });
            });
        </script>    
  
        <!--<script>
            function validarCpf() {
                var teste = document.getElementById("cpf").value;
                var teste2;
                var i;

                for (i = 0; i < 10; i++) {
                    teste2 = teste.charAt(3).value;
                }

                alert(teste2);

            }
        </script>  -->    
    </head>
    <body>
    