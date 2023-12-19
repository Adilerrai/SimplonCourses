<%--
  Created by IntelliJ IDEA.
  User: sap
  Date: 19/12/2023
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Responsive Sidebar</title>

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            overflow-x: hidden; /* Hide horizontal scrollbar */
        }

        #sidebar {
            background-color: #343a40;
            color: #fff;
            min-height: 100vh;
            transition: all 0.3s;
        }

        #sidebar a {
            color: #fff;
        }

        #sidebar .active {
            background-color: #007bff;
        }

        #content {
            transition: margin-left 0.3s;
            padding: 15px;
        }

        @media (max-width: 768px) {
            #sidebar {
                margin-left: -250px;
            }

            #sidebar.show {
                margin-left: 0;
            }

            #content {
                margin-left: 0;
            }

            #sidebar a {
                display: block;
                text-align: left;
                padding: 10px;
            }

            #sidebar a:hover {
                background-color: #007bff;
            }
        }
    </style>
</head>

<body>

<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-dark text-white" id="sidebar">
        <div class="sidebar-heading">Dashboard</div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"><a href="#" class="nav-link">Dashboard</a></li>
            <li class="list-group-item"><a href="#" class="nav-link">Orders</a></li>
            <li class="list-group-item"><a href="#" class="nav-link">Clients</a></li>
            <li class="list-group-item"><a href="#" class="nav-link">Products</a></li>
        </ul>
    </div>
    <!-- /Sidebar -->

    <!-- Page Content -->
    <div id="content">

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="btn btn-dark" id="menu-toggle">&#9776; Toggle Sidebar</button>
        </nav>

        <div class="container-fluid">
            <!-- Page Content Goes Here -->
            <h2>Welcome to Your Dashboard</h2>
            <!-- Add more content as needed -->
        </div>

    </div>
    <!-- /Page Content -->

</div>
<!-- /Wrapper -->

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- Custom script for sidebar toggle -->
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
        $("#sidebar").toggleClass("show");
    });
</script>

</body>

</html>
