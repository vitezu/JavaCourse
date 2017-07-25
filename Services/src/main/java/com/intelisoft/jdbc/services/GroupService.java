package com.intelisoft.jdbc.services;

import com.inteliSoft.jdbc.entity.GroupEntity;
import com.intelisoft.jdbc.api.GroupDao;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.dao.impl.GroupDaoImpl;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 20.07.2017.
 */
public class GroupService {
    private final Logger logger = Logger.getLogger(GroupService.class);
    private GroupDao groupDao = new GroupDaoImpl();
    Connection conn = DBConnection.getDBConnection();

    public void add(GroupEntity group) {
        try {
            groupDao.add(group, conn);
        } catch (SQLException e) {
            logger.error("Error addGroup", e);
        }
    }

    public void getAll (){
        List<GroupEntity> list = null;
        try {
            list = groupDao.getAll(conn);
        } catch (SQLException e) {
            logger.error("Error getAllGroups", e);
        }
        for (GroupEntity a: list){
            System.out.println(a);
        }
    }


    public void getById (int idGroup){
        try {
            System.out.println(groupDao.getById(idGroup,conn));
        } catch (SQLException e) {
            logger.error("Error getByIdGroup", e);
        }
    }

    public void delete(int idGroup) {
        try {
            conn.setAutoCommit(false);
            groupDao.delete(idGroup, conn);
            conn.commit();
        } catch (Exception e) {
            logger.error("Error deleteGroup", e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error transaction");
                }
            }
        }
    }

    public  void update(GroupEntity group) {
        try {
            conn.setAutoCommit(false);
            groupDao.update(group, conn);
            conn.commit();
        } catch (Exception e) {
            logger.error("Error updateGroup", e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    logger.error("Error transaction", e);
                }
            }
        }
    }

    public void getWithStudents (){
        try {
            System.out.println(groupDao.getWithStudents(conn));
        } catch (SQLException e) {
            logger.error("Error getWithStudents", e);
        }
    }
}