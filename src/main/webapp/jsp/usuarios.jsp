<%-- 
    Document   : usuarios
    Created on : 6/09/2021, 8:44:17 p. m.
    Author     : Grupo 2
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Usuarios</title>    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex"> 
            <div class="card col-sm-4">
                <div class="card-body">
                    <form class="form form-control" action="Controlador?menu=Usuarios" method="POST" >
                        <div class="form-group" >
                            <label>Cedula</label>
                            <c:if test="${usuarioEdit.idUsuario!=0}">
                                <input  type="text" name="txtId" value="${usuarioEdit.idUsuario}" readonly="" 
                                        class="form-control" required="">
                            </c:if>
                            <c:if test="${usuarioEdit.idUsuario==0}">
                                <input  type="text" name="txtId" class="form-control" required="">                                
                            </c:if>
                        </div>
                        <div class="form-group" >
                            <label>Usuario</label>
                            <input  type="text" name="txtNombre" value="${usuarioEdit.nombreUsuario}" 
                                    class="form-control">                            
                        </div>
                        <div class="form-group" >
                            <label>Correo</label>
                            <input  type="text" name="txtCorreo" value="${usuarioEdit.correo}" 
                                    class="form-control" >                            
                        </div>
                        <div class="form-group" >
                            <label>Nombres y apellidos</label>
                            <input  type="text" name="txtNombreC" value="${usuarioEdit.nombreCompleto}" 
                                    class="form-control">                            
                        </div>
                        <div class="form-group" >
                            <label>Clave</label>
                            <input  type="password" name="txtClave" value="${usuarioEdit.clave}" 
                                    class="form-control">                            
                        </div>

                        <div class="form-group" >
                            <label>Tipo Usuario</label>
                            <select class="form-control" name="txtTipo">
                                <c:if test="${empty categorias}">
                                    <option selected="" disabled=" " value="">Por favor Seleccione..</option>
                                    <option value="Administrador">Administrador</option>
                                    <option value="Cliente">Cliente</option>
                                </c:if>
                                <c:forEach items="${categorias}" var="cate">
                                    <option value="${cate}" ${cate == usuarioEdit.tipoUsuario ? 'selected' :''}>
                                        <c:out value="${cate}" />
                                    </option>
                                </c:forEach>
                            </select>
                            <div class="valid-feedback">Campo OK</div>
                            <div class="invalid-feedback">Complete los datos</div>
                        </div>
                        <br/>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary" >
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success" >
                        <input type="submit" name="accion" value="Buscar" class="btn btn-info" >
                        <br/><br/>
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
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CEDULA</th>
                            <th>USUARIO</th>
                            <th>CORREO</th>
                            <th>NOMBRES Y APELLIDOS</th>
                            <th>TIPO USUARIO</th>
                            <th>ACCIONES</th>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${usuarios}">
                            <tr>
                                <td>${e.idUsuario}</td>
                                <td>${e.nombreUsuario}</td>
                                <td>${e.correo}</td>
                                <td>${e.nombreCompleto}</td>
                                <td>${e.tipoUsuario}</td>
                                <td>
                                    <a href="Controlador?menu=Usuarios&accion=Editar&id=${e.idUsuario}" 
                                       class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                                    <a href="Controlador?menu=Usuarios&accion=Eliminar&id=${e.idUsuario}" 
                                       class="btn btn-danger btn-sm"><i class="fa fa-trash-alt"></i></a>
                                    <!-- Modal -->
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>            
    </body>
</html>
