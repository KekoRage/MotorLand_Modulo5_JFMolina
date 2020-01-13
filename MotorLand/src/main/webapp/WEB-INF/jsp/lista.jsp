<!-- asignacion de prefijo a la libreria de Spring -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Lista de Motores</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
       <script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script>

    </head>
    <body>
        <div class="hueco" style="height:50px;">
        <div class="mensaje container">
            ${cartel}
        </div> 
        </div>
        <div class="container">
            <div class="row">
                <h1>Lista de Motores</h1>
               
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Modelo/th>
                            <th>Fabricante</th>
                            <th>Potencia</th>
                            <th>Peso</th>
                            <th>Cantidad</th>
                            <th>Optimo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${motores}" var="motores">
                            <tr>
                                <td><c:out value="${motores.modelo}" /></td>
                                <td><c:out value="${motores.fabricante}" /></td>
                                <td><c:out value="${motores.potencia}" /></td>
                                <td><c:out value="${motores.peso}" /></td>
                                <td><c:out value="${motores.cantidad}" /></td>
                                <!-- Etiqueta spring buscada en google para poder un valor u otro segun una condicion -->
                                <td><c:choose><c:when test="${motores.peso/motores.potencia<'10'}">Si</c:when>  <c:otherwise>No</c:otherwise></c:choose> </td>
    
       

                             </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
             <p>
                    <a href="alta.htm" class="btn btn-primary"><i class="fas fa-plus-square"></i> Nuevo</a>
                </p>
        </div>
        <!-- Modal -->
    </body>
</html>
