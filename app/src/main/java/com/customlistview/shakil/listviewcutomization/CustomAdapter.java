package com.customlistview.shakil.listviewcutomization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Shakil on 7/18/2018.
 */

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataModels;
    Context context;

    private static class ViewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;
    }


    public CustomAdapter(Context context,ArrayList<DataModel> data) {
        super(context,R.layout.row_item,data);
        this.dataModels=data;
        this.context=context;
    }

    @Override
    public void onClick(View view) {
        int position= (int) view.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;
        switch (view.getId()){
            case R.id.item_info:
                Toast.makeText(context, "Availability: " +dataModel.getFeature(), Toast.LENGTH_LONG)
                        .show();
                break;
        }
    }

    private int lastposition=-1;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel=getItem(position);
        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        final View result;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            convertView=layoutInflater.inflate(R.layout.row_item,parent,false);
            viewHolder.txtName=convertView.findViewById(R.id.name);
            viewHolder.txtType=convertView.findViewById(R.id.type);
            viewHolder.txtVersion=convertView.findViewById(R.id.version_number);
            viewHolder.info=convertView.findViewById(R.id.item_info);
            result=convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        lastposition = position;

        Animation animation = AnimationUtils.loadAnimation(context, (position > lastposition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
        viewHolder.txtVersion.setText(dataModel.getVersion_number());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }


}
