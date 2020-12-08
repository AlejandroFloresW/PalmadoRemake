package uca.edu.palmado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
//import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Alarm Selected
        bottomNavigationView.setSelectedItemId(R.id.miProfile);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.miHome:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.miAlarm:
                        startActivity(new Intent(getApplicationContext()
                                , Reminder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.miProfile:
                        return true;
                    case R.id.miMoney:
                        startActivity(new Intent(getApplicationContext()
                                , Presupuesto.class));
                        overridePendingTransition(0,0);
                        return true;
                }//Fin switch
                return  false;
            }
        });

        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(" Con Palmado puedes administrar tus actividades de una manera mas fácil, dile adiós a los días sin dinero")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH US!")
                .addEmail("yaro.flores8816@est.uca.edu.ni ")
                .addWebsite("https://drive.google.com/drive/u/0/folders/1GRF373D6dVcPPxxdndpjQdt3U9FIvAjC")
                .addYoutube("https://www.youtube.com/channel/UC7VNtQXWHl9GyzHydrebi_Q?view_as=subscriber")   //Enter your youtube link here (replace with my channel link)
                .addPlayStore("uca.edu.palmado")   //Replace all this with your package name
                .addInstagram("alec.wf")    //Your instagram id
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);

    }

    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by TeamGastly", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}