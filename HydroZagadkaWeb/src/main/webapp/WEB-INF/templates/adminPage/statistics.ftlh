<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description"
          content="Project of Web Application which shows water levels for lakes and rivers in Poland.">
    <meta name="author" content="JPPL">

    <title>HydroZagadka</title>
    <link rel="icon" href="../../../HydroZagadkaFront/img/Drop.png">

    <!-- Bootstrap Core CSS -->
    <link href="../../../HydroZagadkaFront/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../../../HydroZagadkaFront/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">
    <link href="../../../HydroZagadkaFront/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet"/>
    <!-- Custom CSS -->
    <link href="../../../HydroZagadkaFront/css/stylish-portfolio.min.css" rel="stylesheet">
</head>

<body id="page-top">
<!-- Navigation -->

<a class="menu-toggle rounded" href="#">
    <i class="fa fa-bars"></i>
</a>

<#include "navBarAdmin.ftlh">

<section id="users">
    <div class="container text-center my-auto">
        <br><br>
        <h3>Statystyki zbiorników:</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nazwa zbiornika</th>
            <th scope="col">Województwo</th>

        </tr>
        </thead>
    <tbody>
    <tr>
        <#if WCList??>
            <#list WCList>
                <#items as  waterContainer>
                <th scope="row">${(user?index)+1}</th>
                <td>${WaterContainer.stationName} </td>
                <td>${WaterContainer.province}</td>
               </tr>
                </#items>
</tbody>
</table>
            </#list></#if>
        <div class="overlay"></div>
</section>


<!-- Footer -->

<#include "../mainPartsOfPage/footer.ftlh">

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
    <i class="fa fa-angle-up"></i>
</a>

<!-- Bootstrap core JavaScript -->
<script src="../../../HydroZagadkaFront/vendor/jquery/jquery.min.js"></script>
<script src="../../../HydroZagadkaFront/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<!-- Plugin JavaScript -->
<script src="../../../HydroZagadkaFront/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="../../../HydroZagadkaFront/js/stylish-portfolio.min.js"></script>
<script src="../../../js/formcreator.js"></script>
</body>

</html>