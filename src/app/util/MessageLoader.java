package app.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zoohwang on 14. 9. 2.
 */
public class MessageLoader {

    private static MessageLoader loader;

    private Properties properties = new Properties();

    public static MessageLoader getInstance() {

        if(loader == null) {

            loader = new MessageLoader();

        }
        return loader;
    }

    public void initProps(String fileName) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(fileName)) {
            properties.loadFromXML(is);
        } finally {

        }
    }

    public String getString(String key) {
        if(properties == null) {
            throw new IllegalStateException("property file is not set");
        }
        return properties.getProperty(key);
    }



}
