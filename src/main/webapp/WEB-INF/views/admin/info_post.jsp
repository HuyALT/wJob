<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/admin/info_post.css'/>">
<title>ADMIN</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/admin/main.jsp"%>
		<div class="admin-main-setting">

			<div class="container2">
				<div class="job-detail__container">
					<h4 classs="company-name">${TenCT}</h4>
					<div class="btn-block" style="display: ${btn_block?'flex':'none'}" }>
						<a href="accept?id=${id}" class="btn-accept">Duyệt</a> 
						<a href="deny?id=${id}" class="btn-deny">Từ chối</a>
					</div>

					<hr>
					<h3>${TieuDe}</h3>
					<div class="first-line-detail">
						<span class=""><i class="bx bx-calendar"></i>
						<p>Hạn nộp hồ sơ: ${NgayKetThuc }</p></span> <span class=""><i
							class="bx bx-show"></i>
						<p>Lượt xem: ${LuotXem }</p></span> <span class=""><i class="bx bx-time"></i>
						<p>Đăng ngày: ${NgayBatDau }</p></span>
					</div>
					<div class="row-info">
						<span class="info">
							<p class="title">Yêu cầu kinh nghiệm</p>
							<p class="detail-content">${NamKNYeuCau==0?'Không cần kinh nghiệm':NamKNYeuCau} ${NamKNYeuCau!=0?'Năm':''}</p>
						</span> <span class="info">
							<p class="title">Mức lương</p>
							<p class="detail-content">${Luong }</p>
						</span> <span class="info">
							<p class="title">Hình thức làm việc</p>
							<p class="detail-content">${HinhThuc }</p>
						</span>
					</div>
					<div class="detail-info">
						<h5>Thông tin</h5>
						<div class="group-info">
							<p class="title-info">Nghề nghiệp:</p>
							<p class="info-content">${ViTri }</p>
						</div>
						<div class="group-info">
							<p class="title-info">Số lượng tuyển:</p>
							<p class="info-content">${SLTuyen}</p>
						</div>
						<div class="group-info">
							<p class="title-info">Yêu cầu bằng cấp:</p>
							<p class="info-content">${TrinhDo}</p>
						</div>
						<div class="group-info">
							<p class="title-info">Hạn nộp hồ sơ:</p>
							<p class="info-content">${NgayKetThuc }</p>
						</div>
						<div class="group-info">
							<p class="title-info">Địa điểm:</p>
							<p class="info-content">${DiaChi} ${Khuvuc }</p>
						</div>
					</div>
				</div>
				<div class="desc-container">
					<h5>Mô tả công việc</h5>
					<p class="desc">
						${Mota }
					</p>
				</div>
			</div>

		</div>
	</div>
</body>
</html>