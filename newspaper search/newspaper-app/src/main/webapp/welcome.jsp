<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to newspaper app!!!..</h1>
	<h1>${validationMessage}</h1>
	<form action="submitnewspaper.news">
	<pre>
	Name : <input type="text" name="newspaperName">
	Price : <input type="text" name="price">
	Language : <input type="text" name="language">
	Number Of Pages : <input type="text" name="noOfPages">
	<input type="submit" value="Enter">
	</pre>
	</form>
	
	<h2>${searchValidationMessage}</h2>
	<form action="searchNewspaper.news">
	<label>Search</label> <input type="text" name="searchNewspaper">
	<input type="submit" value="searchNewspaper">
	</form>
	<ol>
	<li>${NEWSPAPERNAME}</li>
	<li>${PRICE }</li>
	<li>${LANGUAGE}</li>
	<li>${NUMBEROFPAGES}</li>
	</ol>
</body>
</html>