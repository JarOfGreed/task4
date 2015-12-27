<%--
  Created by IntelliJ IDEA.
  User: DiZi
  Date: 24.11.2015
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <head>
        <title></title>
        <link href="webjars/bootstrap/3.3.6/dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="webjars/bootstrap/3.3.6/dist/js/bootstrap.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
        Разделение по ролям запили
        <div>
            ${bundle.getObject("hello")}
        </div>
        <div class="btn btn-primary">
            <a class="btn btn-success" href="create-course.jsp">Create course</a>
        </div>
            <c:if test = ${textA==null}>
                <div>
                    <a href="create-student.jsp">Create student</a>
                    ${textA}
                </div>
            </c:if>
        <div>
            <a href="participiant-list.jsp">Registration on the course</a>
        </div>
            <div>
                <a href="registration.jsp"> Registration </a>
            </div>
        <div>
            <a href="delete-course.jsp"> Delete course</a>
        </div>
        <div>
            <a href="update-course.jsp"> Update course </a>
        </div>
        <div>
            <a href="find-user.jsp"> Find user </a>
        </div>
        <div>
            <a href="update-user.jsp"> Update user</a>
        </div>
        <div>
            <a href="find-by-login.jsp"> Find by login </a>
        </div>
        <div>
            <a href="find-all-courses.jsp"> Показать все курсы </a>
        </div>
        ${createdcourses}
        ${entity}
    </body>
</html>
