package com.sample.test.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    Properties envProperties = new Properties();
    Properties envSpecProperties = new Properties();

    public static PropertyReader instance;

    InputStream inputStreamConfig;
    InputStream inputStreamEnvSpecConfig;

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }
    public PropertyReader() {
        getEnvironment();
    }

    private void getEnvironment() {
        try {
                inputStreamConfig = PropertyReader.class.getResourceAsStream("/properties/config.properties");
                envProperties.load(inputStreamConfig);
                loadPropertiesPerEnv();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void loadPropertiesPerEnv() {
        try {
            String environment = System.getenv("EnvironmentName");
            if( environment == null ) {
                environment = envProperties.getProperty("environment");
            }
            if (environment.toLowerCase().contains("prodonline") || environment.toLowerCase().equalsIgnoreCase("pr1")) {
                //
            } else if (environment.toLowerCase().contains("prodoffline")) {
               //
            } else {
               //
            }
            envSpecProperties.load(inputStreamEnvSpecConfig);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public String readProperty(String key) { return envProperties.getProperty(key);}
    public String readEnvSpecProperty(String key) {
        return envSpecProperties.getProperty(key);
    }

}
