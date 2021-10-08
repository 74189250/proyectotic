<%-- 
    Document   : vistaArchivo
    Created on : 3/10/2021, 08:03:07 PM
    Author     : Hogar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <c:if test="${mensaje != null}">
                        <div class=" alert alert-success alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Resultado!</strong> ${mensaje}!.
                        </div>
                    </c:if> 
                    <c:if test="${aviso != null}">
                        <div class=" alert alert-danger alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Cuidado!</strong>${aviso}!.
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="col-sm-6">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>PROVEEDOR</th>
                            <th>PRECIO COMPRA</th>
                            <th>IVA</th>
                            <th>PRECIO VENTA</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pro" items="${productos}">
                            <tr>
                                <td>${pro.codigo}</td>
                                <td>${pro.nombre}</td>
                                <td>${pro.nitProveedor}</td>
                                <td>${pro.precioCompra}</td>
                                <td>${pro.iva}</td>
                                <td>${pro.precioVenta}</td>                                       
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="/" class="btn btn-success btn-lg">Regresar al Inicio</a>
                
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>            
    </body>    
</html>
