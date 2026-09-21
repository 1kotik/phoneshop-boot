<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-4 offset-9">
        <c:choose>
            <c:when test="${not empty pageContext.request.userPrincipal}">
                <span>
                        Hello, ${pageContext.request.userPrincipal.name}
                </span>
                <a href="<c:url value="/logout"/>">
                    <button type="submit" class="btn btn-primary">
                        Logout
                    </button>
                </a>
            </c:when>
            <c:otherwise>
                <span>
                    Guest
                </span>
                <a href="<c:url value="/login"/>">
                    <button type="submit" class="btn btn-primary">
                        Login
                    </button>
                </a>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-4 offset-9">
        <a href="<c:url value="/admin"/>">
            <p>Admin panel</p>
        </a>
    </div>
</div>