import entity.ManageTeaching;
import entity.Subject;
import entity.Teacher;
import helper.Helper;
import service.ManageTeachingService;
import service.SubjectService;
import service.TeacherService;

public class Main {
   static Teacher[] teacherList=new Teacher[100];
   static ManageTeaching[] manageTeachingList=new ManageTeaching[100];
   static Subject [] subjectList=new Subject[100];
   static Helper helper=new Helper();
   static ManageTeachingService manageTeachingService= new ManageTeachingService();
   static SubjectService subjectService=new SubjectService();
   static TeacherService teacherService=new TeacherService();
    public static void main(String[] args) {
           subjectService.setTempListData(subjectList);
           teacherService.setTempListData(teacherList);
           manageTeachingService.setTempListData(manageTeachingList);




    }

}
