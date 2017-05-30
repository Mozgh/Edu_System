<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/25
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理</title>
</head>
<body>
<h1>教务管理系统</h1>
<h2>的管理系统</h2>
当前用户：${user.getId()}
<a href="/Index">退出</a>
<table>
    <tr>
        <td>用户管理</td>
        <td><input type="submit" value="学生用户管理"><a href="Stu_Manage.jsp">学生信息管理</a></td>
        <td><input type="submit" value="教师用户管理"><a href="Tea_Manage.jsp">教师信息管理</a></td>
    </tr>
    <tr>
        <td>课程管理</td>
        <td><input type="submit" value="课程信息管理"><a href="Course_Manage.jsp">课程信息管理</a></td>
        <td><input type="submit" value="教学班管理"><a href="Course_Tea_Manage.jsp">教学班管理</a></td>
    </tr>
    <tr>
        <td>教室信息</td>
        <td><input type="submit" value="添加上课教室"></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="发布公告">
        </td>
    </tr>
</table>
</body>
</html>
