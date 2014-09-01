package app;

import app.dao.StudentDao;
import app.mybatis.MybatisConnectionFactory;
import app.vo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zoohwang on 14. 8. 28.
 */
public class AppMain {

    final static Logger logger = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) {

        String userStr;
        int selectNo = 0;


        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        StudentDao studentDao = new StudentDao(MybatisConnectionFactory.getSqlSessionFactory());

        Student student = new Student();

        do {
            System.out.println("===============================");
            System.out.println("1. 조회");
            System.out.println("2. 등록");
            System.out.println("3. 삭제");
            System.out.println("0. 종료");
            System.out.println("===============================");

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
                    System.out.println("조회");
                    SearchView sv = new SearchView(br);
                    String searchName = sv.searchStudent();
                    student = studentDao.selectById(searchName);
                    if(student != null) {
                        logger.info("조회 결과 : " + student.getName() + " / "
                                + student.getNo() + " / "
                                + student.getMajor() + " / "
                                + student.getMobile());
                    }
                    break;

                case 2:
                    System.out.println("등록");
//                    Student student = new Student();
                    InsertView iv = new InsertView(br, student);
                    student = iv.insertStudent();
                    if(student != null) {
                        logger.info("insert complet : " + student.getName() + " / "
                                + student.getNo() + " / "
                                + student.getMajor() + " / "
                                + student.getMobile());
                    }
                    //DB insert
                    studentDao.insert(student);
                    break;

                case 3:
                    System.out.println("삭제");
                    DeleteView dv = new DeleteView(br);
                    String deleteName = dv.deleteStudent();
                    studentDao.delete(deleteName);
                    break;

                case 0:
                    System.out.println("종료");
                    break;

                case 100:
                    System.out.println("메뉴를 선택 하시오.");
                    break;

                default:
                    System.out.println("잘못 누르셨습니다.");
            }

        } while(selectNo != 0);

        System.out.println("############## System Off ##############");
    }
}
