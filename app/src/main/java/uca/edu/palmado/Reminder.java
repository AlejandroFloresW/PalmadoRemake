package uca.edu.palmado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Reminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Alarm Selected
        bottomNavigationView.setSelectedItemId(R.id.miAlarm);

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
                        return true;
                    case R.id.miProfile:
                        startActivity(new Intent(getApplicationContext()
                                , AboutUs.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.miMoney:
                        startActivity(new Intent(getApplicationContext()
                                , Presupuesto.class));
                        overridePendingTransition(0,0);
                        return true;
                }//Fin switch
                return false;
            }
        });

    }
}