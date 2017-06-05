<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/25
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div id="head">
    <h1>欢迎使用教务管理系统</h1>
    <c:if test="${user!=null}" scope="session" var="userIsEmpty">
        <p>
            学/工号：${user.id}
            <a href="index.jsp">退出</a>
        </p>
        <c:if test="${user.identity==1}" scope="session" var="userIsEmpty">
        <table>
            <tr style="width: 60px">
                <td style="width: 100px"><a href="StudentHome.jsp">首页</a></td>
                <td style="width: 100px"><a href="Course_Stu_Add.jsp">学生选课</a></td>
                <td style="width: 100px"><a href="ToCourse_Stu_Show?s_no=${user.id}">已选课程</a></td>
                <td style="width: 100px"><a href="ToStudentEvaluate?s_no=${user.id}">教师评价</a></td>
                <td style="width: 100px"><a href="ToStudentSchedule?s_no=${user.id}">查看课表</a></td>
                <td style="width: 100px"><a href="ToStudent_Grade?s_no=${user.id}">成绩查询</a></td>
                <td style="width: 100px"><a href="ToStudent_Question?s_no=${user.id}">答疑</a></td>
            </tr>
        </table>
        </c:if>
        <c:if test="${user.identity==2}" scope="session" var="userIsEmpty">
            <table>
                <tr style="width: 60px">
                    <td style="width: 100px"><a href="TeacherHome.jsp">首页</a></td>
                    <td style="width: 100px"><a href="ToTeacher_Stu_List?t_no=${user.id}">查看名册</a></td>
                    <td style="width: 100px"><a href="ToTeacher_Grade?t_no=${user.id}">成绩录入</a></td>
                    <td style="width: 100px"><a href="ToTeacher_Evaluate?t_no=${user.id}">查看评价</a></td>
                    <td style="width: 100px"><a href="ToTeacher_Question?t_no=${user.id}">答疑</a></td>
                </tr>
            </table>
        </c:if>
    </c:if>
</div>
</body>
</html>
