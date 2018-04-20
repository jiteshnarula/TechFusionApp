package com.example.jiteshnarula.techfusionapp.splash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiteshnarula.techfusionapp.R;

/**
 * Created by krish on 19-04-2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }
    public int[] slide_images={
            R.drawable.ic_workshop_1,
            R.drawable.ic_videos,
            R.drawable.ic_event

    };
    public String[] headings={
            "Workshops",
            "Videos",
            "Events"

    };
    public String[] description={
            "Workshops description",
            "Videos description",
            "Events description"

    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView textView1=(TextView)view.findViewById(R.id.textView1);
        TextView textView2=(TextView)view.findViewById(R.id.textView2);

        imageView.setImageResource(slide_images[position]);
        textView1.setText(headings[position]);
        textView2.setText(description[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
