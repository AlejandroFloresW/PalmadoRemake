package uca.edu.palmado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OnBoarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_on_boarding);
    }

    public void EndOnBoarding(View v){
        nextView();
    }

    private void nextView() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}