<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- CSS FILES -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
        
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    
    <link href="https://fonts.googleapis.com/css2?family=Karla:ital,wght@0,300;0,400;0,600;1,300&display=swap" rel="stylesheet">
            
    <link href="<c:url value = "/resources/vendors/bootstrap/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value = "/resources/vendors/bootstrap/bootstrap-icons.css" />" rel="stylesheet">

    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>


    <link href="<c:url value = "/resources/css/job_seeker/header.css" />" rel="stylesheet">
    <title>Document</title>
</head>
<body>
	 <nav class="navbar fixed-top navbar-expand-lg">
        <div class="container">

            <a href="/wJob/job_seeker" class="navbar-brand">
                <i class="bx bx-planet"></i> WJOB
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href=""></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/wJob/job_seeker/my-info"><i class="bx bxs-user"></i>${username}</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</body>
</html>