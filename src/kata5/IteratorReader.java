package kata5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class IteratorReader implements Iterable<String>{
    private final BufferedReader reader;
    
    public IteratorReader(BufferedReader reader) {
        this.reader = reader;
    }
    
    
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            String current = readLine();
            
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String result = current;
                current = readLine();
                return result;
            }
            
            private String readLine() {
                try{
                    return reader.readLine();
                }
                catch(IOException exception){
                    return null;
                }
            }
        };
    }
}
