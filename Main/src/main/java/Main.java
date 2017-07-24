import com.inteliSoft.jdbc.entity.GroupEntity;
import com.inteliSoft.jdbc.entity.StudentsEntity;
import com.intelisoft.jdbc.daoimplements.GroupDaoImplement;
import com.intelisoft.jdbc.daoimplements.StudentsDaoImplement;
import com.intelisoft.jdbc.services.GroupService;
import com.intelisoft.jdbc.services.StudentsService;

import java.util.List;

/**
 * Created by Pavel on 09.07.2017.
 */
public class Main {

    public static void main(String[] args) {

        StudentsDaoImplement studentsDao = new StudentsDaoImplement();
        StudentsService studentsService = new StudentsService();

        GroupDaoImplement groupDao = new GroupDaoImplement();
        GroupService groupService = new GroupService();

        //Add
        GroupEntity group = new GroupEntity();
        group.setIdGroup(6);
        group.setNameGroup("3V");
        group.setTeacher("Potapova");
        group.setGroupRoom(505);
        group.setSpecialSubj("Fisics");
        group.setCounStud(29);
        
        StudentsEntity students = new StudentsEntity();
        students.setIdStudents(6);
        students.setFirstName("Alesya");
        students.setLastName("Ivanova");
        students.setAge(11);
        students.setBirth("2007.04.10");
        students.setPhone(2958457);

//        studentsDao.add(students);
//        groupDao.add(group);

        //Get All
        List<StudentsEntity> studentList = studentsDao.getAll();
        for (StudentsEntity a: studentList){
            System.out.println(a);
        }
        System.out.println();

        List<GroupEntity> list = groupDao.getAll();
        for (GroupEntity a: list){
            System.out.println(a);
        }
        System.out.println();

        //Update
        StudentsEntity students2 = new StudentsEntity();
        students2.setIdStudents(1);
        students2.setFirstName("Veronika");
        students2.setLastName("Ivanova");
        students2.setAge(11);
        students2.setBirth("2007.04.10");
        students2.setPhone(29586666);

        GroupEntity group2 = new GroupEntity();
        group2.setIdGroup(1);
        group2.setNameGroup("3D");
        group2.setTeacher("Potapkina");
        group2.setGroupRoom(705);
        group2.setSpecialSubj("Fisics");
        group2.setCounStud(24);

       studentsService.update(students2);
       groupService.update(group2);

        //Inner Join
          groupDao.getWithStudents();
          System.out.println();
          studentsDao.getWithGroup();
          System.out.println();

        //Delete
        studentsService.delete(2);
        groupService.delete(2);

//      Get byID
        studentsDao.getById(3);
        groupDao.getById(3);
    }
}
