<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/29
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程信息管理</title>
</head>
<body>
${message}
<a href="/ManageHome.jsp">返回</a>
<a href="Course_Add.jsp">新增课程</a>
<table>
    <tr>
        <th>课程代码</th>
        <th>课程名称</th>
        <th>开课学院</th>
    </tr>
    <jsp:useBean id="courselist" scope="request" class="com.zgh.Bean.CourseListBean" />
    <c:forEach var="course" items="${courselist.getCourse_List()}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
            <td>${course.getC_ID()}</td>
            <td>${course.getC_Name()}</td>
            <td>${course.getC_Depart()}</td>
            <td>
                <a href="/ToCourse_Tea_Manage?c_no=${course.getC_ID()}">查看教学班</a>
            </td>
            <td>
                <a href="/EditCourse?c_no=${course.getC_ID()}">修改课程信息</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
