<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
 <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
   <div class="container">
       <div class="row">
           <div class="col-3"></div>
           <div class="col-6">
            
            <form action="/Assigment/admin/login" method="post">
                <div class="card">
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item"><label for="username">Usename</label></li>             
                      <li class="list-group-item"><input class="form-control" type="text" value="${username }" name="username" id="username" required /></li>
                      <c:choose>
                       <c:when test="${!empty username_null}">
                     <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${username_null}" name="error"/>
                     </jsp:include>
                      </c:when>
                      <c:when test="${!empty username_length}">
                     <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${username_length}" name="error"/>
                     </jsp:include>
                      </c:when>
                      <c:when test="${!empty username_exist }">
                       <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${username_exist}" name="error"/>
                     </jsp:include>
                      </c:when>
                      
                  
                      </c:choose>
                      <li class="list-group-item"><label for="passwd">Password</label></li>             
                      <li class="list-group-item"><input class="form-control" type="password" value="${password}" name="passwd" id="passwd" required /></li>
                      <c:choose>
                       <c:when test="${!empty passwd_null}">
                     <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${passwd_null}" name="error"/>
                     </jsp:include>
                      </c:when>
                      <c:when test="${!empty passwd_length}">
                     <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${passwd_length}" name="error"/>
                     </jsp:include>
                      </c:when>
                      <c:when test="${!empty account_exist }">
                       <jsp:include page="/alert/alertdanger.jsp">
                     <jsp:param value="${account_exist}" name="error"/>
                     </jsp:include>
                      </c:when>
                      </c:choose>
                      <li class="list-group-item"><input type="checkbox" name="remember" id="remember" value="remember"> <label for="remember">Remember me ?</label></li>
                      <li class="list-group-item">
                       <input type="submit" value="Đăng nhập" name="login" class="btn btn-success">
                    </li>
                    </ul>
                  </div>
            </form>
           </div>
       </div>
    </div>
 <script src="../js/jquery.min.js"></script>
 <script src="../js/popper.min.js"></script>
 <script src="../js/bootstrap.min.js"></script>
</body>
</html>