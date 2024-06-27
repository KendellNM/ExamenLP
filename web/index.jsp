<%-- 
    Document   : index
    Created on : 27 jun. 2024, 14:49:31
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Examen LP</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

    </head>
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }
    </style>
    <body>
        <div class="container-fluid h-100 d-flex justify-content-center align-items-center" style="background-image: url('assets/login/lima.jpg'); background-size: cover; background-position: center; background-repeat: no-repeat; background-attachment: fixed;">
            <div class="row justify-content-center align-items-center">
                <div class="col-auto bg-dark bg-opacity-75 p-5 rounded" style="height: 550px; width: 550px;">
                    <div class="text-center mb-4 d-flex justify-content-center align-items-center ">
                        <img src="assets/login/logo_upeu.png" width="200" class="img-fluid" />
                    </div>
                    <form action="login" method="post">
                        <div> 
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control bg-transparent text-white border-bottom rounded-0 border-secondary" id="usuario" name="username" placeholder="Ingrese su usuario" required autofocus>
                                <label for="usuario" class="text-secondary">Ingrese su usuario</label>
                                <i class="fas fa-user text-white bg-transparent position-absolute top-0 end-0 mt-3 me-3"></i>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control bg-transparent text-white border-bottom rounded-0 border-secondary" id="contrasena" name="clave" placeholder="Ingrese su contraseña" required>
                                <label for="contrasena" class="text-secondary">Ingrese su contraseña</label>
                                <i class="fa fa-eye text-white bg-transparent position-absolute top-0 end-0 mt-3 me-3 hover-cursor-pointer" id="ver_contrasena" onclick="ver_contra()"></i>
                            </div>
                            <div class="d-grid gap-2">
                                <button class="btn btn-primary shadow rounded-pill" type="submit">Iniciar sesión</button>
                            </div>
                        </div>   

                    </form>
                </div>
            </div>
        </div>   
        <script src="assets/js/jquery-3.7.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/login/script.js"></script>
        
        <script>
            
        </script>
    </body>
</html>
