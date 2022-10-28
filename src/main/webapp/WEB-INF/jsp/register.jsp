<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
        <form method="post" action="register">
            <div class="form-group">
                <label for="userName">* User Name</label>
                <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name">
            </div>
            <div class="form-group">
                <label for="password">* Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="firstName" class="form-control" id="firstName" name="firstName" placeholder="First Name">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="lastName" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="e-mail">
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="address" class="form-control" id="address" name="address" placeholder="Address">
            </div>
            <div class="form-group">
                <label for="phoneNum">Phone Number</label>
                <input type="phoneNum" class="form-control" id="phoneNum" name="phoneNum" placeholder="Phone Number">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <c:if test="${isNew == false}">
                The username exists. Please change to a new name.
                <br />
            </c:if>
        </form>
    </div>
</body>
</html>
