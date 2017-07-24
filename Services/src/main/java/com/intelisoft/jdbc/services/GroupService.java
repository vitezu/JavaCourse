package com.intelisoft.jdbc.services;

import com.inteliSoft.jdbc.entity.GroupEntity;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.dao.impl.GroupDaoImpl;
import com.intelisoft.jdbc.api.GroupDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Pavel on 20.07.2017.
 */
public class GroupService {
    private GroupDao groupDao = new GroupDaoImpl();

    public void delete(int idGroup) {
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection();
            conn.setAutoCommit(false);
            groupDao.delete(idGroup, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error groupServiceDelete");
                }
            }
        }
    }

    public  void update(GroupEntity group) {
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection();
            conn.setAutoCommit(false);
            groupDao.update(group, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error groupServiceUpdate");
                }
            }
        }
    }
}
