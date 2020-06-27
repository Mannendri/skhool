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

public class ExtraCurricularAdapter extends ArrayAdapter<ExtraCurricularItem> {
    public ExtraCurricularAdapter(Context context, ArrayList list){
        super(context,0,list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.extracurricular_item, parent, false);
        ExtraCurricularItem currentItem = getItem(position);
        TextView extracurricularTVname = convertView.findViewById(R.id.name);
        TextView extracurricularTVyears = convertView.findViewById(R.id.years);
        extracurricularTVyears.setText(currentItem.getYears());
        extracurricularTVname.setText(currentItem.getName() );

        return convertView;
    }
}
