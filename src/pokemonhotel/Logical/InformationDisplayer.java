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
    private Pokemon[] pokemon;
    private Room[] rooms;
    private PersonalAssistant[] personalAssistant;
    
    public InformationDisplayer(Pokemon[] pokemon , Room[] rooms , PersonalAssistant[] personalAssistants){
        this.pokemon = pokemon;
        this.rooms = rooms;
        this.personalAssistant = personalAssistants;
    }
    
    public void OutputAllPokemon(){
    
    }
    
    public void OuputAssignedPokemon(){
    
    }
    
    public void OutputUnAssignedPokemon(){
    
    }
    
    
    public void OutputTotalNumberOfPokemonHotelCanAccommodate(){
    
    }
    
    public void OutputPersonalAssistantsAndAssignedPokemon(){
    
    }
    
    public void OutputRoomContent(int roomNumber){
    
    }
    
    public void OutputPokemonInformation(String GeneticStamp){
    
    }
    
    
}
