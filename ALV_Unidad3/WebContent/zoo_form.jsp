<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zoo Form</title>
</head>
<body>
	<form action="ZooController">
		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${zoo.name}" /><br>
		
		<label>Number Animals:</label><br>
		<input type = "text" name= "number_animals" value = "${zoo.number_animals}" /><br>
		
		<label>City:</label><br>
		<input type = "text" name= "city" value = "${zoo.city}" /><br>
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>


