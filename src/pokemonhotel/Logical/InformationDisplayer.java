/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import pokemonhotel.Models.AirPokemon;
import pokemonhotel.Models.LandPokemon;
import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;
import pokemonhotel.Models.WaterPokemon;

/**
 *
 * @author Daniel Murphy
 */
public class InformationDisplayer
{

    Collections collections;

    public InformationDisplayer(Collections collections)
    {
        this.collections = collections;
    }

    /**
     * Outputs to the screen a list of all Pokemon seeking rooms
     */
    public void OutputAllPokemon()
    {
        
        for (Pokemon pokemon : collections.getPokemon())
        {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(pokemon.toString());
        }
    }

    /**
     * Outputs to the screen all personal assistants , the Pokemon they are taking care of , the category of these pokemon and the pokemons room number
     */
    public void OutputPersonalAssistantsAndAssignedPokemon()
    {
        
        for (PersonalAssistant personalAssistant : collections.getPersonalAssistants())
        {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(personalAssistant.toString());
            

            System.out.println(String.format((char)27 + "[36;47m %-156s", "GUEST(S)"));
           
            if (personalAssistant.getGuests().size() > 0)
            {
                for (int j = 0; j < personalAssistant.getGuests().size(); j++)
                {
                    System.out.println(personalAssistant.getGuests().get(j));

                    //Find Category of Pokemon
                    if (personalAssistant.getGuests().get(j).getClass() == LandPokemon.class)
                    {
                        
                        System.out.print(String.format((char) 27 +"[33;35m %-156s", "Pokemon is part of the Land category "));
                    } else if (personalAssistant.getGuests().get(j).getClass() == AirPokemon.class)
                    {
                        System.out.print(String.format((char) 27 + "[33;35m %-156s", "Pokemon is part of Air the category "));
                    } else if (personalAssistant.getGuests().get(j).getClass() == WaterPokemon.class)
                    {
                        System.out.print(String.format((char) 27 + "[33;35m %-156s", "Pokemon is part of Water the category "));
                    }

                    //Find Pokemon Room
                    for (Room room : collections.getRooms())
                    {
                        if (room.getGuest() == personalAssistant.getGuests().get(j))
                        {
                            System.out.println();
                            System.out.println(String.format((char)27 + "[32;47m Guest Room Number: %-137s", room.getRoomNumber()));
                           
                            System.out.println();
                        }

                    }
                }
            }
           
        }

    }

    /**
     * Outputs to the screen the room contents of the room with the given roomNumber along with the personal assistant of the pokemon who is a guest of the room
     * @param roomNumber roomNumber of a room 
     */
    public void OutputRoomContent(int roomNumber)
    {
        System.out.println("----------------------------------------------------------");
        for (Room room : collections.getRooms())
        {
            
            if (roomNumber == room.getRoomNumber())
            {
                
                System.out.println(room.toString());

                 
                if (room.getGuest() != null)
                {
                   
                    for (PersonalAssistant pa : collections.getPersonalAssistants())
                    {
                         
                        for (Pokemon poke : pa.getGuests())
                        {
                           
                            if (poke == room.getGuest())
                            {
                                
                                System.out.print(String.format((char) 27 + "[34;47m The Personal Assistant of %-33s", room.getGuest().getName() + " is:" + pa.toString() + (char)27 + "[0m"));
                                break;
                            }

                        }
                    }
                }
                break;
            }
        }
    }

    /**
     * Outputs the information of a Pokemon including their room and Personal Assistant
     * @param GeneticStamp The GeneticStamp of a Pokemon
     */
    public void OutputPokemonInformation(int GeneticStamp)
    {
        System.out.println();
       
        for (Pokemon pokemon : collections.getPokemon())
        {
            if (GeneticStamp == pokemon.getGeneticStamp())
            {
                System.out.println(pokemon.toString());
                
                Boolean found = false;

                for (PersonalAssistant pa : collections.getPersonalAssistants())
                {
                    for (Pokemon guest : pa.getGuests())
                    {
                        if (guest == pokemon)
                        {
                            System.out.println(pa.toString());
                            found =true;
                            break;
                        }
                        
                    }
                    
                    if(found == true){
                        break;
                    }

                }
                
                if(found == false){
                    System.out.printf((char) 27 + "[31;47m %-38s" , "This pokemon has no personal Assistant");
                    System.out.println();
                }

                found =false;
                
                for (Room room : collections.getRooms())
                {
                    if (room.getGuest() == pokemon)
                    {
                        System.out.println(room.toString());
                        found =true;
                        break;
                    }

                }
                
                if(found ==false){
                    
                    System.out.printf((char) 27 + "[31;47m %-39s" , "This Pokemon has no Room");
                    System.out.println();
                }
                

            }
        }
    }

    /**
     * Output total number of Pokemon which the hotel can accommodate
     */
    public void OutputTotalNumberOfPokemonHotelCanAccommodate()
    {
        System.out.println("------------------------------------------------------");
        System.out.println("\u001B[31m" + " Total number of Pokemon the hotel can accommodate: " + collections.getAssignedPokemon().size());
    }

    /**
     * Output all Pokemon who have been assigned a Room and PersonalAssistant
     */
    public void OuputAssignedPokemon()
    {

        collections.getAssignedPokemon().forEach((poke) ->
        {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(poke.toString());

        });
    }

    /**
     * Output all Pokemon who have not been assigned a Room and Personal Assistant
     */
    public void OutputUnAssignedPokemon()
    {

        collections.getUnassignedPokemon().forEach((poke) ->
        {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(poke.toString());

        });
    }

    /**
     * Output all Rooms which Unoccupied 
     */
    public void OutputUnoccupiedRooms()
    {
        for (Room room : collections.getRooms())
        {
            if (room.getGuest() == null)
            {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println(room.toString());

            }

        }
    }

    /**
     * Output all Personal Assistants who have no Pokemon assigned
     */
    public void OutputUnassignedPersonalAssistants()
    {
        for (PersonalAssistant pa : collections.getPersonalAssistants())
        {

            if (pa.getGuests().isEmpty())
            {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println(pa.toString());
            }
        }
    }
}
