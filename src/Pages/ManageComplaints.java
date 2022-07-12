import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ManageComplaints{
    SortedProrityQueue queue;

    public ManageComplaints(){
        this.queue = new SortedProrityQueue();
        ArrayList<String[]> array = utils.getData("complaints.csv");
        for (String[] data : array) {
            this.queue.add(Integer.parseInt(data[0]),String.valueOf(data[1]));
        }
    }

    public void addComplaint(String complaint, int priority){

        this.queue.add(priority, complaint);
        this.queue.saveFile();
    }

    
}