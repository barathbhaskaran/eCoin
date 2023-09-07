package com.example.vicky.e_coin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class prepaid extends Fragment {
    Button prepidonclick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_prepaid, container, false);

        prepidonclick = (Button)view.findViewById(R.id.prepaidonclick);
        prepidonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Connection to gateway",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
