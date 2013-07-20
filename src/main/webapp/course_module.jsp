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
${module.description}

<h2>Table of Contents</h2>
<ul>
    <ul>
        <c:forEach var="lesson" items="${module.lessons}">
            <li>
                <h3>${lesson.title}</h3>
                    ${lesson.description}
            </li>

            <ul>
                <c:forEach var="section" items="${lesson.sections}">
                    <li><h4>${section.title}</h4></li>
                    <ul>
                        <c:forEach var="content" items="${section.contents}">
                            <li>
                                <h5>${content.title}</h5>
                                    ${content.body}
                            </li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </ul>
        </c:forEach>
    </ul>
</body>


<h2>Assessments</h2>
<ul>
    <ul>
        <c:forEach var="assessment" items="${module.assessments}">
            <li>
                <h3>${assessment.title}</h3>
                    ${assessment.description}
            </li>

            <ul>
                <c:forEach var="section" items="${assessment.sections}">
                    <li><h4>${section.title}</h4></li>
                    <ul>
                        <c:forEach var="question" items="${section.questions}">
                            <c:if test="${question.questionType == 'MULTIPLE_CHOICE'}">
                                <li>
                                    <h5>${question.title}</h5>
                                        ${question.body}
                                    <ol>
                                            <li>${question.answer1}</li>
                                            <li>${question.answer2}</li>
                                            <li>${question.answer3}</li>
                                            <li>${question.answer4}</li>
                                    </ol>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </ul>
        </c:forEach>
    </ul>
    </body>


</html>
