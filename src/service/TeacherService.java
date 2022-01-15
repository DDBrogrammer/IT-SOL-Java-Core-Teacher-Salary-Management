package service;

import entity.Subject;
import entity.Teacher;
import helper.Helper;
import helper.ValidateSubject;
import helper.ValidateTeacher;

public class TeacherService implements BaseService<Teacher>{
    private Helper helper =new Helper();
    private ValidateTeacher validateTeacher=new  ValidateTeacher();
    public void setTempListData(Teacher[] teacherList){
        for(int i=0;i<= teacherList.length-1;i++){
            teacherList[i]= new Teacher("","","",0,"");
        }
        for(int i=0;i<= 5;i++){
            teacherList[i]= new Teacher("Trường"+i,"Hanoi "+i,"0961130568",100+i,"TS");
        }
    }
    public int getTrueListLength(Teacher[] tempTeacherList){
        int u=0;
        for(int i=0;i< tempTeacherList.length-1; i++){
            if(tempTeacherList[i].getId()!=0){
                u++;
            }
        }
        return u;
    }
    public void mergeNewListAndSetId ( Teacher[] newTeacherList ,Teacher[] tempTeacherList){
        int id=100;
        int t=0;
        int trueReaderListLength= getTrueListLength(tempTeacherList);
        int newReaderListLength=newTeacherList.length;

        int totalLength= trueReaderListLength+newReaderListLength;
        for(int i=trueReaderListLength;i<= totalLength-1;i++){
            tempTeacherList[i]=new Teacher(newTeacherList[t].getName(),
                    newTeacherList[t].getAddress(),
                    newTeacherList[t].getPhone(),
                    trueReaderListLength+id,
                    newTeacherList[t].getDegree());
            t++;
            id++;
        }
    }
    @Override
    public void mergeNewData(Teacher newEntity, Teacher[] tempList) {
    }
    @Override
    public void printListData(Teacher[] tempList) {
        for(int i=0;i<=tempList.length-1;i++){
            if( tempList[i].getId()!=0){
                System.out.println(tempList[i].toString());
            }

        }
    }

    @Override
    public Teacher getInputEntity() {
        String name, address,phone,degree ;

        do {
            name= helper.getString("Nhập tên giáo viên:");
            if (validateTeacher.validateName(name)) {
                break;
            }
        } while (true);

        do {
            address = helper.getString("Nhập địa chỉ giáo viên: ");
            if (validateTeacher.validateAddress(address)) {
                break;
            }
        } while (true);

        do{ phone= helper.getString("Nhập số điện thoại: ");
            if(validateTeacher.validatePhone(phone)){
                break;
            }
        }
        while(true);
        do{ degree= helper.getString("Nhập trình độ:");
            if(validateTeacher.validateDegree(degree)){
                break;
            }
        }
        while(true);
        Teacher newSubject = new Teacher(name,address,phone,1,degree.toUpperCase());
        return newSubject;
    }
    public  Teacher[] getInputListEntity(Teacher[] teacherList ){
        int numberOfTeacher= helper.getInt("Nhập số lượng giáo viên: ");
        Teacher[] newTeacherList= new Teacher[numberOfTeacher];
        for (int i=0;i<=numberOfTeacher-1 ; i++){
            newTeacherList[i]= getInputEntity();
        }
        return newTeacherList;
    }
    public Teacher getEntityById(Teacher[] teacherList ){
        Teacher teacher=new Teacher("","","",0,"");
        int teacherId;
        do{
            teacherId= helper.getInt("Nhập id người đọc");
            if(validateTeacher.checkTeacherExist(teacherId,teacherList)){
                break;
            }
        }while(true);
        for(int i=0;i<=teacherList.length-1;i++){
            if(teacherList[i].getId()== teacherId){
                teacher.setId(teacherId);
                teacher.setName(teacherList[i].getName());
                teacher.setAddress(teacherList[i].getAddress());
                teacher.setPhone(teacherList[i].getPhone());
                teacher.setDegree(teacherList[i].getDegree());
            }
        }
        return teacher;


    }
}
