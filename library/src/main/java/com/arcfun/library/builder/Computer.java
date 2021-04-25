package com.arcfun.library.builder;


/**
 * 计算机的抽象类
 */
abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    protected Computer() {
    }


    public String getmBoard() {
        return mBoard;
    }

    /**
     * 设置cpu的核心数
     *
     * @param mBoard
     */
    public void setmBoard(String mBoard) {
        this.mBoard = mBoard;
    }

    public String getmDisplay() {
        return mDisplay;
    }

    public void setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    abstract void setOs();

    public void setmOs(String mOs) {
        this.mOs = mOs;
    }
}
