<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/recruiter/user_info.css'/>">
<title>Tài Khoản</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/job_seeker/header.jsp"%>
		<main>
			<div class="container_block">
				<nav class="sidebar">
					<ul>
						<li class="sidebar-item"><a href="/wJob/job_seeker/my-info">
								<i class="bx bx-user"></i> <span> Hồ sơ của tôi </span>
						</a></li>
						<li class="sidebar-item active"><a href="/wJob/job_seeker/account-center">
								<i class="bx bx-cog"></i> <span> Quản lý tài khoản </span>
						</a></li>
						<li class="sidebar-item"><a href="<c:url value = "/j_spring_security_logout"/>"> <i
								class="bx bx-log-out-circle"></i> <span> Đăng xuất </span>
						</a></li>
					</ul>
				</nav>
				<section class="detail-employer">
					<div class="main-title">
						<h5>Quản lý tài khoản</h5>
					</div>
					<div class="portfolio">
						<div class="user-info">
							<div class="title">
								<h6>Thay đổi mật khẩu</h6>
							</div>
							<form action="changepassword" id="change-pass"
								class="account-info" method="post">
								<div class="input-box">
									<label for="" class="sub-title">Mật khẩu hiện tại </label> <input
										type="password" class="current-pass" name="old-pass"
										onkeyup="hidden_message()" placeholder="" value="" required />
								</div>
								<div class="input-box ">
									<label for="" class="sub-title">Mật khẩu mới: </label> <input
										type="password" class="new-pass" placeholder=""
										name="new-pass" value="" required />
								</div>
								<div class="input-box">
									<label for="" class="sub-title">Nhập lại mật khẩu: </label> <input
										type="password" class="repeat-pass" name="confirm-pass"
										placeholder="" value="" required />
								</div>
								<span style="color:${success?'green':'red'};"
									id="error-old-pass">${message}</span> <span
									style="color: red; display: none;" id="error-text">Mật
									khẩu xác nhận không chính xác</span>
								<div class="btn-update">
									<input type="submit" value="Cập nhật">
								</div>
							</form>
						</div>
						<div class="user-info">
							<div class="user-name">
								<h6>Thông tin cá nhân</h6>
							</div>
							<form action="changeinfo" class="fields" method="post">
								<div class="input-box">
									<label for="" class="sub-title">Họ</label> <input name="ho"
										type="text" class="name" placeholder="" value="${ho}" required />
								</div>

								<div class="input-box">
									<label for="" class="sub-title">Tên </label> <input name="ten"
										type="text" class="name" placeholder="" value="${ten}"
										required />
								</div>

								<div class="input-box ">
									<label for="" class="sub-title">CMND: </label> <input
										type="text" class="CMND/CCCD" placeholder="" name="cmnd"
										value="${cmnd}" required />
								</div>
								<div class="input-box">
									<label for="" class="sub-title">SDT: </label> <input name="sdt"
										type="text" class="phone-number" placeholder=""
										value="${sdt }" required />
								</div>
								<div class="input-box">
									<label for="" class="sub-title">Ngày sinh: </label> <input
										type="date" class="birthday" placeholder=""
										value="${ngaysinh}" name="ngaysinh" required />
								</div>
								<div class="input-box">
									<label for="" class="sub-title">Địa chỉ: </label> <input
										style="max-width: 450px; width: 100%;" type="text"
										name="diachi" class="address" value="${diachi}" required />
								</div>
								<div class="input-box">
									<label for="" class="sub-title">Giới tính: </label> <select
										name="phai" id="gender">
										<option value="0" ${gioitinh?'selected':'none'}>Nam</option>
										<option value="1" ${gioitinh?'none':'selected'}>Nữ</option>
									</select>
								</div>
								<span style="color: green;">${smessage}</span>
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
		<script type="text/javascript" src="<c:url value = '/resources/js/user_info_validation.js'/>"></script>
	</div>
</body>
</html>