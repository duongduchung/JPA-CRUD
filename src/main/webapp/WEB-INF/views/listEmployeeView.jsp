<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.howtodoinjava.demo.model.EmployeeEntity" %>
<html lang="en">
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
    <div>
        id : <input type="text" id="id" disabled/> <br/>
        First Name: <input type="text" id="firstName"/> <br/>
        Last Name: <input type="text" id="lastName"/> <br/>
        Email: <input type="text" id="email"/> <br/>
        Salary: <input type="text" id="salary"/> <br/>
        Day Of Birth: <input type="text" id="dayOfBirth"/> <br/>
        <input type="button" value="Create" onclick="createEmployee()"/> | <input type="button" value="update" onclick="updateEmployee()"/>
    </div>
 
    <table id="listOfEmployees" border="1">
    	<tr>
	       <td>ID</td>
	       <td>First Name</td>
	       <td>Last Name</td>
	       <td>Email</td>
	       <td>Salary</td>
	       <td>Day Of Birth</td>
	       <td>Methods</td>
        </tr>
        <c:forEach items="${lists}" var="employee">    
            <tr id="employee-${employee.getId()}">
                <td id="employee-id-${employee.getId()}">${employee.getId()}</td>
                <td id="employee-firstName-${employee.getId()}">${employee.getFirstName()}</td>
                <td id="employee-lastName-${employee.getId()}">${employee.getLastName()}</td>
                <td id="employee-email-${employee.getId()}">${employee.getEmail()}</td>
                <td id="employee-salary-${employee.getId()}">${employee.getSalary()}</td>
                <td id="employee-dayOfBirth-${employee.getId()}">${employee.getDayOfBirth()}</td>
                <td id="employee-id-${employee.getId()}"><input type="button" value="Edit" onclick="editEmployee('${employee.getId()}')"/>| <input type="button" value="Delete" onclick="deleteEmployee('${employee.getId()}')"/></td>
            </tr>
        </c:forEach>  
    </table>
    
    <script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
	<script>	
        function deleteEmployee(id) {
            $.ajax({
                url: '/employee/' + id,
                type: 'DELETE',
                contentType: 'application/json',
                success: function(data) {
                    console.log('success');
                    $('#employee-' + id).remove();
                },
                error: function(error) {
                    console.log('fail');
                    console.log(error);
                }
            });
        }
        
        function editEmployee(id) {
            $('#id').val($('#employee-id-' + id).text());
            $('#firstName').val($('#employee-firstName-' + id).text());
            $('#lastName').val($('#employee-lastName-' + id).text());
            $('#email').val($('#employee-email-' + id).text());
            $('#salary').val($('#employee-salary-' + id).text());
            $('#dayOfBirth').val($('#employee-dayOfBirth-' + id).text());
        }
    
        function updateEmployee() {
            id = $('#id').val();
            employee = JSON.stringify({
                "name" : $('#name').val(),
                "firstName" : $('#firstName').val(),
                "lastName" : $('#lastName').val(),
                "email" : $('#email').val(),
                "salary" : $('#salary').val(),
                "dayOfBirth": $('#dayOfBirth').val()
            });
            $.ajax({
                url: '/employee/' + id,
                type: 'PUT',
                data: employee,
                contentType: 'application/json',
                dataType : 'json',
                success: function(data) {
                    $('#employee-firstName-' + id).text(data.firstName);
                    $('#employee-lastName-' + id).text(data.lastName);
                    $('#employee-email-' + id).text(data.email);
                    $('#employee-salary-' + id).text(data.salary);
                    $('#employee-dayOfBirth-' + id).text(data.dayOfBirth);
                },
                error: function(error) {
                }
            });
        }
        function createEmployee() {
            employee = JSON.stringify({
                "name" : $('#name').val(),
                "firstName" : $('#firstName').val(),
                "lastName" : $('#lastName').val(),
                "email" : $('#email').val(),
                "salary" : $('#salary').val(),
                "dayOfBirth": $('#dayOfBirth').val()
            });
            $.ajax({
                url: '/employee',
                type: 'POST',
                data: employee,
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                headers: { 
                    'Accept': 'application/json',
                    'Content-Type': 'application/json' 
                },
                success: function(employee) {
                    $('#listOfEmployees').append('<tr id=\'employee-' + employee.id + '\'><td id=\'employee-id-' + employee.id + '\'>' + employee.id + '</td><td id=\'employee-firstName-' + employee.id + '\'>' + employee.firstName + '</td><td id=\'employee-lastName-' + employee.id +  '\'>' + employee.lastName + '</td><td id=\'employee-email-' + employee.id +  '\'>' + employee.email + '</td><td id=\'employee-salary-' + employee.id +  '\'>' + employee.salary + '</td><td id=\'employee-dayOfBirth-' + employee.id +  '\'>' + employee.dayOfBirth + '</td><td><input type=\'button\' value=\'Edit\' onclick=\'editemployee(' + employee.id + ')\'/> | <input type=\'button\' value=\'Delete\' onclick=\'deleteemployee(' + employee.id + ')\'/></td></tr>');

                    $('#id').val('');
                    $('#firstName').val('');
                    $('#lastName').val('');
                    $('#email').val('');
                    $('#salary').val('');
                    $('#dayOfBirth').val('');
                },
                error: function(error) {
                }
            });
        }
    </script>   
   
</body>
</html>