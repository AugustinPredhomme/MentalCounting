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

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CalculActivity extends AppCompatActivity {
    private GenerationDifficultéCalculActivity GenerationDifficulté;
    private Difficulte difficulte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

        difficulte = Difficulte.Facile;

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

    public void generationCalcul(){
        TextView textView = findViewById(R.id.affichagecalcul);
        GenerationDifficulté = new GenerationDifficultéCalculActivity(difficulte);
        textView.setText(GenerationDifficulté.toString());
    }

    public void initBoutons(){
        ArrayList<Button> listeBoutons = new ArrayList<>();
        listeBoutons.add(findViewById(R.id.bouton_zero));
        listeBoutons.add(findViewById(R.id.bouton_un));
        listeBoutons.add(findViewById(R.id.bouton_deux));
        listeBoutons.add(findViewById(R.id.bouton_trois));
        listeBoutons.add(findViewById(R.id.bouton_quatre));
        listeBoutons.add(findViewById(R.id.bouton_cinq));
        listeBoutons.add(findViewById(R.id.bouton_six));
        listeBoutons.add(findViewById(R.id.bouton_sept));
        listeBoutons.add(findViewById(R.id.bouton_huit));
        listeBoutons.add(findViewById(R.id.bouton_neuf));
        for(Button b:listeBoutons){
            b.setOnClickListener(view -> saisie(view));
        }
        Button bouton_suppr = findViewById(R.id.bouton_supprimer);
        bouton_suppr.setOnClickListener(view -> deleteInput(view));
        TextView textView = findViewById(R.id.msg_txt);
        textView.setVisibility(View.INVISIBLE);


    }

    public void deleteInput(View view){
        TextView textView = findViewById(R.id.saisir);
        String text = (String) textView.getText();
        int lengh = text.length();
        if(lengh>0){
            String text2 = text.substring(0,lengh-1);
            textView.setText(text2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saisie(View view){
        TextView textView1 = findViewById(R.id.saisir);
        Button btn = (Button) view;
        textView1.setText((String) textView1.getText()+btn.getText());
        TextView textView2 = findViewById(R.id.msg_txt);
        textView2.setVisibility(View.INVISIBLE);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        VibrationEffect vbEffect = VibrationEffect.createOneShot(100,1);
        vibrator.vibrate(vbEffect);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void verification(View view){
        TextView textView1 = findViewById(R.id.saisir);
        String txt = (String) textView1.getText();
        boolean result;
        try {
            result = (Double.parseDouble(txt)) == (GenerationDifficulté.getResultat());
        }
        catch (Exception e){
            result = false;
        }
        TextView textView2 = findViewById(R.id.msg_txt);
        final MediaPlayer mpFail = MediaPlayer.create(this, R.raw.failure);
        final MediaPlayer mpSuccess = MediaPlayer.create(this, R.raw.success);
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        VibrationEffect vbEffect;
        if(result){
            mpSuccess.start();
            textView2.setTextColor(getResources().getColor(R.color.succes, this.getTheme()));
            textView2.setText(getResources().getString(R.string.succes));
            vbEffect = VibrationEffect.createOneShot(200,2);
            //set le score
        }
        else{
            mpFail.start();
            textView2.setTextColor(getResources().getColor(R.color.echec, this.getTheme()));
            textView2.setText(getResources().getString(R.string.echec));
            vbEffect = VibrationEffect.createOneShot(500,5);
            //set le score
        }
        vibrator.vibrate(vbEffect);
        textView2.setVisibility(View.VISIBLE);
        //Toast.makeText(this, "R attendue :"+op.getReponse()+", R donnée : "+txt, Toast.LENGTH_SHORT).show();
        textView1.setText("");
        generationCalcul();
    }



}