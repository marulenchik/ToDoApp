<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Todos Page</title>
</head>
<body>
<div>Welcome ${name}</div>
<hr>
<h1>Enter Todo Details</h1>

<%--@elvariable id="todo" type=""--%>
<form:form method="post" modelAttribute = "todo">
    <fieldset>
        <form:label path="description">Description:</form:label>
        <form:input type="text" path="description" required = "required"/>
    </fieldset>
    <fieldset>
        <form:label path="targetDate">Target date:</form:label>
        <form:input type="text" path="targetDate" required = "required"/>
    </fieldset>
    <form:input type="hidden" path="id"/>
    <form:input type="hidden" path="done"/>
    <input type="submit" class = "btn">
</form:form>
</body>
</html>