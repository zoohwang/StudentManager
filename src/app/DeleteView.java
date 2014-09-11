package app;

import app.util.MessageLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;

/**
 * Created by zoohwang on 14. 9. 1.
 */
public class DeleteView {

    MessageLoader loader = MessageLoader.getInstance();

    final static Logger logger = LoggerFactory.getLogger(AppMain.class);

    private BufferedReader br;

    public DeleteView(BufferedReader br) {
        this.br = br;
    }

    public String deleteStudent() {
        String userStr = "";
        System.out.println(loader.getString("deleteTitle"));
        System.out.println(loader.getString("back"));
        System.out.println(loader.getString("line"));

        do {
            System.out.print(loader.getString("deleteName"));

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

