<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bartosz
  Date: 28.10.2019
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recent</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Created</th>
        <th scope="col" Content
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article" varStatus="index">
        <tr>
            <th scope="row">${index.index + 1}</th>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="localhost:8080/articles/recent">Powrót</a>
