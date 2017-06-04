<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/4
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩查询</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
加权平均绩点：${ave_GPA}
<table>
    <tr>
        <th>课程代码</th>
        <th>课程名称</th>
        <th>学分</th>
        <th>分数</th>
        <th>绩点</th>
    </tr>
    <c:forEach var="grade" items="${gradeList}" varStatus="status">
    <c:if test="${status.count%2==0}">
        <tr style="background: #eeeeff;">
    </c:if>
    <c:if test="${status.count%2==0}">
        <tr style="background: #dedeff;">
    </c:if>
        <td>${grade.getC_no()}</td>
        <td>${grade.getC_name()}</td>
        <td>${grade.getCredit()}</td>
        <td>${grade.getGrade()}</td>
        <td>${grade.getGPA()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
