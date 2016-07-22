<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <title><s:message code="selectAccount.title"/></title>
    </head>
    <body>
        <div class="container">
            <h1><s:message code="selectAccount.title"/></h1>
            <p>
                <s:message code="operationType"/> 
                <c:choose>
                    <c:when test="${param.operationType == 'deposit'}">
                        <s:message code="deposit"/> 
                    </c:when>
                    <c:when test="${param.operationType == 'withdraw'}">
                        <s:message code="withdraw"/> 
                    </c:when>
                </c:choose>
            </p>
            <sf:form action="operationForm.html" method="post" modelAttribute="operationDto">
                <div class="form-group">
                    <s:message code="selectAccount.accountLabel"/>
                    <sf:input path="sourceAccountNumber" type="text" name="accountNumber" class="form-control"/>
                    <p class="bg-danger">
                        <sf:errors path="sourceAccountNumber"/>
                    </p>
                </div>
                <div class="form-group">
                    <s:message code="selectAccount.fundsLabel"/>
                    <sf:input path="funds" type="text" name="funds" class="form-control"/>
                    <p class="bg-danger">
                        <sf:errors path="funds"/>
                    </p>
                </div>
                <sf:hidden path="name" value="${param.operationType == 'deposit' ? 'depositOperation' : 'withdrawOperation'}"/>
                <button type="submit" class="btn btn-default"><s:message code="next"/></button>
            </sf:form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </body>
</html>
