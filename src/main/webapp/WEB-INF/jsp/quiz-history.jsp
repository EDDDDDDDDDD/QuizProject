<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz History</title>
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
                <th>User Full Name</th>
                <th>Quiz Name</th>
                <th>Date</th>
                <th>Score</th>
                <th>Link</th>
            </tr>
            <c:forEach items="${allQuiz}" var="quiz" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${userFullName[quiz.userID]}</td>
                    <td>${categories[quiz.categoryID-1].name}</td>
                    <td>${quiz.startTime}</td>
                    <td>${quiz.score}</td>
                    <td><a href="/result/${quiz.quizID}">
                        <button>link</button>
                    </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
