/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

import java.util.Random;

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
    
    public void GenerateRooms(Room[] rooms){
        for(int i=0; i< rooms.length;i++){
           rooms[i] = new Room(i+1,3+ranGen.nextInt(8-3));
        }
    }
    
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
              
              do{
                randomType = GetRandomType();
              }while(personalAssistant.getPokemonTypesAccepted().contains(randomType)== true);
              
              personalAssistant.addPokemonTypeAccepted(randomType);
           }
           
           personalAssistants[i]= personalAssistant;
        }
    }
    
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
    
    public void AssignPokemon(Pokemon[] pokemon, Room[] rooms , PersonalAssistant[] personalAssistants){
        
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
        
        //take single Poke
        for(int i=0; i< pokemon.length ;i++){
            Boolean Assigned = false;
            Room cRoom = new Room();
            
            //Assign to room
            for (Room room : rooms) {
                //sucess
                if (room.getGuest() == null && room.getResistanceRating() >= CalcPokemonRating(pokemon[i])) {
                    //add to room
                    //maintain reference to room found
                    cRoom = room;
                    Assigned = true;
                    break;
                }
            }

            //if room was assigned try to assign pa
            if(Assigned == true){
                
                 Assigned = false;
                //Assign to personal Assistant
                for (PersonalAssistant personalAssistant : personalAssistants) {
                    if (personalAssistant.getPokemonTypesAccepted().contains(pokemon[i].getType()) && personalAssistant.getExpertLevel() >= pokemon[i].getExpertLevel() && personalAssistant.getGuests().size() < 5) {
                        personalAssistant.AddGuest(pokemon[i]);
                        Assigned = true;
                        break;
                    }
                }
               
                //Failure to assign pa
                if(Assigned == true){
                    //assign the pokemon to room
                     cRoom.setGuest(pokemon[i]);
                }
            }
        }  
        
       
    }
    
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
    
    private int CalcPokemonRating(Pokemon poke){
        return (poke.getSpecialAttackRating() + poke.getSpeedRating())/3;
    }
   
}
