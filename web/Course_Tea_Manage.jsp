<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/30
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教学班管理</title>
</head>
<body>
<a href="Course_Manage.jsp">返回</a>
<a href="/AddCourseTeacher?c_no=${c_no}">新开教学班</a>
<table>
    <tr>
        <th>课程代码</th>
        <th>课程名称</th>
        <th>开课学院</th>
        <th>教师</th>
        <th>上课地点</th>
        <th>上课时间</th>
    </tr>
    <jsp:useBean id="courselist" scope="request" class="com.zgh.Bean.CourseListBean" />
    <c:forEach var="course_tea" items="${courselist.getCourse_Tea_List()}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
        <td>${course_tea.getC_ID()}</td>
        <td>${course_tea.getC_Name()}</td>
        <td>${course_tea.getC_Depart()}</td>
        <td>${course_tea.getC_Teacher()}</td>
        <td>${course_tea.getC_Room()}</td>
        <td>${course_tea.getC_Time()}</td>
        <td>
            <form>
                <input type="hidden" value="${course_tea.getC_ID()}" name="c_id">
                <input type="hidden" value="${course_tea.getC_Teacher()}" name="c_teacher">
                <input type="submit" value="查看">
            </form>
        </td>
        <td>
            <form>
                <input type="hidden" value="${course_tea.getC_ID()}" name="c_id">
                <input type="hidden" value="${course_tea.getC_Teacher()}" name="c_teacher">
                <input type="submit" value="删除">
            </form>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
