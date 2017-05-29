<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/28
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>学生信息修改</title>
</head>
<body>
<p>当前修改学生为：${edit_student.getS_Name()}</p>
<p>${message}</p>
<form action="EditStudent" method="get" accept-charset="UTF-8">
    <table>
        <tr>
            <td>学号</td>
            <td>${edit_student.getS_ID()}<input type="hidden" value="${edit_student.getS_ID()}" name="s_id"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${edit_student.getS_Name()}<input type="hidden" value="${edit_student.getS_Name()}" name="name"></td>
            <td>更改姓名：<input type="text" name="new_name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${edit_student.getS_Sex()}</td>
        </tr>
        <tr>
            <td>入学年份</td>
            <td>${edit_student.getS_Age()}</td>
        </tr>
        <tr>
            <td>学院</td>
            <td>${edit_student.getS_Depart()}<input type="hidden" value="${edit_student.getS_Depart()}" name="depart"></td>
            <td>更改学院：
                <select name="new_depart">
                    <option value=""></option>
                    <option value="光电信息与计算机工程学院">光电信息与计算机工程学院</option>
                    <option value="能源与动力工程学院">能源与动力工程学院</option>
                    <option value="机械工程学院">机械工程学院</option>
                    <option value="管理学院">管理学院</option>
                    <option value="环境与建筑学院">环境与建筑学院</option>
                    <option value="外语学院">外语学院</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="确定修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
