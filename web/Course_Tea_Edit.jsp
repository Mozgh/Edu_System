<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/30
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教学班查看与编辑</title>
</head>
<body>
<a href="Course_Tea_Manage.jsp">返回</a>
${message}
<form action="/EditCourseTeacher" method="post">
    <table>
        <tr>
            <td>课程代码</td>
            <td>${edit_course.getC_ID()}</td>
        </tr>
        <tr>
            <td>课程名称</td>
            <td>${edit_course.getC_Name()}</td>
        </tr>
        <tr>
            <td>授课教师</td>
            <td>${edit_course.getC_Teacher()}</td>
        </tr>
        <tr>
            <td>上课教室</td>
            <td>${edit_course.getC_Room()}<input type="hidden" value="${edit_course.getC_Room()}" name="room"></td>
            <td>
                <select name="new_room">
                    <c:forEach var="classroom" items="${classroomList}" varStatus="status">
                        <option value="${classroom.getRoom_id()}">${classroom.getBuilding()} ${classroom.getHouse()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>上课时间</td>
            <td>${edit_course.getC_Time()}<input type="hidden" value="${edit_course.getC_Time()}" name="old_time"></td>
            <td>
                <select name="day">
                    <option value="周一">周一</option>
                    <option value="周二">周二</option>
                    <option value="周三">周三</option>
                    <option value="周四">周四</option>
                    <option value="周五">周五</option>
                </select>
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
