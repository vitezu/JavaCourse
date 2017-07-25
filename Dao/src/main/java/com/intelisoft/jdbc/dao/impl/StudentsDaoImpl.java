package com.intelisoft.jdbc.dao.impl;

import com.inteliSoft.jdbc.entity.GroupEntity;
import com.inteliSoft.jdbc.entity.StudentsEntity;
import com.intelisoft.jdbc.api.StudentsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public class StudentsDaoImpl implements StudentsDao {
    private final String addStudents = "INSERT INTO students (firstName, lastName, age, birth, phone, idGroup, idStudents) VALUES (?,?,?,?,?,?,?)";
    private final String getAllStudents = "Select idStudents, firstName, lastName, age, birth, phone from students";
    private final String getByIdStudents = "SELECT * FROM students where idStudents=?";
    private final String updateStudents = "UPDATE students SET  firstName=?, lastName=?, age=?, birth=?, phone=?, idGroup=? where idStudents=?";
    private final String deleteStudents = "DELETE  FROM students where idStudents=?";
    private final String getWithGroup = "SELECT  students.firstName, students.lastName, groups.teacher  FROM students inner join groups ON students.idGroup = groups.idGroup where groups.idGroup = 3";
    private void convertStudents(StudentsEntity students, PreparedStatement prst) throws SQLException {
        GroupEntity group = new GroupEntity();
        group.setIdGroup(3);
        prst.setString(1, students.getFirstName());
        prst.setString(2, students.getLastName());
        prst.setInt(3, students.getAge());
        prst.setString(4, students.getBirth());
        prst.setInt(5, students.getPhone());
        prst.setInt(6, group.getIdGroup());
        prst.setInt(7, students.getIdStudents());
        prst.executeUpdate();
    };
    private StudentsEntity convertRow(ResultSet rs) throws SQLException {
        StudentsEntity students = new StudentsEntity();
        students.setIdStudents(rs.getInt("idStudents"));
        students.setFirstName(rs.getString("firstName"));
        students.setLastName(rs.getString("lastName"));
        students.setAge(rs.getInt("age"));
        students.setBirth(rs.getString("birth"));
        students.setPhone(rs.getInt("phone"));
        return students;
    }


    public void add(StudentsEntity students, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(addStudents);
            convertStudents(students, prst);
                    prst.close();
    }

    public List<StudentsEntity> getAll(Connection conn) throws SQLException {
        List<StudentsEntity> studentsList = new ArrayList<StudentsEntity>();
        Statement st = null;
        ResultSet rs = null;
            st = conn.createStatement();
            rs = st.executeQuery(getAllStudents);
            while (rs.next()) {
                StudentsEntity students = convertRow(rs);
                studentsList.add(students);
            }
                st.close();
            return studentsList;
    }

    public StudentsEntity getById(int idStudents, Connection conn) throws SQLException {
        PreparedStatement prst = null;
        StudentsEntity students = null;
            prst = conn.prepareStatement(getByIdStudents);
            prst.setInt(1, idStudents);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                students = convertRow(rs);
            }
            prst.close();
        return students;
    }

    public void update(StudentsEntity students, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(updateStudents);
            convertStudents(students, prst);
            prst.close();
    }

    public void delete(int idStudents, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(deleteStudents);
            prst.setInt(1, idStudents);
            prst.executeUpdate();
            prst.close();
    }

    public List<StudentsEntity> getWithGroup(Connection conn) throws SQLException {
        List<StudentsEntity> studentsList = new ArrayList<StudentsEntity>();
        StudentsEntity students = new StudentsEntity();
        GroupEntity group = new GroupEntity();
        Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getWithGroup);
            while (rs.next()) {
                students.setFirstName(rs.getString("firstName"));
                students.setLastName(rs.getString("lastName"));
                group.setTeacher(rs.getString("teacher"));
                students.setGroup(group);
                studentsList.add(students);
            }
        return studentsList;
    }
}
