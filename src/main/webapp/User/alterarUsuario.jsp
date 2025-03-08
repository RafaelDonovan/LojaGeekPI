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
        <script src="../Javascript/verifica.js"></script>
    </head>
        <c:if test="${sessionScope.loggedUser !=null}">
            <span>${sessionScope.loggedUser}</span>
                <a href="/logout"><button>Sair</button></a>
                <a href="/PaginaInicial.jsp"><button>Menu</button></a>
        </c:if>
        <body>
           <title>Alterar Usuário</title>
               <form action="/criar-usuario" method="post" onsubmit="return validarFormulario()">
                   <section>
                       <p>Alterar Usuário</p>

                       <div>Nome: <input type="text" name="User-Nome" id="User-Nome" value="${param.nome}"></div>
                       <div>CPF: <input type="text" name="User-CPF" id="User-CPF" value="${param.cpf}" maxlength="14" oninput="formatarCPF(this)"></div>
                       <div>Senha: <input type="password" id="senha"></div>
                       <div>Confirmar Senha: <input type="password" name="User-Senha" id="confirmarSenha"></div>
                       <div>Grupo: <input type="text" name="User-Grupo" id="User-Grupo" value="${param.Grupo}"></div>
                       <button type="submit">Ok</button>
                       <div><input type="hidden" name="id" id="id" value="${param.id}"></div>
                   </section>
               </form>
               <a href="/achar-todos-usuarios"><button>Cancelar</button></a>
               <span id="mensagemErro" style="display: none; color: red;"></span>

               <script>
                   function formatarCPF(input) {
                       var cpf = input.value.replace(/\D/g, '');

                       if (cpf.length > 3 && cpf.length <= 6) {
                           cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2');
                       } else if (cpf.length > 6 && cpf.length <= 9) {
                           cpf = cpf.replace(/(\d{3})(\d{3})(\d)/, '$1.$2.$3');
                       } else if (cpf.length > 9) {
                           cpf = cpf.replace(/(\d{3})(\d{3})(\d{3})(\d)/, '$1.$2.$3-$4');
                       }

                       input.value = cpf;
                   }
               </script>
</html>