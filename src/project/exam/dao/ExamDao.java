package project.exam.dao;

import java.util.List;

import project.exam.model.Exam;

public interface ExamDao {
  Exam idSearch(Long id);
  List<Exam> list();
  void add(Exam exam);
  void update(Exam exam);
  void remove(Exam exam);
  void finish(Long id);  
}
