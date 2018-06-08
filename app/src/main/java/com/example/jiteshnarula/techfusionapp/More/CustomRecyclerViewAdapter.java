package com.example.jiteshnarula.techfusionapp.More;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.splash.SplashActivity;
import com.example.jiteshnarula.techfusionapp.splash.StartActivity;

import java.util.ArrayList;

//class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//    LinearLayout linearLayout;
//    private ItemClickListner itemClickListner;
//
//    public RecyclerViewHolder(View itemView) {
//        super(itemView);
//        linearLayout= (LinearLayout)itemView.findViewById(R.id.linear_layout_more_recyclerview);
//        linearLayout.setOnClickListener(this);
//    }
//
//    public void setItemClickListner(ItemClickListner itemClickListner){
//        this.itemClickListner=itemClickListner;
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        itemClickListner.onClick(v,getAdapterPosition());
//    }
//}

class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView t1;
    ImageView imageView;
    LinearLayout linearLayout;
    private ItemClickListner itemClickListner;
    public SimpleViewHolder(View view) {
        super(view);
        t1=(TextView)view.findViewById(R.id.listTextView);
        imageView=(ImageView)view.findViewById(R.id.listImageView);
        linearLayout= (LinearLayout)itemView.findViewById(R.id.linear_layout_more_recyclerview);
        linearLayout.setOnClickListener(this);
    }

    public void setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner=itemClickListner;
    }


    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v,getAdapterPosition());
    }
}

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter <SimpleViewHolder>{

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

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent moreIntent1 =  new Intent(mContext,AboutUs_Activity.class);
                        mContext.startActivity(moreIntent1);
                        break;
                    case 1:
                        Intent moreIntent2 =  new Intent(mContext,FAQs_Activity.class);
                        mContext.startActivity(moreIntent2);
                        break;
                    case 2:
                        Intent moreIntent3 =  new Intent(mContext,Our_Goal_Activity.class);
                        mContext.startActivity(moreIntent3);
                        break;
                    case 3:
                        Intent moreIntent4 =  new Intent(mContext,Our_Partners_Activity.class);
                        mContext.startActivity(moreIntent4);
                        break;
                    case 4:
                        Intent moreIntent5 =  new Intent(mContext,Contact_Us_Activity.class);
                        mContext.startActivity(moreIntent5);
                        break;
                }


                Toast.makeText(mContext,"click",Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {

        return data.size();
    }




}
