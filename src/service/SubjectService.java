package service;

import entity.Subject;
import entity.Teacher;

public class SubjectService implements BaseService<Subject> {
     public void setTempListData(Subject[] subjectList){
        for(int i=0;i<= subjectList.length-1;i++){
            subjectList[i]= new Subject(0,"",0,0,0);
        }
        for(int i=0;i<= 5;i++){
            subjectList[i]=new Subject(100+i,"",i,i,i);
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
        int trueReaderListLength= getTrueListLength(tempSubjectList);
        int newReaderListLength=newSubjectList.length;

        int totalLength= trueReaderListLength+newReaderListLength;
        for(int i=trueReaderListLength;i<= totalLength-1;i++){
            tempSubjectList[i]=new Subject(newSubjectList[t].getId()+id,
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

}
