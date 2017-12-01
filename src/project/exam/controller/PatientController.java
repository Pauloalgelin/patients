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
import project.patient.dao.PatientDao;
import project.patient.model.Patient;

@Controller
@Transactional
public class PatientController {

  @Autowired
  ExamDao dao;
  
  @Autowired
  PatientDao daop;
  
  // Welcome page
  @RequestMapping("/welcome")
  public String welcome() {
    return "patient/welcome";
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
  
  
  // List of patients
  @RequestMapping("/patient-list")
  public String patientList(Model model) {
	  model.addAttribute("patients", daop.list());
	  return "patient/patient-list";
  }

  // Form to insert a new patient
  @RequestMapping("/patient-form")
  public String patientForm() {
	  return "patient/patient-form";
  }
  
  // Patient persistence
  @RequestMapping("/patient-add")
  public String patientAdd(@Valid Patient patient, BindingResult result) {
    if(result.hasErrors()) {
	  return "patient/patient-form";
    }
    daop.add(patient);
    return "redirect:patient-list";
  }  
  
  // Patient details and list
  @RequestMapping("/patient-details")
  public String patientDetails(Long id, Model model) {
    Patient patient = daop.idSearch(id);
    model.addAttribute("patient", patient);
    model.addAttribute("exams", daop.patientExamsList(patient));
    return "patient/patient-view";
  }

  // Exam removal from db
  @RequestMapping("/patient-remove")
  public void patientRemove(Long id, HttpServletResponse response) {
    daop.remove(daop.idSearch(id));
    response.setStatus(200);
  }  
}
