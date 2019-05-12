/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


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
    
    
    
    public DataStore(String NamesFilePath){
       this.Names = ReadFromFile(NamesFilePath);
       
       LandTypes = new ArrayList<>();
       WaterTypes = new ArrayList<>();
       AirTypes = new ArrayList<>();
       
       LandTypes.add("Normal");
       LandTypes.add("Grass");
       LandTypes.add("Fighting");
       LandTypes.add("Poison");
       LandTypes.add("Ground");
       LandTypes.add("Rock");
       LandTypes.add("Steel");
       
       AirTypes.add("Fire");
       AirTypes.add("Electric");
       AirTypes.add("Flying");
       AirTypes.add("Psychic");
       AirTypes.add("Bug");
       AirTypes.add("Ghost");
       AirTypes.add("Dragon");
       AirTypes.add("Fairy");
       
       WaterTypes.add("Water");
       WaterTypes.add("Ice");
       WaterTypes.add("Dark");
       
       
    }
    
    /**
     * Returns a string arrayList which is read from a file
     * @param filePath the location of the file to be read from
     * @return The information from the file
     */
    private ArrayList<String> ReadFromFile(String filePath) 
    {  
        ArrayList<String> filled = new ArrayList<>();
        File file = new File(filePath);
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
