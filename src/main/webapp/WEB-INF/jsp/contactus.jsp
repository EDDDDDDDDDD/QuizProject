<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
    <nav>
        <dic class = "topnav"></dic>
        <ul class = "nav-links">
            <a class = 'active' href="/home">Home</a>
            <a class = 'active' href="/register">Register</a>
            <a class = 'active' href="/feedback">Feedback</a>
            <a class = 'active' href="contactus">Contact Us</a>
            <a class = 'active' href="/logout">Logout</a>
        </ul>
    </nav>
    <form method="post" action="contactus">
        <table>
            <tr>
                <h4>--- Leave Comment to Us ---</h4>
            </tr>
            <tr>
                <label for="message">Comment</label>
            </tr>
            <tr>
                <input class="form-control" id="message" name="messageBody" path="messageBody" type="textarea" rows="4" cols="50">
            </tr>
            <tr>
                <button type="submit" name="messageBody">Submit</button>
            </tr>
        </table>
    </form>
</body>
</html>
