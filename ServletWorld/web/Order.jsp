

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <%
        Cookie[] cookie = null;
        cookie = request.getCookies();
    %>
<form action = "ServletForm" method = "POST">
    <Table>
        <tr>
            <th><%out.print(cookie[0].getValue()); %> Please check off things you would like to order</th>
        </tr>
        <tr>
            <td><input type = "checkbox" name = "Cars" checked = "checked"/> Cars</td>
        </tr>
        <tr>
            <td><input type = "checkbox" name = "House"/> House</td>
        </tr>
        <tr>
            <td><input type = "checkbox" name = "Boats"/> Boats</td>
        </tr>
        <tr>
            <td><input type = "checkbox" name = "Planes" checked = "checked"/> Planes</td>
        </tr>
    </Table><br/>
    <input type = "submit" value = "Select Subject" />
</form>
</body>
</html>

