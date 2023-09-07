package com.example.vicky.e_coin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.example.vicky.e_coin.R;

import java.util.ArrayList;

public class recycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<models> imageModelArrayList;
    private modeladapter adapter;

    private int[] myImageList = new int[]{R.drawable.parrot, R.drawable.anchor,R.drawable.bird, R.drawable.girl};
    private String[] myImageNameList = new String[]{"Money Transfer","Wallet Maintenance" ,"Payment Utilities","Ticket Booking"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        imageModelArrayList = initialize();
        adapter = new modeladapter(this, imageModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplication(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                       if(position==0){
                           Intent moneytransint = new Intent(view.getContext(),fragmentholder.class);
                           startActivity(moneytransint);
                        }
                        if(position==1){
                            Intent maintainint = new Intent(view.getContext(),maintain.class);
                            startActivity(maintainint);
                        }
                        if(position==2){
                            Intent utility =  new Intent(view.getContext(),payment_utility.class);
                            startActivity(utility);
                        }
                        if(position==3){
                            Intent ticketint = new Intent(view.getContext(),ticket.class);
                            startActivity(ticketint);
                        }
                    }
                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private ArrayList<models> initialize(){

        ArrayList<models> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            models fruitModel = new models();
            fruitModel.setName(myImageNameList[i]);
            fruitModel.setImage_drawable(myImageList[i]);
            list.add(fruitModel);
        }

        return list;
    }
}
