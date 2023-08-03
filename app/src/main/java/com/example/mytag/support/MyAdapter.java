package com.example.mytag.support;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mytag.R;
import java.util.List;

/**
 * @author Belitski Marat
 * @date 02.08.2023
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Language> list;

    public MyAdapter(Context context, int layout, List<Language> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public int getLayout() {
        return layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
       return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Language newList = list.get(position);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        @SuppressLint("ViewHolder")
        View spinner_layout = inflater.inflate(R.layout.layout_spinner_language, parent, false);

        TextView text = spinner_layout.findViewById(R.id.spinner_text);
        text.setText(newList.getName());

        ImageView image  = spinner_layout.findViewById(R.id.spinner_image);
        image.setImageResource(newList.getImage());

        return spinner_layout;
    }
}
