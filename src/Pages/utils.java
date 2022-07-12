import java.io.*;
import java.util.ArrayList;

public class utils {
    public static ArrayList<String[]> getData(String filename){
        File file = new File(filename);
        ArrayList<String[]> arraylist = new ArrayList<>();
        BufferedReader bis = null;
        FileReader fis= null;
        String line;
        try {
            fis = new FileReader(file);
            bis = new BufferedReader(fis);
            while( (line = bis.readLine()) != null ){
                String[] data = line.split(",");
                arraylist.add(data); 
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("The specified file not found" + fnfe);
        } catch(IOException ioe) {
            System.out.println("I/O Exception: " + ioe);
        } finally {
            try{
                if(bis != null) {
                    fis.close();
                    bis.close();
                }
            }catch(IOException ioe) {
                System.out.println("Error in InputStream close(): " + ioe);
            }
        }
        return arraylist;
    }

    public static void CodeWriter(String filename, ArrayList<String[]> dataset) {
        try{
            FileWriter fw = new FileWriter(filename);
            fw.write("");
            fw.close();
        }
        catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
        for (String[] data : dataset) {
            String _d = "";
            for(int i=0; i<data.length; i++){
                _d+=data[i];
                if(i != data.length-1){
                    _d+=",";
                }
            }
            _d+="\n";
            try{
                FileWriter fw = new FileWriter(filename,true);
                fw.write(_d);
                fw.close();
            }
            catch(IOException ioe){
                System.err.println("IOException: " + ioe.getMessage());
            }   
        }
    }
}
