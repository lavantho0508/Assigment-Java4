<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
   <div class="container">
       <div class="row">
           <div class="col-3"></div>
           <div class="col-6">
            
            <form action="AdminServlet" method="post">
                <div class="card">
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item"><label for="username">Usename</label></li>             
                      <li class="list-group-item"><input class="form-control" type="text" value="" name="username" id="username" required /></li>
                      <c:choose>
                       
                      <c:when test="${!empty username_length}">
                     <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${username_length}" name="error"/>
                     </jsp:include>
                      </c:when>
                      <c:when test="${!empty username_exist }">${username_exist }</c:when>
                      </c:choose>
                      <li class="list-group-item"><label for="passwd">Password</label></li>             
                      <li class="list-group-item"><input class="form-control" type="password" value="" name="passwd" id="passwd" required /></li>
                      <li class="list-group-item"><input type="checkbox" name="remember" id="remember" value="remember"> <label for="remember">Remember me ?</label></li>
                      <li class="list-group-item">
                        <button class="btn btn-success">Đăng nhập</button>
                        <a href="" class="btn btn-danger">Quên mật khẩu ?</a>
                    </li>
                    </ul>
                  </div>
            </form>
           </div>
       </div>
    </div>
 <script src="js/jquery.min.js"></script>
 <script src="js/popper.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>