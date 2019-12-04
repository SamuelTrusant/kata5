package kata5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    
    public static List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            IteratorReader iteratorreader = new IteratorReader(reader);
        
            for (String line : iteratorreader) {
                list.add(line);
            }    
        }
        catch (FileNotFoundException exception) {
            System.out.println("ERROR MailListReader::read (File Not Found)" + exception);
        }
        catch (IOException exception){
            System.out.println("ERROR MailListReader::read (IO Exception)" + exception);
        }
     
        return list;
    }
}
