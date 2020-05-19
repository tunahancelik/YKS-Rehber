package com.anemon.ykssayac;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class Aytpuan extends AppCompatActivity {
    private AdView aytbanner;
    Context context = this;
    private InterstitialAd insterstitialAd;
    double fn, tn, mn, kn, tan, cn, cgn, dn, dln, bn, en, sayisal, sozel, esit, dil, feln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aytpuan);

        MobileAds.initialize(this,"ca-app-pub-6103319033249647~7949912137");
        aytbanner=findViewById(R.id.aytbanner);
        AdRequest adRequest=new AdRequest.Builder().build();
        aytbanner.loadAd(adRequest);

        Puantutucu islem = (Puantutucu) getApplicationContext();
        final double deger = islem.getPuan();


        LinearLayout kaydet, hesapla;
        final EditText fizikdogru = (EditText) findViewById(R.id.fizikdogru);
        final EditText fizikyanlis = (EditText) findViewById(R.id.fizikyanlis);
        final EditText matdogru = (EditText) findViewById(R.id.matdogru);
        final EditText matyanlis = (EditText) findViewById(R.id.matyanlis);
        final EditText kimyadogru = (EditText) findViewById(R.id.kimyadogru);
        final EditText kimyayanlis = (EditText) findViewById(R.id.kimyayanlis);
        final EditText turkcedogru = (EditText) findViewById(R.id.turkcedogru);
        final EditText turkceyanlis = (EditText) findViewById(R.id.turkceyanlis);
        final EditText biyodogru = (EditText) findViewById(R.id.biyodogru);
        final TextView biyoyanlis = (EditText) findViewById(R.id.biyoyanlis);
        final TextView ededogru = (EditText) findViewById(R.id.ededogru);
        final TextView edeyanlis = (EditText) findViewById(R.id.edeyanlis);
        final TextView tarod = (EditText) findViewById(R.id.tarod);
        final EditText taroy = (EditText) findViewById(R.id.taroy);
        final TextView cogdog = (EditText) findViewById(R.id.cogdog);
        final TextView cogyan = (EditText) findViewById(R.id.cogyan);
        final TextView tariki = (EditText) findViewById(R.id.tartd);
        final TextView tarikiy = (EditText) findViewById(R.id.tarty);
        final TextView cogiki = (EditText) findViewById(R.id.cogtd);
        final TextView cogikiy = (EditText) findViewById(R.id.cogtyanlis);
        final TextView dind = (EditText) findViewById(R.id.dind);
        final TextView diny = (EditText) findViewById(R.id.diny);
        final TextView dild = (EditText) findViewById(R.id.dild);
        final TextView dily = (EditText) findViewById(R.id.dily);
        final TextView feld = (EditText) findViewById(R.id.feld);
        final TextView fely = (EditText) findViewById(R.id.felyanlis);
        final TextView fiziknet = (TextView) findViewById(R.id.fiziknet);
        final TextView matnet = (TextView) findViewById(R.id.matanet);
        final TextView kimyanet = (TextView) findViewById(R.id.kimyanet);
        final TextView biyonet = (TextView) findViewById(R.id.biyonet);
        final TextView turknet = (TextView) findViewById(R.id.turkcenet);
        final TextView edenet = (TextView) findViewById(R.id.edenet);
        final TextView tarbir = (TextView) findViewById(R.id.taronet);
        final TextView tarhiki = (TextView) findViewById(R.id.tartnet);
        final TextView cognet = (TextView) findViewById(R.id.cognet);
        final TextView cogikinet = (TextView) findViewById(R.id.cogtnet);
        final TextView dinnet = (TextView) findViewById(R.id.dinnet);
        final TextView dilnet = (TextView) findViewById(R.id.dilnet);
        final TextView felne = (TextView) findViewById(R.id.felnet);
        final TextView saysonuc = (TextView) findViewById(R.id.sonucsay);
        final TextView esitsonuc = (TextView) findViewById(R.id.sonucesit);
        final TextView sozsonuc = (TextView) findViewById(R.id.sonucsoz);
        final TextView dilsonuc = (TextView) findViewById(R.id.sonucdil);

        insterstitialAd=new InterstitialAd(this);
        insterstitialAd.setAdUnitId("ca-app-pub-6103319033249647/2369759305");
        insterstitialAd.loadAd(new AdRequest.Builder().build());

        kaydet = (LinearLayout) findViewById(R.id.kaydet);
        hesapla = (LinearLayout) findViewById(R.id.buttonhesapayt);


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Kaydetme Özelliği Gelecek Sürümde Eklenecek!", Toast.LENGTH_LONG).show();
            }
        });
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insterstitialAd.isLoaded()){
                    insterstitialAd.show();
                }
                try {

                    int td = Integer.parseInt(turkcedogru.getText().toString());
                    int mtdogru = Integer.parseInt(matdogru.getText().toString());
                    int tryanlis = Integer.parseInt(turkceyanlis.getText().toString());
                    int myanlis = Integer.parseInt(matyanlis.getText().toString());
                    int fdogru = Integer.parseInt(fizikdogru.getText().toString());
                    int fyanlis = Integer.parseInt(fizikyanlis.getText().toString());
                    int kdo = Integer.parseInt(kimyadogru.getText().toString());
                    int ky = Integer.parseInt(kimyayanlis.getText().toString());
                    int bd = Integer.parseInt(biyodogru.getText().toString());
                    int by = Integer.parseInt(biyoyanlis.getText().toString());
                    int ed = Integer.parseInt(ededogru.getText().toString());
                    int ey = Integer.parseInt(edeyanlis.getText().toString());
                    int cod = Integer.parseInt(cogdog.getText().toString());
                    int coy = Integer.parseInt(cogyan.getText().toString());
                    int toy = Integer.parseInt(taroy.getText().toString());
                    int tod = Integer.parseInt(tarod.getText().toString());
                    int ctd = Integer.parseInt(cogiki.getText().toString());
                    int cty = Integer.parseInt(cogikiy.getText().toString());
                    int ttd = Integer.parseInt(tariki.getText().toString());
                    int tty = Integer.parseInt(tarikiy.getText().toString());
                    int dd = Integer.parseInt(dind.getText().toString());
                    int dy = Integer.parseInt(diny.getText().toString());
                    int dildo = Integer.parseInt(dild.getText().toString());
                    int dilyy = Integer.parseInt(dily.getText().toString());
                    int feldo = Integer.parseInt(feld.getText().toString());
                    int felya = Integer.parseInt(fely.getText().toString());

                    fn = (fdogru - (fyanlis / 4));
                    bn = (bd - (by / 4));
                    kn = (kdo - (ky / 4));
                    mn = (mtdogru - (myanlis / 4));
                    tn = (mtdogru - (myanlis / 4));
                    cn = (cod - (coy / 4));
                    cgn = (ctd - (cty / 4));
                    tn = (tod - (toy / 4));
                    tan = (ttd - (tty / 4));
                    en = (ed - (ey / 4));
                    dn = (dd - (dy / 4));
                    dln = (dildo - (dilyy / 4));
                    feln = (feldo - (felya / 4));


                    fiziknet.setText(String.valueOf(fn));
                    biyonet.setText(String.valueOf(bn));
                    kimyanet.setText(String.valueOf(kn));
                    matnet.setText(String.valueOf(mn));
                    turknet.setText(String.valueOf(tn));
                    cognet.setText(String.valueOf(cn));
                    cogikinet.setText(String.valueOf(cgn));
                    tarbir.setText(String.valueOf(tn));
                    tarhiki.setText(String.valueOf(tan));
                    edenet.setText(String.valueOf(en));
                    dinnet.setText(String.valueOf(dn));
                    dilnet.setText(String.valueOf(dln));
                    felne.setText(String.valueOf(feln));


                    sayisal = 100 + deger + (mn * 3) + (fn * 2.85) + (kn * 3.07) + (bn * 3.07);
                    esit = 100 + deger + (mn * 3) + (en * 3) + (tn * 2.8) + (cn * 3.33);
                    sozel = 100 + deger + (en * 3) + (tn * 2.8) + (cn * 3.33) + (tan * 2.91) + (cgn * 2.91) + (feln * 3.3) + (dn * 3.33);
                    dil = 100 + deger + (dln * 3);

                    saysonuc.setText(String.valueOf(sayisal));
                    sozsonuc.setText(String.valueOf(sozel));
                    esitsonuc.setText(String.valueOf(esit));
                    dilsonuc.setText(String.valueOf(dil));



                } catch (Exception e) {
                    Toast.makeText(context, "Lütfen Boşlukları doldurun!", Toast.LENGTH_LONG).show();
                }
            }


        });

    }
}


