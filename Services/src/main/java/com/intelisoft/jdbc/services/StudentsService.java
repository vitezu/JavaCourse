package com.intelisoft.jdbc.services;

import com.inteliSoft.jdbc.entity.StudentsEntity;
import com.intelisoft.jdbc.api.StudentsDao;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.dao.impl.StudentsDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 18.07.2017.
 */
public class StudentsService {
   private StudentsDao studentsDao = new StudentsDaoImpl();
    Connection conn = DBConnection.getDBConnection();

    public void add(StudentsEntity students) {
        studentsDao.add(students, conn);
    }

    public void getAll (){
        List<StudentsEntity> list = studentsDao.getAll(conn);
        for (StudentsEntity a: list){
            System.out.println(a);
        }
    }

    public void getById (int idStudents){
        System.out.println(studentsDao.getById(idStudents,conn));
    }

    public void delete(int idStudents) {
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection();
            conn.setAutoCommit(false);
            studentsDao.delete(idStudents, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error studentsServiceDelete");
                }
            }
        }
    }

    public  void update(StudentsEntity students) {
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection();
            conn.setAutoCommit(false);
            studentsDao.update(students, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error studentsServiceUpdate");
                }
            }
        }
    }

    public void getWithGroup(){
        List<StudentsEntity> studentList2 = studentsDao.getWithGroup(conn);
        for (StudentsEntity a: studentList2){
            System.out.println(a);
        }
    }
}