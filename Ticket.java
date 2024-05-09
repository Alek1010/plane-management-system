/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1965221_planemanagment;
//import com.mycompany.w1965221_planemanagment.person;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author alekm
 */
public class Ticket {
    
    private int row;
    private int seat;
    private double price;
    private person Person;
    
    
    //constructor method
    public Ticket(int row,int seat, person Person){
        this.row = row;
        this.seat = seat;
        this.Person=Person;
        this.price = calculatePrice(row);
        
    }
    
    //getters and setters
    public int getRow(){
        return row;}
    public void setRow(int row){
        this.row=row;
    }
    
    //seats
    public int getSeat(){
        return seat;
    }
    public void setSeat(int seat){
        this.seat = seat;
    }
    
    //price
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    
    //person
    public person getPerson(){
        return Person;
    }
    public void setPerson(person Person){
        this.Person=Person;
    }
    
    
    //method to print out ticket information
    public void printTicketInfo(){
        System.out.println("ticket information");
        System.out.println("row "+row);
        System.out.println("seat "+seat);
        System.out.println("price £"+price);
        if(Person !=null){
            System.out.println("person information");
            Person.printInfo();
        }
    }
    private static final double PRICE_RANGE_1=200.00;
    private static final double PRICE_RANGE_2=150.00;
    private static final double PRICE_RANGE_3=180.00;
    
    
    //method to calculate ticket price based on seat num
    private double calculatePrice(int row){
        if(row>=1 && row<=5){
            return PRICE_RANGE_1;
        }else if(row>=6&& row<=9){
            return PRICE_RANGE_2;
        }else if(row>=10&&row<=14){
            return PRICE_RANGE_3;
        }else{
            return 0;
    }
    }
    
    public void save(){
        //i wrote this in my ticket class so it could have access to all of the information
        //like seat,row,price as well as person infomation
        // create file nanme based on row and seat number
        String fileName = String.format("%s%d.txt",(char)('A'+seat-1),row);
        
        try(FileWriter writer = new FileWriter(fileName)){
            //write ticket information into file
            writer.write("Ticket information:\n");
            writer.write("Row: "+seat+"\n");
            writer.write("seat: "+row+"\n");
            writer.write("Price: £"+price+"\n");
            if(Person != null){
                writer.write("Person Information:\n");
                writer.write("Name: "+Person.getName()+"\n");
                writer.write("Surname: " + Person.getSurname() + "\n");
                writer.write("Email: " + Person.getEmail() + "\n");
                
            }
            System.out.println("Ticket information saved to "+ fileName);
        }catch (IOException e){
            System.out.println("error occured while saving ticket information");
            e.printStackTrace();
        }
    }
}

