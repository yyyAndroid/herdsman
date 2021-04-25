package com.arcfun.library.builder;

class Direct {
    Builder builder = null;

    public Direct(Builder builder) {
        this.builder = builder;
    }

    public void construct(String board, String display) {
        builder.buildBoard(board);
        builder.buildDisplay(display);
        builder.buildOS();
    }
}
