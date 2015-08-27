<%--
  Created by IntelliJ IDEA.
  User: Gormit
  Date: 26.08.2015
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--  Horror pagination (((  --%>

<div class="pagination pagination-centered">

    <ul>
        <c:choose>
            <c:when test="${currentPage le 1}">
                <li class="disabled"><a href="#">First</a></li>
                <li class="disabled"><a href="#">Prev</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="users?page=${currentPage + 1 - currentPage}&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}" >First</a></li>
                <li><a href="users?page=${currentPage - 1}&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}">Prev</a></li>
            </c:otherwise>
        </c:choose>


        <c:choose>
            <c:when test="${currentPage <= 3}">
                <c:forEach var="i" begin="1" end="5">
                    <li><a href="users?page=${i}&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}">${i}</a></li>
                </c:forEach>
            </c:when>
            <c:when test="${currentPage + 2 >= lastPage}">
                <c:forEach var="i" begin="${lastPage - 4}" end="${lastPage}">
                    <li><a href="users?page=${i}&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}">${i}</a></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach var="i" begin="${currentPage - 2}" end="${currentPage + 2}">
                    <li><a href="users?page=${i}&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}">${i}</a></li>
                </c:forEach>
            </c:otherwise>
        </c:choose>


        <c:choose>
            <c:when test="${currentPage eq lastPage}">
                <li class="disabled"><a href="#">Next</a></li>
                <li class="disabled"><a href="#">Last</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="users?page=${currentPage + 1}&&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}">Next</a></li>
                <li><a href="users?page=${lastPage}&sortId=${sortId}&sortName=${sortName}&sortSurname=${sortSurname}&sortLogin=${sortLogin}&sortMail=${sortMail}&sortPhone=${sortPhone}">Last</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
