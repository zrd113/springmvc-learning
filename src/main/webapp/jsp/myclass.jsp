<%--
  Created by IntelliJ IDEA.
  User: 82054
  Date: 2020/12/11
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addclass" method="post">
    <table>
        <tr>
            <td>班级编号：</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>学生编号：</td>
            <td><input type="text" name="students[0].id"></td>
        </tr>
        <tr>
            <td>学生姓名：</td>
            <td><input type="text" name="students[0].name"></td>
        </tr>
        <tr>
            <td>学生编号：</td>
            <td><input type="text" name="students[1].id"></td>
        </tr>
        <tr>
            <td>学生姓名：</td>
            <td><input type="text" name="students[1].name"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
