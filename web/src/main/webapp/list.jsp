<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 26.08.2015
  Time: 17:59
  To change this template use File | Settings | File Templates.

  Page list of Users with include pagination and sort
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <script src="js/bootstrap.min.js" type="javascript"></script>
    <title>List page</title>
</head>
<body>

<div class="container">

    <jsp:include page="header.jsp"/>

    <div class="row" id="content">

        <jsp:include page="menu.jsp"/>

        <div class="span9">
            <form action="users" method="get">
                <input name="page" value="${currentPage}" hidden>
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Login</th>
                    <th>E-mail</th>
                    <th>Phone number</th>
                    </thead>
                    <tbody>
                    <tr id="sort">
                        <td>
                            <select id="sortId" name="sortId">
                                <option value="${sortId}" selected></option>
                                <option value="ASC">up</option>
                                <option value="DESC">down</option>
                            </select>
                        </td>
                        <td>
                            <select id="sortName" name="sortName">
                                <option value="${sortName}" selected></option>
                                <option value="ASC">up</option>
                                <option value="DESC">down</option>
                            </select>
                        </td>
                        <td>
                            <select id="sortSurname" name="sortSurname">
                                <option value="${sortSurname}" selected></option>
                                <option value="ASC">up</option>
                                <option value="DESC">down</option>
                            </select>
                        </td>
                        <td>
                            <select id="sortLogin" name="sortLogin">
                                <option value="${sortLogin}" selected></option>
                                <option value="ASC">up</option>
                                <option value="DESC">down</option>
                            </select>
                        </td>
                        <td>
                            <select id="sortMail" name="sortMail">
                                <option value="${sortMail}" selected></option>
                                <option value="ASC">up</option>
                                <option value="DESC">down</option>
                            </select>
                        </td>
                        <td>
                            <select id="sortPhone" name="sortPhone">
                                <option value="${sortPhone}" selected></option>
                                <option value="ASC">up</option>
                                <option value="DESC">down</option>
                            </select>
                        </td>
                    </tr>
                    <c:forEach var="user" items="${requestScope.users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.login}</td>
                            <td>${user.mail}</td>
                            <td>${user.phoneNumber}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button class="btn" type="submit">apply filter</button>
            </form>
        </div>
    </div>

    <jsp:include page="pagination.jsp"/>

    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
