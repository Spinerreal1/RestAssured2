package org.test.props;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static Properties prop;

    public  static Properties getConfiguration(){
        return getConfiguration("config.properties");
    }

    @SneakyThrows
    public static Properties getConfiguration(String filename) {
            try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream(filename)){
                if(input == null) {
                    throw new IllegalArgumentException("unable to find" + filename);
                  }
                prop = new Properties();
                prop.load(input);
            }
            return prop;
    }
}
