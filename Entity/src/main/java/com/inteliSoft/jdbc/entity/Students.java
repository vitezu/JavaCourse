package com.inteliSoft.jdbc.entity;

/**
 * Created by Pavel on 10.07.2017.
 */
public class Students {
    private Integer idStudents;
    private String firstName;
    private String lastName;
    private Integer age;
    private String birth;
    private Integer phone;
    private Group group;

    public Integer getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(Integer idStudents) {
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