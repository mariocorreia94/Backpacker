<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose destination</title>
</head>
<body>
<h1>Bem-vindo ${user.username}</h1>

<h2><div style="color:green">${success}</div></h2>

<div class="newTrip">
    <div class="row">
        <div class="span12">
            <form class="form-horizontal" action="newTrip" method="POST">
                <fieldset>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label">Origem</label>
                        <div class="controls">
                            <input type="text" id="origin" name="origin" placeholder="Origem" class="input-xlarge">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Password-->
                        <label class="control-label">Destino</label>
                        <div class="controls">
                            <input type="text" id="destiny" name="destiny" placeholder="Destino" class="input-xlarge">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Button -->
                        <div class="controls">
                            <button class="btn btn-success">Continuar</button>
                        </div>
                    </div>
                </fieldset>
            </form>
            <div style="color:red">${error}</div>
        </div>
    </div>
</div>

</body>
</html>
