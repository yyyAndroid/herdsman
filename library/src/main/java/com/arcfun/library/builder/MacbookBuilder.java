package com.arcfun.library.builder;

class MacbookBuilder extends Builder {

    private Computer mComputer = new MacBook();

    @Override
    public void buildBoard(String board) {
        mComputer.setmBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setmDisplay(display);
    }

    @Override
    public void buildOS() {
        mComputer.setOs();
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
