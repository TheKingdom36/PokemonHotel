/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import java.util.Scanner;

/**
 *
 * @author Daniel Murphy
 */
public class Menu {
    InformationDisplayer infoDisplayer;
    Scanner scan = new Scanner(System.in);
    
    public Menu(InformationDisplayer infoDisplayer){
        this.infoDisplayer = infoDisplayer;
    }
    
    public void DisplayOptions(){
        System.out.println("Option 1: Output all Pokemon");
        System.out.println("Option 2: Output Personal Assistants and Pokemon they have");
        System.out.println("Option 3: Output Room contents");
        System.out.println("Option 4: Output Pokemon Information");
    }
    
    public void HandleInput(int input){
        switch(input){
            case 1:
                infoDisplayer.OutputAllPokemon();
            case 2:
                infoDisplayer.OutputPersonalAssistantsAndAssignedPokemon();
            case 3:
                System.out.println("Enter the room number of the room you would like to see");
                infoDisplayer.OutputRoomContent(scan.nextInt());
            case 4: 
                System.out.println("Enter the Genetic Stamp of the pokemon you would like to see");
                infoDisplayer.OutputPokemonInformation(scan.nextInt());
                    
        }
    }
}
