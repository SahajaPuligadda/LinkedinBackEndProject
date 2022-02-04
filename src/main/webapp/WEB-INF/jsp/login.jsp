<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">
<font color = "red">${ errorMessage }</font>
    <form method="post">
        Email: <input type="text" name="email"/>
        Password: <input type="password" name="password"/>
        <input type="submit"/>
    </form>
<%--My First JSP!!!--%>
<%--${name}--%>
</div>

<%@include file="common/footer.jspf"%>
