function validarFormulario() {
    var nome = document.getElementById("User-Nome").value;
    var cpf = document.getElementById("User-CPF").value;
    var senha = document.getElementById("senha").value;
    var confirmarSenha = document.getElementById("confirmarSenha").value;
    var grupo = document.getElementById("User-Grupo").value;

    if (nome === "" || cpf === "" || senha === "" || confirmarSenha === "" || grupo === "") {
        document.getElementById("mensagemErro").innerHTML = "Por favor, preencha todos os campos.";
        document.getElementById("mensagemErro").style.display = "block";
        return false;
    }

    if (cpf.length !== 14) {
            mensagemErro.innerHTML = "O campo CPF deve ter exatamente 14 dígitos.";
            mensagemErro.style.display = "block";
            return false;
        }

    if (senha !== confirmarSenha) {
        document.getElementById("mensagemErro").innerHTML = "As senhas não coincidem.";
        document.getElementById("mensagemErro").style.display = "block";
        return false;
    }

    return true;
}