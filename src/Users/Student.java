import java.util.Scanner;

public class Student {
    public void DisplayMenu(){
        Scanner s = new Scanner(System.in);
        DoubleLinkedlist d = new DoubleLinkedlist("data.csv");
        Manage_room mg = new Manage_room();
        System.out.println("================================================================");
        System.out.println("                            Student Page ");
        System.out.println("================================================================");
        //Manage student 
        System.out.println("1 Add details: ");
        System.out.println("2 Update a student info: ");
        System.out.println("3 Take token for food : ");
        System.out.println("4 See the features of the room : ");
        System.out.println("5 See room availability :");
        System.out.println("-1 To return to menu: ");
        System.out.print("Enter your choice: ");

            int choice;
            String name,depart;
            long id;
            double Roomnumber;

            choice = s.nextInt();
            int locationStartingFromZero;
            Object i;
            switch(choice){

                case 1:
                    System.out.print("Enter the student's name: ");
                    name = s.next();
                    System.out.print("Enter the student's id: ");
                    id = s.nextLong();
                    System.out.print("Enter the student's Room Number: ");
                    Roomnumber = s.nextDouble();
                    System.out.print("Enter the student's departartment: ");
                    depart = s.next();
                    System.out.print("Enter the location Starting from zero to insert the student at: ");
                    locationStartingFromZero = s.nextInt();
                    d.insertNode(name, id, Roomnumber, depart, locationStartingFromZero);
                    DisplayMenu();
                    break;
                
                case 2:
                    System.out.print("Enter the student's id: ");
                    id = s.nextLong();
                    d.updateNode(id);
                    DisplayMenu();
                    break;

                
                case 3 :
                System.out.print("Enter the student's name: ");
                    String n = s.next();
                    System.out.print("Enter the student's id: ");
                    int id_ = s.nextInt();
                    Token_queue q= new Token_queue();
                    q.enqueue(id_, n);

                    DisplayMenu();
                case 4:
                System.out.println("\nChoose room type :\n1.Double Room_1 \n2.Double Room_2 \n3.Single Room_1 \n4.Single Room_2\n");
                    Hotel.features();

                case 5:
                System.out.println("\nChoose room type :\n1.Double Room_1 \n2.Double Room_2 \n3.Single Room_1\n4.Single Room_2\n");
                     Hotel.availability();

                case -1:
                    System.out.println("Have a Good Day <3");
                    break;
                default:
                    System.out.println("Please Enter a Valid Symbol!!! ");
                    System.out.println("================================================================");

                    break;
            }
        }
    }

    

    
