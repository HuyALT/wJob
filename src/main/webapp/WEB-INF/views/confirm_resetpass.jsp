<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value = '/resources/css/mailconfirm.css'/>">
<title>Xác nhận</title>
</head>
<body>
		<form action="resetpass" class="form-check-email" method="post">
            <h2>Vui lòng nhập mã xác nhận đã gửi đến Email</h2>
            <h3 style="color: red">Lưu ý: Nếu bạn nhập sai bạn phải thao tác lại từ đầu</h3>
            <input type="text" class="input-text-check-email" placeholder="Mã xác nhận" name="code" required>
            <span id="error">${message}</span>
            <input type="submit" class="button-check-email">
        </form>
</body>
</html>