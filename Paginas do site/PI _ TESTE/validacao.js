document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();

    var senha1 = document.querySelector('input[name="password"]').value;
    var senha2 = document.querySelector('input[name="confirm_password"]').value;
    var dataNascimento = new Date(document.querySelector('input[name="Data de nascimento"]').value);
    var cep = document.querySelector('input[name="cep"]').value;
    var numero = document.querySelector('input[name="numero"]').value;

    // Verifica se as senhas são iguais
    if (senha1 !== senha2) {
        alert('As senhas devem ser iguais!');
        return false;
    }

    // Verifica se a data de nascimento é válida
    var anoAtual = new Date().getFullYear();
    if (dataNascimento.getFullYear() > 2023 || dataNascimento.getFullYear() < anoAtual - 100) {
        alert('A data de nascimento deve ser entre ' + (anoAtual - 100) + ' e 2023!');
        return false;
    }

    // Verifica se o CEP é válido
    var regexCep = /^[0-9]{5}-[0-9]{3}$/;
    if (!regexCep.test(cep)) {
        alert('O CEP deve estar no formato correto (ex: 04811-140)!');
        return false;
    }

    // Verifica se o número foi digitado
    if (!numero) {
        alert('O número deve ser digitado!');
        return false;
    }

    alert('Formulário enviado com sucesso!');

    // Limpa os campos do formulário
    this.reset();

    return true;
});
