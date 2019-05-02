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
public class Menu {
    InformationDisplayer infoDisplayer;
    
    public Menu(InformationDisplayer infoDisplayer){
        this.infoDisplayer = infoDisplayer;
    }
    
    public void DisplayOptions(){
        System.out.println("Option 1: Output all Pokemon");
    }
    
    public void HandleInput(int input){
        switch(input){
            case 1:
                infoDisplayer.OutputAllPokemon();
                    
        }
    }
}
