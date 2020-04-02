package bl;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class InvestingPropertyManager {
    static Logger logger = Logger.getLogger(InvestingPropertyManager.class);
    private static Map<String,String> propertyMap = null;

    public static Map<String,String>  getPropMap() {
        if(propertyMap==null) {
            try {
                propertyMap = getPropValues();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return propertyMap;
    }

    private static Map<String,String> getPropValues() throws IOException {
        Map<String,String> propertyMap = new HashMap<>();
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "investing-config.properties";
            logger.info("reading properties from "+propFileName);
            inputStream = InvestingPropertyManager.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            propertyMap.put("userName",prop.getProperty("userName"));
            propertyMap.put("port",prop.getProperty("port"));
            propertyMap.put("password",prop.getProperty("password"));
            propertyMap.put("max_pool_size",prop.getProperty("max_pool_size"));
            propertyMap.put("driver_class",prop.getProperty("driver_class"));
            propertyMap.put("url",prop.getProperty("url"));
            propertyMap.entrySet().forEach(entry->{
                logger.info("property loaded: "+entry.getKey()+" : "+ entry.getValue());
            });
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propertyMap;
    }
}
