<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/admin/list_account.css'/>">
<title>ADMIN</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/admin/main.jsp"%>
		<div class="admin-main-setting">
			<input type="search" class="search-table" id="search-id"
				placeholder="Tìm kiếm tài khoản bằng Username"
				onkeyup="myFunction()">
			<div class="table-wrap">
				<table class="table" id="table-account">
					<tr>
						<th class="table-header">Username</th>
						<th class="table-header">Chi tiết</th>
						<th class="table-header">Trạng thái</th>
					</tr>
					<c:forEach var="tk" items="${ltk}">
						<tr>
							<td class="table-data">${tk.username}</td>
							<td class="table-data"><a href="info_user?username=${tk.username }">Chi tiết</a></td>
							<td class="table-data"><a href="change-status?username=${tk.username}" id="account-status"  class="${tk.trangthai?'Enable':'Disable'}">${tk.trangthai?'Hoạt động':'Bị khóa'}</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value = '/resources/js/admin/search_account_table.js'/>"></script>
</body>
</html>