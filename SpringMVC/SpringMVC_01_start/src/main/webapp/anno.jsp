<%--
  Created by IntelliJ IDEA.
  User: liubin23956
  Date: 2019-10-19
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 常用注解 -->
    <h3>Anno</h3>
    <a href="anno/testRequestParam?name=hehhe">RequestParam</a>

    <form action="anno/testRequestBody" method="post">--%>
                用户名称: <input type="text" name="uname" /><br/>
                用户年龄: <input type="text" name="age" /><br/>
                用户生日: <input type="text" name="date" /><br/>
                <input type="submit" value="提交" />
    </form>

    <br>
    <a href="anno/testPathVariable/10">PathVariable</a>

    <br>
    <a href="anno/testRequestHeader">RequestHeader</a>

    <br>
    <a href="anno/testCookieValue">CookieValue</a>

    <br>
    <form action="anno/testModelAttribute" method="post">
        用户名称: <input type="text" name="uname" /><br/>
        用户年龄: <input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <br>
    <a href="anno/testSessionAttributes">SessionAttributes</a>

    <br>
    <a href="anno/testGetSessionAttributes">GetSessionAttributes</a>
    <br>
    <a href="anno/testDelSessionAttributes">DelSessionAttributes</a>

</body>
</html>
