<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>

<common:page pageTitle="Admin panel" showMenu="false">
    <div class="row mb-3">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <h2>Admin panel page stub</h2>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Avatar</th>
            <th scope="col">Login</th>
            <th scope="col">Role</th>
            <th scope="col">Name</th>
            <th scope="col">Bio</th>
            <th scope="col">Location</th>
            <th scope="col">Company</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users.content}">
            <tr>
                <td>
                    <c:out value="${user.id}" />
                </td>
                <td>
                    <img src="${user.avatarUrl}" alt="avatar" style="height: 40px; width: 40px">
                </td>
                <td>
                    <c:out value="${user.login}" />
                </td>
                <td>
                    <c:out  value="${user.role.name()}" />
                </td>
                <td>
                    <c:out value="${user.name}" />
                </td>
                <td>
                    <c:out value="${user.bio}" />
                </td>
                <td>
                    <c:out value="${user.location}" />
                </td>
                <td>
                    <c:out value="${user.company}" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <util:paginationSection page="${users}"
                            url="admin"
                            maxPages="${plpMaxPages}"/>
</common:page>