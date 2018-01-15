package com.example.myimageloader;

import android.widget.ImageView;

import java.lang.ref.WeakReference;

class ImageRequest {
    String url;
    WeakReference<ImageView> target;
    int width;
    int height;

    private ImageRequest(Builder builder) {
        url = builder.url;
        target = builder.target;
    }

    public static final class Builder {
        private final IMGldr imGldr;
        private String url;
        private WeakReference<ImageView> target;

        Builder(IMGldr imGldr) {
            this.imGldr=imGldr;
        }

        Builder load(String val) {
            url = val;
            return this;
        }

        public void into(ImageView val) {
            target = new WeakReference<>(val);
            imGldr.enqueue(this.build());
        }

        ImageRequest build() {
            return new ImageRequest(this);
        }
    }
}
