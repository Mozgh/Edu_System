<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/30
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息修改</title>
</head>
<body>
<a href="Course_Manage.jsp">返回</a>
<form action="EditCourse" method="post">
<table>
    <tr>
        <td>课程代码</td>
        <td>${edit_course.getC_ID()}<input type="hidden" value="${edit_course.getC_ID()}" name="c_no"></td>
    </tr>
    <tr>
        <td>课程名称</td>
        <td>${edit_course.getC_Name()}</td>
    </tr>
    <tr>
        <td>开设学院</td>
        <td>${edit_course.getC_Depart()}</td>
    </tr>
    <tr>
        <td>课程简介</td>
        <td>${edit_course.getC_Info()}<input type="hidden" value="${edit_course.getC_Info()}" name="info"></td>
        <td><input type="text" name="new_info" style="width: 100px;height: 50px"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="确认"></td>
    </tr>
</table>
</form>
</body>
</html>
