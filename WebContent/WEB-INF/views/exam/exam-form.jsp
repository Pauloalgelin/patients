<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=U/TF-8">
    <title>New Exam</title>
  </head>
  <body>
    <h3>New exam</h3>
    <form action="exam-add" method="post">
      Patient: <input type="text" name="patient"></br>
      Description: <br />
      <textarea name="description" rows="3" cols="80"></textarea><br />
      <input type="submit" value="Add">
    </form>
    <a href="exam-list">back</a>&emsp;
  </body>
</html>