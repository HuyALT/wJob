<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value = '/resources/css/register.css'/>">
    <title>Document</title>
</head>
<body>
    <div class="contain">
        <h1 class="contain-header">BỔ SUNG THÔNG TIN CHO TÀI KHOẢN</h1>
        <form action="NewAccount" class="form-register" method="post"> 
            <div class="form-register-ho">
                <label for="" class="form-register-label-ho">Họ:</label>
                <input type="text" name="ho" class="form-register-input-ho" placeholder="Họ" required autocomplete="off">
            </div>

            <div class="form-register-ten">
                <label for="" class="form-register-label-ten">Tên:</label>
                <input type="text" name="ten" class="form-register-input-ten" placeholder="Tên" required autocomplete="off">
            </div>

            <div class="form-register-gioitinh">
                <label for="" class="form-register-label-gioitinh">Giới tính:</label>
                <select name="gioitinh" class="form-register-gioitinh-select">
                    <option value="nam" selected="selected">Nam</option>
                    <option value="nu">Nữ</option>
                </select>
            </div>

            <div class="form-register-ngaysinh">
                <label for="" class="form-register-label-ngaysinh">Ngày sinh:</label>
                <input type="date" name="ngaysinh" class="form-register-input-ngaysinh">
            </div>

            <div class="form-register-sdt">
                <label for="" class="form-register-label-sdt">Số điện thoại:</label>
                <input type="text" name="sdt" maxlength="10" required class="form-register-input-sdt" placeholder="Số điện thoại" autocomplete="off">
            </div>

            <div class="form-register-cmnd">
                <label for="" class="form-register-label-cmnd">CMND/CCCD:</label>
                <input type="text" name="cmnd" maxlength="12" class="form-register-input-cmnd" placeholder="CMND/CCCD" required autocomplete="off">
            </div>

            <div class="form-register-dichi">
                <label for="" class="form-register-label-diachi">Địa chỉ:</label>
                <input type="text" name="diachi" class="form-register-input-diachi" autocomplete="off">
            </div>

            <div class="form-register-email">
                <label for="" class="form-register-label-email">Email:</label>
                <input type="email" name="email" class="form-register-input-email" autocomplete="email">
            </div>

            <div class="form-register-role">
                <label for="" class="form-register-label-role">Bạn là:</label>
                <select name="role" class="form-register-role-select">
                    <option value="0" selected="selected">Nhà tuyển dụng</option>
                    <option value="1">Người tìm việc</option>
                </select>
            </div>

            <input type="submit" value="Xác nhận" class="form-register-submit">

        </form>
    </div>
    
    <script type="text/javascript" src="<c:url value = '/resources/js/validationRegister.js'/>"></script>
</body>
</html>