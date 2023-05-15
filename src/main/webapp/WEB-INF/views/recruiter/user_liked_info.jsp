<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/recruiter/user_liked_info.css'/>">
<title>Trang chủ</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/recruiter/header.jsp"%>
		<main>
			<section class="detail-employer">
				<div class="main-title">
					<h5>Hồ sơ</h5>
				</div>
				<div class="portfolio">
					<div class="user-info">
						<div class="user-name">
							<span>${ho} ${ten }</span>
						</div>
						<form class="fields">
							<div class="input-box ">
								<label for="">Giới tính: </label> <input type="text"
									class="major" placeholder="" value="${phai}" />
							</div>
							<div class="input-box">
								<label for="" class="">Trình độ: </label> <input type="text"
									class="level" placeholder="" value="${trinhdo}"
									disabled="disabled" />
							</div>
							<div class="input-box ">
								<label for="">Chuyên ngành: </label> <input type="text"
									class="major" placeholder="" value="${chuyennganh}"
									disabled="disabled" />
							</div>
							<div class="input-box ">
								<label for="">Email: </label> <input type="text" class="major"
									placeholder="" value="${email}" disabled="disabled" />
							</div>
							<div class="input-box ">
								<label for="">Số điện thoại: </label> <input type="text"
									class="major" placeholder="" value="${sdt}" />
							</div>
							<div class="input-box">
								<label for="">Thông tin giới thiệu: </label>
								<textarea rows="10" cols="50" class="level" disabled="disabled">${mota}</textarea>
							</div>
						</form>
					</div>
				</div>
			</section>
		</main>
		<%@include file="/WEB-INF/views/recruiter/footter.jsp"%>
	</div>
</body>
</html>