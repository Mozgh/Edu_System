<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/28
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<form action="AddStudent" method="get">
<table>
    <tr>
        <td>姓名</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>性别</td>
        <td><input type="text" name="sex"></td>
    </tr>
    <tr>
        <td>入学年份</td>
        <td><input type="text" name="age"></td>
    </tr>
    <tr>
        <td>学院</td>
        <td>
            <select name="depart">
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
        <td></td>
        <td><input type="submit" value="确认"></td>
    </tr>
</table>
</form>
</body>
</html>
