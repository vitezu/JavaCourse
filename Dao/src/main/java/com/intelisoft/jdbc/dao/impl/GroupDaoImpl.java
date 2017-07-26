package com.intelisoft.jdbc.dao.impl;

import com.inteliSoft.jdbc.entity.Group;
import com.inteliSoft.jdbc.entity.Students;
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
    private Group convertRow(ResultSet rs) throws SQLException {
        Group group = new Group();
        group.setIdGroup(rs.getInt("idGroup"));
        group.setNameGroup(rs.getString("nameGroup"));
        group.setTeacher(rs.getString("teacher"));
        group.setGroupRoom(rs.getInt("groupRoom"));
        group.setSpecialSubj(rs.getString("specialSubj"));
        group.setCounStud(rs.getInt("counStud"));
    return group;
    }
    private void convertGroup(Group group, PreparedStatement prst) throws SQLException {
        prst.setString(1, group.getNameGroup());
        prst.setString(2, group.getTeacher());
        prst.setInt(3, group.getGroupRoom());
        prst.setString(4, group.getSpecialSubj());
        prst.setInt(5, group.getCounStud());
        prst.setInt(6, group.getIdGroup());
        prst.executeUpdate();
    };

    public void add(Group group, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(addGroup);
            convertGroup(group, prst);
            prst.close();
        }

    public List<Group> getAll(Connection conn) throws SQLException {
        List<Group> list = new ArrayList<Group>();
        Statement st = null;
        ResultSet rs = null;
            st = conn.createStatement();
            rs = st.executeQuery(getAllGroups);
            while (rs.next()) {
            Group group = convertRow(rs);
                list.add(group);
            }
                    st.close();
            return list;
        }


    public Group getById(int idGroup, Connection conn) throws SQLException {
        Group group = null;
        PreparedStatement prst = null;
            prst = conn.prepareStatement(getByIdGroup);
            prst.setInt(1, idGroup);
            ResultSet rs = prst.executeQuery();
        while (rs.next()){
            group = convertRow(rs);
}
            prst.close();
        return group;
    }

    public void update(Group group, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(updateGroup);
            convertGroup(group, prst);
                    prst.close();
        }

    public void delete(int idGroup, Connection conn) throws SQLException {
        PreparedStatement prst = null;
            prst = conn.prepareStatement(deleteGroup);
            prst.setInt(1, idGroup);
            prst.executeUpdate();
                    prst.close();
        }

    public Group getWithStudents(Connection conn) throws SQLException {
        Group group = new Group();
        Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getWithStudents);
            if (rs.next()) {
                group.setNameGroup(rs.getString("nameGroup"));
                group.setTeacher(rs.getString("teacher"));
                List<Students> students = new ArrayList<Students>();
                do {
                    Students students1 = new Students();
                    students1.setFirstName(rs.getString("firstName"));
                    students1.setLastName(rs.getString("lastName"));
                    students.add(students1);
                } while (rs.next());
                group.setStudents(students);
            }
        return group;
    }
}