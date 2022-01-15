package helper;

import entity.Subject;

public class ValidateManageTeaching {
   public boolean validateNumberOfClass(int numberOfClass){
        if(numberOfClass>3){
            System.out.println("Không được đăng ký quá 3 lớp một môn");
                   return false;
        }else if(numberOfClass<=0){
            System.out.println("Phải đăng ký ít nhất một lớp");
            return false;
        }   else return true ;
    }

   public int countTotalLesson(Subject [] subjectsList, int[] numOfClassList){
       int count=0;
        for(int i=0;i<=subjectsList.length-1;i++){
           count=count+ (subjectsList[i].getTotalLesson()*numOfClassList[i]);
        }
        return count;
    }
   public boolean validateTotalLesson(Subject [] subjectsList, int[] numOfClassList){
        if(countTotalLesson(subjectsList,numOfClassList)>200){
            System.out.println("Đăng ký vượt quá số lượng tiết dạy cho phép");
            return false;
        }else return true;
    }


}
