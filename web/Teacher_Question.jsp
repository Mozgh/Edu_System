<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/6
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>答疑</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
${message}
<form>

    <table>
        <tr>
            <td>目前有${question0.size()}待回答</td>
        </tr>
        <c:forEach var="q0" items="${question0}" varStatus="status">
            <tr>
                <td><a href="AnswerQuestionPage?t_no=${user.id}&q_no=${q0.getQ_no()}">${q0.getQuestion()}</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
