package app;

/**
 * Created by zoohwang on 14. 8. 29.
 */
public class Message {
    public static final String ERROR_FORMAT = "%s 은(는) 반드시 입력 해야 합니다.";

    public static final String NAME = "이름";
    public static final String NO = "학번";
    public static final String MAJOR = "학과";
    public static final String MOBILE = "전화번호";

    public static final String ERROR_MSG_NAME = String.format(ERROR_FORMAT, NAME);
    public static final String ERROR_MSG_NO = String.format(ERROR_FORMAT, NO);
    public static final String ERROR_MSG_MAJOR = String.format(ERROR_FORMAT, MAJOR);
    public static final String ERROR_MSG_MOBILE = String.format(ERROR_FORMAT, MOBILE);

}
