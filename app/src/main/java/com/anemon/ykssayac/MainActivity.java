package com.anemon.ykssayac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;



import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView gun, saat, dakika, saniye,sozler;
    private AdView banner;
    private Handler handler;
    private Runnable runnable;
    private ArrayList<String>sozList;
    Context context = this;

   LinearLayout btpuan,bthakkinda,btduyuru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-6103319033249647~7949912137");
        banner=findViewById(R.id.banner);
        AdRequest adRequest=new AdRequest.Builder().build();
        banner.loadAd(adRequest);

        gun = (TextView) findViewById(R.id.gun);
        saat = (TextView) findViewById(R.id.saat);
        dakika = (TextView) findViewById(R.id.dakika);
        saniye = (TextView) findViewById(R.id.saniye);
        sozler=(TextView)findViewById(R.id.sozler);
        btduyuru = (LinearLayout) findViewById(R.id.btduyurular);
        btpuan = (LinearLayout) findViewById(R.id.btpuan);
        bthakkinda = (LinearLayout) findViewById(R.id.bthakkinda);
        sozDoldur();
        sozGetir();
        btduyuru.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Intent ax = new Intent(MainActivity.this, Calisma.class);
               startActivity(ax);
               overridePendingTransition(R.anim.fleft, R.anim.fhelper);
                //Toast.makeText(context, "Bu özellik gelecek sürümde aktif olacak!", Toast.LENGTH_LONG).show();
            }
        });
        btpuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ax = new Intent(MainActivity.this, Tytpuan.class);
                startActivity(ax);
                overridePendingTransition(R.anim.fleft, R.anim.fhelper);
            }
        });
        bthakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ax = new Intent(MainActivity.this, Hakkinda.class);
                startActivity(ax);
                overridePendingTransition(R.anim.fleft, R.anim.fhelper);
            }
        });

        countDownStart();
    }
    public String getSoz(int index){
        return sozList.get(index);
    }
    public void  sozGetir(){
    Random random=new Random();
    int indexSoz=random.nextInt(sozList.size());
    String sozz=getSoz(indexSoz);
    sozler.setText(sozz);
    }
    public void sozDoldur(){
        sozList=new ArrayList<>();
        sozList.add("“Dün geçti, bugün senin yarın bugünün eseri olucaktır.”");
        sozList.add("“Yüzüstü yere serilseniz bile, hala ileriye doğru hareket ediyorsunuzdur.” Victor Kiam");
        sozList.add("“Durmadığın sürece ne kadar yavaş gittiğin önemli değil.” Konfiçyüs");
        sozList.add("“Hayatımın erken dönemlerinde öğrendim ki eğer bir şeyi istiyorsan, biraz gürültü yapsan iyi olur.” ");
        sozList.add("Başarıdaki kararlılığım yeterince güçlü ise başarısızlık asla beni yakalayamaz!");
        sozList.add("İşlerin nasıl yapıldığını bilmiyorsan kendi bildiğin gibi değiştir!");
        sozList.add("Azim Hırs Kararlılık bunların arasında sen eksik olma :)");
        sozList.add("“Arkamda bıraktığım köprüleri yıkarım ki, ilerlemekten başka çarem kalmasın.” Fridtjof Nansen");
        sozList.add("Daha iyisini yapmanın bir yolu var ise bulun ve kimseye kulak asmayın!");
        sozList.add("“Kalite bir eylem değil alışkanlıktır” Aristo");
        sozList.add("“Her kulaçta karaya biraz daha yaklaşırsın, boğulanlar değil kurtulanlar konuşulur.” Aristo");

    }
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd hh:mm");
                    //YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2020-07-25 10:00");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        gun.setText("" + String.format("%02d", days));
                        saat.setText("" + String.format("%02d", hours));
                        dakika.setText(""
                                + String.format("%02d", minutes));
                        saniye.setText(""
                                + String.format("%02d", seconds));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }




}

