<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
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
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Primary Address</th>
                <th>Primary Email</th>
                <th>Status</th>
                <th>Link</th>
            </tr>
            <c:forEach items="${allUser}" var="user" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${user.userID}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.address}</td>
                    <td>${user.email}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.active}">
                                Active
                            </c:when>
                            <c:otherwise>
                                Suspended
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${user.active}">
                                <form method="post" action="/admin/home">
                                    <input name="userID"  type="hidden" value="${user.userID}">
                                    <button type="submit" class="status-button" value="false">Suspend</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form method="post" action="/admin/home">
                                    <input name="userID"  type="hidden" value="${user.userID}">
                                    <button type="submit" class="status-button" value="true">Activate</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
