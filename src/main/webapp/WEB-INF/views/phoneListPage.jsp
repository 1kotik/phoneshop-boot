<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib prefix="phone" tagdir="/WEB-INF/tags/phone" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<common:page pageTitle="Phone list" showMenu="true">
    <div class="message-container">
        <c:choose>
            <c:when test="${empty errorMessage && phones.content.size() > 0}">
                Found <c:out value="${phones.totalElements}"/> results!
            </c:when>
            <c:otherwise>
                <span class="error-message">
                    ${errorMessage}
                </span>
            </c:otherwise>
        </c:choose>
    </div>
    <phone:plpSearch/>
    <c:if test="${empty errorMessage}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Image</th>
                <th scope="col">Brand <util:sorting currentSort="${currentSort}"
                                                    sortCriteria="brand"
                                                    page="${phones}"
                                                    parameters="${parametersMap}"/>
                </th>
                <th scope="col">Model <util:sorting currentSort="${currentSort}"
                                                    sortCriteria="model"
                                                    page="${phones}"
                                                    parameters="${parametersMap}"/></th>
                <th scope="col">Price <util:sorting currentSort="${currentSort}"
                                                    sortCriteria="price"
                                                    page="${phones}"
                                                    parameters="${parametersMap}"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="phone" items="${phones.content}">
                <phone:tile phone="${phone}"/>
            </c:forEach>
            </tbody>
        </table>
        <util:paginationSection page="${phones}"
                                url="phones"
                                maxPages="${plpMaxPages}"
                                parameters="${parametersMap}"/>
    </c:if>
</common:page>

<script src="js/removeEmptyUrlParameters.js"></script>