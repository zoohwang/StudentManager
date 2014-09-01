package app.vo;

import sun.nio.cs.ext.MacArabic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zoohwang on 14. 8. 28.
 */
public class Student {

    /**
     * 이름
     */
    String name;

    /**
     * 학과
     */
    String major;

    /**
     * 학번
     */
    String no;

    /**
     * 휴대전화
     */
    String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile.replaceAll("[^\\d]", "");
    }
}
