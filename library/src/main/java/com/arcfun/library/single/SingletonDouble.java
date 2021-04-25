package com.arcfun.library.single;

public class SingletonDouble {
    private static SingletonDouble sInstance = null;

    private SingletonDouble() {

    }

    public void doSomeThing() {
        System.out.println("do sth.");
    }

    public static SingletonDouble getInstance() {
        if (sInstance == null) {
            synchronized (SingletonDouble.class) {
                if (sInstance == null) {
                    sInstance = new SingletonDouble();
                }
            }
        }
        return sInstance;
    }
}
