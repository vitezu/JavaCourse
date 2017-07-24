package com.inteliSoft.jdbc.entity;

import java.util.List;

/**
 * Created by Pavel on 10.07.2017.
 */
public class GroupEntity {

    private Integer idGroup;
    private String nameGroup;
    private String teacher;
    private Integer groupRoom;
    private String specialSubj;
    private Integer counStud;
    private List<StudentsEntity> students;


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

    public Integer getCounStud() {
        return counStud;
    }

    public void setCounStud(Integer counStud) {
        this.counStud = counStud;
    }

    public List<StudentsEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsEntity> students) {
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
                ", counStud=" + counStud +
                ", students=" + students +
                '}';
    }
}
