package com.example.s4web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DernierCalculActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dernier_calcul);

        Button boutonRetour = findViewById(R.id.bouton_retour);
        boutonRetour.setOnClickListener(view -> lancerMainActivity());
    }

    private void lancerMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}