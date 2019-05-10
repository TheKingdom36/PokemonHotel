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
    
     /**
     * Prints to the screen all available user options
     */
    public void DisplayOptions(){
        System.out.println("Option 1: Output all Pokemon");
        System.out.println("Option 2: Output Personal Assistants and Pokemon they have");
        System.out.println("Option 3: Output Room contents");
        System.out.println("Option 4: Output Pokemon Information");
        System.out.println("Option 5: Output unassigned Pokemon");
        System.out.println("Option 6: Output assigned Pokemon");
        System.out.println("Option 7: Output total number of pokemon the hotel can accomdate");
        System.out.println("Option 8: Output Unoccupied Rooms");
    }
    
    /**
     * Handles user input for the menu 
     * @param input Value used to determine which option will be selected
     */
    public void HandleInput(int input){
        switch(input){
            case 1:{
                infoDisplayer.OutputAllPokemon();
                break;
            }
                
            case 2:{
                 infoDisplayer.OutputPersonalAssistantsAndAssignedPokemon();
                 break;
            }
               
            case 3:{
                System.out.println("Enter the room number of the room you would like to see");
                if(scan.hasNextInt()){
                      infoDisplayer.OutputRoomContent(scan.nextInt());
                }else{
                    System.out.println("illigal input");
                }
              
                break;
            } 
                
            case 4: {
                System.out.println("Enter the Genetic Stamp of the pokemon you would like to see");
                if(scan.hasNextInt()){
                       infoDisplayer.OutputPokemonInformation(scan.nextInt());
                }else{
                    System.out.println("illigal input");
                }
               
                break;
            }
            
            case 5:{
                infoDisplayer.OutputUnAssignedPokemon();
                break;
            }
            
            case 6:{
                infoDisplayer.OuputAssignedPokemon();
                break;
            }
            
            case 7:{
                infoDisplayer.OutputTotalNumberOfPokemonHotelCanAccommodate();
                break;
            }
            
            case 8:{
                infoDisplayer.OutputUnoccupiedRooms();
                break;
            }
            
            default:{
                System.out.println("Invalid input");
            }
                    
        }
    }
}
