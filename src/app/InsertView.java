package app;

import app.util.MessageLoader;
import app.vo.Student;

import java.io.BufferedReader;

/**
 * Created by zoohwang on 14. 8. 28.
 */
public class InsertView {

    private BufferedReader br;
    String userStr;
    Student student;

    MessageLoader loader = MessageLoader.getInstance();

    public InsertView(BufferedReader br, Student student) {
        this.br = br;
        this.student = student;
    }

    public Student insertStudent() {

        System.out.println("========== 학생 등록 ==========");
        System.out.println("1. 이전 메뉴");
        System.out.println("==========================");

        student.setName(inputStudentInfo(loader.getString("name"), loader.getString("errMsg")));
        if(student.getName() == null) return null;
        student.setNo(inputStudentInfo(loader.getString("no"), loader.getString("errMsg")));
        if(student.getNo() == null) return null;
        student.setMajor(inputStudentInfo(loader.getString("major"), loader.getString("errMsg")));
        if(student.getMajor() == null) return null;
        student.setMobile(inputStudentInfo(loader.getString("mobile"), loader.getString("errMsg")));
        if(student.getMobile() == null) return null;

        return student;
    }

    public String inputStudentInfo(String item, String errMsg) {
        String msg = String.format(errMsg,item);
        boolean isNext = false;
            do {
                System.out.print(item);
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

