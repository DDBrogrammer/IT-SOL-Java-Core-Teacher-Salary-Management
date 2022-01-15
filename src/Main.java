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
        boolean run=true;
        do {
            helper.printMenu();
            int chose=helper.getInt(" ");
            switch(chose) {
                case 1:
                    int chose_1;
                    do {
                        chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm giáo viên.\n"
                                + "[2] Xem danh sách sách.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_1>=1 && chose_1<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_1==1){
                        Teacher[] newTeacherList = teacherService.getInputListEntity(teacherList);
                        teacherService.mergeNewListAndSetId(newTeacherList,teacherList);
                        System.out.println("Thêm mới thành công ");
                    }else if(chose_1==2){
                        teacherService.printListData(teacherList);
                    }else if(chose_1==3){
                        break;
                    }
                    boolean checkContinue_1= helper.askYesNo();
                    if(checkContinue_1){
                        break;
                    } else{run=false;}

                case 2:
                    int chose_2;
                    do {
                        chose_2 = helper.getInt("Nhập lựa chọn:\n"
                                + "[1] Thêm môn học.\n"
                                + "[2] Xem danh sách môn học.\n"
                                + "[3] Quay lại.\n"
                        );
                        if(chose_2>=1 && chose_2<=3){
                            break;
                        }
                        System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                    } while(true);
                    if(chose_2==1){
                        Subject[] newSubjectList = subjectService.getInputListEntity( subjectList);
                        subjectService.mergeNewListAndSetId(newSubjectList,subjectList);
                        System.out.println("Thêm mới thành công ");

                    }else if(chose_2==2){
                        subjectService.printListData(subjectList);
                    }else if(chose_2==3){
                        break;
                    }
                    boolean checkContinue_2= helper.askYesNo();
                    if(checkContinue_2){
                        break;
                    } else{run=false;}
                case 5:
                    run=false;
                    break;
                default:
                    System.out.println("Bạn phải nhập số nguyên trong khoảng từ 1 đến 5");
            }
        }
        while (run);
        System.out.println("Đã thoát chương trình");

    }

}
