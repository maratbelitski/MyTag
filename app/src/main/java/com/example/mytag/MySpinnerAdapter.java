package com.example.mytag;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Belitski Marat
 * @date 22.06.2023
 */
public class MySpinnerAdapter extends ArrayAdapter<Object> {


    public MySpinnerAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
