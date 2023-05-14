<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value = '/resources/css/recruiter/main.css'/>">
    <title>Trang chủ</title>
</head>
<body>
    <div class="contain">
    	<%@include file="/WEB-INF/views/recruiter/header.jsp" %>
		<main>
        <section id="section-list">
            <div class="jobs-list-container">
                <div class="jobs">
                <c:forEach var="bv" items="${lmybv}">
                    <div class="job">
                        <h2 class="job-title">${bv.tieude}</h2>
                        <a class="company-name">${bv.tenct }</a>
                        <span class="salary"><i class="bx bx-money"></i>${bv.mucluong }</span>
                        <span class="position"><i class="bx bx-map"></i>${bv.khuvuc }</span>
                        <div class="level">Trình độ: ${bv.tdEntity.noidung }</div>
                        <div class="quantity">Số lượng: ${bv.soluong}</div>
                        <div class="date">Hạn nôp hồ sơ: ${bv.ngaykt }</div>
                        <div class="status" style="${bv.ttEntity.id==2?'color: green;':'color: red;'}">${bv.ttEntity.tentt}</div>
                         <a class = "like" href="like-list?id=${bv.id}" style="${bv.ttEntity.id==2?'display: block;':'display: none;'}">Ứng tuyển: 0</a>
                        <a class = "lockpost" href="lock?id=${bv.id}" style="${bv.ttEntity.id==2?'display: block;':'display: none;'}">Nhấn để khóa bài viết</a>
                    </div>
                  </c:forEach>                   
                </div>
            </div>
            <div class="pagination-row">
                <ul class="pagination pagination-md justify-content-center">
                  </ul>
            </div>
            
        </section>
		</main>
		<%@include file = "/WEB-INF/views/recruiter/footter.jsp" %>
		<script type="text/javascript" src="<c:url value = "/resources/js/pagination.js"/>"></script>
    </div>
</body>
</html>