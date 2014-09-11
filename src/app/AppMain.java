package app;

import app.dao.StudentDao;
import app.mybatis.MybatisConnectionFactory;
import app.util.MessageLoader;
import app.vo.Student;
import jdk.nashorn.internal.objects.NativeArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by zoohwang on 14. 8. 28.
 */
public class AppMain {

    final static Logger logger = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {

        MessageLoader loader = MessageLoader.getInstance();

            try {
                loader.initProps("/properties.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        loader.getString("name");

        String userStr;
        int selectNo = 0;


        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        StudentDao studentDao = new StudentDao(MybatisConnectionFactory.getSqlSessionFactory());

        Student student = new Student();
        List<Student> list;

        do {
            System.out.println(loader.getString("line"));
            System.out.println(loader.getString("search"));
            System.out.println(loader.getString("insert"));
            System.out.println(loader.getString("delete"));
            System.out.println(loader.getString("searchAll"));
            System.out.println(loader.getString("end"));
            System.out.println(loader.getString("line"));

            try {
                userStr = br.readLine();

                if(userStr.equals(""))
                    selectNo = 100;
                else
                    selectNo = Integer.parseInt(userStr);

            } catch (Exception e) {
                e.printStackTrace();
            }

            switch (selectNo) {
                case 1:
                    System.out.println(loader.getString("search"));
                    SearchView sv = new SearchView(br);
                    String searchName = sv.searchStudent();
                    student = studentDao.selectById(searchName);

                    System.out.println("조회 결과 : " + student.toString());

                    break;

                case 2:
                    System.out.println(loader.getString("insert"));
//                    Student student = new Student();
                    InsertView iv = new InsertView(br, student);
                    student = iv.insertStudent();
                    if(student != null) {
                        logger.info("insert complet : {}", student.toString());
                    }
                    //DB insert
                    studentDao.insert(student);
                    break;

                case 3:
                    System.out.println(loader.getString("delete"));
                    DeleteView dv = new DeleteView(br);
                    String deleteName = dv.deleteStudent();
                    studentDao.delete(deleteName);
                    break;

                case 4:
                    list = studentDao.selectAll();
                    for(Student s : list) {
                        System.out.println(s.toString());
                    }
                    break;
                case 0:
                    System.out.println(loader.getString("end"));
                    break;

                case 100:
                    System.out.println(loader.getString("selectMenu"));
                    break;

                default:
                    System.out.println(loader.getString("mistake"));
            }

        } while(selectNo != 0);

        System.out.println(loader.getString("off"));
    }
}
