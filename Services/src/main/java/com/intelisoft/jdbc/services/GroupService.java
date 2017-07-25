package com.intelisoft.jdbc.services;

import com.inteliSoft.jdbc.entity.GroupEntity;
import com.intelisoft.jdbc.api.GroupDao;
import com.intelisoft.jdbc.connection.DBConnection;
import com.intelisoft.jdbc.dao.impl.GroupDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel on 20.07.2017.
 */
public class GroupService {
    private GroupDao groupDao = new GroupDaoImpl();
    Connection conn = DBConnection.getDBConnection();

    public void add(GroupEntity group) {
      groupDao.add(group, conn);
    }

    public void getAll (){
        List<GroupEntity> list = groupDao.getAll(conn);
        for (GroupEntity a: list){
            System.out.println(a);
        }
    }

    public void getById (int idGroup){
        System.out.println(groupDao.getById(idGroup,conn));
    }

    public void delete(int idGroup) {
        try {
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
        try {
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

    public void getWithStudents (){
        System.out.println(groupDao.getWithStudents(conn));
    }
}