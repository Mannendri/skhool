package com.example.mymulti_screenapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.skhool.InfoItem;
import com.example.skhool.R;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<InfoItem> {
    public InfoAdapter(Context context, ArrayList list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.info_list_item, parent, false);
        InfoItem currentInfoItem = getItem(position);

        ImageView infoItemImage = convertView.findViewById(R.id.infoItemImage);
        TextView infoItemTitle = convertView.findViewById(R.id.infoItemTitle);
        TextView infoItemContent = convertView.findViewById(R.id.infoItemContent);

        infoItemImage.setImageResource(currentInfoItem.getImage());
        infoItemTitle.setText(currentInfoItem.getTitle());
        infoItemContent.setText(currentInfoItem.getContent());

        return convertView;
    }
}