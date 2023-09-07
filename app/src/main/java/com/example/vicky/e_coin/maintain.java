package com.example.vicky.e_coin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class maintain extends AppCompatActivity {
    EditText cname,cardno,mm,yy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);
        cardno = (EditText)findViewById(R.id.cardno);
        cname = (EditText)findViewById(R.id.cname);
        mm = (EditText)findViewById(R.id.mm);
        yy = (EditText)findViewById(R.id.yy);
    }

    public void validatecard(View view){
        String cno = cardno.getText().toString();
        String cn = cname.getText().toString();
        String m = mm.getText().toString();
        String y =yy.getText().toString();
        int m1,y1;
        if(y.matches("")){
                y1=0;
        }else {
             y1 = Integer.parseInt(m);
        }
        if(m.matches("")){
            m1=0;
        }else {
            m1 = Integer.parseInt(m);
        }
        int flag =0;
        if(cno.length()<16){
            Toast.makeText(this, "Invalid card Number", Toast.LENGTH_SHORT).show();
        }else{
            flag = flag+1;
        }
        if(cn.length()<1){
            Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show();
        }else{
            flag = flag+1;
        }
        if(m1>12 || m.equals("")){
            Toast.makeText(this, "Invalid Month", Toast.LENGTH_SHORT).show();
        }else{
            flag = flag+1;
        }
        if(y1>99 || y.equals("")){
            Toast.makeText(this, "Invalid year", Toast.LENGTH_SHORT).show();
        }else{
            flag = flag+1;
        }

        if(flag==4){
            Toast.makeText(this, "Card accepted / added", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Card Denied", Toast.LENGTH_SHORT).show();
        }

    }
}
