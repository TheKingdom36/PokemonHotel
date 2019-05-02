/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

/**
 *
 * @author Daniel Murphy
 */
public class Room {
    //RoomNumber
    private int roomNumber;
    //Resistence rating
    private int resistanceRating;
    //Guest
    private Pokemon guest;
    
    public Room(){
    }
   
    
    public Room(int roomNumber,int resistanceRating){
        this.roomNumber = roomNumber;
        this.resistanceRating = resistanceRating; 
    }
    
    public Room(int roomNumber,int resistanceRating,Pokemon guest){
        this.roomNumber = roomNumber;
        this.resistanceRating = resistanceRating; 
        this.guest = guest;
    }
    
    

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getResistanceRating() {
        return resistanceRating;
    }

    public void setResistanceRating(int ResistanceRating) {
        this.resistanceRating = ResistanceRating;
    }

    public Pokemon getGuest() {
        return guest;
    }

    public void setGuest(Pokemon Guest) {
        this.guest = Guest;
    }
    
    public String toString(){
        return "RoomNumber: "+this.roomNumber + " ResistanceRating: " + this.resistanceRating + " Guest: " + this.guest; 
    }
}
