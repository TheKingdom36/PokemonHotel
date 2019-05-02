/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel Murphy
 */
public class DataStore {
    
    
    private ArrayList<String> Names;
    private ArrayList<String> LandTypes;
    private ArrayList<String> WaterTypes;
    private ArrayList<String> AirTypes;
    

    public ArrayList<String> getNames() {
        return Names;
    }

    public ArrayList<String> getLandTypes() {
        return LandTypes;
    }

    public ArrayList<String> getWaterTypes() {
        return WaterTypes;
    }

    public ArrayList<String> getAirTypes() {
        return AirTypes;
    }
    
    
    
    public DataStore(String NamesfilePath){
       this.Names = fillNames();
       
       LandTypes = new ArrayList<>();
       WaterTypes = new ArrayList<>();
       AirTypes = new ArrayList<>();
       
       
       //TODO Remove
       LandTypes.add("Rock");
       LandTypes.add("Ground");
       AirTypes.add("Fire");
       AirTypes.add("Ground");
       WaterTypes.add("Water");
       
       
    }
    
    private ArrayList<String> fillNames() 
    {  
        ArrayList<String> filled = new ArrayList<>();
        File file = new File("pokemon.txt");
        System.out.print(file);
        try (Scanner scan = new Scanner(file)) 
        {
            while(scan.hasNextLine())
            {
                filled.add(scan.nextLine());
            }
        }catch (FileNotFoundException e)
        {
            System.out.println("No such File   "+ e);
        }
        return filled;
    }
}
