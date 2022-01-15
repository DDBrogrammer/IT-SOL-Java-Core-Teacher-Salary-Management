package service;

import entity.Subject;
import helper.Helper;
import helper.ValidateSubject;

public class SubjectService implements BaseService<Subject> {
    private Helper helper =new Helper();
    private ValidateSubject validateSubject=new  ValidateSubject();
     public void setTempListData(Subject[] subjectList){
        for(int i=0;i<= subjectList.length-1;i++){
            subjectList[i]= new Subject(0,"",0,0,0);
        }
        for(int i=0;i<= 5;i++){
            subjectList[i]=new Subject(100+i,"Lập trình "+i+1,i+9,i+6,i+1000);
        }
    }
    public int getTrueListLength(Subject[] tempSubjectList){
        int u=0;
        for(int i=0;i< tempSubjectList.length-1; i++){
            if(tempSubjectList[i].getId()!=0){
                u++;
            }

        }
        return u;
    }
    public void mergeNewListAndSetId ( Subject[] newSubjectList ,Subject[] tempSubjectList){
        int id=100;
        int t=0;
        int trueSubjectListLength= getTrueListLength(tempSubjectList);
        int newSubjectListLength=newSubjectList.length;
        int totalLength= trueSubjectListLength+newSubjectListLength;
        for(int i=trueSubjectListLength;i<= totalLength-1;i++){
            tempSubjectList[i]=new Subject(newSubjectList[t].getId()+id+trueSubjectListLength-1,
                    newSubjectList[t].getName(),
                    newSubjectList[t].getTotalLesson(),
                    newSubjectList[t].getTotalTheoryLesson(),
                    newSubjectList[t].getExpense());
            t++;
            id++;
        }
    }
    @Override
    public void mergeNewData(Subject newEntity, Subject[] tempList) {
    }
    @Override
    public void printListData(Subject[] tempList) {
        for(int i=0;i<=tempList.length-1;i++){
            if( tempList[i].getId()!=0){
                System.out.println(tempList[i].toString());
            }

        }
    }

    @Override
    public Subject getInputEntity() {
        String name ;
        int totalLesson ,totalTheoryLesson,expense;
        do {
            name= helper.getString("Nhập tên môn học:");
            if (validateSubject.validateName(name)) {
                break;
            }
        } while (true);

        do {
            totalLesson = helper.getInt("Nhập tổng số tiết học: ");
            if (validateSubject.validateTotalLesion(totalLesson)) {
                break;
            }
        } while (true);

        do{ totalTheoryLesson= helper.getInt("Nhập số tiết lý thuyết: ");
            if(validateSubject.validateTotalTheoryLesion(totalLesson,totalTheoryLesson)){
                break;
            }
        }
        while(true);
        do{ expense= helper.getInt("Nhập chi phí:");
            if(validateSubject.validateExpense(expense)){
                break;
            }
        }
        while(true);
        Subject newSubject = new Subject(1, name,totalLesson,totalTheoryLesson,expense);
        return newSubject;
    }
    public  Subject[] getInputListEntity(Subject[] subjectList ){
        int numberOfSubject= helper.getInt("Nhập số lượng môn học: ");
        Subject[] newSubjectList= new Subject[numberOfSubject];
        for (int i=0;i<=numberOfSubject-1 ; i++){
            newSubjectList[i]= getInputEntity();
        }
        return newSubjectList;
    }




}
