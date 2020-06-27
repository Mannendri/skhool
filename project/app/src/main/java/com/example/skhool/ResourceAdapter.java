package com.example.skhool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ResourceAdapter extends ArrayAdapter<ResourceItem> {

    public ResourceAdapter(Context context, ArrayList list){
        super(context,0,list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_item, parent, false);
        ResourceItem currentResourceItem = getItem(position);
        TextView resourceItemTextViewTitle = convertView.findViewById(R.id.resource_item_title);
        TextView resourceItemTextViewURL = convertView.findViewById(R.id.resource_item_url);
        resourceItemTextViewTitle.setText(currentResourceItem.getTitle() );
        resourceItemTextViewURL.setText(currentResourceItem.getUrl() );
        return convertView;
    }
}
