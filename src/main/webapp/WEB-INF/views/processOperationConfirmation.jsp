<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <title><s:message code="processOperationConfirmation.title"/></title>
    </head>
    <body>
        <div class="container">
            <h1><s:message code="processOperationConfirmation.title"/></h1>
            <p>
                <s:message code="operationType"/> 
                <c:choose>
                    <c:when test="${operation.name == 'depositOperation'}">
                        <s:message code="deposit"/> 
                    </c:when>
                    <c:when test="${operation.name == 'withdrawOperation'}">
                        <s:message code="withdraw"/> 
                    </c:when>
                </c:choose>
            </p>
            <p>
                <s:message code="processOperationConfirmation.message" arguments="${account.number}"/>
                <fmt:formatNumber value="${account.balance / 100}" type="currency"/>
            </p>
            <a href="index.html"><s:message code="homeLink"/></a>
         </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min$.js"></script>
    </body>
</html>
