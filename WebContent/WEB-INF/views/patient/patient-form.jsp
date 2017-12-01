<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=U/TF-8">
    <title>New Patient</title>
  </head>
  <body>
    <h3>New patient</h3>
    <form action="patient-add" method="post">
      Name: <input type="text" name="name"></br>
      Sex: <input type="text" name="sex"></br>
      Age: <input type="number" name="age" min="0" max="120"></br>
      Address: <input type="text" name="address"></br>
      <input type="submit" value="Add">
    </form>
    <a href="patient-list">back</a>&emsp;
  </body>
</html>