package com.intelisoft.jdbc.services;

import com.inteliSoft.jdbc.entity.Students;
import com.intelisoft.jdbc.api.StudentsDao;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.dao.impl.StudentsDaoImpl;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 18.07.2017.
 */
public class StudentsService {
    private final Logger logger = Logger.getLogger(StudentsService.class);
   private StudentsDao studentsDao = new StudentsDaoImpl();
    Connection conn = DBConnection.getDBConnection();

    public void add(Students students) {
        try {
            studentsDao.add(students, conn);
        } catch (SQLException e) {
            logger.error("Error addStudents", e);
        }
    }

    public void getAll (){
        List<Students> list = null;
        try {
            list = studentsDao.getAll(conn);
        } catch (SQLException e) {
            logger.error("Error getAllStudents", e);
        }
        for (Students a: list){
            System.out.println(a);
        }
    }

    public void getById (int idStudents){
        try {
            System.out.println(studentsDao.getById(idStudents,conn));
        } catch (SQLException e) {
            logger.error("Error getByIdStudents", e);
        }
    }

    public void delete(int idStudents) {
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection();
            conn.setAutoCommit(false);
            studentsDao.delete(idStudents, conn);
            conn.commit();
        } catch (Exception e) {
            logger.error("Error deleteStudents", e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error transaction");
                }
            }
        }
    }

    public  void update(Students students) {
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection();
            conn.setAutoCommit(false);
            studentsDao.update(students, conn);
            conn.commit();
        } catch (Exception e) {
            logger.error("Error updateStudents", e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error transaction");
                }
            }
        }
    }

    public void getWithGroup(){
        List<Students> studentList2 = null;
        try {
            studentList2 = studentsDao.getWithGroup(conn);
        } catch (SQLException e) {
            logger.error("Error getWithGroup", e);
        }
        for (Students a: studentList2){
            System.out.println(a);
        }
    }
}