package app;

import app.Message;

import java.io.BufferedReader;

/**
 * Created by zoohwang on 14. 9. 1.
 */
public class DeleteView {

    private BufferedReader br;

    public DeleteView(BufferedReader br) {
        this.br = br;
    }

    public String deleteStudent() {
        String userStr = "";
        System.out.println("======== 학생 정보 삭제 ========");
        System.out.println("1. 이전 메뉴");
        System.out.println("==============================");

        do {
            System.out.print("삭제할 학생의 이름 : ");

            try {
                userStr = br.readLine();
                if(userStr.equals("1"))
                    return null;
                if(userStr.equals("")) {
                    System.out.println(Message.ERROR_MSG_NAME);
                } else {
                    return userStr;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while(true);
    }
}

