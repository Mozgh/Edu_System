<%--
  Created by IntelliJ IDEA.
  User: feir4
  Date: 2017/5/19
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆页面</title>
  </head>
  <body>
    <h1>欢迎使用教务管理系统</h1>
    <form action="Login" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
      </tr>
    </table>
    <input type="radio" value="student" name="identity">学生
    <input type="radio" value="teacher" name="identity">教师
    <input type="radio" value="admin" name="identity">管理员
    </form>
  </body>
</html>
