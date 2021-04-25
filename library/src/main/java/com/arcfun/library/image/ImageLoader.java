package com.arcfun.library.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ImageLoader
 */
class ImageLoader {

    //图片缓存
    ICache imageCache = new ImageCache();

    //线程池，线程数量未CPU数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * show image
     *
     * @param url
     * @param imageView
     */
    public void displayImage(final String url, final ImageView imageView) {
        final Bitmap bitmap = imageCache.get(url);
        if (bitmap == null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap1 = downloadImage(url);
                if (bitmap1 == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap1);
                }
                imageCache.put(url, bitmap1);
            }
        });
    }

    /**
     * download bitmap
     *
     * @param imageUrl
     * @return
     */
    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
