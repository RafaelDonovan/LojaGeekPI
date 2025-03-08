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
    </head>

    <body>
        <form action="/login" method="post">
            <span>${requestScope.mensagem}</span>
            <br>

            <label for="email"> Usuario </label>
            <input type="text" id="email" name="email">

            <br>

            <label for="senha"> Senha </label>
            <input type="password" id="senha" name="senha">

            <button type="submit">Login</button>
        </form>
    </body>
</html>