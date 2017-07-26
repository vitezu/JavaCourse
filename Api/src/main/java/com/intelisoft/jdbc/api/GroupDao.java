package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.Group;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public interface GroupDao {

         void add(Group group, Connection conn) throws SQLException;
         List<Group> getAll(Connection conn) throws SQLException;
         Group getById(int idClass, Connection conn) throws SQLException;
         void update(Group group, Connection conn) throws SQLException;
         void delete(int idGroup, Connection conn) throws SQLException;
         Group getWithStudents(Connection conn) throws SQLException;
    }


