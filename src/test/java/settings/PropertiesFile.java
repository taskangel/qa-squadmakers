package settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    Properties properties = new Properties();
    FileInputStream inputStream;

    public PropertiesFile(){
        loadProperties();
    }

    public void loadProperties(){
        String location = System.getProperty("user.dir");
        if(properties.isEmpty()){
            try {
                inputStream = new FileInputStream(location+"/src/test/java/settings/config.properties");
                properties.load(inputStream);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key).toLowerCase();
    }

    public boolean getHeadless(){
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }
}
