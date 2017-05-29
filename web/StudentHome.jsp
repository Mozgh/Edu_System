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

<p>
    学号：${user.id}
    <input type="submit" value="退出">
</p>

<jsp:include page="Head.jsp"></jsp:include>

<div id="ClassSchedule">
    <table border="1">
        <tr style="height: 10px;width: 40px">
            <th> </th>
            <th>星期一</th>
            <th>星期二</th>
            <th>星期三</th>
            <th>星期四</th>
            <th>星期五</th>
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
