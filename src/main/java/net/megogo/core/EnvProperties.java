package net.megogo.core;

import java.util.Properties;

public class EnvProperties {

    private static final String PROPERTIES_FILE = "env.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            PROPERTIES.load(EnvProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    private static String getProperty(String key) {
        if (PROPERTIES.containsKey(key)) {
            return PROPERTIES.getProperty(key);
        } else if (System.getProperties().containsKey(key)) {
            return System.getProperty(key);
        } else {
            throw new RuntimeException("Property not defined: " + key);
        }
    }
}
