<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="searchForm" method="get" action="phones" class="pdp-search-form">
    <label for="name" class="pdp-search-form__label">
        Model brand name:
    </label>
    <input id="name"
           name="name"
           class="pdp-search-form__input"
           value="${param.name}"/>
    <label for="fromPrice" class="pdp-search-form__label">
        From price:
    </label>
    <input id="fromPrice"
           name="fromPrice"
           class="pdp-search-form__input"
           value="${param.fromPrice}"/>
    <label for="toPrice" class="pdp-search-form__label">
        To price:
    </label>
    <input id="toPrice"
           name="toPrice"
           class="pdp-search-form__input"
           value="${param.toPrice}"/>
    <c:if test="${not empty param.sort}">
        <input id="sort"
               name="sort"
               type="hidden"
               value="${param.sort}">
    </c:if>
    <button class="pdp-search-form__button">
        Search
    </button>
</form>
<a href="phones" class="reset-search-link">
    Reset search parameters
</a>
