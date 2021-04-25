package com.arcfun.library.image;

import android.graphics.Bitmap;

class DoubleCache implements ICache {

    ICache mMemoryCache = new ImageCache();
    ICache mDiskCache = new DiskCache();

    @Override
    public Bitmap get(String url) {

        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
