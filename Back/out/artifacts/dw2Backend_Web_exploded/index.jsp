<%--
  Created by IntelliJ IDEA.
  User: Brayan M. Gonçalves
  Date: 16/05/2019
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teste</title>
</head>
<body>
    <h2>Logar no Sistema</h2>
    <form action="/login/controller" method="post">
        Login: <input type="text" name="email"><br/>
        Senha: <input type="password" name="password">

        </br></br>
        <input type="submit" value="Logar">
    </form>

    </br></br>
    <h2>Cadastrar-se no Sistema</h2>
    <form action="/register/controller" method="post">
        Login: <input type="text" name="username"><br/>
        e-MAIL: <input type="text" name="email"><br/>
        Senha: <input type="password" name="password">

        </br></br>
        <input type="submit" value="Cadastrar-se">
    </form>

    </br></br>
    <h2>Listar Cadastros</h2>
    <form action="/list/controller" method="post">
        </br>
        <input type="submit" value="Listar">
    </form>

</body>
</html>
