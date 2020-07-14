package com.example.skhool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CollegeAdapter extends ArrayAdapter<String> {
    public CollegeAdapter(Context context, ArrayList<String> collegesArray) {
        super(context, 0, collegesArray);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.college_list_item,parent, false);
        String currentCollegeName = getItem(position);
        TextView collegeNameTextView = convertView.findViewById(R.id.college_name);
        collegeNameTextView.setText(currentCollegeName);
        return convertView;
    }
}
