package com.example.mytag;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Belitski Marat
 * @date 20.07.2023
 */
public class MyView {
   private TextView myTextView;
    private ImageView myImageView;

    public MyView(TextView myTextView, ImageView myImageView) {
        this.myTextView = myTextView;
        this.myImageView = myImageView;
    }

    public TextView getMyTextView() {
        return myTextView;
    }

    public ImageView getMyImageView() {
        return myImageView;
    }
}
