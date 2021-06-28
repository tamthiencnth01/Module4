<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are <%= count %> customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>
    <% for (Customer c : customers) { %>
    <tr>
        <td>
            <%= c.getId() %>
        </td>
        <td>
            <a href="/customers/info.jsp?id=<%= c.getId() %>"><%= c.getName() %></a>
        </td>
        <td>
            <%= c.getEmail() %>
        </td>
        <td>
            <%= c.getAddress() %>
        </td>
        <td>
            <a href="/delete?id=<%= c.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<a href="/customers/add.jsp">Add customer</a>