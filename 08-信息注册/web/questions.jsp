<%@ page import="java.util.List" %>
<%@ page import="com.person.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: XUN~MLF
  Date: 2020/12/21
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table border="1px">
        <tr align="center">
            <td>题目编号</td>
            <td>题目信息</td>
            <td>A选项</td>
            <td>B选项</td>
            <td>C选项</td>
            <td>D选项</td>
            <td>正确答案</td>
            <td colspan="2">删除操作</td>
        </tr>
        <%
            List<Question> list = (List) request.getAttribute("key");
            for(Question question:list) {
        %>
        <tr>
            <td><%=question.getQuestionId()%></td>
            <td><%=question.getTitle()%></td>
            <td><%=question.getOptionA()%></td>
            <td><%=question.getOptionB()%></td>
            <td><%=question.getOptionC()%></td>
            <td><%=question.getOptionD()%></td>
            <td><%=question.getAnswer()%></td>
            <td>
                <a href="/08_web/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a>
            </td>
            <td>
                <a href="/08_web/question/findById?questionId=<%=question.getQuestionId()%>">试题信息</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</center>

</body>
</html>
