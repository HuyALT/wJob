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
			 <section id="section-filter">
            <div class="bar-search">
                <div class="filter-job">
                    <div class="select-btn">
                        <span id = "txt-job">Chọn ngành nghề</span>
                        <i class="bx bxs-chevron-down"></i>
                    </div>
                    <div class="content">
                        <ul class="options" id="opt-job">
                        <c:forEach var="ng" items="${lng}">
                        	<li>${ng.noidung}</li>
                        </c:forEach>
                            
                        </ul>
                    </div>
                </div>
                <div class="filter-position">
                    <div class="select-btn">
                        <span id = "txt-position">Chọn khu vực</span>
                        <i class="bx bxs-chevron-down"></i>
                    </div>
                    <div class="content">
                        <ul class="options"  id="opt-position">
                            <li>Hà Nội</li>
                            <li>TP.HCM</li>
                        </ul>
                    </div>
                </div>

                <div class="filter-formality-job">
                    <div class="select-btn">
                        <span id = "txt-formality">Chọn hình thức</span>
                        <i class="bx bxs-chevron-down"></i>
                    </div>
                    <div class="content">
                        <ul class="options" id = "opt-formality">
                            <li>Part Time</li>
                            <li>Full Time</li>
                            <li>Theo ca</li>
                        </ul>
                    </div>
                    
                </div>
                <div class="btn-search">
                    <button class="submit-search" onclick="search_active()">
                        Tìm kiếm
                    </button>
                </div>
            </div>
        </section>
        <section id="section-list">
            <div class="jobs-list-container">
                <div class="jobs">
                <c:forEach var="bv" items="${lbv}">
                    <div class="job" onclick="window.location.href='/wJob/recruiter/job_info?id=${bv.id}'">
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
		<%@include file = "/WEB-INF/views/recruiter/footter.jsp" %>
		<script type="text/javascript" src="<c:url value = "/resources/js/custom.js"/>"></script>
		<script type="text/javascript" src="<c:url value = "/resources/js/pagination.js"/>"></script>
    </div>
</body>
</html>