<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Card Registration</title>
</head>
<body>
<form action="regform"  >   
Enter Customer Name: <input type="text" name="username" pattern="[a-z A-Z]{3,20}" title="Should only contain letters" ><br><br>                 
Enter Account Number : <input type="text" name="accountnumber" pattern="[1-9]{3,15}" title="Should only contain numerical Values with min 3 and max 15 values" ><br><br>
Enter PhoneNumber : <input type="text" name="phonenumber" pattern="[1-9]{3,11}"   title="Should only contain numerical Values with min 3 and max 10 values" ><br><br>
Enter Age : <input type="number" name="age" min="18" max="80" value="18" title="age should be above 18" ><br><br>
Enter Salary : <input type="number" name="salary" min="20000" max="1000000" value="20000" title="Salary should be above 20000"><br><br>
<input type="submit"><br> 


</form>

</body>
</html>