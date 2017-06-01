<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/30
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加课程信息</title>
</head>
<body>
<a href="Course_Manage.jsp">返回</a>
<form action="AddCourse" method="post">
    <h1>新增课程信息</h1>
    <table>
        <tr>
            <td>课程名</td>
            <td><input type="text" name="c_name"></td>
        </tr>
        <tr>
            <td>开课学院</td>
            <td>
                <select name="c_depart">
                    <option value=""></option>
                    <option value="10">能源与动力工程学院</option>
                    <option value="12">光电信息与计算机工程学院</option>
                    <option value="14">机械工程学院</option>
                    <option value="16">管理学院</option>
                    <option value="18">环境与建筑学院</option>
                    <option value="20">外语学院</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>学分</td>
            <td><input type="text" name="c_credit"></td>
        </tr>
        <tr>
            <td>课程简介</td>
            <td><input type="text" name="c_info"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>
</body>
</html>
