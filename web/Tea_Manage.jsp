<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/29
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师信息管理</title>
</head>
<body>
${message}
<form action="AddTeacher" method="post"><input type="submit" value="添加教师"></form>
<table>
    <tr>
        <th>教工号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>学院</th>
        <th>职称</th>
    </tr>
    <jsp:useBean id="teacherlist" scope="request" class="com.zgh.Bean.TeacherListBean"/>
    <c:forEach var="teacher" items="${teacherlist.getTeacherList()}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
            <td>${teacher.getT_ID()}</td>
            <td>${teacher.getT_Name()}</td>
            <td>${teacher.getT_Age()}</td>
            <td>${teacher.getT_Depart()}</td>
            <td>${teacher.getT_Prof()}</td>
            <td><form action="EditTeacher" method="post"><input type="hidden" value="${teacher.getT_ID()}" name="t_id"><input type="submit" value="修改"> </form></td>
            <td><form action="/DelTeacher" method="post"><input type="hidden" value="${teacher.getT_ID()}" name="t_id"><input type="submit" value="删除"> </form></td>
        </tr>
    </c:forEach>
</table>
<a href="ManegeHome.jsp">返回</a>
</body>
</html>
