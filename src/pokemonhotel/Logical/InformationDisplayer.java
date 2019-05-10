/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

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
public class InformationDisplayer {
    Collections collections;
    
    public InformationDisplayer(Collections collections){
        this.collections = collections;
    }
    
    //Abraham
    public void OutputAllPokemon(){
        for (Pokemon pokemon : collections.getPokemon()) {
            System.out.println(pokemon.toString());
            System.out.println("--------------------------------------------------------------------------");
        }
    }
    
    
    //Abraham 
    public void OutputPersonalAssistantsAndAssignedPokemon(){
        for (PersonalAssistant personalAssistant : collections.getPersonalAssistants()) {
            System.out.println("Personal Assistant");
            System.out.println(personalAssistant.toString());
            
            
            
            System.out.println("Guests");
            if (personalAssistant.getGuests().size() > 0) {
                for (int j = 0; j < personalAssistant.getGuests().size(); j++) {
                    System.out.println(personalAssistant.getGuests().get(j));
                    
                    //Find Category of Pokemon
                    if(personalAssistant.getGuests().get(j).getClass() == LandPokemon.class){
                        System.out.println("Pokemon is part of Land category");
                    }else if(personalAssistant.getGuests().get(j).getClass() == AirPokemon.class){
                        System.out.println("Pokemon is part of Air category");
                    }else if(personalAssistant.getGuests().get(j).getClass() == WaterPokemon.class){
                        System.out.println("Pokemon is part of Water category");
                    }
                    
                    //Find Pokemon Room
                     for(Room room:collections.getRooms()){
                        if(room.getGuest() == personalAssistant.getGuests().get(j)){
                            System.out.println("Guest Room Number: " + room.getRoomNumber());
                        }
                            
                     }
                }
            }
             System.out.println("--------------------------------------------------------------------------");

        }
        
    }
    
    //Abraham
    public void OutputRoomContent(int roomNumber){
        for (Room room : collections.getRooms()) {
            if (roomNumber == room.getRoomNumber()) {
                System.out.println(room.toString());
                
                if(room.getGuest() != null){
                    for(PersonalAssistant pa: collections.getPersonalAssistants()){
                        for(Pokemon poke:pa.getGuests()){
                            if(poke == room.getGuest()){
                                System.out.println("PersonalAssistant of " +room.getGuest().getName()+" is " + pa.toString());
                                 break;
                            }
                           
                        }
                    }
                }
                break;
            }
        }
    }
    
    //Abraham
    public void OutputPokemonInformation(int GeneticStamp){
        for (Pokemon pokemon : collections.getPokemon()) {
            if (GeneticStamp == pokemon.getGenericStamp()) {
                System.out.println(pokemon.toString());
               
                for(PersonalAssistant pa: collections.getPersonalAssistants()){
                    for(Pokemon guest:pa.getGuests()){
                        if(guest == pokemon){
                            System.out.println(pa.toString());
                            break;
                        }
                    }
                    
                }
                
                for(Room room: collections.getRooms()){
                    if(room.getGuest() == pokemon){
                        System.out.println(room.toString());
                        break;
                    }
                    
                }
            
            }
        }
    }
     
    public void OutputTotalNumberOfPokemonHotelCanAccommodate(){
        System.out.println("Total number of Pokemon the hotel can accommodate: "+collections.getAssignedPokemon().size());
    }
    
    
    public void OuputAssignedPokemon(){
        collections.getAssignedPokemon().forEach((poke) -> {
            System.out.println(poke.toString());
            System.out.println("--------------------------------------------------------------------------");
        });
    }
    
    public void OutputUnAssignedPokemon(){
        collections.getUnassignedPokemon().forEach((poke) -> {
            System.out.println(poke.toString());
            System.out.println("--------------------------------------------------------------------------");
        });
    }
    
    public void OutputUnoccupiedRooms(){
        for(Room room : collections.getRooms()){
            if(room.getGuest() == null){
                 System.out.println(room.toString());
                 System.out.println("--------------------------------------------------------------------------");
            }
           
        }
    }
    
    public void OutputUnassignedPersonalAssistants(){
        for(PersonalAssistant pa:collections.getPersonalAssistants()){
            if(pa.getGuests().isEmpty()){
                System.out.println(pa.toString());
            }
        }
    }
}
