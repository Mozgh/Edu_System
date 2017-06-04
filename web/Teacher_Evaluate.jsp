<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/3
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看评价</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<form action="/ToTeacher_Evaluate" method="post">
    <table>
        <tr>
            <td>选择课程</td>
            <td>
                <select name="course">
                    <option value=""></option>
                    <c:forEach var="course" items="${courseList.getCourse_List()}" varStatus="status">
                        <option value="${course.getC_ID()}">${course.getC_Name()}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="hidden" value="${user.id}" name="t_no"></td>
            <td><input type="submit" value="查看评价"></td>
        </tr>
    </table>

    <table border="1">
        <tr>
            <th></th>
            <th style="width: 60px">评分</th>
            <th>留言</th>
        </tr>
        <c:forEach var="evaluate" items="${teacherEvaList.getTeacherEvaluateList()}" varStatus="status">
            <c:if test="${status.count%2==0}">
                <tr style="background: #eeeeff;">
            </c:if>
            <c:if test="${status.count%2==0}">
                <tr style="background: #dedeff;">
            </c:if>
            <td>${status.count}</td>
            <td style="align-content: center">${evaluate.getScore()}</td>
            <td>${evaluate.getT_comment()}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
