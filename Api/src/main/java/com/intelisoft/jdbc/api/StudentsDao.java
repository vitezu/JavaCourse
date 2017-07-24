package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.StudentsEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public interface StudentsDao {
   void add(StudentsEntity students);
   List<StudentsEntity> getAll();
   StudentsEntity getById(int idStudents);
   void update(StudentsEntity students, Connection conn);
   void delete(int idStudents, Connection conn);
   StudentsEntity getWithGroup();

}
