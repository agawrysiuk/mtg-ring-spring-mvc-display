<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MTG Ring decks</title>
</head>
<body>
    <div align="center">
        <h2>Decks used</h2>
        <p>Here are the decks used in the MTG Ring game:</p>
        <c:forEach var="deck" items="${decks}">
            <c:url var="viewUrl" value="deck">
                <c:param name="deckName" value="${deck.deckName}"/>
            </c:url>
            <p><b><a href="${viewUrl}"><c:out value="${deck.deckName}"/></a></b></p>
        </c:forEach>
    </div>
</body>
</html>
