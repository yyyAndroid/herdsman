package com.arcfun.library.single;

class SingletonnInner {
    private SingletonnInner() {
    }

    public static SingletonnInner getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final SingletonnInner sInstance = new SingletonnInner();
    }
}
