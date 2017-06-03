<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/6/3
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评价教师</title>
</head>
<body>
<jsp:include page="Head.jsp" />

待评价教师：${teacherEvaList.getTeacherEvaluateList().size()}
<form action="ToStudentEvaluate" method="post">
    <table>
        <tr><td>教师姓名</td><td>${teacherEva.getT_name()}<input type="hidden" value="${teacherEva.getT_no()}" name="t_no"></td></tr>
        <tr><td>课程</td><td>${teacherEva.getC_name()}<input type="hidden" value="${teacherEva.getC_no()}" name="c_no"></td></tr>
        <tr>
            <td>评分</td>
            <td>
                <select name="score">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>文字评价</td>
            <td><input type="text" width="100" height="50" name="comment"></td>
        </tr>
        <tr><td><input type="hidden" value="${user.id}" name="s_no"></td><td><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
