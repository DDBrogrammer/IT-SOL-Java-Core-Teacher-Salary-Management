package helper;

import entity.Teacher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTeacher {
    private String PHONE_NUMBER_REGEX= "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    public Boolean validateName( String name){

        if(name.length() == 0){
            System.out.println("Bạn chưa nhập tên giáo viên");
            return false;
        }else if(
                name.length()>=100
        )  {
            System.out.println("Tên giáo viên quá dài");
            return  false;
        } else {
            return true;}
    }

    public Boolean validateAddress( String name){
        if(name.length() == 0){
            System.out.println("Bạn chưa nhập địa chỉ ");
            return false;
        }else if(
                name.length()>=250
        )  {
            System.out.println("Địa chỉ quá dài ");
            return  false;
        } else {
            return true;}
    }
    public Boolean validatePhone(String phone) {
        Pattern p = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher m = p.matcher(phone);
        boolean b = m.matches();
        if(phone.length() == 0){
            System.out.println("Bạn chưa nhập số điện thoại của người đọc");
            return false;
        }else if(
                phone.length()>11
        )  {
            System.out.println("Số điện thoại quá dài");
            return  false;
        } else if( !b){
            System.out.println("Số điện thoại không hợp lệ");
            return false;}
        else{
            return true;

        }    }
    public Boolean validateDegree( String degree){
        if(degree.toUpperCase().equals("GS-TS") ||
                degree.toUpperCase().equals("PGS-TS")||
                degree.toUpperCase().equals("GVC")||
                degree.toUpperCase().equals("TS")
        ){
            return true;
        }   else {
            System.out.println("Chỉ được nhập các mã [GS-TS] Giáo sư tiến sĩ,[PGS-TS] Phó giáo sư tiến sĩ ,[GVC] Giáo viên chính,[TS] Tiến sĩ");
            return false;}
    }

    public Boolean checkTeacherExist(int id, Teacher[] teacherList){
        boolean check=false;
        for (int i=0;i<=teacherList.length-1;i++){
            if(teacherList[i].getId()==id){
                check=true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy giáo viên này");
        }
        return check;
    }

}
