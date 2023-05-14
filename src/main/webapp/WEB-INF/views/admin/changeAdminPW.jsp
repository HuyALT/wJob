<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/admin/changeAdminPW.css'/>">
<title>ADMIN</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/admin/main.jsp"%>
		<div class="admin-main-setting">
			<form action="changePassword/submit" id="change-password">
				<div class="form-wrap">
					<div class="form-input">
						<h4>Mật khẩu cũ</h4>
						<input type="password" class="old-password" name="old-password"
							required>
					</div>
					<div class="form-input">
						<h4>Mật khẩu mới</h4>
						<input type="password" class="new-password" name="new-password"
							required>
					</div>
					<div class="form-input">
						<h4>Xác nhận mật khẩu</h4>
						<input type="password" class="confirm-password"
							name="confirm-password" required>
					</div>
					<span>${message }</span> <input type="submit" value="Xác nhận" onclick="myfunc()"
						class="form-btn-submit" required>
				</div>

			</form>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value = '/resources/js/admin/funtion_alert.js'/>"></script>
</body>
</html>