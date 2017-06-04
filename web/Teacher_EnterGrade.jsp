<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/4
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩录入</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<form action="ToTeacher_Grade" method="post">
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
            <td><input type="submit" value="录入成绩"></td>
        </tr>
    </table>
</form>
<c:if test="${row!=null}">
    成功录入${row}条成绩!
</c:if>
<c:if test="${gradeList!=null}">
<form action="/EnterGrade" method="post">
    <input type="submit" value="保存">
    共有${gradeList.size()}条记录<input type="hidden" value="${gradeList.size()}" name="count">
    <table>
        <tr>
            <th></th>
            <th>学号</th>
            <th>姓名</th>
            <th>课程</th>
            <th>成绩</th>
        </tr>
        <c:forEach var="grade" items="${gradeList}" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff;">
        </c:if>
        <c:if test="${status.count%2==0}">
            <tr style="background: #dedeff;">
        </c:if>
            <td>${status.count}</td>
            <td>${grade.getS_no()}</td>
            <td>${grade.getS_name()}</td>
            <td>${grade.getC_name()}</td>
            <td><input type="text" name="grade${status.count}"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="保存">
</form>
</c:if>
</body>
</html>
