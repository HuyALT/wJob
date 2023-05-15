<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/job_seeker/user_info.css'/>">
<title>Tài Khoản</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/job_seeker/header.jsp"%>
		<main>
			<div class="container_block">
				<nav class="sidebar">
					<ul>
						<li class="sidebar-item active"><a
							href="/wJob/job_seeker/my-info"> <i class="bx bx-user"></i> <span>
									Hồ sơ của tôi </span>
						</a></li>
						<li class="sidebar-item"><a href="/wJob/job_seeker/account-center">
								<i class="bx bx-cog"></i> <span> Quản lý tài khoản </span>
						</a></li>
						<li class="sidebar-item"><a href="<c:url value = "/j_spring_security_logout"/>"> <i
								class="bx bx-log-out-circle"></i> <span> Đăng xuất </span>
						</a></li>
					</ul>
				</nav>
				<section class="detail-employer">
					<div class="main-title">
						<h5>Hồ sơ của tôi</h5>
					</div>
					<div class="portfolio">
						<div class="user-info">
							<div class="user-name">
								<span>${ho } ${ten }</span>
							</div>
							<form action="changeportfolio" class="fields">
								<div class="input-box">
									<label for="" class="">Trình độ: </label> 
									<select class="level" name="trinhdo">
										<option value="0" ${tdnd==0?'selected':''}>---Trống---</option>
										<c:forEach var="td" items="${ltd}" >
											<option value="${td.id}" ${tdnd == td.id?'selected':''}>${td.noidung}</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-box ">
									<label for="">Chuyên ngành: </label> 
									<select class="major" name="chuyennganh">
										<option value="0" ${cnnd==0?'selected':''}>--Trống--</option>
										<c:forEach var = "cn" items="${lng}">
											<option value="${cn.id}"  ${cnnd==cn.id?'selected':''}>${cn.noidung}</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-box">
									<label for="">Thông tin giới thiệu: </label>
									<textarea rows="10" cols="50" class="level" name="mota">${mota}</textarea>
								</div>
								<span style="color: green;">${message}</span>
								<div class="btn-update">
									<input type="submit" value="Cập nhật">
								</div>
							</form>
						</div>
					</div>
			</div>
			</section>
	</main>
	<%@include file="/WEB-INF/views/job_seeker/footter.jsp"%>
	</div>
</body>
</html>