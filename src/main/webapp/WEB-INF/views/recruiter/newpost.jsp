<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="<c:url value = '/resources/css/recruiter/newpost.css'/>">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/login-signup-forget.css">
<title>Login</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/recruiter/header.jsp"%>
		<main>
			<form action="post" class="form-upload-status">
				<input type="text" class="input-field-form" name="tieude"
					placeholder="Tiêu đề" required autocomplete="off"> <input
					type="text" class="input-field-form form-name" name="tenct"
					placeholder="Tên doanh nghiệp" autocomplete="off" required>

				<div class="box-job">
					<p class="job-text">Ngành</p>
					<select name="nganh" id="" >
						<c:forEach var="ng" items="${lng }">
							<option value="${ng.id}">${ng.noidung}</option>
						</c:forEach>
					</select>
				</div>

				<div class="box-form-date">
					<p class="input-date-text">Hạn nộp hồ sơ:</p>
					<input type="date" class="input-field-form form-date" name="date"
						id="datepost" placeholder="" autocomplete="off" required>
				</div>

				<div class="box-form-exp">
					<p class="input-exp-text">Yêu cầu kinh nghiệm:</p>
					<div class="combox-form">
						<select name="namkn" id="namkn-select">
							<option value="0" selected="selected">Không yêu cầu</option>
							<option value="1">1 năm</option>
							<option value="2">2 năm</option>
							<option value="3">3 năm</option>
							<option value="4">4 năm</option>
							<option value="5">5 năm</option>
							<option value="6">6 năm</option>
							<option value="7">7 năm</option>
							<option value="8">8 năm</option>
							<option value="9">9 năm</option>
						</select>
					</div>
				</div>
				<div class="form-wage-type">
					<div class="box-wage">
						<p class="wage-text">Mức lương</p>
						<input type="number" id="quantity" name="luong" min="1" value="0">
					</div>
					<div class="box-type">
						<p class="type-text">Hình thức</p>
						<select name="hinhthuc" id="">
							<option value="Full Time" selected="selected">Fulltime</option>
							<option value="Part Time">Parttime</option>
							<option value="Theo ca">Theo ca</option>
							<option value="Full Time + Part Time">Full Time + Part time</option>
							<option value="Full Time + Part Time + Theo ca">Mọi hình thức</option>
						</select>
					</div>
				</div>
				<input type="text" class="input-field-form form-job"
					placeholder="Ví trí ứng tuyển" name="vitri" autocomplete="off"
					required>
				<div class="box-form-quantity">
					<p class="input-quantity-text">Số lượng:</p>
					<input type="number" id="quantity" name="soluong" min="1" value="1">
				</div>
				<div class="box-branch">
					<p class="branch-text">Trình độ học vấn</p>
					<select name="trinhdo" id="">
						<c:forEach var="td" items="${ltd}">
							<option value="${td.id}">${td.noidung}</option>
						</c:forEach>
					</select>
				</div>
				<div class="box-local">
					<p class="local-text">Khu vực</p>
					<select name="khuvuc" id="">
						<option value="Hà Nội" selected="selected">Hà nội</option>
						<option value="TP.HCM">TP.HCM</option>
					</select>
				</div>

				<div class="box-local-detail">
					<p class="local-detail">Địa chỉ</p>
					<input type="text" value="" name="diachi"
						class="local-detail-input" autocomplete="off" required>
				</div>

				<div class="box-email">
					<p class="text-email">Email liên hệ</p>
					<input type="email" value="${emaillh}" name="email" class="email-input"
						autocomplete="off" required>
				</div>

				<div class="box-phone">
					<p class="text-phone">SĐT liên hệ</p>
					<input type="text" value="${sdtlh}" name="sdt" class="phone-input"
						autocomplete="off" required>
				</div>

				<div class="box-body-text">
					<p class="body-text">Yêu cầu công việc:</p>
					<textarea id="w3review" name="mota" rows="4" cols="70"
						autocomplete="off"></textarea>
				</div>


				<input type="submit" class="button-submit-form" onclick="alert_function()">
			</form>
		</main>
	</div>
	<%@include file="/WEB-INF/views/recruiter/footter.jsp"%>

	<script type="text/javascript"
		src="<c:url value='/resources/js/recruiter/validation.js' />"></script>
		
		<script type="text/javascript" src="<c:url value='/resources/js/recruiter/alert_func.js' />"></script>
</body>
</html>