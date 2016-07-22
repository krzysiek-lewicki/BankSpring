<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <title><s:message code="index.title"/></title>
</head>
<body>
<div class="container">
    <h1><s:message code="index.title"/></h1>
    <ul>
        <li><a href="createAccount.html"><s:message code="index.createAccountLink"/></a></li>
        <li><a href="operationForm.html?operationType=deposit"><s:message code="index.depositFundsLink"/></a></li>
        <li><a href="operationForm.html?operationType=withdraw"><s:message code="index.withdrawFundsLink"/></a></li>
        <sec:authorize access="hasRole('MANAGER')">
            <li><a href=""><s:message code="index.transferFundsLink"/></a></li>
        </sec:authorize>
        <li><a href="logout.html"><s:message code="index.logoutLink"/> <sec:authentication property="principal.username"/></a></li>
    </ul>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
