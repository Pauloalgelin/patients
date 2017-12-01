package project.exam.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import project.exam.dao.ExamDao;
import project.exam.model.Exam;

@Controller
@Transactional
public class PatientController {

  @Autowired
  ExamDao dao;
  
  // Welcome page
  @RequestMapping("/welcome")
  public String welcome() {
    return "patient/welcome";
  }
  
  // List of patients
  @RequestMapping("/patient-list")
  public String patientList() {
	  return "patient/patient-list";
  }
  
  // Form to insert a new exam
  @RequestMapping("/exam-form")
  public String examForm() {
	  return "exam/exam-form";
  }
  
  // Exam persistence
  @RequestMapping("/exam-add")
  public String examAdd(@Valid Exam exam, BindingResult result) {
    if(result.hasErrors()) {
	  return "exam/exam-form";
    }
    dao.add(exam);
    return "redirect:exam-list";
  }
  
  // Exam removal from db
  @RequestMapping("/exam-remove")
  public void examRemove(Long id, HttpServletResponse response) {
    dao.remove(dao.idSearch(id));
    response.setStatus(200);
  }

  @RequestMapping("/exam-details")
  public String examDetails(Long id, Model model) {
    model.addAttribute("exam", dao.idSearch(id));
    return "exam/exam-details";
  }
  
  @RequestMapping("/exam-update")
  public String examUpdate (Exam exam) {
	System.out.print("chamou");
    dao.update(exam);
    return "redirect:exam-list";
  }
  
  // List of exams
  @RequestMapping("/exam-list")
  public String examList(Model model) {
    model.addAttribute("exams", dao.list());
    return "exam/exam-list";
  }
}
