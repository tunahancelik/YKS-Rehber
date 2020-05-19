package com.anemon.ykssayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class Hakkinda extends AppCompatActivity {
    Context context = this;
    private AdView hakban;
    LinearLayout geri, paylas,video;
    private RewardedVideoAd rewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkinda);
        MobileAds.initialize(this,"ca-app-pub-6103319033249647~7949912137");
        hakban=findViewById(R.id.hakban);
        AdRequest adRequest=new AdRequest.Builder().build();
        hakban.loadAd(adRequest);

        rewardedVideoAd=MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.loadAd("ca-app-pub-6103319033249647/3763033651",new AdRequest.Builder().build());


        geri = (LinearLayout) findViewById(R.id.geribtn);
        video= (LinearLayout) findViewById(R.id.video);
        paylas = (LinearLayout) findViewById(R.id.paylasbtn);



        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rewardedVideoAd.isLoaded()){
                    rewardedVideoAd.show();
                }

            }
        });


        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Bu Özellik Gelecek Sürümde Eklenecek!", Toast.LENGTH_LONG).show();
            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ax = new Intent(Hakkinda.this, MainActivity.class);
                startActivity(ax);
                finish();
                overridePendingTransition(R.anim.fleft, R.anim.fhelper);
            }
        });
    }
}
