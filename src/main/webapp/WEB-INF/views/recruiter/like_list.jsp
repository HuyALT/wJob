<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value = '/resources/css/recruiter/list_user.css'/>">
    <title>Danh sách người ứng tuyển</title>
</head>
<body>
    <div class="contain">
    	<%@include file="/WEB-INF/views/recruiter/header.jsp" %>
		<main>
			<div class="table-wrap">
				<table class="table" id="table-post">
					<tr>
						<th class="table-header" style=" background-color: #04AA6D;">Tên người ứng tuyển</th>
						<th class="table-header" style=" background-color: #04AA6D;">Trình độ</th>
						<th class="table-header" style=" background-color: #04AA6D;">Chuyên ngành</th>
						<th class="table-header" style=" background-color: #04AA6D;">Chi tiết</th>
						
					</tr>
					<c:forEach var="qt" items="${lqt}">
						<tr>
						<td class="table-data">${qt.ndEntity.ho} ${qt.ndEntity.ten}</td>
						<td class="table-data">${qt.ndEntity.hsnd.tdEntity==null?'Trống':qt.ndEntity.hsnd.tdEntity.noidung}</td>
						<td class="table-data">${qt.ndEntity.hsnd.nganhEntity==null?'Trống':qt.ndEntity.hsnd.nganhEntity.noidung}</td>
						<td class="table-data"><a href="user_liked_info?id=${qt.ndEntity.id}">Chi tiết</a></td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
		</main>
		<%@include file = "/WEB-INF/views/recruiter/footter.jsp" %>
    </div>
</body>
</html>