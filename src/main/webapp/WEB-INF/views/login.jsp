<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <title><s:message code="login.title"/></title>
    </head>
    <body>
        <div class="container">
            <h1><s:message code="login.title"/></h1>
            <form action="login.html" method="post">
                <div class="form-group">
                    <s:message code="login.usernameLabel"/>
                    <input type="text" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <s:message code="login.passwordLabel"/>
                    <input type="password" name="password" class="form-control"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default"><s:message code="login.login"/></button>
            </form>
            <c:if test="${param.error != null}">
                <p class="bg-danger">
                    <s:message code="login.authenticationError"/>
                </p>
            </c:if>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </body>
</html>
