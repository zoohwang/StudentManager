package app;

import app.util.MessageLoader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by zoohwang on 14. 9. 1.
 */
public class SearchView {

    MessageLoader loader = MessageLoader.getInstance();

    BufferedReader br;

    public SearchView(BufferedReader br) {
        this.br = br;
    }

    public String searchStudent() {
        String userStr = "";
        System.out.println(loader.getString("searchTitle"));
        System.out.println(loader.getString("back"));
        System.out.println(loader.getString("line"));

        do {
            System.out.print(loader.getString("searchName"));
            try {
                userStr = br.readLine();
                if(userStr.equals("1"))
                    return null;
                if(userStr.equals("")) {
                    System.out.println(String.format(loader.getString("errMsg"), loader.getString("name")));
                } else {
                    return userStr;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(true);
    }
}
