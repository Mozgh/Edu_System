<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/3
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教学班名单</title>
</head>
<body>
<jsp:include page="Head.jsp" />

<form action="ToTeacher_Stu_List" method="post">
    <table>
        <tr>
            <td>选择教学班</td>
            <td>
                <select name="course">
                    <option value="${c_no}">${c_name}</option>
                    <c:forEach var="course" items="${courseList.getCourse_List()}" varStatus="status">
                        <option value="${course.getC_ID()}">${course.getC_Name()}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="hidden" value="${user.id}" name="t_no">
                <input type="submit" value="查看"></td>
        </tr>
    </table>

</form>

<table border="1">
    <tr>
        <th style="width:80px">学号</th>
        <th style="width:80px">姓名</th>
        <th style="width:80px">年级</th>
        <th style="width:150px">学院</th>
    </tr>
    <c:forEach var="student" items="${studentList.getStudentList()}" varStatus="status">
    <c:if test="${status.count%2==0}">
        <tr style="background: #eeeeff;">
    </c:if>
    <c:if test="${status.count%2==0}">
        <tr style="background: #dedeff;">
    </c:if>
            <td>${student.getS_ID()}</td>
            <td>${student.getS_Name()}</td>
            <td>${student.getS_Age()}</td>
            <td>${student.getS_Depart()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
