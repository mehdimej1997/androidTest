package com.example.chickenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;


public class FirstPage extends AppCompatActivity {


    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        interstitial = new InterstitialAd(FirstPage.this);

        interstitial.setAdUnitId(getString(R.string.interstitial));


        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {

                displayInterstitial();
            }
        });

    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}