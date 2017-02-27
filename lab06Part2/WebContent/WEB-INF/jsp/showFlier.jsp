<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Flier Information</title>
</head>
<body>
	<h3>Flier Information</h3>
	<p>${msg}</p>
	<p>
		<c:if test="${not empty flierName}">
Name: ${flierName}
</c:if>
	</p>
	<p>
		<c:if test="${not empty flierEmail}">
Email: ${flierEmail}
</c:if>
	</p>
</body>
</html>