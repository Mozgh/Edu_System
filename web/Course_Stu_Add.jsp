<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/31
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选课</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<h1>选课</h1>
${message}
<table border="1">
    <tr>
        <th style="width: 100px">课程代码</th>
        <th style="width: 100px">课程名称</th>
        <th style="width: 100px">教师姓名</th>
        <th style="width: 100px">上课时间</th>
        <th style="width: 100px">上课地点</th>
        <th style="width: 60px">学分</th>
        <th style="width: 100px">已选人数</th>
    </tr>
    <jsp:useBean id="courseList" scope="request" class="com.zgh.Bean.CourseListBean"/>
    <c:forEach var="course" items="${courseList.getCourse_Tea_List()}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
            <td>${course.getC_ID()}</td>
            <td>${course.getC_Name()}</td>
            <td>${course.getC_Teacher()}</td>
            <td>${course.getC_Time()}</td>
            <td>${course.getC_Room()}</td>
            <td>${course.getC_Credit()}</td>
            <td>已选人数</td>
            <td><a href="/AddCourseStudent?c_no=${course.getC_ID()}&t_no=${course.getT_ID()}&ct_id=${course.getCT_ID()}&c_time=${course.getC_Time()}">选课</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
