/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import java.util.Random;
import pokemonhotel.Logical.Collections;
import pokemonhotel.Models.AirPokemon;
import pokemonhotel.Models.LandPokemon;
import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;
import pokemonhotel.Models.WaterPokemon;

/**
 *
 * @author Daniel Murphy
 */
public class SetUp {
    private final DataStore dataStore =  new DataStore("pokemon.txt");
    private final Random ranGen;
    
    public SetUp(){
       ranGen = new Random();
    }
    
    /**
     * Generates Rooms and stores in placed in array
     * @param rooms array of rooms which the method will populate
     */
    public void GenerateRooms(Room[] rooms){
        int maxResistenceRating = 7;
        int minResistenceRating = 3;
        
        for(int i=0; i< rooms.length;i++){
           rooms[i] = new Room(i+1,minResistenceRating+ranGen.nextInt(maxResistenceRating-minResistenceRating +1));
        }
    }
    
    /**
     * Generates personalAssistants and stores in placed in array
     * @param personalAssistants array of personalAssistants which the method will populate
     */
    public void GeneratePersonalAssitants(PersonalAssistant[] personalAssistants){
        
        int maxExpertValue = 6;
        int minExpertValue = 1;
        int numberOfTypesAccepted = 2;
        
        
        for(int i=0; i< personalAssistants.length ;i++){
           PersonalAssistant personalAssistant = new PersonalAssistant();
           
           personalAssistant.setExpertLevel(ranGen.nextInt(maxExpertValue - minExpertValue +1) + minExpertValue);
           personalAssistant.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
           
           
           String randomType;
           for( int j=0 ; j < numberOfTypesAccepted; j++){
              
               //Performs do loop until a type is choosen which does not match any other type assigned to the personalAssistant
              do{
                randomType = GetRandomType();
              }while(personalAssistant.getPokemonTypesAccepted().contains(randomType)== true);
              
              personalAssistant.addPokemonTypeAccepted(randomType);
           }
           
           personalAssistants[i]= personalAssistant;
        }
    }
    
    
    /**
     * Generates Pokemon and stores in placed in array
     * @param pokemon array of pokemon which the method will populate
     */
     public void GeneratePokemon(Pokemon[] pokemon)
    {
        for (int i = 0; i < pokemon.length; i++)
        {
           
            switch (ranGen.nextInt(3))
            {
                case 0:
                    LandPokemon landPokemon = new LandPokemon();
                    landPokemon.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
                    landPokemon.setExpertLevel(ranGen.nextInt(10-1)+1);
                    landPokemon.setGenericStamp(i);
                    landPokemon.setSpecialAttackRating(ranGen.nextInt(15-5)+5);
                    landPokemon.setSpeedRating(ranGen.nextInt(15-5)+5);
                    landPokemon.setType(GetRandomType());
                    pokemon[i] = landPokemon;
                    break;
                case 1:
                    AirPokemon airPokemon = new AirPokemon();
                    airPokemon.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
                    airPokemon.setExpertLevel(ranGen.nextInt(10-1)+1);
                    airPokemon.setGenericStamp(i);
                    airPokemon.setSpecialAttackRating(ranGen.nextInt(15-5)+5);
                    airPokemon.setSpeedRating(ranGen.nextInt(15-5)+5);
                    airPokemon.setType(GetRandomType());
                    pokemon[i] = airPokemon;
                    break;
                case 2:
                    WaterPokemon waterPokemon = new WaterPokemon();
                    waterPokemon.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
                    waterPokemon.setExpertLevel(ranGen.nextInt(10-1)+1);
                    waterPokemon.setGenericStamp(i);
                    waterPokemon.setSpecialAttackRating(ranGen.nextInt(15-5)+5);
                    waterPokemon.setSpeedRating(ranGen.nextInt(15-5)+5);
                    waterPokemon.setType(GetRandomType());
                    pokemon[i] = waterPokemon;
                    break;
                default:
                    System.out.println("Something went wrong!!!");
            }
        }
    }
    
     /**
      * AssignPokemon attempts to assign Pokemon to a Room and PersonalAssistant
      * @param collections Object containing required collections of objects
      */
    public void AssignPokemon(Collections collections){
        Pokemon[] pokemon = collections.getPokemon();
        Room[] rooms = collections.getRooms();
        PersonalAssistant[] personalAssistants = collections.getPersonalAssistants();
        
        //Sort Pokemon
        for (int i = 0; i < pokemon.length; i++) {
            for (int j = 1; j < (pokemon.length - i); j++) {
               
                if ( pokemon[j-1].getExpertLevel() < pokemon[j].getExpertLevel()) {
                    Pokemon temp = pokemon[j-1];
                    pokemon[j-1] = pokemon[j];
                    pokemon[j] = temp;
                }
            }
        }
        
        Boolean Assigned;
        //take each Pokemon
        for (Pokemon poke : pokemon) {
            Assigned = false;
            Room currRoom = new Room();
             
            //Assign to room
            for (Room room : rooms) {
                //sucess
                if (room.getGuest() == null && room.getResistanceRating() >= CalcPokemonRating(poke)) {
                    //add to room
                    //maintain reference to room found
                    currRoom = room;
                    Assigned = true;
                    break;
                }
            }
            
            //If room was assigned try to assign personalAssistant
            if (Assigned == true) {
                Assigned = false;
                // attempt to assign Pokemon to Personal Assistant
                for (PersonalAssistant personalAssistant : personalAssistants) {
                    if (personalAssistant.getPokemonTypesAccepted().contains(poke.getType()) 
                            && personalAssistant.getExpertLevel() >= poke.getExpertLevel() 
                                && personalAssistant.getGuests().size() < personalAssistant.getMaxNumberOfGuests()) {
                        
                        personalAssistant.AddGuest(poke);
                        Assigned = true;
                        break;
                        
                    }
                }
                //Failure to assign pa
                if (Assigned == true) {
                    //assign the pokemon to room
                    currRoom.setGuest(poke);
                    collections.getAssignedPokemon().add(poke);
                }else{
                    collections.getUnassignedPokemon().add(poke);
                }
            }else{
                collections.getUnassignedPokemon().add(poke);
            }
        }  
        
       
    }
    
    /**
     * Returns a randomly selected Pokemon type as a String
     * @return Randomly chosen String
     */
    private String GetRandomType(){
        switch(ranGen.nextInt(2)){
            case 0:
                return dataStore.getAirTypes().get(ranGen.nextInt(dataStore.getAirTypes().size()));
            case 1:
                 return dataStore.getWaterTypes().get(ranGen.nextInt(dataStore.getWaterTypes().size()));
            case 2:
                 return dataStore.getLandTypes().get(ranGen.nextInt(dataStore.getLandTypes().size()));
        }
        
        return "Error";
    }
    
    /**
     * Returns a rating calculated using a Pokemon
     * @param poke Pokemon to be used in calculation
     * @return result of calculation
     */
    private int CalcPokemonRating(Pokemon poke){
        return (poke.getSpecialAttackRating() + poke.getSpeedRating())/3;
    }
   
}
