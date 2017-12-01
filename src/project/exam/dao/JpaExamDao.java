package project.exam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import project.exam.model.Exam;

@Repository
public class JpaExamDao implements ExamDao {
  
  @PersistenceContext
  EntityManager manager;

    public void add(Exam exam) {
      manager.persist(exam);
    }

    public void update(Exam exam) {
      manager.merge(exam);
    }

    @SuppressWarnings("unchecked")
	public List<Exam> list() {
      return manager.createQuery("select e from Exam e")
        .getResultList();
    }

    public Exam idSearch(Long id) {
      return manager.find(Exam.class, id);
    }

    public void remove(Exam exam) {
      Exam examRemove = idSearch(exam.getId());
      manager.remove(examRemove);
    }

    public void finish(Long id) {
      Exam exam = idSearch(id);
      exam.setFinished(true);
    }
}