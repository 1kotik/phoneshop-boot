<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/util" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="url" required="true" type="java.lang.String" %>
<%@ attribute name="maxPages" required="true" type="java.lang.Integer" %>
<%@ attribute name="parameters" required="false" type="java.util.Map" %>

<c:set var="totalPagesToDisplay" value="${page.totalPages < maxPages ? page.totalPages - 1 : maxPages - 1}"/>
<c:set var="currentPage" value="${page.number}"/>
<c:set var="isLastPage" value="${currentPage >= page.totalPages - 1}"/>
<c:set var="startIndex" value="${currentPage < totalPagesToDisplay || totalPagesToDisplay == 0
                                ? 0
                                : (isLastPage ? currentPage - totalPagesToDisplay + 1 : currentPage - totalPagesToDisplay + 2)}"/>
<c:set var="endIndex" value="${currentPage < totalPagesToDisplay || totalPagesToDisplay == 0
                                ? totalPagesToDisplay
                                : (isLastPage ? currentPage : currentPage + 1)}"/>

<div class="page-container">
    <common:paginationTile pageNumber="${currentPage - 1}"
                           pageSymbol="<<"
                           url="${url}"
                           active="false"
                           disabled="${currentPage < 1}"
                           parameters="${parameters}"/>
    <c:if test="${startIndex > 0}">
        <common:paginationTile pageNumber="0"
                               pageSymbol="1"
                               url="${url}"
                               active="false"
                               parameters="${parameters}"/>
        <c:if test="${startIndex != 1}">
            <span>...</span>
        </c:if>
    </c:if>
    <c:forEach var="pageNumber" begin="${startIndex}" end="${endIndex}">
        <common:paginationTile pageNumber="${pageNumber}"
                               pageSymbol="${pageNumber + 1}"
                               url="${url}"
                               active="${pageNumber eq currentPage}"
                               parameters="${parameters}"/>
    </c:forEach>
    <common:paginationTile pageNumber="${currentPage + 1}"
                           pageSymbol=">>"
                           url="${url}"
                           active="false"
                           disabled="${isLastPage}"
                           parameters="${parameters}"/>
</div>
