<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Update</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
    <ul class = "nav-links">
        <a class = 'active' href="/admin/home">Home</a>
        <a class = 'active' href="/admin/quiz-history">Quiz History</a>
        <a class = 'active' href="/admin/questions">Questions Update</a>
        <a class = 'active' href="/admin/feedback-history">Feedback History</a>
        <a class = 'active' href="/logout">Logout</a>
    </ul>
    <form method="post" action="question-update" mobleAttribute="updatedQuestion">
        <table>
            <div class="form-group">
                <tr>
                    <label for="categoryID">Category</label>
                </tr>
                <input type="text"
                       id="categoryID"
                       name="categoryID"
                       path="updatedQuestion.categoryID"
                       value="${question.categoryID}"
                       placeholder="${question.categoryID}"
                       class="form-control" >
            </div>
            <div class="form-group">
                <tr>
                    <label for="description">Description</label>
                </tr>
                <tr>
                    <label for="description">${question.description}</label>
                </tr>
                <input type="textarea"
                       id="description"
                       name="description"
                       path="updatedQuestion.description"
                       value="${question.description}"
                       placeholder="${question.description}"
                       rows="4" cols="50" class="form-control">
            </div>
            <div class="form-group">
                <tr>
                    <c:choose>
                        <c:when test="${question.active}">
                            <label for="status">Status</label>
                            <select name="active" id="status"
                                    path="updatedQuestion.active">
                                <option value="true">True</option>
                                <option value="false">False</option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <label for="status">Status</label>
                            <select name="active" id="status"
                                    path="updatedQuestion.active">
                                <option value="false">False</option>
                                <option value="true">True</option>
                            </select>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </div>
            <tr>
                <input name="questionID"  type="hidden"
                       path="updatedQuestion.questionID"
                       value="${question.questionID}">
                <button type="submit" class="btn btn-primary">Submit</button>
            </tr>
        </table>
    </form>
</body>
</html>
