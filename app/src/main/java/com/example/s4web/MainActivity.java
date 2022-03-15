package com.example.s4web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonCalculer = findViewById(R.id.bouton_calculer);
        boutonCalculer.setOnClickListener(view -> lancerActivityCalcul());

        Button boutonDernierCalcul = findViewById(R.id.bouton_dernier_calcul);
        boutonDernierCalcul.setOnClickListener(view -> lancerActivityDernierCalcul());
    }

    private void lancerActivityCalcul() {
        Intent intent = new Intent(this,CalculActivity.class);
        startActivity(intent);
    }

    private void lancerActivityDernierCalcul() {
        Intent intent = new Intent(this,DernierCalculActivity.class);
        startActivity(intent);
    }

}