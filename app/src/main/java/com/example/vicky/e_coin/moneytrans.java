package com.example.vicky.e_coin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class moneytrans extends AppCompatActivity {
    Button pay;
    EditText amount,remark,recipient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneytrans);
        pay = (Button)findViewById(R.id.pay);
        amount = (EditText)findViewById(R.id.amount);
        remark = (EditText)findViewById(R.id.remark);
        recipient = (EditText)findViewById(R.id.recipient);
    }

    public void payment(View view){
        Toast.makeText(this, "Recipient: "+recipient.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Amount to send: "+amount.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Remark : "+remark.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Connecting to Payment gateway..", Toast.LENGTH_SHORT).show();
    }
}
