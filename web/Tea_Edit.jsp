<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/29
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息修改</title>
</head>
<body>
<p>当前修改教师为：${edit_teacher.getT_Name()}</p>
<p>${message}</p>
<form action="EditTeacher" method="get" accept-charset="UTF-8">
    <table>
        <tr>
            <td>教工号</td>
            <td>${edit_teacher.getT_ID()}<input type="hidden" value="${edit_teacher.getT_ID()}" name="t_id"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${edit_teacher.getT_Name()}<input type="hidden" value="${edit_teacher.getT_Name()}" name="name"></td>
            <td>更改姓名：<input type="text" name="new_name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${edit_teacher.getT_Age()}</td>
        </tr>
        <tr>
            <td>学院</td>
            <td>${edit_teacher.getT_Depart()}<input type="hidden" value="${edit_teacher.getT_Depart()}" name="depart"></td>
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
            <td>职称</td>
            <td>${edit_teacher.getT_Prof()}<input type="hidden" value="${edit_teacher.getT_Prof()}" name="prof"></td>
            <td>
                <select name="new_prof">
                    <option value="助教">助教</option>
                    <option value="讲师">讲师</option>
                    <option value="副教授">副教授</option>
                    <option value="教授">教授</option>
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
