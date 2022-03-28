<%

if(session.getAttribute("admin")==null){
	request.setAttribute("link", "admin");
	request.getRequestDispatcher("/alert/404.jsp").forward(request, response);
	return;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Manager</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <header>
            <img src="../images/bannerAdmin.png" alt="" height="300px">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="false">Home</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link ${active}" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Quản lý admin</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="true">Quản lý nhân viên</button>
                </li>
              </ul>
              <div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<span class="text-danger m-3 h2">Danh sách nhân viên</span><br>
					<table class="table table-bordered table-responsive">
						<thead>
							<th>Mã nv</th>
							<th>Họ tên</th>
							<th>Giới tính</th>
							<th>Địa chỉ</th>
							<th>Năm sinh</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Trạng thái</th>
							<th>Make by</th>
							<th>Ngày tạo</th>
							<th>Password</th>

						</thead>
						<tbody>
							<c:forEach var="item" items="${staff}">
								<tr>
									<td>${item.nhanvienid}</td>
									<td>${item.hoten}</td>
									<td>${item.gioitinh==true?'Nam':'Nữ'}</td>
									<td>${item.diachi}</td>
									<td>${item.namsinh}</td>
									<td>${item.email}</td>
									<td>${item.sdt}</td>
									<td>${item.trangthai}</td>
									<td>${item.admin.adminid}</td>
									<td>${item.ngaytao}</td>
									<td>${item.password}</td>
								</tr>

							</c:forEach>
						</tbody>

					</table>
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<span class="h2 text-danger">Quản lý admin</span> <br>
					<form action="login" method="post">
						<label for="username" class="form-label"> Tài khoản </label> <input
							type="text" name="adminid" id="username" class="form-control">
						<label for="name" class="form-label"> Họ tên </label> <input
							type="text" name="hoten" id="name" class="form-control"> <label
							for="" class="form-label"> Giới tính </label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="gioitinh"
								id="flexRadioDefault1" value="0" checked> <label
								class="form-check-label" for="flexRadioDefault1"> Nam </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="gioitinh"
								id="flexRadioDefault2" value="1"> <label
								class="form-check-label" for="flexRadioDefault2"> Nữ </label>
						</div>
						<label for="diachi" class="form-label"> Địa chỉ </label> <input
							type="text" name="diachi" id="diachi" class="form-control">
						<label for="passwd" class="form-label"> Password </label> <input
							type="password" name="password" id="passwd" class="form-control">
						<button type="submit" class="btn btn-success m-2" value="add" name="btn_add">Thêm</button>
					</form>
					<table class="table table-bordered table-responsive">
						<thead>
							<th>Tài khoản</th>
							<th>Họ tên</th>
							<th>Giới tính</th>
							<th>Địa chỉ</th>
							<th>Password</th>

						</thead>
						<tbody>
						<c:forEach var="item" items="${admin}">
						<tr>
						<td>${item.adminid}</td>
						<td>${item.hoten}</td>
						<td>${item.gioitinh==true?'Nam':'Nữ'}</td>
						<td>${item.diachi}</td>
						<td>${item.password}</td>
						</tr>
						</c:forEach>
						</tbody>

					</table>
				</div>
				<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                    <span class="h2">Quản lý nhân viên</span>
                    <!-- code -->
                </div>
              </div>
              
        </header>
    </div>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
</body>
</html>