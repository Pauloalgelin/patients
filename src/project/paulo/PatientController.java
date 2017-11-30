package project.paulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


import project.dao.ExamDao;
import project.exam.model.Exam;


@Controller
public class PatientController {

  @Autowired
  ExamDao dao;
  
  @RequestMapping("/welcome")
  public String welcome() {
    return "patient/welcome";
  }
  
  @RequestMapping("/patient-list")
  public String listPatient() {
	  return "patient/patient-list";
  }
  
  @RequestMapping("/exam-form")
  public String examForm() {
	  return "exam/exam-form";
  }
  
  @RequestMapping("/exam-add")
  public String addExam(@Valid Exam exam, BindingResult result) {
    if(result.hasErrors())
	  return "exam/exam-form";
    dao.add(exam);
    return "exam/exam-list";
  }
  
  @RequestMapping("/exam-list")
  public String listExam(Model model) {
    model.addAttribute("exams", dao.list());
    return "exam/exam-list";
  }
}
