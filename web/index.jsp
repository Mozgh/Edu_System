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
  ${message}
  <form action="IndexServlet" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
      </tr>
    </table>
    <input type="radio" value="1" name="identity">学生
    <input type="radio" value="2" name="identity">教师
    <input type="radio" value="0" name="identity">管理员
    <input type="submit" value="登录">
    <input type="submit" value="重置">
  </form>
  </body>
</html>
