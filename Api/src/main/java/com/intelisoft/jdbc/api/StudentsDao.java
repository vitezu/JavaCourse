package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.StudentsEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public interface StudentsDao {
   void add(StudentsEntity students, Connection conn);
   List<StudentsEntity> getAll(Connection conn);
   StudentsEntity getById(int idStudents, Connection conn);
   void update(StudentsEntity students, Connection conn);
   void delete(int idStudents, Connection conn);
   List<StudentsEntity> getWithGroup(Connection conn);

}
