package com.nicolas.mastermindandroid;

import android.util.Log;
import android.widget.TextView;

public class ControllerMastermind {

    private int[] Solution;
    private int[][] Proposition;
    private int nbCouleur; //5
    private int nbPosition; //4
    private int nbTentative; //10



    // Constructeur par défaut
    public ControllerMastermind() {
        this.nbCouleur = 5;
        this.nbPosition = 4;
        this.nbTentative =10;
        this.Solution = new int[nbPosition];
        this.Proposition = new int[nbPosition+2][nbTentative];
        this.nbTentative = nbTentative;
        GenererSolution();

    }
    public ControllerMastermind( int nbCouleur, int nbPosition, int nbTentative) {
        this.Solution = new int[nbPosition];
        this.Proposition = new int[nbPosition+2][nbTentative];
        this.nbCouleur = nbCouleur;
        this.nbPosition = nbPosition;
        this.nbTentative = nbTentative;
        GenererSolution();
    }
    public ControllerMastermind(  int nbTentative) {
        this.Solution = new int[4];
        this.Proposition = new int[6][nbTentative];
        this.nbCouleur = 5;
        this.nbPosition = 4;
        this.nbTentative = nbTentative;
        GenererSolution();
    }
    public int[] getSolution() {
        return Solution;
    }

    public void setSolution(int[] Solution) {
        this.Solution = Solution;
    }

    public int[][] getProposition() {
        return Proposition;
    }

    public void setProposition(int[][] Proposition) {
        this.Proposition = Proposition;
    }

    public int getNbCouleur() {
        return nbCouleur;
    }

    public void setNbCouleur(int nbCouleur) {
        this.nbCouleur = nbCouleur;
    }

    public int getNbPosition() {
        return nbPosition;
    }

    public void setNbPosition(int nbPosition) {
        this.nbPosition = nbPosition;
    }

    public int getNbTentative() {
        return nbTentative;
    }

    public void setNbTentative(int nbTentative) {
        this.nbTentative = nbTentative;
    }



    public void GenererSolution(){
        for (int i = 0; i < nbPosition; i++) {
            Solution[i] =  (int) (Math.random() * nbCouleur);

        }
        Log.d("soluce", "GenererSolution: "+ Solution[0] + " " + Solution[1]+ " "+ Solution[2] + " "+ Solution[3] + " ");
    }

    public void CalculBPMP(int monEssai){
        int[] RECSolution = new int[nbPosition];
        int[] RECProposition = new int[nbPosition];
        for (int i = 0; i < nbPosition; i++) {
            RECSolution[i] = Solution[i];
            RECProposition[i] = Proposition[i][monEssai];
        }
        int nbBP = 0;
        int nbMP = 0;

        //Comparaison
        // Calcul des BP
        for (int i = 0; i < nbPosition; i++) {
            if (RECProposition[i] == RECSolution[i]) {
                nbBP = nbBP + 1;
                RECSolution[i] = 99;
                RECProposition[i] = 88;
            }
        }
        Proposition[nbPosition][monEssai] = nbBP;
        // Calcul des MP
        for (int i = 0; i < nbPosition; i++) {
            for (int j = 0; j < nbPosition; j++) {
                if (RECProposition[i] == RECSolution[j]) {
                    nbMP = nbMP + 1;
                    RECSolution[j] = 99;
                    RECProposition[i] = 88;
                }
            }

        }
        Proposition[nbPosition+1][monEssai] = nbMP;

    }

    public boolean Gagne(int unEssai){
        if (Proposition[nbPosition][unEssai]==nbPosition){
            return true;
        }else{
            return false;
        }

    }
    public void SaisirProposition(int[] maProposition, int unEssai){
        for (int i = 0; i < nbPosition; i++) {
            Proposition[i][unEssai] = maProposition[i];
        }
    }
}
