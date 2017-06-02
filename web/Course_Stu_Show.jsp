<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/2
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>已选课程</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<h1>已选课程</h1>
<form>
    <table>
        <tr>
            <th>课程代码</th>
            <th>课程名称</th>
            <th>授课教师</th>
            <th>上课时间</th>
            <th>上课教室</th>
            <th>开课学院</th>
            <th>学分</th>
        </tr>
        <c:forEach var="course" items="${courseStuList.getCourse_Stu_List()}" varStatus="status">
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
            <td><a href="/DelCourseStu?s_no=${user.id}&c_no=${course.getC_ID()}&t_no=${course.getT_ID()}">退选</a></td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
