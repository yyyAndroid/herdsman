package com.arcfun.library.single;

class SingletonOne {
    private static SingletonOne instance;

    private SingletonOne() {
    }

    public static synchronized SingletonOne getInstance(){
        if (instance == null){
            instance = new SingletonOne();
        }
        return instance;
    }
}
