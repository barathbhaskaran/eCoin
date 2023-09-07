package com.example.vicky.e_coin;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class fragment_moneytrans extends Fragment {
    ImageView upiid,atm,phone,mail;
    TextView info;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_moneytrans, container, false);
        upiid = (ImageView)view.findViewById(R.id.upiid);
        atm = (ImageView)view.findViewById(R.id.atm);
        phone = (ImageView)view.findViewById(R.id.phone);
        mail = (ImageView)view.findViewById(R.id.mailid);
        info = (TextView)view.findViewById(R.id.info);
        upiid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setVisibility(v.INVISIBLE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_check_container,new upi_id_trans());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setVisibility(v.INVISIBLE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_check_container,new atm_trans());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setVisibility(v.INVISIBLE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_check_container,new phone_trans());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setVisibility(v.INVISIBLE);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_check_container,new mail_trans());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return view;
    }

}
