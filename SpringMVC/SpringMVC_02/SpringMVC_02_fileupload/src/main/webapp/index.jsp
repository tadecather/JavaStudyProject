<%--
  Created by IntelliJ IDEA.
  User: liubin
  Date: 2019/10/28
  Time: 9:41 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>传统文件上传</h3>

    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        选择上传文件：<input type="file" name="upload" /> <br/>
        <input type="submit" value="上传" />
    </form>

    <br/>

    <h3>SpringMVC 文件上传</h3>

    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        选择上传文件：<input type="file" name="upload" /> <br/>
        <input type="submit" value="上传" />
    </form>

    <br/>

    <h3>跨服务器 文件上传</h3>

    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        选择上传文件：<input type="file" name="upload" /> <br/>
        <input type="submit" value="上传" />
    </form>

</body>
</html>
