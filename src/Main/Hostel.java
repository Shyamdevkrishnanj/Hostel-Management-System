import java.io.FileNotFoundException;
import java.util.*;
public class Hostel {
    public static void main(String args[]) throws FileNotFoundException
    {
        String months[] = {  "Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul","Aug", "Sep", "Oct", "Nov", "Dec" };

        Calendar calendar = Calendar.getInstance();
    

        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\n                     ░H░O░S░T░E░L░ ░M░A░N░A░G░M░E░N░T░ ░S░Y░S░T░E░M░                              ");
        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////");

        System.out.print("\n Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));

        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        System.out.println("");
        try (Scanner input = new Scanner(System.in)) {
            Admin ad= new Admin();
            ad.read();

            
            int choic,status = 1;
            while (status == 1)

            {
                System.out.println("\n                                    MAIN MENU ");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("1.Warden  2.Student 3.Admin 4.Exit");
                System.out.println("-----------------------------------------------------------------------------------");
    
                choic = input.nextInt();
                switch (choic)
                {
                case 1:
                {
                   
                    Warden.wardenLog();
                   
                }
                break;
                case 2:
                {
                    Student.login();
                   
                }
                break;
                case 3: 
                 {
                   ad.AdminLog(); 

                    } 
                break;
                case 4:{
                    System.out.println("Thank you for Using!!!");
                    System.out.println("Namaha Shivaya!!!");
                    System.exit(0);
                   break;
                }

}}
        }
}
}