import java.util.ArrayList;
public class Token_queue {
    private ArrayList<Token> queue;
    private int front;
    private int rear;

    class Token{
        int id;
        String name;
        public Token(int id, String name){
            this.id = id;
            this.name = name;
        }   
    }

    public Token_queue() {
        queue = new ArrayList<>();
        front = 0;
        rear = -1;
        getobs();
    }

    private void getobs(){
        System.out.println(queue.size());
        ArrayList<String[]> data = utils.getData("token.csv");
        for (String[] _d : data) {
            Token token = new Token(Integer.parseInt(_d[0]), _d[1]);
            this.queue.add(token);
            rear++;
        }
    }

    private void writeobs(){
        ArrayList<String[]> dataset = new ArrayList<>();
        System.out.println(queue.size());
        for (Token token : queue) {
            String[] _d = {String.valueOf(token.id), token.name};
            dataset.add(_d);
        }
        utils.CodeWriter("token.csv", dataset);

    }

    public void enqueue(int id, String name) {
        Token token = new Token(id,name);
        queue.add(token);
        writeobs();
        rear++;
    }

    public boolean dequeue() {
        if( rear==-1){
            System.out.println("Queue is empty");
        }
        else {
            queue.remove(front);
            rear--;
            writeobs();
            return true;
        }
        return false;
    }

    public int size() {
        return rear - front + 1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }
}
