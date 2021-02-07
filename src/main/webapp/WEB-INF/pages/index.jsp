<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Planet: vladimirlozickiy
  Date: 2019-08-09
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        .cube {
            float: left;
            width: 150px;
            height: 20px;
        }
    </style>
</head>
<body>
<h4>Content</h4>

<form method="post" action="/pol">
    <input type="submit" value="get">
</form>

<div>${value}</div>

</body>
</html>
