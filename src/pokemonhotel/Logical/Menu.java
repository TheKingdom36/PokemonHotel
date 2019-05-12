/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;
/**
 *
 * @author Daniel Murphy
 */
public class Menu
{

    InformationDisplayer infoDisplayer;
    IntegerAsker intAsker;
    int NumberOfOptions;
    public Menu(InformationDisplayer infoDisplayer)
    {
        intAsker = new IntegerAsker(System.in,System.out);
        this.infoDisplayer = infoDisplayer;
        NumberOfOptions = 9;
    }

    /**
     * Prints to the screen all available user options
     */
    public void DisplayOptions()
    {
        System.out.println("\n****************************************");
        System.out.println("----------------------------------------");
        System.out.printf((char) 27 + "[31;47m %-39s", "WELCOME TO POKEMON HOTEL ");
        System.out.println("\n----------------------------------------");
        System.out.printf((char) 27 + "[31;47m %-39s", "WE HOPE YOU ENJOY YOUR STAY ");
        System.out.println("\n----------------------------------------");
        System.out.printf((char) 27 + "[31;47m %-12s", "CREATED BY Daniel, Stephen and Abraham ");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 1: Output all Pokemon");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 2: Output Personal Assistants and Pokemon they have");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 3: Output Room contents");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 4: Output Pokemon Information");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 5: Output unassigned Pokemon");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 6: Output assigned Pokemon");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 7: Output total number of pokemon the hotel can accomdate");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 8: Output Unoccupied Rooms");
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-65s", "Option 9: Output Unassigned Personal Assistants");
        System.out.println("\n------------------------------------------------------------------");
    }

    /**
     * Handles user input for the menu
     *
     * @param input value used to determine which option will be selected
     */
    public void HandleInput(int input)
    {
        switch (input)
        {
            case 1:
            {
                infoDisplayer.OutputAllPokemon();
                break;
            }

            case 2:
            {
                infoDisplayer.OutputPersonalAssistantsAndAssignedPokemon();
                break;
            }

            case 3:
            {
                System.out.println("----------------------------------------------------------");
                infoDisplayer.OutputRoomContent(intAsker.ask("\u001B[31m" + " Enter the room number of the room you would like to see: "));
                
                break;
            }

            case 4:
            {
                System.out.println("---------------------------------------------------------------");
                infoDisplayer.OutputPokemonInformation(intAsker.ask("\u001B[31m" + " Enter the Genetic Stamp of the pokemon you would like to see: "));
                
                break;
            }

            case 5:
            {
                infoDisplayer.OutputUnAssignedPokemon();
                break;
            }

            case 6:
            {
                infoDisplayer.OuputAssignedPokemon();
                break;
            }

            case 7:
            {
                infoDisplayer.OutputTotalNumberOfPokemonHotelCanAccommodate();
                break;
            }

            case 8:
            {
                infoDisplayer.OutputUnoccupiedRooms();
                break;
            }

            case 9:
            {
                infoDisplayer.OutputUnassignedPersonalAssistants();
                break;
            }

            default:
            {
                
                if(input > 9){
                     System.out.println("\u001B[31m" + "Number entered is too big");
                }else{
                     System.out.println("\u001B[31m" + " Invalid input");
                }
               
                break;
            }

        }
    }
}

