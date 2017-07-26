package com.intelisoft.jdbc.dao.hibernate.entity;

import javax.persistence.*;

/**
 * Created by Pavel on 26.07.2017.
 */
@Entity
@Table(name = "students")
public class Students {
    @Id
    @Column(name= "id_student")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idStudent;
    @Column(name= "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @Column(name= "age")
    private Integer age;
    @Column(name= "birth")
    private String birth;
    @Column(name= "phone")
    private Integer phone;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_group")
    private Group group;

    Students (){

    }
    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Students{" +
                "idStudent=" + idStudent +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                ", phone=" + phone +
                ", group=" + group +
                '}';
    }
}
