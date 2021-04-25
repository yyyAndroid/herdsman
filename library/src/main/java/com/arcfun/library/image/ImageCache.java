package com.arcfun.library.image;

import android.graphics.Bitmap;
import android.util.LruCache;

class ImageCache implements ICache {
    private LruCache<String, Bitmap> mImageCache;

    ImageCache() {
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024 / 4);
        mImageCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getHeight() * value.getRowBytes() / 1024;
            }
        };
    }

    public void put(String key, Bitmap bitmap) {
        mImageCache.put(key, bitmap);
    }

    public Bitmap get(String key) {
        return mImageCache.get(key);
    }
}
