/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

import java.util.ArrayList;

/**
 *
 * @author Daniel Murphy
 */
public class PersonalAssistant {
    //Name
    private String name;
    //Expert level
    private int expertLevel;
    
    //Pokenmon Accepted types
    private ArrayList<String> pokemonTypesAccepted;
    
    //PokemonGuests
    private ArrayList<Pokemon> guests;
    
    public PersonalAssistant(){
        this.pokemonTypesAccepted = new ArrayList<>();
        this.guests = new ArrayList<>();
    }
    
    public PersonalAssistant(String name,int expertLevel){
        this.pokemonTypesAccepted = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.name = name;
        this.expertLevel = expertLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpertLevel() {
        return expertLevel;
    }

    public void setExpertLevel(int expertLevel) {
        this.expertLevel = expertLevel;
    }

    public ArrayList<String> getPokemonTypesAccepted() {
        return pokemonTypesAccepted;
    }

    public void addPokemonTypeAccepted(String pokemonType) {
        this.pokemonTypesAccepted.add(pokemonType);
    }

    public ArrayList<Pokemon> getGuests() {
        return guests;
    }

    public void AddGuest(Pokemon Guest) {
            this.guests.add(Guest);
    }
    
    @Override
    public String toString(){
        return "Name: " + this.name + " ExpertLevel: " + this.expertLevel + " PokemonTypes: " + this.pokemonTypesAccepted.get(0) +" and " + this.pokemonTypesAccepted.get(1);
    }
}
