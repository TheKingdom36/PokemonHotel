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
import pokemonhotel.Logical.SetUp;

/**
 *
 * @author Daniel Murphy
 */
public class PokemonHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Collections collections = new Collections();
        
        SetUp setUp = new SetUp();
        setUp.GenerateRooms(collections.getRooms());
        setUp.GeneratePersonalAssitants(collections.getPersonalAssistants());
        setUp.GeneratePokemon(collections.getPokemon());
        setUp.AssignPokemon(collections);
        
        InformationDisplayer infoDisplayer = new InformationDisplayer(collections);
         
        Menu menu = new Menu(infoDisplayer);
        
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        System.out.println();
        do{
            menu.DisplayOptions();
            System.out.print("Enter value: ");
            
            if(scan.hasNextInt()){
                 menu.HandleInput(scan.nextInt());
            }else{
                scan.nextLine();
            } 
            
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
            System.out.println();
        }while(true);
    }
    
}
