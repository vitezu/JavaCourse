package com.inteliSoft.jdbc.entity;

import java.util.List;

/**
 * Created by Pavel on 10.07.2017.
 */
public class Group {

    private Integer idGroup;
    private String nameGroup;
    private String teacher;
    private Integer groupRoom;
    private String specialSubj;
    private List<Students> students;


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
