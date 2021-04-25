package com.arcfun.library.image;

import android.graphics.Bitmap;

public interface ICache {
    public Bitmap get(String url);

    public void put(String url, Bitmap bitmap);
}
