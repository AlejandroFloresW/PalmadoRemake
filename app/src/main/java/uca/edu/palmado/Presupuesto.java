package uca.edu.palmado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Presupuesto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto);
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
                        startActivity(new Intent(getApplicationContext()
                                , AboutUs.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.miMoney:

                        return true;
                }//Fin switch
                return false;
            }
        });
    }
}