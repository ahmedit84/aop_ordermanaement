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
    <h2 align="center"> Create New Order</h2>

    <form:form action="addOrder" modelAttribute="order">
<table align="center" bordr="1">
    <tr>
        <th colspan="2">New Order Details</th>
    </tr>
    <tr>
        <td>Order Description</td> <td><form:input path="description"/></td>
    </tr>
     <tr>
        <td>Customer</td> <td>
            <form:select path="customerId">
                <c:forEach var="cust" items="${customers}">
                    <form:option value="${cust.customersId}" label="${cust.name}"/>
            </c:forEach>
            </form:select>
             &nbsp;&nbsp; <a href="allCustomers">Add Customer</a> <br/>
        </td>
    </tr>
    <tr align="center">
        <td colspan="2">
            <input type="submit" value="Save Order"/>
        </td>
    </tr>
</table>
    </form:form>
     <br/>
     <hr/>
	<h2 align="center">All Order Details</h2>
        <table align="center" border="1" style="width: 500px">
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>Id: <c:out value="${order.orderId}"/></td>
                <td>Description: <c:out value="${order.description}"/> </td>
                <td>Customer Id: <c:out value="${order.customerId}"/> </td>
        </tr>
        </c:forEach>
        </table>
</body>
</html>