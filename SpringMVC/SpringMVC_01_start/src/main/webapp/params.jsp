<%--
  Created by IntelliJ IDEA.
  User: liubin23956
  Date: 2019-10-19
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <%--请求参数绑定 数据封装到Account中    --%>
<%--    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名: <input type="text" name="username" /><br/>--%>
<%--        密码: <input type="text" name="password" /><br/>--%>
<%--        金额: <input type="text" name="money" /><br/>--%>
<%--        用户名称: <input type="text" name="user.uname" /><br/>--%>
<%--        用户年龄: <input type="text" name="user.age" /><br/>--%>
<%--        <input type="submit" value="提交" />--%>
<%--    </form>--%>

    <!-- 数据封装到 Account 类中，类中存在集合 -->
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名: <input type="text" name="username" /><br/>--%>
<%--        密码: <input type="text" name="password" /><br/>--%>
<%--        金额: <input type="text" name="money" /><br/>--%>

<%--        用户名称: <input type="text" name="users[0].uname" /><br/>--%>
<%--        用户年龄: <input type="text" name="users[0].age" /><br/>--%>

<%--        用户名称: <input type="text" name="mapUsers['one'].uname" /><br/>--%>
<%--        用户年龄: <input type="text" name="mapUsers['one'].age" /><br/>--%>
<%--        <input type="submit" value="提交" />--%>
<%--    </form>--%>
    <%--自定义类型转换器--%>
<%--    <form action="param/saveUser" method="post">--%>
<%--        用户名称: <input type="text" name="uname" /><br/>--%>
<%--        用户年龄: <input type="text" name="age" /><br/>--%>
<%--        用户生日: <input type="text" name="date" /><br/>--%>
<%--        <input type="submit" value="提交" />--%>
<%--    </form>--%>
    <a href="param/testServlet" >Servlet原生API</a>
</body>
</html>
