
import java.util.*;
import java.io.*;


class Singleroom
{
    String name;
    String contact;
    String gender;   
    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}
class Doubleroom extends Singleroom
{ 
    String name2;
    String contact2;
    String gender2;  
    
    Doubleroom()
    {
        this.name="";
        this.name2="";
    }
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}
class NotAvailable extends Exception
{
    
    public String toString()
    {
        return "Not Available !";
    }
}

class holder 
{
    Doubleroom double_room1[]=new Doubleroom[10]; //Luxury
    Doubleroom double_room2[]=new Doubleroom[20]; //Deluxe
    Singleroom single_room1[]=new Singleroom[10]; //Luxury
    Singleroom single_room2[]=new Singleroom[20]; //Deluxe
}

class Hotel
{
    static holder hotel_ob=new holder();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
        System.out.print("Enter second customer name: ");
        name2 = sc.next();
        System.out.print("Enter contact number: ");
        contact2=sc.next();
        System.out.print("Enter gender: ");
        gender2 = sc.next();
        }      
          switch (i) {
            case 1:hotel_ob.double_room1[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:hotel_ob.double_room2[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:hotel_ob.single_room1[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:hotel_ob.single_room2[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }
    
    static void bookroom(String filename)
    {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0;j<hotel_ob.double_room1.length;j++)
                {
                    if(hotel_ob.double_room1[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn--;
                if(hotel_ob.double_room1[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                 for(j=0;j<hotel_ob.double_room2.length;j++)
                {
                    if(hotel_ob.double_room2[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-11;
                if(hotel_ob.double_room2[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                  for(j=0;j<hotel_ob.single_room1.length;j++)
                {
                    if(hotel_ob.single_room1[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-31;
                if(hotel_ob.single_room1[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                  for(j=0;j<hotel_ob.single_room2.length;j++)
                {
                    if(hotel_ob.single_room2[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-41;
                if(hotel_ob.single_room2[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                   System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }
    
    static void features()
    {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    
    static void availability()
    {
      int j,count=0;
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(hotel_ob.double_room1[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<hotel_ob.double_room2.length;j++)
                {
                    if(hotel_ob.double_room2[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<hotel_ob.single_room1.length;j++)
                {
                    if(hotel_ob.single_room1[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<hotel_ob.single_room2.length;j++)
                {
                    if(hotel_ob.single_room2[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }

    
    static void deallocate(int rn,int rtype)
    {
       
        char w;
        switch (rtype) {
            case 1:               
                if(hotel_ob.double_room1[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.double_room1[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    
                    hotel_ob.double_room1[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            case 2:
                if(hotel_ob.double_room2[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.double_room2[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    
                    hotel_ob.double_room2[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                 
                break;
            case 3:
                if(hotel_ob.single_room1[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.single_room1[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    
                    hotel_ob.single_room1[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            case 4:
                if(hotel_ob.single_room2[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.single_room2[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                   
                    hotel_ob.single_room2[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }
    

}

public class Manage_room {
    
    public void main(){

        Scanner sc = new Scanner(System.in);
        int ch,ch2;
        char wish;
    
        do{
           
        System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n5.Checkout\n6.Exit\n");
        ch = sc.nextInt();
        switch(ch){
         
            case 1: System.out.println("\nChoose room type :\n1.Double Room_1 \n2.Double Room_2 \n3.Single Room_1 \n4.Single Room_2\n");
                    Hotel.features();
                break;
            case 2:System.out.println("\nChoose room type :\n1.Double Room_1 \n2.Double Room_2 \n3.Single Room_1\n4.Single Room_2\n");
                     Hotel.availability();
                break;
            case 3:System.out.println("\nChoose room type :\n1.Double Room_1 \n2.Double Room_2 \n3.Single Room_1\n4.Single Room_2\n");
            String _d ="";
            //  _d+=name+","+contact+","+gender+",";
                     Hotel.bookroom("Room.csv");  
                     try{
                        FileWriter fw = new FileWriter("Room.csv");
                        fw.write(_d);
                        fw.close();
                    }
                    catch(IOException ioe){
                        System.err.println("IOException: " + ioe.getMessage());
                    }                   
                break;

            case 5:                 
                System.out.print("Room Number -");
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println("Room doesn't exist");
                     else if(ch2>40)
                         Hotel.deallocate(ch2-41,4);
                     else if(ch2>30)
                         Hotel.deallocate(ch2-31,3);
                     else if(ch2>10)
                         Hotel.deallocate(ch2-11,2);
                     else if(ch2>0)
                         Hotel.deallocate(ch2-1,1);
                     else
                         System.out.println("Room doesn't exist");
                     break;
            case 6:
            break;
                
        }
           
            System.out.println("\nContinue : (y/n)");
            wish=sc.next().charAt(0); 
            if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
            {
                System.out.println("Invalid Option");
                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0); 
            }
            
        }
        while(wish=='y'||wish=='Y');    
        
        Thread t=new Thread();
        t.start();
    }


   
 }
