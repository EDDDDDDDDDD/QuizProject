<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
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
            <c:choose>
                <c:when test="${isLogin}">
                    <a class = 'active' href="/logout">Logout</a>
                </c:when>
                <c:otherwise>
                    <a class = 'active' href="/">Login</a>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <div class="container">
        <form method="post" action="feedback">
            <table>
                <div class="form-group">
                    <tr>Star Rating   </tr>
                    <c:forEach varStatus="loop" begin="1" end="5">
                        <tr>
                            <label for="star">${loop.index} </label>
                            <input id="star" name="starRating" path="starRating" type="radio" value="${loop.index}">
                        </tr>
                    </c:forEach>
                </div>
            </table>
                <div class="form-group">
                    <label for="description">Feedback</label>
                    <input class="form-control" id="description" name="description" path="description" type="textarea" rows="4" cols="50">
                </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</body>
</html>
