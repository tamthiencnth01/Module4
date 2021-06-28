<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/6/2021
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>index</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.form.min.js" />"></script>

</head>
<body>
<c:forEach var="c" items="${requestScope.customers}">
    <tr>
        <td>
            <c:out value="${c.id}"/>
        </td>
        <td>
            <c:out value="${c.name}"/>
        </td>
        <td>
            <c:out value="${c.address}"/>
        </td>
        <td>
            <img src="${c.avatar}" />
        </td>
    </tr>
</c:forEach>

<br /> <br />
<div class="progress" id="progressbox" style="height: 45px; width: 50%" >
    <div class="progress-bar progress-bar-striped active" id="progressbar"
         role="progressbar" aria-valuenow="80" aria-valuemin="0"
         aria-valuemax="100" style="width: 0%">
        <div id="status" style="text-align: center; width: 100%; margin-top: 10px"></div>
    </div>
</div>
</body>
</html>
