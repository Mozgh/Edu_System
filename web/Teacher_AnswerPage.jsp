<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/6
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回答问题</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<form action="AnswerQuestionPage" method="post">
    <input type="hidden" value="${question.getQ_no()}" name="q_no">
    <table>
        <tr>
            <td>问题描述</td>
            <td>${question.getQuestion()}</td>
        </tr>
        <tr>
            <td>输入回答</td>
            <td><input type="text" name="answer"></td>
        </tr>
        <tr>
            <td><input type="hidden" value="${user.id}" name="t_no"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>