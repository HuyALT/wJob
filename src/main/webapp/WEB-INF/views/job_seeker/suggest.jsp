<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value = '/resources/css/main.css'/>">
<title>Gợi ý cho bạn</title>
</head>
<body>
	<div class="contain">
    	<%@include file="/WEB-INF/views/job_seeker/header.jsp" %>
		<main>
		<h1 style="text-align: center; padding-top: inherit;">${lbvsuggest.size()>0?'':'Không có việc làm phù hợp với bạn'}</h1>
        <section id="section-list">
            <div class="jobs-list-container">
                <div class="jobs">
                <c:forEach var="bv" items="${lbvsuggest}">
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
            <div class="pagination-row">
                <ul class="pagination pagination-md justify-content-center">
                  </ul>
            </div>
        </section>
		</main>
		<%@include file = "/WEB-INF/views/job_seeker/footter.jsp" %>
		<script type="text/javascript" src="<c:url value = "/resources/js/pagination.js"/>"></script>
    </div>
</body>
</html>