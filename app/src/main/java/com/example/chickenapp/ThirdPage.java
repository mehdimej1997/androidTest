package com.example.chickenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ThirdPage extends AppCompatActivity {
    WebView view;
    ProgressDialog prDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        view = findViewById(R.id.html);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setAppCacheEnabled(true);
        view.loadUrl("file:///android_asset/page3/index.html");

        view.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                prDialog = new ProgressDialog(ThirdPage.this);
                prDialog.setMessage("S'il vous plaît, attendez...");
                prDialog.show();
            }
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(prDialog!=null){
                    prDialog.dismiss();
                }
            }
        });
    }
}