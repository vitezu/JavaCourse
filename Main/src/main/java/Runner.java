import com.inteliSoft.jdbc.entity.Group;
import com.inteliSoft.jdbc.entity.Students;
import com.intelisoft.jdbc.services.GroupService;
import com.intelisoft.jdbc.services.StudentsService;

/**
 * Created by Pavel on 09.07.2017.
 */
public class Runner {

    public static void main(String[] args) {

        StudentsService studentsService = new StudentsService();

        GroupService groupService = new GroupService();

        //Add
        Group group = new Group();
        group.setIdGroup(6);
        group.setNameGroup("3V");
        group.setTeacher("Potapova");
        group.setGroupRoom(505);
        group.setSpecialSubj("Fisics");
        group.setCounStud(29);
        
        Students students = new Students();
        students.setIdStudents(6);
        students.setFirstName("Alesya");
        students.setLastName("Ivanova");
        students.setAge(11);
        students.setBirth("2007.04.10");
        students.setPhone(2958457);

//        studentsService.add(students);
//        groupService.add(group);

        //Get All
        studentsService.getAll();
        System.out.println();
        groupService.getAll();
        System.out.println();

        //Update
        Students students2 = new Students();
        students2.setIdStudents(1);
        students2.setFirstName("Veronika");
        students2.setLastName("Ivanova");
        students2.setAge(11);
        students2.setBirth("2007.04.10");
        students2.setPhone(29586666);

        Group group2 = new Group();
        group2.setIdGroup(1);
        group2.setNameGroup("3D");
        group2.setTeacher("Potapkina");
        group2.setGroupRoom(705);
        group2.setSpecialSubj("Fisics");
        group2.setCounStud(24);

       studentsService.update(students2);
       groupService.update(group2);

        //Inner Join
        groupService.getWithStudents();
          System.out.println();

        studentsService.getWithGroup();
        System.out.println();

        //Delete
        studentsService.delete(2);
        groupService.delete(2);

//      Get byID
        studentsService.getById(3);
        groupService.getById(3);
    }
}
