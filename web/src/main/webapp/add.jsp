<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 26.08.2015
  Time: 18:00
  To change this template use File | Settings | File Templates.

  Form to add CSV file
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <script src="js/bootstrap.min.js" type="javascript"></script>
    <title>Download page</title>
</head>
<body>

<div class="container">

    <jsp:include page="header.jsp"/>

    <div class="row" id="content">

        <jsp:include page="menu.jsp"/>

        <div class="span9">

            <form method="post" action="users" enctype="multipart/form-data">
                <input type="file" name="file" accept="text/csv">
                <input type="submit" value="Отправить">
            </form>

        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div>

