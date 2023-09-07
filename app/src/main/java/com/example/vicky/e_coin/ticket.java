package com.example.vicky.e_coin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ticket extends AppCompatActivity {
        WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl("https://in.bookmyshow.com/madurai");
    }
}
