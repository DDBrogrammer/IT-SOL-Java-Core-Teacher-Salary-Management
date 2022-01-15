package helper;

import entity.Subject;
import entity.Teacher;

public class ValidateSubject {
    public Boolean validateName( String name){
        if(name.length() == 0){
            System.out.println("Bạn chưa nhập tên môn học");
            return false;
        }else if(
                name.length()>=200
        )  {
            System.out.println("Tên môn học quá dài");
            return  false;
        } else {
            return true;}
    }

    public Boolean validateTotalLesion( int totalLesion ){
        if(totalLesion <= 0){
            System.out.println("Số tiết học phải lớn hơn 0 ");
            return false;
        }else if (totalLesion>=200){
            System.out.println("Số tiết môn học vượt quá số tiết học được dạy");
            return false;
        }else return true;
    }
    public Boolean validateTotalTheoryLesion( int totalLesion, int  totalTheoryLesson  ){
        if(totalLesion <= 0){
            System.out.println("Số tiết học phải lớn hơn 0 ");
            return false;
        }else if (totalTheoryLesson>totalLesion){
            System.out.println("Số tiết học lý thuyết vượt quá tổng số tiết học");
            return false;
        }else return true;
    }
    public Boolean validateExpense( int expense){
        if(expense <= 0){
            System.out.println("Chi phí phải lớn hơn 0 ");
            return false;
        }else return true;
    }
    public Boolean checkSubjectExist(int id, Subject[] subjectList){
        boolean check=false;
        for (int i=0;i<=subjectList.length-1;i++){
            if(subjectList[i].getId()==id){
                check=true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy môn học này");
        }
        return check;
    }
}
