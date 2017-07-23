package com.inteliSoft.jdbc.entity;

import java.util.List;

/**
 * Created by Pavel on 10.07.2017.
 */
public class GroupEntity {

    private int idGroup;
    private String nameGroup;
    private String teacher;
    private int groupRoom;
    private String specialSubj;
    private int counStud;
    private List<StudentsEntity> students;


    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameClass) {
        this.nameGroup = nameClass;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getGroupRoom() {
        return groupRoom;
    }

    public void setGroupRoom(int groupRoom) {
        this.groupRoom = groupRoom;
    }

    public String getSpecialSubj() {
        return specialSubj;
    }

    public void setSpecialSubj(String specialSubj) {
        this.specialSubj = specialSubj;
    }

    public int getCounStud() {
        return counStud;
    }

    public void setCounStud(int counStud) {
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
