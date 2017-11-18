<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zoo</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="ZooController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>IdZoo</th>
			 <th>Name</th>
			 <th>Number Animals</th>
			 <th>City</th>
			
		</tr>
		<c:forEach var="zoo" items="${zoos}">
		
		<tr>
			<td>
				<form action= "ZooController">
					<input type = "hidden" name = "id_zoom" value= "${zoo.id_zoom}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${zoo.id_zoom}</td>
			<td> ${zoo.name}</td>
			<td> ${zoo.number_animals}</td>
			<td> ${zoo.city}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="ZooReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>