
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<html>
<head>
    <title>Employee Management</title>
    <style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    #listOfEmployees tr:first-child{
        font-weight: bold;
    }
    </style>
</head>
 
<body>
     
 
    <table id="listOfEmployees" border="1">
    <tr>
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        
      </tr>
    <c:forEach items="${lists}" var="employee">    
      <tr>
        <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.email}</td>
       
      </tr>
    </c:forEach>
    </table>
 
   
</body>
</html>