package com.example.vicky.e_coin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class utilityfrag1 extends Fragment {
    Button postpaid,prepaid_1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_utilityfrag1, container, false);
        postpaid = (Button)view.findViewById(R.id.postpaid);
        //prepaid_1 = (Button)view.findViewById(R.id.prepaid);

        postpaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postpaid.setVisibility(v.INVISIBLE);
                //prepaid_1.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.postpaid_container,new postpaid());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }


}
