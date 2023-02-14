<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit champ</title>
</head>
<body>
<form action="editChampServlet" method="post">
Champ: <input type="text" name="champName" value="${champToEdit.champName}">
Fun-Rank: <input type="text" name="funRank" value="${champToEdit.funRank}">
<input type="hidden" name="id" value="${champToEdit.id}">
<input type="submit" value="Save Edited Champ">
</form>

</body>
</html>