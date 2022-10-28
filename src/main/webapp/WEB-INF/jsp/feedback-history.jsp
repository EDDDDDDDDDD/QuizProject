<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback History</title>
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
                <th>Feedback ID</th>
                <th>Description</th>
                <th>Star Rating</th>
            </tr>
            <c:forEach items="${feedbacks}" var="feedback" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${feedback.feedbackID}</td>
                    <td>${feedback.description}</td>
                    <td>${feedback.starRating}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
