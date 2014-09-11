package app.dao;

import app.AppMain;
import app.vo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zoohwang on 14. 9. 1.
 */
public class StudentDao {

    final static Logger logger = LoggerFactory.getLogger(AppMain.class);

    private SqlSessionFactory sqlSessionFactory = null;

    public StudentDao(SqlSessionFactory sqlSessionFacroty) {
        this.sqlSessionFactory = sqlSessionFacroty;
    }

    public List<Student> selectAll() {
        List<Student> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Student.selectAll");
        } finally {
            session.close();
        }

        logger.info("selectAll() --> " + list);
        return list;
    }

    public Student selectById(String name) {
        Student student = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            student = session.selectOne("Student.selectById", name);
        } finally {
            session.close();
        }
//        logger.info("selectById(" + name + ") --> " + student);
        logger.info("selectById({}) --> {}", name, student);
        return student;
    }

    public int insert(Student student) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.insert("Student.insert", student);
        } finally {
            session.commit();
            session.close();
        }
        logger.info("insert(" + student + ") --> " + student.getName());
        return id;
    }

    public void update(Student student) {
        int id = -1;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            id = session.update("Student.update", student);
        } finally {
            session.commit();
            session.close();
        }
        logger.info("update(" + student + ") --> updated");
    }

    public void delete(String name) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Student.delete", name);
        } finally {
            session.commit();
            session.close();
        }
        logger.info("delete(" + name + ")");
    }
}
