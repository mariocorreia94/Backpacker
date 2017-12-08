<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Backpacker</title>
    <link rel="stylesheet" type="text/css" href="resources/main.css"/>
    <link rel="shortcut icon" type="image/png" href="resources/images/favicon.png"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<td class="text-center">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
                <form:form modelAttribute="newLogin" method="POST" >

                    <form:input type="text" path="username" class="form-control" placeholder="Nome"/>
                    <form:errors path="username" style="color:red"/>

                </br>
                    <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                    <form:errors path="password" style="color:red"/>
                </br>
                <div class="wrapper">
            <span class="group-btn">

            <form:button type="submit" class="btn btn-default pull-left">Login</form:button>
            </span>
                </div>
            </div>
            </form:form>
            <div style="color:red">${error}</div>
        </div>
    </div>
</body>
</html>