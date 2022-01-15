package service;

import entity.Subject;
import entity.Teacher;

public class TeacherService implements BaseService<Teacher>{
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
}
