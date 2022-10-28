<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <form method="post" action="quiz">
            <table>
                <c:forEach items="${selectedQuestions}" var="question" varStatus="loop">
                    <tr><td>Q${loop.index+1}.)  ${question.description}</td></tr>
                        <c:forEach items="${questionsChoice.get(question.questionID)}" var="choice">
                            <tr><td>
                                <input type="radio" id="${choice.choiceID}" name="${question.questionID}" value="${choice.choiceID}">
                                <label for="${choice.choiceID}">${choice.description}</label>
                            </td></tr>
                        </c:forEach>
                </c:forEach>
            </table>
            <button class="btn btn-primary" type="submit">submit</button>
        </form>
    </div>
</body>
</html>
