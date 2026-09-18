<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="sortCriteria" required="true" type="java.lang.String" %>
<%@ attribute name="currentSort" required="true" type="org.springframework.data.domain.Sort.Order" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="parameters" required="false" type="java.util.Map" %>

<c:set var="upperArrow" value="&#x25B2;"/>
<c:set var="downArrow" value="&#x25BC;"/>
<c:set var="sortCriteriaMatched" value="${not empty currentSort && sortCriteria == currentSort.property}"/>

<c:url var="sortUrl" value="/phones">
    <c:param name="page" value="${page.number}"/>
    <c:forEach var="parameter" items="${parameters}">
        <c:param name="${parameter.key}" value="${parameter.value}"/>
    </c:forEach>
</c:url>

<c:choose>
    <c:when test="${sortCriteriaMatched && currentSort.direction.name() == 'ASC'}">
        <c:out value="${upperArrow}" escapeXml="false"/>
    </c:when>
    <c:otherwise>
        <a href="${sortUrl}&sort=${sortCriteria},asc">
            <c:out value="${upperArrow}" escapeXml="false"/>
        </a>
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${sortCriteriaMatched && currentSort.direction.name() == 'DESC'}">
        <c:out value="${downArrow}" escapeXml="false"/>
    </c:when>
    <c:otherwise>
        <a href="${sortUrl}&sort=${sortCriteria},desc">
            <c:out value="${downArrow}" escapeXml="false"/>
        </a>
    </c:otherwise>
</c:choose>
