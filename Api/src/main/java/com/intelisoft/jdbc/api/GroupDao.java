package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.GroupEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public interface GroupDao {

         void add(GroupEntity group, Connection conn) throws SQLException;
         List<GroupEntity> getAll(Connection conn) throws SQLException;
         GroupEntity getById(int idClass, Connection conn) throws SQLException;
         void update(GroupEntity group, Connection conn) throws SQLException;
         void delete(int idGroup, Connection conn) throws SQLException;
         GroupEntity getWithStudents(Connection conn) throws SQLException;
    }


