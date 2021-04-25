package com.arcfun.library.lod;

/**
 * 租户
 */
class Tenant {
    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;
    public static final float diffArea = 0.00001f;

    public void rentRoom(Mediator mediator) {
        mediator.rentOut(roomArea, roomPrice);
    }
}
