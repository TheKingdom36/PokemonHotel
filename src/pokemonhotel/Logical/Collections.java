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
    private int maxNumberOfRooms = 100;
    private Room[] rooms;

    private int maxNumberOfPersonalAssistants = 20;
    private PersonalAssistant[] personalAssistants;

    private int maxNumberOfPokemon = 80;
    private Pokemon[] pokemon;

    private ArrayList<Pokemon> AssignedPokemon; 
    private ArrayList<Pokemon> UnassignedPokemon;

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
