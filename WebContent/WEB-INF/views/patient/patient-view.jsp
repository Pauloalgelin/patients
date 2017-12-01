<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Exams of "${patient.name}"</title>
</head>
  <body>
  
  <script type="text/javascript">
      function remove(id) {
        $.post("exam-remove", {'id' : id},
          function() {
            $("#exam_"+id).hide();
          }
        )
      }
    </script>
    
    <h2>Exams of ${patient.name}</h2>
    
    <table>
      <tr>
        <th>Exam number&emsp;</th>
        <th>Description&emsp;</th>
        <th>Remove&emsp;</th>
        <th>More</th>
      </tr>
      
      <c:forEach items="${exams}" var="exam">
        <tr id="exam_${exam.id}">
          <td>${exam.id}&emsp;</td>
          <td>${exam.description}&emsp;</td>
          <td><a href="#" onClick="remove(${exam.id})">Delete</a></td>&emsp;
          <td><a href="exam-details?id=${exam.id}" method="post">Update</a></td>
        </tr>
      </c:forEach>
    </table>
    </br>
    
    <a href="patient-list">back</a>&emsp;
    <a href="patient-form">new patient</a>&emsp;
    <a href="exam-form">new exam</a>
    
  </body>
</html>