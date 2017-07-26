package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.Students;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public interface StudentsDao {
   void add(Students students, Connection conn) throws SQLException;
   List<Students> getAll(Connection conn) throws SQLException;
   Students getById(int idStudents, Connection conn) throws SQLException;
   void update(Students students, Connection conn) throws SQLException;
   void delete(int idStudents, Connection conn) throws SQLException;
   List<Students> getWithGroup(Connection conn) throws SQLException;

}
