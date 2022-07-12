import java.io.FileWriter;
import java.io.IOException;

public class SortedProrityQueue {
        class Node{
            int priority;
            String data;
            Node next;
            Node(int priority,String data2){
                this.data = data2;
                this.priority = priority;
                this.next = null;
            }
         }

        Node head = null;
        Node tail = null;
        int size = 0;

        //add
        void add(int priority,String data){

            Node newNode = new Node(priority,data);
            if(head == null){
               head = tail = newNode;
               size++;
            }

            else if(newNode.priority<head.priority){
                newNode.next = head;
                head = newNode;
                size++;
            }

            else{
                Node currentNode;
                Node temp = head;
                
                do{
                    currentNode = temp;
                    temp = temp.next;
                }
                while(temp!=null && temp.priority<newNode.priority && currentNode.next!=null);
                
                currentNode.next = newNode;
                newNode.next = temp;
                size++;
            }
        }
       
        //return the length
        int len(){

            return size;
        }

       //check if empty or not
       boolean is_empty(){
        if(size == 0){
            return true;
        }
        return false;
    }
        void saveFile()
        {
            Node current = head;
            try{
                FileWriter fw = new FileWriter("complaints.csv");
                fw.write("");
                fw.close();
            }
            catch(IOException ioe){
                System.err.println("IOException: " + ioe.getMessage());
            }
    
            while(current!=null){
                try{
                    FileWriter fw = new FileWriter("complaints.csv", true);
                    if(current == head){
                        fw.write(current.priority+","+current.data+"\n");
                        System.out.print("{"+"("+current.priority+","+current.data+")"+"}");
                    }
                    else{
                        fw.write(current.priority+","+current.data+"\n");
                    }
                    fw.close();
                }
                catch(IOException ioe){
                    System.err.println("IOException: " + ioe.getMessage());
                }
                current = current.next;
            }
        }
}