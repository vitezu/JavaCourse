package com.intelisoft.jdbc.dao.impl;

import com.inteliSoft.jdbc.entity.Group;
import com.inteliSoft.jdbc.entity.Students;
import com.intelisoft.jdbc.api.StudentsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public class StudentsDaoImpl implements StudentsDao {
    private final String addStudents = "INSERT INTO students (firstName, lastName, age, birth, phone, idGroup, idStudent) VALUES (?,?,?,?,?,?,?)";
    private final String getAllStudents = "Select idStudent, firstName, lastName, age, birth, phone from students";
    private final String getByIdStudents = "SELECT * FROM students where idStudent=?";
    private final String updateStudents = "UPDATE students SET  firstName=?, lastName=?, age=?, birth=?, phone=?, idGroup=? where idStudent=?";
    private final String deleteStudents = "DELETE  FROM students where idStudent=?";
    private final String getWithGroup = "SELECT  students.firstName, students.lastName, groups.teacher  FROM students inner join groups ON students.idGroup = groups.idGroup where students.idGroup = 3";
    private void convertStudents(Students students, PreparedStatement prst) throws SQLException {
        Group group = new Group();
        group.setIdGroup(3);
        prst.setString(1, students.getFirstName());
        prst.setString(2, students.getLastName());
        prst.setInt(3, students.getAge());
        prst.setString(4, students.getBirth());
        prst.setInt(5, students.getPhone());
        prst.setInt(6, group.getIdGroup());
        prst.setInt(7, students.getIdStudent());
        prst.executeUpdate();
    };
    private Students convertRow(ResultSet rs) throws SQLException {
        Students students = new Students();
        students.setIdStudent(rs.getInt("idStudent"));
        students.setFirstName(rs.getString("firstName"));
        students.setLastName(rs.getString("lastName"));
        students.setAge(rs.getInt("age"));
        students.setBirth(rs.getString("birth"));
        students.setPhone(rs.getInt("phone"));
        return students;
    }


    public void add(Students students, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(addStudents);
            convertStudents(students, prst);
                    prst.close();
    }

    public List<Students> getAll(Connection conn) throws SQLException {
        List<Students> studentsList = new ArrayList<Students>();
        Statement st = null;
        ResultSet rs = null;
            st = conn.createStatement();
            rs = st.executeQuery(getAllStudents);
            while (rs.next()) {
                Students students = convertRow(rs);
                studentsList.add(students);
            }
                st.close();
            return studentsList;
    }

    public Students getById(int idStudents, Connection conn) throws SQLException {
        PreparedStatement prst = null;
        Students students = null;
            prst = conn.prepareStatement(getByIdStudents);
            prst.setInt(1, idStudents);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                students = convertRow(rs);
            }
            prst.close();
        return students;
    }

    public void update(Students students, Connection conn) throws SQLException {
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

    public List<Students> getWithGroup(Connection conn) throws SQLException {
        List<Students> studentsList = new ArrayList<Students>();
        Group group = new Group();
        Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getWithGroup);
            while (rs.next()) {
                Students students = new Students();
                students.setFirstName(rs.getString("firstName"));
                students.setLastName(rs.getString("lastName"));
                group.setTeacher(rs.getString("teacher"));
                students.setGroup(group);
                studentsList.add(students);
            }
        return studentsList;
    }
}
