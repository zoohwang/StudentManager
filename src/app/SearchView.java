package app;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;

/**
 * Created by zoohwang on 14. 9. 1.
 */
public class SearchView {

    BufferedReader br;

    public SearchView(BufferedReader br) {
        this.br = br;
    }

    public String searchStudent() {
        String userStr = "";
        System.out.println("======== 학생 정보 조회 ========");
        System.out.println("1. 이전 메뉴");
        System.out.println("==============================");

        do {
            System.out.print("검색할 학생의 이름 : ");
            try {
                userStr = br.readLine();
                if(userStr.equals("1"))
                    return null;
                if(userStr.equals("")) {
                    System.out.println(Message.ERROR_MSG_NAME);
                } else {
                    return userStr;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(true);
    }
}
