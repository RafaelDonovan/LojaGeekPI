<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="style.css">
    <script src="../Javascript/verificaCriar.js"></script>
</head>

<body>
    <c:if test="${sessionScope.loggedUser !=null}">
        <span>${sessionScope.loggedUser}</span>
        <a href="/logout"><button>Sair</button></a>
        <a href="/PaginaInicial.jsp"><button>Menu</button></a>
    </c:if>

    <title>Cadastrar Usuário</title>


    <form action="/criar-usuario" method="post" onsubmit="return validarFormulario()">
        <section>
            <p> Cadastrar Usuário </p>

            <div>Nome: <input type="text" name="User-Nome" id="User-Nome"></div>
            <div>CPF: <input type="text" name="User-CPF" id="User-CPF" oninput="formatarCPF()" maxlength="14"></div>
            <div>E-mail: <input type="email" name="User-Email" id="User-Email"></div>
            <div>Senha: <input type="password" id="senha"></div>
            <div>Confirmar Senha: <input type="password" name="User-Senha" id="confirmarSenha"></div>
            <div>Grupo:
                <input list="grupo" name="User-Grupo" id="User-Grupo"> </input><br/><br/>
                <datalist id="grupo">
                  <option value="ADM">
                  <option value="Estoquista">
                </datalist>
            </div>
            <c:if test="${sessionScope.loggedUser !=null}">
                <button type="submit">Ok</button>
            </c:if>

            <div><input type="hidden" name="id" id="id"></div>
        </section>
    </form>
    <a href="/achar-todos-usuarios"><button>Cancelar</button></a>
    <span id="mensagemErro" style="display: none; color: red;"></span>

    <script>
        function formatarCPF() {
            let cpfInput = document.getElementById('User-CPF');
            let cpf = cpfInput.value;

            cpf = cpf.replace(/\D/g, '');

            cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');

            cpfInput.value = cpf;
        }
    </script>
</body>

</html>