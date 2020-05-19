package com.anemon.ykssayac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Calisma extends AppCompatActivity {
    private TextView icerik,baslik;
    Context context = this;
    private AdView banner;
    private RewardedVideoAd rewardedVideoAd;
    LinearLayout btpuan,geri,paylas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calisma);
        FirebaseDatabase datebase=FirebaseDatabase.getInstance();
        DatabaseReference myRef=datebase.getReference("duyurular");

        MobileAds.initialize(this,"ca-app-pub-6103319033249647~7949912137");
        banner=findViewById(R.id.banner);
        AdRequest adRequest=new AdRequest.Builder().build();
        banner.loadAd(adRequest);

        btpuan = (LinearLayout) findViewById(R.id.btpuan);
        geri = (LinearLayout) findViewById(R.id.geribtn);
        icerik = (TextView) findViewById(R.id.textduyuru);
        baslik = (TextView) findViewById(R.id.baslik);
        paylas = (LinearLayout) findViewById(R.id.paylasbtn);

        rewardedVideoAd=MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.loadAd("ca-app-pub-6103319033249647/3763033651",new AdRequest.Builder().build());


        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ax = new Intent(Calisma.this, MainActivity.class);
                startActivity(ax);
                finish();
                overridePendingTransition(R.anim.fleft, R.anim.fhelper);
            }
        });
        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Bu Özellik Gelecek Sürümde Eklenecek!", Toast.LENGTH_LONG).show();
            }
        });
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                rewardedVideoAd.show();
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {

            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });






        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot d:dataSnapshot.getChildren()){

                   Duyurular duyuru=d.getValue(Duyurular.class);
                   icerik.setText(duyuru.getDuyuru());
                   baslik.setText(duyuru.getKey());


               }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



}}
