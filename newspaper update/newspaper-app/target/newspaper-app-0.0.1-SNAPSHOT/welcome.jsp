<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<p style="color:red" >${messageForName} </p>
	Price : <input type="text" name="price">
		<p style="color:red" >${messageForPrice} </p>
	Language : <input type="text" name="language">
		<p style="color:red" >${messageForLanguage} </p>
	Number Of Pages : <input type="text" name="noOfPages">
		<p style="color:red" >${messageForPages} </p>
	<input type="submit" value="Enter">
	</pre>
	</form>
	
	<h2>${searchValidationMessage}</h2>
	<form action="searchNewspaper.news">
	<label>Search By Newspaper :</label> <input type="text" name="searchNewspaper">
	<input type="submit" value="searchNewspaper">
	</form>
	<ol>
	<li>${NEWSPAPERNAME}</li>
	<li>${PRICE}</li>
	<li>${LANGUAGE}</li>
	<li>${NUMBEROFPAGES}</li>
	</ol>
	
	<div>
		<a href="getAllNewspaper.news">viewAllNewspaper</a>
	</div>
	
	<%-- <h2>${searchValidationMessageForLang}</h2>
	<form action="searchLanguage.news">
	<label>Search By Language :</label> <input type="text" name="searchLanguage">
	<input type="submit" value="searchLanguage">
	</form>
	<ol>
	<li>${NEWSPAPERNAME}</li>
	<li>${PRICE}</li>
	<li>${LANGUAGE}</li>
	<li>${NUMBEROFPAGES}</li>
	</ol> --%>
</body>
</html>