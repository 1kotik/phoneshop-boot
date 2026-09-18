<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="pageNumber" required="true" type="java.lang.Integer" %>
<%@ attribute name="pageSymbol" required="true" type="java.lang.String" %>
<%@ attribute name="url" required="true" type="java.lang.String" %>
<%@ attribute name="active" required="true" type="java.lang.Boolean" %>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean" %>
<%@ attribute name="parameters" required="false" type="java.util.Map" %>


<c:url var="url" value="${url}">
    <c:param name="page" value="${pageNumber}"/>
    <c:forEach var="parameter" items="${parameters}">
        <c:param name="${parameter.key}" value="${parameter.value}"/>
    </c:forEach>
    <c:if test="${not empty param.sort}">
        <c:param name="sort" value="${param.sort}"/>
    </c:if>
</c:url>

<c:set var="activeClass" value="${active ? 'page-tile--active' : ''}"/>
<c:set var="disabledClass" value="${disabled ? 'page-tile--disabled' : ''}"/>

<div class="page-tile ${activeClass} ${disabledClass}">
    <c:choose>
        <c:when test="${active or disabled}">
            <span>
                    ${pageSymbol}
            </span>
        </c:when>
        <c:otherwise>
            <a href="${url}">
                    ${pageSymbol}
            </a>
        </c:otherwise>
    </c:choose>
</div>

