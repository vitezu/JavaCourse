package com.intelisoft.jdbc.dao.impl;

import com.inteliSoft.jdbc.entity.GroupEntity;
import com.inteliSoft.jdbc.entity.StudentsEntity;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.api.StudentsDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public class StudentsDaoImpl implements StudentsDao {
    private final Logger logger = Logger.getLogger(StudentsDaoImpl.class);
    Connection conn = DBConnection.getDBConnection();

    public void add(StudentsEntity students) {
        PreparedStatement prst = null;
        String addStudents = "INSERT INTO students (idStudents, firstName, lastName, age, birth, phone, idGroup) VALUES (?,?,?,?,?,?,?)";
        try {
            GroupEntity group = new GroupEntity();
            group.setIdGroup(3);
            prst = conn.prepareStatement(addStudents);
            prst.setInt(1, students.getIdStudents());
            prst.setString(2, students.getFirstName());
            prst.setString(3, students.getLastName());
            prst.setInt(4, students.getAge());
            prst.setString(5, students.getBirth());
            prst.setInt(6, students.getPhone());
            prst.setInt(7, group.getIdGroup());
            prst.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error addStudents", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }

    public List<StudentsEntity> getAll() {
        List<StudentsEntity> studentsList = new ArrayList<StudentsEntity>();
        Statement st = null;
        String getAllStudents = "Select idStudents, firstName, lastName, age, birth, phone from students";
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(getAllStudents);
            while (rs.next()) {
                StudentsEntity students = new StudentsEntity();
                students.setIdStudents(rs.getInt("idStudents"));
                students.setFirstName(rs.getString("firstName"));
                students.setLastName(rs.getString("lastName"));
                students.setAge(rs.getInt("age"));
                students.setBirth(rs.getString("birth"));
                students.setPhone(rs.getInt("phone"));
                studentsList.add(students);
            }

        } catch (SQLException e) {
            logger.error("Error getAllStudents", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
            return studentsList;
        }
    }

    public StudentsEntity getById(int idStudents) {
        PreparedStatement prst = null;
        String getByIdStudents = "SELECT * FROM students where idStudents=?";
        StudentsEntity students = new StudentsEntity();

        try {
            prst = conn.prepareStatement(getByIdStudents);
            prst.setInt(1, idStudents);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                students.setIdStudents(rs.getInt("idStudents"));
                students.setFirstName(rs.getString("firstName"));
                students.setLastName(rs.getString("lastName"));
                students.setAge(rs.getInt("age"));
                students.setBirth(rs.getString("birth"));
                students.setPhone(rs.getInt("phone"));
                System.out.println(students);
            }
        } catch (SQLException e) {
            logger.error("Error getByIdStudents", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
        return students;
    }

    public void update(StudentsEntity students, Connection conn) {
        PreparedStatement prst = null;
        String updateStudents = "UPDATE students SET  firstName=?, lastName=?, age=?, birth=?, phone=?, idGroup=? where idStudents=?";
        try {
            GroupEntity group = new GroupEntity();
            group.setIdGroup(3);
            prst = conn.prepareStatement(updateStudents);
            prst.setString(1, students.getFirstName());
            prst.setString(2, students.getLastName());
            prst.setInt(3, students.getAge());
            prst.setString(4, students.getBirth());
            prst.setInt(5, students.getPhone());
            prst.setInt(6, group.getIdGroup());
            prst.setInt(7, students.getIdStudents());
            prst.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updateStudents", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }

    }

    public void delete(int idStudents, Connection conn) {
        PreparedStatement prst = null;
        String deleteStudents = "DELETE  FROM students where idStudents=?";
        try {
            prst = conn.prepareStatement(deleteStudents);
            prst.setInt(1, idStudents);
            prst.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleteStudents", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }

    }

    public StudentsEntity getWithGroup() {
        StudentsEntity students = new StudentsEntity();
        GroupEntity group = new GroupEntity();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String getWithGroup = "SELECT  students.firstName, students.lastName, groups.teacher  FROM students inner join groups ON students.idGroup = groups.idGroup where groups.idGroup = 3";
            ResultSet rs = statement.executeQuery(getWithGroup);
            while (rs.next()) {
                students.setFirstName(rs.getString("firstName"));
                students.setLastName(rs.getString("lastName"));
                group.setTeacher(rs.getString("teacher"));
                students.setGroup(group);
                System.out.println(students);
            }
        } catch (SQLException e) {
            logger.error("Error getWithGroup", e);}
        return students;
    }

}
