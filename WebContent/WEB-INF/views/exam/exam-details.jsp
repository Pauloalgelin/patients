<form action="exam-update" method="post">
  <input type="hidden" name="id" value="${exam.id}" />
  <input type="hidden" name="patient" value="${exam.patient}" />
  Name: ${exam.patient}</br>
  Number: ${exam.id}</br>
  Description:</br><textarea name="description" rows="3" cols="80" placeholder="${exam.description}"></textarea></br>
  <input type="submit" value="Update">
</form>
<a href="exam-list">back</a>&emsp;