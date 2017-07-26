package com.intelisoft.jdbc.dao.hibernate.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pavel on 26.07.2017.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Column(name= "idGroup")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGroup;
    @Column(name = "nameGroup")
    private String nameGroup;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "groupRoom")
    private Integer groupRoom;
    @Column(name = "specialSubj")
    private String specialSubj;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="group")
    private List<Students> students;

    Group(){
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getGroupRoom() {
        return groupRoom;
    }

    public void setGroupRoom(Integer groupRoom) {
        this.groupRoom = groupRoom;
    }

    public String getSpecialSubj() {
        return specialSubj;
    }

    public void setSpecialSubj(String specialSubj) {
        this.specialSubj = specialSubj;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", nameGroup='" + nameGroup + '\'' +
                ", teacher='" + teacher + '\'' +
                ", groupRoom=" + groupRoom +
                ", specialSubj='" + specialSubj + '\'' +
                ", students=" + students +
                '}';
    }
}
