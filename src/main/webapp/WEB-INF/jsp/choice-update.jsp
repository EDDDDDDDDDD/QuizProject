<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choice Update</title>
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
    <table>
        <tr>Question:</tr>
        <tr>${question.description}</tr>
        <th>Choice ID</th>
        <th>Description</th>
        <th>Correct Choice</th>
<%--        <form method="post" action="choice-update">--%>
<%--            <c:forEach items="${question.choices}" var="choice" varStatus="loop">--%>
<%--                <tr>--%>
<%--                    <td>${choice.choiceID}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <input type="textarea"--%>
<%--                           id="description"--%>
<%--                           name="description"--%>
<%--                           path="choice.description"--%>
<%--                           value="${choice.description}">--%>
<%--                           placeholder="${choice.description}">--%>

<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </form>--%>
        <form:form method="post" action="/admin/choice-update" modelAttribute="updatedChoices">
        <c:forEach items="${updatedChoices.choices}" var="choice" varStatus="loop">
            <tr>
                <td>
                    ${choice.choiceID}
                </td>
                <td>
                    <form:input type="textarea"
                           id="description"
                           name="description"
                           path="choices[${loop.index}].description"
                           value="${choice.description}"
                           placeholder="${choice.description}"
                           class="form-control"/>
                </td>
                <td>
                    <label for="status">Status</label>
                    <c:choose>
                        <c:when test="${choice.correct}">
                            <form:select name="active" id="status"
                                         path="choices[${loop.index}].correct">
                                <option value="true">True</option>
                                <option value="false">False</option>
                            </form:select>
                        </c:when>
                        <c:otherwise>
                            <form:select name="active" id="status"
                                         path="choices[${loop.index}].correct">
                                <option value="false">False</option>
                                <option value="true">True</option>
                            </form:select>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <form:input
                           path="choices[${loop.index}].choiceID"
                           name="choiceID"
                           type="hidden"
                           value="${choice.choiceID}"/>
                    <form:input
                            path="choices[${loop.index}].questionID"
                            name="questionID"
                            type="hidden"
                            value="${choice.questionID}"/>
                </td>
            </tr>
        </c:forEach>
        <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </table>
</body>
</html>
