package com.intelisoft.jdbc.dao.impl;

import com.inteliSoft.jdbc.entity.GroupEntity;
import com.inteliSoft.jdbc.entity.StudentsEntity;
import com.intelisoft.jdbc.api.GroupDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public class GroupDaoImpl implements GroupDao {
    private final Logger logger = Logger.getLogger(GroupDaoImpl.class);
    private final String addGroup = "INSERT INTO groups (nameGroup, teacher, groupRoom, specialSubj, counStud, idGroup) VALUES (?,?,?,?,?,?)";
    private final String getAllGroups = "Select idGroup, nameGroup, teacher, groupRoom, specialSubj, counStud from groups ";
    private final String getByIdGroup = "SELECT idGroup, nameGroup, teacher, groupRoom, specialSubj, counStud FROM groups where idGroup=?";
    private final String updateGroup = "UPDATE groups SET  nameGroup=?, teacher=?, groupRoom=?, specialSubj=?, counStud=? where idGroup=?";
    private final String deleteGroup = "DELETE FROM groups where idGroup=?";
    private final String getWithStudents = "SELECT  groups.nameGroup, groups.teacher, students.firstName, students.lastName FROM groups inner join students ON students.idGroup = groups.idGroup where groups.idGroup = 3";
    private GroupEntity convertRow(ResultSet rs) throws SQLException {
        GroupEntity group = new GroupEntity();
        group.setIdGroup(rs.getInt("idGroup"));
        group.setNameGroup(rs.getString("nameGroup"));
        group.setTeacher(rs.getString("teacher"));
        group.setGroupRoom(rs.getInt("groupRoom"));
        group.setSpecialSubj(rs.getString("specialSubj"));
        group.setCounStud(rs.getInt("counStud"));
    return group;
    }
    private void convertGroup(GroupEntity group, PreparedStatement prst) throws SQLException {
        prst.setString(1, group.getNameGroup());
        prst.setString(2, group.getTeacher());
        prst.setInt(3, group.getGroupRoom());
        prst.setString(4, group.getSpecialSubj());
        prst.setInt(5, group.getCounStud());
        prst.setInt(6, group.getIdGroup());
        prst.executeUpdate();
    };


    public void add(GroupEntity group, Connection conn) {
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(addGroup);
            convertGroup(group, prst);
        } catch (SQLException e) {
            logger.error("Error addGroup", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }

    public List<GroupEntity> getAll(Connection conn) {
        List<GroupEntity> list = new ArrayList<GroupEntity>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(getAllGroups);
            while (rs.next()) {
            GroupEntity group = convertRow(rs);
                list.add(group);
            }
        } catch (SQLException e) {
            logger.error("Error getAllGroups", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
            return list;
        }
    }

    public GroupEntity getById(int idGroup, Connection conn) {
        GroupEntity group = null;
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(getByIdGroup);
            prst.setInt(1, idGroup);
            ResultSet rs = prst.executeQuery();
        while (rs.next()){
            group = convertRow(rs);
}
        } catch (SQLException e) {
            logger.error("Error getByIdGroup", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
        return group;
    }

    public void update(GroupEntity group, Connection conn) {
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(updateGroup);
            convertGroup(group, prst);
        } catch (SQLException e) {
            logger.error("Error updateGroup", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }

    public void delete(int idGroup, Connection conn) {
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement(deleteGroup);
            prst.setInt(1, idGroup);
            prst.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleteGroup", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }

    public GroupEntity getWithStudents(Connection conn) {
        GroupEntity group = new GroupEntity();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getWithStudents);
            if (rs.next()) {
                group.setNameGroup(rs.getString("nameGroup"));
                group.setTeacher(rs.getString("teacher"));
                List<StudentsEntity> students = new ArrayList<StudentsEntity>();
                do {
                    StudentsEntity students1 = new StudentsEntity();
                    students1.setFirstName(rs.getString("firstName"));
                    students1.setLastName(rs.getString("lastName"));
                    students.add(students1);
                } while (rs.next());
                group.setStudents(students);
            }
        } catch (SQLException e) {
            logger.error("Error getWithStudents", e);
        }
        return group;
    }
}