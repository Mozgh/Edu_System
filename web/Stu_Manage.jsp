<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/25
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息管理</title>
</head>
<body>
<p>当前用户:${user.getId()}</p>
${message}
<form action="/AddStudent" method="post"><input type="submit" value="添加学生"></form>
<table border="1">
    <tr>
        <th></th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年级</th>
        <th>学院</th>
        <th></th>
    </tr>
    <jsp:useBean id="studentlist" scope="request" class="com.zgh.Bean.StudentListBean" />
    <c:forEach var="student" items="${studentlist.getStudentList()}" varStatus="status">

        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
            <td><input type="checkbox" value=${status.count}>${status.count} </td>
            <td>${student.getS_ID()}</td>
            <td>${student.getS_Name()}</td>
            <td>${student.getS_Sex()}</td>
            <td>${student.getS_Age()}</td>
            <td>${student.getS_Depart()}</td>
            <td><form action="EditStudent" method="post"><input type="hidden" value="${student.getS_ID()}" name="s_id"><input type="submit" value="修改"></form></td>
            <td><form action="DelStudent" method="post"> <input type="submit" value="删除"><input type="hidden" value="${student.getS_ID()}" name="s_id"></form></td>
        </tr>
    </c:forEach>

</table>
<a href="ManageHome.jsp">返回</a>
</body>
</html>
