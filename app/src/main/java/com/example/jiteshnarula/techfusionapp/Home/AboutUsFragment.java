package com.example.jiteshnarula.techfusionapp.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiteshnarula.techfusionapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {



    public AboutUsFragment() {
        // Required empty public constructor
    }
    TextView t1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        t1=(TextView) view.findViewById(R.id.AboutUsTextView);
        String str="Technology Fusion is a division of G Systems for training and development. Technology fusion primarily focus on corporate, college, school training and skill enhancement program.We also organize industrial training, vocational training and provide assistance in placement and internship.\n" +
                "\n" +
                "G Systems started in 2011. G Systems works on cutting edge technologies and we have experienced team of different domain and technology.\n" +
                "\n" +
                "G Systems have experts in cloud computing, web application development, application maintenance, application support and android development. It's our efficient and effective solution that has given us satisfied clients. We clearly understood and defined so that automation is really effective and gives the right results.";
        t1.setText(str);

        return view;
    }

}
