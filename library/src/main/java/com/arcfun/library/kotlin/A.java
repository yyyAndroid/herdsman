package com.arcfun.library.kotlin;

class A implements AInterface {
    @Override
    public void putNumber(int num) {
        System.out.println("int");
    }

    @Override
    public void putNumber(Integer integer) {
        System.out.println("integer");
    }
}
