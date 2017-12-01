package project.patient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import project.exam.model.Exam;
import project.patient.model.Patient;

@Repository
public class JpaPatientDao implements PatientDao {

  @PersistenceContext
  EntityManager manager;

  @Override
  public Patient idSearch(Long id) {
    return manager.find(Patient.class, id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Patient> list() { 
    return manager.createQuery("select p from Patient p").getResultList();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Exam> patientExamsList(Patient patient) {
	  return manager.createQuery("select e from Exam as e where e.patient = '" + patient.getName() + "'").getResultList();
  }

  @Override
  public void add(Patient patient) {
    manager.persist(patient);
  }

  @Override
  public void update(Patient patient) {
    manager.merge(patient);
  }

  @Override
  public void remove(Patient patient) {
    @SuppressWarnings("unused")
	Patient patientRemove = idSearch(patient.getId());
    manager.remove(patient);
  }

}
