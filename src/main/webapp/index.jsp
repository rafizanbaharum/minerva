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
<ul>
    <c:forEach var="course" items="${courses}">
        <li><a href="/course/${course.code}">${course.code} - ${course.name}</a></li>
    </c:forEach>
</ul>

</body>
</html>
