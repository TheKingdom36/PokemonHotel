/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;

/**
 *
 * @author Daniel Murphy
 */
public class InformationCollecter {
    
    public void outputInfoOnPoke(Pokemon[] pokemon){
        for(Pokemon poke: pokemon){
            System.out.println(poke);
        }
        
        for(int i=1 ; i< 11;i++){
            int r=0;
            int e=0;
             for(Pokemon poke: pokemon){
                if(this.CalcPokemonRating(poke) == i){
                    r++;
                }
                
                if(poke.getExpertLevel() == i){
                    e++;
                }
                
            }
                 System.out.println("Number of pokemon with resistence rating of" + i + " is " +r );
                 System.out.println("Number of pokemon with Expert rating of" + i + " is " +e );
        }
       
    }
    
    public void outputInfoOnrooms(Room[] rooms){
        
         int r=0;
            int roomsEmpty=0;
            
        for(int i=1 ; i< 8;i++){
            r=0;
             for(Room room: rooms){
                if(room.getResistanceRating() == i){
                    r++;
                }
                
                if(room.getGuest() == null){
                 roomsEmpty++;
                }
                
            }
             System.out.println(roomsEmpty);
             
              
                 System.out.println("Number of rooms with resistence rating of" + i + " is " +r );
        }
        
       
    }
    
    
     public void outputInfoOnPA(PersonalAssistant[] Pas){
       
            int numberOfGuests =0;
            for(PersonalAssistant pa: Pas){  
                System.out.println("//////////////////////////");
                System.out.println(pa.toString());
                for(Pokemon poke: pa.getGuests()){
                    System.out.println(poke);
                }
                 numberOfGuests += pa.getGuests().size();
            }
                 
        System.out.println("NumberOfGuests: " + numberOfGuests);
       
    }
    
    
    
    private int CalcPokemonRating(Pokemon poke){
        return (poke.getSpecialAttackRating() + poke.getSpeedRating())/3;
    }
}
