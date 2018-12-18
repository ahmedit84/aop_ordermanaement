<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Results</title>
    </head>
    <body>
        
        <a href="../index.jsp">Home Page</a>
        <h2 align="center"> Create New Customer</h2>


    <form:form action="addCustomer" modelAttribute="customer">
        <table align="center" bordr="1">
            <tr>
                <th colspan="2">New Customer Details</th>
            </tr>
            <tr>
                <td>Customer Name</td> <td><form:input path="name" /></td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="Create Customer"/>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <hr/>
    <h2 align="center">All Customers</h2>
    <table align="center" border="1" style="width: 500px">
        <tr>
            <th>Customer Id</th> <th>Customer Name</th>
        </tr>
        <c:forEach var="cust" items="${customers}">
            <tr>
                <td> <c:out value="${cust.customersId}"/></td>
                <td> <c:out value="${cust.name}"/> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>