package com.example.s4web;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

        Button boutonMenu = findViewById(R.id.bouton_menu);
        boutonMenu.setOnClickListener(view -> retourMenu());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void retourMenu() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saisie(View view){
        TextView tv = findViewById(R.id.saisir);
        Button btn = (Button) view;
        tv.setText((String) tv.getText()+btn.getText());
        TextView tv1 = findViewById(R.id.msg_txt);
        tv1.setVisibility(View.INVISIBLE);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        VibrationEffect vbEffect = VibrationEffect.createOneShot(100,1);
        vibrator.vibrate(vbEffect);
    }



}