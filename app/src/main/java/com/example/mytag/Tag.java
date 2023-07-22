package com.example.mytag;

import androidx.annotation.NonNull;

/**
 * @author Belitski Marat
 * @date 19.07.2023
 */
public class Tag {
   private final String textTag;
   private final int imageTag;



    public Tag( String textTag, int imageTag) {
        this.textTag = textTag;
        this.imageTag = imageTag;

    }

    public String getTextTag() {
        return textTag;
    }
    public int getImageTag() {
        return imageTag;
    }

    @NonNull
    @Override
    public String toString() {
        return textTag ;
    }
}
