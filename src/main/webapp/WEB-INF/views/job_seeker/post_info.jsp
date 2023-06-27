<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/post_info.css'/>">
<link rel="stylesheet" href="<c:url value = '/resources/css/main.css'/>">
<title>Trang Chủ</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/job_seeker/header.jsp"%>
		<main>
			<div class="container2">
				<div class="job-detail__container">
					<h4 classs="company-name">${TenCT}</h4>
					<hr>
					<h3>${TieuDe}</h3>
					<div class="first-line-detail">
						<span class=""><i class="bx bx-calendar"></i>
							<p>Hạn nộp hồ sơ: ${NgayKetThuc }</p></span> <span class=""><i
							class="bx bx-show"></i>
							<p>Lượt xem: ${LuotXem }</p></span> <span class=""><i
							class="bx bx-time"></i>
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
							<p class="info-content">${DiaChi}${Khuvuc }</p>
						</div>
						<div class="group-info">
							<p class="title-info">Email liên hệ:</p>
							<a class="info-content" href="mailto:${email }">${email }</a>
						</div>
						<div class="group-info">
							<p class="title-info">SDT liên hệ:</p>
							<p class="info-content" >${sdt}</p>
						</div>
					</div>
					<div class="btn-submit">
                        <button onclick="window.location.href='/wJob/job_seeker/like?id=${idbv}';alert('Ứng tuyển thành công');" ${islike?'':'disabled'}>${text}</button>
                    </div>
				</div>
				<div class="desc-container">
					<h5>Mô tả công việc</h5>
					<p class="desc">${Mota }</p>
				</div>
			</div>
			<h3 style="text-align: center;" >Các công việc khác có liên quan</h3>
			<section id="section-list">
            <div class="jobs-list-container">
                <div class="jobs">
                <c:forEach var="bv" items="${lbvt3}">
                    <div class="job" onclick="window.location.href='/wJob/job_seeker/job_info?id=${bv.id}'">
                        <h2 class="job-title">${bv.tieude}</h2>
                        <a class="company-name">${bv.tenct }</a>
                        <span class="salary"><i class="bx bx-money"></i>${bv.mucluong }</span>
                        <span class="position"><i class="bx bx-map"></i>${bv.khuvuc }</span>
                        <div class="level">Trình độ: ${bv.tdEntity.noidung }</div>
                        <div class="quantity">Số lượng: ${bv.soluong}</div>
                        <div class="date">Hạn nôp hồ sơ: ${bv.ngaykt }</div>
                    </div>
                  </c:forEach>                   
                </div>
            </div>
            </section>
	</div>
	</main>
	<%@include file="/WEB-INF/views/recruiter/footter.jsp"%>
	</div>
</body>
</html>