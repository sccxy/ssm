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
<title>用户管理模块</title>
</head>
<body>
	${success }
	<a href="/ssm/" style="text-decoration: none" >返回</a>
	<a href="/ssm/page/insertUser.jsp"  style="text-decoration: none" >添加用户</a>
	<center>
        <table width="60%" border="1" cellSpacing="0">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">姓名</th>
            <th scope="col">密码</th>
            <th scope="col">操作</th>
          </tr>
          <c:forEach items="${pageInfo.list}" var="user">
          <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.userPassword}</td>
            <td><a href="showUser?userId=${user.id}&typeId=1" target= _blank style="text-decoration: none">详情</a>
                <a href="deleteUser?userId=${user.id}" style="text-decoration: none">删除</a>
                <a href="showUser?userId=${user.id}&typeId=2" style="text-decoration: none">修改</a>
            </td>
          </tr>
          </c:forEach>
        </table>
        <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }页,总 ${pageInfo.total } 条记录</div></p>
        <a href="showAllUserList?pageNo=${pageInfo.firstPage}">第一页</a>
        <c:if test="${pageInfo.hasPreviousPage }">
            <a href="showAllUserList?pageNo=${pageInfo.pageNum-1}">上一页</a>
        </c:if>
      
        <c:if test="${pageInfo.hasNextPage }">
            <a href="showAllUserList?pageNo=${pageInfo.pageNum+1}">下一页</a>
        </c:if>
        
        <a href="showAllUserList?pageNo=${pageInfo.lastPage}">最后页</a>
    </center>
</body>
</html>