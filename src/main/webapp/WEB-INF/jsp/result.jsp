<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
    <nav>

        <dic class = "topnav"></dic>
        <c:choose>
            <c:when test="${isAdmin}">
                <ul class = "nav-links">
                    <a class = 'active' href="/admin/home">Home</a>
                    <a class = 'active' href="/admin/quiz-history">Quiz History</a>
                    <a class = 'active' href="/admin/questions">Questions Update</a>
                    <a class = 'active' href="/admin/feedback-history">Feedback History</a>
                    <a class = 'active' href="/logout">Logout</a>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class = "nav-links">
                    <a class = 'active' href="/home">Home</a>
                    <a class = 'active' href="/register">Register</a>
                    <a class = 'active' href="/feedback">Feedback</a>
                    <a class = 'active' href="/contactus">Contact Us</a>
                    <a class = 'active' href="/logout">Logout</a>
                </ul>
            </c:otherwise>
        </c:choose>
    </nav>
    <div class="container">
        <table>
            <tr><td>
                <c:choose>
                    <c:when test="${quizAttributes.get(\"score\") > 3}">
                        Congratulation! ${quizAttributes.get("fullName")} Passed the Quiz!
                    </c:when>
                    <c:otherwise>
                        Sorry! ${quizAttributes.get("fullName")} failed the Quiz!
                    </c:otherwise>
                </c:choose>
            </td></tr>
            <tr><td>Score: ${quizAttributes.get("score")}</td></tr>
            <tr><td>Quiz : ${quizAttributes.get("quizName")}</td></tr>
            <tr><td>User : ${quizAttributes.get("fullName")}</td></tr>
            <tr><td>Quiz Start Time: ${quizAttributes.get("startTime")}</td></tr>
            <tr><td>Quiz End Time: ${quizAttributes.get("endTime")}</td></tr>

            <c:forEach items="${questionsChoice}" var="question" varStatus="loop">
                <tr><td>Q${loop.index+1}.)  ${question.key.description}</td><td> </td></tr>
                <c:forEach items="${question.value}" var="choice">
                    <tr><td>
                        <c:choose>
                            <c:when test="${choice.correct}">
                                <c:choose>
                                    <c:when test="${selectedChoices[loop.index].choiceID == choice.choiceID}">
                                        ${choice.description}   -> This is the correct answer.
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${isAdmin}">
                                                ${choice.description}   (Correct answer)
                                            </c:when>
                                            <c:otherwise>
                                                ${choice.description}
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${selectedChoices[loop.index].choiceID == choice.choiceID}">
                                        ${choice.description}   -> This is the WRONG answer.
                                    </c:when>
                                    <c:otherwise>
                                        ${choice.description}
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td></tr>
                </c:forEach>
            </c:forEach>
        </table>
        <c:choose>
            <c:when test="${isAdmin}">
                <form method="get" action="/admin/quiz-history">
                    <button class="btn btn-primary" type="submit">Back to Admin</button>
                </form>
            </c:when>
            <c:otherwise>
                <form method="get" action="/home">
                    <button class="btn btn-primary" type="submit">Back to Home</button>
                </form>
            </c:otherwise>
        </c:choose>

    </div>
</body>
</html>
