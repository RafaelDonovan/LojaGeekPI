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
    <title>Pricipal</title>

    <link rel="stylesheet" href="style.css">
</head>

<body>
    <c:if test="${sessionScope.loggedUser != null || sessionScope.loggedUserEstoque != null}">
        <span>${sessionScope.loggedUser}</span>
            <a href="/logout"><button>Sair</button></a>
    </c:if>
    <div>Principal</div>
    <a href="/achar-todos-produtos">Listar Produto</a>
    <a href="/achar-todos-usuarios">Listar Usuário</a>
    <a href="">Listar Pedidos</a>
</body>

</html>