package com.intelisoft.jdbc.api;

import com.inteliSoft.jdbc.entity.GroupEntity;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public interface GroupDao {

        void add(GroupEntity group);
         List<GroupEntity> getAll();
         GroupEntity getById(int idClass);
         void update(GroupEntity group, Connection conn);
         void delete(int idGroup, Connection conn);
         GroupEntity getWithStudents();
    }


