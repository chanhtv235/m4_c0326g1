<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm mới</h2>
<%--<form action="/student/add" method="post">--%>
<%--    ID:--%>
<%--    <input name="id"/><br>--%>
<%--    Name:--%>
<%--    <input name="name"/><br>--%>
<%--    Gender:--%>
<%--    <input type="radio" name="gender" value="0"/>Male--%>
<%--    <input type="radio" name="gender" value="0"/>Female<br>--%>
<%--    Subject:--%>
<%--    <c:forEach items="${subjects}" var="sub">--%>
<%--        <input type="checkbox" name="subjects" value="${sub}"><span>${sub}</span>--%>
<%--    </c:forEach><br>--%>
<%--    <select name="className">--%>
<%--        <option value="C06">C06</option>--%>
<%--        <option value="C07">C07</option>--%>
<%--        <option value="C07">C08</option>--%>
<%--    </select><br>--%>
<%--    <button>Lưu</button>--%>
<%--</form>--%>


<form:form action="/student/add" modelAttribute="student" method="post">
    ID:
    <form:input path="id"/><br>
    Name:
    <form:input path="name"/><br>
    Gender:
    <form:radiobutton path="gender" value="1"/>Male
    <form:radiobutton path="gender" value="0"/> Female<br>
    Subject:
    <form:checkboxes path="subjects" items="${subjects}"/><br>
    <form:select path="className">
        <form:option value="C06">C06</form:option>
        <form:option value="C07">C07</form:option>
        <form:option value="C07">C08</form:option>
    </form:select><br>
    <form:button>Lưu</form:button>
</form:form>

</body>
</html>
