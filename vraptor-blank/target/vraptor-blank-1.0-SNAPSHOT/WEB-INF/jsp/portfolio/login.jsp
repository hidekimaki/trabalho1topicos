<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${linkTo[PortfolioController].autenticar}" method="POST">
            <input type="text" class="form-control" name="p.login" placeholder="Login" />
            <input type="password" class="form-control" name="p.senha" placeholder="Senha" />
            <button type="submit" class="btn btn-primary form-control">Login</button>
        </form>

    </body>
</html>
