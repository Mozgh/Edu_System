<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/4
  Time: 15:52
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
<form action="ToStudent_Question" method="post">
    <table>
        <tr>
            <td>选择老师</td>
            <td>
                <select name="t_no">
                    <option></option>
                    <c:forEach var="teacher" items="${teacherList}" varStatus="status">
                        <option value="${teacher.getT_ID()}">${teacher.getT_Name()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>输入问题</td>
            <td><input type="text" name="question" style="width: 200px;height: 60px"> </td>
        </tr>
        <tr>
            <td><input type="hidden" value="${user.id}" name="s_no"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<table>
    <tr>
        <td>已回答问题</td>
    </tr>
        <c:forEach var="q1" items="${question1}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
            <td><a href="ToQuestion_Page?q_no=${q1.getQ_no()}">${q1.getQuestion()}</a></td>
            </tr>
        </c:forEach>
    <tr><td>未回答问题</td></tr>
        <c:forEach var="q0" items="${question0}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
        <td>${q1.getQuestion}</td>
    </tr>
        </c:forEach>
    <tr>
        <td>历史问题</td>
    </tr>
    <c:forEach var="q2" items="${question2}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
        <td><a href="ToQuestion_Page?q_no=${q2.getQ_no()}">${q2.getQuestion()}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
