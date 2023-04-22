package dev.isnotnull.utils;

import java.util.HashMap;

public class SessionUtils {

    private HashMap<Object, Object> session;

    public static final String TEST_KEY="testKey";

    public SessionUtils(){
        session = new HashMap<>();
    }

    public void put(String key, String value){
        session.put(key, value);
    }

    public void put(String key, int value){
        session.put(key, value);
    }

    public void put(String key, boolean value){
        session.put(key, value);
    }

    public Object get(String key){
        return session.get(key);
    }

    public Boolean contains(String key){
        return session.containsKey(key);
    }

    public void remove(String key){
        session.remove(key);
    }

    public void clear(){
        session.clear();
    }

}
