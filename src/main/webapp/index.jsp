<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>MINERVA</title>
</head>
<body>


<h1>Course List</h1>

<table class="list">
    <tr>
        <th>Code</th>
        <th>Name</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.code}</td>
            <td>${course.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
