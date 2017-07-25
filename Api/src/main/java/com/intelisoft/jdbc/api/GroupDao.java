package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.GroupEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public interface GroupDao {

         void add(GroupEntity group, Connection conn);
         List<GroupEntity> getAll(Connection conn);
         GroupEntity getById(int idClass, Connection conn);
         void update(GroupEntity group, Connection conn);
         void delete(int idGroup, Connection conn);
         GroupEntity getWithStudents(Connection conn);
    }


