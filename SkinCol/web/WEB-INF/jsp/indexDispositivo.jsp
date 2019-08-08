<%-- 
    Document   : indexDispositivo
    Created on : 19/07/2019, 03:42:08 PM
    Author     : angel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>SkinCol | Dashboard</title>
  
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
  <link rel="stylesheet" href="css/bootstrap.min.css" />
  <link rel="stylesheet" href="css/mdb.min.css">
  <link rel="stylesheet" href="css/style.min.css">
  <!--<link rel="stylesheet" href="css/estilos.css" />-->
  <link rel="shortcut icon" type="" href="favicon.ico" />
  <!-- DATATABLES-->
  <link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
</head>

<body>
  <header>
    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
      <div class="container-fluid">

        <!-- Brand -->
        <a class="navbar-brand waves-effect" href="index.html" target="_blank">
          <img src="img/Logo Skin Black.png" style="width:150px" alt="">
        </a>
        <!-- Collapse -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

          <!-- Left -->
          <ul class="navbar-nav nav.pills mr-auto">
            <li class="nav-item">
              <a class="nav-link waves-effect" href="#">Usuarios</a>
            </li>
            <li class="nav-item">
              <a class="nav-link waves-effect" href="proveedor.php" >Proveedores</a>
            </li>
            <li class="nav-item">
              <a class="nav-link waves-effect" href="facturainsumos.php">Facturas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link waves-effect" href="#" >Ventas</a>
            </li>
          </ul>

          <!-- Right -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">

             <!-- User Account: style can be found in dropdown.less -->
              <li>
                <div class="btn-group">
                <a href="#" class="btn btn-white" data-toggle="dropdown">
                  <span class="hidden-xs"> 
                    <i class="fas fa-user"> </i> <?php echo $_SESSION["Nombres"] ?> 
                  </span>  
               </a>
               <a href="../ajax/usuario.php?op=salir" class="btn btn danger-color"><h5 class="text-white"><i class="fas fa-power-off"></i></h5></a>
                </div>
              </li>
              <!-- /User Account: style can be found in dropdown.less -->
            </ul>
          </div>
        </div>
      </div>
    </nav>
    <!-- Navbar -->
  </header>

<!--Main layout-->
  <main class="pt-5 mx-lg-5">
    <div class="container-fluid mt-5">

      <!-- Heading -->
      <div class="card mb-4 wow fadeIn">

        <!--Card content-->
        <div class="card-body d-sm-flex justify-content-between">

          <h4 class="mb-2 mb-sm-0 pt-1">
            <a href="index.html" target="_blank">SkinCol</a>
            <span>/</span>
            <span>Dispositivo</span>
          </h4>
        </div>
      </div>
      <!-- Heading -->

      <!--Grid row-->
      <div class="row wow fadeIn">

        <!--Grid column-->
        <div class="col-md-12 mb-4">

          <!--Card-->
          <div class="card">

            <!--Card content-->
            <div class="card-body">

              <!-- Table  -->
              <div class="row justify-content-">
                <div class="col-md-12 ">
                  <a class="btn btn-success" href="agregarDispositivo.htm">
                    <i class="far fa-plus-square"></i> Agregar
                  </a>
                </div>
              </div>
                <!-- Table head -->
                <div id="listadoregistros">
                  <table id="tbllistado" class="table table-striped">
                    <thead class="blue-grey lighten-4">
                      <tr>
                        <th>Modelo</th>
                        <th>Marca</th>
                        <th>Tipo</th>
                        <th>Imagen</th>
                        <th>Opciones</th>
                      </tr>
                    </thead>
                    <c:forEach var="dato" items="${lista}">
                    <tr>
                        <td>${dato.Modelo}</td>
                        <td>${dato.Marca}</td>
                        <td>${dato.Tipo}</td>
                        <td>${dato.Imagen}</td>
                        <td>
                            <a href="editarDispositivo.htm?IdDispositivo=${dato.IdDispositivo}" class="btn btn-warning">Editar</a>
                            <a onclick="return confirm ('Esta seguro?');" href="deleteDispositivo.htm?IdDispositivo=${dato.IdDispositivo}" class="btn btn-danger">Eiminar</a>
                        </td>
                    </tr>
                </c:forEach>
                  </table>
                </div>
                <!-- Table head -->
              <!-- Table  -->

              

            </div>

          </div>
          <!--/.Card-->

        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->

    </div>
  </main>
  <!--Main layout-->
  <!--Footer-->
<footer class="page-footer font-small unique-color-dark pt-4">

<!-- Footer Elementos -->
<div class="container">

  <!-- Llamar a la accion -->
  <ul class="list-unstyled list-inline text-center py-2">
    <li class="list-inline-item">
      <h5 class="mb-1">Regístrate Gratis</h5>
    </li>
    <li class="list-inline-item">
      <a href="#!" class="btn btn-outline-white btn-rounded">Regístrate!</a>
    </li>
  </ul>
  <!-- Llamar a la accion -->

</div>
<!-- Footer Elementos -->

<!-- Copyright -->
<div class="footer-copyright text-center py-3">
  <span>Made in Colombia</span> | © 2019 Copyright: SkinCol
</div>
<!-- Copyright -->

</footer>
<!--/.Footer-->
<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- DATATABLES-->
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
<!-- BOOTBOX-->
<script src="js/bootbox.min.js"></script>
<!-- Initializations -->
<script type="text/javascript">
// Animations initialization
new WOW().init();
</script>
</body>
</html>
