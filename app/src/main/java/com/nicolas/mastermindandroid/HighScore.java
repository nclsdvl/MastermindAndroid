package com.nicolas.mastermindandroid;

import android.text.GetChars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Nicolas
 * @version 1.0
 */
public class HighScore {

    private static boolean initialized = false;
    private static List<Winner> listHighscore = new ArrayList<Winner>();


    public static void setListHighscore(List<Winner> listHighscore) {
        HighScore.listHighscore = listHighscore;
    }

    public HighScore() {
        initialized = true;
    }

    /**
     * 
     * @return
     */
    public static List<Winner> getListHighscore() {
        return listHighscore;
    }

    /**
     * Ajoute un élément à la listHigsocre
     * @param winner L'instance winner à ajouté à la liste
     */
    public static void addElements(Winner winner){

        listHighscore.add(winner);
        Collections.sort(listHighscore);
    }




    @Override
    public String toString() {
        String temp = "";
        for(Winner str:listHighscore)
            temp+=str;
        return "HighScore{}" + temp;
    }
}
