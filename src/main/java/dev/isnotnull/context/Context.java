package dev.isnotnull.context;

import dev.isnotnull.utils.SessionUtils;

public class Context {

    private SessionUtils mySession;
    public Context(SessionUtils theSession){
        mySession = theSession;
    }

    public SessionUtils getSession(){
        return mySession;
    }
}
