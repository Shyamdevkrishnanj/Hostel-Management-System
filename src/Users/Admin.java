import java.io.*;
import java.util.Scanner;

class Admin {
    public void read() {
        try {

            File file = new File("input.txt");
            Scanner sc = new Scanner(file);

            System.out.println("INSTRUCTIONS :");
            int i = 1;
            while (sc.hasNextLine()) {
                System.out.println("\t" + "\t" + i + ") " + sc.nextLine());
                i++;
            }

            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void write_instruction() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number  of instruction to be added");
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[] myList = new int[size];

        int i;

        for (i = 0; i < myList.length; i++) {
            System.out.println("Enter the new instruction : ");
            String inp = input.next();
            try {
                File file = new File("input.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pn = new PrintWriter(bw);

                pn.println(inp);
                pn.close();
            } catch (IOException ia) {
                System.out.println("Exception occurred:");
                ia.printStackTrace();
            }

        }

    }

    void add_stock() {
        Scanner sc = new Scanner(System.in);
        int flag = 1;

        try {
            File f = new File("requirements.csv");

            if (!f.exists()) {
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            while (flag == 1) {
                System.out.print("Enter item: ");
                String stname = sc.next();
                System.out.print("Enter item quanity: ");
                int stquan = sc.nextInt();
                System.out.print("Enter item price: ");
                int st = sc.nextInt();
                pw.println(stname + "," + stquan + "," + st);
                System.out.print("Do you want to continue (y/n): ");
                String con = sc.next();

                if (con.equals("n")) {
                    flag = 0;
                }
            }

            pw.close();
        }

        catch (IOException e) {
            System.out.println("Something went wrong...");
        }
    }

    void disp_stock() {
        try {
            File f = new File("requirements.csv");
            Scanner r = new Scanner(f);
            System.out.println("----------------------------------------");
            System.out.println("                 Stock");
            System.out.println("----------------------------------------");
            int c = 1;

            while (r.hasNextLine()) {
                String data = r.nextLine();
                String[] line = data.split(",");
                System.out.println(c + ". " + "item name : " + line[0] + "\n\tQuantity:- " + line[1] + "\n\tPrice:- "
                        + line[2] + "\n");
                c++;
            }

            r.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("Something went wrong...");
        }
    }

    void main() {

        Scanner s = new Scanner(System.in);

        System.out.println("================================================================");
        System.out.println("                            ADMIN Page ");
        System.out.println("================================================================");
        System.out.println(
                "\nEnter your choice :\n1.Manage students and Room \n2.Add new instruction in the notice board \n3.Display the stock \n4.Add Stock  n6.Exit\n");
        int choice;
        choice = s.nextInt();
        switch (choice) {

            case 1:
                Warden w = new Warden();
                w.DisplayMenu();
                break;

            case 2:
                write_instruction();
                break;

            case 3:
                disp_stock();

            case 4:
                add_stock();

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
