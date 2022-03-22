package com.example.s4web;

public class GenerationDifficultéCalculActivity {
    private double partieGauche;
    private double partieDroite;
    private char operateur;
    private double resultat;

    public GenerationDifficultéCalculActivity(Difficulte difficulte){
        int typeDifficulte=0;
        int minAddition=0;
        int maxAddition=0;
        int minMultiplication=0;
        int maxMultiplication=0;

        if (difficulte == Difficulte.Facile) {
            typeDifficulte= (int) (Math.random() * ( 2 - 0 ));
            minAddition = 1;
            maxAddition = 20;
        }
        if (difficulte == Difficulte.Moyen) {
            typeDifficulte= (int) (Math.random() * ( 4 - 0 ));
            minAddition = -50;
            maxAddition = 50;
            minMultiplication=1;
            maxMultiplication=20;
        }
        if (difficulte == Difficulte.Difficile) {
            typeDifficulte= (int) (Math.random() * ( 4 - 0 ));
            minAddition = -50;
            maxAddition = 50;
            minMultiplication=-50;
            maxMultiplication=50;
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
                    if(partieDroite>partieGauche){ //Inversion pour éviter les resultats négatifs
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

    @Override
    public String toString() {
        String affichageCalcul="";
        if (partieGauche - Math.floor(partieGauche) > 0 && partieDroite - Math.floor(partieDroite) > 0) {
            affichageCalcul = partieGauche + " " + operateur + " " + partieDroite + " = ?";
        } else {
            if (partieDroite - Math.floor(partieDroite) > 0) {
                affichageCalcul = (int) partieGauche + " " + operateur + " " + partieDroite + " = ?";
            } else {
                if (partieGauche - Math.floor(partieGauche) > 0) {
                    affichageCalcul = (int) partieGauche + " " + operateur + " " + partieDroite + " = ?";
                } else {
                    affichageCalcul = (int) partieGauche + " " + operateur + " " + (int) partieDroite + " = ?";
                }
            }

        }

        return affichageCalcul;
    }

    public String getOperateur(){ return String.valueOf(operateur);}

    public double getResultat() {
        return resultat;
    }
}
