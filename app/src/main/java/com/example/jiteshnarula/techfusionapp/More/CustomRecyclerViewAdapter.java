package com.example.jiteshnarula.techfusionapp.More;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiteshnarula.techfusionapp.R;

import java.util.ArrayList;



public class CustomRecyclerViewAdapter extends RecyclerView.Adapter <CustomRecyclerViewAdapter.SimpleViewHolder>{

    Context mContext;
    ArrayList<String> data;
    ArrayList<Integer> imageArrayList;
    //LayoutInflater inflater;


    public CustomRecyclerViewAdapter(Context mContext, ArrayList<String> data,ArrayList<Integer> imageArrayList) {
        Log.d("krishna", "onCreate: In Custom Constructor" +data);
        this.mContext = mContext;
        this.data = data;
        this.imageArrayList=imageArrayList;
    }


    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("krishna", "onCreate: Adapter Activity class started");
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        Log.d("krishna", "onCreate: Adapter Activity class started : "+data.get(position));
        holder.t1.setText(data.get(position));
        holder.imageView.setImageResource(imageArrayList.get(position));
    }



    @Override
    public int getItemCount() {

        return data.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView imageView;
        public SimpleViewHolder(View view) {
            super(view);
             t1=(TextView)view.findViewById(R.id.listTextView);
             imageView=(ImageView)view.findViewById(R.id.listImageView);
        }
    }
}
