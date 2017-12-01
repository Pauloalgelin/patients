package project.patient.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {
  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  private String name;
  private String sex;
  private int age;
  private String address;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }  

}
