<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Java Mail Sender</h1>
<form action="sendMail.mail">
<pre>
	To: <input type="text" name="to">
	Subject: <input type="text" name="subject">
	Message: <input type="text" name="message">
	<input type="submit" value="send">
</pre>
</form>
<h2>${message}</h2>
</body>
</html>