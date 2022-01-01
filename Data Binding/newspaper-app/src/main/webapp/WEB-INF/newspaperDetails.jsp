<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Thanks for the details</h1>
<ol>
<li>${NAME}</li>
<li>${PRICE}</li>
<li>${LANGUAGE}</li>
<li>${NUMBEROFPAGES}</li>
</ol>
Name <input type="text" value="${NAME}">
<select>
<option>SELECT</option>
<option>${NAME}</option>
</select>
</body>
</html>