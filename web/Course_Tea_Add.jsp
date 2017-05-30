<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/30
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新开教学班</title>
</head>
<body>
<a href="Course_Tea_Manage.jsp">返回</a>
<form action="/AddCourseTeacher" method="post">
    <table>
        <tr>
            <td>课程代码</td>
            <td>${course.getC_ID()}<input type="hidden" value="${course.getC_ID()}" name="c_no"></td>
        </tr>
        <tr>
            <td>课程名称</td>
            <td>${course.getC_Name()}</td>
        </tr>
        <tr>
            <td>开设学院</td>
            <td>${course.getC_Depart()}</td>
        </tr>
        <tr>
            <td>开课教师</td>
            <td>
                <select name="teacher">
                    <c:forEach var="t" items="${teacherList.getTeacherList()}" varStatus="status">
                        <option value="${t.getT_ID()}">${t.getT_Name()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>上课地点</td>
            <td>
                <select name="classroom">
                    <c:forEach var="classroom" items="${classroomList}" varStatus="status">
                        <option value="${classroom.getRoom_id()}">${classroom.getBuilding()} ${classroom.getHouse()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>上课时间</td>
            <td>
                <select name="day">
                    <option value="周一">周一</option>
                    <option value="周二">周二</option>
                    <option value="周三">周三</option>
                    <option value="周四">周四</option>
                    <option value="周五">周五</option>
                </select>
            </td>
            <td>
                <select name="time">
                    <option value="1,2节">1,2节</option>
                    <option value="3,4节">3,4节</option>
                    <option value="5,6节">3,4节</option>
                    <option value="7,8节">3,4节</option>
                    <option value="9,10,11节">9,10,11节</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="确认"></td>
        </tr>
    </table>
</form>
</body>
</html>
