/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import java.util.ArrayList;
import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;

/**
 *
 * @author Daniel Murphy
 */
public class Collections {
    
    private final int maxNumberOfRooms = 100;
    //Holds all created Rooms
    private final Room[] rooms;

    private final int maxNumberOfPersonalAssistants = 20;
    //Holds all created PersonalAssistants
    private final PersonalAssistant[] personalAssistants;

    private final int maxNumberOfPokemon = 80;
    
    //Holds all created Pokemon
    private final Pokemon[] pokemon;

    //Holds Pokemon which can stay at the hotel
    private final ArrayList<Pokemon> AssignedPokemon; 
    
    //Holds Pokemon which cant stay at the hotel
    private final ArrayList<Pokemon> UnassignedPokemon;

    public Room[] getRooms() {
        return rooms;
    }

    public PersonalAssistant[] getPersonalAssistants() {
        return personalAssistants;
    }

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public ArrayList<Pokemon> getAssignedPokemon() {
        return AssignedPokemon;
    }

    public ArrayList<Pokemon> getUnassignedPokemon() {
        return UnassignedPokemon;
    }
        
    public Collections(){
        rooms = new Room[maxNumberOfRooms];
        personalAssistants = new PersonalAssistant[maxNumberOfPersonalAssistants];
        pokemon = new Pokemon[maxNumberOfPokemon];
        this.AssignedPokemon = new ArrayList<>();
        this.UnassignedPokemon = new ArrayList<>();
    }
        
}
