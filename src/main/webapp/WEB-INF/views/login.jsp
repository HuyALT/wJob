<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <link rel="stylesheet" href="<c:url value = '/resources/css/login.css'/>">
    <script src="https://kit.fontawesome.com/37bc1e751f.js" crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body onload="ready_load()">
  
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
            <form action="<c:url value='j_spring_security_login' />" class="form-login" id="login" method="post">
            <input type="text" name = "username"  class="input-field" placeholder="Tên Đăng nhập" required autocomplete="off" pattern="[a-zA-Z0-9]{5,}" title="Tên Đăng nhập phải lớn hơn 4 kí tự và không chứa kí tự đặc biệt">
            <input type="password" name = "password"  class="input-field" placeholder="Mật khẩu" required autocomplete="off">
             <span id = "incorect" style="color: red; display: block">${message}</span>
            <a href="forget_password" class="forgot_password">Quên mật khẩu</a>
            <button type="submit" class="submit-btn">Đăng nhập</button>
            
            </form>
            <form action="mailconfirm" class="form-login" id="register" method="post">
                <input type="text" name="username" class="input-field" placeholder="Tên đăng nhập" required autocomplete="off"  pattern="[a-zA-Z0-9]{5,}" title="Tên Đăng nhập phải lớn hơn 4 kí tự và không chứa kí tự đặc biệt">
                <input type="password" name="password-reg" class="input-field" placeholder="Mật khẩu" required autocomplete="off" >
                <input type="password" name="confirmpassword" class="input-field" placeholder="Nhập lại mật khẩu" autocomplete="off" required>
                <input type="email" name="email" class="input-field" placeholder="Email" autocomplete="off" required>
                <span id="error-text" style="color: red; display: none;">Mật khẩu nhập lại không chính xác</span>
                <span id="error-username" style="color: red; display: block;">${error_username}</span>
                <button type="submit" class="submit-btn" id = "btn-dangki" >Đăng ký</button>
            </form>
        </div>
    </div>
    <script src="<c:url value = '/resources/js/login.js'/>"></script>
    <script type="text/javascript" src="<c:url value = '/resources/js/validationLogin.js'/>"></script>
</body>
</html>