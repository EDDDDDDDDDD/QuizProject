<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
    <nav>
        <dic class = "topnav"></dic>
        <ul class = "nav-links">
            <a class = 'active' href="/home">Home</a>
            <a class = 'active' href="/register">Register</a>
            <a class = 'active' href="/feedback">Feedback</a>
            <a class = 'active' href="contactus">Contact Us</a>
            <a class = 'active' href="/logout">Logout</a>
        </ul>
    </nav>
    <div class="container">
        <table>
            <tr>
                <form method="post" action="home">
                    <h4>--- Choose one of the categories ---</h4>
                    <c:forEach items="${categoryName}" var="entry">
                        <button type="submit" name="categoryID" value="${entry.key}">${entry.value}</button>
                    </c:forEach>
                </form>
            </tr>
            <tr><h6>---------------------------------------</h6></tr>
            <tr>
                <th>No.</th>
                <th>Quiz Name</th>
                <th>Date</th>
                <th>Link</th>
            </tr>
            <c:forEach items="${quizzes}" var="quiz" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${categoryName[quiz.categoryID]}</td>
                    <td>${quiz.startTime}</td>
                    <td>
                        <form method="get" action="result/${quiz.quizID}">
                            <button type="submit" class="quiz-button">Link</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>

</body>
</html>
