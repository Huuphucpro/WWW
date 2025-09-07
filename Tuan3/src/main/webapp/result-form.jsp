<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="fit.iuh.se.bai01_jsp.Student" scope="request"/>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f8ff; padding: 20px; }
        h2 { text-align: center; }
        table { border-collapse: collapse; margin: auto; background: #fff; padding: 15px; }
        td, th { border: 1px solid #ccc; padding: 8px 12px; }
        th { background: #e6f2ff; }
    </style>
</head>
<body>
<h2>Registration Result</h2>

<table>
    <tr><th colspan="2">Personal Info</th></tr>
    <tr><td>First Name</td><td><jsp:getProperty name="student" property="firstName"/></td></tr>
    <tr><td>Last Name</td><td><jsp:getProperty name="student" property="lastName"/></td></tr>
    <tr><td>Email</td><td><jsp:getProperty name="student" property="email"/></td></tr>
    <tr><td>Phone</td><td><jsp:getProperty name="student" property="phoneNumber"/></td></tr>
    <tr><td>Gender</td><td><jsp:getProperty name="student" property="gender"/></td></tr>
    <tr><td>DOB</td><td><jsp:getProperty name="student" property="dob"/></td></tr>
    <tr><td>Address</td><td><jsp:getProperty name="student" property="address"/></td></tr>
    <tr><td>City</td><td><jsp:getProperty name="student" property="city"/></td></tr>
    <tr><td>Pincode</td><td><jsp:getProperty name="student" property="pin_code"/></td></tr>
    <tr><td>State</td><td><jsp:getProperty name="student" property="state"/></td></tr>
    <tr><td>Country</td><td><jsp:getProperty name="student" property="country"/></td></tr>
</table>

<br/>

<table>
    <tr><th colspan="4">Qualification</th></tr>
    <tr><th>Exam</th><th>Board</th><th>Percent</th><th>Year</th></tr>
    <tr><td>X</td><td><jsp:getProperty name="student" property="board10"/></td><td><jsp:getProperty name="student" property="percent10"/></td><td><jsp:getProperty name="student" property="year10"/></td></tr>
    <tr><td>XII</td><td><jsp:getProperty name="student" property="board12"/></td><td><jsp:getProperty name="student" property="percent12"/></td><td><jsp:getProperty name="student" property="year12"/></td></tr>
    <tr><td>Graduation</td><td><jsp:getProperty name="student" property="boardGrad"/></td><td><jsp:getProperty name="student" property="percentGrad"/></td><td><jsp:getProperty name="student" property="yearGrad"/></td></tr>
    <tr><td>Masters</td><td><jsp:getProperty name="student" property="boardMas"/></td><td><jsp:getProperty name="student" property="percentMas"/></td><td><jsp:getProperty name="student" property="yearMas"/></td></tr>
</table>

<br/>

<table>
    <tr><th>Hobbies</th></tr>
    <tr><td>
        <%
            java.util.List<String> hobbies = student.getHobbies();
            if(hobbies != null){
                for(String h : hobbies){
                    out.print(h + "<br/>");
                }
            }
        %>
    </td></tr>
</table>

<br/>

<table>
    <tr><th>Courses</th></tr>
    <tr><td>
        <%
            java.util.List<String> courses = student.getCourses();
            if(courses != null){
                for(String c : courses){
                    out.print(c + "<br/>");
                }
            }
        %>
    </td></tr>
</table>

</body>
</html>
