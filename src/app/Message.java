package app;

/**
 * Created by zoohwang on 14. 8. 29.
 *
 * [2014.09.11]
 * application 에 사용용되는 문구 및 안내 메시지의 유동 적인 관리를 위해
 * properties.xml 로 대체.(현재 Message classs는 사용하지 않음)
 */
public class Message {
    public static final String ERROR_FORMAT = "%s 은(는) 반드시 입력 해야 합니다.";
    public static final String TEXT_FORMAT = "%-5s";

    public static String NAME;
    public static String NO;
    public static String MAJOR;
    public static String MOBILE;

    public static final String ERROR_MSG_NAME = String.format(ERROR_FORMAT, NAME);
    public static final String ERROR_MSG_NO = String.format(ERROR_FORMAT, NO);
    public static final String ERROR_MSG_MAJOR = String.format(ERROR_FORMAT, MAJOR);
    public static final String ERROR_MSG_MOBILE = String.format(ERROR_FORMAT, MOBILE);

    public static String getNAME() {
        return NAME;
    }

    public static void setNAME(String NAME) {
        Message.NAME = NAME;
    }

    public static String getNO() {
        return NO;
    }

    public static void setNO(String NO) {
        Message.NO = NO;
    }

    public static String getMAJOR() {
        return MAJOR;
    }

    public static void setMAJOR(String MAJOR) {
        Message.MAJOR = MAJOR;
    }

    public static String getMOBILE() {
        return MOBILE;
    }

    public static void setMOBILE(String MOBILE) {
        Message.MOBILE = MOBILE;
    }
}
