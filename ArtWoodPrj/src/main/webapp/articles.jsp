
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ArtWood.model.Article" %>
<%@ page import="com.ArtWood.dao.ArticleDao" %>

<%
    ArticleDao articleData = new ArticleDao();
    List<Article> articles = articleData.getAllArticles();
    request.setAttribute("BOOKS_LIST", articles);
%>
<!DOCTYPE html>
<!-- Created by CodingLab |www.youtube.com/CodingLabYT-->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title> Responsive Sidebar Menu  | CodingLab </title>
    <link rel="stylesheet" href="style.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <title>CRUD Application</title>

    <style>
        .inner {
            margin: 15px 0;
        }
    </style>
</head>
</head>
<style>
    /* Google Font Link */
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: "Poppins" , sans-serif;
    }
    .sidebar{
        position: fixed;
        left: 0;
        top: 0;
        height: 100%;
        width: 78px;
        background: #11101D;
        padding: 6px 14px;
        z-index: 99;
        transition: all 0.5s ease;
    }
    .sidebar.open{
        width: 250px;
    }
    .sidebar .logo-details{
        height: 60px;
        display: flex;
        align-items: center;
        position: relative;
    }
    .sidebar .logo-details .icon{
        opacity: 0;
        transition: all 0.5s ease;
    }
    .sidebar .logo-details .logo_name{
        color: #fff;
        font-size: 20px;
        font-weight: 600;
        opacity: 0;
        transition: all 0.5s ease;
    }
    .sidebar.open .logo-details .icon,
    .sidebar.open .logo-details .logo_name{
        opacity: 1;
    }
    .sidebar .logo-details #btn{
        position: absolute;
        top: 50%;
        right: 0;
        transform: translateY(-50%);
        font-size: 22px;
        transition: all 0.4s ease;
        font-size: 23px;
        text-align: center;
        cursor: pointer;
        transition: all 0.5s ease;
    }
    .sidebar.open .logo-details #btn{
        text-align: right;
    }
    .sidebar i{
        color: #fff;
        height: 60px;
        min-width: 50px;
        font-size: 28px;
        text-align: center;
        line-height: 60px;
    }
    .sidebar .nav-list{
        margin-top: 20px;
        height: 100%;
    }
    .sidebar li{
        position: relative;
        margin: 8px 0;
        list-style: none;
    }
    .sidebar li .tooltip{
        position: absolute;
        top: -20px;
        left: calc(100% + 15px);
        z-index: 3;
        background: #fff;
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
        padding: 6px 12px;
        border-radius: 4px;
        font-size: 15px;
        font-weight: 400;
        opacity: 0;
        white-space: nowrap;
        pointer-events: none;
        transition: 0s;
    }
    .sidebar li:hover .tooltip{
        opacity: 1;
        pointer-events: auto;
        transition: all 0.4s ease;
        top: 50%;
        transform: translateY(-50%);
    }
    .sidebar.open li .tooltip{
        display: none;
    }
    .sidebar input{
        font-size: 15px;
        color: #FFF;
        font-weight: 400;
        outline: none;
        height: 50px;
        width: 100%;
        width: 50px;
        border: none;
        border-radius: 12px;
        transition: all 0.5s ease;
        background: #1d1b31;
    }
    .sidebar.open input{
        padding: 0 20px 0 50px;
        width: 100%;
    }
    .sidebar .bx-search{
        position: absolute;
        top: 50%;
        left: 0;
        transform: translateY(-50%);
        font-size: 22px;
        background: #1d1b31;
        color: #FFF;
    }
    .sidebar.open .bx-search:hover{
        background: #1d1b31;
        color: #FFF;
    }
    .sidebar .bx-search:hover{
        background: #FFF;
        color: #11101d;
    }
    .sidebar li a{
        display: flex;
        height: 100%;
        width: 100%;
        border-radius: 12px;
        align-items: center;
        text-decoration: none;
        transition: all 0.4s ease;
        background: #11101D;
    }
    .sidebar li a:hover{
        background: #FFF;
    }
    .sidebar li a .links_name{
        color: #fff;
        font-size: 15px;
        font-weight: 400;
        white-space: nowrap;
        opacity: 0;
        pointer-events: none;
        transition: 0.4s;
    }
    .sidebar.open li a .links_name{
        opacity: 1;
        pointer-events: auto;
    }
    .sidebar li a:hover .links_name,
    .sidebar li a:hover i{
        transition: all 0.5s ease;
        color: #11101D;
    }
    .sidebar li i{
        height: 50px;
        line-height: 50px;
        font-size: 18px;
        border-radius: 12px;
    }
    .sidebar li.profile{
        position: fixed;
        height: 60px;
        width: 78px;
        left: 0;
        bottom: -8px;
        padding: 10px 14px;
        background: #1d1b31;
        transition: all 0.5s ease;
        overflow: hidden;
    }
    .sidebar.open li.profile{
        width: 250px;
    }
    .sidebar li .profile-details{
        display: flex;
        align-items: center;
        flex-wrap: nowrap;
    }
    .sidebar li img{
        height: 45px;
        width: 45px;
        object-fit: cover;
        border-radius: 6px;
        margin-right: 10px;
    }
    .sidebar li.profile .name,
    .sidebar li.profile .job{
        font-size: 15px;
        font-weight: 400;
        color: #fff;
        white-space: nowrap;
    }
    .sidebar li.profile .job{
        font-size: 12px;
    }
    .sidebar .profile #log_out{
        position: absolute;
        top: 50%;
        right: 0;
        transform: translateY(-50%);
        background: #1d1b31;
        width: 100%;
        height: 60px;
        line-height: 60px;
        border-radius: 0px;
        transition: all 0.5s ease;
    }
    .sidebar.open .profile #log_out{
        width: 50px;
        background: none;
    }
    .home-section{
        position: relative;
        background: #E4E9F7;
        min-height: 100vh;
        top: 0;
        left: 78px;
        width: calc(100% - 78px);
        transition: all 0.5s ease;
        z-index: 2;
    }
    .sidebar.open ~ .home-section{
        left: 250px;
        width: calc(100% - 250px);
    }
    .home-section .text{
        display: inline-block;
        color: #11101d;
        font-size: 25px;
        font-weight: 500;
        margin: 18px
    }
    @media (max-width: 420px) {
        .sidebar li .tooltip{
            display: none;
        }
    }
</style>
<body>
<div class="sidebar">
    <div class="logo-details">
        <i class='bx bxl-c-plus-plus icon'></i>
        <div class="logo_name">ArtWood</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
        <li>
            <i class='bx bx-search' ></i>
            <input type="text" placeholder="Search...">
            <span class="tooltip">Search</span>
        </li>
        <li>
            <a href="dashboard.jsp">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Dashboard</span>
            </a>
            <span class="tooltip">Dashboard</span>
        </li>
        <li>
            <a href="clients.jsp">
                <i class='bx bx-user' ></i>
                <span class="links_name">Client</span>
            </a>
            <span class="tooltip">Client</span>
        </li>
        <li>
            <a href="articles.jsp">
                <i class='bx bx-pie-chart-alt-2' ></i>
                <span class="links_name">Product</span>
            </a>
            <span class="tooltip">Product</span>
        </li>
        <li>
            <a href="ordre.jsp">
                <i class='bx bx-cart-alt' ></i>
                <span class="links_name">Order</span>
            </a>
            <span class="tooltip">Order</span>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-heart' ></i>
                <span class="links_name">Saved</span>
            </a>
            <span class="tooltip">Saved</span>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-cog' ></i>
                <span class="links_name">Setting</span>
            </a>
            <span class="tooltip">Setting</span>
        </li>
        <li class="profile">
            <div class="profile-details">
                <img src="profile.jpg" alt="profileImg">
                <div class="name_job">
                    <div class="name">Adil</div>
                    <div class="job">Admin</div>
                </div>
            </div>
            <i class='bx bx-log-out' id="log_out" ></i>
        </li>
    </ul>
</div>
<section class="home-section">
    <div class="text">Dashboard</div>



    <div class="container-fluid">
        <nav class="navbar navbar-light">
            <a class="navbar-brand">Gestionnaire du Stock</a>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </nav>
    </div>
    <div class="container">
        <div class="inner">
            <div class="row">
                <div class="col-md-3">
                    <h3>Nouveau Produit</h3>
                    <form action="ArticleServlet" method="post">
                        <input type="hidden" name="action" value="add"> <!-- Add hidden field for action -->
                        <div class="form-group">
                            <label>Nom produit</label> <input class="form-control" name="bkname" placeholder="Nom du produit" required>
                        </div>
                        <div class="form-group">
                            <label>Description</label> <input class="form-control" name="bkdes" placeholder="Description" required>
                        </div>
                        <div class="form-group">
                            <label>prix</label> <input class="form-control" name="prix" placeholder="Prix" required>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="reset" class="btn btn-primary">Reset</button>
                    </form>
                </div>
                <div class="col-md-9">
                    <h3>Book Information From Database</h3>
                    <table class="table">
                        <thead class="bg-light">
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Book Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% for (Article tempArticle : articles) { %>
                        <tr>
                            <td><%= tempArticle.getId() %></td>
                            <td><%= tempArticle.getNom() %></td>
                            <td><%= tempArticle.getDescription() %></td>
                            <td><%= tempArticle.getPrix() %></td>

                            <td>
                                <form id="deleteForm" action="ArticleServlet" method="post">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="bkname" value="<%= tempArticle.getId() %>">
                                    <a href="#" onclick="confirmDelete()">Delete</a>
                                </form>

                                <script>
                                    function confirmDelete() {
                                        if (confirm('Are you sure you want to delete?')) {
                                            document.getElementById('deleteForm').submit();
                                        }
                                    }
                                </script>
                            </td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


</section>
<script>
    let sidebar = document.querySelector(".sidebar");
    let closeBtn = document.querySelector("#btn");
    let searchBtn = document.querySelector(".bx-search");

    closeBtn.addEventListener("click", ()=>{
        sidebar.classList.toggle("open");
        menuBtnChange();//calling the function(optional)
    });

    searchBtn.addEventListener("click", ()=>{ // Sidebar open when you click on the search iocn
        sidebar.classList.toggle("open");
        menuBtnChange(); //calling the function(optional)
    });

    // following are the code to change sidebar button(optional)
    function menuBtnChange() {
        if(sidebar.classList.contains("open")){
            closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
        }else {
            closeBtn.classList.replace("bx-menu-alt-right","bx-menu");//replacing the iocns class
        }
    }
</script>
</body>
</html>