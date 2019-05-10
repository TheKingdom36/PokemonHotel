/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel;

import pokemonhotel.Logical.Menu;
import pokemonhotel.Logical.InformationDisplayer;
import java.util.Scanner;
import pokemonhotel.Logical.Collections;
import pokemonhotel.Logical.InformationCollecter;
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
        
        Collections collections = new Collections();
        
       
        SetUp setUp = new SetUp();
        
        setUp.GenerateRooms(collections.getRooms());
        setUp.GeneratePersonalAssitants(collections.getPersonalAssistants());
        setUp.GeneratePokemon(collections.getPokemon());
        
        setUp.AssignPokemon(collections);
        
       
        InformationDisplayer infoDisplayer = new InformationDisplayer(collections);
         
        
        Menu menu = new Menu(infoDisplayer);
        
        Scanner scan = new Scanner(System.in);
        
        InformationCollecter info = new InformationCollecter();
        info.outputInfoOnPA(collections.getPersonalAssistants());
        info.outputInfoOnPoke(collections.getPokemon());
        info.outputInfoOnrooms(collections.getRooms());
        
        for(Room r : collections.getRooms()){
            System.out.println(r.toString());
        }
        
        do{
            menu.DisplayOptions();
            
            if(scan.hasNextInt()){
                 menu.HandleInput(scan.nextInt());
            }else{
                scan.nextLine();
            }
            
           
        }while(true);
    }
    
}
