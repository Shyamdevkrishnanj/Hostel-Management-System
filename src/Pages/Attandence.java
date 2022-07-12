import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;

public class Attandence implements Serializable {
    public static ArrayList<Student> studentsList;
    public static final String MAIN_DB_FILE = "database.csv";
    static class Student implements Serializable{
        private String name;
      
        private boolean isPresent = false;


        public Student() {
            this.name = name;

        }

        public boolean isPresent() {
            return isPresent;
        }

        public void setPresent(boolean present) {
            isPresent = present;
        }


    }

    public static void showStudent() {
        String filename="data.csv";

        DoubleLinkedlist d= new DoubleLinkedlist(filename);

        d.displayList();
        Student student = new Student();
        studentsList.add(student);
        try {
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            in.readLine();
        } catch (IOException exception) {
System.out.println("erro1");
        }
    }



    private static void makePresentsForAllStudent(String File) {

        ArrayList<String[]> dataset = utils.getData("data.csv");
        for (String[] student : dataset) {
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        try {
            System.out.println("\n........................Students........................");
            for (int j = 0; j < studentsList.size(); j++) {
                Student st = studentsList.get(j);
                System.out.println("Name: " + student[1] + " - ID: " + student[0] );
                System.out.println("Is Presented then ENTER \'p\' else ENTER \'n\'=>");
                String readChar = in.readLine();
                String status = student[0]+","+student[1];
                if (readChar.equalsIgnoreCase("p")) {
                    st.setPresent(true);
                    status+=",present\n";
                    System.out.println("" + student[1] + " Present today...");
                } 
                else {
                    st.setPresent(false);
                    status+=",abscent\n";
                    System.out.println("" + student[1] + " Absent today...");
                }
                exportToFile(status,"database.csv");
                System.out.println("...........................................................................");
            }

            in.readLine();
        } catch (IOException exception) {
System.out.println("error2");
        }
    }
}

    private static void showAttendance(String filename) {

        ArrayList<String[]> dataset = utils.getData("database.csv");
        for (String[] student : dataset) {
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        try {
            System.out.println("\n........................Students........................");
            for (int j = 0; j < studentsList.size(); j++) {
                Student st = studentsList.get(j);
                System.out.println("Name: " + student[1] + " - ID: " + student[0] + " - Status: " +student[2] );
                System.out.println("...........................................................................");
            }


            in.readLine();
        } catch (IOException exception) {
System.out.println("error3");
        }}
    }

    public static void exportToFile(String content, String filename){

         try{
            FileWriter fw = new FileWriter(filename, true);
            fw.write(content);
            fw.close();
        }
        catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void importFromFile(){

        try{

            FileInputStream saveFile = new FileInputStream("data.csv");

 
            ObjectInputStream save = new ObjectInputStream(saveFile);


            studentsList = (ArrayList<Student>) save.readObject();

       
            save.close(); 
        }
        catch(Exception exc){
            exc.printStackTrace(); 
        }

        if (studentsList!=null&&studentsList.size()>0)
            System.out.println("\t\t" + "Loaded old data...");
        System.out.println();
    }

    public void main_attandence() {

        System.out.println("============" + "=================");
        System.out.println("Students Personal Details");
        System.out.println("============" + "=================");
        studentsList = new ArrayList<Student>();

        String strChoice;


        try {
            File mainDbFile = new File("data.csv");
            mainDbFile.mkdirs();
            importFromFile();
        } catch (Exception e) {

        }

        boolean isRun = true;
        while (isRun) {
  
            System.out.println("1. GET ALL STUDENT              ");
            System.out.println("2. TAKE ATTANDANCE OF  ALL STUDENT ATTENDANCE ");
            System.out.println("3. GET ALL STUDENT ATTENDANCE ");
            System.out.println("EXIT 0");

            strChoice = "";
            try {
                InputStreamReader converter = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(converter);

                System.out.println("Enter Choice=>");
                strChoice = in.readLine();
            } catch (IOException exception) {

            }

            switch (strChoice) {
 
                case "1":
                    showStudent();
                    break;
                case "2":
                    makePresentsForAllStudent("data.csv");
                    break;
                case "3":
                    showAttendance("data.csv");
                    break;

                default:
                    isRun = false;
                    break;
            }

        }

    }
}