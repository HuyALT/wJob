<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value = '/resources/css/admin/info_user.css'/>">
<title>ADMIN</title>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/views/admin/main.jsp"%>
		<div class="admin-main-setting">
				
				<div class="user-info">
                <div class="user-name"><h4>Thông tin cá nhân</h4></div>
                <form action="" class="fields">
                    <div class="input-box">
                        <label for="" class="sub-title">Họ và tên: </label>
                        <input type="text" class="name" placeholder="" value="${ho} ${ten}" disabled/>
                    </div>
                    <div class="input-box ">
                        <label for="" class="sub-title">CMND: </label> 
                        <input type="text" class="CMND/CCCD" placeholder="" value="${cmnd}" disabled/>
                    </div>
                    <div class="input-box">
                        <label for="" class="sub-title">Email: </label>
                        <input type="email" class="email" placeholder="" value="${email}" disabled/>
                    </div>
                    <div class="input-box">
                        <label for="" class="sub-title">SDT: </label>
                        <input type="text" class="phone-number" placeholder="" value="${sdt }" disabled/>
                    </div>
                    <div class="input-box">
                        <label for="" class="sub-title">Ngày sinh: </label>
                        <input type="text" class="birthday" placeholder="" value="${ngaysinh}" disabled/>
                    </div>
                    <div class="input-box">
                        <label for="" class="sub-title">Địa chỉ: </label>
                        <input style="max-width: 450px; width: 100%;"type="text" class="address" value="${diachi}" disabled/>
                    </div>
                    <div class="input-box">
                        <label for="" class="sub-title">Giới tính: </label>
                        <input type="text" class="phone-number" placeholder="" value="${gioitinh}" disabled/>
                        
                    </div>
                </form>
            </div>
				
			</div>
		</div>
</body>
</html>