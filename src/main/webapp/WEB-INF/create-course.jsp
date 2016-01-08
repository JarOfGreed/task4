<%--
  Created by IntelliJ IDEA.
  User: DiZi
  Date: 25.11.2015
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create course</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/servlet" method="post">
            <input type="hidden" name="action" value="create-course">
            <input type="hidden" name="directory" value="index">
            <input type="text" name="name" id="title" placeholder="${bundle.getObject("courseName")}">
            <textarea name="course-description" id="text" cols="30" rows="10" placeholder="${bundle.getObject("courseDescription")}"></textarea>
            <input type="hidden" name="teacher-id" value="${user.getId()}">
            <button type="submit">${bundle.getObject("createcourse")}</button>
        </form>
    </body>
</html>
