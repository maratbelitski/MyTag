package com.example.mytag;

import android.text.Layout;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Belitski Marat
 * @date 19.07.2023
 */
public class Tag {
   private int number;
   private FrameLayout layout;
   private TextView text;
   private ImageView image;


    public Tag(int number, FrameLayout layout, TextView text, ImageView image) {
        this.number = number;
        this.layout = layout;
        this.text = text;
        this.image = image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public FrameLayout getLayout() {
        return layout;
    }

    public void setLayout(FrameLayout layout) {
        this.layout = layout;
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView text) {
        this.text = text;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
