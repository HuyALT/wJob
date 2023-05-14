<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/admin/list_post_wait.css'/>">
<title>ADMIN</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/admin/main.jsp"%>
		<div class="admin-main-setting">
			<div class="table-wrap">
				<table class="table" id="table-post">
					<tr>
						<th class="table-header">ID</th>
						
						<th class="table-header">Tên đơn vị</th>
						<th class="table-header">Tên User</th>
						<th class="table-header">Chi tiết</th>
					</tr>
					<c:forEach var="bv" items="${lbv}">
						<tr>
						<td class="table-data">${bv.id}</td>
						<td class="table-data">${bv.tenct }</td>
						<td class="table-data">${bv.ndEntity.tknd.username}</td>
						<td class="table-data"><a href="list_post_wait/info?id=${bv.id}">Chi tiết</a></td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
	</div>
	</div>
</body>
</html>