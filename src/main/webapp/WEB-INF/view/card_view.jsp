<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MTG Ring decks</title>
</head>
<body>
    <div align="center">
        <h2><c:out value="${card.title}"/></h2>
        <img src="<c:url value="/resources/database/cards/" />${card.cardPath}.jpg" alt="image" />
    </div>
</body>
</html>