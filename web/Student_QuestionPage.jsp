<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/6
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问题详情</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<a href="ToStudent_Question?s_no=${user.id}">返回</a>

<table>
    <tr>
        <td>问题</td>
        <td>${question.getQuestion()}</td>
    </tr>
    <tr>
        <td>回答者</td>
        <td>${question.getT_name()}</td>
    </tr>
    <tr>
        <td>问题回答</td>
        <td>${question.getAnswer()}</td>
    </tr>
</table>
</body>
</html>
