

//FUNÇÃO UTILIZADA PARA ATRIBUIT VALORES À JANELA MODAL DA TELA DE EDIÇÃO DE DADOS
function startModal(codigo, nome, rg, cpf, email, dataNascimento, codigoEndereco, cep, logradouro, bairro, numero, dataAdmissao, pontoReferencia) {

    document.getElementById("codigoAtendente").value = codigo;
    document.getElementById("nome").value = nome;
    document.getElementById('rg').value = rg;
    document.getElementById('cpf').value = cpf;
    document.getElementById('email').value = email;
    document.getElementById('dataNascimento').value = dataNascimento;
    document.getElementById('codigoEndereco').value = codigoEndereco;
    document.getElementById('cep').value = cep;
    document.getElementById('logradouro').value = logradouro;
    document.getElementById('bairro').value = bairro;
    document.getElementById('numero').value = numero;
    document.getElementById('dataAdmissao').value = dataAdmissao;
    document.getElementById('pontoReferencia').value = pontoReferencia;
}


function startModalEspecialidade(codigoEspecialidade, nomeEspecialidade) {
    document.getElementById("codigoEspecialidade").value = codigoEspecialidade;
    document.getElementById("nomeEspecialidadeAtualizar").value = nomeEspecialidade;

}


function startModalMedico(codigoMedico, registroProfissional, dataAdmissao, codigoEspecialidade, nomeEspecialidade, nome, email, rg, cpf, dataNascimento, codigoEndereco, cep, bairro, logradouro,numero,pontoReferencia) {


    document.getElementById("codigoMedico").value = codigoMedico;
    document.getElementById("registroProfissional").value = registroProfissional;
    document.getElementById("dataAdmissao").value = dataAdmissao;
    document.getElementById("codigoEspecialidade").value = codigoEspecialidade;
    document.getElementById("nomeEspecialidade").value = nomeEspecialidade;
    document.getElementById("nome").value = nome;   
    document.getElementById("email").value = email;
    document.getElementById("rg").value = rg;
    document.getElementById("cpf").value = cpf;
    document.getElementById("dataNascimento").value = dataNascimento;
    document.getElementById("codigoEndereco").value = codigoEndereco;
    document.getElementById("cep").value = cep;
    document.getElementById("bairro").value = bairro;
    document.getElementById("logradouro").value = logradouro;
    document.getElementById("numero").value = numero;
    document.getElementById("pontoReferencia").value = pontoReferencia;
    
}




function startModalPaciente(codigo, nome, rg, cpf, email, dataNascimento, codigoEndereco, cep, logradouro, bairro, numero,pontoReferencia){
    
    
    
    document.getElementById("codigoPaciente").value = codigo;
    document.getElementById("nome").value = nome;
    document.getElementById('rg').value = rg;
    document.getElementById('cpf').value = cpf;
    document.getElementById('email').value = email;
    document.getElementById('dataNascimento').value = dataNascimento;
    document.getElementById('codigoEndereco').value = codigoEndereco;
    document.getElementById('cep').value = cep;
    document.getElementById('logradouro').value = logradouro;
    document.getElementById('bairro').value = bairro;
    document.getElementById('numero').value = numero;
    
    document.getElementById('pontoReferencia').value = pontoReferencia;
    
}
        
        
        
function teste(){
    
    
    alert("teste");
}        