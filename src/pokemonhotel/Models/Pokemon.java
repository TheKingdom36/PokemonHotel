    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

/**
 *
 * @author Stephen
 */
public class Pokemon
{
    private String                  name;
    private int             geneticStamp;
    private String                 type;
    private int      specialAttackRating;
    private int              speedRating;
    private int              expertLevel;
    
    public Pokemon(){}
    
    public Pokemon(String name, int genericStamp, String type, int specialAttackRating, 
            int speedRating, int expertLevel, int roomNumber, int resistanceRating)
    {
        this.name                = name;
        this.geneticStamp        = geneticStamp;
        this.type                = type;
        this.specialAttackRating = specialAttackRating;
        this.speedRating         = speedRating;
        this.expertLevel         = expertLevel;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getGeneticStamp()
    {
        return geneticStamp;
    }

    public void setGeneticStamp(int genericStamp)
    {
        this.geneticStamp = genericStamp;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    
    public int getSpecialAttackRating()
    {
        return specialAttackRating;
    }

    public void setSpecialAttackRating(int specialAttackRating)
    {
        this.specialAttackRating = specialAttackRating;
    }

    public int getSpeedRating()
    {
        return speedRating;
    }

    public void setSpeedRating(int speedRating)
    {
        this.speedRating = speedRating;
    }

    public int getExpertLevel()
    {
        return expertLevel;
    }

    public void setExpertLevel(int expertLevel)
    {
        this.expertLevel = expertLevel;
    }


    @Override
    public String toString()
    {
        return String.format((char)27 + "[4;34m POKEMON : Name: %-12s Genetic Stamp: %-12s Type: %-12s Special Attack Rating: %-12s Speed Rating: %-12s Expert Level: %-3s", name, geneticStamp, type, specialAttackRating, speedRating, expertLevel);
    }   
}