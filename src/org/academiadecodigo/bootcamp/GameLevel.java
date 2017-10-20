package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

/**
 * Created by codecadet on 20/10/2017.
 */
public class GameLevel {

    private BufferedReader bReader;
    private ArrayList<boolean[]> cadetLevelConfig;
    private String line;
    public static int MAX_CADETS_PER_ROW = 8;

    public GameLevel(String file) {

        cadetLevelConfig = new ArrayList<>();

        try {
            bReader = new BufferedReader(new FileReader(file));
            loadFromFile();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean[] lineParser(String line) throws IOException {

        String[] lineValues = line.split(",");
        if(lineValues.length > 8){
            throw new IOException("FILE SHOULD ONLY HAVE 8 VALUES PER LINE!");
        }

        boolean[] cadetBooleans = new boolean[MAX_CADETS_PER_ROW];

        for (int i = 0; i < lineValues.length; i++) {

           if(lineValues[i].equals("0")) {
               cadetBooleans[i] = false;
           } else {
               cadetBooleans[i] = true;
           }
        }

        return cadetBooleans;
    }

    public void loadFromFile() {

        try {
            while((line = bReader.readLine()) != null){

                cadetLevelConfig.add(lineParser(line));
            }
        } catch (IOException e) {
            System.out.println("Couldn't read file");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<boolean[]> getCadetArray() {
        return cadetLevelConfig;
    }
}
