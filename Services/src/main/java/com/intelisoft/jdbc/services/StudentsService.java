package com.intelisoft.jdbc.services;

import com.inteliSoft.jdbc.entity.StudentsEntity;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.daoimplements.StudentsDaoImplement;
import com.intelisoft.jdbc.daointerfaces.DaoStudentsInterface;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Pavel on 18.07.2017.
 */
public class StudentsService {
   private DaoStudentsInterface studentsDao = new StudentsDaoImplement();

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
}