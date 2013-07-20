<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>MINERVA</title>
</head>
<body>


<h1>${course.code} - ${course.name}</h1>
${course.description}

<h2>Course Modules</h2>
<ul>
    <c:forEach var="module" items="${course.modules}">
        <li><a href="/course/${course.code}/module/${module.order}">${module.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
