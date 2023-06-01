<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: administrador
  Date: 1/6/23
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ESTO FUNCIONA GEI</title>
</head>
<body>
    <h1>GEI</h1>

    <table>
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Características</th>
            <th>Icono</th>
            <th>Mapa</th>
        </tr>
        </thead>

        <tbody>
            <c:forEach var="linea" items="${lineas}">
                <tr>
                    <td>${linea.nombre}</td>
                    <td>${linea.descripcion}</td>
                    <td>${linea.caracteristicas}</td>
                    <td>${linea.icono}</td>
                    <td>${linea.mapa}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

