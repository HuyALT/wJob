<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value = '/resources/css/mailconfirm.css'/>">
<title>Quên mật khẩu</title>
</head>
<body>
	<form action="forget_pass_email" class="form-check-email">
            <h2>Vui lòng nhập Email của bạn</h2>
            <input type="email" class="input-text-check-email" placeholder="Email" name="email" required>
            <span id="error">${message}</span>
            <input type="submit" class="button-check-email">
        </form>
</body>
</html>