<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MTG Ring decks</title>
</head>
<body>
<h2><c:out value="${deckName}"/></h2>
<%--yeah, i dont know how to use divs--%>
<table>
    <tr>
        <td valign="top" width="600">
            <div>
                <table border="1" cellpadding="5">
                    <caption><h4>Main deck:</h4></caption>

                    <tr>
                        <th>Quantity</th>
                        <th>Card title</th>
                    </tr>

                    <c:forEach var="card" items="${deckMain}">
                        <c:url var="viewCard" value="card">
                            <c:param name="cardName" value="${card.key}"/>
                        </c:url>
                        <tr>
                            <td><c:out value="${card.value}"/></td>
                            <td><b><a href="${viewCard}" target="iframe1"><c:out value="${card.key}"/></a></b></td>
                        </tr>
                    </c:forEach>

                </table>

                <table border="1" cellpadding="5">
                    <caption><h4>Sideboard:</h4></caption>

                    <tr>
                        <th>Quantity</th>
                        <th>Card title</th>
                    </tr>

                    <c:forEach var="card" items="${deckSide}">
                        <c:url var="viewCard" value="card">
                            <c:param name="cardName" value="${card.key}"/>
                        </c:url>
                        <tr>
                            <td align="center"><c:out value="${card.value}"/></td>
                            <td><b><a href="${viewCard}" target="iframe1"><c:out value="${card.key}"/></a></b></td>
                        </tr>
                    </c:forEach>

                </table>
                <p>&nbsp;</p>
                <c:url var="home" value="/"/>
                <h2><a href="${home}">Back to the list</a></h2>
            </div>
        </td>
        <td valign="top">
            <div>
                <iframe name="iframe1" height="900" width="675"></iframe>
            </div>
        </td>
    </tr>
</table>



</body>
</html>