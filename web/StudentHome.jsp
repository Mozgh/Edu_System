<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/19
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>欢迎使用教务管理系统</h1>
<p>
    学号：${user.id}
    <input type="submit" value="退出">
</p>
<div id="FuncMap">

</div>

<div id="ClassSchedule">
    <table border="1">
        <tr style="height: 10px;width: 40px">
            <th> </th>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednesdays</th>
            <th>Thursday</th>
            <th>Friday</th>
        </tr>
        <tr style="height: 30px;width: 30px">
            <td>第一节</td>
            <td>课程1</td>
            <td>课程2</td>
            <td>课程3</td>
            <td>课程4</td>
            <td>课程5</td>
        </tr>
    </table>
</div>
</body>
</html>
