function validarFormulario() {
    var nome = document.getElementById("User-Nome").value;
    var cpf = document.getElementById("User-CPF").value;
    var email = document.getElementById("User-Email").value;
    var senha = document.getElementById("senha").value;
    var confirmarSenha = document.getElementById("confirmarSenha").value;
    var grupo = document.getElementById("User-Grupo").value;
    var mensagemErro = document.getElementById("mensagemErro");

    if (nome === "" || cpf === "" || email === "" || senha === "" || confirmarSenha === "" || grupo === "") {
        mensagemErro.innerHTML = "Por favor, preencha todos os campos do formulário.";
        mensagemErro.style.display = "block";
        return false;
    }

    if (cpf.length !== 14) {
        mensagemErro.innerHTML = "O campo CPF deve ter exatamente 14 dígitos.";
        mensagemErro.style.display = "block";
        return false;
    }

    if (senha !== confirmarSenha) {
        mensagemErro.innerHTML = "Os campos de senha não estão iguais. Por favor, verifique.";
        mensagemErro.style.display = "block";
        return false;
    }

    return true;
}