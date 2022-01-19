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
	
	<h2>${updateValidationMessage}</h2>
	<form action="updateNewspaper.news">
	
	<pre>
	Name : <input type="text" name="newspaperName" value="${NEWSPAPERNAME}">
		<p style="color:red" >${messageForName} </p>
	Price : <input type="text" name="price" value="${PRICE}">
		<p style="color:red" >${messageForPrice} </p>
	Language : <input type="text" name="language" value="${LANGUAGE}">
		<p style="color:red" >${messageForLanguage} </p>
	Number Of Pages : <input type="text" name="noOfPages" value="${NUMBEROFPAGES}">
		<p style="color:red" >${messageForPages} </p>
	<input type="submit" value="Update">
	</pre>
	</form>
	
	<div>
		<a href="getAllNewspaper.news">viewAllNewspaper</a>
		<br>
		<c:forEach items="${ListOfNewspaper}" var="newspaperObj">
		<tr>
			<td>${newspaperObj.newspaperName}</td><br>
			<td>${newspaperObj.price}</td><br>
			<td>${newspaperObj.language}</td><br>
			<td>${newspaperObj.noOfPages}</td><br>
		</tr>
		</c:forEach>
		
	</div>
	<br>
	<br>
	
	<h2>${deleteValidationMessage}</h2>
	<form action="deleteNewspaper.news">
	<label>Enter Newspaper name :</label> <input type="text" name="searchNewspaper">
	<input type="submit" value="DeleteNewspaper"><br><br>
	</form>
	
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