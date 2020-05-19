package com.anemon.ykssayac;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class Tytpuan extends AppCompatActivity {

    Context context = this;
    private AdView tytbanner;
    private InterstitialAd insterstitialAd;
    LinearLayout buttonhesap,aythesap;

    double islem,aytp;
    float kon;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan);

        MobileAds.initialize(this,"ca-app-pub-6103319033249647~7949912137");
        tytbanner=findViewById(R.id.tytbanner);
        AdRequest adRequest=new AdRequest.Builder().build();
        tytbanner.loadAd(adRequest);

        Toast.makeText(context, "TYT hesaplandıktan sonra AYT geçebilirsiniz", Toast.LENGTH_LONG).show();
        final Puantutucu hesaplananpuan = (Puantutucu) getApplicationContext();

        final EditText turkcedogru= (EditText) findViewById(R.id.tdogru);
        final EditText tyanlis= (EditText) findViewById(R.id.tyanlis);
        final EditText matdogru= (EditText) findViewById(R.id.mtdogru);
        final EditText matyanlis= (EditText) findViewById(R.id.mtyanlis);
        final EditText fendogru= (EditText) findViewById(R.id.fendogru);
        final EditText fenyanlis= (EditText) findViewById(R.id.fenyanlis);
        final EditText sosyaldogru= (EditText) findViewById(R.id.sosyaldogru);
        final EditText sosyalyanlis= (EditText) findViewById(R.id.sosyalyanlis);
        final EditText diploma= (EditText) findViewById(R.id.diploma);
        final TextView fennet= (TextView) findViewById(R.id.fennet);
        final TextView matnet= (TextView) findViewById(R.id.matnet);
        final TextView trnet= (TextView) findViewById(R.id.trnet);
        final TextView sosyalnet= (TextView) findViewById(R.id.sosyalnet);
        final CheckBox kontrol= (CheckBox) findViewById(R.id.kont);
        final TextView sonuc=(TextView) findViewById(R.id.sonuc);
        buttonhesap=(LinearLayout) findViewById(R.id.buttonhesap);
        aythesap=(LinearLayout) findViewById(R.id.aythesapla);
        diploma.setText("0");


       insterstitialAd=new InterstitialAd(this);
       insterstitialAd.setAdUnitId("ca-app-pub-6103319033249647/2369759305");
        insterstitialAd.loadAd(new AdRequest.Builder().build());


        buttonhesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(insterstitialAd.isLoaded()){
                    insterstitialAd.show();
                }

                try {

                float tdogru=Float.parseFloat(turkcedogru.getText().toString());
                float mtdogru=Float.parseFloat(matdogru.getText().toString());
                float tryanlis=Float.parseFloat(tyanlis.getText().toString());
                float myanlis=Float.parseFloat(matyanlis.getText().toString());
                float fdogru=Float.parseFloat(fendogru.getText().toString());
                float fyanlis=Float.parseFloat(fenyanlis.getText().toString());
                float sdogru=Float.parseFloat(sosyaldogru.getText().toString());
                float syanlis=Float.parseFloat(sosyalyanlis.getText().toString());
                float diplomap=Float.parseFloat(diploma.getText().toString());

                fennet.setText(String.valueOf((fdogru-(fyanlis/4))));
                sosyalnet.setText(String.valueOf((sdogru-(syanlis/4))));
                trnet.setText(String.valueOf((tdogru-(tryanlis/4))));
                matnet.setText(String.valueOf((mtdogru-(myanlis/4))));





                    kon=0;

                    if(kontrol.isChecked())

                    {

                      kon= (float) (diplomap*0.6);

                    }

                    islem = 100 + ((tdogru - (tryanlis / 4)) * 3.3) + ((mtdogru - (myanlis / 4)) * 3.3) + ((fdogru - (fyanlis / 4)) * 3.4) + ((sdogru - (syanlis / 4)) * 3.4) + kon;
                    sonuc.setText(String.valueOf(islem));
                    aytp=((tdogru - (tryanlis / 4)) * 1.32)+((mtdogru - (myanlis / 4)) * 1.32)+((fdogru - (fyanlis / 4)) * 1.36) + ((sdogru - (syanlis / 4)) * 1.36);

                    aythesap.setVisibility(View.VISIBLE);
                    hesaplananpuan.setPuan(aytp);


            }
             catch (Exception e) {
                 Toast.makeText(context, "Lütfen Boşlukları doldurun!", Toast.LENGTH_LONG).show();
            }}


        });




        aythesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ax = new Intent(Tytpuan.this, Aytpuan.class);
                startActivity(ax);
                overridePendingTransition(R.anim.fleft, R.anim.fhelper);
            }
        });


    }
}
