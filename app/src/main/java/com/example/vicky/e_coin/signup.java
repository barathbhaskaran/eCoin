package com.example.vicky.e_coin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.vicky.e_coin.Retrofit.IMyservices;
import com.example.vicky.e_coin.Retrofit.RetrofitClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class signup extends AppCompatActivity {
    Button signuprt;
    EditText username_sp,password_sp,password_sp_cf,name1;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    IMyservices iMyservices;

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signuprt = (Button)findViewById(R.id.signuprt);
        username_sp = (EditText)findViewById(R.id.mailsp);
        password_sp = (EditText)findViewById(R.id.passsp);
        password_sp_cf = (EditText)findViewById(R.id.passspcp);
        name1 = (EditText)findViewById(R.id.namesp);
        Retrofit retrofitClient = RetrofitClient.getInstance();
        iMyservices = retrofitClient.create(IMyservices.class);

    }

    public void signup(View view){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String usr = username_sp.getText().toString();
        String name = name1.getText().toString();
        if(usr.matches(emailPattern)&& usr.length()>0 && name.length()>0){
            if(password_sp.getText().toString().matches(password_sp_cf.getText().toString())) {
                String pass = password_sp.getText().toString();
                registerUser(usr,name,pass);
            }
            else {Toast.makeText(signup.this,"Password Mismatch",Toast.LENGTH_LONG).show();}
        }
        else
            Toast.makeText(getApplicationContext(),"Invalid mail/User",Toast.LENGTH_LONG).show();
    }

    private void registerUser(String usr, String name, String pass) {

        compositeDisposable.add(iMyservices.registerUser(usr,name,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String response) throws Exception {
                        Toast.makeText(signup.this, response, Toast.LENGTH_SHORT).show();
                    }
                }));
    }



}
