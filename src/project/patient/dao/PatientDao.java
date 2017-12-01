package project.patient.dao;

import java.util.List;

import project.exam.model.Exam;
import project.patient.model.Patient;

public interface PatientDao {
  Patient idSearch(Long id);
  List<Patient> list();
  List<Exam> patientExamsList(Patient patient);
  void add(Patient patient);
  void update(Patient patient);
  void remove(Patient patient);
}
