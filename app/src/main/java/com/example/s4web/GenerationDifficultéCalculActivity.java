package com.example.s4web;

import java.util.Random;

public class GenerationDifficultéCalculActivity {
    private double partieGauche;
    private double partieDroite;
    private char operateur;
    private double resultat;

    public GenerationDifficultéCalculActivity(Difficulte difficulte){
        int typeDifficulte=0;
        int maxAddition=0;
        int minAddition=0;
        int maxMultiplication=0;
        int minMultiplication=0;
        if (difficulte == Difficulte.Facile) {
            typeDifficulte= (int) (Math.random() * ( 2 - 0 ));
            maxAddition = 20;
            minAddition = 1;

        }
        if (difficulte == Difficulte.Moyen) {
            typeDifficulte= (int) (Math.random() * ( 4 - 0 ));
            maxAddition = 50;
            minAddition = 1;
            maxMultiplication=10;
            minMultiplication=1;
        }
        if (difficulte == Difficulte.Difficile) {
            typeDifficulte= (int) (Math.random() * ( 4 - 0 ));
            maxAddition = 100;
            minAddition = -100;
            maxMultiplication=20;
            minMultiplication=1;
            //calcul complexe
        }
        switch (typeDifficulte){
            case (0):
                operateur='+';
                partieGauche=minAddition+ (int) (Math.random() * ( maxAddition - minAddition ));
                partieDroite=minAddition+ (int) (Math.random() * ( maxAddition - minAddition ));
                resultat=partieDroite+partieGauche;
                break;
            case (1):
                operateur='-';
                partieGauche=minAddition+ (int) (Math.random() * ( maxAddition - minAddition ));
                partieDroite=minAddition+ (int) (Math.random() * ( maxAddition - minAddition ));
                if(difficulte!=Difficulte.Difficile){
                    if(partieDroite>partieGauche){
                        double tmp = partieDroite;
                        partieDroite=partieGauche;
                        partieGauche=tmp;
                    }
                }
                resultat=partieGauche-partieDroite;
                break;
            case (2):
                operateur='*';
                partieGauche=minMultiplication+ (int) (Math.random() * ( maxMultiplication - minMultiplication ));
                partieDroite=minMultiplication+ (int) (Math.random() * ( maxMultiplication - minMultiplication ));
                resultat=partieDroite*partieGauche;
                break;
            case (3):
                operateur='/';
                partieDroite=minMultiplication+ (int) (Math.random() * ( maxMultiplication - minMultiplication ));
                partieGauche=partieDroite*(int) (Math.random() * (10-1));
                resultat=partieGauche/partieDroite;
                break;
        }

        if(difficulte==Difficulte.Facile||difficulte==Difficulte.Moyen||difficulte==Difficulte.Difficile){
            partieDroite=(int) partieDroite;
            partieGauche=(int) partieGauche;
        }

    }

    @java.lang.Override
    public String toString() {
        String retour="";
        if (partieGauche - Math.floor(partieGauche) > 0 && partieDroite - Math.floor(partieDroite) > 0) {
            retour = partieGauche + " " + operateur + " " + partieDroite + " = ?";
        } else {
            if (partieDroite - Math.floor(partieDroite) > 0) {
                retour = (int) partieGauche + " " + operateur + " " + partieDroite + " = ?";
            } else {
                if (partieGauche - Math.floor(partieGauche) > 0) {
                    retour = (int) partieGauche + " " + operateur + " " + partieDroite + " = ?";
                } else {
                    retour = (int) partieGauche + " " + operateur + " " + (int) partieDroite + " = ?";
                }
            }

        }

        return retour;
    }

    public double getResultat() {
        return resultat;
    }
}
