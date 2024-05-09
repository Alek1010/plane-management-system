/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.w1965221_planemanagment;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alekm
 */
public class W1965221_planeManagment {

    public static void main(String[] args) {
        
        int[][] seats= new int[4][14]; // inisalise the array
        String[]colums={"A","B","C","D"};
        
        Ticket[] tickets = new Ticket[52];//inisalise the ticket object array
        
        
        
        //setting up valdation system for user input 
        boolean run = false;
        System.out.println("");
        do{// do while loop for multiple iterations
            boolean correct = false;
        int user_Choice = 0;
        Scanner input = new Scanner(System.in);
        
        
    
         
            
        
        while(!correct){//while only breaks if user input is valid
            user_Choice = 0;
            Scanner input1 = new Scanner(System.in);
            try{
                System.out.println("***********************************");
                System.out.println();
                System.out.print("*");
                System.out.println("           menu options           *");
                System.out.println();
                System.out.println("************************************");
        
                System.out.println("1) buy a seat");
                System.out.println("2) cancel a seat");
                System.out.println("3) find first available seat");
                System.out.println("4) show seating plan");
                System.out.println("5) print ticket information and total sales");
                System.out.println("6) search ticket");
                System.out.println("0) quit");
                System.out.println("***********************************");
                System.out.println("please select an option: ");
        //displayed options
            
                user_Choice = input1.nextInt();
            
                if(user_Choice<0||user_Choice>6){
                    System.out.println("must be between 0 and 6");
                }else{
                    correct = true;
                }
                
            }catch(InputMismatchException e){
                System.out.println("must be a number");
                //input validation
            }
            
        
           
        }
        
         // switch to access the reast of the program once the user input has 
         //been validation the option is used to determine what the program should do next 
         switch(user_Choice){
             case 1:
                 
                 seating_plan(seats);
                 buy_seat(seats,colums,tickets);//buying ticket
                 
                 break;
             case 2:
                 cancel_seat(seats,colums,tickets);//cancel ticket 
                 break;
             case 3:
                 find_first_avalable(seats,colums);//locates first seat 
                 break;
             case 4:
                 seating_plan(seats);//looks at the seating plan 
                 break;
             case 5:
                 print_ticket_info(tickets);//prints out ticket information 
                 break;
             case 6:
                 search_tickets(tickets,seats,colums);// searches for the first avaliable ticket
                 break;
             default:
                 System.out.println("thank you");//default is the program terminates 
                 
                 run=true;
                 break;
                 
         }
            
        }while(!run);
        
 
        
        
        
        
       
            
            
    }
    
    public static void buy_seat(int[][]seats,String[]colums,Ticket[] ticket){
        //method to buy tickets 
        Scanner input = new Scanner(System.in);
        boolean valid= false;
        String col_seat ="";
        int row_seat =0;
        while(!valid){
            //input validation


        System.out.println("select a colum");//takes user input checks weather
        // the input was either A,B,C,D if not it asks again 
        col_seat = input.next().toUpperCase();
        for(int i=0;i<colums.length;i++){
        if(col_seat.equals(colums[i])){
            valid =true;
        }
            }

     }
     valid=false;// reset valid variable
     while(!valid){
        Scanner input_2 = new Scanner(System.in);
        try{

            System.out.println("select a row");
            row_seat = input_2.nextInt();
            if(row_seat<0||row_seat>14){
                System.out.println("must be between the 0 and 14");

            }else{
                valid = true;
            }

        }catch(InputMismatchException e){
            System.out.println("must be a number");
            
        }
            //asks for the row numbers of the seat and checks if it is a valid number 
            // and makes sure it is a number otherwise it will ask again 

     }
        
        
        int col_to_int = 0;
        if(col_seat.equals("A")){
            col_to_int = 0;
        }else if(col_seat.equals("B")){
            col_to_int=1;
        }else if(col_seat.equals("C")){
            col_to_int=2;
        }else if(col_seat.equals("D")){
            col_to_int=3;
        }
        //converts the seat column to the assigned letter to be printed out
        
        if(row_seat>0){
            row_seat=row_seat-1; // sub one to return back to the actual index 
        }
        
        
        
        
        
        for(int i=0;i<seats.length;i++){
            for(int j = 0;j<seats[i].length;j++){
                if(seats[i][j]==seats[col_to_int][row_seat]){
                    if(seats[col_to_int][row_seat] !=1){
                        
                        //System.out.println("Booked");
                        seats[col_to_int][row_seat]=1;
                        break;
                    }if(seats[col_to_int][row_seat]!=0){
                            System.out.println("seat is alread taken");
                            //buy_seat(seats,colums);
                            
                        }
                    
                    
                }
            }
            break;
            
            //search for the seat and change to 1 if empty or print taken if already taken
        }
        // promting for persons information
        Scanner inputPerson = new Scanner(System.in);
        System.out.println("enter persons name");
        String name = inputPerson.nextLine();
        System.out.println("enter persons surname");
        String surname = inputPerson.nextLine();
        System.out.println("enter persons email");
        String email = inputPerson.nextLine();
        
        //creating person object
        person Person = new person(name,surname,email);
        
        
       
        
        
        
        //creat new ticket object to add to the ticket list
        Ticket tickets = new Ticket(row_seat+1,col_to_int+1,Person);
        //int ticketIndex=0;
        //adding ticket to the array of tickets
        for(int i=0;i<ticket.length;i++){
            if(ticket[i]==null){
                ticket[i]=tickets;
                //ticketIndex =i;
                break;
            }
                    }
        tickets.save();
        System.out.println("ticket sucessfully booked £"+tickets.getPrice());
        
        
        
        
        
    }
    
    
    
    public static void cancel_seat(int[][]seats,String[]colums,Ticket[]tickets){
        //the same as buy a seat just in the oposite order so it changes from a 1 to a 0 and when the seats are reloaded
        //a zero is in place of were the x was and the ticket is also removed
        
        //searches for the inputed seat validates the input and removes it form the array
        // if it is their and removes the ticket for that seat
        
        Scanner input = new Scanner(System.in);
        boolean valid= false;
        String col_seat ="";
        int row_seat =0;
        while(!valid){
            

        System.out.println("select a colum");
        col_seat = input.next().toUpperCase();
        for(int i=0;i<colums.length;i++){
        if(col_seat.equals(colums[i])){
            valid =true;
        }
            }

     }
     valid=false;
     while(!valid){
        Scanner input_2 = new Scanner(System.in);
        try{

            System.out.println("select a row");
            row_seat = input_2.nextInt();
            if(row_seat<0||row_seat>14){
                System.out.println("must be between the 0 and 14");

            }else{
                valid = true;
            }

        }catch(InputMismatchException e){
            System.out.println("must be a number");
        }


     }
        
        
        int col_to_int = 0;
        if(col_seat.equals("A")){
            col_to_int = 0;
        }else if(col_seat.equals("B")){
            col_to_int=1;
        }else if(col_seat.equals("C")){
            col_to_int=2;
        }else if(col_seat.equals("D")){
            col_to_int=3;
        }
        
        
        row_seat--;
        
        
        
        if(seats[col_to_int][row_seat]== 1){
            System.out.println("seat cancelled");
            seats[col_to_int][row_seat]=0;
        }
        

        
        for(int i = 0;i<tickets.length;i++){
            if(tickets[i]!=null &&tickets[i].getRow() == row_seat+1&& tickets[i].getSeat()==col_to_int+1){
                tickets[i]=null;
                break;
            }
        }
        
        
    }
    
    public static void find_first_avalable(int[][]seats,String[]colums){
        boolean foundFreeSlots=false;
        
        //int[][] position = seats;
        //searches the array and looks for any spaces were their is a 0 and outputs it 
        
        for(int i=0;i<seats.length;i++){
            
            for(int j = 0;j<seats[i].length;j++){
                
                if((i==1||i==2)&&(j==12||j==13)){// skips the rows 13 and 14 for b and c
                    continue;
                }
                
               
                  if(seats[i][j]!=1){
                      char rowLabel =(char)('A'+i);
                      System.out.println("first free slot ["+rowLabel+"] ["+(j+1)+"]"); 
                      foundFreeSlots =true;
                      break;
                  }
                    
                    
                 
            }
            if(foundFreeSlots){
                break;
            }
            
            
        }
        
        if(!foundFreeSlots){
            System.out.println("their are no free seats");
        }
        
    }
    
    public static void seating_plan(int[][]seats){
        //out puts the seating plan of the air plan it to make it 
        //more user friendly it also outputs the seat numbers and column 
        //in the correct index which is done by starting from 1 instead 
        
        String[]letters={"A","B","C","D"};
        System.out.print("    ");
        for(int i = 1; i <= seats[0].length; i++){
            System.out.printf("%-4d",i);
        }
        System.out.println();

        for(int i = 0; i < seats.length; i++){
            System.out.print(letters[i]+"   ");
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j]==1){
                    System.out.print("X   ");// prints x for every taken seat
                    
                }else{
                   System.out.print(seats[i][j]+"   "); //just prints zero to show it is not taken
                }
                
                
                
                if(i==1 || i==2){
                    if(j==11){
                        break;
                    }
                }
            }
            System.out.println();
            
           
        }
        
        

        
        
        
    }
    
    public static void print_ticket_info(Ticket[]tickets){
        double totalAmount =0.0;
        //adds up total sales from each seat and prints all the tickets for every
        // seat with all the information on it using the ticket class
        
        
        
        System.out.println("tickets sold during session");
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]!=null){
                totalAmount = totalAmount+tickets[i].getPrice();
                tickets[i].printTicketInfo();
                System.out.println("------------------------------");
            }
            
            
        }
        
        System.out.println("total amount sold £"+totalAmount);
        
    }
    
    
    public static void search_tickets(Ticket[] tickets,int[][]seats,String[]colums){
        // user inputs a seat and it tells them if that is avalable or not 
        // if not it prints the ticket of the person alreadt their
        Scanner input = new Scanner(System.in);
        boolean valid= false;
        String col_seat ="";
        int row_seat =0;
        while(!valid){


        System.out.println("select a colum");
        col_seat = input.next().toUpperCase();
        for(int i=0;i<colums.length;i++){
        if(col_seat.equals(colums[i])){
            valid =true;
        }
            }

     }
     valid=false;
     while(!valid){
        Scanner input_2 = new Scanner(System.in);
        try{

            System.out.println("select a row");
            row_seat = input_2.nextInt();
            if(row_seat<0||row_seat>14){
                System.out.println("must be between the 0 and 14");

            }else{
                valid = true;
            }

        }catch(InputMismatchException e){
            System.out.println("must be a number");
        }


     }
        
        
        int col_to_int = 0;
        if(col_seat.equals("A")){
            col_to_int = 0;
        }else if(col_seat.equals("B")){
            col_to_int=1;
        }else if(col_seat.equals("C")){
            col_to_int=2;
        }else if(col_seat.equals("D")){
            col_to_int=3;
        }
        
        
        row_seat--;
        
        
        
        
        boolean seatFound = false;
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getRow() == row_seat+1  && ticket.getSeat() == col_to_int+1 ) {
                // If the seat is booked, print ticket and person information
                System.out.println("--------------------------------");
                System.out.println("Taken");
                System.out.println("--------------------------------");
                ticket.printTicketInfo();
                System.out.println("--------------------------------");
                seatFound = true;
                break;
            }
        }

        // If seat is not booked
        if (!seatFound) {
            System.out.println("This seat is available.");
        }
    }
    
    
    
    
}
        
        
        
    
    

       
        

    
    

