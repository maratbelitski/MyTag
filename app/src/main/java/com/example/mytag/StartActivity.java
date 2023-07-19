package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    FrameLayout frameLayout1, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6,
            frameLayout7, frameLayout8, frameLayout9, frameLayout10, frameLayout11, frameLayout12,
            frameLayout13, frameLayout14, frameLayout15, frameLayout16;

    ImageView image1, image2, image3, image4, image5, image6, image7, image8,
            image9, image10, image11, image12, image13, image14, image15, image16;
    TextView text1, text2, text3, text4, text5, text6, text7, text8,
            text9, text10, text11, text12, text13, text14, text15, text16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        frameLayout1 = findViewById(R.id.frameLayout1);
        frameLayout2 = findViewById(R.id.frameLayout2);
        frameLayout3 = findViewById(R.id.frameLayout3);
        frameLayout4 = findViewById(R.id.frameLayout4);
        frameLayout5 = findViewById(R.id.frameLayout5);
        frameLayout6 = findViewById(R.id.frameLayout6);
        frameLayout7 = findViewById(R.id.frameLayout7);
        frameLayout8 = findViewById(R.id.frameLayout8);
        frameLayout9 = findViewById(R.id.frameLayout9);
        frameLayout10 = findViewById(R.id.frameLayout10);
        frameLayout11 = findViewById(R.id.frameLayout11);
        frameLayout12 = findViewById(R.id.frameLayout12);
        frameLayout13 = findViewById(R.id.frameLayout13);
        frameLayout14 = findViewById(R.id.frameLayout14);
        frameLayout15 = findViewById(R.id.frameLayout15);
        frameLayout16 = findViewById(R.id.frameLayout16);

        image1 = findViewById(R.id.image1);
        image1.setImageResource(R.drawable.hex_tag);
        image2 = findViewById(R.id.image2);
        image2.setImageResource(R.drawable.hex_tag);
        image3 = findViewById(R.id.image3);
        image3.setImageResource(R.drawable.hex_tag);
        image4 = findViewById(R.id.image4);
        image4.setImageResource(R.drawable.hex_tag);
        image5 = findViewById(R.id.image5);
        image5.setImageResource(R.drawable.hex_tag);
        image6 = findViewById(R.id.image6);
        image6.setImageResource(R.drawable.hex_tag);
        image7 = findViewById(R.id.image7);
        image7.setImageResource(R.drawable.hex_tag);
        image8 = findViewById(R.id.image8);
        image8.setImageResource(R.drawable.hex_tag);
        image9 = findViewById(R.id.image9);
        image9.setImageResource(R.drawable.hex_tag);
        image10 = findViewById(R.id.image10);
        image10.setImageResource(R.drawable.hex_tag);
        image11 = findViewById(R.id.image11);
        image11.setImageResource(R.drawable.hex_tag);
        image12 = findViewById(R.id.image12);
        image12.setImageResource(R.drawable.hex_tag);
        image13 = findViewById(R.id.image13);
        image13.setImageResource(R.drawable.hex_tag);
        image14 = findViewById(R.id.image14);
        image14.setImageResource(R.drawable.hex_tag);
        image15 = findViewById(R.id.image15);
        image15.setImageResource(R.drawable.hex_tag);
        image16 = findViewById(R.id.image16);
        image16.setImageResource(R.mipmap.ic_launcher_foreground);

        text1 = findViewById(R.id.text1);
        text1.setText(R.string.number1);
        text2 = findViewById(R.id.text2);
        text2.setText(R.string.number2);
        text3 = findViewById(R.id.text3);
        text3.setText(R.string.number3);
        text4 = findViewById(R.id.text4);
        text4.setText(R.string.number4);
        text5 = findViewById(R.id.text5);
        text5.setText(R.string.number5);
        text6 = findViewById(R.id.text6);
        text6.setText(R.string.number6);
        text7 = findViewById(R.id.text7);
        text7.setText(R.string.number7);
        text8 = findViewById(R.id.text8);
        text8.setText(R.string.number8);
        text9 = findViewById(R.id.text9);
        text9.setText(R.string.number9);
        text10 = findViewById(R.id.text10);
        text10.setText(R.string.number10);
        text11 = findViewById(R.id.text11);
        text11.setText(R.string.number11);
        text12 = findViewById(R.id.text12);
        text12.setText(R.string.number12);
        text13= findViewById(R.id.text13);
        text13.setText(R.string.number13);
        text14 = findViewById(R.id.text14);
        text14.setText(R.string.number14);
        text15 = findViewById(R.id.text15);
        text15.setText(R.string.number15);
        text16 = findViewById(R.id.text16);
        text16.setText(R.string.numberEmpty);


        Tag[][] matrixWin = {
                {new Tag(1, frameLayout1, text1, image1), new Tag(2, frameLayout2, text2, image2), new Tag(3, frameLayout3, text3, image3), new Tag(4, frameLayout4, text4, image4)},
                {new Tag(5, frameLayout5, text5, image5), new Tag(6, frameLayout6, text6, image6), new Tag(7, frameLayout7, text7, image7), new Tag(8, frameLayout8, text8, image8)},
                {new Tag(9, frameLayout9, text9, image9), new Tag(10, frameLayout10, text10, image10), new Tag(11, frameLayout11, text11, image11), new Tag(12, frameLayout12, text12, image12)},
                {new Tag(13, frameLayout13, text13, image13), new Tag(14, frameLayout14, text14, image14), new Tag(15, frameLayout15, text15, image15), new Tag(16, frameLayout16, text16, image16)}
        };

    }


    public void showMove(View view) {
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.right_animation);
//        frameLayout15.startAnimation(animation);
        if (view.equals(frameLayout15)) {
            image15.setImageResource(R.mipmap.ic_launcher_foreground);
            text15.setText(R.string.numberEmpty);
            image16.setImageResource(R.drawable.hex_tag);
            text16.setText(R.string.number15);
        } else if (view.equals(frameLayout16)) {
            image16.setImageResource(R.mipmap.ic_launcher_foreground);
            text16.setText(R.string.numberEmpty);
            image15.setImageResource(R.drawable.hex_tag);
            text15.setText(R.string.number15);
        }
    }
}