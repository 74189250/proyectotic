<%-- 
    Document   : facturas
    Created on : 7/10/2021, 01:49:26 PM
    Author     : Hogar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Facturación</title>    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
    </head>
    <body>
        <h1 style="text-align: center">Factura de Venta Grupo 28</h1>
        <form method="post" action="Controlador?menu=Ventas">
            <div class="d-flex">
                <div class=" col-sm-5">
                    <div class="card">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>                                
                            </div>                            
                            <div class="form-group d-flex">
                                <div class="col-sm-4">
                                    <input type="text" name="txCedula" class="form-control" placeholder="Cedula del Cliente"> 
                                </div>                                
                                    <div class="col-sm-2">
                                        <button type="submit" name="accion" value="buscarCliente" class="btn btn-outline-success">Consultar</button>                                      
                                    </div>                            
                                    <div class="col-sm-6">
                                        <input type="text" name="txNombreCliente" class="form-control" placeholder="Nombre del Cliente" readonly="">  
                                    </div>                                
                            </div>
                            <div class="form-group">
                                <label>Datos del Producto</label>                                
                            </div>                            
                            <div class="form-group d-flex">

                            </div>
                            <div class="form-group d-flex">

                            </div>
                        </div>

                    </div>

                </div>
                <div class=" col-sm-7">

                </div>

            </div>    
        </form>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>                
    </body>
</html>
