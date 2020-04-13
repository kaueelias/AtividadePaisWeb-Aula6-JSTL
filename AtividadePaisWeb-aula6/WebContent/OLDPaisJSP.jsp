<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Pais" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar País</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <%Pais pais=(Pais)request.getAttribute("Pais"); %>
        <!-- Barra superior com os menus de navegação -->

        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header"> <%=pais.getNome() %> #<%=pais.getId() %></h3>
            <div class="row">
                <div class="col-md-12"style="background-color: #C0C0C0;">
                    <p><strong>Nome do país</strong>
                    </p>
                    <p>
                        <%=pais.getNome() %>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6"style="background-color: #A9A9A9;">
                    <p><strong>População total do país</strong>
                    </p>
                    <p>
                        <%=pais.getPopulacao() %> pessoas
                    </p>
                </div>
                <div class="col-md-6"style="background-color: #808080;">
                    <p><strong>Área total do país</strong>
                    </p>
                    <p>
                        <%=pais.getArea() %> km²
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.html" class="btn btn-primary">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>