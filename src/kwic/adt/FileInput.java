package kwic.adt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInput implements Input {
    private String fileName;
    
    public FileInput(String fileName) {
        setInput(fileName);
    }

    @Override
    public void setInput(String input) {
        this.fileName = input;
    }

    @Override
    public void readAndStoreInput(Characters chars) {
        ArrayList<String> result = new ArrayList<String>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                result.add(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.format("file:%s not found",fileName);
            System.exit(1);
        } catch (IOException e) {
            System.out.format("file:%s not readable",fileName);
            System.exit(1);
        }   
        
        chars.setChar(result);
    }

}
