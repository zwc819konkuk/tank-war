package com.zwc.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static final  Properties props = new Properties();

    private PropertyManager(){}



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
    public static int getInt(String key){
        if (props == null) return 0;
        return Integer.parseInt((String)props.get(key));
    }
}
