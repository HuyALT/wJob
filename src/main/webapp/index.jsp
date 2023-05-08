<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="<c:url value = '/resources/css/index.css'/>">
    <script src="https://kit.fontawesome.com/37bc1e751f.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="nav">
        <img src="<c:url value = '/resources/images/logo.png'/>" alt="" class="nav-logo">
        <div class="nav-button">
            <a href="login" class="nav-button-login">Tham gia ngay</a>
        </div>
    </div>
    <div class="header">
        <img src="<c:url value = '/resources/images/backgroundindex.png'/>" alt="" class="header-img">
        <h2 class="header-title">THAM GIA NGAY ĐỂ CÓ THÊM THÔNG TIN VỀ NHỮNG CÔNG VIỆC CHẤT LƯỢNG</h2>
        <a href="#" class="header-join">Tham gia ngay</a>
    </div>
    <footer>
        <h5 class="footer-title">LIÊN HỆ CHÚNG TÔI</h5>
        <div class="icon-list">
            <i class="fa-brands fa-facebook"></i>
            <i class="fa-brands fa-twitter"></i>
            <i class="fa-brands fa-linkedin"></i>
            <i class="fa-solid fa-envelope"></i>
        </div>
    </footer>
</body>
</html>
