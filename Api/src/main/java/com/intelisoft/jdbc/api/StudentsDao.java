package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.StudentsEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public interface StudentsDao {
   void add(StudentsEntity students, Connection conn) throws SQLException;
   List<StudentsEntity> getAll(Connection conn) throws SQLException;
   StudentsEntity getById(int idStudents, Connection conn) throws SQLException;
   void update(StudentsEntity students, Connection conn) throws SQLException;
   void delete(int idStudents, Connection conn) throws SQLException;
   List<StudentsEntity> getWithGroup(Connection conn) throws SQLException;

}
