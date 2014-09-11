package app;

import app.vo.Student;

import java.io.BufferedReader;

/**
 * Created by zoohwang on 14. 8. 28.
 */
public class InsertView {

    private BufferedReader br;
    String userStr;
    Student student;

    public InsertView(BufferedReader br, Student student) {
        this.br = br;
        this.student = student;
    }

    public Student insertStudent() {

        System.out.println("========== 학생 등록 ==========");
        System.out.println("1. 이전 메뉴");
        System.out.println("==============================");

        student.setName(inputStudentInfo(Message.NAME, Message.ERROR_MSG_NAME));
        if(student.getName() == null) return null;
        student.setNo(inputStudentInfo(Message.NO, Message.ERROR_MSG_NO));
        if(student.getNo() == null) return null;
        student.setMajor(inputStudentInfo(Message.MAJOR, Message.ERROR_MSG_MAJOR));
        if(student.getMajor() == null) return null;
        student.setMobile(inputStudentInfo(Message.MOBILE, Message.ERROR_MSG_MOBILE));
        if(student.getMobile() == null) return null;

        return student;
    }

    public String inputStudentInfo(String item, String msg) {

        boolean isNext = false;
        String title = String.format(Message.TEXT_FORMAT, item);
            do {
                System.out.print(title);
                try {
                    userStr = br.readLine();
                    if(userStr.equals("1"))
                        return null;
                    if(userStr.equals("")) {
                        System.out.println(msg);
                    } else {
                        isNext = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while(!isNext);

        return userStr;
    }
}

