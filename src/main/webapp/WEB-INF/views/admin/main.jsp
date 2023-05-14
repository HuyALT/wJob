<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/admin/common.css'/>">
<title>ADMIN</title>
</head>
<body>
	<div class="contain">
		<div class="contain-header">
			<img src="<c:url value = '/resources/images/Logogif.gif'/>" alt=""
				class="contain-header-logo">

			<div class="contain-header-btn">
				<a href="<c:url value = "/j_spring_security_logout"/>" class="contain-header-logout">Đăng xuất</a>
				<a href="/wJob/admin/changePassword" class="contain-header-changepassword">Đổi mật khẩu</a>
			</div>
		</div>

		<div class="admin-setting">
			<ul class="setting-option-list">
				<li><a class="setting-option" href="/wJob/admin/list_post_wait">Bài viết chờ duyệt</a></li>
				<li><a class="setting-option" href="/wJob/admin/list_post">Tất cả bài viết</a></li>
				<li><a class="setting-option" href="/wJob/admin/list_account">Danh sách tài khoản</a></li>
			</ul>
		</div>
		</div>
</body>
</html>