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
        当前用户：${user.getId()}<input type="submit" value="退出">
        <table>
            <tr>
                <td><a>返回首页</a></td>
                <td><a>学生选课</a></td>
                <td><a>教师评价</a></td>
                <td><a>查看课表</a></td>
                <td><a>成绩查询</a></td>
                <td><a>答疑功能</a></td>
            </tr>
        </table>
    </c:if>

</div>
</body>
</html>
