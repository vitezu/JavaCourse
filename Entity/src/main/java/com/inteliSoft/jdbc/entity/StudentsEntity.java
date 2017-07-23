package com.inteliSoft.jdbc.entity;

/**
 * Created by Pavel on 10.07.2017.
 */
public class StudentsEntity {
    private int idStudents;
    private String firstName;
    private String lastName;
    private int age;
    private String birth;
    private int phone;
    private GroupEntity group;


    public int getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(int idStudents) {
        this.idStudents = idStudents;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity students = (StudentsEntity) o;

        if (age != students.age) return false;
        if (phone != students.phone) return false;
        if (firstName != null ? !firstName.equals(students.firstName) : students.firstName != null) return false;
        if (lastName != null ? !lastName.equals(students.lastName) : students.lastName != null) return false;
        if (birth != null ? !birth.equals(students.birth) : students.birth != null) return false;
        return group != null ? group.equals(students.group) : students.group == null;
    }

    @Override
    public String toString() {
        return "com.inteliSoft.jdbc.entity.Students{" +
                "idStudents=" + idStudents +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                ", phone=" + phone +
                ", group=" + group +
                '}';
    }
}