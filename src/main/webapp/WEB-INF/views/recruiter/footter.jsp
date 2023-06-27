<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- CSS FILES -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
        
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    
    <link href="https://fonts.googleapis.com/css2?family=Karla:ital,wght@0,300;0,400;0,600;1,300&display=swap" rel="stylesheet">
            
    <link href="<c:url value = "/resources/vendors/bootstrap/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value = "/resources/vendors/bootstrap/bootstrap-icons.css" />" rel="stylesheet">

    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	
	<script src="https://kit.fontawesome.com/37bc1e751f.js" crossorigin="anonymous"></script>

    <link href="<c:url value = "/resources/css/recruiter/footter.css" />" rel="stylesheet">
    <title>Document</title>
</head>
<body>
	<footer class="site-footer">
        <div class="container">
            <div class="row">

                <div class="col-lg-5 col-12 me-auto mb-4">

                    <img src="<c:url value = "/resources/images/hcm.jpg" />" alt="" class="map">
                </div>

                <div class="col-lg-2 col-12 mx-auto my-lg-0 my-4">
                    <h5 class="text-white mb-3">Lĩnh vực</h5>

                    <ul class="footer-menu">
                        <li class="footer-menu-item"><a href="/wJob/recruiter/search?job=Giáo%20dục%20/%20đào%20tạo&position=&formality=" class="footer-menu-link">Giáo dục và Đào tạo</a></li>

                        <li class="footer-menu-item"><a href="/wJob/recruiter/search?job=Nh%C3%A2n%20s%E1%BB%B1&position=&formality=" class="footer-menu-link">Nhân sự</a></li>

                        <li class="footer-menu-item"><a href="/wJob/recruiter/search?job=C%C3%B4ng%20ngh%E1%BB%87%20th%C3%B4ng%20tin&position=&formality=" class="footer-menu-link">Công nghệ thông tin</a></li>

                        <li class="footer-menu-item"><a href="/wJob/recruiter/search?job=X%C3%A2y%20d%E1%BB%B1ng&position=&formality=" class="footer-menu-link">Xây dựng</a></li>
                    </ul>
                </div>

                <div class="col-lg-2 col-12">
                    <h5 class="text-white mb-3">LIỆN HỆ CHÚNG TÔI</h5>

                    <p class="text-white mb-1">97 Man Thiện, P.Hiệp Phú, TP.Thủ Đức, TP.Hồ Chí Minh</p>

                    <p><a href="mailto:email@company.com" class="footer-link">WJOB@gmail.com</a><p>
                </div>

                <div class="site-footer-bottom mt-5">
                    <div class="row pt-4">
                        <div class="col-lg-6 col-12">
                            <p class="copyright-text tooplate-link">Copyright © 2023 WJOB Co., Ltd.
                            <br>Design: <a rel="nofollow" href="https://www.tooplate.com/" target="_blank">DHT</a></p>
                        </div>

                        <div class="col-lg-3 col-12 ms-auto">
                            <ul class="social-icon">
                                <li><a href="#" class="social-icon-link"><i class="fa-brands fa-facebook"></i></a></li>

                                <li><a href="#" class="social-icon-link"><i class="fa-brands fa-twitter"></i></a></li>

                                <li><a href="#" class="social-icon-link"><i class="fa-brands fa-instagram"></i></a></li>

                                <li><a href="#" class="social-icon-link"><i class="fa-brands fa-linkedin"></i></a></li>

                                <li><a href="#" class="social-icon-link"><i class="fa-brands fa-youtube"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </footer>
    <script type="text/javascript" src="<c:url value = "/resources/vendors/jquery/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value = "/resources/vendors/jquery/jquery.backstretch.min.js" />"></script>
    <script type="text/javascript" src="<c:url value = "/resources/vendors/jquery/jquery.twbsPagination.min.js" />"></script>
    <noscript>Your browser does not support JavaScript!</noscript>
</body>
</html>