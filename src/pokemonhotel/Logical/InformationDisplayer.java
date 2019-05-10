/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;

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
            }
        }
    }
    
    //Abraham
    public void OutputPokemonInformation(int GeneticStamp){
        for (Pokemon pokemon : collections.getPokemon()) {
            if (GeneticStamp == pokemon.getGenericStamp()) {
                System.out.println(pokemon.toString());
                System.out.println("--------------------------------------------------------------------------");
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
}
