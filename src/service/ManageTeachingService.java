package service;

import entity.ManageTeaching;
import entity.Subject;
import entity.Teacher;
import helper.Helper;
import helper.ValidateManageTeaching;

public class ManageTeachingService implements BaseService<ManageTeaching>  {

    private TeacherService teacherService=new TeacherService();
    private SubjectService subjectService=new SubjectService();
    private Helper helper = new Helper();
    private ValidateManageTeaching validateManageTeaching=new ValidateManageTeaching();
     public void setTempListData(ManageTeaching[] manageTeachingList){
        Subject[] tempSubjectList= new Subject[99];
        for(int i=0;i<= tempSubjectList.length-1;i++){
            tempSubjectList[i]=new Subject(0,"",0,0,0);
        }
        int [] tempQuantity=new int [99];
        for(int i=0;i<=tempQuantity.length-1;i++){
            tempQuantity[i]=0;
        }
        Teacher tempTeacher=new Teacher("","","",0,"");
        for(int i=0;i<= manageTeachingList.length-1;i++){
            manageTeachingList[i]= new ManageTeaching(tempTeacher,tempSubjectList,tempQuantity);
        }
    }

    public int getTrueListLength(ManageTeaching[] tempManageTeachingList){
        int u=0;
        for(int i=0;i< tempManageTeachingList.length-1; i++){
            if(tempManageTeachingList[i].getTeacher().getId()!=0){
                u++;
            }
        }
        return u;
    }
    @Override
    public void mergeNewListAndSetId(ManageTeaching[] newSubjectList, ManageTeaching[] tempSubjectList) {
    }
    public  void mergeNewData(ManageTeaching borrowBook,ManageTeaching[] tempManageTeachingList){
        boolean check=true;
        for(int i=0;i<=tempManageTeachingList.length-1;i++){
            if(tempManageTeachingList[i].getTeacher().getId()==0 && check==true){
                tempManageTeachingList[i].setNumberOfClass(borrowBook.getNumberOfClass());
                tempManageTeachingList[i].setSubjectList(borrowBook.getSubjectList());
                tempManageTeachingList[i].setTeacher(borrowBook.getTeacher());
                check=false;
            }
        }    }

    @Override
    public void printListData(ManageTeaching[] tempList) {
        System.out.println(tempList.length);
        System.out.println(tempList[0].getSubjectList().length);
        System.out.println(tempList[0].getNumberOfClass().length);
        System.out.println(subjectService.getTrueListLength(tempList[0].getSubjectList()));
        for(int i=0;i<= tempList.length-1;i++){

            if(tempList[i].getTeacher().getId()!=0){

                System.out.println("                                                               ");
                System.out.println(tempList[i].getTeacher().toString());
                for(int u=0;u<= tempList[i].getNumberOfClass().length -1;u++){
                    System.out.println(tempList[i].getSubjectList()[u].toString()+" Số lượng:"+tempList[i].getNumberOfClass()[u]);
                }
                System.out.println("                                                               ");
            }else break;
        }
    }

    public void printListDataByName(ManageTeaching[] manageTeachingList){
        ManageTeaching temp = new ManageTeaching();
        for (int i = 0; i < getTrueListLength(manageTeachingList) - 1; i++) {
            for (int j = i + 1; j < getTrueListLength(manageTeachingList); j++) {
                if (manageTeachingList[i].getTeacher().getName().compareTo(manageTeachingList[j].getTeacher().getName()) > 0) {
                    temp = manageTeachingList[i];
                    manageTeachingList[i] = manageTeachingList[j];
                    manageTeachingList[j] = temp;
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp là :");
        printListData(manageTeachingList);
    }

    public void printListDataByTotalLesson(ManageTeaching[] manageTeachingList){
        ManageTeaching temp = new ManageTeaching();
        for (int i = 0; i < getTrueListLength(manageTeachingList) - 1; i++) {
            for (int j = i + 1; j < getTrueListLength(manageTeachingList); j++) {
                if (validateManageTeaching.countTotalLesson(manageTeachingList[i].getSubjectList(),manageTeachingList[i].getNumberOfClass())<
                        validateManageTeaching.countTotalLesson(manageTeachingList[j].getSubjectList(),manageTeachingList[j].getNumberOfClass())) {
                    temp = manageTeachingList[i];
                    manageTeachingList[i] = manageTeachingList[j];
                    manageTeachingList[j] = temp;
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp là :");
        printListData(manageTeachingList);
    }
    @Override
    public ManageTeaching getInputEntity() {
        return null;
    }

    public  void getInputManageTeaching(Teacher[] teacherList, Subject[] subjectList, ManageTeaching[] manageTeachingList) {
        int numberOfSubjectID;
        int numberOfClass;
        teacherService.printListData(teacherList);
        System.out.println("Chọn từ danh sách giáo viên đã có");
        Teacher teacher=teacherService.getEntityById(teacherList);
        System.out.println("Đã chọn giáo viên dùng: "+teacher.toString());
        do{
            numberOfSubjectID=helper.getInt("Nhập số lượng môn học") ;
            if(numberOfSubjectID > (subjectList.length)){
                System.out.println("Vượt quá số lượng môn hiện có ");
            }else break;
        } while(true);
        Subject[] arrSubject= new Subject[numberOfSubjectID];
        for(int i=0;i<=arrSubject.length-1;i++){
            arrSubject[i]= new Subject(0,"",0,0,0);
        }
        int[] numberOfClassList=new int[numberOfSubjectID];
        for(int i=0;i<=numberOfClassList.length-1;i++){
            numberOfClassList[i]= 0;
        }
        subjectService.printListData(subjectList);
        for(int i=0;i<arrSubject.length;i++){
            System.out.println("Chọn từ danh sách đầu sách đã có");
            Subject subject =subjectService.getEntityById(subjectList);
            System.out.println("Đã chọn môn học: "+subject.toString());
            do{
                numberOfClass= helper.getInt("Nhập số lượng lớp học cần dạy:");
                if(!validateManageTeaching.validateNumberOfClass(numberOfClass)){
                    System.out.println("Vượt quá số lượng được dạy");
                }else if(!validateManageTeaching.validateTotalLesson(arrSubject,numberOfClassList)){
                    System.out.println("");
                }else  break;
            }while(true);
            arrSubject[i].setId(subject.getId());
            arrSubject[i].setName(subject.getName());
            arrSubject[i].setTotalLesson(subject.getTotalLesson());
            arrSubject[i].setTotalTheoryLesson(subject.getTotalTheoryLesson());
            arrSubject[i].setExpense(subject.getExpense());
            numberOfClassList[i]=numberOfClass;
        }
        ManageTeaching borrowBook=new ManageTeaching(teacher,subjectList,numberOfClassList);
        mergeNewData(borrowBook,manageTeachingList);
        System.out.println(borrowBook.toString());


}


   public void printSalary(ManageTeaching[]  manageTeaching){
    for(int i = 0; i<=manageTeaching.length-1;i ++){
        if(manageTeaching[i].getTeacher().getId()!=0){
            System.out.println("                                                             ");
            System.out.println("Giáo viên: "+manageTeaching[i].getTeacher().toString());
            System.out.println("Có tiền lương là: "+countSalary(manageTeaching[i].getSubjectList(),manageTeaching[i].getNumberOfClass()));
            System.out.println("                                                             ");
        }
    }
   }
   public double countSalary(Subject[] subjectList, int[] numberOfClassList){
    double salary=0;
    for(int i = 0;i<=subjectList.length-1;i++){
        salary=((subjectList[i].getTotalLesson()-subjectList[i].getTotalTheoryLesson())*0.7*subjectList[i].getExpense())+
                ((subjectList[i].getTotalTheoryLesson())*subjectList[i].getExpense()) +salary;
    }
    return salary;
   }
}