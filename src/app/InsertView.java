package app;

import app.util.MessageLoader;
import app.vo.Student;

import java.io.BufferedReader;

/**
 * Created by zoohwang on 14. 8. 28.
 */
public class InsertView {

    MessageLoader loader = MessageLoader.getInstance();

    private BufferedReader br;
    String userStr;
    Student student;

    public InsertView(BufferedReader br, Student student) {
        this.br = br;
        this.student = student;
    }

    public Student insertStudent() {

        System.out.println(loader.getString("insertTitle"));
        System.out.println(loader.getString("back"));
        System.out.println(loader.getString("line"));

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

    public String inputStudentInfo(String item, String msg) {

        boolean isNext = false;

        // 입력 항목의 열을 맞추기 위해 format을 %-5s로 설정.
        String title = String.format(loader.getString("textFormat"), item);
        do {
            System.out.print(title);
            try {
                userStr = br.readLine();
                if(userStr.equals("1"))
                    return null;
                if(userStr.equals("")) {
                    System.out.println(String.format(msg, item));
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

