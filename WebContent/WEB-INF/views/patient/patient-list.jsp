<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of patients</title>
  </head>
  <body>
    <script type="text/javascript">
      function remove(id) {
        $.post("patient-remove", {'id' : id},
          function() {
            $("#patient_"+id).hide();
          }
        )
      }
    </script>
    
    <h2>Patients</h2>
    <table>
      <tr>
        <th>Name&emsp;</th>
        <th>Sex&emsp;</th>
        <th>Age&emsp;</th>
        <th>Address&emsp;</th>
        <th>Exams&emsp;</th>
        <th>Remove&emsp;</th>
      </tr>
      
      <c:forEach items="${patients}" var="patient">
        <tr id="patient_${patient.id}">
          <td>${patient.name}&emsp;</td>
          <td>${patient.sex}&emsp;</td>
          <td>${patient.age}&emsp;</td>
          <td>${patient.address}&emsp;</td>
          <td><a href="patient-details?id=${patient.id}" method="post">List of exams</a></td>&emsp;
          <td><a href="#" onClick="remove(${patient.id})">Delete</a></td>&emsp;
        </tr>
      </c:forEach>
    </table>
    </br>
    <a href="welcome">back</a>&emsp;
    <a href="patient-form">new patient</a>&emsp;
    <a href="exam-form">new exam</a>
  </body>
</html>
