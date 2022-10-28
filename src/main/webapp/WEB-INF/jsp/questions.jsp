<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions Update</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
<nav>
    <dic class = "topnav"></dic>
    <ul class = "nav-links">
        <a class = 'active' href="/admin/home">Home</a>
        <a class = 'active' href="/admin/quiz-history">Quiz History</a>
        <a class = 'active' href="/admin/questions">Questions Update</a>
        <a class = 'active' href="/admin/feedback-history">Feedback History</a>
        <a class = 'active' href="/logout">Logout</a>
    </ul>
</nav>
<div class="container">
    <table>
        <tr>
            <th>No.</th>
            <th>Question ID</th>
            <th>Category</th>
            <th>Description</th>
            <th>Status</th>
            <th>Question Update</th>
            <th>Choice Update</th>
        </tr>
        <c:forEach items="${allQuestions}" var="question" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${question.questionID}</td>
                <td>${categoryName[question.categoryID]}</td>
                <td>${question.description}</td>
                <td>${question.active}</td>
                <td>
                    <form method="get" action="/admin/question-update">
                        <input name="questionID"  type="hidden" value="${question.questionID}">
                        <button type="submit" class="question-button">Update</button>
                    </form>
                </td>
                <td>
                    <form method="get" action="/admin/choice-update">
                        <input name="questionID"  type="hidden" value="${question.questionID}">
                        <button type="submit" class="question-button">Update</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
