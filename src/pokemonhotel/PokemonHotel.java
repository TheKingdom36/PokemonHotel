/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel;

import pokemonhotel.Logical.InformationCollecter;
import pokemonhotel.Logical.Menu;
import pokemonhotel.Logical.InformationDisplayer;
import java.util.Scanner;
import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;
import pokemonhotel.Models.SetUp;

/**
 *
 * @author Daniel Murphy
 */
public class PokemonHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int maxNumberOfRooms = 100;
        Room[] rooms;
        rooms =new Room[maxNumberOfRooms];
    
        int maxNumberOfPersonalAssistants = 20;
        PersonalAssistant[] personalAssistants;
        personalAssistants = new PersonalAssistant[maxNumberOfPersonalAssistants];
        
        int maxNumberOfPokemon = 80;
        Pokemon[] pokemon;
        pokemon = new Pokemon[maxNumberOfPokemon];
        
        
        //ArrayList<Pokemon> AssignedPokemon = new ArrayList<>();
        //ArrayList<Pokemon> UnassignedPokemon = new ArrayList<>();
        
       
        SetUp setUp = new SetUp();
        
        setUp.GenerateRooms(rooms);
        setUp.GeneratePersonalAssitants(personalAssistants);
        setUp.GeneratePokemon(pokemon);
        
        setUp.AssignPokemon(pokemon, rooms, personalAssistants);
        
        for(Room r: rooms){
            System.out.println(r.toString());
        }
         
        InformationDisplayer infoDisplayer = new InformationDisplayer(pokemon,rooms,personalAssistants);
        
        Menu menu = new Menu(infoDisplayer);
        
        Scanner scan = new Scanner(System.in);
        
        
        do{
            menu.DisplayOptions();
            menu.HandleInput(scan.nextInt());
        }while(true);
    }
    
}
