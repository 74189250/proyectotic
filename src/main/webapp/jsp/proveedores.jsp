<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Clientes</title>    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
    </head>
    <body>
        <h1>Proveedores!</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form class="form form-control" action="Controlador?menu=Proveedores" method="POST">
                        <div class="form-group" >
                            <label>Nit</label>
                            <c:if test="${proveedorEdit.nit != 0}">
                                <input  type="text" name="txtCedula" value="${proveedorEdit.nit}" readonly="" 
                                        class="form-control" required="">
                            </c:if>
                            <c:if test="${proveedorEdit.nit == 0}">
                                <input  type="text" name="txtCedula" class="form-control" required="">                                
                            </c:if>
                        </div>
                        <div class="form-group" >
                            <label>Nombre Proveedor</label>
                            <input  type="text" name="txtNombre" value="${proveedorEdit.nombreproveedor}" 
                                    class="form-control" >                            
                        </div>           
                        <div class="form-group" >
                            <label>Direccion</label>
                            <input  type="text" name="txtDireccion" value="${proveedorEdit.direccion}" 
                                    class="form-control">                            
                        </div>
                        <div class="form-group" >
                            <label>Teléfono</label>
                            <input  type="text" name="txtTelefono" value="${proveedorEdit.telefono}" 
                                    class="form-control">                           
                        </div>
                        <div class="form-group" >
                            <label>Ciudad</label>
                            <input  type="text" name="txtCorreo" value="${proveedorEdit.ciudad}" 
                                    class="form-control">                            
                        </div>
                        <br/>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" >
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
                                <th>NOMBRE PROVEEDOR</th>
                                <th>DIRECCION</th>
                                <th>TELEFONO</th>                    
                                <th>CIUDAD</th>
                                <th>ACCIONES</th>
                        </thead>

                        <tbody>
                            <c:forEach var="prov" items="${proveedores}">
                                <tr>
                                    <td>${prov.nit}</td>
                                    <td>${prov.nombreproveedor}</td>
                                    <td>${prov.direccion}</td>
                                    <td>${prov.telefono}</td>                               
                                    <td>${prov.ciudad}</td>
                                    <td>
                                        <a href="Controlador?menu=Proveedores&accion=Editar&id=${prov.nit}" 
                                           class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                                        <a href="Controlador?menu=Proveedores&accion=Eliminar&id=${prov.nit}" 
                                           class="btn btn-danger btn-sm"><i class="fa fa-trash-alt"></i></a>


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
