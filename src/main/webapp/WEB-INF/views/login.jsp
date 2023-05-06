<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="<c:url value = '/resources/css/Login.css'/>">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"><link rel="stylesheet" href="assets/css/login-signup-forget.css">
    <title>Login</title>
</head>
<body>
    
    <div class="contain">
        <div class="contain-form">
            <div class="button-box">
                <div id="btn"></div>
                <button type="button" class="toggle-btn" onclick="login()">Đăng nhập</button>
                <button type="button" class="toggle-btn" onclick="register()">Đăng ký</button>
            </div>
            <div class="social-icons">
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-envelope-o" aria-hidden="true"></i></a>
            </div>
            <form action="" class="form-login" id="login">
            <input type="text" class="input-field" placeholder="Tên Đăng nhập" required>
            <input type="text" class="input-field" placeholder="Mật khẩu" required>
            <input type="checkbox" class="check-box"><span>Nhớ mật khẩu</span>
            <a href="" class="forgot_password">Quên mật khẩu</a>
            <button type="submit" class="submit-btn">Đăng nhập</button>
            
            </form>
            <form action="" class="form-login" id="register">
                <input type="text" class="input-field" placeholder="Tên đăng nhập" required>
                <input type="text" class="input-field" placeholder="Mật khẩu" required>
                <input type="text" class="input-field" placeholder="Nhập lại mật khẩu" required>
                
                <button type="submit" class="submit-btn">Đăng ký</button>
            </form>
        </div>
    </div>
    <script>
        var x = document.getElementById("login")
        var y = document.getElementById("register")
        var z = document.getElementById("btn")

        function register() {
            x.style.left = "-400px";
            y.style.left = "50px";
            z.style.left = "110px";
        }

        function login() {
            x.style.left = "50px";
            y.style.left = "450px";
            z.style.left = "0";
        }
    </script>
</body>
</html>