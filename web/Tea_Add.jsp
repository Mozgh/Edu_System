<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师信息</title>
</head>
<body>
<form action="AddTeacher" method="get">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年龄</td>
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
            <td>职称</td>
            <td>
                <select name="prof">
                    <option value=""></option>
                    <option value="助教">助教</option>
                    <option value="讲师">讲师</option>
                    <option value="副教授">副教授</option>
                    <option value="教授">教授</option>
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
