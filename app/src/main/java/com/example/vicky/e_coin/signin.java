package com.example.vicky.e_coin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.vicky.e_coin.Retrofit.IMyservices;
import com.example.vicky.e_coin.Retrofit.RetrofitClient;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class signin extends AppCompatActivity {
    Button signin,signup;
    EditText mail,pass;
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
        setContentView(R.layout.activity_signin);
        signin = (Button)findViewById(R.id.signin);
        signup = (Button)findViewById(R.id.signup);
        mail = (EditText)findViewById(R.id.mail);
        pass = (EditText)findViewById(R.id.pass);

        Retrofit retrofitClient = RetrofitClient.getInstance();
        iMyservices = retrofitClient.create(IMyservices.class);

    }

    public void signup(View view){
        Intent sgint = new Intent(getApplicationContext(),signup.class);
        startActivity(sgint);
    }
    public void authenticate(View view){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String uname = mail.getText().toString();
        String passch = pass.getText().toString();
        //major auth
        /*if (uname.matches(emailPattern) && uname.length() > 0 &&passch.length()>0) {
        loginUser(uname,passch);
        }else {
            Toast.makeText(this, "INCORRECT PASSWORD/USERNAME", Toast.LENGTH_LONG).show();
        }*/
        //temp login
        if(uname.equals("vicky")&&passch.equals("admin")){
            Intent admin_int = new Intent(getApplicationContext(), recycler.class);
            startActivity(admin_int);
        }
    }

    private void loginUser(String uname, String passch) {

        compositeDisposable.add(iMyservices.loginUser(uname,passch)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String response) throws Exception {
                int flag = Integer.parseInt(response);
                if(flag == 1){
                    login(null);
                }else if (flag==0)
                {
                    Toast.makeText(signin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
            }

            private void login(View view) {
                Intent admin_int = new Intent(getApplicationContext(), recycler.class);
                startActivity(admin_int);
            }
        }));

    }
}
