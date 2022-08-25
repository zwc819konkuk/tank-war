package com.zwc.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }
}
