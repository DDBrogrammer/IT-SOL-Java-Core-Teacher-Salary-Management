package service;

import entity.ManageTeaching;
import entity.Subject;
import entity.Teacher;

public class ManageTeachingService implements BaseService<ManageTeaching>  {
     public void setTempListData(ManageTeaching[] manageTeachingList){
        Subject[] tempSubjectList= new Subject[100];
        for(int i=0;i<= tempSubjectList.length-1;i++){
            tempSubjectList[i]=new Subject(0,"",0,0,0);
        }
        int [] tempQuantity=new int [100];
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
        for(int i=0;i<=tempList.length-1;i++){
            System.out.println(tempList[i].toString());
        }
    }

    @Override
    public ManageTeaching getInputEntity() {
        return null;
    }

}
