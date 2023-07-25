package com.example.mytag.support;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Belitski Marat
 * @date 20.07.2023
 */
public class MyView {
    public List<MyView> valuesViewList;
   private final TextView myTextView;
    private final ImageView myImageView;

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
