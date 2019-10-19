<%--
  Created by IntelliJ IDEA.
  User: liubin23956
  Date: 2019-10-19
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        // 页面加载
        $(function () {
            $("#btn").click(function () {
                // alert("Hello");
                $.ajax({
                    // 编写JSON 格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe", "password":"123", "age":"12"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //服务器端响应的json数据进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">TestString</a>
    <br>
    <a href="user/testVoid">TestVoid</a>

    <br>
    <a href="user/testModelAndView">TestModelAndView</a>
    <br>
    <a href="user/testForwardOrRedirect">TestForwardOrRedirect</a>

    <br/>
    <button id="btn">发送ajax的请求</button>

</body>
</html>
