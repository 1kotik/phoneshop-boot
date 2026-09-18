<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<common:page pageTitle="Phone details" showMenu="true">
    <div class="row mb-3">
        <common:back/>
    </div>
    <div class="pdp">
        <div class="pdp__image">
            <img src="<c:url value="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${phone.image}"/>"
                 alt="<c:out value='${phone.brand} ${phone.model}'/>"/>
        </div>
        <div class="pdp__info">
            <h2 class="pdp__title">
                <c:out value="${phone.brand}"/> <c:out value="${phone.model}"/>
            </h2>
            <dl class="pdp__specs">
                <dt>Brand:</dt>
                <dd><c:out value="${phone.brand}"/></dd>
                <dt>Model:</dt>
                <dd><c:out value="${phone.model}"/></dd>
                <dt>Price:</dt>
                <dd><c:out value="${phone.price}"/> $</dd>
            </dl>
            <p class="pdp__description">
                <strong>Description:</strong>
                <c:out value="${phone.description}"/>
            </p>
        </div>
    </div>
</common:page>
