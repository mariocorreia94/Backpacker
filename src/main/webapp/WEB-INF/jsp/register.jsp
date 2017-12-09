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
    <div class="container">
        <form:form modelAttribute="newUser" action="newUser">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover" id="tab_logic">
                        <thead>
                        <tr>
                            <th class="text-center">
                                Name
                            </th>
                            <th class="text-center">
                                Password
                            </th>
                            <th class="text-center">
                                Email
                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr id='addr0'>
                            <td>
                                <form:input type="text" path="username" class="form-control" placeholder="Nome"/>
                                <form:errors path="username" style="color:red"/>
                            </td>

                            <td>

                                <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                                <form:errors path="password" style="color:red"/>
                            </td>
                            <td>
                                <form:input type="text" path="email" class="form-control" placeholder="Email"/>
                                <form:errors path="email" style="color:red"/>
                            </td>
                        </tr>
                        <tr id='addr1'></tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <form:button type="submit" method="POST" formaction="createNewUser"
                         class="btn btn-default pull-left">Adicionar Cliente</form:button>
            <div style="color:red">${error}</div>
        </form:form>
    </div>
</body>
</html>