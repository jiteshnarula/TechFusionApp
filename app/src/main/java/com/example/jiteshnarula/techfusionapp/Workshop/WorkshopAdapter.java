package com.example.jiteshnarula.techfusionapp.Workshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiteshnarula.techfusionapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.WorkshopViewHolder>{

    private Context mContext;
    private List<Workshop> workshopList;

    public WorkshopAdapter(Context mContext, List<Workshop> workshopList) {
        this.mContext = mContext;
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public WorkshopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_recyclerview_view,null);
        WorkshopViewHolder workshopViewHolder = new WorkshopViewHolder(view);
        return  workshopViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopViewHolder holder, int position) {


        Workshop workshop = workshopList.get(position);
        holder.nameTextView.setText(workshop.getName());
        holder.priceTextView.setText(String.valueOf(workshop.getPrice()));

      
        Picasso.get()
                .load("http://192.168.56.1/TechFusion/images/"+workshop.getPhoto())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    class WorkshopViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameTextView,priceTextView;


        public WorkshopViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.workshopImageView);
            nameTextView = itemView.findViewById(R.id.titleTextView);
            priceTextView = itemView.findViewById(R.id.textViewPrice);

        }
    }



}
