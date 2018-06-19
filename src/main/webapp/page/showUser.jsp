<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情</title>
<script type="text/javascript" src="/ssm/assets/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="/ssm/assets/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/ssm/showAllUserList" target= _blank style="text-decoration: none">返回</a>
	<table width="60%" border="1"   cellspacing="0">
	<tr><th>ID</th><th>用户名</th><th>密码</th></tr>
	<thead>
	</thead>
	<tbody>
	<tr><td>${user.id }</td><td>${user.userName }</td><td>${user.userPassword }</td></tr>
	</tbody>
	</table>
</body>
</html>